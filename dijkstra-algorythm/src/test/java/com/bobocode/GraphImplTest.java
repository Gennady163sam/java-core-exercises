package com.bobocode;

import com.bobocode.exceptions.IncorrectDistanceException;
import com.bobocode.exceptions.NodeNotFoundException;
import com.bobocode.interfaces.Graph;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphImplTest {
    private Graph graph = new GraphImpl();

    @Test
    public void testCalculateShortestDistanceBetweenNodes() {
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
    }

    @Test
    public void testCalculateShortestPathBetweenNodes() {
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

        assertEquals(graph.calculateShortestPath("nodeA", "nodeF"), Set.of("nodeA", "nodeD", "nodeF"));
    }

    @Test
    public void testCalculateShortestDistanceInEmptyGraph() {
        graph.addNode("nodeA");
        graph.addNode("nodeB");
        graph.addNode("nodeC");
        graph.addNode("nodeD");
        graph.addNode("nodeE");
        graph.addNode("nodeF");

        assertEquals(graph.calculateShortestDistance("nodeA", "nodeF"), Integer.MAX_VALUE);
        assertEquals(graph.calculateShortestDistance("nodeA", "nodeE"), Integer.MAX_VALUE);

        assertNull(graph.calculateShortestPath("nodeA", "nodeF"));
    }

    @Test
    public void testCalculateShortestDistanceInGraphWithoutNodes() {
        try {
            graph.calculateShortestDistance("nodeA", "nodeF");
            fail("Should throw exception");
        } catch (Exception e) {
            assertTrue(e instanceof NodeNotFoundException);
            assertEquals(String.format("Cannot find Node with name=%s", "nodeA"), e.getMessage());
        }
    }

    @Test
    public void testCalculateShortestPathInGraphWithoutNodes() {
        try {
            graph.calculateShortestPath("nodeA", "nodeF");
            fail("Should throw exception");
        } catch (Exception e) {
            assertTrue(e instanceof NodeNotFoundException);
            assertEquals(String.format("Cannot find Node with name=%s", "nodeA"), e.getMessage());
        }
    }

    @Test
    public void testNotConnectedNodeIntoGraph() {
        graph.addNode("nodeA");
        graph.addNode("nodeB");
        graph.addNode("nodeC");
        graph.addNode("nodeD");

        graph.addDestination("nodeA", "nodeB", 3);
        graph.addDestination("nodeA", "nodeC", 10);

        graph.addDestination("nodeB", "nodeC", 6);
        graph.addDestination("nodeC", "nodeB", 6);

        assertEquals(graph.calculateShortestDistance("nodeA", "nodeC"), 9);
        assertEquals(graph.calculateShortestDistance("nodeA", "nodeD"), Integer.MAX_VALUE);

        assertEquals(graph.calculateShortestPath("nodeA", "nodeC"), Set.of("nodeA", "nodeB", "nodeC"));
    }

    @Test
    public void testAddDistanceWithoutNode() {

        try {
            graph.addDestination("nodeA", "nodeB", -1);
            fail("Should throw exception");
        } catch (Exception e) {
            assertTrue(e instanceof NodeNotFoundException);
            assertEquals(String.format("Cannot find Node with name=%s", "nodeA"), e.getMessage());
        }
    }

    @Test
    public void testIncorrectDistanceIntoGraph() {
        graph.addNode("nodeA");
        graph.addNode("nodeB");

        try {
            graph.addDestination("nodeA", "nodeB", -1);
            fail("Should throw exception");
        } catch (Exception e) {
            assertTrue(e instanceof IncorrectDistanceException);
        }
    }
}