package assignment02;
import java.util.Random;
import java.util.Scanner;
/*there are 7 extra functionalities:
 1. Mode selection    2.Mode validation
 3.Guesser number validation
 4.Player number validation
 5.Semi-final round is included if tie.
 6.Results are displayed
 7. Closure greetings*/

class Guessor{
	public int guessorNum;
	
	public int getGuessorGuessedNumber() {
		Scanner sc = new Scanner(System.in);
		guessorNum = sc.nextInt();
		return guessorNum;
	}
	
	public int guessorNumCheck(int guessorNum) {
		int guess1 = guessorNum;
		while(guess1<0 || guess1>=50) {
			System.out.println("pls enter a value betweeen 0 and 50");
			guess1 = getGuessorGuessedNumber();
		}
		return guess1;
	}
}


class Player{
	public int playerNum;
		
	public int getPlayerGuessNum() {
			Scanner sc = new Scanner(System.in);
			playerNum = sc.nextInt();
		 return playerNum;
    }
	
	public int playerNumCheck(int playerNum) {
		int var = playerNum;
		while(var<0 || var>=50) {
			System.out.println("pls enter a value betweeen 0 and 50");
		    var = getPlayerGuessNum();	
		}
		return var;
	}
}

class Umpire{
	public int guessedNum;
	public int player1Num;
	public int player2Num;
	public int player3Num;
	public int finalPlayerANum;
	public int finalPlayerBNum;
	public int playerCount = 1;
	
 	public void grabGuessor(int mode) {
 		Guessor g = new Guessor();
 		if(mode==1) {
 			System.out.println("Guessor, pls enter your guessed number.");
 			guessedNum = g.getGuessorGuessedNumber();
 		}
 		else {
 			Random rand = new Random();
 			guessedNum = rand.nextInt(50);
 		}
 		guessedNum = g.guessorNumCheck(guessedNum);
 	}
 	
 	public void grabPlayer() {
 		Player p1 = new Player();
 		Player p2 = new Player();
 		Player p3 = new Player();
 		
 		System.out.println("Player- ''" +playerCount +" '' please enter any number from0 to 50");
 		player1Num = p1.getPlayerGuessNum();
 		player1Num = p1.playerNumCheck(player1Num);
 		playerCount = playerCount+1;
 		
 		System.out.println("Player- ''" +playerCount +" '' please enter any number from0 to 50");
 		player2Num = p2.getPlayerGuessNum();
 		player2Num = p2.playerNumCheck(player2Num);
 		playerCount = playerCount+1;
 		
 		System.out.println("Player- ''" +playerCount +"'' please enter any number from0 to 50");
 		player3Num = p3.getPlayerGuessNum();
 		player3Num = p3.playerNumCheck(player3Num);
 	}
 	
 	public void compare() {
 		LaunchGame launchFinal = new LaunchGame();
 		if(guessedNum==player1Num) {
 			if(guessedNum==player2Num) {
 				if(guessedNum==player3Num) {
 					System.out.println("Awesome guessing! All 3 won the game. I am sure you must be best friends ;)");
 					System.out.println("---------------------------------------");
 					showResults();
 					System.out.println("---------------------------------------");
 				}
 				else{
 					System.out.println("Its a tie between player 1 and 2");
 					System.out.println("---------------------------------------");
 					showResults();
 					System.out.println("---------------------------------------");
 					System.out.println("But there has to be a final winner...so let's begin final round !");
 					launchFinal.finalWinner(1,2);
 				}
 			}
 			
 			else if(player1Num==player3Num) {
 				System.out.println("Its a tie between player 1 and 3");
					System.out.println("---------------------------------------");
					showResults();
					System.out.println("---------------------------------------");
					System.out.println("But there has to be a final winner...so let's begin final round !");
					launchFinal.finalWinner(1,3);	
 			}
 			
 			else {
 				System.out.println("player1 wins the game");
 				showResults();
 			}
 			
 		}
 		else if(guessedNum==player2Num) {
 			if(guessedNum==player3Num) {
 				System.out.println("Its a tie between player 1 and 2");
					System.out.println("---------------------------------------");
					showResults();
					System.out.println("---------------------------------------");
					System.out.println("But there has to be a final winner...so let's begin final round !");
					launchFinal.finalWinner(2,3);
 			}
 			else {
 				System.out.println("player2 wins the game");
 				showResults();
 			}
 		}
 		else if(guessedNum==player3Num) {
 			System.out.println("player3 wins the game");
 			showResults();
 		}
 		else {
 			System.out.println("Hard luck! No one wins the game.");
 			System.out.println("Is it like main teri dusman..dusman tu mera ;)" );
 			showResults();
 		}
 	}
 	
 	
 	public void grabFinalPlayers(int a,int b) {
 		Player finalPlayerA = new Player();
 		Player finalPlayerB = new Player();
 		
 		System.out.println("Player-''" +a +"'' please enter any number from 0 to 50");
 		finalPlayerANum = finalPlayerA.getPlayerGuessNum();
 		finalPlayerANum = finalPlayerA.playerNumCheck(finalPlayerANum);
 		
 		System.out.println("Player-''" +b +"'' please enter any number from 0 to 50");
 		finalPlayerBNum = finalPlayerB.getPlayerGuessNum();
 		finalPlayerBNum = finalPlayerB.playerNumCheck(finalPlayerBNum);
 	}
 	
