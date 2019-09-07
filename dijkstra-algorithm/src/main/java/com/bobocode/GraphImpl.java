package com.bobocode;

import com.bobocode.interfaces.Graph;

import java.util.Set;

/**
 * {@link GraphImpl} implements Graph {@link Graph}, using nodes as vertices. Nodes are stores in instances of nested
 * class Node. The graph can be initialized from a file, or by calling methods to add a node {@link GraphImpl#addNode(String)}
 * and add an edge {@link GraphImpl#addDestination(String, String, int)}
 *
 */
public class GraphImpl implements Graph {

    /**
     * This method creates a Graph from file
     *
     * File format e.g.
     * nodeA nodeB nodeC
     * nodeA nodeB 1
     * nodeA nodeC 12
     * @param fileName file contains graph struct
     * @return a new graph contains vertices and edges
     */
    @Override
    public Graph fromFile(String fileName) {
        throw new UnsupportedOperationException("This method is not implemented yet"); // todo: implement this method
    }

    /**
     * Adds a node to the graph, if it doesn't exist
     *
     * @param nodeName name of node to add
     */
    @Override
    public void addNode(String nodeName) {
        throw new UnsupportedOperationException("This method is not implemented yet"); // todo: implement this method
    }

    /**
     * Adds a edge to the graph between nodes
     *
     * @param nodeFromName name of first node in edge
     * @param nodeToName name of second node in edge
     * @param distance the weight of edge
     */
    @Override
    public void addDestination(String nodeFromName, String nodeToName, int distance) {
        throw new UnsupportedOperationException("This method is not implemented yet"); // todo: implement this method
    }

    /**
     * Calculates shortest distance between two nodes
     *
     * @param nodeStart name of node start path
     * @param nodeEnd name of node finish path
     * @return min distance between two nodes
     */
    @Override
    public int calculateShortestDistance(String nodeStart, String nodeEnd) {
        throw new UnsupportedOperationException("This method is not implemented yet"); // todo: implement this method
    }

    /**
     * Calculates shortest path between two nodes
     *
     * @param nodeStart name of node start path
     * @param nodeEnd name of node finish path
     * @return set of nodes, contains min path between two nodes
     */
    @Override
    public Set<String> calculateShortestPath(String nodeStart, String nodeEnd) {
        throw new UnsupportedOperationException("This method is not implemented yet"); // todo: implement this method
    }
}
