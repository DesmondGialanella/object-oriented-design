public class enemy1_purple extends GameObject {
	private int m_ticks;
	private java.util.Random m_rand = new java.util.Random();
	private int speed = 1;

	public enemy1_purple(int x, int y, int w, int h, int dX, int dY) {
		super("./purpleball.png", x, y, w, h, dX, dY);
	}

	@Override
	public void tick(int maxw, int maxh) {
		m_ticks++;

		if (m_ticks % 60 == 0 && m_ticks < 600) {
			m_dX *= 1.2;
			m_dY *= 1.2;

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

		
		if (m_x <= 0)
			m_dX = m_dX * -1;

		if (m_y <= 0)
			m_dY = m_dY * -1;

		if (m_x >= (maxw - (m_w + 10)))
			m_dX = m_dX * -1;

		if (m_y >= (maxh - (m_h + 5)))
			m_dY = m_dY * -1;

	}

}