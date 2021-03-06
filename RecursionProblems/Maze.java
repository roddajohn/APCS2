public class Maze {
    public static void main(String [] args) {
	Maze maze = new Maze();
	char[][] board = new char[5][5];
	board[0][0] = 'x';
	board[1][0] = 'x';
	board[2][0] = 'x';
	board[3][0] = 'x';
	board[4][0] = 'x';
	board[0][1] = 'x';
	board[1][1] = 's';
	board[2][1] = 'x';
	board[3][1] = 'x';
	board[4][1] = 'x';
	board[0][2] = 'x';
	board[1][2] = ' ';
	board[2][2] = 'x';
	board[3][2] = 'x';
	board[4][2] = 'x';
	board[0][3] = 'x';
	board[1][3] = ' ';
	board[2][3] = ' ';
	board[3][3] = 'e';
	board[4][3] = 'x';
	board[0][4] = 'x';
	board[1][4] = 'x';
	board[2][4] = 'x';
	board[3][4] = 'x';
	board[4][4] = 'x';
	for (int i = 0 ; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		System.out.print(", " + board[i][j] + " ");
	    }
	    System.out.println("");
	}
	board = maze.findPath(board);
	System.out.println(board);
    }
    public char[][] findPath(char[][] board) {
	int x = -1;
	int y = -1;
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] == 's') {
		    x = i;
		    y = j;
		}
	    }
	}
	if (x == -1 || y == -1) {
	    throw new IllegalArgumentException();
	}
	return findPathHelper(board, x, y);
    }
    public void printCharMatrix(char[][] board) {
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		System.out.print(", " + board[i][j] + " ");
	    }
	    System.out.println("");
	}
    }
    public char[][] findPathHelper(char[][] board, int x, int y) {
	printCharMatrix(board);
	if (borderingCharacter(board, x, y, 'e')) {
	    board[x][y] = '@';
	}
	else {
	    if (canMove(board, x, y + 1)) {
		findPathHelper(board, x, y + 1);
		if (board[x][y + 1] == '@') {
		    board[x][y] = '@';
		}
	    }
	    if (canMove(board, x - 1, y)) {
		findPathHelper(board, x - 1, y);
		if (board[x - 1][y] == '@') {
		    board[x][y] = '@';
		}
	    }
	    if (canMove(board, x, y - 1)) {
		findPathHelper(board, x, y - 1);
		if (board[x][y - 1] == '@') {
		    board[x][y] = '@';
		}
	    }
	    if (canMove(board, x + 1, y)) {
		findPathHelper(board, x + 1, y);
		if (board[x + 1][y] == '@') {
		    board[x][y] = '@';
		}
	    }
	    board[x][y] = '.';
	}
	return board;
    }
    public boolean canMove(char[][] board, int x, int y) {
	if (board[x][y] == '.' || board[x][y] == 's' || board[x][y] == '@' || board[x][y] == 'x' || x >= board.length || x < 0 || y >= board[x].length || y < 0) {
	    return false;
	}
	else {
	    return true;
	}
    }
    public boolean borderingCharacter(char[][]board, int x, int y, char c) {
	if (withinBounds(board, x, y + 1)) {
	    if (board[x][y + 1] == c) {
		return true;
	    }
	}
	if (withinBounds(board, x - 1, y)) {
	    if (board[x - 1][y] == c) {
		return true;
	    }
	}
	if (withinBounds(board, x, y - 1)) {
	    if (board[x][y - 1] == c) {
		return true;
	    }
	}
	if (withinBounds(board, x + 1, y)) {
	    if (board[x + 1][y] == c) {
		return true;
	    }
	}
	return false;
    }
    public boolean withinBounds(char[][]board, int x, int y) {
	if (x < board.length && x >= 0 && y < board[x].length && y >= 0) {
	    return true;
	}
	return false;
    }
}