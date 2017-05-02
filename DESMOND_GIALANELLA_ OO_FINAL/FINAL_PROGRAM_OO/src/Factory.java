import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Factory implements IFactory {
	private int hero_type1;
	private int enemy_type1;
	private int enemy_type2;
	private int viewmode_type1;
	private static IFactory m_instance;

	public static IFactory getInstance() {
		if (m_instance == null)
			m_instance = new Factory();
		return m_instance;
	}

	private Factory() {

		// scanning in the text file
		File file = new File("textfilegamechanger.txt");

		try {
			Scanner sc = new Scanner(file);

			String enemy1 = sc.nextLine();
			String[] enemy1_parts = enemy1.split("=");

			String enemy2 = sc.nextLine();
			String[] enemy2_parts = enemy2.split("=");

			String hero1 = sc.nextLine();
			String[] hero1_parts = hero1.split("=");

			String viewmode = sc.nextLine();
			String[] viewmode_parts = viewmode.split("=");

			hero_type1 = Integer.parseInt(hero1_parts[1]);
			enemy_type1 = Integer.parseInt(enemy1_parts[1]);
			enemy_type2 = Integer.parseInt(enemy2_parts[1]);
			viewmode_type1 = Integer.parseInt(viewmode_parts[1]);

			System.out.println(enemy1);
			System.out.println(enemy2);
			System.out.println(hero1);
			System.out.println(viewmode);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public IGameObject createEnemy(int x, int y, int w, int h, int dX, int dY) {
		if (enemy_type1 == 1)
			return new enemy1_purple(x, y, w, h, dX, dY);
		else if (enemy_type1 == 2)
			return new enemy2_red(x, y, w, h, dX, dY);
		else if (enemy_type1 == 3)
			return new enemy3_yellow(x, y, w, h, dX, dY);
		else
			return new enemy4_green(x, y, w, h, dX, dY);

	}

	@Override
	public IGameObject createEnemy2(int x, int y, int w, int h, int dX, int dY) {
		if (enemy_type2 == 1)
			return new enemy1_purple(x, y, w, h, dX, dY);
		else if (enemy_type2 == 2)
			return new enemy2_red(x, y, w, h, dX, dY);
		else if (enemy_type2 == 3)
			return new enemy3_yellow(x, y, w, h, dX, dY);
		else
			return new enemy4_green(x, y, w, h, dX, dY);

	}

	@Override
	public IGameObject createHero(List<IGameObject> objs, int x, int y, int w, int h, int dX, int dY) {
		IGameObject hero;
		if (hero_type1 == 1)
			hero = new hero1_bubble(x, y, w, h, dX, dY);
		else if (hero_type1 == 2)
			hero = new hero2_steelball(x, y, w, h, dX, dY);
		else
			hero = new hero3_iceball(x, y, w, h, dX, dY);
		
		hero.setenemylist(objs);
		return hero;
	}

	@Override
	public IGameView createMainView(List<IGameObject> objects) {
		return new GameView(objects);
	}

	@Override
	public IGameView createStatusView(List<IGameObject> objects) {
		IGameView bar_num;
		if (viewmode_type1 == 1) {
			bar_num = new StatusView(objects);
		} else {
			bar_num = new num_view(objects);
		}

		return bar_num;
	}

	@Override
	public IGameController createController(int interval, List<IGameObject> objects, List<IGameView> views) {
		return new GameController(interval, objects, views);
	}
}
