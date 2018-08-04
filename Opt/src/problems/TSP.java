package problems;

import java.io.IOException;
import java.net.URISyntaxException;
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
				          
		    Stream<String> lines;
			
			lines = Files.lines(path);
					
			int dim = Integer.parseInt(lines.filter(line -> line.startsWith("DIMENSION"))
					          .findFirst()
					          .get().trim().split(": ")[1]);
			lines.close();

			
			int[][] cities = new int[dim][];
			int city = 0;
			
			lines = Files.lines(path);
		    lines.skip(6)
		    	 .forEach(line -> {
		    		 String[] l = line.trim().split(" ");
		    		 cities[city][0] = Integer.parseInt(l[0]);
		    		 cities[city][1] = Integer.parseInt(l[1]);
		    		 cities[city][2] = Integer.parseInt(l[2]); 
		    });
		    
		    lines.close();
		    
		    return cities;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public double euclidean2d(int p1, int p2) {
		return 0;
	}

	public int[][] getCities() {
		return cities;
	}

	public void setCities(int[][] cities) {
		this.cities = cities;
	}
	
	
	public static void main(String[] args) {
		TSP tsp = new TSP("TSPLIB//a280.tsp");
		
		tsp.getCities();
	}
	
}
