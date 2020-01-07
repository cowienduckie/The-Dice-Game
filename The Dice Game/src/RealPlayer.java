import java.util.Scanner;

public class RealPlayer extends Player{
	Scanner sc = new Scanner(System.in);
	
	public void say() {
		String str;
		
		if(win) {
			System.out.println("GM : " + name + "! You win this game! How do you feel?");
			System.out.print(name + " : ");
			str = sc.nextLine();
		}
		else{
			System.out.print(name + " : ");
			str = sc.nextLine();
		}
		System.out.print("");
	}
}
