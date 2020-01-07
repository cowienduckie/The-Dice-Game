import java.util.Random;

public class VirtualPlayer extends Player{
	String lose_emotion[] = {
		"Oh no! I'm lose! ",
		"Just unlucky! See you next time!",
		"Let's have a rematch!"
	};
	String win_emtion[] = {
		"Yes! I won it!",
		"First prize for the winner!",
		"Let's have a rematch!"
	};
	
	public void say() {
		Random rd = new Random();
		if (win) {
			System.out.println("GM : " + name + "! You win this game! How do you feel?");
            int u=rd.nextInt(win_emtion.length);
            System.out.println(name + " : " + win_emtion[u]);
		}
		else {
           int u=rd.nextInt(lose_emotion.length);
           System.out.println(name + " : " +lose_emotion[u]);
		};
	}
}
