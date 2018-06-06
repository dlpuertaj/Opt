package problems;

import java.util.Random;


public abstract class Problem {
	
	private boolean opt;
	private double[] bounds;
	private int dim;
	
	public Problem(double[] bounds, int dim,boolean opt) {
		this.bounds = bounds;
		this.dim = dim;
		this.opt = opt;
	}

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

	public double[] randomDoubleSolution() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		double[] solution = new double[dim];
		for(int i = 0 ; i < dim ; i++) {
			solution[i] =  bounds[0] + (bounds[1] - bounds[0]) * rand.nextDouble();
		}
		return solution;
	}

	public double[] getBounds() {
		return bounds;
	}

	public void setBounds(double[] bounds) {
		this.bounds = bounds;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}
	
	
}
