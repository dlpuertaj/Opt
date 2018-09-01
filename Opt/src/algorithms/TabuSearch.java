package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import problems.TSP;
import utils.Tour;


public class TabuSearch {
	
	public int tabuSize;
	public int popSize;
	public int iters;
	public TSP tsp; //Problem
	public List<Tour> tabuList;
	public List<Tour> candidates;
	public TabuSearch(int tabuSize, int popSize, int iters, TSP tsp) {
		this.tabuSize = tabuSize;
		this.popSize = popSize;
		this.iters = iters;
		this.tabuList = new ArrayList<>();
		this.candidates = new ArrayList<>(tabuSize);
		this.tsp = tsp;
	}
	
	public double search() {		

		Tour best = tsp.generateRandomTour();
		
		for(int i = 0 ; i < iters ; i++) {
			candidates = generateCandidates(popSize);
			Collections.sort(candidates, Tour.Comparators.DISTANCE);//TODO: Implement sorting algorithms
			Tour bestCandidate = candidates.get(0);
			if(bestCandidate.getDistance() < best.getDistance()) {
				best = bestCandidate;
				
				if(tabuList.size() < tabuSize)
					tabuList.add(best);
			}
		}
		return  best.getDistance();
	}
	
	private List<Tour> generateCandidates(int popSize) {
		List<Tour> newCandidates = new ArrayList<>();
		int newCandidate = 0;
		while (newCandidate < popSize) {
			Tour candidate = tsp.generateRandomTour();
			if(!isTabu(candidate))
				newCandidates.add(candidate);
				newCandidate++;
		}
		return newCandidates;
	}

	private boolean isTabu(Tour candidate) {
		return tabuList.contains(candidate);
	}
}
