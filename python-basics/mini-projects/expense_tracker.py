"""A console expense tracker with categories, totals, and top categories.

The interesting part: a dict does the aggregation, but underneath that is
exactly the hash map from python-basics/data-structures/hash_map.py -
keys go through a hash, land in a bucket, and accumulate.
"""


class ExpenseTracker:
    def __init__(self):
        self._expenses = []  # (category, amount) pairs

    def add_expense(self, category, amount):
        if amount <= 0:
            raise ValueError("amount must be positive")
        self._expenses.append((category, amount))

    def total(self):
        return sum(amount for _, amount in self._expenses)

    def by_category(self):
        totals = {}
        for category, amount in self._expenses:
            totals[category] = totals.get(category, 0) + amount
        return totals

    def top_categories(self, limit=None):
        ranked = sorted(self.by_category().items(),
                        key=lambda item: item[1], reverse=True)
        return ranked if limit is None else ranked[:limit]


def main():
    tracker = ExpenseTracker()
    print("Expense Tracker - add <category> <amount>, 'report', or 'quit'")

    while True:
        line = input("\n> ").strip()
        if line.lower() in ("quit", "q"):
            break
        parts = line.split()
        if len(parts) != 2:
            print("Use: add <category> <amount>, or 'report'")
            continue
        if parts[0].lower() == "report":
            if tracker.total() == 0:
                print("No expenses yet.")
                continue
            print(f"Total: R{tracker.total():.2f}")
            for category, amount in tracker.top_categories():
                print(f"  {category}: R{amount:.2f}")
            continue
        try:
            category = parts[0]
            amount = float(parts[1])
            tracker.add_expense(category, amount)
            print(f"Added R{amount:.2f} to {category}.")
        except ValueError as error:
            print(error)


if __name__ == "__main__":
    main()
