package dynamic_beat;

public class Track {
	private String titleImage;//제목이미지
	private String startImage;// 게임 선택창 표지미이지
	private String gameImage;//실행했을때 표지 이미지 
	private String startMusic;// 게임 선택창 음악
	private String gameMusic;//실행했을때 음악
	private String titleName;
	
	
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMsuic(String startMsuic) {
		this.startMusic = startMsuic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	
	
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic,String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName=titleName;
	}
	
	
	
	

}
