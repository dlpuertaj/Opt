package problems;

public class Rastrigin extends Problem{

	private final int A = 10;

	
	public Rastrigin(double[] bounds, int dim,boolean opt) {
		super(bounds,dim,opt);
	}
	
	@Override
	public double calc(double[] x) {
		double s = 0;
		
		for (double xi : x) {
			s = (xi*xi) - A*Math.cos(2*Math.PI*xi);
		}
		return A*super.getDim() + s;
	}
	
}
