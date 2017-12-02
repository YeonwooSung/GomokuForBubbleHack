
public class Board {

	public static final int BOARDSIZE = 15;
	public static final char FREE = '.';
	public static final char BLACK = 'x';
	public static final char WHITE = 'o';
	
	public char[][] board;
	
	public Board(){
		
		board = new char[BOARDSIZE][BOARDSIZE];
		
		// Construct the shape of the board
				for (int x = 0; x < BOARDSIZE; x++) {
					for (int y = 0; y < BOARDSIZE; y++) {
						
						board[x][y] = FREE;	
				}
			}
	}	
		public void printBoard() {

					for (int y = 0; y < BOARDSIZE; y++) {
						for (int x = 0; x < BOARDSIZE; x++) {
							System.out.print(" ");
							switch (board[x][y]) {
							case FREE:
								System.out.print(".");
								break;
							case BLACK:
								System.out.print("x");
								break;
							case WHITE:
								System.out.print("o");
								break;
							default:
								System.out.print(" ");
							}
						}
						System.out.println();
					}
				}
		}
	

