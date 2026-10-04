"""Makes the python-basics packages importable from the pytest suite."""

import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
for folder in ("python-basics/data-structures", "python-basics/mini-projects"):
    sys.path.insert(0, str(ROOT / folder))
