def count_words_and_lines(file_path):
    try:
        with open(file_path, "r", encoding="utf-8") as text_file:
            lines = text_file.readlines()
    except FileNotFoundError:
        print("The file does not exist:", file_path)
        return None

    line_count = len(lines)
    word_count = 0

    for line in lines:
        words = line.split()
        word_count += len(words)

    return line_count, word_count


def run_word_counter():
    print("Word Counter")
    file_path = input("Enter the path to a text file: ").strip()

    if file_path == "":
        print("No file path was entered.")
        return

    result = count_words_and_lines(file_path)
    if result is None:
        return

    line_count, word_count = result
    print("Line count:", line_count)
    print("Word count:", word_count)


if __name__ == "__main__":
    run_word_counter()
