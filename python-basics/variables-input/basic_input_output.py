def run_basic_input_output_example():
    print("Basic Input And Output Example")

    name = input("Enter a fictional student name: ").strip()
    course_name = input("Enter a course name: ").strip()

    age_text = input("Enter an age: ").strip()
    if not age_text.isdigit():
        print("Age must be a whole number. I will use 18 for this example.")
        age = 18
    else:
        age = int(age_text)

    print()
    print("Student Summary")
    print("Name:", name if name else "Unknown")
    print("Course:", course_name if course_name else "Not provided")
    print("Age next year:", age + 1)


if __name__ == "__main__":
    run_basic_input_output_example()
