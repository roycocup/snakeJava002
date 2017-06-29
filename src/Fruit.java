import processing.core.PVector;

public class Fruit {
	Game game;
	PVector pos; 

	public Fruit(Game game){
		this.game = game;
		pos = new PVector();
		spawn();
	}
	
	void spawn(){
		pos.x = (int) game.random(game.numCols-1) * game.w;
		pos.y = (int) game.random(game.numRows-1) * game.w;
	}
	
	void update(){
		if(game.snake.pos.dist(pos) < 5){
			spawn();
		} 
	}
	
	void draw(){
		game.pushMatrix();
		game.fill(125,0,125);
		game.ellipse(pos.x, pos.y, game.w, game.w);
		game.popMatrix();
	}
	
}