 	public void finalCompare(int a,int b) {
 		LaunchGame launchFinal = new LaunchGame();
 		if(guessedNum==finalPlayerANum) {
 			if(guessedNum==finalPlayerBNum) {
 				System.out.println("Again its a tie between Player-''" +a +"'' and player-''" +b);
 				System.out.println("         Janam Janam ka sath..;)");
 				System.out.println("---------------------------------");
 				showResults(a,b);
 				System.out.println("---------------------------------");
 				System.out.println("but policy is for only one winner.");
 				launchFinal.finalWinner(a,b);
 			}
 			else {
 				System.out.println("---------------------------------");
 				showResults(a,b);
 				System.out.println("---------------------------------");
 				System.out.println("The winner of the game is Player-''" +a);
 			}
 		}
 		else if(guessedNum==finalPlayerBNum) {
 			System.out.println("-------------------------------------");
 			showResults(a,b);
 			System.out.println("-------------------------------------");
 			System.out.println("The winner of the game is Player-''" +b);
 		}
 		else {
 			System.out.println("-------------------------------------");;
 			showResults(a,b);
 			System.out.println("-------------------------------------");
 			System.out.println("Psttt ! No one wins the game.");
 		}
 	}
 	
 	
 	public void showResults() {
 		System.out.println("Guessor number: " +guessedNum);
 		System.out.println("_____________________________");
 		System.out.println("Player1 number:" +player1Num);
 		System.out.println("Player2 number:" +player2Num);
 		System.out.println("Player3 number:" +player3Num);
 	}
 	
 	public void showResults(int a,int b) {
 		System.out.println("Guessor number:" +guessedNum);
 		System.out.println("Player" +a +"number: " +finalPlayerANum);
 		System.out.println("Player" +b +"number: " +finalPlayerBNum);
 	}
 	
}


public class LaunchGame {
	public static void main(String[] args) {
		int mode = 0;
		LaunchGame launch = new LaunchGame();
		launch.greetings();
		Umpire um = new Umpire();
		mode = launch.getMode();
		um.grabGuessor(launch.modeCheck(mode));
		um.grabPlayer();
		um.compare();
		launch.footer();
	}
	
	public void greetings() {
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.println("May i have your good name pls");
		name = sc.nextLine();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("                Hello " +name +"... Welcome to assignment01 guessor game :)");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Let's get started ! \n");
	}
	
	//get mode from user
	public int getMode() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input: 1 for guessor play mode || 2 for computer Guessor mode");
		int mode = sc.nextInt();
		return mode;
	}
	
	
	public int modeCheck(int mode) {
		int m1 = mode;
		while(m1!=1 && m1!=2) {
			m1 = getMode();
		}
		return m1;
	 }
	
    public void finalWinner(int a,int b) {
    	int mode = modeCheck(getMode());
    	Umpire um1 = new Umpire();
    	um1.grabGuessor(mode);
    	um1.grabFinalPlayers(a, b);
    	um1.finalCompare(a, b);
    }
    
    public void footer() {
		System.out.println("------------------------------------------------------------------------------");
    	System.out.println("The Guessor game is a product of:");
		int n=7;
		for(int j=0;j<n;j++) {
			for(int i=0;i<n;i++) {
				if(((j==1 || j==n-2) && 0<i && i<n-1) || (j!=0 && j!=n-1 && i==(n-1)/2))
					System.out.print("II");
				else
					System.out.print(". ");
			}
		
		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && (i==1 || i==n-2)) || (i==j && i!=0 && i!=n-1))
					System.out.print("NN");
				else
					System.out.print(". ");
			}  
		

		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && i==1) || ((j==n-2||j==1) && 0<i && i<n-1) || (j==n/2 && i!=0 && i!=n-1))
					System.out.print("EE");
				else
					System.out.print(". ");
			}  
		
		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && (i==1 || i==n-2)) || (j==n-2 && 0<i && i<n-1))
					System.out.print("UU");
				else
					System.out.print(". ");
			}  
		

		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && i==1) || (j==1 && 0<i && i<n-1) || (j==n/2 && i!=0 && i!=n-1) || (i==n-2 && j!=0 && j<n/2) || (j-i==2 && j>4))
					System.out.print("RR");
				else
					System.out.print(". ");
			}  

		
		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && (i==1 || i==n-2)) || ((j==1 || j==n-2) && 0<i && i<n-1))
					System.out.print("00");
				else
					System.out.print(". ");
			}  

		
		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && (i==1 || i==n-2)) || (i==j && i!=0 && i!=n-1))
					System.out.print("NN");
				else
					System.out.print(". ");
			}  
            System.out.println("");
		}
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("The copyright of this product is strictly prohibited.");
		System.out.println("It was pleasure meeting you virtually. I'll be h@ppy to serve you again :)");
		System.out.println("------------------------------------------------------------------------------");
    }
}
