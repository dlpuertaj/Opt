package algorithms.stochastic;

import java.util.Random;

import problems.Problem;
import problems.Rastrigin;
import util.Individual;

public class RandomSearch {

	private int iters;
	private Problem p;
	private Individual ind;
	
	public RandomSearch(int iters,Problem p) {
		this.p = p;
		this.iters = iters;	
	}
	
	public double run() {
		double solution = 0;
		double currentSolution;
		for (int i = 0; i < iters; i++) {
			double[] sol = randomSolution();
			ind.setSolution(sol);
			currentSolution = p.calc(ind.getSolution());
			if(currentSolution < solution)
				solution = currentSolution;
		}
		return solution;
	}
	
	public double[] randomSolution() {
		
		return new double[] {0.0};
	}
	
}
