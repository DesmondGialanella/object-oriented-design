
public class enemy2_red extends GameObject {
	private int m_ticks;
	private java.util.Random m_rand = new java.util.Random();
	private int speed = 40;

	public enemy2_red(int x, int y, int w, int h, int dX, int dY) {
		super("./redball.png", x, y, w, h, dX, dY);
	}

	@Override
	public void tick(int maxw, int maxh) {
		m_ticks++;
		if (m_ticks % speed == 0) {
			m_x = m_rand.nextInt(maxw);
			m_y = m_rand.nextInt(maxh);
		}

		if (m_ticks % 100 == 0) {
			if (speed > 10) {
				speed = speed - 5;
			}
		}
		if (m_ticks % 30 == 0) {
			int xz = m_rand.nextInt(10);
			if (xz == 1)
				m_dX = m_dX * -1;
		}
		if (m_ticks % 30 == 0) {
			int xxz = m_rand.nextInt(10);
			if (xxz == 1)
				m_dY = m_dY * -1;
		}

		m_x = m_x + m_dX;
		m_y = m_y + m_dY;

		if (m_x > maxw)
			m_x = 0;
		else if (m_x < 0)
			m_x = maxw;

		if (m_y > maxh)
			m_y = 0;
		else if (m_y < 0)
			m_y = maxh;

	}

}