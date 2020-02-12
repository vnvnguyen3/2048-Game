import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener{
	private int score = 0;
	private int hiScore = 0;
	private int[][] grid = new int[4][4];
	private int[][] prev = new int[4][4];
	private GridGenerator generator = new GridGenerator();
	
	/*
	 * Gameplay Class
	 * Keeps track of score and grid numbers while taking in key presses
	 */
	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addTile();
	}
	
	/*
	 * Paints background, scores, and grid with GridGenerator
	 */
	public void paint(Graphics g) {
		//Background
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, 800, 800);
		
		//Score
		g.setFont(new Font("Daytona", Font.BOLD, 30));
		g.setColor(Color.BLACK);
		g.drawString("Score:", 50, 40);
		g.drawString(""+score, 50, 70);
		
		//High Score
		g.setColor(Color.BLACK);
		g.drawString("High Score:", 165, 40);
		g.drawString(""+hiScore, 165, 70);
		
		//Reset
		g.setColor(Color.BLACK);
		g.drawString("Press Enter", 350, 40);
		g.drawString("to Reset", 350, 70);
		
		//Grid
		generator.update(grid);
		generator.draw((Graphics2D)g);
	}
	
	/*
	 * Adds a tile over a random empty spot in the grid after making a move
	 */
	public void addTile() {
		if(score > hiScore) {
			hiScore = score;
		}
		Random rand = new Random();
		int[][] empty = new int[4][4];
		int s = 1;
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 4; col++) {
				if(grid[col][row] == 0) {
					empty[col][row] = s;
					s++;
				}
			}
		}
		if(s > 1) {
			int selected = rand.nextInt(s-1)+1;
			for(int row = 0; row < 4; row++) {
				for(int col = 0; col < 4; col++) {
					if(empty[col][row]==selected) {
						grid[col][row] = 2;
						repaint();
						return;
					}
				}
			}
		}
	}
	
	/*
	 * Copies the grid to check if it has changed after making a move
	 */
	public void copy() {
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 4; col++) {
				prev[col][row] = grid[col][row];
			}
		}
	}

	/*
	 * Different events happen when you press right, left, up, down, or enter
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moveUp();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveDown();
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset?");
			if(confirm == 0) {
				reset();
			}
		}
	}
	
	/*
	 * Press right to move the tiles to the right
	 */
	public void moveRight() {
		copy();
		for(int row = 0; row < 4; row++) {
			int stop = 3;
			for(int col = 2; col >= 0; col--) {
				if(grid[col][row]>0) {
					int i = col;
					while(i < stop) {
						int current = grid[i][row];
						int next = grid[i+1][row];
						if(next == 0) {
							grid[i][row] = 0;
							grid[i+1][row] = current;
						}
						else if(current == next) {
							grid[i][row] = 0;
							grid[i+1][row] += current;
							score += current + next;
							stop--;
							break;
						}
						else {
							stop--;
							break;
						}
						i++;
					}
				}
			}
		}
		repaint();
		if(!Arrays.deepEquals(prev, grid)) {
			addTile();
		}
	}
	
	/*
	 * Press left to move the tiles to the left
	 */
	public void moveLeft() {
		copy();
		for(int row = 0; row < 4; row++) {
			int stop = 0;
			for(int col = 1; col < 4; col++) {
				if(grid[col][row]>0) {
					int i = col;
					while (i > stop) {
						int current = grid[i][row];
						int next = grid[i-1][row];
						if(next == 0) {
							grid[i][row] = 0;
							grid[i-1][row] = current;
						}
						else if(current == next) {
							grid[i][row] = 0;
							grid[i-1][row] += current;
							score += current + next;
							stop++;
							break;
						}
						else {
							stop++;
							break;
						}
						i--;
					}
				}
			}
		}
		repaint();
		if(!Arrays.deepEquals(prev, grid)) {
			addTile();
		}
	}
	
	/*
	 * Press up to move the tiles upwards
	 */
	public void moveUp() {
		copy();
		for(int col = 0; col < 4; col++) {
			int stop = 0;
			for(int row = 1; row < 4; row++) {
				if(grid[col][row]>0) {
					int i = row;
					while(i > stop) {
						int current = grid[col][i];
						int next = grid[col][i-1];
						if(next==0) {
							grid[col][i] = 0;
							grid[col][i-1] = current;
						}
						else if(current==next) {
							grid[col][i] = 0;
							grid[col][i-1] += current;
							score += current + next;
							stop++;
							break;
						}
						else {
							stop++;
							break;
						}
						i--;
					}
				}
			}
		}
		repaint();
		if(!Arrays.deepEquals(prev, grid)) {
			addTile();
		}
	}
	
	/*
	 * Press down to move the tiles downward
	 */
	public void moveDown() {
		copy();
		for(int col = 0; col < 4; col++) {
			int stop = 3;
			for(int row = 2; row >= 0; row--) {
				if(grid[col][row]>0) {
					int i = row;
					while(i < stop) {
						int current = grid[col][i];
						int next = grid[col][i+1];
						if(next==0) {
							grid[col][i] = 0;
							grid[col][i+1] = current;
						}
						else if(current==next) {
							grid[col][i] = 0;
							grid[col][i+1] += current;
							score += current + next;
							stop--;
							break;
						}
						else {
							stop--;
							break;
						}
						i++;
					}
				}
			}
		}
		repaint();
		if(!Arrays.deepEquals(prev, grid)) {
			addTile();
		}
	}
	
	/*
	 * Press enter to reset the grid and score
	 */
	public void reset() {
		grid = new int[4][4];
		prev = new int[4][4];
		score = 0;
		addTile();
	}

	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}
