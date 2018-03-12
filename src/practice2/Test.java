package practice2;

public class Test {
	public static void main(String[] arg) {
		double[][] A = {{1,2,0,0,3}, {4,5,6,0,0},{0,7,8,0,9},{0,0,0,10,0},{11,0,0,0,12}};
		double[] b = {5,4,3,2,1};
		MinFillIn fill = new MinFillIn();
		FullMatrix mat = new FullMatrix(A);
		int[] seq = fill.sequence(A);
		System.out.println("The sequence of permuting is:");
		for(int i = 0; i < seq.length; i++) {
			System.out.print(seq[i] + " ");
		}
		System.out.println(" ");
		fill.calculate(seq, mat, b);
		System.out.println("The matrix U is:");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(mat.matrixB[i][j] + " ");
			}
			System.out.println(",");
		}
		double[] res = new double[5];
		res[4] = b[4] / mat.matrixB[4][4];
		res[3] = (b[3] - mat.matrixB[3][4] * res[4]) / mat.matrixB[3][3];
		res[2] = (b[2] - mat.matrixB[2][4] * res[4] - mat.matrixB[2][3] * res[3]) / mat.matrixB[2][2];
		res[1] = (b[1] - mat.matrixB[1][4] * res[4] - mat.matrixB[1][3] * res[3] - mat.matrixB[1][2] * res[2]) / mat.matrixB[1][1];
		res[0] = (b[0] - mat.matrixB[0][4] * res[4] - mat.matrixB[0][3] * res[3] - mat.matrixB[0][2] * res[2] - mat.matrixB[0][1] * res[1]) / mat.matrixB[0][0];
		System.out.println("The solution x is:");
		for(int i = 0; i < 5; i++) {
			System.out.println(res[i]);
		}
	}
		
}
