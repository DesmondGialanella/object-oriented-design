
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

class num_view extends JPanel implements IGameView {
	private JLabel num_bar;
	private JLabel timealive = new JLabel();

	private JLabel m_status = new JLabel();
	private IGameObject hero;
	List<IGameObject> m_objects;
	private int ticks = 0;
	private boolean stop = true;
	private AudioClip endingsong;
	private AudioClip ingamesong;

	public num_view(List<IGameObject> objects) {
		m_objects = objects;
		setLayout(new BorderLayout());
		m_status.setText("");

		for (IGameObject obj : m_objects) {
			if (obj.getName().equals("Hero")) {
				hero = obj;
				ingamesong = Applet.newAudioClip(getClass().getResource("finn_rap_battle.wav"));
				ingamesong.loop();
				break;
			}
		}
		num_bar = new JLabel("100");
		add(num_bar, BorderLayout.CENTER);
		add(timealive, BorderLayout.EAST);
	}

	@Override
	public void tick() {
		if (hero.getalive()) {
			ticks++;
		} else {
			ingamesong.stop();
		}

		if (hero.getalive() == false && stop) {
			endingsong = Applet
					.newAudioClip(getClass().getResource("Adventure_Time_-_Everything_Stays_Instrumental_.wav"));

			endingsong.play();
			stop = false;
		}

		
		timealive.setText("TIME ALIVE = " + ticks / 30 + " SECONDS");
		num_bar.setText("POWER COOL DOWN = " + Integer.toString(hero.gettime()));
		if (m_objects.size() > 1) {
			if (hero.gettime() < 0) {
				num_bar.setText("POWER COOL DOWN = 0");
			}

		}
		
		if(hero.getalive()==false) {
			timealive.setText("GAME OVER!                                                     TIME ALIVE = " + ticks / 30 + " SECONDS");

		}
	}

	@Override
	public JPanel getJPanel() {
		return this;
	}
}
