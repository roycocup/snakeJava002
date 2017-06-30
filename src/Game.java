 import processing.core.PApplet;

public class Game extends PApplet {
	boolean debug = true;
	int numCols; 
	int numRows;
	int w = 10;

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
		if(debug){
			drawGrid();
		}
		
	}
	
	void drawGrid(){
		stroke(255, 0, 254, 50);
		for(int i = 0; i <= numCols; i++){
			line(i*w,0,i*w,height);
		}
		for(int j = 0; j < numCols; j++){
			line(0,j*w,width,j*w);
		}
	}
	
	public void keyPressed(){
		if (key == 'a'){
			snake.doCollision();
		}
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
