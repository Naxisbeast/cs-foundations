package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A directed graph stored as an adjacency list (each node maps to the list
 * of nodes it points to). To model an undirected graph, add each edge in
 * both directions.
 *
 * BFS and DFS are the two fundamental traversals:
 *   bfs(start)  — level by level, using a queue. Gives the shortest path in
 *                 an unweighted graph, which is why it powers flood-fill and
 *                 "degrees of separation" problems.
 *   dfs(start)  — goes as deep as possible before backtracking, using the
 *                 call stack. Powers cycle detection and maze solving.
 *
 * Time complexity of both traversals: O(V + E) — every node and edge is
 * visited once. Space: O(V) for the visited set (plus the queue / stack).
 */
public class Graph {

    private final Map<Integer, List<Integer>> adjacency = new HashMap<>();

    /** Add a directed edge from -> to. The to-node is created even if it has no outgoing edges. */
    public void addEdge(int from, int to) {
        adjacency.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        adjacency.computeIfAbsent(to, k -> new ArrayList<>());
    }

    /** The neighbours a node points to (empty list if the node is unknown). */
    public List<Integer> neighbors(int node) {
        return adjacency.getOrDefault(node, Collections.emptyList());
    }

    /** Breadth-first search from a start node, in visit order. */
    public List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        if (!adjacency.containsKey(start)) {
            return order;
        }

        Set<Integer> visited = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int next : adjacency.get(node)) {
                if (visited.add(next)) {
                    queue.add(next);
                }
            }
        }
        return order;
    }

    /** Depth-first search from a start node, in visit order. */
    public List<Integer> dfs(int start) {
        List<Integer> order = new ArrayList<>();
        dfs(start, new HashSet<>(), order);
        return order;
    }

    private void dfs(int node, Set<Integer> visited, List<Integer> order) {
        if (!adjacency.containsKey(node) || !visited.add(node)) {
            return;
        }
        order.add(node);
        for (int next : adjacency.get(node)) {
            dfs(next, visited, order);
        }
    }
}
