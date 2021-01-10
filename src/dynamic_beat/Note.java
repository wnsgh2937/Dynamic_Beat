package dynamic_beat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteSpacebarBasicImage = new ImageIcon(Main.class.getResource("../images/noteSpacebarBasic.png")).getImage();
	
	private int x,y= 0;
	private String noteType;
	public static int combo=0;
	private boolean proceeded=true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded=false;
	}
	
	public Note() {
	}
	
	public Note(String noteType) {
		if(noteType.equals("S")){
			x=228;
		}
		else if(noteType.equals("D")){
			x=334;
		}
		else if(noteType.equals("F")){
			x=438;
		}
		else if(noteType.equals("Space")){
			x=542;
		}
		else if(noteType.equals("J")){
			x=746;
		}
		else if(noteType.equals("K")){
			x=850;
		}
		else if(noteType.equals("L")){
			x=954;
		}
		this.noteType=noteType;
		
	}
	
	public void screenDraw(Graphics2D g) {
		if(!noteType.equals("Space")){
			g.drawImage(noteBasicImage,x,y,null);
		}
		else {
			g.drawImage(noteSpacebarBasicImage,x,y,null);
		}
			 
		
	}
	
	public void drop() {
			y+=Main.NOTE_SPEED;
			if(y>660) {
				combo=0;
				System.out.println("Miss");
				close();
			}
	}
	
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void judge() {
		if(y>=640) {
			combo=0;
			Game.score+=Game.SCORE_MULTIFLIER*0;
			close();
		}
		else if(y>=630) {
			combo++;
			Game.score+=Game.SCORE_MULTIFLIER*0.3;
			close();
		}
		else if(y>=620) {
			combo++;
			Game.score+=Game.SCORE_MULTIFLIER*0.5;
			close();
		}
		else if(y>=540) {
			combo++;
			Game.score+=Game.SCORE_MULTIFLIER*1;
			close();
		}
		else if(y>=520) {
			combo++;
			Game.score+=Game.SCORE_MULTIFLIER*0.5;
			close();
		}
		else if(y>=510) {
			combo++;
			Game.score+=Game.SCORE_MULTIFLIER*0.3;
			close();
		}
		else if(y>=500) {
			combo=0;
			Game.score+=Game.SCORE_MULTIFLIER*0;
			close();
		}
	}
	
	public static void setComboZero() {
		combo=0;
	}
	


	
	
	
}
