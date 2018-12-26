
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewTest {

	public static class Puzzle {
		private char[][] spaces;

		
		int row, col;

		Puzzle() {
			spaces = new char[5][];
			for (int i = 0; i < 5; i++) {
				spaces[i] = new char[5];
			}
		}

		public boolean read(BufferedReader in) throws IOException {
			for (int i = 0; i < 5; i++) {
				String line = in.readLine();
				if (line.equals("Z"))
					return false;
				for (int j = 0; j < 5; j++) {
					spaces[i][j] = line.charAt(j);
					if (spaces[i][j] == ' ') {
						row = i;
						col = j;
					}
				}
			}
			return true;
		}

		public void swapSpace(int row2, int col2) {
			char tmp = spaces[row][col];
			spaces[row][col] = spaces[row2][col2];
			spaces[row2][col2] = tmp;
		}

		public boolean doMove(char c) {
			switch (c) {
			case 'A':
				if (row == 0)
					return false;
				swapSpace(row - 1, col);
				row--;
				return true;
			case 'B':
				if (row == 4)
					return false;
				swapSpace(row + 1, col);
				row++;
				return true;
			case 'L':
				if (col == 0)
					return false;
				swapSpace(row, col - 1);
				col--;
				return true;
			case 'R':
				if (col == 4)
					return false;
				swapSpace(row, col + 1);
				col++;
				return true;
			default:
				System.out.println("Bad move: '" + c + "'");
				return false;
			}
		}

		public void doMoves(BufferedReader in) throws IOException {
			while (true) {
				String line = in.readLine();
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (c == '0')
						return;
					if (!doMove(c)) {
						row = -1;
						col = -1;
						return;
					}
                  System.out.println("move allow:\n"+this);
				}
			}
		}

		public String toString() {
			if (row == -1 || col == -1)
				return "   This puzzle has no final configuration.";

			StringBuilder buf = new StringBuilder();
			for (int i = 0; i < 5; i++) {
				buf.append("  ");
				for (int j = 0; j < 5; j++) {
					buf.append(' ');
					buf.append(spaces[i][j]);
				}
				buf.append('\n');
			}
			return buf.toString();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int counter = 1;
		while (true) {
			Puzzle p = new Puzzle();
			if (!p.read(in))
				break;
			p.doMoves(in);
			System.out.println("Puzzle #" + counter++ + ":\n" + p);
		}
	}
}