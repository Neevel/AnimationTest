import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {

	public static void main(String[] args) {
		
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration(); 
	config.width = 1600; 
	config.height = 768; 
	new LwjglApplication(new GdxGame(), config); 
	

	}

}
