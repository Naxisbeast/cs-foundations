def calculate_average(marks):
    if len(marks) == 0:
        return 0
    return sum(marks) / len(marks)


def count_passes_and_fails(marks):
    pass_count = 0
    fail_count = 0

    for mark in marks:
        if mark >= 50:
            pass_count += 1
        else:
            fail_count += 1

    return pass_count, fail_count


def run_student_marks_analyzer():
    marks = [72, 48, 65, 81, 39, 90]

    print("Student Marks Analyzer")
    print("Marks:", marks)

    average_mark = calculate_average(marks)
    highest_mark = max(marks)
    lowest_mark = min(marks)
    pass_count, fail_count = count_passes_and_fails(marks)

    print("Average mark:", round(average_mark, 2))
    print("Highest mark:", highest_mark)
    print("Lowest mark:", lowest_mark)
    print("Pass count:", pass_count)
    print("Fail count:", fail_count)


if __name__ == "__main__":
    run_student_marks_analyzer()
