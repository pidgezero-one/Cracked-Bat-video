import java.awt.*;


public class Crow {

	Image sit, fly1, fly2;

	public Crow (Image a, Image b, Image c) {
		sit = a;
		fly1 = b;
		fly2 = c;
	}

	Image sit () {
		return sit;
	}

	Image fly (int i) {
		if (i == 0)
			return fly1;
		else
			return fly2;
	}

}
