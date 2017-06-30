import processing.core.PVector;

public class Fruit {
	Game game;
	PVector pos; 

	public Fruit(Game game){
		this.game = game;
		pos = new PVector();
		spawn();
	}
	
	public void spawn(){
		pos.x = (int) game.random(game.numCols-1) * game.w;
		pos.y = (int) game.random(game.numRows-1) * game.w;
	}
	
	void update(){
		 
	}
	
	void draw(){
		game.pushMatrix();
		game.fill(125,0,125);
		game.noStroke();
		game.translate(game.w/2, game.w/2);
		game.ellipse(pos.x, pos.y, game.w, game.w);
		game.popMatrix();
	}
	
}
