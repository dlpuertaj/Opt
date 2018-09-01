package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Util {
	public static void main(String[] args) {
		int[] arr = {1,5,8,9,4,6,2,7,3};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(stochastic2opt(arr)));
	}
	
	private static Random rand = new Random();
	
	//http://www.saipanyam.net/2011/06/stochastic-algorithms-2.html
	public static int[] stochastic2opt(int[] tour) {
		
		
		int[] result = tour.clone();
		int size = result.length;
		int p1 = rand.nextInt(size);
		int p2 = rand.nextInt(size);
		Set<Integer> exclude = new HashSet<>();
		exclude.add(p1);
		
		if(p1 == 0)
			exclude.add(size - 1);
		else
			exclude.add(p1 - 1);
		
		if  (p1 == size - 1)
			exclude.add(0);
		else
			exclude.add(p1 + 1);
		
		while(exclude.contains(p2)) {
			p2 = rand.nextInt(size);
		}
		
		if(p2 < p1) {
			int temp = p1;
			p1 = p2;
			p2 = temp;
		}
		
		int[] range = Arrays.copyOfRange(result, p1, (p2+1));
		
		//http://www.java67.com/2016/10/3-ways-to-reverse-array-in-java-coding-interview-question.html
		for(int i=0; i<range.length/2; i++){
		    int temp = range[i];
		    range[i] = range[range.length -i -1];
		    range[range.length -i -1] = temp;
		}
		
		int index = 0;
		for(int i=p1; i < p2+1; i++){
			result[i] = range[index];
			index++;
		}
	
		return result;
	}
	
	//https://github.com/jackspyder/2-opt/blob/master/src/sample/TwoOpt.java
	public static int[] twoOpt(int[] tour, int[][] cities) {		
        int[] newTour = null;
        double bestDist = tourDistance(tour, cities);
        double newDist;
        int swaps = 1;
        int improve = 0;
        int iterations = 0;
        long comparisons = 0;

        while (swaps != 0) { //loop until no improvements are made.
            swaps = 0;

            //Initialize inner/outer loops avoiding adjacent calculations and making use of problem symmetry to half total comparisons.
            for (int i = 1; i < tour.length - 2; i++) {
                for (int j = i + 1; j < tour.length - 1; j++) {
                    comparisons++;
                    //check distance of line A,B + line C,D against A,C + B,D if there is improvement, call swap method.
                    
                    double AB = euclideanDistance2d(cities[tour[i]], cities[tour[i+1]]);
                    double CD = euclideanDistance2d(cities[tour[j+1]], cities[tour[j]]);
                    double AC = euclideanDistance2d(cities[tour[i]], cities[tour[j+1]]);
                    double BD = euclideanDistance2d(cities[tour[i+1]], cities[tour[j]]);
                    if ( ( AB + CD ) >= ( AC + BD ) ) {

                        newTour = swap(tour, i, j); //pass arraylist and 2 points to be swapped.

                        newDist = tourDistance(newTour, cities);

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
	
	public static double tourDistance(int[] tour, int[][] cities) {
		double distance = 0;
		for(int i = 0 ; i < tour.length - 1 ; i++) {
			distance += euclideanDistance2d(cities[tour[i]], cities[tour[i+1]]);
		}
		distance += euclideanDistance2d(cities[tour[tour.length-1]], cities[tour[0]]);
		return distance;
	}
	
	public static double euclideanDistance2d(int [] p1, int[] p2) {
		return Math.sqrt(Math.pow((p2[0] - p1[0]), 2.0) + Math.pow((p2[1] - p2[1]), 2.0));
	}
	
	public static double euclideanDistance(double p1, double p2) {
		return Math.sqrt(Math.pow((p2 - p1), 2.0));
	}
	
	public static int[] swap(int[] tour, int i , int j) {
		int temp;
		temp = tour[i];
		tour[i] = tour[j];
		tour[j] = temp;
		
		return tour;
	}
	
	public static int[] randomPermutation(int[] tour) {
		int[] permutation = tour.clone();
		int size = permutation.length;
		int r_index;
		int temp;
		for(int i = 0 ; i < size ; i++) {
			r_index = rand.nextInt(size - i) + i;
			temp = permutation[i];
			permutation[i] = permutation[r_index];
			permutation[r_index] = temp;
		}
		return permutation;
	}
	
	public static int randInBound(int min, int max) {
		return rand.nextInt(max - min + 1) + min;
	}
	
	public static double randInBound(double min, double max) {
		double randomValue = min + (max - min) * rand.nextDouble();
		return randomValue;
	}
	
	public static double[] randomSolution(int size, double[] bounds) {
		double[] solution = new double[size];
		for (int i = 0; i < solution.length; i++) {
			solution[i] = randInBound(bounds[0], bounds[1]);
		}
		return solution;
	}
	
	public static int[] randomSolution(int size, int[] bounds) {
		int[] solution = new int[size];
		for (int i = 0; i < solution.length; i++) {
			solution[i] = randInBound(bounds[0], bounds[1]);
		}
		return solution;
	}
}
