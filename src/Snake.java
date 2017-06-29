import processing.core.PVector;

public class Snake{
	public int x;
	public int y;
	
	Game game; 
	Vector dir; 
	PVector pos; 
	
	public Snake(Game game){
		this.game = game;
		pos = new PVector(game.numCols / 2, game.numRows / 2);
		dir = new Vector();
		assignDirection(0, 1);
	}

	public void assignDirection(int x,int y){
		dir.x = x; 
		dir.y = y;
		
	}
	
	void move(){
		pos.x += dir.x * game.w;
		pos.y += dir.y * game.w;
		
		if (pos.x < 0)
			pos.x = game.width;
		if (pos.x > game.width)
			pos.x = 0;
		if (pos.y < 0)
			pos.y = game.height;
		if (pos.y > game.height)
			pos.y = 0;
	}
	
	void update(){
		move();
	}

	void draw(){
		game.fill(255);
		game.rect(pos.x,pos.y, game.w, game.w);
	}

}