package utils;

import java.util.Comparator;

public class Tour implements Comparable<Tour>{
	private int[] tour;
	private double distance;
	public int[] getTour() {
		return tour;
	}
	public void setTour(int[] tour) {
		this.tour = tour;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
		
	}

	public static class Comparators {
	    public static final Comparator<Tour> DISTANCE = (Tour t1, Tour t2) -> Double.compare(t1.distance, t2.distance);
	    public static final Comparator<Tour> TOUR = (Tour t1, Tour t2) -> {
	    	for (int i = 0; i < t1.tour.length; i++) {
				if(t1.tour[i] != t2.tour[i])
					return -1;
			}	    	
	    	return 0;
	    };
	    public static final Comparator<Tour> TOURDISTANCE = (Tour t1, Tour t2) -> DISTANCE.thenComparing(TOUR).compare(t1, t2);
	}

	@Override
	public int compareTo(Tour tour) {
		return Comparators.TOUR.compare(this, tour);
	}
}
