#!/usr/bin/env bash
# Verifies the whole cs-foundations tree from a clean clone:
#   1. Java core (data-structures, oop-principles, demo runner) compiles
#   2. JUnit tests compile and pass
#   3. every academic-assignment folder compiles standalone
#   4. every Python file passes a syntax check
#   5. every C++ file compiles with warnings on, if a compiler is present
#
# Usage:  bash scripts/verify.sh
# Run from any directory; the script finds the repo root itself.
set -euo pipefail

cd "$(dirname "$0")/.."

JUNIT_JAR="lib/junit-platform-console-standalone-1.13.4.jar"
JUNIT_URL="https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.13.4/junit-platform-console-standalone-1.13.4.jar"
OUT="build/classes"
PASS=0

# Classpath separator differs on Windows (;) vs Unix (:)
case "$(uname -s)" in
    MINGW*|MSYS*|CYGWIN*) CP_SEP=";" ;;
    *) CP_SEP=":" ;;
esac

# 1. JUnit runner (downloaded once, then cached locally; git-ignored)
mkdir -p lib
if [ ! -f "$JUNIT_JAR" ]; then
    echo "[verify] downloading JUnit console runner..."
    curl -fsSL --max-time 120 "$JUNIT_URL" -o "$JUNIT_JAR"
fi

rm -rf "$OUT"
mkdir -p "$OUT"

# 2. Compile the Java core
echo "[verify] compiling Java core..."
CORE_SOURCES=$(find data-structures oop-principles src/examples -name '*.java')
javac -d "$OUT" $CORE_SOURCES
PASS=$((PASS + 1))

# 3. Compile and run the JUnit tests, if any exist
if [ -d "src/test/java" ] && find src/test/java -name '*.java' | grep -q .; then
    echo "[verify] compiling and running tests..."
    TEST_SOURCES=$(find src/test/java -name '*.java')
    javac -cp "$OUT$CP_SEP$JUNIT_JAR" -d "$OUT" $TEST_SOURCES
    java -jar "$JUNIT_JAR" --class-path "$OUT" --scan-class-path --disable-banner
    PASS=$((PASS + 1))
fi

# 4. Each academic-assignment folder must compile standalone
echo "[verify] compiling academic-assignment folders..."
for dir in academic-assignments/assignment-*/src; do
    if [ -d "$dir" ]; then
        TMPDIR=$(mktemp -d)
        javac -d "$TMPDIR" "$dir"/*.java
        rm -rf "$TMPDIR"
    fi
done
PASS=$((PASS + 1))

# 5. Python syntax check
echo "[verify] checking Python syntax..."
python -m py_compile $(find python-basics -name '*.py')
PASS=$((PASS + 1))

# 6. C++ compile check (optional — needs a compiler; CI covers this)
if command -v g++ >/dev/null 2>&1; then
    echo "[verify] compiling C++ files..."
    for src in $(find structured-programming -name '*.cpp'); do
        g++ -std=c++17 -Wall -Wextra -fsyntax-only "$src"
    done
    PASS=$((PASS + 1))
else
    echo "[verify] g++ not found — skipping C++ check (CI covers this)"
fi

echo "[verify] ALL $PASS CHECKS PASSED"
