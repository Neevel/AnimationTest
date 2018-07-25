import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class Enemys extends ApplicationAdapter{

	SpriteBatch batch2;
	Texture img2;
	int frame2 = 0;
	int zeile2 = 0;
	Sprite sprite2;
	TextureRegion[][] regions2;
	
	@Override
	public void create() {
		batch2 = new SpriteBatch();                       //  1200 x 683
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

//	@Override
//	public void render() {
//		
//		
//		batch2.begin();
//		
//		
//		sprite2.draw(batch2);
//		
//		batch2.end();
//
//	}

}