package problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TSP {

	public int[][] cities;
	
	public TSP(int[][] cities) {
		this.cities = cities;
	}
	
	public TSP(String fileName) {
		this.cities = importCities(fileName);
	}

	private int[][] importCities(String fileName) {
		try {
			Path path = Paths.get(fileName);
				          
		    Stream<String> info = Files.lines(path);
		    Stream<String> lines = Files.lines(path);
					
			int dim = Integer.parseInt(info.limit(5)
										   .filter(line -> line.startsWith("DIMENSION"))
					                       .findFirst()
					                       .get().trim().split(": ")[1]);
			
			info.close();
			
			int[][] cities = new int[dim][3];

		    lines.skip(6)	
		    	 .filter(l -> !"EOF".equals(l) )
		    	 .forEach(line -> {
		    		 System.out.println(line);
		    		 String[] l = line.trim().split("\\s+");
		    		 cities[Integer.parseInt(l[0])-1][0] = Integer.parseInt(l[0]);
		    		 cities[Integer.parseInt(l[0])-1][1] = Integer.parseInt(l[1]);
		    		 cities[Integer.parseInt(l[0])-1][2] = Integer.parseInt(l[2]);	    		 
		    });
		    
		    lines.close();
		    
		    return cities;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public double euclidean2d(int c1, int c2) {
		return Math.round(Math.sqrt(Math.pow((cities[c1][1] - cities[c2][1]), 2.0) + Math.pow((cities[c1][2] - cities[c2][2]), 2.0)));
	}

	public int[][] getCities() {
		return cities;
	}

	public void setCities(int[][] cities) {
		this.cities = cities;
	}
	
	public int[] generateRoute() {
		return null;
	}
	
	public double tourDistance(int[] tour) {
		double distance = 0;
		for(int i = 0 ; i < tour.length - 1 ; i++) {
			distance += euclidean2d(i, i+1);
		}
		
		return distance;
	}

	
	//https://github.com/jackspyder/2-opt/blob/master/src/sample/TwoOpt.java
	public int[] twoOpt(int[] tour) {		
        int[] newTour = null;
        double bestDist = tourDistance(tour);
        double newDist;
        int swaps = 1;
        int improve = 0;
        int iterations = 0;
        long comparisons = 0;

        while (swaps != 0) { //loop until no improvements are made.
            swaps = 0;

            //initialise inner/outer loops avoiding adjacent calculations and making use of problem symmetry to half total comparisons.
            for (int i = 1; i < tour.length - 2; i++) {
                for (int j = i + 1; j < tour.length - 1; j++) {
                    comparisons++;
                    //check distance of line A,B + line C,D against A,C + B,D if there is improvement, call swap method.
                    
                    double AB = euclidean2d(tour[i], tour[i+1]);
                    double CD = euclidean2d(tour[j+1], tour[j]);
                    double AC = euclidean2d(tour[i], tour[j+1]);
                    double BD = euclidean2d(tour[i+1], tour[j]);
                    if ( ( AB + CD ) >= ( AC + BD ) ) {

                        newTour = swap(tour, i, j); //pass arraylist and 2 points to be swapped.

                        newDist = tourDistance(newTour);

                        if (newDist < bestDist) { //if the swap results in an improved distance, increment counters and update distance/tour
                            tour = newTour;
                            bestDist = newDist;
                            swaps++;
                            improve++;
                        }
                    }
                }
            }
            iterations++;
        }
        System.out.println("Total comparisons made: " + comparisons);
        System.out.println("Total improvements made: " + improve);
        System.out.println("Total iterations made: " + iterations);
        
        return newTour;
	
	}
	
	
	public int[] swap(int[] tour, int i , int j) {
		return null;
	}
	
	public static void main(String[] args) {
		TSP tsp = new TSP("TSPLIB//a280.tsp");
		
		tsp.getCities();
	}
	
}
