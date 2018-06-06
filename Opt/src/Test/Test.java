package Test;

import algorithms.stochastic.RandomSearch;
import problems.Problem;
import problems.Rastrigin;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] bounds = {-5.12,5.12}; 
		Problem problem = new Rastrigin(bounds,10,true);
		RandomSearch search = new RandomSearch(1000000,problem);
		double opt = search.search();
		System.out.println("Best solution found: "+opt);
	}

}
