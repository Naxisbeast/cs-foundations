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
 *
 * With weighted edges, dijkstra(source) finds the shortest distances from
 * a start node. The version here picks the next unvisited node by scanning
 * (O(V^2)); a binary-heap priority queue brings it to O((V + E) log V) —
 * the same min-heap from data-structures/heap/ in action.
 */
public class Graph {

    private final Map<Integer, List<Integer>> adjacency = new HashMap<>();
    private final Map<Integer, Map<Integer, Integer>> weights = new HashMap<>();

    /** Add a directed edge from -> to. The to-node is created even if it has no outgoing edges. */
    public void addEdge(int from, int to) {
        adjacency.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        adjacency.computeIfAbsent(to, k -> new ArrayList<>());
    }

    /** Add a directed weighted edge. Unweighted edges count as weight 1. */
    public void addWeightedEdge(int from, int to, int weight) {
        addEdge(from, to);
        weights.computeIfAbsent(from, k -> new HashMap<>()).put(to, weight);
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

    /**
     * Shortest distances from a source node. Unreachable nodes map to
     * Integer.MAX_VALUE. Empty map if the source is not in the graph.
     */
    public Map<Integer, Integer> dijkstra(int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        if (!adjacency.containsKey(source)) {
            return distances;
        }

        for (int node : adjacency.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        Set<Integer> visited = new HashSet<>();
        while (visited.size() < adjacency.size()) {
            int current = minUnvisited(distances, visited);
            if (current == -1) {
                break;
            }
            visited.add(current);

            long currentDistance = distances.get(current);
            if (currentDistance == Integer.MAX_VALUE) {
                continue;
            }
            for (int next : adjacency.get(current)) {
                long candidate = currentDistance + weight(current, next);
                if (candidate < distances.get(next)) {
                    distances.put(next, (int) candidate);
                }
            }
        }
        return distances;
    }

    private int minUnvisited(Map<Integer, Integer> distances, Set<Integer> visited) {
        int best = -1;
        int bestDistance = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            if (!visited.contains(entry.getKey()) && entry.getValue() < bestDistance) {
                best = entry.getKey();
                bestDistance = entry.getValue();
            }
        }
        return best;
    }

    private int weight(int from, int to) {
        Map<Integer, Integer> fromWeights = weights.getOrDefault(from, Collections.emptyMap());
        return fromWeights.getOrDefault(to, 1);
    }
}
