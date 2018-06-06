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
		double currentSolution;
		double globalSolution = p.calc(solution);

		for (int i = 0; i < iters; i++) {
			System.out.println(i+"-"+globalSolution);
			solution = p.randomDoubleSolution();
			
			currentSolution = p.calc(solution);
			
			if(p.evluateSolution(currentSolution, globalSolution))
				globalSolution = currentSolution;
		}
		
		return globalSolution;
	}
}
