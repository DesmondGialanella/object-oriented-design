import java.util.ArrayList;
import java.util.List;

public class hero3_iceball extends GameObject {
	private int m_ticks = 0;
	private boolean teleport = false;
	private boolean inbounds = true;
	private int firsthit = 0;
	private boolean smaller = false;
	private java.util.Random m_rand = new java.util.Random();

	public hero3_iceball(int x, int y, int w, int h, int dX, int dY) {
		super("./iceball.png", x, y, w, h, 0, 0);
		setName("Hero");
	}

	@Override
	public void tick(int maxw, int maxh) {
		m_timer--;
		m_ticks++;
		if (teleport && m_timer < 0) {
			m_timer = 140;
			teleport = false;
		}
		if (m_timer <= 6) {
			smaller = false;
			m_w = 35;
			m_h = 35;
		}
		if (m_timer <= 5) {
			m_w = 30;
			m_h = 30;
		}
		if (m_timer <= 4) {
			m_w = 25;
			m_h = 25;
		}
		if (m_timer <= 2) {
			m_w = 40;
			m_h = 40;
		}
		///////////////// smaller\/
		if (m_timer == 140 && smaller) {
			m_w = 35;
			m_h = 35;
		}
		if (m_timer == 139 && smaller) {
			m_w = 30;
			m_h = 30;
		}
		if (m_timer == 138 && smaller) {
			m_w = 20;
			m_h = 20;
		}
		if (m_timer <= 137 && smaller) {
			m_w = 10;
			m_h = 10;
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
					inbounds = false;
					alive = false;

					m_x = -1000;
					m_y = -1000;
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
			smaller = true;
			System.out.println(m_timer);
		}

	}

}