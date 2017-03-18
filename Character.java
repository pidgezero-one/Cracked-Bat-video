import java.awt.*;
public class Character {
	int height = 0;
	int width = 0;
	Image nw1, nw2, ne1, ne2, n1, n2, w1, w2, e1, e2, sw1, sw2, se1, se2, s1, s2;
	char dir = ('0');
	
	
	public Character (Image a, Image b, Image c, Image d, Image e, Image f, Image g, Image h, Image i, Image j, Image k, Image l, Image m, Image n, Image o, Image p) {
		s1 = a;
		s2 = b;
		sw1 = c;
		sw2 = d;
		w1 = e;
		w2 = f;
		nw1 = g;
		nw2 = h;
		n1 = i;
		n2 = j;
		ne1 = k;
		ne2 = l;
		e1 = m;
		e2 = n;
		se1 = o;
		se2 = p;
		
	}
	
	void setDir (char c) {
		dir = c;
	}
	
	Image south (int i) {
		if (i == 0)
			return s1;
		else
			return s2;
	}
	
	Image southwest (int i) {
		if (i == 0)
			return sw1;
		else
			return sw2;
	}
	
	Image west (int i) {
		if (i == 0)
			return w1;
		else
			return w2;
	}
	
	Image northwest (int i) {
		if (i == 0)
			return nw1;
		else
			return nw2;
	}
	
	Image north (int i) {
		if (i == 0)
			return n1;
		else
			return n2;
	}
	
	Image northeast (int i) {
		if (i == 0)
			return ne1;
		else
			return ne2;
	}
	
	Image east (int i) {
		if (i == 0)
			return e1;
		else
			return e2;
	}
	
	Image southeast (int i) {
		if (i == 0)
			return se1;
		else
			return se2;
	}
	
	
	Image getPic (int i) {
		if (dir == '0') {
			if (i == 0)
				return e1;
			else
				return e2;
		} else if (dir == '1') {
			if (i == 0)
				return se1;
			else
				return se2;
		} else if (dir == '2') {
			if (i == 0)
				return s1;
			else
				return s2;
		} else if (dir == '3') {
			if (i == 0)
				return sw1;
			else
				return sw2;
		} else if (dir == '4') {
			if (i == 0)
				return w1;
			else
				return w2;
		} else if (dir == '5') {
			if (i == 0)
				return nw1;
			else
				return nw2;
		} else if (dir == '6') {
			if (i == 0)
				return n1;
			else
				return n2;
		} else if (dir == '7') {
			if (i == 0)
				return ne1;
			else
				return ne2;
		} else {
			return null;
		}
	}
	
}
