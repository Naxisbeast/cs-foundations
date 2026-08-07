def classify_grade(mark):
    if mark >= 75:
        return "Distinction"
    if mark >= 50:
        return "Pass"
    return "Fail"


def read_mark():
    mark_text = input("Enter a mark between 0 and 100: ").strip()

    try:
        mark = float(mark_text)
    except ValueError:
        print("Invalid input. Please enter a number.")
        return None

    if mark < 0 or mark > 100:
        print("Invalid mark. The mark must be between 0 and 100.")
        return None

    return mark


def run_grade_checker():
    print("Grade Checker")
    mark = read_mark()

    if mark is None:
        return

    grade = classify_grade(mark)
    print("Grade result:", grade)


if __name__ == "__main__":
    run_grade_checker()
