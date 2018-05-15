package algorithms.stochastic;

import java.util.Random;

import problems.Problem;
import problems.Rastrigin;

public class RandomSearch {

	private int iters;
	private Problem p;
	
	public RandomSearch(int iters,Problem p) {
		this.p = p;
		this.iters = iters;	
	}
	
	public double run() {
		double solution = 0;
		double[] currentSOlution;
		for (int i = 0; i < iters; i++) {
			
			
			solution = p.calc(x);
		}
		return solution;
	}
	
	
	
}
