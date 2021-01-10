package dynamic_beat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private boolean gameMaker=false;
	public static int SCORE_MULTIFLIER=1;
	public static int score=0;

	int index;
	ArrayList<Note> noteList=new ArrayList<Note>();

	
	public Game(String titlename, String difficulty,String musicTitle) {
		this.titleName=titlename;;
		this.difficulty=difficulty;
		this.musicTitle=musicTitle;
		gameMusic=new Music(this.musicTitle,false);
	}
	
	public void GameMusicClose() {
		gameMusic.close();
		Note.combo=0;
	}
	
	public void screenDraw(Graphics2D g) {


		g.drawImage(noteRouteSImage,228,30,null);
		g.drawImage(noteRouteDImage,332,30,null);
		g.drawImage(noteRouteFImage,436,30,null);
		g.drawImage(noteRouteSpace1Image,540,30,null);
		g.drawImage(noteRouteSpace2Image,640,30,null);
		g.drawImage(noteRouteJImage,744,30,null);
		g.drawImage(noteRouteKImage,848,30,null);
		g.drawImage(noteRouteLImage,952,30,null);
		
		g.drawImage(noteRouteLineImage,224,30,null);
		g.drawImage(noteRouteLineImage,328,30,null);
		g.drawImage(noteRouteLineImage,432,30,null);
		g.drawImage(noteRouteLineImage,536,30,null);
		g.drawImage(noteRouteLineImage,740,30,null);
		g.drawImage(noteRouteLineImage,844,30,null);
		g.drawImage(noteRouteLineImage,948,30,null);
		g.drawImage(noteRouteLineImage,1052,30,null);
		
		g.drawImage(judgementLineImage,0,580,null);
		
		
		for(int i=0;i<noteList.size();i++) {
			Note note = noteList.get(i);
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
			note.screenDraw(g);
			}
		}
		
		
		
		g.drawImage(gameInfoImage,0,660,null);
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD,30));

		g.drawString(difficulty,1190,702);
		g.drawString(titleName,20,702);
		g.setFont(new Font("Elephant", Font.BOLD,30));
		int num1 = score;
		String str1 = Integer.toString(num1);
		g.drawString(str1,565,702);
		
		g.setFont(new Font("Elephant", Font.BOLD,35));
		int num2 = Note.combo;
		String str2 = Integer.toString(num2);
		g.drawString(str2+" COMBO",550,180);
		
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.PLAIN,26));
		g.drawString("S",270,609);
		g.drawString("D",374,609);
		g.drawString("F",478,609);
		g.drawString("Spacebar",580,609);
		g.drawString("J",784,609);
		g.drawString("K",889,609);
		g.drawString("L",993,609);
		
		

	}
	
	public static void setScoreZero() {
		score=0;
	}
	
	
	public void pressS() {
		if(gameMaker==true) {
			System.out.println(gameMusic.getTime()+" S");
		}
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressD() {
		if(gameMaker==true) {
			System.out.println(gameMusic.getTime()+" D");
		}
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}	
	
	
	public void pressF() {
		if(gameMaker==true) {
			System.out.println(gameMusic.getTime()+" F");
		}
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressSpace() {
		if(gameMaker==true) {
			System.out.println(gameMusic.getTime()+" Space");
		}
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3",false).start();
		
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressJ()  {
		if(gameMaker==true) {
			System.out.println(gameMusic.getTime()+" J");
		}
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressK() {
		if(gameMaker==true) {
			System.out.println(gameMusic.getTime()+" K");
		}
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressL() {
		if(gameMaker==true) {
			System.out.println(gameMusic.getTime()+" L");
		}
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	
	@Override
	public void run() {
		try {
			dropNotes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes() throws Exception {
		Beat[] beats= null;
		if(titleName.equals("OmyGirl-Closer")) {
			if(difficulty.equals("Easy")) {
			    index(titleName,difficulty);
				int[] time=new int[this.index];
				String[] noteType=new String[this.index];
			    int i=0;
			    BufferedReader br = new BufferedReader( new FileReader("D:\\eclipse-workspace\\Dynamic Beat\\src\\text\\"+titleName+difficulty+".txt") );
			    String str = ""; 
			    while( (str = br.readLine()) != null ) { 
				      String[] tmp = str.split(" ");
				      String st = tmp[0];
				      int k=Integer.parseInt(st);
				      time[i]=k;
				      noteType[i]=tmp[1];
				      i++;
				}
			    br.close(); 
				
				int gap=(Main.HEIGHT/Main.NOTE_SPEED)*Main.SLEEP_TIME;
				
				beats=new Beat[index];
				for(int k=0;k<index;k++) {
					beats[k]=new Beat(time[k]-gap,noteType[k]);
				}	
			}
			else if(difficulty.equals("Hard")) {
			    index(titleName,difficulty);
				int[] time=new int[this.index];
				String[] noteType=new String[this.index];
			    int i=0;
			    BufferedReader br = new BufferedReader( new FileReader("D:\\eclipse-workspace\\Dynamic Beat\\src\\text\\"+titleName+difficulty+".txt") );
			    String str = ""; 
			    while( (str = br.readLine()) != null ) { 
				      String[] tmp = str.split(" ");
				      String st = tmp[0];
				      int k=Integer.parseInt(st);
				      time[i]=k;
				      noteType[i]=tmp[1];
				      i++;
				}
			    br.close(); 
				
				int gap=(Main.HEIGHT/Main.NOTE_SPEED)*Main.SLEEP_TIME;
				
				beats=new Beat[index];
				for(int k=0;k<index;k++) {
					beats[k]=new Beat(time[k]-gap,noteType[k]);	
				};
			}
		}
		else if(titleName.equals("OmyGirl-5thSeason")) {
			if(difficulty.equals("Easy")) {
			    index(titleName,difficulty);
				int[] time=new int[this.index];
				String[] noteType=new String[this.index];
			    int i=0;
			    BufferedReader br = new BufferedReader( new FileReader("D:\\eclipse-workspace\\Dynamic Beat\\src\\text\\"+titleName+difficulty+".txt") );
			    String str = ""; 
			    while( (str = br.readLine()) != null ) { 
				      String[] tmp = str.split(" ");
				      String st = tmp[0];
				      int k=Integer.parseInt(st);
				      time[i]=k;
				      noteType[i]=tmp[1];
				      i++;
				}
			    br.close(); 
				
				int gap=(Main.HEIGHT/Main.NOTE_SPEED)*Main.SLEEP_TIME;
				
				beats=new Beat[index];
				for(int k=0;k<index;k++) {
					beats[k]=new Beat(time[k]-gap,noteType[k]);
				}	
			}
			else if(difficulty.equals("Hard")) {
			    index(titleName,difficulty);
				int[] time=new int[this.index];
				String[] noteType=new String[this.index];
			    int i=0;
			    BufferedReader br = new BufferedReader( new FileReader("D:\\eclipse-workspace\\Dynamic Beat\\src\\text\\"+titleName+difficulty+".txt") );
			    String str = ""; 
			    while( (str = br.readLine()) != null ) { 
				      String[] tmp = str.split(" ");
				      String st = tmp[0];
				      int k=Integer.parseInt(st);
				      time[i]=k;
				      noteType[i]=tmp[1];
				      i++;
				}
			    br.close(); 
				
				int gap=(Main.HEIGHT/Main.NOTE_SPEED)*Main.SLEEP_TIME;
				
				beats=new Beat[index];
				for(int k=0;k<index;k++) {
					beats[k]=new Beat(time[k]-gap,noteType[k]);
				}	
			}
		}
		else if(titleName.equals("April-Spring Story")) {
			if(difficulty.equals("Easy")) {
			    index(titleName,difficulty);
				int[] time=new int[this.index];
				String[] noteType=new String[this.index];
			    int i=0;
			    BufferedReader br = new BufferedReader( new FileReader("D:\\eclipse-workspace\\Dynamic Beat\\src\\text\\"+titleName+difficulty+".txt") );
			    String str = ""; 
			    while( (str = br.readLine()) != null ) { 
				      String[] tmp = str.split(" ");
				      String st = tmp[0];
				      int k=Integer.parseInt(st);
				      time[i]=k;
				      noteType[i]=tmp[1];
				      i++;
				}
			    br.close(); 
				
				int gap=(Main.HEIGHT/Main.NOTE_SPEED)*Main.SLEEP_TIME;
				
				beats=new Beat[index];
				for(int k=0;k<index;k++) {
					beats[k]=new Beat(time[k]-gap,noteType[k]);
				}	
			}
			else if(difficulty.equals("Hard")) {
			    index(titleName,difficulty);
				int[] time=new int[this.index];
				String[] noteType=new String[this.index];
			    int i=0;
			    BufferedReader br = new BufferedReader( new FileReader("D:\\eclipse-workspace\\Dynamic Beat\\src\\text\\"+titleName+difficulty+".txt") );
			    String str = ""; 
			    while( (str = br.readLine()) != null ) { 
				      String[] tmp = str.split(" ");
				      String st = tmp[0];
				      int k=Integer.parseInt(st);
				      time[i]=k;
				      noteType[i]=tmp[1];
				      i++;
				}
			    br.close(); 
				
				int gap=(Main.HEIGHT/Main.NOTE_SPEED)*Main.SLEEP_TIME;
				
				beats=new Beat[index];
				for(int k=0;k<index;k++) {
					beats[k]=new Beat(time[k]-gap,noteType[k]);
				}	
			}
		}
		int i = 0;
		gameMusic.start();
		while(i<beats.length&&!isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime()<=gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped=true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}	
	}

	public void judge(String input) {
		for (int i=0;i<noteList.size();i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
	
	
	public void index(String titleName,String difficulty) throws Exception{
	    int index=0;
		BufferedReader br = new BufferedReader( new FileReader("D:\\eclipse-workspace\\Dynamic Beat\\src\\text\\"+titleName+difficulty+".txt") ); 
	    String str = ""; 
	    while( (str = br.readLine()) != null ) { 
	      index++;
	    }
	    this.index=index;
	    Game.SCORE_MULTIFLIER=100000/index;
	    br.close(); 
	}
}
	

