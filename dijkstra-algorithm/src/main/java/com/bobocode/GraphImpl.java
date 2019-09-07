package com.bobocode;

import com.bobocode.interfaces.Graph;

import java.util.Set;

public class GraphImpl implements Graph {

    @Override
    public void addNode(String nodeName) {
        throw new UnsupportedOperationException("This method is not implemented yet"); // todo: implement this method
    }

    @Override
    public void addDestination(String nodeFromName, String nodeToName, int distance) {
        throw new UnsupportedOperationException("This method is not implemented yet"); // todo: implement this method
    }

    @Override
    public int calculateShortestDistance(String nodeStart, String nodeEnd) {
        throw new UnsupportedOperationException("This method is not implemented yet"); // todo: implement this method
    }

    @Override
    public Set<String> calculateShortestPath(String nodeStart, String nodeEnd) {
        throw new UnsupportedOperationException("This method is not implemented yet"); // todo: implement this method
    }
}
