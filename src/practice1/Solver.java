package practice1;

public class Solver {
	public double[] x(double[][] A, double[] b) {
		double a1 = A[0][0];
		double a2 = A[0][1];
		double a3 = A[1][0];
		double a4 = A[1][1];
		double b1 = b[0];
		double b2 = b[1];
		double[] x = new double[2];
		x[0] = (b1 * a4 - a2 * b2) / (a1 * a4 - a2 * a3);
		x[1] = (b1 * a3 - a1 * b2) / (a2 * a3 - a4 * a1);
		return x;
	}
}
