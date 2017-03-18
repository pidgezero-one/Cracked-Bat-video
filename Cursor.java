import java.awt.Image;


public class Cursor {
	Image c1, c2;
	
	public Cursor (Image a, Image b){
		c1 = a;
		c2 = b;
	}
	
	Image get (int i) {
		if (i == 0)
			return c1;
		else
			return c2;
	}
}
