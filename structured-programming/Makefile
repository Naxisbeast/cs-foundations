# One-command build for the C++ examples.
#
#   make            build every standalone demo
#   make test       compile and run the mini test suite
#   make clean      remove built artifacts

CXX      = g++
CXXFLAGS = -std=c++17 -Wall -Wextra

DEMOS = \
    input-output/student_profile \
    conditionals/number_classifier \
    loops/multiplication_table \
    functions/calculator_functions \
    arrays/marks_analyzer \
    structs/student_record_system \
    mini-projects/library_menu_system \
    mini-projects/inventory_system \
    mini-projects/guessing_game \
    data-structures/stack \
    data-structures/queue

TEST = tests/stack_queue_test

all: $(DEMOS)

test: $(TEST)
	./$(TEST)

$(DEMOS): %: %.cpp
	$(CXX) $(CXXFLAGS) $< -o $@

$(TEST): tests/stack_queue_test.cpp
	$(CXX) $(CXXFLAGS) $< -o $@

clean:
	rm -f $(DEMOS) $(TEST)
