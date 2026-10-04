"""pytest tests for the Python mini projects."""

import os
import tempfile

import pytest

from expense_tracker import ExpenseTracker
from hangman import render
from word_frequency import count_words, top_words


class TestExpenseTracker:
    def test_totals_and_categories(self):
        tracker = ExpenseTracker()
        tracker.add_expense("food", 250)
        tracker.add_expense("transport", 120)
        tracker.add_expense("food", 80)
        assert tracker.total() == 450
        assert tracker.by_category() == {"food": 330, "transport": 120}
        assert tracker.top_categories(1) == [("food", 330)]

    def test_non_positive_amount_rejected(self):
        tracker = ExpenseTracker()
        with pytest.raises(ValueError):
            tracker.add_expense("food", 0)


class TestHangman:
    def test_render_hides_unguessed_letters(self):
        assert render("stack", {"s", "a"}) == "s _ a _ _"


class TestWordFrequency:
    def test_counts_and_ranks(self):
        fd, path = tempfile.mkstemp(suffix=".txt")
        with os.fdopen(fd, "w") as file:
            file.write("The quick brown fox jumps over the lazy dog. The dog is fast.")
        try:
            counts = count_words(path)
            assert counts is not None
            assert top_words(counts, 3)[0] == ("dog", 2)
            assert "the" not in counts   # stopword filtered
        finally:
            os.remove(path)

    def test_missing_file_returns_none(self):
        assert count_words("does-not-exist.txt") is None
