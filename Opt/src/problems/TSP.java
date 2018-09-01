package problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

import utils.Tour;
import utils.Util;

/**
 * @author David_Puerta
 *
 */
public class TSP {

	public int[][] cities;
	public Random rand = new Random();
	
	public TSP(int[][] cities) {
		this.cities = cities;
	}
	
	public TSP(String fileName) {
		importCities(fileName);
	}

	private void importCities(String fileName) {
		try {
			Path path = Paths.get(fileName);
				          
		    Stream<String> info = Files.lines(path);
		    Stream<String> lines = Files.lines(path);
					
			int dim = Integer.parseInt(info.limit(5)
										   .filter(line -> line.startsWith("DIMENSION"))
					                       .findFirst()
					                       .get().trim().split(": ")[1]);
			
			info.close();
			
			cities = new int[dim][2];

		    lines.skip(6)	
		    	 .filter(l -> !"EOF".equals(l) )
		    	 .forEach(line -> {
//		    		 System.out.println(line);
		    		 String[] l = line.trim().split("\\s+");
//		    		 cities[Integer.parseInt(l[0])-1][0] = Integer.parseInt(l[0]);
		    		 cities[Integer.parseInt(l[0])-1][0] = Integer.parseInt(l[1]);
		    		 cities[Integer.parseInt(l[0])-1][1] = Integer.parseInt(l[2]);	    		 
		    });
		    
		    lines.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Tour generateRandomTour() {
		int[] initPermutation = new int[cities.length];
		for(int i = 0 ; i < cities.length ; i++) {
			initPermutation[i] = cities[i][0];
		}
		Tour tour = new Tour();
		tour.setTour(Util.randomPermutation(initPermutation));
 		tour.setDistance(Util.tourDistance(tour.getTour(), cities));
		return tour;
	}
	
	public int[][] getCities() {
		return cities;
	}

	public void setCities(int[][] cities) {
		this.cities = cities;
	}  
}
