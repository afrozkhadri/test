import java.util.Scanner;

public class CrossWord {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int Case = 1;
		while (true) {
			int noOfRows = input.nextInt();
			if (noOfRows == 0)
				break;
			int noOfCols = input.nextInt();

			char[][] arr = new char[noOfRows][noOfCols];
			for (int row = 0; row < noOfRows; ++row)
				arr[row] = input.next().toCharArray();

			int count = 1;
			int[][] grid = new int[noOfRows][noOfCols];
			for (int row = 0; row < noOfRows; ++row)
				for (int col = 0; col < noOfCols; ++col) {
					if (arr[row][col] == '*')
						continue;
					else if ((col - 1 < 0 || row - 1 < 0) || (arr[row][col - 1] == '*' || arr[row - 1][col] == '*'))
						grid[row][col] = count++;
				}

			if (Case > 1)
				System.out.println();
			System.out.println("puzzle #" + (Case++) + ":");
			System.out.println("Across");
			for (int row = 0; row < noOfRows; ++row)
				for (int col = 0; col < noOfCols; ++col) {
					if (arr[row][col] == '*')
						continue;
					count = col;
					String str = "";
					while (count < noOfCols && arr[row][count] != '*')
						str += arr[row][count++];
					System.out.printf("%3d.%s\n", grid[row][col], str);
					col = count;
				}

			boolean[][] bool = new boolean[noOfRows][noOfCols];
			System.out.println("Down");
			for (int row = 0; row < noOfRows; ++row) {
				for (int col = 0; col < noOfCols; ++col) {
					if (arr[row][col] == '*')
						continue;
					if (bool[row][col])
						continue;
					count = row;
					String string = "";
					while (count < noOfRows && arr[count][col] != '*') {
						bool[count][col] = true;
						string += arr[count++][col];
					}
					System.out.printf("%3d.%s\n", grid[row][col], string);
				}
			}

		}
	}
}