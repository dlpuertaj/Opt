package Test;

import algorithms.stochastic.RandomSearch;
import problems.Problem;
import problems.Rastrigin;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem problem = new Rastrigin(10);
		RandomSearch search = new RandomSearch(100,problem);
		double opt = search.search();
		System.out.println("Best solution found: "+opt);
	}

}
