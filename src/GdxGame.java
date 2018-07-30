import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class GdxGame extends ApplicationAdapter {

	SpriteBatch batch;

	// player
	Texture player;
	Texture background;
	int frame = 0;
	int zeile = 0;
	Sprite sprite;
	TextureRegion[][] regions;

	@Override
	public void create() {

		batch = new SpriteBatch();

		player = new Texture("player2.png");
		background = new Texture("back.jpg");

		regions = TextureRegion.split(player, 300, 319);
		sprite = new Sprite(regions[0][0]);

		sprite.setPosition(0, 250);

		Timer.schedule(new Task() {
			@Override
			public void run() {
				frame++;
				if (frame > 3) // if sprite anzahl auf dem letzten fange in der nächsten zeile an
				{
					frame = 0;
					if (zeile == 1) {
						zeile = 0;
					} else {

						zeile = 1;
					}
				}

				sprite.setRegion(regions[zeile][frame]);
			}

		}, 0, 1 / 6f);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(255, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			if (sprite.getX() > -50) {
				sprite.translateX(-10f);
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			if (sprite.getX() < 1350) {
				sprite.translateX(10f);
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			if (sprite.getY() > -10) {
				sprite.translateY(-10f);
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			if (sprite.getY() < 480) {
				sprite.translateY(10f);
			}
		}

		batch.begin();

		// batch.draw(background, 0, 0);
		sprite.draw(batch);

		batch.end();

	}

	

}
