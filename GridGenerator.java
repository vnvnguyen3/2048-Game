import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class GridGenerator {
	private int[][] grid = new int[4][4];
	/*
	 * GridGenerator Class
	 * Draws the grid and tiles
	 * Sets different colors for the different numbers
	 */
	public void draw(Graphics2D g) {
		//Grid
		g.setColor(Color.BLACK);
		g.fillRect(50, 100, 450, 10);
		g.fillRect(50, 210, 450, 10);
		g.fillRect(50, 320, 450, 10);
		g.fillRect(50, 430, 450, 10);
		g.fillRect(50, 540, 450, 10);
		g.fillRect(50, 100, 10, 450);
		g.fillRect(160, 100, 10, 450);
		g.fillRect(270, 100, 10, 450);
		g.fillRect(380, 100, 10, 450);
		g.fillRect(490, 100, 10, 450);
		
		//Tiles
		g.setFont(new Font("Daytona", Font.BOLD, 20));
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 4; col++) {
				int tile = grid[col][row];
				if(tile == 0) {
					g.setColor(Color.DARK_GRAY);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
				}
				else if(tile == 2){
					g.setFont(new Font("Daytona", Font.BOLD, 60));
					g.setColor(Color.LIGHT_GRAY);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 95+col*110, 180+row*110);
				}
				else if(tile == 4){
					g.setFont(new Font("Daytona", Font.BOLD, 60));
					g.setColor(Color.GRAY);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 95+col*110, 180+row*110);
				}
				else if(tile == 8){
					g.setFont(new Font("Daytona", Font.BOLD, 60));
					g.setColor(Color.ORANGE);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 95+col*110, 180+row*110);
				}
				else if(tile == 16){
					g.setFont(new Font("Daytona", Font.BOLD, 60));
					g.setColor(Color.PINK);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 75+col*110, 180+row*110);
				}
				else if(tile == 32){
					g.setFont(new Font("Daytona", Font.BOLD, 60));
					g.setColor(Color.MAGENTA);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 75+col*110, 180+row*110);
				}
				else if(tile == 64){
					g.setFont(new Font("Daytona", Font.BOLD, 60));
					g.setColor(Color.RED);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 75+col*110, 180+row*110);
				}
				else if(tile == 128){
					g.setFont(new Font("Daytona", Font.BOLD, 50));
					g.setColor(Color.YELLOW);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 70+col*110, 180+row*110);
				}
				else if(tile == 256){
					g.setFont(new Font("Daytona", Font.BOLD, 50));
					g.setColor(Color.GREEN);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 70+col*110, 180+row*110);
				}
				else if(tile == 512){
					g.setFont(new Font("Daytona", Font.BOLD, 50));
					g.setColor(Color.CYAN);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 70+col*110, 180+row*110);
				}
				else if(tile == 1024){
					g.setFont(new Font("Daytona", Font.BOLD, 40));
					g.setColor(Color.BLUE);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 65+col*110, 175+row*110);
				}
				else if(tile == 2048){
					g.setFont(new Font("Daytona", Font.BOLD, 40));
					g.setColor(Color.WHITE);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.BLACK);
					g.drawString(""+tile, 65+col*110, 175+row*110);
				}
				else if(tile < 10000){
					g.setFont(new Font("Daytona", Font.BOLD, 40));
					g.setColor(Color.BLACK);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.WHITE);
					g.drawString(""+tile, 65+col*110, 175+row*110);
				}
				else if(tile < 100000){
					g.setFont(new Font("Daytona", Font.BOLD, 30));
					g.setColor(Color.BLACK);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.WHITE);
					g.drawString(""+tile, 65+col*110, 175+row*110);
				}
				else {
					g.setFont(new Font("Daytona", Font.BOLD, 30));
					g.setColor(Color.BLACK);
					g.fillRect(60+col*110, 110+row*110, 100, 100);
					g.setColor(Color.WHITE);
					g.drawString(""+tile, 60+col*110, 175+row*110);
				}
			}
		}
	}
	
	/*
	 * Takes in a new grid to draw
	 */
	public void update(int[][] g) {
		grid = g;
	}
}
