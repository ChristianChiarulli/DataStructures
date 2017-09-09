/*
* Christian Chiarulli
* Lab 1 GuessingGame
* I chose not to include a try a try catch block because I went with the regex implementation
* The regex validator should be sufficient to filter out inputs that a re unnacceptable
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class GuessingGame{

List list = new ArrayList();

// variables to be used throughout the class
private String guess = null;
private String longGuess = "you didn't even try";

// Displays a greeting to the user
  public void greeting(){
    System.out.println("Welcome to the game here are some numbers");
    System.out.println("3, 6, 9");
    System.out.println("Your job is to find the pattern");
  }

// Reads inputs and displays output
  public void readInputsAndDisplay(){
      Scanner s = new Scanner(System.in);

      int[] arr = new int[3]; //array list to hold numbers in guess

      // populates array with 1's because its automatically populated with zeros, this helps with false positives
      for (int k = 0; k < arr.length; k++){
        arr[k] = 1;
      }
      System.out.println("Enter your guess as three positive integers, 'answer' to see the pattern\nor 'previous' to see your past guesses\n ");

      // main loop of program
      do{
      System.out.print("Enter your next guess: ");
      guess = s.nextLine();
      String[] splitted = guess.split(" ");
      if (guess.matches("^\\d+\\s\\d+\\s\\d+$")){
        //System.out.println("regular expression confirmed");
        for (int i = 0; i < splitted.length; i++){
          //System.out.println(splitted[i]);
          arr[i] = Integer.parseInt(splitted[i]);
          //System.out.println(arr[i]);
        }

        check(arr);
      } 

      else if (guess.equals("answer")){
        System.out.println("What is your guess?");
        longGuess = s.nextLine();
        System.out.println("The answer is the numbers are all divisible by 3.");
        System.exit(0);
      }
      else if (guess.equals("previous")){
        for (int i = 0; i < list.size(); i++){
          //String getString = list.get(i);
          System.out.println(list.get(i));
        }
        System.out.println();
      }
      else{
        System.out.println("Please enter valid input\n");
      }
    }while(!guess.equals("answer"));
  }
  // checks if valid input follows the rule
  public void check(int[] arr){
    if (arr[0] % 3 == 0 && arr[1] % 3 == 0 && arr[2] % 3 == 0){
      System.out.println("Yes!\n");
      list.add(guess + " Right!");
    }
    else{
      System.out.println("No.\n");
      list.add(guess + " Wrong.");
    }
  }

  public String toString() {
		return this.guess;
	}

  public static void main(String[] args){
    //instantiate object;
    GuessingGame g = new GuessingGame();
    g.greeting();
    g.readInputsAndDisplay();
  }
}
