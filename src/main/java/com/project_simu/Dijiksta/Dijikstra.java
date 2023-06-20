package com.project_simu.Dijiksta;

import java.util.LinkedList;

public interface Dijikstra {
    public void AdjacencyMatrix();
    public int findMinimumDistance(double[] distances, boolean[] visited);
    public LinkedList<Integer> dijkstra(int source, int destination, double maxValue);
    public  double calculateDistance(double lat1, double lon1, double lat2, double lon2);
}
