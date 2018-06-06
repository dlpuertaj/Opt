package algorithms.stochastic;

import problems.Problem;

public class RandomSearch {

	private int iters;
	private Problem p;
	
	public RandomSearch(int iters,Problem p) {
		this.p = p;
		this.iters = iters;	
	}
	
	public double search() {
		double[] solution = p.randomDoubleSolution();
		double currentBest;
		double globalBest = p.calc(solution);

		for (int i = 0; i < iters; i++) {
			System.out.println(i+"-"+globalBest);
			solution = p.randomDoubleSolution();
			
			currentBest = p.calc(solution);
			
			if(p.evluateSolution(currentBest, globalBest))
				globalBest = currentBest;
		}
		
		return globalBest;
	}
}
