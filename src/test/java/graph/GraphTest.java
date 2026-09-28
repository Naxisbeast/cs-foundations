package graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph diamondGraph() {
        // 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        return graph;
    }

    @Test
    void bfsVisitsLevelByLevel() {
        assertEquals(List.of(0, 1, 2, 3), diamondGraph().bfs(0));
    }

    @Test
    void dfsGoesDeepBeforeBacktracking() {
        assertEquals(List.of(0, 1, 3, 2), diamondGraph().dfs(0));
    }

    @Test
    void traversalsVisitEveryReachableNodeOnce() {
        List<Integer> bfs = diamondGraph().bfs(0);
        List<Integer> dfs = diamondGraph().dfs(0);
        assertEquals(4, bfs.size());
        assertEquals(4, dfs.size());
        assertTrue(bfs.containsAll(List.of(0, 1, 2, 3)));
        assertTrue(dfs.containsAll(List.of(0, 1, 2, 3)));
    }

    @Test
    void singleNodeGraph() {
        Graph graph = new Graph();
        graph.addEdge(5, 5);   // a self-loop keeps the node in the graph
        assertEquals(List.of(5), graph.bfs(5));
        assertEquals(List.of(5), graph.dfs(5));
    }

    @Test
    void startNodeNotInGraphReturnsEmptyTraversal() {
        Graph graph = diamondGraph();
        assertTrue(graph.bfs(99).isEmpty());
        assertTrue(graph.dfs(99).isEmpty());
    }

    @Test
    void disconnectedNodeIsReachedFromItself() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(9, 10);   // separate component
        assertEquals(List.of(9, 10), graph.bfs(9));
        assertEquals(List.of(0, 1), graph.dfs(0));
    }

    @Test
    void neighborsOfUnknownNodeIsEmpty() {
        assertTrue(diamondGraph().neighbors(99).isEmpty());
    }
}
