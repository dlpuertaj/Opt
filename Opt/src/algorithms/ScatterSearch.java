package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import problems.Rastrigin;
import utils.Individual;
import utils.Tuple;
import utils.Util;

public class ScatterSearch {
	
	private Rastrigin rastrigin;
	
	public ScatterSearch(Rastrigin rastrigin) {
		this.rastrigin = rastrigin;
	}
	
	public double search() {
		return 0;
	}
	
	public double[] localSearch(double[] bounds, double[] best, int maxNoImprov, int stepSize) {
		double[] candidate = best.clone();
		double candidateCost;
		double bestCost = objectiveFunction(best);
		while(maxNoImprov > 0) {
			candidate = takeStep(bounds,best, stepSize);
			candidateCost = objectiveFunction(candidate);
			if(candidateCost < bestCost)
				best = candidate;
			maxNoImprov -= 1;
		}
		return best;
	}
	
	public double objectiveFunction(double[] solution) {
		return rastrigin.calc(solution);
	}
	
	public double distance(double[] candidate, double[] reference) {
		double distance = 0;
		for (int i = 0; i < reference.length; i++) {
			distance += Util.euclideanDistance(candidate[i], reference[i]);
		}
		return distance;
	}
	
	public double[] takeStep(double[] bounds, double[] current, int stepSize) {
		double[] position = new double[current.length];
		double lowerBound = 0;
		double upperBound = 0;
		for (int i = 0; i < position.length; i++) {
			lowerBound = Math.max(bounds[0], current[i] - stepSize);
			upperBound = Math.min(bounds[0], current[i] + stepSize);
			position[i] = Util.randInBound((int)lowerBound, (int)upperBound);
		}
		return position;
	}
	
	public List<Individual<double[]>> constructInitialSet(int setSize, int maxNoImprove, int stepsize){
		List<Individual<double[]>> diverseSet = new ArrayList<>(setSize);
		double[] candidate = Util.randomSolution(rastrigin.getN(), rastrigin.getBounds());
		
		while(setSize > 0) {
			Individual<double[]> refined = new Individual<>(localSearch(rastrigin.getBounds(),candidate, maxNoImprove, stepsize));
			if(!diverseSet.contains(refined))
				diverseSet.add(refined);
			setSize--;
		}
		return diverseSet;
	}
	
	

	public Tuple<List<Individual<double[]>>, Individual<double[]>>  selectReferenceSet(List<Individual<double[]>> diverseList, int num_elite, int refSetSize) {
		Collections.sort(diverseList,diverseList.get(0).getFITNESS());
		List<Individual<double[]>> refSet = diverseList.subList(0, num_elite);
		List<Individual<double[]>> remainder = diverseList.subList(num_elite,diverseList.size());
		for(int i = 0 ; i < remainder.size(); i++) {
			remainder.get(i).setFitness(distance(remainder.get(i).getSolution(),refSet.get(i).getSolution()));
		}
		Collections.sort(remainder, remainder.get(0).FITNESS);
		refSet.addAll(remainder.subList(0, refSetSize-refSet.size()));
		return new Tuple<List<Individual<double[]>>, Individual<double[]>>(refSet,refSet.get(0));
	}
}
