//DESMOND GIALANELLA 2017

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public static void main(String args[]) throws FileNotFoundException {
		JFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	public MainFrame() throws FileNotFoundException {
		super("Game Engine Example");
		setSize(800, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int interval = 34;

		// model
		List<IGameObject> objects = new ArrayList<IGameObject>();
		objects.add(Factory.getInstance().createEnemy(10, 10, 50, 50, 5, 5));
		objects.add(Factory.getInstance().createEnemy2(10, 10, 50, 50, 5, 7));

		objects.add(Factory.getInstance().createHero(objects, 400, 200, 40, 40, 5, 5));

		// view
		IGameView view = Factory.getInstance().createMainView(objects);
		IGameView statusView = Factory.getInstance().createStatusView(objects);
		List<IGameView> views = new ArrayList<IGameView>();
		views.add(view);
		views.add(statusView);

		// controller
		IGameController controller = Factory.getInstance().createController(interval, objects, views);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(view.getJPanel(), BorderLayout.CENTER);
		getContentPane().add(statusView.getJPanel(), BorderLayout.SOUTH);

		controller.startGame();

	}
}
