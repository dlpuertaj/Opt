package test;

import algorithms.HillClimbing;
import algorithms.RandomSearch;
import problems.MaxOnes;
import problems.Rastrigin;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rastrigin ras = new Rastrigin(10,10);
		RandomSearch rs = new RandomSearch();
		
		double[] searchSpace = {-5.12,5.12};
		double best = rs.search(searchSpace, 1000, ras);
		
		System.out.println("Best " + best);
		
		MaxOnes mx = new MaxOnes(1000);
		HillClimbing hc = new HillClimbing();
		
		best = hc.search(10000, mx);
		
		System.out.println("Best " + best);

	}

}
