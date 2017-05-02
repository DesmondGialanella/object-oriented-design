import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class GameObject implements IGameObject {

	protected List<IGameObject> m_enemylist;

	protected BufferedImage m_image;
	protected int m_x;
	protected int m_y;
	protected int m_w;
	protected int m_h;
	protected int m_dX; // x velocity in pixels per interval
	protected int m_dY; // y velocity in pixels per intercal
	protected int timerlength = 140;
	protected int m_timer = 0;
	protected String m_name = "";
	protected boolean alive = true;

	public GameObject(String image, int x, int y, int w, int h, int dX, int dY) {
		m_x = x;
		m_y = y;
		m_w = w;
		m_h = h;
		m_dX = dX;
		m_dY = dY;
		try {
			m_image = ImageIO.read(new File(image));
		} catch (IOException ex) {
			throw new Error(ex);
		}
	}

	public int gettimerlength() {
		return timerlength;
	}

	public int gettime() {
		return m_timer;
	}

	public boolean getalive() {
		return alive;
	}

	public abstract void tick(int maxw, int maxh);

	@Override
	public BufferedImage getImage() {
		return m_image;
	}

	@Override
	public Rectangle getRectangle() {
		return new Rectangle(m_x, m_y, m_w, m_h);
	}

	@Override
	public int getX() {
		return m_x;
	}

	@Override
	public int getY() {
		return m_y;
	}

	@Override
	public int getW() {
		return m_w;
	}

	@Override
	public int getH() {
		return m_h;
	}

	@Override
	public int getDX() {
		return m_dX;
	}

	@Override
	public int getDY() {
		return m_dY;
	}

	@Override
	public void keyPressed(char ch) {
	}

	public void keyReleased(char keyChar) {
	}

	public void setenemylist(List<IGameObject> objs) {
		m_enemylist = objs;
	}

	public void setName(String string) {
		m_name = string;
	}

	public String getName() {
		return m_name;
	}

}
