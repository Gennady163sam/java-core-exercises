package com.bobocode.interfaces;

import java.util.Set;

public interface Graph {
    void addNode(String nodeName);
    void addDestination(String nodeFromName, String nodeToName, int distance);
    int calculateShortestDistance(String nodeStart, String nodeEnd);
    Set<String> calculateShortestPath(String nodeStart, String nodeEnd);
}
