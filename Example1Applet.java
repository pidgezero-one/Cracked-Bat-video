import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;


public class Example1Applet extends java.applet.Applet implements Runnable {

	public void main(String[]args) {
		init();
		start();
		run();
	}
	
	private static final long serialVersionUID = 1L;
	boolean loading = true;
	int frame, bframe;
	Thread animator;
	public static int x = 100, y = 0;
	int[][] path = new int[10000][2];
	int[][] batpath = new int [999][2];
	char[] direction = new char[10000];
	public static Image pidges1, pidges2, pidgesw1, pidgesw2, pidgew1, pidgew2, pidgenw1, pidgenw2, pidgen1, pidgen2, pidgene1, pidgene2, pidgee1, pidgee2, pidgese1, pidgese2;
	public static Image wwls1, wwls2, wwlsw1, wwlsw2, wwlw1, wwlw2, wwlnw1, wwlnw2, wwln1, wwln2, wwlne1, wwlne2, wwle1, wwle2, wwlse1, wwlse2;
	public static Image houses1, houses2, housesw1, housesw2, housew1, housew2, housenw1, housenw2, housen1, housen2, housene1, housene2, housee1, housee2, housese1, housese2;
	public static Image tomeks1, tomeks2, tomeksw1, tomeksw2, tomekw1, tomekw2, tomeknw1, tomeknw2, tomekn1, tomekn2, tomekne1, tomekne2, tomeke1, tomeke2, tomekse1, tomekse2;
	public static Image onettmap;
	public static Image speechbox, dot;
	public static Image crowsit, crowfly1, crowfly2, spitefulcrow, bat1, bat2;
	public static Image pidgebar, wwlbar, housebar, tomekbar;
	public static Image battlebox, pidgemenu, wwlmenu, housemenu, tomekmenu, tomekitems, housepsi, housepsicost1, housepsicost2;
	public static Image cursor1, cursor2, omega, money, end;
	public static Image sparkyhouse, sparkys, sparkyn, sparkye, sparkyw, dark;
	public static Image menumain, menuequips, menuweapons, menustats, menustats2, where, who, which, arrows1, arrows2;
	public char dir = '0';
	Character pidge, wwl, house, tomek;
	Crow crow;
	public static Image[] gray = new Image[23];
	Cursor c;
	public static Image row;
	Color[] bckgd = new Color[14];
	public static BufferedImage bs = new BufferedImage (256, 224, BufferedImage.TYPE_INT_RGB);
	public static Graphics2D gd;
	BufferedImage board = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);


	public void init() {

		setSize(256,224);

		int i = 0;
		while (i < 65) {
			if (i < 16) {
				path[i][0] = 219;
				path[i][1] = 405 + i;
				direction[i] = '2';
			}
			else if (i < 65){
				path[i][0] = 219 + (i - 16);
				path[i][1] = 421;
				direction[i] = '0';
			}
			i++;
		}
		for (int j = 0; j <= 48; j++) {
			path[266+j][0] = path[16+j][0];
			path[266+j][1] = path[16+j][1];
			direction[266+j] = '0';
		}
		for (int j = 0; j < 203; j++) {
			path[314+j][0] = 267+j;
			path[314+j][1] = 421;

			direction[314+j] = '0';
		}
		for (int j = 0; j < 113; j++) {
			path[517+j][0] = 470+j;
			path[517+j][1] = 421-j;
			direction[517+j] = '7';
		}
		for (int k = 0; k <54; k++) {
			path[2564+k][0] = path[570+k][0];
			path[2564+k][1] = path[570+k][1];
			direction[2564+k] = direction[570+k];
		}
		for (int k = 0; k < 17; k++) {
			path[2616+k][0] = path[2616+(k-1)][0]+1;
			path[2616+k][1] = path[2616+(k-1)][1];
			direction[2616+k] = '0';
		}
		for (int k = 0; k < 91; k++) {
			path[2633+k][0] = path[2633+(k-1)][0]-1;
			path[2633+k][1] = path[2633+(k-1)][1]+1;
			direction[2633+k] = '3';
		}
		for (int k = 0; k < 430; k++) {
			path[2723+k][0] = path[2723+(k-1)][0]+1;
			path[2723+k][1] = path[2723+(k-1)][1];
			direction[2723+k] = '0';
		}
		for (int k = 0; k < 16; k++) {
			path[3153+k][0] = path[3153+(k-1)][0];
			path[3153+k][1] = path[3153+(k-1)][1]-1;
			direction[3153+k] = '6';
		}
		for (int k = 0; k < 51; k++) {
			path[3169+k][0] = path[3169+(k-1)][0];
			path[3169+k][1] = path[3169+(k-1)][1];
			direction[3169+k] = '6';
		}
		for (int k = 0; k < 49; k++) {
			path[3564+k][0] = 931;
			path[3564+k][1] = 391;
			direction[3564+k] = '2';
		}
		for (int k = 0; k < 5; k++) {
			path[3613+k][0] = path[3613+(k-1)][0];
			path[3613+k][1] = path[3613+(k-1)][1] + 1;
			direction[3613+k] = '2';
		}
		for (int k = 0; k < 100; k++) {
			path[3618+k][0] = path[3618+(k-1)][0]-1;
			path[3618+k][1] = path[3618+(k-1)][1];
			direction[3618+k] = '4';
		}
		for (int k = 0; k < 20; k++) {
			batpath[k][0] = 828-16;
			batpath[k][1] = 399 - k/2;			
		}
		for (int k = 0; k < 75; k++) {
			batpath[(20+k)][0] = batpath[(20+k-1)][0]+1;
			batpath[(20+k)][1] = batpath[(20+k-1)][1];			
		}
		for (int k = 0; k < 90; k++) {
			batpath[(95+k)][0] = batpath[(94)][0]+((int)(20 * Math.cos(Math.toRadians(270+k*4))));
			batpath[(95+k)][1] = batpath[(94)][1]-(20+(int)(20 * Math.sin(Math.toRadians(270+k*4))));
		}
		for (int k = 0; k < 90; k++) {
			batpath[(185+k)][0] = batpath[(184+k)][0]-3;
			batpath[(185+k)][1] = batpath[(184+k)][1]-3;
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		try {
			pidges1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-south1.gif"));
			pidges2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-south2.gif"));
			pidgesw1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-southwest1.gif"));
			pidgesw2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-southwest2.gif"));
			pidgew1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-west1.gif"));
			pidgew2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-west2.gif"));
			pidgenw1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-northwest1.gif"));
			pidgenw2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-northwest2.gif"));
			pidgen1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-north1.gif"));
			pidgen2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-north2.gif"));
			pidgene1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-northeast1.gif"));
			pidgene2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-northeast2.gif"));
			pidgee1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-east1.gif"));
			pidgee2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-east2.gif"));
			pidgese1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-southeast1.gif"));
			pidgese2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/pidge-southeast2.gif"));
			wwls1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-south1.gif"));
			wwls2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-south2.gif"));
			wwlsw1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-southwest1.gif"));
			wwlsw2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-southwest2.gif"));
			wwlw1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-west1.gif"));
			wwlw2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-west2.gif"));
			wwlnw1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-northwest1.gif"));
			wwlnw2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-northwest2.gif"));
			wwln1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-north1.gif"));
			wwln2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-north2.gif"));
			wwlne1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-northeast1.gif"));
			wwlne2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-northeast2.gif"));
			wwle1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-east1.gif"));
			wwle2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-east2.gif"));
			wwlse1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-southeast1.gif"));
			wwlse2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/wwl-southeast2.gif"));
			houses1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-south1.gif"));
			houses2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-south2.gif"));
			housesw1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-southwest1.gif"));
			housesw2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-southwest2copy.gif"));
			housew1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-west1.gif"));
			housew2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-west2.gif"));
			housenw1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-northwest1.gif"));
			housenw2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-northwest2.gif"));
			housen1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-north1.gif"));
			housen2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-north2.gif"));
			housene1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-northeast1.gif"));
			housene2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-northeast2.gif"));
			housee1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-east1.gif"));
			housee2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-east2.gif"));
			housese1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-southeast1.gif"));
			housese2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/house-southeast2.gif"));
			tomeks1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-south1.gif"));
			tomeks2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-south2.gif"));
			tomeksw1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-southwest1.gif"));
			tomeksw2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-southwest2.gif"));
			tomekw1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-west1.gif"));
			tomekw2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-west2.gif"));
			tomeknw1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-northwest1.gif"));
			tomeknw2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-northwest2.gif"));
			tomekn1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-north1.gif"));
			tomekn2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-north2.gif"));
			tomekne1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-northeast1.gif"));
			tomekne2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-northeast2.gif"));
			tomeke1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-east1.gif"));
			tomeke2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-east2.gif"));
			tomekse1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-southeast1.gif"));
			tomekse2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/tomek-southeast2.gif"));
			onettmap = toolkit.getImage (new URL("http://i47.tinypic.com/2mme6v6.png"));
			speechbox = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/speechbox.gif"));
			dot = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/dot.gif"));
			crowsit = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/crow-sit.gif"));
			crowfly1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/crow-fly1.gif"));
			crowfly2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/crow-fly2.gif"));
			sparkyhouse = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/sparkyshouse.gif"));
			sparkys = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/sparky-south.gif"));
			sparkyn = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/sparky-north.gif"));
			sparkyw = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/sparky-west.gif"));
			sparkye = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/sparky-east.gif"));

			
			gray[0] = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/map-grey.gif"));
			for (int k = 1; k <= 22; k++) {
				String fname = "http://img.photobucket.com/albums/v314/pidgezero_one/sprites/map-grey" + k + ".gif";
				gray[k] = toolkit.getImage (new URL(fname));
			}
			pidgebar = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/bar-pidge.gif"));
			wwlbar = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/bar-wwl.gif"));
			housebar = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/bar-house.gif"));
			tomekbar = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/bar-tomek.gif"));
			battlebox = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/battle-words.gif"));
			pidgemenu = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/battlemenu-pidge.gif"));
			wwlmenu = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/battlemenu-wwl-1.gif"));
			housemenu = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/battlemenu-house.gif"));
			tomekmenu = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/battlemenu-tomek-1.gif"));
			tomekitems = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/itemmenu-tomek.gif"));
			housepsi = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/psimenu-house.gif"));
			housepsicost1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/psilupus-house.gif"));
			housepsicost2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/psiamerica-house.gif"));
			cursor1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/cursor1.gif"));
			cursor2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/cursor2.gif"));
			omega = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/OMEGA.gif"));
			money = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/money.gif"));
			spitefulcrow = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/spitefulcrow.gif"));
			bat1 = toolkit.getImage(new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/bat1.gif"));
			bat2 = toolkit.getImage(new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/bat2.gif"));
			menumain = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/menu-1.gif"));
			menuequips = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/menu-pidgeequips.gif"));
			menuweapons = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/menu-weapons.gif"));
			menustats = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/menu-pidgestats.gif"));
			menustats2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/menu-pidgestatsnew.gif"));
			who = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/menu-who.gif"));
			which = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/menu-which.gif"));
			where = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/menu-where.gif"));
			arrows1 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/menu-arrows.gif"));
			arrows2 = toolkit.getImage (new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/menu-arrows2.gif"));
			end = toolkit.getImage(new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/theend.gif"));
			row = toolkit.getImage(new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/row.gif"));
			dark = toolkit.getImage(new URL("http://img.photobucket.com/albums/v314/pidgezero_one/sprites/dark.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		pidge = new Character(pidges1, pidges2, pidgesw1, pidgesw2, pidgew1, pidgew2, pidgenw1, pidgenw2, pidgen1, pidgen2, pidgene1, pidgene2, pidgee1, pidgee2, pidgese1, pidgese2);
		wwl = new Character (wwls1, wwls2, wwlsw1, wwlsw2, wwlw1, wwlw2, wwlnw1, wwlnw2, wwln1, wwln2, wwlne1, wwlne2, wwle1, wwle2, wwlse1, wwlse2);
		house = new Character (houses1, houses2, housesw1, housesw2, housew1, housew2, housenw1, housenw2, housen1, housen2, housene1, housene2, housee1, housee2, housese1, housese2);
		tomek = new Character (tomeks1, tomeks2, tomeksw1, tomeksw2, tomekw1, tomekw2, tomeknw1, tomeknw2, tomekn1, tomekn2, tomekne1, tomekne2, tomeke1, tomeke2, tomekse1, tomekse2);
		crow = new Crow (crowsit, crowfly1, crowfly2);
		c = new Cursor (cursor1, cursor2);

		bckgd[0] = new Color(152,200,192);
		bckgd[1] = new Color(136,192,176);
		bckgd[2] = new Color(136,192,152);
		bckgd[3] = new Color(128,192,136);
		bckgd[4] = new Color(144,200,128);
		bckgd[5] = new Color(160,200,120);
		bckgd[6] = new Color(176,200,120);
		bckgd[7] = new Color(200,200,112);
		bckgd[8] = new Color(176,200,120);
		bckgd[9] = new Color(160,200,120);
		bckgd[10] = new Color(144,200,128);
		bckgd[11] = new Color(128,192,136);
		bckgd[12] = new Color(136,192,152);
		bckgd[13] = new Color(136,192,176);


		prepareImage(pidge.south(0),16,24,this);
		prepareImage(pidge.south(1),16,24,this);
		prepareImage(pidge.southwest(0),16,24,this);
		prepareImage(pidge.southwest(1),16,24,this);
		prepareImage(pidge.west(0),16,24,this);
		prepareImage(pidge.west(1),16,24,this);
		prepareImage(pidge.northwest(0),16,24,this);
		prepareImage(pidge.northwest(1),16,24,this);
		prepareImage(pidge.north(0),16,24,this);
		prepareImage(pidge.north(1),16,24,this);
		prepareImage(pidge.northeast(0),16,24,this);
		prepareImage(pidge.northeast(1),16,24,this);
		prepareImage(pidge.east(0),16,24,this);
		prepareImage(pidge.east(1),16,24,this);
		prepareImage(pidge.southeast(0),16,24,this);
		prepareImage(pidge.southeast(1),16,24,this);
		prepareImage(wwl.south(0),16,24,this);
		prepareImage(wwl.south(1),16,24,this);
		prepareImage(wwl.southwest(0),16,24,this);
		prepareImage(wwl.southwest(1),16,24,this);
		prepareImage(wwl.west(0),16,24,this);
		prepareImage(wwl.west(1),16,24,this);
		prepareImage(wwl.northwest(0),16,24,this);
		prepareImage(wwl.northwest(1),16,24,this);
		prepareImage(wwl.north(0),16,24,this);
		prepareImage(wwl.north(1),16,24,this);
		prepareImage(wwl.northeast(0),16,24,this);
		prepareImage(wwl.northeast(1),16,24,this);
		prepareImage(wwl.east(0),16,24,this);
		prepareImage(wwl.east(1),16,24,this);
		prepareImage(wwl.southeast(0),16,24,this);
		prepareImage(wwl.southeast(1),16,24,this);
		prepareImage(house.south(0),16,24,this);
		prepareImage(house.south(1),16,24,this);
		prepareImage(house.southwest(0),16,24,this);
		prepareImage(house.southwest(1),16,24,this);
		prepareImage(house.west(0),16,24,this);
		prepareImage(house.west(1),16,24,this);
		prepareImage(house.northwest(0),16,24,this);
		prepareImage(house.northwest(1),16,24,this);
		prepareImage(house.north(0),16,24,this);
		prepareImage(house.north(1),16,24,this);
		prepareImage(house.northeast(0),16,24,this);
		prepareImage(house.northeast(1),16,24,this);
		prepareImage(house.east(0),16,24,this);
		prepareImage(house.east(1),16,24,this);
		prepareImage(house.southeast(0),16,24,this);
		prepareImage(house.southeast(1),16,24,this);
		prepareImage(tomek.south(0),16,24,this);
		prepareImage(tomek.south(1),16,24,this);
		prepareImage(tomek.southwest(0),16,24,this);
		prepareImage(tomek.southwest(1),16,24,this);
		prepareImage(tomek.west(0),16,24,this);
		prepareImage(tomek.west(1),16,24,this);
		prepareImage(tomek.northwest(0),16,24,this);
		prepareImage(tomek.northwest(1),16,24,this);
		prepareImage(tomek.north(0),16,24,this);
		prepareImage(tomek.north(1),16,24,this);
		prepareImage(tomek.northeast(0),16,24,this);
		prepareImage(tomek.northeast(1),16,24,this);
		prepareImage(tomek.east(0),16,24,this);
		prepareImage(tomek.east(1),16,24,this);
		prepareImage(tomek.southeast(0),16,24,this);
		prepareImage(tomek.southeast(1),16,24,this);
		prepareImage(onettmap,1186,579,this);
		prepareImage(dot,3,4,this);
		prepareImage(speechbox,152,64,this);
		prepareImage(crowsit,16,24,this);
		prepareImage(crowfly1,16,24,this);
		prepareImage(crowfly2,16,24,this);
		for (int l = 0; l <= 22; l++) {
			prepareImage(gray[l],256,224,this);

		}
		prepareImage(pidgebar,56,64,this);
		prepareImage(wwlbar,56,64,this);
		prepareImage(housebar,56,64,this);
		prepareImage(tomekbar,56,64,this);
		prepareImage(battlebox,192,48,this);
		prepareImage(pidgemenu,168,48,this);
		prepareImage(wwlmenu,168,48,this);
		prepareImage(housemenu,168,48,this);
		prepareImage(tomekmenu,168,48,this);
		prepareImage(tomekitems,192,128,this);
		prepareImage(housepsi,216,64,this);
		prepareImage(housepsicost1,88,48,this);
		prepareImage(housepsicost2,88,48,this);
		prepareImage(cursor1,4,8,this);
		prepareImage(cursor2,4,8,this);
		prepareImage(omega,8,8,this);
		prepareImage(spitefulcrow,30,32,this);
		prepareImage(money,64,32,this);
		prepareImage(sparkyhouse,256,224,this);
		prepareImage(sparkyn,16,24,this);
		prepareImage(sparkys,16,24,this);
		prepareImage(sparkye,16,24,this);
		prepareImage(sparkyw,16,24,this);
		prepareImage(menumain,104,64,this);
		prepareImage(menuequips,104,64,this);
		prepareImage(menuweapons,104,128,this);
		prepareImage(menustats,120,48,this);
		prepareImage(menustats2,120,48,this);
		prepareImage(who,56,32,this);
		prepareImage(which,56,32,this);
		prepareImage(where,56,32,this);
		prepareImage(arrows1,20,10,this);
		prepareImage(arrows2,20,10,this);
		prepareImage(bat1,15,16,this);
		prepareImage(bat2,15,16,this);
		prepareImage(end,256,224,this);
		prepareImage(dark,256,224,this);

	}

	public void start() {
		animator = new Thread(this);
		animator.start();
		setSize(256,224);
	}

	public void run() {

		setSize(256,224);
		while (Thread.currentThread() == animator) {
			if (frame == 0) {
				repaint();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			loading = false;
			frame++;	
			if ((frame >= 631) && (frame <= 2287)) {
				bframe++;
				if (bframe == 112)
					bframe = 0;
			}

			if (frame == 4400)
				System.exit(0);
			repaint();

			if ((frame >= 0 && frame <= 64) || (frame >= 66 && frame <= 73) || (frame >= 110 && frame <= 162)|| (frame >= 165 && frame <= 171) || (frame >= 173 && frame <= 181) || (frame >= 183 && frame <= 233) || (frame >= 236 && frame <= 260) || (frame >= 264 && frame <= 305) || (frame >= 314 && frame <= 617) || (frame >= 642 && frame <= 2255) || (frame >= 2278 && frame <= 2280) || (frame >= 2282 && frame <= 2291) || (frame >= 2293 && frame <= 2316) || (frame >= 2319 && frame <= 2368) || (frame >= 2371 && frame <= 2376) || frame == 2378 || (frame >= 2380 && frame <= 2408) || (frame >= 2410 && frame <= 2414) || (frame >= 2416 && frame <= 2420) || (frame >= 2422 && frame <= 2476) && (frame >= 2479 && frame <= 2492) || (frame >= 2494 && frame <= 2517) || frame == 2519 || (frame >= 2522 && frame <= 2551) || (frame >= 2533 && frame <= 2570) || (frame >= 2573 && frame <= 2592) || (frame >= 2612 && frame <= 3198) || (frame >= 3219 && frame <= 3250) || (frame >= 3252 && frame <= 3277) || (frame >= 3279 && frame <= 3303) || (frame >= 3306 && frame <= 3359) || (frame >= 3362 && frame <= 3376) || (frame >= 3381 && frame <= 3433) || (frame >= 3436 && frame <= 3467) || (frame >= 3471 && frame <= 3496) || (frame >= 3499 && frame <= 3502) || (frame >= 3504 && frame <= 3521) || (frame >= 3524 || frame <= 3543) || (frame >= 3545 && frame <= 3591) || (frame >= 3612 && frame <= 3756) || (frame >= 3758 && frame <= 3761) || (frame >= 3763 && frame <= 3785) && (frame >= 3899 && frame <= 3902) || (frame >= 3905 && frame <= 4273) || (frame >= 4275 && frame <= 4277) || (frame >= 4285 && frame <= 4293) || (frame >= 4295 && frame <= 4356) || (frame > 4359)) {
				try {
					Thread.sleep(10);
				}
				catch (Exception e) {
				}
			}
			if ((frame >= 619 && frame <= 640) || (frame >= 2255 && frame <= 2266) || (frame >= 2268 && frame <= 2276) || (frame >= 3199 && frame <= 3208) || (frame >= 3210 && frame <= 3217) || frame == 3435 || (frame >= 3591 && frame <= 3601) || (frame >= 3603 && frame <= 3610) || (frame >= 3787 && frame <= 3898)) {
				try {
					Thread.sleep(15);
				}
				catch (Exception e) {
				}
			}
			if (frame == 65 || frame == 74 || (frame >= 107 && frame <= 109) || frame == 163 || frame == 164 || frame == 172 || frame == 182 || frame == 234 || frame == 235 || (frame >= 261 && frame <= 263) || (frame >= 306 && frame <= 314) || frame == 618 || frame == 641 || frame == 2267 || frame == 3377 || frame == 2281 || frame == 2292 || frame == 2317 || frame == 2318 || frame == 2369 || frame == 2370 || frame == 2377 || frame == 2409 || frame == 2415 || frame == 2421 || frame == 2477 || frame ==  2478 || frame == 2493 || frame == 2518 || frame == 2520 || frame == 2521 || frame == 2552 || frame == 2571 || frame == 2572 || frame == 2593 || frame == 2594 || frame == 3209 || frame == 3218 || frame == 3251 || frame == 3278 || frame == 3304 || frame == 3305 || frame == 3360 || frame == 3361 || (frame >= 3377 && frame <= 3380) || frame == 3434 || (frame >= 3468 && frame <= 3470) || frame == 3497 || frame == 3498 || frame == 3504 || frame == 3522 || frame == 3523 || frame == 3544 || frame == 3602 || frame == 3611 || frame == 3757 || frame == 3762 || frame == 3786 || frame == 3903 || frame == 3904 || frame == 4274 || (frame >= 4278 && frame <= 4282) || frame == 4284 || frame == 4294 || frame == 4357) {
				try {
					Thread.sleep(1000);
				}
				catch (Exception e) {
				}
			}
			if (frame == 2379 || frame == 4283 || frame == 4358) {
				try {
					Thread.sleep(2000);
				}
				catch (Exception e) {
				}
			}
		}

	}
	public void paint (Graphics g) {
		update(g);
		setSize(256,224);
	}

	public void update(Graphics g) {
		setSize(256,224);
		bs = (BufferedImage) this.createImage(256, 224);
		gd = bs.createGraphics();
		if (loading) {
			g.drawString("LOADING LOL",50,50);
			g.drawString("PLZ WAIT 10 SECONDS THX",50,75);
			g.drawString("-love, pidge",50,90);


		}

		else {


			board = (BufferedImage) this.createImage(1186, 579);
			Graphics2D gc = board.createGraphics();
			//gc.setColor(Color.white);
			//gc.fillRect(0, 0, 400, 400); // fill in background
			gc.setColor(Color.black);
			Font f = new Font("Apple Kid",Font.PLAIN,16);
			gc.setFont(f);

			//gc.drawString("Just like your mom, you never want to stop.", 140, 140);
			//gc.drawImage ints: x1(applet), y1(applet), x2(applet), y2(applet), x1(image), y1(image), x2(image), y2(image)

			//gc.drawImage(onettmap, 0, 0, 256, 224, path[frame][0]-122, path[frame][1]-97, 134+path[frame][0], 127+path[frame][1], this);
			gc.drawImage(onettmap, 0, 0, 1186, 579, this);
			//while ()
			if (frame < 65) {
				if (frame >= 48) {
					tomek.setDir(direction[frame-48]);
					gc.drawImage(tomek.getPic(((frame - 48) / 10) % 2), path[frame-48][0], path[frame-48][1], 16, 24, this);
				} else
					gc.drawImage(tomek.south(0), path[0][0], path[0][1], 16, 24, this);
				if (frame >= 32) {
					house.setDir(direction[frame-32]);
					gc.drawImage(house.getPic(((frame - 32) / 10) % 2), path[frame-32][0], path[frame-32][1], 16, 24, this);
				} else
					gc.drawImage(house.south(0), path[0][0], path[0][1], 16, 24, this);
				if (frame >= 16) {
					wwl.setDir(direction[frame-16]);
					gc.drawImage(wwl.getPic(((frame - 16) / 10) % 2), path[frame-16][0], path[frame-16][1], 16, 24, this);
				} else
					gc.drawImage(wwl.south(0), path[0][0], path[0][1], 16, 24, this);

				pidge.setDir(direction[frame]);
				gc.drawImage(pidge.getPic((frame / 10) % 2), path[frame][0], path[frame][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[frame][0]-122, path[frame][1]-97, 134+path[frame][0], 127+path[frame][1], this);
			}
			else if (frame == 65) {
				pidge.setDir('4');
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.getPic(0), path[64][0], path[64][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);

			}
			if ((frame > 65) && (frame <= 74)) {
				int s1pos = (frame - 66);
				String s1 = "Aw yeah!";
				pidge.setDir('4');
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.getPic(0), path[64][0], path[64][1], 16, 24, this);
				gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+13, 3, 4, this);
				gc.drawString((String)s1.subSequence(0, s1pos), path[64][0]-122+96+14, path[64][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);

			}
			if (frame > 74 && frame < 108) {
				int s2pos = (frame - 75);
				String s2 = "I finally got the \"Kickass bat\"!";
				pidge.setDir('4');
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.getPic(0), path[64][0], path[64][1], 16, 24, this);
				gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+13, 3, 4, this);
				gc.drawString("Aw yeah!", path[64][0]-122+96+14, path[64][1]-97+7+19);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+29, 3, 4, this);
				gc.drawString((String)s2.subSequence(0, s2pos), path[64][0]-122+96+14, path[64][1]-97+7+35);

				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);

			}

			else if (frame == 108) {
				pidge.setDir('4');
				gc.drawImage(tomek.south(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.getPic(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);

			}

			if (frame == 109) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.getPic(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);

			}
			if (frame > 109 && frame <= 142) {
				int spos = (frame - 110);
				String s = "Was eet really worth selling all";
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.getPic(0), path[64][0], path[64][1], 16, 24, this);
				gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+13, 3, 4, this);
				gc.drawString((String)s.subSequence(0, spos), path[64][0]-122+96+14, path[64][1]-97+7+19);

				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);

			}
			if (frame > 142 && frame <= 163) {
				int spos = (frame - 143);
				String s = "Was eet really worth selling all";
				String s2 = "your equeeps, Pidge?";
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.getPic(0), path[64][0], path[64][1], 16, 24, this);
				gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[64][0]-122+96+14, path[64][1]-97+7+19);
				gc.drawString((String)s2.subSequence(0, spos), path[64][0]-122+96+14, path[64][1]-97+7+35);
				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);

			}
			if (frame == 164) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.east(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame > 164 && frame <= 182) {
				int pos = (frame - 165);
				String s = ("Well... Probably!");
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				if (frame > 172) {
					gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);
				}
				else {
					gc.drawImage(pidge.east(0), path[64][0], path[64][1], 16, 24, this);
				}

				gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+13, 3, 4, this);
				gc.drawString((String)s.subSequence(0, pos), path[64][0]-122+96+14, path[64][1]-97+7+19);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame > 182 && frame <= 213) {
				int spos = (frame - 183);
				String s = "Well... Probably!";
				String s2 = "It's gotta be called \"Kickass\"";
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);
				gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[64][0]-122+96+14, path[64][1]-97+7+19);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+29, 3, 4, this);
				gc.drawString((String)s2.subSequence(0, spos), path[64][0]-122+96+14, path[64][1]-97+7+35);
				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);

			}
			if (frame > 213 && frame <= 234) {
				int spos = (frame - 214);
				String s = "Well... Probably!";
				String s2 = "It's gotta be called \"Kickass\"";
				String s3 = "for a reason, right?";
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.getPic(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);
				gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[64][0]-122+96+14, path[64][1]-97+7+19);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+29, 3, 4, this);
				gc.drawString(s2, path[64][0]-122+96+14, path[64][1]-97+7+35);
				gc.drawString((String)s3.subSequence(0,spos), path[64][0]-122+96+14, path[64][1]-97+7+51);
				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);

			}
			if (frame == 235) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.east(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.south(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame > 235 && frame <= 261) {
				String s = "so what do we do now? lol";
				int pos = frame - 236;
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.east(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.south(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);
				gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+13, 3, 4, this);
				gc.drawString((String)s.subSequence(0, pos), path[64][0]-122+96+14, path[64][1]-97+7+19);

				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame == 262) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.south(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.south(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame == 263) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.south(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.west(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame > 263 && frame <= 288) {
				String s = "Let's go beat things up, ";
				int pos = frame - 264;
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.south(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.west(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+13, 3, 4, this);
				gc.drawString((String)s.subSequence(0, pos), path[64][0]-122+96+14, path[64][1]-97+7+19);

				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame > 288 && frame <= 306) {
				String s = "America-style! :D";
				int pos = frame - 289;
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.south(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.west(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.drawImage(speechbox, path[64][0]-122+96, path[64][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[64][0]-122+96+9, path[64][1]-97+7+13, 3, 4, this);
				gc.drawString("Let's go beat things up, ", path[64][0]-122+96+14, path[64][1]-97+7+19);
				gc.drawString((String)s.subSequence(0, pos), path[64][0]-122+96+14, path[64][1]-97+7+35);

				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);

			}
			if (frame == 307) {
				gc.drawImage(tomek.southeast(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.south(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.west(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}if (frame == 308) {
				gc.drawImage(tomek.southeast(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.south(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.southwest(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.south(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame == 309) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.south(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.south(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame == 310) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.south(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.east(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame == 311) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.south(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.west(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame == 312) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.west(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.west(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame == 313) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.east(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.east(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.west(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame == 314) {
				gc.drawImage(tomek.east(0), path[16][0], path[16][1], 16, 24, this);
				gc.drawImage(house.east(0), path[32][0], path[32][1], 16, 24, this);
				gc.drawImage(wwl.east(0), path[48][0], path[48][1], 16, 24, this);
				gc.drawImage(pidge.east(0), path[64][0], path[64][1], 16, 24, this);


				g.drawImage(board, 0, 0, 256, 224, path[64][0]-122, path[64][1]-97, 134+path[64][0], 127+path[64][1], this);
			}
			if (frame > 314 && frame <= 618) {
				int crowcoord = frame % 581;
				tomek.setDir(direction[frame-48]);
				house.setDir(direction[frame-32]);
				wwl.setDir(direction[frame-16]);
				pidge.setDir(direction[frame]);
				if (frame < 581) {
					gc.drawImage(crow.sit(), 612, 280, 16, 24, this);
				}
				else {
					gc.drawImage(crow.fly(((frame - 10) / 10) % 2), 612 - crowcoord, 280 + crowcoord, 16, 24, this);
				}
				gc.drawImage(tomek.getPic(((frame-5 - 48) / 10) % 2), path[frame-48][0], path[frame-48][1], 16, 24, this);
				gc.drawImage(house.getPic(((frame-10 - 32) / 10) % 2), path[frame-32][0], path[frame-32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(((frame-10 - 16) / 10) % 2), path[frame-16][0], path[frame-16][1], 16, 24, this);
				gc.drawImage(pidge.getPic(((frame-10 ) / 10) % 2), path[frame][0], path[frame][1], 16, 24, this);

				g.drawImage(board, 0, 0, 256, 224, path[frame][0]-122, path[frame][1]-97, 134+path[frame][0], 127+path[frame][1], this);


			}
			if (frame > 618 && frame <= 641) {
				int index = frame - 619;
				g.drawImage(gray[index],0,0,256,224,this);

			}
			if (frame > 641 && frame <= 651) {
				gd.drawImage(gray[22],0,0,256,224,this);
				for (int j = 0; j < frame - 641; j++)
					gd.drawImage(dark,0,0,256,224,this);
				g.drawImage(bs,0,0,256,224,this);
			}

			if (frame > 651 && frame < 2287)
				DrawBattleBackground();

			if (frame >651 && frame <= 661) {
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				for (int j = 0; j < 661 - frame; j++)
					gd.drawImage(dark,0,0,256,224,this);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 661 && frame <= 691) {
				int pos = frame - 662;
				String s = "You engage the Spiteful Crow.";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString((String)s.subSequence(0, pos), 47, 26);
				g.drawImage(bs,0,0,256,224, this);


			}
			if (frame > 691 && frame <= 791) {
				String s = "You engage the Spiteful Crow.";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				g.drawImage(bs,0,0,256,224, this);


			}
			if (frame == 792) {
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 792 && frame <= 811) {
				gd.drawImage(pidgebar,17,144,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(pidgemenu,9,8,168,48,this);
				if ((frame /4 )% 2 == 0) {
					gd.drawImage(cursor1,19,19,4,8,this);
				}
				else {
					gd.drawImage(cursor2,19,19,4,8,this);
				}
				g.drawImage(bs,0,0,256,224, this);


			}
			if (frame == 812) {
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 812 && frame <= 851) {
				int curpos = 19;
				if (frame > 826) {
					curpos = 67;
				}
				if (frame > 836) {
					curpos = 107;					
				}
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,144,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(wwlmenu,9,8,168,48,this);
				if ((frame /4 )% 2 == 0) {
					gd.drawImage(cursor1,curpos,19,4,8,this);
				}
				else {
					gd.drawImage(cursor2,curpos,19,4,8,this);
				}
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame == 852) {
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 852 && frame <= 871) {
				int curpos = 19;
				if (frame > 861)
					curpos = 35;
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,144,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(housemenu,9,8,168,48,this);
				if ((frame /4 )% 2 == 0) {
					gd.drawImage(cursor1,19,curpos,4,8,this);
				}
				else {
					gd.drawImage(cursor2,19,curpos,4,8,this);
				}
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 871 && frame <= 881) {
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,144,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(housemenu,9,8,168,48,this);
				gd.drawImage(housepsi,33,8,216,64,this);

				if ((frame /4 )% 2 == 0) {
					gd.drawImage(cursor1,43,19,4,8,this);
				}
				else {
					gd.drawImage(cursor2,43,19,4,8,this);
				}
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 881 && frame <= 931) {
				int curx = 179;
				int cury = 19;
				if (frame >891)
					cury = 35;
				if (frame >901)
					curx = 195;
				if (frame >911)
					curx = 211;
				if (frame >921)
					curx = 227;

				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,144,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(housemenu,9,8,168,48,this);
				gd.drawImage(housepsi,33,8,216,64,this);
				if (frame < 891)
					gd.drawImage(housepsicost1,9,25,88,48,this);
				else
					gd.drawImage(housepsicost2,9,25,88,48,this);

				if ((frame /4 )% 2 == 0) {
					gd.drawImage(cursor1,curx,cury,4,8,this);
				}
				else {
					gd.drawImage(cursor2,curx,cury,4,8,this);
				}
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame == 932) {
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 932 && frame <= 961) {
				int curpos = 19;
				if (frame > 946) {
					curpos = 67;
				}
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,144,56,64,this);
				gd.drawImage(tomekmenu,9,8,168,48,this);
				if ((frame /4 )% 2 == 0) {
					gd.drawImage(cursor1,curpos,19,4,8,this);
				}
				else {
					gd.drawImage(cursor2,curpos,19,4,8,this);
				}
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 961 && frame <= 1001) {
				int curx = 67;
				int cury = 19;
				if (frame > 981) {
					cury = 35;
				}
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,144,56,64,this);
				gd.drawImage(tomekmenu,9,8,168,48,this);
				gd.drawImage(tomekitems,57,8,192,128,this);
				if ((frame /4 )% 2 == 0) {
					gd.drawImage(cursor1,curx,cury,4,8,this);
				}
				else {
					gd.drawImage(cursor2,curx,cury,4,8,this);
				}
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1001 && frame <= 1013) {
				int pos = frame - 1002;
				String s = "House tried ";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,144,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString((String)s.subSequence(0, pos), 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1013 && frame <= 1026) {
				int pos = frame - 1014;
				String s = "House tried ";
				String s2 = "PSI AMERICA ";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,144,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				gd.drawString((String)s2.subSequence(0, pos), 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1026 && frame <= 1127) {
				String s = "House tried ";
				String s2 = "PSI AMERICA ";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,144,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				gd.drawString(s2, 47, 42);
				gd.drawImage(omega, 107, 34, 8, 8, this);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1127 && frame <= 1143) {
				int pos = frame - 1128;
				String s2 = "PSI AMERICA";
				String s3 = "It did not work ";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,144,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s2, 47, 26);
				gd.drawImage(omega, 107, 18, 8, 8, this);
				gd.drawImage(dot,42,37,3,4,this);
				gd.drawString((String)s3.subSequence(0, pos), 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1143 && frame <= 1165) {
				int pos = frame - 1144;
				String s3 = "It did not work ";
				String s4 = "on the Spiteful Crow!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,144,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawImage(dot,42,21,3,4,this);
				gd.drawString(s3, 47, 26);
				gd.drawString((String)s4.subSequence(0, pos), 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1165 && frame <= 1265) {
				String s3 = "It did not work ";
				String s4 = "on the Spiteful Crow!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,144,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawImage(dot,42,21,3,4,this);
				gd.drawString(s3, 47, 26);
				gd.drawString(s4, 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame == 1265) {
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1265 && frame <= 1280) {
				int pos = frame - 1266;
				String s = "WWL went MMMM!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,144,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString((String)s.subSequence(0, pos), 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1280 && frame <= 1380) {
				String s = "WWL went MMMM!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,144,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1380 && frame <= 1395) {
				int pos = frame - 1381;
				String s = "Pidge attacks!";
				gd.drawImage(pidgebar,17,144,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString((String)s.subSequence(0, pos), 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1395 && frame <= 1495) {
				String s = "Pidge attacks!";
				gd.drawImage(pidgebar,17,144,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1495 && frame <= 1513) {
				int pos = frame - 1496;
				String s = "Pidge attacks!";
				String s2 = "The Spiteful Crow ";
				gd.drawImage(pidgebar,17,144,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				gd.drawImage(dot,42,37,3,4,this);
				gd.drawString((String)s2.subSequence(0, pos), 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}

			if (frame > 1513 && frame <= 1529) {
				int pos = frame - 1514;
				String s = "The Spiteful Crow ";
				String s2 = "dodged quickly!";
				gd.drawImage(pidgebar,17,144,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				gd.drawString((String)s2.subSequence(0, pos), 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1529 && frame <= 1629) {
				String s = "The Spiteful Crow ";
				String s2 = "dodged quickly!";
				gd.drawImage(pidgebar,17,144,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				gd.drawString(s2, 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1629 && frame <= 1666) {
				int pos = frame - 1630;
				String s = "The Spiteful Crow stole a Kickass bat";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString((String)s.subSequence(0, pos), 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1666 && frame <= 1698) {
				int pos = frame - 1667;
				String s = "The Spiteful Crow stole a Kickass bat";
				String s2 = "in the confusion of the battle!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				gd.drawString((String)s2.subSequence(0, pos), 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1698 && frame <= 1798) {
				String s = "The Spiteful Crow stole a Kickass bat";
				String s2 = "in the confusion of the battle!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				gd.drawString(s2, 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1798 && frame <= 1819) {
				int pos = frame - 1799;
				String s = "Pidge: OH WHAT THE?!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString((String)s.subSequence(0, pos), 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1819 && frame <= 1889) {
				String s = "Pidge: OH WHAT THE?!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1889 && frame <= 1900) {
				int pos = frame - 1890;
				String s = "Tomek ate ";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,144,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString((String)s.subSequence(0, pos), 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1900 && frame <= 1920) {
				int pos = frame - 1901;
				String s = "Tomek ate ";
				String s2 = "the Polish Sausage.";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,144,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				gd.drawString((String)s2.subSequence(0, pos), 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 1920 && frame <= 2000) {
				String s = "Tomek ate ";
				String s2 = "the Polish Sausage.";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,144,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.drawImage(dot,42,21,3,4,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s, 47, 26);
				gd.drawString(s2, 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 2000 && frame <= 2016) {
				int pos = frame - 2001;
				String s2 = "the Polish Sausage.";
				String s3 = "Tomek's HP are ";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,144,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawString(s2, 47, 26);
				gd.drawImage(dot,42,37,3,4,this);
				gd.drawString((String)s3.subSequence(0, pos), 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 2016 && frame <= 2027) {
				int pos = frame - 2017;
				String s3 = "Tomek's HP are ";
				String s4 = "maxed out!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,144,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawImage(dot,42,21,3,4,this);
				gd.drawString(s3, 47, 26);
				gd.drawString((String)s4.subSequence(0, pos), 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 2027 && frame <= 2127) {
				String s3 = "Tomek's HP are ";
				String s4 = "maxed out!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,144,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawImage(dot,42,21,3,4,this);
				gd.drawString(s3, 47, 26);
				gd.drawString(s4, 47, 42);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 2127 && frame <= 2155) {
				int pos = frame - 2128;
				String s3 = "The Spiteful Crow ran away!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawImage(dot,42,21,3,4,this);
				gd.drawString((String)s3.subSequence(0, pos), 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 2155 && frame <= 2255) {
				String s3 = "The Spiteful Crow ran away!";
				gd.drawImage(pidgebar,17,152,56,64,this);
				gd.drawImage(wwlbar,73,152,56,64,this);
				gd.drawImage(housebar,129,152,56,64,this);
				gd.drawImage(tomekbar,185,152,56,64,this);
				gd.drawImage(battlebox,33,8,192,48,this);
				gd.setColor(Color.white);
				gd.setFont(f);
				gd.drawImage(dot,42,21,3,4,this);
				gd.drawString(s3, 47, 26);
				g.drawImage(bs,0,0,256,224, this);
			}
			if (frame > 2255 && frame <= 2266) {
				gd.setColor(bckgd[(bframe/4)%14]);
				gd.fillRect(0,0,256,224);
				gd.drawImage(row, 0-bframe*2, 60, 224, 22, this);
				gd.drawImage(row, 224-bframe*2, 60, 224, 22, this);
				gd.drawImage(row, 448-bframe*2, 60, 224, 22, this);
				gd.drawImage(row, 224+bframe*2, 97, 224, 22, this);
				gd.drawImage(row, 0+bframe*2, 97, 224, 22, this);
				gd.drawImage(row, -224+bframe*2, 97, 224, 22, this);
				gd.drawImage(row, -448+bframe*2, 97, 224, 22, this);
				gd.drawImage(row, 0-bframe*2, 129, 224, 22, this);
				gd.drawImage(row, 224-bframe*2, 129, 224, 22, this);
				gd.drawImage(row, 448-bframe*2, 129, 224, 22, this);
				for (int j = 0; j < frame - 2255; j++)
					gd.drawImage(dark,0,0,256,224,this);
				g.drawImage(bs,0,0,256,224, this);
			}


			if (frame > 2266 && frame <= 2277) {
				tomek.setDir(direction[618-48]);
				house.setDir(direction[618-32]);
				wwl.setDir(direction[618-16]);
				pidge.setDir(direction[618]);

				gc.drawImage(tomek.getPic(((618 - 48) / 10) % 2), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.getPic(((618 - 32) / 10) % 2), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(((618 - 16) / 10) % 2), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.getPic(((618) / 10) % 2), path[618][0], path[618][1], 16, 24, this);
				for (int j = 0; j < 2277 - frame; j++)
					gc.drawImage(dark,path[618][0]-122,path[618][1]-97,256,224,this);

				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2278) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.east(0), path[618][0], path[618][1], 16, 24, this);

				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2279) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southeast(0), path[618][0], path[618][1], 16, 24, this);

				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2280) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.south(0), path[618][0], path[618][1], 16, 24, this);

				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2281) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);

				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2281 && frame <= 2292) {
				String s = "It just...";
				int pos = frame - 2282;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString((String)s.subSequence(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2292 && frame <= 2317) {
				String s = "It just...";
				String s2 = "It just STOLE MY BAT! :(";
				int pos = frame - 2293;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[618][0]-122+96+14, path[618][1]-97+7+19);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+29, 3, 4, this);
				gc.drawString((String)s2.subSequence(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+35);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2318) {
				gc.drawImage(tomek.east(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2318 && frame <= 2346) {
				String s = "Why don't we just buy a new";
				int pos = frame - 2319;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2346 && frame <= 2369) {
				String s = "Why don't we just buy a new";
				String s2 = "one at ze drug sztore?";
				int pos = frame - 2347;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[618][0]-122+96+14, path[618][1]-97+7+19);
				gc.drawString(s2.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+35);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2370) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.south(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2370 && frame <= 2377) {
				String s = "hmm...";
				int pos = frame - 2371;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.south(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2378) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.south(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2379) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.south(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(money, path[618][0]-122+9, path[618][1]-97+80, 64, 32, this);
				gc.drawImage(pidgebar,path[618][0]-122+17,path[618][1]-97+152,56,64,this);
				gc.drawImage(wwlbar,path[618][0]-122+73,path[618][1]-97+152,56,64,this);
				gc.drawImage(housebar,path[618][0]-122+129,path[618][1]-97+152,56,64,this);
				gc.drawImage(tomekbar,path[618][0]-122+185,path[618][1]-97+152,56,64,this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);

			}
			if (frame == 2380) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.south(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2380 && frame <= 2409) {
				String s = "we ain't got enough money :P";
				int pos = frame - 2381;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.south(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2410) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.southwest(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2411) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.west(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2412) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northwest(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2413) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.north(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2414) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2415) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.east(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2415 && frame <= 2421) {
				String s = "Or...";
				int pos = frame - 2416;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.east(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2421 && frame <= 2450) {
				String s = "Or...";
				String s2 = "We could always grind until ";
				int pos = frame - 2422;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[618][0]-122+96+14, path[618][1]-97+7+19);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+29, 3, 4, this);
				gc.drawString(s2.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+35);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2450 && frame <= 2477) {
				String s = "Or...";
				String s2 = "We could always grind until ";
				String s3 = "we can afford another one?";
				int pos = frame - 2451;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[618][0]-122+96+14, path[618][1]-97+7+19);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+29, 3, 4, this);
				gc.drawString(s2, path[618][0]-122+96+14, path[618][1]-97+7+35);
				gc.drawString(s3.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+51);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2478) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.south(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2478 && frame <= 2493) {
				String s = "I dunno man...";
				int pos = frame - 2479;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.south(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2493 && frame <= 2518) {
				String s = "I dunno man...";
				String s2 = "I kinda need a weapon...";
				int pos = frame - 2494;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.south(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[618][0]-122+96+14, path[618][1]-97+7+19);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+29, 3, 4, this);
				gc.drawString(s2.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+35);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2519) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2520) {
				gc.drawImage(tomek.south(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2521) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2521) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2521 && frame <= 2544) {
				String s = "Why don't we go veesit";
				int pos = frame - 2522;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2544 && frame <= 2552) {
				String s = "Why don't we go veesit";
				String s2 = "Sparky?";
				int pos = frame - 2545;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[618][0]-122+96+14, path[618][1]-97+7+19);
				gc.drawString(s2.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+35);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame > 2552 && frame <= 2571) {
				String s = "Why don't we go veesit";
				String s2 = "Sparky?";
				String s3 = "Maybe he can help!";
				int pos = frame - 2553;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[618][0]-122+96+14, path[618][1]-97+7+19);
				gc.drawString(s2, path[618][0]-122+96+14, path[618][1]-97+7+35);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+45, 3, 4, this);
				gc.drawString(s3.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+51);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2572) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.southwest(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}

			if (frame > 2572 && frame <= 2593) {
				String s = "That's a great idea!";
				int pos = frame - 2573;
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.southwest(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.southwest(0), path[618][0], path[618][1], 16, 24, this);
				gc.drawImage(speechbox, path[618][0]-122+96, path[618][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(dot,path[618][0]-122+96+9, path[618][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0, pos), path[618][0]-122+96+14, path[618][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}
			if (frame == 2594) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.northeast(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);
			}

			if (frame > 2594 && frame <= 2612) {
				gc.drawImage(tomek.northeast(0), path[618-48][0], path[618-48][1], 16, 24, this);
				gc.drawImage(house.northeast(0), path[618-32][0], path[618-32][1], 16, 24, this);
				gc.drawImage(wwl.northeast(0), path[618-16][0], path[618-16][1], 16, 24, this);
				gc.drawImage(pidge.northeast(0), path[618][0], path[618][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[618][0]-122, path[618][1]-97, 134+path[618][0], 127+path[618][1], this);

			}
			if (frame > 2612 && frame < 3133) {
				pidge.setDir(direction[frame]);
				wwl.setDir(direction[frame-16]);
				house.setDir(direction[frame-32]);
				tomek.setDir(direction[frame-48]);
				gc.drawImage(tomek.getPic(((frame - 48) / 10) % 2), path[frame-48][0], path[frame-48][1], 16, 24, this);
				gc.drawImage(house.getPic(((frame - 32) / 10) % 2), path[frame-32][0], path[frame-32][1], 16, 24, this);
				gc.drawImage(wwl.getPic(((frame - 16) / 10) % 2), path[frame-16][0], path[frame-16][1], 16, 24, this);
				gc.drawImage(pidge.getPic(((frame) / 10) % 2), path[frame][0], path[frame][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[frame][0]-122, path[frame][1]-97, 134+path[frame][0], 127+path[frame][1], this);
			}
			if (frame > 3133 && frame <= 3198) {
				pidge.setDir(direction[frame]);
				wwl.setDir(direction[frame-16]);
				house.setDir(direction[frame-32]);
				tomek.setDir(direction[frame-48]);
				gc.drawImage(pidge.getPic(((frame) / 10) % 2), path[frame][0], path[frame][1], 16, 24, this);
				gc.drawImage(wwl.getPic(((frame - 16) / 10) % 2), path[frame-16][0], path[frame-16][1], 16, 24, this);
				gc.drawImage(house.getPic(((frame - 32) / 10) % 2), path[frame-32][0], path[frame-32][1], 16, 24, this);
				gc.drawImage(tomek.getPic(((frame - 48) / 10) % 2), path[frame-48][0], path[frame-48][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[frame][0]-122, path[frame][1]-97, 134+path[frame][0], 127+path[frame][1], this);
			}
			if (frame > 3198 && frame <= 3208) {
				pidge.setDir(direction[frame]);
				wwl.setDir(direction[frame-16]);
				house.setDir(direction[frame-32]);
				tomek.setDir(direction[frame-48]);
				gc.drawImage(pidge.north(0), path[3198][0], path[3198][1], 16, 24, this);
				gc.drawImage(wwl.north(0), path[3198-16][0], path[3198-16][1], 16, 24, this);
				gc.drawImage(house.north(0), path[3198-32][0], path[3198-32][1], 16, 24, this);
				gc.drawImage(tomek.north(0), path[3198-48][0], path[3198-48][1], 16, 24, this);
				for (int k = 0; k < frame-3199; k++) {
					gc.drawImage(dark,path[3198][0]-122,path[3198][1]-97,256,224,this);
				}
				g.drawImage(board, 0, 0, 256, 224, path[3198][0]-122, path[3198][1]-97, 134+path[3198][0], 127+path[3198][1], this);
			}
			if (frame > 3208 && frame <= 3218) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkys,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168, 113, 16, 24, this);
				for (int k = 0; k < 3218 - frame; k++) {
					gd.drawImage(dark,0,0,256,224,this);
				}
				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3218 && frame <= 3250) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkys,121,113,16,24,this);
				if (frame - 48 >= 3219)
					gd.drawImage(tomek.west(((frame - 58) / 10) % 2), 168-((frame - 48) % 3219), 113, 16, 24, this);
				else
					gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				if (frame - 32 >= 3219)
					gd.drawImage(house.west(((frame - 42) / 10) % 2), 168-((frame - 32) % 3219), 113, 16, 24, this);
				else
					gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				if (frame - 16 >= 3219)
					gd.drawImage(wwl.west(((frame - 26) / 10) % 2), 168-((frame - 16) % 3219), 113, 16, 24, this);
				else
					gd.drawImage(wwl.west(0), 168, 113, 16, 24, this);
				gd.drawImage(pidge.west(((frame) / 10) % 2), 168-frame % 3219, 113, 16, 24, this);


				g.drawImage(bs,0,0,256,224,this);

			}
			if (frame == 3251) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);


				g.drawImage(bs,0,0,256,224,this);
			}

			if (frame > 3251 && frame <= 3278) {
				String s = "Pidge? WWL? House? Tomek? ";
				int pos = frame - 3252;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s.substring(0,pos), 111, 26);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3278 && frame <= 3304) {
				String s = "Pidge? WWL? House? Tomek? ";
				String s2 = "What a pleasant surprise!";
				int pos = frame - 3279;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s, 111, 26);
				gd.drawImage(dot,106,37, 3, 4, this);
				gd.drawString(s2.substring(0,pos), 111, 42);

				g.drawImage(bs,0,0,256,224,this);
			}

			if (frame == 3305) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.south(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3305 && frame <= 3335) {
				String s = "Hey, Sparky! Pidge's bat got ";
				int pos = frame - 3306;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s.substring(0,pos), 111, 26);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3335 && frame <= 3360) {
				String s = "Hey, Sparky! Pidge's bat got ";
				String s2 = "stolen. Do you have one?";
				int pos = frame - 3336;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s, 111, 26);
				gd.drawString(s2.substring(0,pos), 111, 42);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame == 3361) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkys,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3361 && frame <= 3377) {
				String s = "A bat, you say?";
				int pos = frame - 3362;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkys,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s.substring(0,pos), 111, 26);

				g.drawImage(bs,0,0,256,224,this);
			}

			if (frame == 3378) {
				String s = "A bat, you say?";
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkyw,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s, 111, 26);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame == 3379) {
				String s = "A bat, you say?";
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkyn,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s, 111, 26);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame == 3380) {
				String s = "A bat, you say?";
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s, 111, 26);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3380 && frame <= 3409) {
				String s = "A bat, you say?";
				String s2 = "Here, I think this might be ";
				int pos = frame - 3381;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s, 111, 26);
				gd.drawImage(dot,106,37, 3, 4, this);
				gd.drawString(s2.substring(0, pos), 111, 42);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3409 && frame <= 3434) {
				String s = "A bat, you say?";
				String s2 = "Here, I think this might be ";
				String s3 = "what you're looking for.";
				int pos = frame - 3410;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s, 111, 26);
				gd.drawImage(dot,106,37, 3, 4, this);
				gd.drawString(s2, 111, 42);
				gd.drawString(s3.substring(0,pos), 111, 58);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame == 3435) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3435 && frame <= 3451) {
				String s = "Pidge received ";
				int pos = frame - 3436;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s.substring(0,pos), 111, 26);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3451 && frame <= 3468) {
				String s = "Pidge received ";
				String s2 = "the Cracked bat.";
				int pos = frame - 3452;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s, 111, 26);
				gd.drawString(s2.substring(0,pos), 111, 42);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame == 3469) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.south(0), 168-31, 113, 16, 24, this);
				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame == 3470) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3470 && frame <= 3497) {
				String s = "Thanks a bunch, Sparky! :D";
				int pos = frame - 3471;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s.substring(0,pos), 111, 26);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame == 3498) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.south(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3498 && frame <= 3522) {
				String s = "so... back to leveling?";
				int pos = frame - 3499;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.south(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s.substring(0,pos), 111, 26);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame == 3523) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3523 && frame <= 3544) {
				String s = "Seeya later, Sparky!";
				int pos = frame - 3524;
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.west(0), 168, 113, 16, 24, this);
				gd.drawImage(house.west(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.west(0), 168-31, 113, 16, 24, this);
				gd.drawImage(speechbox, 97, 8, 152, 64, this);
				gd.setFont(f);
				gd.setColor(Color.white);
				gd.drawImage(dot,106,21, 3, 4, this);
				gd.drawString(s.substring(0,pos), 111, 26);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3544 && frame <= 3576) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.east(0), 168, 113, 16, 24, this);
				gd.drawImage(house.east(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.west(0), 168-15, 113, 16, 24, this);
				gd.drawImage(pidge.east((frame/10) % 2), 168-31+(frame-3545), 113, 16, 24, this);

				g.drawImage(bs,0,0,256,224,this);
			}

			if (frame > 3576 && frame <= 3591) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.east(0), 168, 113, 16, 24, this);
				gd.drawImage(house.east(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.east(((frame-10)/10) % 2), 168-15+(frame-3577), 113, 16, 24, this);
				gd.drawImage(pidge.east(0), 168, 113, 16, 24, this);

				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3591 && frame <= 3601) {
				gd.drawImage(sparkyhouse,0,0,256,224,this);
				gd.drawImage(sparkye,121,113,16,24,this);
				gd.drawImage(tomek.east(0), 168, 113, 16, 24, this);
				gd.drawImage(house.east(0), 168, 113, 16, 24, this);
				gd.drawImage(wwl.east(0), 168, 113, 16, 24, this);
				gd.drawImage(pidge.east(0), 168, 113, 16, 24, this);
				for (int k = 0; k < frame - 3597; k++) {
					gd.drawImage(dark,0,0,256,224,this);
				}
				g.drawImage(bs,0,0,256,224,this);
			}
			if (frame > 3601 && frame <= 3611) {
				gc.drawImage(tomek.south(0),path[3198][0],path[3198][1],16,24,this);
				gc.drawImage(house.south(0),path[3198][0],path[3198][1],16,24,this);
				gc.drawImage(wwl.south(0),path[3198][0],path[3198][1],16,24,this);
				gc.drawImage(pidge.south(0),path[3198][0],path[3198][1],16,24,this);
				for (int k = 0; k < 3611 - frame; k++) {
					gc.drawImage(dark,path[3198][0]-122,path[3198][1]-97,256,224,this);
				}
				g.drawImage(board, 0, 0, 256, 224, path[3198][0]-122, path[3198][1]-97, 134+path[3198][0], 127+path[3198][1], this);
			}
			if (frame > 3611 && frame <= 3717) {
				pidge.setDir(direction[frame]);
				wwl.setDir(direction[frame-16]);
				house.setDir(direction[frame-32]);
				tomek.setDir(direction[frame-48]);
				if (frame <= 3660)
					gc.drawImage(tomek.getPic(0), path[frame-48][0], path[frame-48][1], 16, 24, this);
				else
					gc.drawImage(tomek.getPic(((frame - 48) / 10) % 2), path[frame-48][0], path[frame-48][1], 16, 24, this);
				if (frame <= 3644)
					gc.drawImage(house.getPic(0), path[frame-32][0], path[frame-32][1], 16, 24, this);
				else
					gc.drawImage(house.getPic(((frame - 32) / 10) % 2), path[frame-32][0], path[frame-32][1], 16, 24, this);
				if (frame <= 3628)
					gc.drawImage(wwl.getPic(0), path[frame-16][0], path[frame-16][1], 16, 24, this);
				else
					gc.drawImage(wwl.getPic(((frame - 16) / 10) % 2), path[frame-16][0], path[frame-16][1], 16, 24, this);
				gc.drawImage(pidge.getPic(((frame) / 10) % 2), path[frame][0], path[frame][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[frame][0]-122, path[frame][1]-97, 134+path[frame][0], 127+path[frame][1], this);
			}
			if (frame > 3717 && frame <= 3745) {
				String s = "Wait! Pidge, shouldn't you ";
				int pos = frame - 3718;
				gc.drawImage(tomek.southwest(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.west(1), path[3717][0], path[3717][1], 16, 24, this);gc.drawImage(speechbox, path[607][0]-122+96, path[607][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, path[3717][0]-122+96, path[3717][1]-97+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0, pos), path[3717][0]-122+96+14, path[3717][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 3745 && frame <= 3757) {
				String s = "Wait! Pidge, shouldn't you ";
				String s2 = "equeep eet?";
				int pos = frame - 3746;
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.west(1), path[3717][0], path[3717][1], 16, 24, this);gc.drawImage(speechbox, path[607][0]-122+96, path[607][1]-97+7, 152, 64, this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, path[3717][0]-122+96, path[3717][1]-97+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString(s, path[3717][0]-122+96+14, path[3717][1]-97+7+19);
				gc.drawString(s2.substring(0, pos), path[3717][0]-122+96+14, path[3717][1]-97+7+35);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 3758) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.west(1), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 3759) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.northwest(1), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 3760) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.north(1), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 3761) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.northeast(1), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 3762) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(1), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 3762 && frame <= 3786) {
				String s = "Oh yeah! Thanks, Tomek.";
				int pos = frame - 3763;
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(1), path[3717][0], path[3717][1], 16, 24, this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, path[3717][0]-122+96, path[3717][1]-97+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0,pos), path[3717][0]-122+96+14, path[3717][1]-97+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 3787) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}

			int origx = path[3717][0]-122;
			int origy = path[3717][1]-97;
			if (frame > 3787 && frame <= 3817) {
				int curx = 19, cury = 19;
				if (frame >3797)
					curx = 67;
				if (frame >3807)
					cury = 35;
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				gc.drawImage(menumain,origx+9,origy+8,104,64,this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(cursor1,origx+curx,origy+cury,4,8,this);
				else
					gc.drawImage(cursor2,origx+curx,origy+cury,4,8,this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 3817 && frame <= 3837) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				gc.drawImage(menumain,origx+9,origy+8,104,64,this);
				gc.drawImage(money, origx+9, origy+80, 64, 32, this);
				gc.drawImage(pidgebar,origx+17,origy+144,56,64,this);
				gc.drawImage(wwlbar,origx+73,origy+152,56,64,this);
				gc.drawImage(housebar,origx+129,origy+152,56,64,this);
				gc.drawImage(tomekbar,origx+185,origy+152,56,64,this);
				gc.drawImage(who,origx+9,origy+8,56,32,this);
				gc.drawImage(menuequips,origx+65,origy+8,160,80,this);
				gc.drawImage(menustats,origx+25,origy+88,120,48,this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(arrows1,origx+191,origy+6,20,10,this);
				else
					gc.drawImage(arrows2,origx+191,origy+6,20,10,this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 3837 && frame <= 3867) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				gc.drawImage(menumain,origx+9,origy+8,104,64,this);
				gc.drawImage(money, origx+9, origy+80, 64, 32, this);
				gc.drawImage(pidgebar,origx+17,origy+144,56,64,this);
				gc.drawImage(wwlbar,origx+73,origy+152,56,64,this);
				gc.drawImage(housebar,origx+129,origy+152,56,64,this);
				gc.drawImage(tomekbar,origx+185,origy+152,56,64,this);
				gc.drawImage(where,origx+9,origy+8,56,32,this);
				gc.drawImage(menuequips,origx+65,origy+8,160,80,this);
				gc.drawImage(menustats,origx+25,origy+88,120,48,this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(cursor1,origx+75,origy+19,4,8,this);
				else
					gc.drawImage(cursor2,origx+75,origy+19,4,8,this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 3867 && frame <= 3897) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				gc.drawImage(menumain,origx+9,origy+8,104,64,this);
				gc.drawImage(money, origx+9, origy+80, 64, 32, this);
				gc.drawImage(pidgebar,origx+17,origy+144,56,64,this);
				gc.drawImage(wwlbar,origx+73,origy+152,56,64,this);
				gc.drawImage(housebar,origx+129,origy+152,56,64,this);
				gc.drawImage(tomekbar,origx+185,origy+152,56,64,this);
				gc.drawImage(which,origx+9,origy+8,56,32,this);
				gc.drawImage(menuequips,origx+65,origy+8,160,80,this);
				gc.drawImage(menuweapons,origx+145,origy+8,104,128,this);
				gc.drawImage(menustats2,origx+25,origy+88,120,48,this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(cursor1,origx+155,origy+19,4,8,this);
				else
					gc.drawImage(cursor2,origx+155,origy+19,4,8,this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 3898) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 3898 && frame <= 3903) {
				String s = "...?";
				int pos = frame - 3899;
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, origx+96, origy+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0,pos), origx+96+14, origy+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 3904) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.west(0), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 3904 && frame <= 3999) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.west(0), path[3717][0], path[3717][1], 16, 24, this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(bat1,batpath[frame-3905][0],batpath[frame-3905][1],15,16,this);
				else
					gc.drawImage(bat2,batpath[frame-3905][0],batpath[frame-3905][1],15,16,this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 3999 && frame <= 4089) {
				gc.drawImage(tomek.southeast(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.southeast(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.southeast(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southeast(0), path[3717][0], path[3717][1], 16, 24, this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(bat1,batpath[frame-3905][0],batpath[frame-3905][1],15,16,this);
				else
					gc.drawImage(bat2,batpath[frame-3905][0],batpath[frame-3905][1],15,16,this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 4089 && frame <= 4114) {
				String s = "LOLOLOLOLOLOLOLOL!!!!!!!";
				int pos = frame - 4090;
				gc.drawImage(tomek.southeast(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.southeast(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.southeast(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southeast(0), path[3717][0], path[3717][1], 16, 24, this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(bat1,batpath[184][0],batpath[184][1],15,16,this);
				else
					gc.drawImage(bat2,batpath[184][0],batpath[184][1],15,16,this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, origx+96, origy+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0,pos), origx+96+14, origy+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 4114 && frame <= 4214) {
				String s = "LOLOLOLOLOLOLOLOL!!!!!!!";
				gc.drawImage(tomek.southeast(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.southeast(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.southeast(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southeast(0), path[3717][0], path[3717][1], 16, 24, this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(bat1,batpath[184][0],batpath[184][1],15,16,this);
				else
					gc.drawImage(bat2,batpath[184][0],batpath[184][1],15,16,this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, origx+96, origy+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString(s, origx+96+14, origy+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 4214 && frame <= 4224) {
				gc.drawImage(tomek.southeast(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.southeast(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.southeast(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southeast(0), path[3717][0], path[3717][1], 16, 24, this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(bat1,batpath[frame-4030][0],batpath[frame-4030][1],15,16,this);
				else
					gc.drawImage(bat2,batpath[frame-4030][0],batpath[frame-4030][1],15,16,this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 4224 && frame <= 4234) {
				gc.drawImage(tomek.south(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.south(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.south(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.south(0), path[3717][0], path[3717][1], 16, 24, this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(bat1,batpath[frame-4030][0],batpath[frame-4030][1],15,16,this);
				else
					gc.drawImage(bat2,batpath[frame-4030][0],batpath[frame-4030][1],15,16,this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 4234 && frame <= 4274) {
				gc.drawImage(tomek.southwest(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.southwest(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.southwest(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southwest(0), path[3717][0], path[3717][1], 16, 24, this);
				if ((frame /4 )% 2 == 0)
					gc.drawImage(bat1,batpath[frame-4010][0],batpath[frame-4010][1],15,16,this);
				else
					gc.drawImage(bat2,batpath[frame-4010][0],batpath[frame-4010][1],15,16,this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 4274 && frame <= 4278) {
				String s = "...";
				int pos = frame-4275;
				gc.drawImage(tomek.southwest(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.southwest(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.southwest(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southwest(0), path[3717][0], path[3717][1], 16, 24, this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, origx+96, origy+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0,pos), origx+96+14, origy+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 4279) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.southwest(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.southwest(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southwest(0), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 4280) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.southwest(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southwest(0), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 4281) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southwest(0), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 4282) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southwest(0), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 4283) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.south(0), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 4284) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}

			if (frame > 4284 && frame <= 4294) {
				String s = "So, uh...";
				int pos = frame - 4285;
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.southeast(0), path[3717][0], path[3717][1], 16, 24, this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, origx+96, origy+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString(s.substring(0,pos), origx+96+14, origy+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 4294 && frame <= 4309) {
				String s = "So, uh... how many more ";
				int pos = frame - 4285;
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, origx+96, origy+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString("So, uh... " + s.substring(10,pos), origx+96+14, origy+7+19);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 4309 && frame <= 4337) {
				String s = "So, uh... how many more ";
				String s2 = "battles until we can afford";
				int pos = frame - 4310;
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, origx+96, origy+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString(s, origx+96+14, origy+7+19);
				gc.drawString(s2.substring(0,pos), origx+96+14, origy+7+35);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame > 4337 && frame <= 4357) {
				String s = "So, uh... how many more ";
				String s2 = "battles until we can afford";
				String s3 = "another bat, House?";
				int pos = frame - 4338;
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.west(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				gc.setColor(Color.white);
				gc.drawImage(speechbox, origx+96, origy+7, 152, 64, this);
				gc.drawImage(dot,path[3717][0]-122+96+9, path[3717][1]-97+7+13, 3, 4, this);
				gc.drawString(s, origx+96+14, origy+7+19);
				gc.drawString(s2, origx+96+14, origy+7+35);
				gc.drawString(s3.substring(0, pos), origx+96+14, origy+7+51);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame == 4358) {
				gc.drawImage(tomek.west(0), path[3717-48][0], path[3717-48][1],16,24,this);
				gc.drawImage(house.south(0), path[3717-32][0], path[3717-32][1],16,24,this);
				gc.drawImage(wwl.west(0), path[3717-16][0], path[3717-16][1],16,24,this);
				gc.drawImage(pidge.east(0), path[3717][0], path[3717][1], 16, 24, this);
				g.drawImage(board, 0, 0, 256, 224, path[3717][0]-122, path[3717][1]-97, 134+path[3717][0], 127+path[3717][1], this);
			}
			if (frame >= 4359) {
				g.drawImage(end, 0, 0, 256, 224, this);
			}

		}
	}

	public void DrawBattleBackground () {
		gd.setColor(bckgd[(bframe/4)%14]);
		gd.fillRect(0,0,256,224);
		gd.drawImage(row, 0-bframe*2, 60, 224, 22, this);
		gd.drawImage(row, 224-bframe*2, 60, 224, 22, this);
		gd.drawImage(row, 448-bframe*2, 60, 224, 22, this);
		gd.drawImage(row, 224+bframe*2, 97, 224, 22, this);
		gd.drawImage(row, 0+bframe*2, 97, 224, 22, this);
		gd.drawImage(row, -224+bframe*2, 97, 224, 22, this);
		gd.drawImage(row, -448+bframe*2, 97, 224, 22, this);
		gd.drawImage(row, 0-bframe*2, 129, 224, 22, this);
		gd.drawImage(row, 224-bframe*2, 129, 224, 22, this);
		gd.drawImage(row, 448-bframe*2, 129, 224, 22, this);
		gd.setColor(Color.black);
		gd.fillRect(0,0,256,67);
		gd.fillRect(0,157,256,224);
		gd.drawImage(spitefulcrow,115,112,30,32,this);
	}


	public void stop() {
		animator = null;
	}

}
