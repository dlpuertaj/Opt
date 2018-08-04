package algorithms;

import java.util.Random;

import problems.Rastrigin;

public class RandomSearch {

	
	
	public double search(double[] searchSpace, int maxIter, Rastrigin r) {
	  double best = 0;
	  double iterBest = 0;
	  double[] candidate;
	  
	  candidate  = randomCandidate(searchSpace, r.getN());
	  best = r.calc(candidate);
	  for(int i = 0 ; i < maxIter ; i++) {
	    candidate  = randomCandidate(searchSpace, r.getN());
	    iterBest = r.calc(candidate);
	    best = iterBest < best ? iterBest : best;
	    System.out.println("Iteration: " + i + " Best: " + best);
	  }
	  return best;
	}

	public double[] randomCandidate(double[] searchSpace, int n) {
		double[] candidate = new double[n];
		Random rand = new Random();
		for(int i = 0 ; i < n ; i++) {
			candidate[i] = searchSpace[0] + (searchSpace[1] - searchSpace[0]) * rand.nextDouble();
		}
		return candidate;
	}
}
