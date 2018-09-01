package utils;

import java.util.Comparator;

public class Individual <T> implements Comparable<Individual<T>>{
	private T solution;
	private double fitness;
	
	public Individual(){}
	
	public Individual(T solution, double fitness){
		this.solution = solution;
		this.fitness = fitness;
	}
	
	public Individual(T solution){
		this.solution = solution;
		this.fitness = 0.0;
	}
	
	public T getSolution() {
		return solution;
	}

	public void setSolution(T solution) {
		this.solution = solution;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public final Comparator<Individual<T>> SOLUTION = (Individual<T> ind1, Individual<T> ind2) -> {
		if(ind1.solution != ind2.solution)
			return -1;
		else
			return 0;
    };
    
    public final Comparator<Individual<T>> FITNESS = (Individual<T> ind1, Individual<T> ind2) -> Double.compare(ind1.fitness, ind2.fitness);
    
    
    
	public Comparator<Individual<T>> getSOLUTION() {
		return SOLUTION;
	}

	public Comparator<Individual<T>> getFITNESS() {
		return FITNESS;
	}

	@Override
	public int compareTo(Individual<T> o) {
		return SOLUTION.compare(this, o);
	}
	
}
