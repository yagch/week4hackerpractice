package practice3;



public class Main {
	public static void main(String[] arg) {
		double[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] rowPtr = {0, 3, 6, 9, 10, 12};
		int[] colInd = {0, 1, 4, 0 ,1, 2, 1, 2, 4, 3, 0, 4};
		double[][] fullMat = {{1, 2, 0, 0, 3}, {4, 5, 6, 0, 0}, {0, 7, 8, 0, 9}, {0, 0, 0, 10, 0}, {11, 0, 0, 0, 12}};
		SparseMatrix A = new SparseMatrix(value, rowPtr, colInd, 5);
		FullMatrix B = new FullMatrix(fullMat);
		
		//Calculate Max Column for sparse matrix
		double[] sum1 = new double[A.rank];
		for(int i = 0; i < sum1.length; i++) {
			sum1[i] = 0;
		}
		for(int i = 0; i < A.value.length; i++) {
			sum1[A.colInd[i]] += Math.abs(A.value[i]);
		}
		double maxCol1 = 0;
		for(int i = 0; i < sum1.length; i++) {
			if(sum1[i] > maxCol1) {
				maxCol1 = sum1[i];
			}
		}
		System.out.println("The upper bound of column vector sum for sparse matrix is");
		System.out.println(maxCol1);
		
		//Calculate Max Row for sparse matrix
		double[] sum2 = new double[A.rank];
		for(int i = 0; i < sum2.length; i++) {
			sum2[i] = 0;
		}
		for(int i = 1; i < A.rowPtr.length; i++) {
			for(int j = A.rowPtr[i - 1]; j < A.rowPtr[i]; j++) {
				sum2[i - 1] += Math.abs(A.value[j]);
			}
		}
		double maxCol2 = 0;
		for(int i = 0; i < sum2.length; i++) {
			if(sum2[i] > maxCol2) {
				maxCol2 = sum2[i];
			}
		}
		System.out.println("The upper bound of row vector sum for sparse matrix is");
		System.out.println(maxCol2);
		
		//Calculate Max Column for full matrix
		double[] sum3 = new double[B.rank];
		for(int i = 0; i < sum3.length; i++) {
			sum3[i] = 0;
		}
		for(int i = 0; i < B.rank; i++) {
			for(int j = 0; j < B.rank; j++) {
				sum3[i] += Math.abs(B.matrixB[j][i]);
			}
		}
		double maxCol3 = 0;
		for(int i = 0; i < sum3.length; i++) {
			if(sum3[i] > maxCol3) {
				maxCol3 = sum3[i];
			}
		}
		System.out.println("The upper bound of column vector sum for full matrix is");
		System.out.println(maxCol3);
		
		//Calculate Max Row for full matrix
		double[] sum4 = new double[B.rank];
		for(int i = 0; i < sum4.length; i++) {
			sum4[i] = 0;
		}
		for(int i = 0; i < B.rank; i++) {
			for(int j = 0; j < B.rank; j++) {
				sum4[i] += Math.abs(B.matrixB[i][j]);
			}
		}
		double maxCol4 = 0;
		for(int i = 0; i < sum4.length; i++) {
			if(sum4[i] > maxCol4) {
				maxCol4 = sum4[i];
			}
		}
		System.out.println("The upper bound of column vector sum for full matrix is");
		System.out.println(maxCol4);
	}
}
