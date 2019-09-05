package com.bobocode;

import com.bobocode.interfaces.Graph;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphImplTest {
    private Graph graph = new GraphImpl();

    @Test
    public void testAddNodesIntoEmptyGraph() {
        graph.addNode("nodeA");
        graph.addNode("nodeB");
        graph.addNode("nodeC");
        graph.addNode("nodeD");
        graph.addNode("nodeE");
        graph.addNode("nodeF");

        graph.addDestination("nodeA", "nodeB", 2);
        graph.addDestination("nodeA", "nodeC", 4);
        graph.addDestination("nodeA", "nodeD", 5);

        graph.addDestination("nodeB", "nodeE", 7);
        graph.addDestination("nodeB", "nodeC", 1);

        graph.addDestination("nodeC", "nodeD", 3);
        graph.addDestination("nodeC", "nodeF", 4);

        graph.addDestination("nodeD", "nodeF", 2);
        graph.addDestination("nodeE", "nodeF", 8);

        assertEquals(graph.calculateShortestDistance("nodeA", "nodeF"), 7);
        assertEquals(graph.calculateShortestDistance("nodeA", "nodeE"), 9);

        assertEquals(graph.calculateShortestPath("nodeA", "nodeF"), Set.of("nodeA", "nodeD", "NodeF"));
    }

}