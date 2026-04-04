# publish-report.ps1
# Script untuk generate dan publish surefire report ke GitHub Pages

$ErrorActionPreference = "Stop"

$RepoDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$TempDir = Join-Path (Split-Path -Parent $RepoDir) "report-temp"
$CurrentBranch = git -C $RepoDir rev-parse --abbrev-ref HEAD

Write-Host "=============================================" -ForegroundColor Cyan
Write-Host "  Publish Surefire Report ke GitHub Pages" -ForegroundColor Cyan
Write-Host "=============================================" -ForegroundColor Cyan

# [1/5] Generate report
Write-Host ""
Write-Host "[1/5] Generating test report..." -ForegroundColor Yellow
Set-Location $RepoDir
mvn surefire-report:report -B
if ($LASTEXITCODE -ne 0) {
    Write-Host "[ERROR] Gagal generate report. Proses dihentikan." -ForegroundColor Red
    exit 1
}

# [2/5] Copy ke folder temp
Write-Host ""
Write-Host "[2/5] Copying report to temp folder..." -ForegroundColor Yellow
if (Test-Path $TempDir) {
    Remove-Item -Recurse -Force $TempDir
}
Copy-Item -Recurse "$RepoDir\target\reports" $TempDir
if ($LASTEXITCODE -ne 0) {
    Write-Host "[ERROR] Gagal copy report. Proses dihentikan." -ForegroundColor Red
    exit 1
}

# [3/5] Pindah ke branch gh-pages (buat jika belum ada)
Write-Host ""
Write-Host "[3/5] Switching to gh-pages branch..." -ForegroundColor Yellow
$branchExists = git show-ref --verify --quiet refs/heads/gh-pages
if ($LASTEXITCODE -eq 0) {
    git checkout gh-pages
} else {
    Write-Host "  Branch gh-pages belum ada, membuat baru..." -ForegroundColor Gray
    git checkout --orphan gh-pages
    git rm -rf . | Out-Null
    git commit --allow-empty -m "init: gh-pages branch"
    git push origin gh-pages
    git checkout gh-pages
}

# [4/5] Hapus file lama, copy yang baru, push
Write-Host ""
Write-Host "[4/5] Updating files and pushing..." -ForegroundColor Yellow
Set-Location $RepoDir
Get-ChildItem -Force | Where-Object { $_.Name -ne ".git" } | Remove-Item -Recurse -Force
Copy-Item -Recurse "$TempDir\*" .
$timestamp = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
git add .
git commit -m "chore: update test report $timestamp"
git push origin gh-pages
if ($LASTEXITCODE -ne 0) {
    Write-Host "[ERROR] Gagal push ke gh-pages. Kembali ke branch semula..." -ForegroundColor Red
    git checkout $CurrentBranch
    exit 1
}

# [5/5] Kembali ke branch semula
Write-Host ""
Write-Host "[5/5] Switching back to $CurrentBranch..." -ForegroundColor Yellow
git checkout $CurrentBranch

# Bersihkan temp
Remove-Item -Recurse -Force $TempDir

Write-Host ""
Write-Host "=============================================" -ForegroundColor Green
Write-Host "  Done! Report published to gh-pages." -ForegroundColor Green
Write-Host "=============================================" -ForegroundColor Green
