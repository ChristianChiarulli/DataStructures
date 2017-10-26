import java.util.Scanner;

public class Palindrome{
  public static void main(String[] args){
    Stack<Character> s =  new Stack<>();
    Queue<Character> q = new Queue<>();
    Scanner sc = new Scanner(System.in);
    String in = null;
    StringBuilder resultq = new StringBuilder();
    do{
      System.out.print("Enter Palindrome or \"quit\" to end the program: ");
      in = sc.nextLine();

      for(int i = 0; i < in.length(); i++){
        if((in.charAt(i) >= 'a' && in.charAt(i) <= 'z') || (in.charAt(i) >= 'A' && in.charAt(i) <= 'Z') || (in.charAt(i) >= '0' && in.charAt(i) <= '9'))
          s.push(in.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while(!s.empty()) {
  			  result.append(s.pop());
  		  }
        if(result.toString().equalsIgnoreCase(in.replaceAll("[^a-zA-Z0-9]",""))){
        q.offer('\n');
        for(int i = in.length() - 1; i >= 0; i--){
        //  if((in.charAt(i) >= 'a' && in.charAt(i) <= 'z') || (in.charAt(i) >= 'A' && in.charAt(i) <= 'Z') || (in.charAt(i) >= '0' && in.charAt(i) <= '9'))
            q.offer(in.charAt(i));
        }
        q.offer('\n');
        }

      while(!q.empty()) {
			  resultq.append(q.poll());
		  }

      if(result.toString().equalsIgnoreCase(in.replaceAll("[^a-zA-Z0-9]",""))){
         System.out.println("\nYou have a palindrome\n");
       }
      else{
          if(!in.equalsIgnoreCase("quit"))
            System.out.println("\nDo you know what a palindrome is?\n");
        }
      }while(!in.equalsIgnoreCase("quit"));
      System.out.println(resultq);
  }
}
