package graph;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void shortestDistancesOnASmallNetwork() {
        Graph graph = new Graph();
        graph.addWeightedEdge(0, 1, 4);
        graph.addWeightedEdge(0, 2, 1);
        graph.addWeightedEdge(2, 1, 2);
        graph.addWeightedEdge(1, 3, 1);
        graph.addWeightedEdge(2, 3, 5);

        Map<Integer, Integer> distances = graph.dijkstra(0);
        assertEquals(0, distances.get(0));
        assertEquals(3, distances.get(1));   // 0 -> 2 -> 1 (1 + 2), not the direct 4
        assertEquals(1, distances.get(2));
        assertEquals(4, distances.get(3));   // 0 -> 2 -> 1 -> 3 (1 + 2 + 1), not 0 -> 2 -> 3 (1 + 5)
    }

    @Test
    void unreachableNodeStaysAtMaxValue() {
        Graph graph = new Graph();
        graph.addWeightedEdge(0, 1, 2);
        graph.addWeightedEdge(5, 6, 1);   // separate component

        Map<Integer, Integer> distances = graph.dijkstra(0);
        assertEquals(2, distances.get(1));
        assertEquals(Integer.MAX_VALUE, distances.get(5));
        assertEquals(Integer.MAX_VALUE, distances.get(6));
    }

    @Test
    void sourceNotInGraphReturnsEmptyMap() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        assertTrue(graph.dijkstra(99).isEmpty());
    }

    @Test
    void unweightedEdgesBehaveAsWeightOne() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        Map<Integer, Integer> distances = graph.dijkstra(0);
        assertEquals(0, distances.get(0));
        assertEquals(1, distances.get(1));
        assertEquals(2, distances.get(2));
    }
}
