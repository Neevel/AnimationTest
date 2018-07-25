import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class GdxGame extends ApplicationAdapter {
	
	SpriteBatch batch;
	SpriteBatch batch2;
	//player
	Texture img;
	Texture background; 
	int frame = 0;
	int zeile = 0;
	Sprite sprite;
	TextureRegion[][] regions;
	//gegner
	Texture img2;
	int frame2 = 0;
	int zeile2 = 0;
	Sprite sprite2;
	TextureRegion[][] regions2;

	@Override
	public void create() {
		
		batch = new SpriteBatch();    
		batch2 = new SpriteBatch(); //  1200 x 683
		img = new Texture("player2.png"); 
		background = new Texture("back.jpg"); 
		
		regions = TextureRegion.split(img, 300 ,  319); 
		sprite = new Sprite(regions[0][0]); 
		//sprite2.setPosition(0, 250);
		//sprite.setPosition(0, 250);
		
		Timer.schedule(new Task()  {
			@Override
			public void run() {
				frame ++;
				if(frame > 3)      // if sprite anzahl auf dem letzten fange in der nächsten zeile an 
				{
					frame = 0; 
					if(zeile == 1) 
					{	
						zeile = 0; 
					}
					else
					{
				
					zeile = 1; 
					}
				}
			
			sprite.setRegion(regions [zeile][frame]); 
		}
		
	},0, 1/5f);
img2 = new Texture("enemy1.png"); 
	 
		
		regions2 = TextureRegion.split(img2, 250 ,  226); 
		sprite2 = new Sprite(regions2[0][0]); 
		sprite2.setPosition(0, 250);
		Timer.schedule(new Task()  {
			@Override
			public void run() {
				frame2 ++;
				if(frame2 > 29)      // if sprite anzahl auf dem letzten fange in der nächsten zeile an 
				{
					frame2 = 0; 
					if(zeile2 == 1) 
					{	
						zeile2 = 0; 
					}
					else
					{
				
					zeile2 = 1; 
					}
				}
			
			sprite2.setRegion(regions2 [zeile2][frame2]); 
		}
		
	},0, 1/5f);

	

	}
	

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			sprite.translateX(-5f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			sprite.translateX(5f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			sprite.translateY(-5f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			sprite.translateY(5f);
		}
		
		batch.begin();
		
		batch.draw(background, 0, 0);
		sprite.draw(batch);
		sprite2.draw(batch);
		
		batch.end();

	}

}
