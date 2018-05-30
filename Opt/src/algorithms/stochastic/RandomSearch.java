package algorithms.stochastic;

import java.util.Random;

import problems.Problem;
import util.Individual;

public class RandomSearch {

	private int iters;
	private Problem p;
	private Individual ind;
	
	public RandomSearch(int iters,Problem p) {
		this.p = p;
		this.iters = iters;	
	}
	
	public double search() {
		double[] sol;
		double solution = p.getInicialValue();
		double currentSolution;
		ind = new Individual();
		for (int i = 0; i < iters; i++) {
			sol = ind.randomSolution();
			
			currentSolution = p.calc(ind.getSolution());
			if(p.evluateSolution(currentSolution, solution))
				solution = currentSolution;
		}
		return solution;
	}
	
	public double[] randomSolution() {
		
		return new double[] {0.0};
	}
	
}
