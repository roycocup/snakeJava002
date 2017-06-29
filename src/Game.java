 import processing.core.PApplet;

public class Game extends PApplet {

	int w = 10; 
	int numCols; 
	int numRows;

	Snake snake; 
	Fruit fruit;

	public void settings(){
		size(400, 400);
	}
	
	public void setup(){
		frameRate(10);
		numCols = width / w; 
		numRows = height / w;
		snake = new Snake(this);
		fruit = new Fruit(this);
	}


	public void draw(){
		background(0);
		snake.update();
		snake.draw();
		fruit.update();
		fruit.draw();
	}
	
	public void keyPressed(){
		switch(keyCode){
		case 37:
			snake.assignDirection(-1,0);
			break;
		case 38:
			snake.assignDirection(0,-1);
			break;
		case 39:
			snake.assignDirection(1,0);
			break;
		case 40:
			snake.assignDirection(0,1);
			break;
		}
	}
	

	public static void main(String[] args) {
		PApplet.main("Game");
	}

}
