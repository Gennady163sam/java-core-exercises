package com.bobocode.interfaces;

import java.util.Set;
/**
 * Graph is a structure amounting to a set of objects in which some pairs of the objects are in some sense "related".
 */
public interface Graph {
    /**
     * Adds new vertices in graph.
     *
     * @param nodeName the name of node to add
     */
    void addNode(String nodeName);

    /**
     * Adds edge between two vertices.
     *
     * @param nodeFromName the name of first node in edge
     * @param nodeToName the name of second node in edge
     * @param distance distance between vertices
     */
    void addDestination(String nodeFromName, String nodeToName, int distance);

    /**
     * Returns shortest distance between two vertices
     *
     * @param nodeStart the name of start node
     * @param nodeEnd the name of finish node
     * @return an integer value that is distance between vertices
     */
    int calculateShortestDistance(String nodeStart, String nodeEnd);

    /**
     * Returns shortest path between two vertices
     *
     * @param nodeStart the name of start node
     * @param nodeEnd the name of finish node
     * @return a set that contains node names for shortest path between vertices
     */
    Set<String> calculateShortestPath(String nodeStart, String nodeEnd);

    /**
     * Returns configured Graph from file
     *
     * File format e.g.
     * nodeA nodeB nodeC
     *
     * nodeA nodeB 1
     * nodeA nodeC 12
     *
     * @param fileName the name of file, which contains graph
     * @return a graph that contains vertices from file
     */
    Graph fromFile(String fileName);
}
