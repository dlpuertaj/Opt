package problems;

public class Rastrigin {
	private int n;
	private int A;
	private final double[] bounds = {-5.12,5.12};
	public Rastrigin (int n, int A) {
		this.n = n;
		this.A = A;
	}
	
	public double calc(double[] X) {
		double sum = 0;
		for(int i = 0 ; i < n ; i++) {
			sum += Math.pow(X[i], 2) - A*Math.cos(2*Math.PI*X[i]);
		}
		return (A*n) + sum;				
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getA() {
		return A;
	}

	public void setA(int a) {
		A = a;
	}

	public double[] getBounds() {
		return bounds;
	}
}
