#!/usr/bin/env bash

set -e

# Set JAVA_HOME agar mvn bisa berjalan di bash (Git Bash / WSL)
export JAVA_HOME="/c/Program Files/Java/jdk-24"
export PATH="$JAVA_HOME/bin:$PATH"

REPO_DIR="$(cd "$(dirname "$0")" && pwd)"
TEMP_DIR="$(dirname "$REPO_DIR")/report-temp"
CURRENT_BRANCH=$(git -C "$REPO_DIR" rev-parse --abbrev-ref HEAD)

echo "============================================="
echo "  Publish Surefire Report ke GitHub Pages"
echo "============================================="

# [1/5] Generate report
echo ""
echo "[1/5] Generating test report..."
cd "$REPO_DIR"
mvn surefire-report:report -B

# [2/5] Copy ke folder temp di luar project
echo ""
echo "[2/5] Copying report to temp folder..."
rm -rf "$TEMP_DIR"
cp -r "$REPO_DIR/target/reports" "$TEMP_DIR"

# [3/5] Pindah ke branch gh-pages (buat jika belum ada)
echo ""
echo "[3/5] Switching to gh-pages branch..."
if git show-ref --verify --quiet refs/heads/gh-pages; then
    git checkout gh-pages
else
    echo "  Branch gh-pages belum ada, membuat baru..."
    git checkout --orphan gh-pages
    git rm -rf . > /dev/null 2>&1
    git commit --allow-empty -m "init: gh-pages branch"
    git push origin gh-pages
    git checkout gh-pages
fi

# [4/5] Hapus file lama (kecuali .git), copy yang baru, push
echo ""
echo "[4/5] Updating files and pushing..."
cd "$REPO_DIR"
find . -maxdepth 1 ! -name '.git' ! -name '.' -exec rm -rf {} +
cp -r "$TEMP_DIR"/. .
git add .
git commit -m "chore: update test report $(date '+%Y-%m-%d %H:%M:%S')"
git push origin gh-pages

# [5/5] Kembali ke branch semula
echo ""
echo "[5/5] Switching back to $CURRENT_BRANCH..."
git checkout "$CURRENT_BRANCH"

# Bersihkan temp
rm -rf "$TEMP_DIR"

echo ""
echo "============================================="
echo "  Done! Report published to gh-pages."
echo "============================================="
