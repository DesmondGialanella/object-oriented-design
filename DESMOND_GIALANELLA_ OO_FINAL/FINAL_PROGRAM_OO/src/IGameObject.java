import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

public interface IGameObject {
	public void tick(int maxw, int maxh);

	public BufferedImage getImage();

	public Rectangle getRectangle();

	public int getX();

	public int getY();

	public int getW();

	public int getH();

	public int getDX();

	public int getDY();

	public void keyPressed(char ch);

	public void keyReleased(char keyChar);

	public int gettimerlength();

	public int gettime();

	public String getName();

	public boolean getalive();

	public void setenemylist(List<IGameObject> objs);
}
