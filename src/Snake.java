import java.util.ArrayList;

import processing.core.PVector;

public class Snake{
	public int x;
	public int y;
	
	Game game; 
	PVector dir; 
	PVector pos; 
	ArrayList<PVector> elements; 
	int tailSize = 1;
	
	public Snake(Game game){
		this.game = game;
		pos = new PVector(game.numCols / 2, game.numRows / 2);
		dir = new PVector();
		assignDirection(0, 1);
		elements = new ArrayList<PVector>();
		elements.add(pos.copy());
	}
	
	void update(){
		updateElements();
		move();
		doCollision();
	}
	
	void draw(){
		game.fill(255);
		for(int i = elements.size()-1; i >= 0; i--){
			game.rect(elements.get(i).x, elements.get(i).y, game.w, game.w);
		}
	}

	public void assignDirection(int x,int y){
		dir.x = x; 
		dir.y = y;
	}
	
	void move(){
		pos.x += dir.x * game.w;
		pos.y += dir.y * game.w;
		
		if (pos.x < 0)
			pos.x = game.width-game.w;
		
		if (pos.x >= game.width)
			pos.x = 0;
		
		if (pos.y < 0)
			pos.y = game.height-game.w;
		
		if (pos.y >= game.height)
			pos.y = 0;
	}
	
	void doCollision(){
		if(pos.dist(game.fruit.pos) < 5){
			game.fruit.spawn();
			elements.add(pos);
			tailSize++;
		}
	}
	
	void updateElements(){
		if (elements.size() <= tailSize){
			shiftElements();
		} 
		elements.set(elements.size()-1, pos.copy());
	}
	
	void shiftElements(){
		if (elements.size() > 1){
			for(int i = 0; i < elements.size()-1; i++){
				elements.set(i, elements.get(i+1));
			}
		}
	}
	

	

}