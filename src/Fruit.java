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
		pos.x = (int) game.random(game.numCols * game.w);
		pos.y = (int) game.random(game.numRows * game.w);
	}
	
	void update(){
		if(game.snake.pos.dist(this.pos) < 3){
			spawn();
		} 
	}
	
	void draw(){
		game.fill(125,0,125);
		game.ellipse(pos.x, pos.y, game.w, game.w);
	}
	
}
