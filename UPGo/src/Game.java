import java.awt.Color;

public class Game{

    // The following five constants were defined in the starter code (kt54)
    private static String BLACKPLAY_MESSAGE      = "Black side plays. Enter move:";
    private static String WHITEPLAY_MESSAGE     = "White side plays. Enter move:";
    private static String ILLEGALMOVE_MESSAGE   = "Illegal move!";
    private static String BLACKWINS_MESSAGE       = "Black side wins!";
    private static String WHITEWINS_MESSAGE      = "White side win!";
    private checkForVic gameBoard;
    private BoardDisplay display;
    

    public Game() {
        gameBoard = new checkForVic();
        display = new BoardDisplay();
    }
    
    public  boolean isMoveLegal(int row, int col) {
        
        if (row < 0 || row >= gameBoard.BOARDSIZE || col < 0 || col >= gameBoard.BOARDSIZE)
          return false; 
        
        if (gameBoard.board[row][col] != gameBoard.FREE) {
        	return false;
        }
        
        return true;    
    }

    public void makeMove(int row, int col,boolean blackMove){
    	
        if(blackMove){
            gameBoard.board[row][col] = gameBoard.BLACK;
        	display.update(Color.BLACK);
    	}else{
            gameBoard.board[row][col] = gameBoard.WHITE;
        	display.update(Color.WHITE);
    	}
    }

    public void printStatus(boolean blackMove){
        if(blackMove){
            System.out.println(BLACKPLAY_MESSAGE);
        }else{
            System.out.println(WHITEPLAY_MESSAGE);
        }
    }


    public void play() {
    	
    	 //EasyIn2 reader = new EasyIn2();
    	 
    	 boolean over = false;
    	 boolean blackMoved = true;
    	 

    	 while(!over) {
             //gameBoard.printBoard();
             //printStatus(blackMoved);
             //row = reader.getInt();
             //col = reader.getInt();
             int row = -1;
        	 int col = -1;
			 while(display.lastPiece != null && row == -1 && col == -1) {
				 row = display.lastPiece.getX();
				 col = display.lastPiece.getY();
				 //System.out.println(row + " " + col);
			 }


             if(isMoveLegal(row, col)){
                 makeMove(row, col, blackMoved);
                    if( gameBoard.checkForVictory(row,col) ) {
                        over = true;
                        gameBoard.printBoard();
                        if(blackMoved){
                            System.out.println(BLACKWINS_MESSAGE);
                        	display.win("Black");
                        }else{
                            System.out.println(WHITEWINS_MESSAGE);
                        	display.win("White");
                        }
                    }
                 blackMoved = !blackMoved;

             }else{
            	 System.out.println();//ILLEGALMOVE_MESSAGE);
            } //info of illegal move.
         }

    			 

    	           

    }
}
 