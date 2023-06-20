package com.project_simu.Dijiksta;

import com.project_simu.entity.Aeroport;
import com.project_simu.repository.AeroportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class DijikstraImp implements Dijikstra{
    @Autowired
    AeroportRepository AeroportRepository;
    private double[][] adjacencyMatrix;
    private  final double EARTH_RADIUS_KM = 6371.0;
    private Integer NUM_AIRPORTS;

    @Override
    public void AdjacencyMatrix() {
        List<Aeroport> Aeroport =AeroportRepository.findAll();
        NUM_AIRPORTS=(int) AeroportRepository.count();
        adjacencyMatrix=new double[Aeroport.size()][Aeroport.size()];
        for (int i=0;i<Aeroport.size();i++){
            for (int j=0;j<Aeroport.size();j++){
                if(i==j)
                adjacencyMatrix[i][j]=-1;
                else
                    adjacencyMatrix[i][j]=calculateDistance(Aeroport.get(j).getLocalisation().getY(),Aeroport.get(j).getLocalisation().getX(), Aeroport.get(i).getLocalisation().getY(), Aeroport.get(i).getLocalisation().getX());

            }
        }
    }

    @Override
    public int findMinimumDistance(double[] distances, boolean[] visited) {
        double minDistance = Double.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < NUM_AIRPORTS; i++) {
            if (!visited[i] && distances[i] <= minDistance) {
                minDistance = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    @Override
    public  LinkedList<Integer> dijkstra(int source, int destination,double maxValue) {
        double[] distances = new double[NUM_AIRPORTS];
        boolean[] visited = new boolean[NUM_AIRPORTS];
        int[] previous = new int[NUM_AIRPORTS];
        double[][] adjacent = adjacencyMatrix;
        for (int k = 0; k < adjacent.length; k++) {
            for (int j = 0; j < adjacent.length; j++) {
                if (adjacent[k][j] > maxValue)
                    adjacent[k][j] = -1;
            }
        }
//        for (int k = 0; k < adjacent.length; k++) {
//            for (int j = 0; j < adjacent.length; j++)
//                System.out.print(adjacent[k][j]+"/");
//            System.out.println();
//            }
        Arrays.fill(distances, Double.MAX_VALUE);
        Arrays.fill(visited, false);
        Arrays.fill(previous, -1);

        distances[source] = 0;


        for (int i = 0; i < NUM_AIRPORTS - 1; i++) {
            int currentAirport = findMinimumDistance(distances, visited);
            visited[currentAirport] = true;

            for (int j = 0; j < NUM_AIRPORTS; j++) {
                if (!visited[j] && adjacent[currentAirport][j] != -1) {
                    double newDistance = distances[currentAirport] + adjacent[currentAirport][j];
                    if (newDistance < distances[j]) {
                        distances[j] = newDistance;
                        previous[j] = currentAirport;
                    }
                }
            }
        }

        LinkedList<Integer> path = null;
        if (distances[destination] == Double.MAX_VALUE) {
            System.out.println("Il n'y a pas de chemin possible entre l'aéroport de départ et l'aéroport d'arrivée.");
        } else {
            path = new LinkedList<>();
            int airport = destination;
            while (airport != -1) {
                path.addFirst(airport);
                airport = previous[airport];
            }

            System.out.print("Le plus court chemin est : ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i != path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
            System.out.println("La distance totale est : " + distances[destination] + " km");
        }
        return path;
    }

    @Override
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS_KM * c;
        return distance;

    }

    public double[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(double[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public int getNUM_AIRPORTS() {
        return NUM_AIRPORTS;
    }

    public void setNUM_AIRPORTS(int NUM_AIRPORTS) {
        this.NUM_AIRPORTS = NUM_AIRPORTS;
    }


    public void afficher(){
        for(int i=0;i<adjacencyMatrix.length;i++){
            for(int j=0;j<adjacencyMatrix.length;j++){
                System.out.print(adjacencyMatrix[i][j]+"/");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------");
    }

}
