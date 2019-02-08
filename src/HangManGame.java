package SoftTech;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangManGame {
	private static String [] words = {"SALVADOR", "BATTLER", "ROYAL", "BLOODBORNE", "GRAND", "LEAGUE", "LEGENDS", "PROGRESS", "TROPHIES", "BEGINNING", "COMMUNITY", "REDEMPTION", "PORTUGAL", "LEONARDO", "DICTIONARY", "FRANCE", "LOIC", "APPLICATION", "SPAIN", "BENGTH", "ANAS", "DONALD", "RUSSIA", "MAX", "YARO", "TABLE", "FISH", "TIGER", "FISH", "HELLO", "YESTERDAY", "HOTEL", "SCHOOL", "GAMES", "COMPUTER"};
	private static String Original; 
	private static String [] Covered ;
	private static String [] CopyC;
	private static ArrayList<String> WrongL = new ArrayList<String>();
	private static int countWrong;
	
	public static void main(String[]args) {
	    //Randomize a word from the database
		Random randIndex = new Random();
		int index = randIndex.nextInt(words.length);
		Original = words[index];
		//System.out.print(Original);
		System.out.println("= Guess the secret word =");
		Covered = Original.split("");
		CopyC= Covered.clone();
		for(int i = 0;i<Original.length();i++) {
			CopyC [i] = "_ ";
			System.out.print(CopyC [i]+" ");
		}
		
		                                                  
		//Start                                                    //Original = HOTEL
		while(countWrong <= 6) {                                  //Covered = H O T E L
		Scanner sc = new Scanner(System.in); 
		
		//When you get the correct word
		if(Arrays.equals(CopyC, Covered)) {
			System.out.println("\nYOU WON !!");
			sc.close();
			break;
		}
		//CopyC = _ _ _ _ _ 
		System.out.println("\nGuess a letter :");
		String Guess = sc.nextLine();
		Guess = Guess.toUpperCase();
		
		//Replace spaces with correct guess letter
		boolean check=false;
		for(int j = 0;j<Covered.length;j++) {
			String help = Covered[j];
			if (help.equals(Guess) ) {
			CopyC[j] = Guess;
			check = true;
			}
		}
		
		if (check==false) {
			countWrong++;
			WrongL.add(Guess);
		}
		//Print out for wrong letter and lives left
		System.out.println("\nYou have "+(7-countWrong)+" lives left.");
		System.out.println("Wrong letters :"+WrongL.toString());
		
		//Print out (Letter + _ _ )
		for(int x = 0;x<Covered.length;x++) {
			System.out.print(CopyC [x]+" ");
			}
		
		}
		
		if(countWrong >= 7)	{
			System.out.println("\nGAME OVER");
			System.out.println("Secret word was"+ "\""+Original+"\"");
}
	
		
	

	}
	
	}
	

