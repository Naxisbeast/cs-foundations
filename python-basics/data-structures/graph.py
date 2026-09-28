"""A directed graph as an adjacency list, with BFS and DFS.

This is the Python mirror of the Java Graph in data-structures/graph/.
Same two traversals: BFS is level-by-level using a deque (queue); DFS
goes deep using recursion (the call stack).

Time: O(V + E) for both traversals. Space: O(V) for the visited set.
"""

from collections import deque


class Graph:
    def __init__(self):
        self._adjacency = {}

    def add_edge(self, from_node, to_node):
        """Add a directed edge. The to-node exists even with no outgoing edges."""
        self._adjacency.setdefault(from_node, []).append(to_node)
        self._adjacency.setdefault(to_node, [])

    def neighbors(self, node):
        return self._adjacency.get(node, [])

    def bfs(self, start):
        """Level-by-level traversal from a start node, in visit order."""
        if start not in self._adjacency:
            return []

        visited = {start}
        queue = deque([start])
        order = []

        while queue:
            node = queue.popleft()
            order.append(node)
            for next_node in self._adjacency.get(node, []):
                if next_node not in visited:
                    visited.add(next_node)
                    queue.append(next_node)
        return order

    def dfs(self, start):
        """Depth-first traversal from a start node, in visit order."""
        order = []
        self._dfs(start, set(), order)
        return order

    def _dfs(self, node, visited, order):
        if node not in self._adjacency or node in visited:
            return
        visited.add(node)
        order.append(node)
        for next_node in self._adjacency.get(node, []):
            self._dfs(next_node, visited, order)


if __name__ == "__main__":
    graph = Graph()
    graph.add_edge(0, 1)
    graph.add_edge(0, 2)
    graph.add_edge(1, 3)
    graph.add_edge(2, 3)
    print("BFS from 0:", graph.bfs(0))
    print("DFS from 0:", graph.dfs(0))
