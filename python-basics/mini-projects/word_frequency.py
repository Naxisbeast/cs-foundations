"""Word frequency counter - read a file, count words, show the top ones.

The dict counts are the hash-map idea from
python-basics/data-structures/hash_map.py in action, and sorting the
items into a top-N list is the same ranking you'd do anywhere. A small
stopword list keeps the interesting words on top.
"""

import re
from collections import Counter

STOPWORDS = {"the", "and", "a", "an", "of", "to", "in", "is", "it",
             "that", "for", "on", "with", "as", "at", "by", "be"}


def count_words(file_path):
    try:
        with open(file_path, "r", encoding="utf-8") as text_file:
            text = text_file.read()
    except FileNotFoundError:
        return None

    words = re.findall(r"[a-z']+", text.lower())
    return Counter(word for word in words if word not in STOPWORDS)


def top_words(counts, limit=10):
    return counts.most_common(limit)


def main():
    file_path = input("Path to a text file: ").strip()
    counts = count_words(file_path)
    if counts is None:
        print("File not found.")
        return

    print(f"Unique words (after stopwords): {len(counts)}")
    for word, count in top_words(counts):
        print(f"  {word}: {count}")


if __name__ == "__main__":
    main()
