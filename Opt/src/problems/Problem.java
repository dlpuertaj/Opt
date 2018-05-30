package problems;

public abstract class Problem {
	private boolean opt;
	public abstract double calc(double[] x);

	public boolean evluateSolution(double currentSolution, double globalSolution) {
		if(opt)
			if(currentSolution < globalSolution)
				return true;
			else 
				return false;
		else
			if(currentSolution > globalSolution)
				return true;
			else
				return false; 
	}

	public double getInicialValue() {
		if(opt)
			return Double.MAX_VALUE;
		else
			return Double.MIN_VALUE;
	}
}
