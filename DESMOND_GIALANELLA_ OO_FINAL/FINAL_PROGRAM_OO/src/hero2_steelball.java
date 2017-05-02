import java.util.ArrayList;
import java.util.List;

public class hero2_steelball extends GameObject {
	private int m_ticks = 0;
	private boolean teleport = false;
	private boolean inbounds = true;
	private int firsthit = 0;
	private boolean invinc = false;

	private java.util.Random m_rand = new java.util.Random();

	public hero2_steelball(int x, int y, int w, int h, int dX, int dY) {

		super("./steelball.png", x, y, w, h, 0, 0);
		setName("Hero");

	}

	@Override
	public void tick(int maxw, int maxh) {
		m_timer--;
		m_ticks++;

		if (teleport && m_timer < 0) {
			m_timer = 140;
			teleport = false;
			invinc = true;
		}
		if (m_timer < 0) {
			invinc = false;
		}

		m_x += m_dX;
		m_y += m_dY;

		if (inbounds) {
			if (m_x > maxw)
				m_x = 0;
			else if (m_x < 0)
				m_x = maxw;

			if (m_y > maxh)
				m_y = 0;
			else if (m_y < 0)
				m_y = maxh;
		}

		for (IGameObject obj : m_enemylist) {
			if (getRectangle().intersects(obj.getRectangle()) && obj != this) {
				if (firsthit == 0) {
					m_x = 400;
					m_y = 325;
				}
				if (firsthit >= 1) {
					if (invinc == false) {
						inbounds = false;
						alive = false;

						m_x = -1000;
						m_y = -1000;
					}

				}
				firsthit++;
			}
		}
	}

	@Override
	public void keyPressed(char ch) {

		if (ch == 'a') {
			m_dX = -5;
			m_dY = 0;
		}
		if (ch == 'd') {
			m_dX = 5;
			m_dY = 0;
		}
		if (ch == 'w') {
			m_dX = 0;
			m_dY = -5;
		}
		if (ch == 's') {
			m_dX = 0;
			m_dY = 5;
		}

		if (ch == ' ' && m_timer < 0 && inbounds == true) {
			teleport = true;
			System.out.println(m_timer);
		}

	}

}