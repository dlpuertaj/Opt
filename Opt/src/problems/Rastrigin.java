package problems;

public class Rastrigin extends Problem{

	private final int A = 10;
	private final double[] bounds = {-5.12,5.12};
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
	
	public int getDimensions() {
		return dimensions;
	}
	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}
	public int getA() {
		return A;
	}
	public double[] getBounds() {
		return bounds;
	}

	
}
