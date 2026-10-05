#ifndef MINI_TEST_HPP
#define MINI_TEST_HPP

// A tiny, dependency-free assertion framework for the C++ examples.
// It exists so the C++ code has real tests (assertions that fail when
// something breaks), not just demo output. A real project would use
// Catch2 or GoogleTest; this keeps the repo self-contained.

#include <iostream>

static int mini_passed = 0;
static int mini_failed = 0;

#define CHECK(condition)                                                        \
    do {                                                                        \
        if (condition) {                                                        \
            mini_passed++;                                                      \
        } else {                                                                \
            mini_failed++;                                                      \
            std::cout << "FAIL: " << __FILE__ << ":" << __LINE__                \
                      << "  " << #condition << std::endl;                       \
        }                                                                       \
    } while (0)

inline int miniTestSummary() {
    std::cout << mini_passed << " passed, " << mini_failed << " failed"
              << std::endl;
    return mini_failed == 0 ? 0 : 1;
}

#endif
