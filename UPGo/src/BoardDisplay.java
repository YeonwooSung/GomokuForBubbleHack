import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BoardDisplay {
	
	static final int BOARD_SIZE = 15;
	Piece[][] grid = new Piece[BOARD_SIZE][BOARD_SIZE];
	Piece lastPiece = null;
	JFrame frame;
	
	BoardDisplay() {
		frame = new JFrame("Gomoku");
		
		JPanel toolbar = new JPanel();
		
		JPanel board = new JPanel();
		setBoard(board);
		frame.add(board);
		
		frame.setSize(1024,768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	void setBoard(JPanel board) {
		board.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));
		board.setBounds(100, 100, 500, 500);
		
		for (int i = 0; i < BOARD_SIZE; i++){
	        for (int j = 0; j < BOARD_SIZE; j++){
	        	int x = j;
	        	int y = i;
	            Piece currentPiece = grid[i][j] = new Piece(j, i);
	            currentPiece.getLabel().setBorder(new LineBorder(new Color(0, 204, 255)));
	            currentPiece.getLabel().setBackground(new Color(51, 153, 102));
	            currentPiece.getLabel().setOpaque(true);
	            board.add(currentPiece.getLabel());
	            
	            currentPiece.getLabel().addMouseListener(new MouseAdapter() {
	            	public void mouseClicked(MouseEvent e) {
	            		lastPiece = currentPiece;
	            	}
	            });
	            
	        }
	    }
	}
	
	void setPiece(Color color, int x, int y) {
		grid[y][x].getLabel().setBackground(color);
	}

	public void update(Color color) {
		if(lastPiece != null) {
			lastPiece.getLabel().setBackground(color);
		}
			
	}

	public void win(String winner) {
		JOptionPane.showConfirmDialog(frame, winner + " wins!");
	}
	
	
}

class Piece {
	
	private JLabel label;
	private int x;
	private int y;
	
	public Piece(int x, int y) {
		this.label = new JLabel();
		this.x = x;
		this.y = y;
	}
	
	public JLabel getLabel() {
		return this.label;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
