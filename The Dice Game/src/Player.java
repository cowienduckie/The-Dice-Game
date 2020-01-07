
public class Player {
	String name;
	int score = 0;
	boolean win = false;
	String lose_emotion;
	String win_emotion;
	
	
	public Player() {
		super();
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void win() {
		this.win = true;
	}
	
	public void say() {
	}
}
