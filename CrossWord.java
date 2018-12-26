import java.util.Scanner;

public class CrossWord {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int Case = 1;
		while (true) {
			int a = input.nextInt();
			if (a == 0)
				break;
			int b = input.nextInt();

			char[][] arrGrid = new char[a][b];
			for (int i = 0; i < a; ++i)
				arrGrid[i] = input.next().toCharArray();

			int cnt = 1;
			int[][] grid = new int[a][b];
			for (int i = 0; i < a; ++i)
				for (int j = 0; j < b; ++j) {
					if (arrGrid[i][j] == '*')
						continue;
					else if ((j - 1 < 0 || i - 1 < 0) || (arrGrid[i][j - 1] == '*' || arrGrid[i - 1][j] == '*'))
						grid[i][j] = cnt++;
				}

			if (Case > 1)
				System.out.println();
			System.out.println("puzzle #" + (Case++) + ":");
			System.out.println("Across");
			for (int i = 0; i < a; ++i)
				for (int j = 0; j < b; ++j) {
					if (arrGrid[i][j] == '*')
						continue;
					cnt = j;
					String str = "";
					while (cnt < b && arrGrid[i][cnt] != '*')
						str += arrGrid[i][cnt++];
					System.out.printf("%3d.%s\n", grid[i][j], str);
					j = cnt;
				}

			boolean[][] bool = new boolean[a][b];
			System.out.println("Down");
			for (int i = 0; i < a; ++i) {
				for (int j = 0; j < b; ++j) {
					if (arrGrid[i][j] == '*')
						continue;
					if (bool[i][j])
						continue;
					cnt = i;
					String str = "";
					while (cnt < a && arrGrid[cnt][j] != '*') {
						bool[cnt][j] = true;
						str += arrGrid[cnt++][j];
					}
					System.out.printf("%3d.%s\n", grid[i][j], str);
				}
			}

		}
	}
}