package practice2;

public class MinFillIn {
	// sequence[] is used to save the order of row permution
	public int[] sequence(double[][] a) {
		int rank = a[0].length;
		int[] helper = new int[rank];   // helper[] is used to save the row index
		for(int i = 0; i < helper.length; i++) {
			helper[i] = i;
		}
		int res[] = new int[rank - 1];
		for(int i = 0; i < rank - 1; i++) {
			int m = i; // m is used to save the index of the row to be permute with the first row
			int minFillIn = rank * rank; // minFillIn is used to save the minimal fill in number
			for(int j = i; j < rank; j++) {
				if(a[helper[j]][i] != 0) {
					int fillIn = 0;
					for(int k = i; k < rank; k++) {
						if(k == j) {
							continue;
						}
						else {
							if(a[helper[k]][i] != 0) {
								for(int l = i + 1; l < rank; l++) {
									if(a[helper[j]][l] != 0 && a[helper[k]][l] == 0) {
										fillIn++;
									}
								}
							}
						}
					}
					if(fillIn < minFillIn) {
						m = j;
						minFillIn = fillIn;
				    }
				}
			}
			int y = helper[i];
			helper[i] = helper[m];
			helper[m] = y;
			res[i] = m;
		}
		return res;
	}
	
	// perm is to use the sequence[] to finish permutation and calculation
	public void calculate(int[] seq, FullMatrix mat, double[] b) {
		int rank = mat.rank;
		for(int i = 0; i < seq.length; i++) {
			if(i != seq[i]) {
				mat.permute(i + 1, seq[i] + 1);
				permute(b, i + 1, seq[i] + 1);
			}
			for(int j = i + 1; j < rank; j++) {
				if(mat.matrixB[j][i] != 0) {
					double scale = mat.matrixB[j][i] / mat.matrixB[i][i];
					mat.scaling(i + 1, j + 1, -scale);
					scaling(b, i + 1, j + 1, -scale);
				}
			}
		}
	}
	public void permute(double[] b, int i, int j) {
		double m = b[i - 1];
		b[i - 1] = b[j - 1];
		b[j - 1] = m;
	}
	public void scaling(double[] b, int i, int j, double scaler) {
		b[j - 1] = b[j - 1] + scaler * b[i - 1];
	}
}
