public class checkForVic extends Board{

    public checkForVic(){
        super();
    }

    public boolean checkTheBoundary(int col, int row, int x, int y){
        if(row<0 || row>=BOARDSIZE || col<0 || col>=BOARDSIZE || (col == x && row == y))
            return false;

        else return true;
    }// this is for avoiding  checking null and itself.

    public boolean checkTheBoundary(int col, int row){
        if(row<0 || row>=BOARDSIZE || col<0 || col>=BOARDSIZE )
            return false;

        else return true;
    }

    public boolean checkForVictory(int x, int y){       // check for victory stats here.

        char piece = board[x][y];
        for(int col = x-1; col<= x+1; col++){
            for (int row = y-1; row <= y+1; row++){
                if( checkTheBoundary(col,row,x,y) && (board[col][row] == piece) ) {
                    if(col == x || row == y){
                        if( checkStraightLine(x,y,piece)) {
                            return true;
                        }
                    }

                    else if( checkTheBoundary(col-1,5) && (x == col-1) ){
                            if (checkSlopeLine(x,y,piece)){
                                return true;
                            }
                    }
                    else if( checkTheBoundary(col+1,5) && (x == col+1 )  ){
                    	 if (checkSlopeLine(x,y,piece)){
                             return true;
                         }
                    }

                }
            }
        }
        return false;  //with out any piece in the first round.
    }

    public boolean checkSlopeLine(int x, int y, char piece){
        int count1 = 0;
        int count2 = 0;
        int a = x - 1;
        int b = y - 1;
        int c = x + 1;
        int d = y + 1;
        //for slope leftward
        while( checkTheBoundary(a,b) && checkPiece(a,b,piece)){ //upward
            count1 ++;
            a--;
            b--;
        }
        while( checkTheBoundary(c,d) && checkPiece(c,d,piece)){ //downward
            count1 ++;
            c++;
            d++;
        }
        if(count1 >= 4)
            return true;
        else{
            a = x - 1;
            b = y - 1;
            c = x + 1;
            d = y + 1;
        }

        //for slope rightward
        while( checkTheBoundary(c,b) && checkPiece(c,b,piece)){ //upward
            count2 ++;
            c++;//X
            b--;//y
            System.out.println("Here");
        }
        while(checkTheBoundary(a,d) && checkPiece(a,d,piece)){ //downward
            count2 ++;
            a--;
            d++;
        }
        if(count2 >= 4)
            return true;
        else
            return false;


    }


    //this is for horizental and vertical

    public boolean checkStraightLine(int x, int y, char piece){
        int count1 = 0;
        int a = x + 1;
        int b = x - 1;

        int count2 =0;
        int n = y + 1;
        int m = y - 1;
        
        //this is for horizental line
        while( checkTheBoundary(a,y) && checkPiece(a,y,piece)){  //rightward
            count1 ++;
            a++;
        }
        while( checkTheBoundary(b,y) && checkPiece(b,y,piece)){ //leftwoard
            count1 ++;
            b--;
        }

        if(count1 >= 4)
            return true;

        else{                   //this is for vertical line
            while( checkTheBoundary(x,n) && checkPiece(x,n,piece)){  //downward
                count2 ++;
                n++;
            }
            while ( checkTheBoundary(x,m) && checkPiece(x,m,piece)){ //upward
                count2 ++;
                m--;
            }
            if(count2 >= 4)
                return true;
            else
                return false;
        }

    }


    public boolean checkPiece(int x, int y, char piece){
        if(board[x][y] == piece){
            return true;
        }
        else return false;
    }

}
