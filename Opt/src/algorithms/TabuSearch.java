package algorithms;

import problems.TSP;

public class TabuSearch {
	
	public int tabuSize;
	public int popSize;
	public int iters;
	public TSP tsp;
	
	public double search() {
		
		int[] current = randomPermutation(tsp.getCities());
		return 0;
	}

	private int[] randomPermutation(int[][] cities) {
		
		return null;
	}
	
	private int[] generateCandidate() {
		return null;
	}
}
