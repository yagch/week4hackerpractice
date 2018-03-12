package practice1;

public class test {
	public static void main(String[] arg) {
		Solver solver = new Solver();
		double e = 0.01;
		double[][] A = new double[2][2];
		A[0][0] = 100;
		A[0][1] = 99;
		A[1][0] = 99;
		double[] b = new double[2];
		b[0] = 199;
		b[1] = 197;
		double[] validate = new double[2];
		for(int i = 0; i < 8; i++) {
			A[1][1] = 98.01 - e;
			double x1 = solver.x(A, b)[0];
			double y1 = solver.x(A, b)[1];
		    validate[0] = 100 * x1 + 99 * y1 - 199;
		    validate[1] = 99 * x1 + (98.01 - e) * y1 - 197;
		    double norm = Math.sqrt(validate[0] * validate[0] + validate[1] * validate[1]);
		    System.out.println("when e = 10 ^ -" + (-2 - i) + ":");
		    System.out.println("x = " + x1);
		    System.out.println("y = " + y1);
		    System.out.println("norm = " + norm);
		    e *= 0.1;
		}
	}
}
