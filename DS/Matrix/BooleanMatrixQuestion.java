/*A Boolean Matrix Question
Given a boolean matrix mat[M][N] of size M X N,
modify it such that if a matrix cell mat[i][j] is 1 (or true)
then make all the cells of ith row and jth column as 1.*/

class BooleanMatrixQuestion {


	public static void convert(int[][] m) {
		boolean row[] = new boolean[m.length];
		boolean col[] = new boolean[m[0].length];

		int k = 0;

		for (int i = 0 ; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 1) {
					row[i] = true;
					col[j] = true;
				}
			}
		}

		for (int i = 0 ; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (row[i] == true || col[j] == true) {
					m[i][j] = 1;
				}
			}
		}
	}

	public static void main(String[] args) {

		int[][] mat = { {1, 0, 0, 1},
			{0, 0, 1, 0},
			{0, 0, 0, 0}
		};

		convert(mat);

		for (int i = 0 ; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}

	}
}