import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;;

public class Game {
	//--------Config---------//
	public final int numberPlayer = 4;
	public final int endPoint = 21;
	public final int sleeptime = 10;
	
	//--------Var------------//
	public int numberRealPlayer;
	public String winner =" ";
	public static boolean end = false;
	
	//----------------------------------------------//
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	Player player[] = new Player[numberPlayer];
	
	//----------------------------------------------//
	public void prepareGame(){
		System.out.println("THE DICE GAME");
		System.out.println("-------------------------");
		System.out.println("PREPARE GAME");
		System.out.println("");
		System.out.print("How many people are there wanna play?  "); numberRealPlayer = sc.nextInt();
		System.out.println("");
		//Add Real Player 
		String name = sc.nextLine();
		for(int i = 1; i<= numberRealPlayer; i++) {
			player[i-1] = new RealPlayer();
			System.out.print("Enter player " + i + "'s name:  ");
			name = sc.nextLine();
			player[i-1].setName(name);
			System.out.println("");
		}
		//Add Virtual Player
		for(int i = 1; i <= numberPlayer-numberRealPlayer; i++) {
			System.out.println("Create Virtual Player "+ i);
			System.out.println("");
			VirtualPlayer bot = new VirtualPlayer();
			player[numberPlayer-i] = bot;
			player[numberPlayer-i].setName("Virtual Player " + i);
		}
		System.out.println("-------------------------");
	}
	
	public void gameMaster() throws InterruptedException{
		int count = 0;
		int result = 0;
		while(!end) {
			TimeUnit.MILLISECONDS.sleep(sleeptime);
			System.out.println("Now is " + player[count].name + "'s turn!");
			result = rollDice();
			TimeUnit.MILLISECONDS.sleep(sleeptime);
			System.out.println("......");
			TimeUnit.MILLISECONDS.sleep(sleeptime);
			System.out.println("......");
			TimeUnit.MILLISECONDS.sleep(sleeptime);
			System.out.println("You got number " + result);
			System.out.println("");
			result += player[count].score;
			if(result > 21) player[count].setScore(0);
			else if(result < 21) player[count].setScore(result);
			else{
				end =true;
				player[count].setScore(result);
				continue;
			}
			System.out.println(player[count].name +"'s score is " + player[count].getScore() +" now.");
			TimeUnit.MILLISECONDS.sleep(sleeptime);
			System.out.println("");
			System.out.println("-------------------------");
			count++;
			if(count == 4) count = 0;
		}
		winner = player[count].name;
		player[count].win();
		System.out.println(player[count].name +"'s score is " + player[count].getScore() +"!\n" + player[count].name + " is the winner!");
		System.out.println("");
		System.out.println("-------------------------");
		TimeUnit.MILLISECONDS.sleep(sleeptime);
		player[count].say();
		for(int i=0; i < numberPlayer; i++) {
			if(i == count) continue;
			player[i].say();
		}
	}

 	public int rollDice() {
		Dice dice = new Dice();		
		int highchance = dice.getHighChance(rd.nextInt(4));
		int arr[] = {1, 2, 3, 4, 5, 6};
		//swap
			int x =arr[highchance-1];
			arr[highchance-1] = arr[5];
			arr[5] = x;
		//
		int face = rd.nextInt(100) / 16;
		if(face == 6) face = arr[5];
		for(int i=0; i <= 5; i++)
			if( i == face) {
				face = arr[i];
				break;
			}
		return face;
	}
		
	public void play() throws InterruptedException {
		prepareGame();
		gameMaster();
		System.out.println(" ");
		System.out.println("-------------------------");
	}
	
}
