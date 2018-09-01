package algorithms;

import problems.MaxOnes;

public class HillClimbing {
	public double search(int iters, MaxOnes mx) {
		double found = 0;
		String best = mx.randomBitString();
		found = mx.calc(best);
		String neighbor;
		for(int i = 0 ; i < iters ; i++) {
			neighbor = mx.mutate(best);
			best = mx.calc(neighbor) > found ?  neighbor : best;
			found = mx.calc(best);
//			System.out.println(found);
			if(found == mx.getLenght())
				break;
		}
		return found;
	}
}
