package Problems;

public class Rastrigin implements Problem{

	private final int A = 10;
	private int dimensions;
	
	public Rastrigin(int dim) {
		this.dimensions = dim;
	}
	@Override
	public double calc(double[] x) {
		double s = 0;
		
		for (double xi : x) {
			s = (xi*xi) - A*Math.cos(2*Math.PI*xi);
		}
		return A*this.dimensions + s;
	}

}
