/*
* Christian Chiarulli
* This program will introduce the concepts of generics
* I did achieve the extra credit goal
*
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class GenList<E>{
    public static void main(String[] args){
      // 2.1, 2.2, 2.3
      List<Integer> list = new ArrayList<>();
      Scanner s = new Scanner(System.in);
      int intInput = 0;

      System.out.print("Enter some numbers to test: ");
      intInput = s.nextInt();

      list.add(intInput);

      for (int i = 0; i < 4; i++){
        System.out.print("anotha one: ");
        intInput = s.nextInt();
        list.add(intInput);
      }
      System.out.println();
      System.out.println(list);
      System.out.println(unique(list));
      System.out.println(sum(list));

      System.out.print("Enter a number to return the numbers in the list that divide evenly: ");
      intInput = s.nextInt();
      System.out.println(allMultiples(list, intInput));

      //This will test 2.4, 2.5, 2.6
      List<String> strList = new ArrayList<>();
      String strInput = " ";

      System.out.print("Enter size of strings you want to return: ");
      intInput = s.nextInt();
      strInput = s.nextLine(); // <---- apparently the nextInt() leaves a \n behind after you press enter

      System.out.print("Now lets enter some strings: ");
      strInput = s.nextLine();

      strList.add(strInput);

      for (int i = 0; i < 4; i++){
        System.out.print("anotha one: ");
        strInput = s.nextLine();
        strList.add(strInput);
      }

      System.out.println(allStringsOfSize(strList, intInput));

      System.out.print("Enter a sentence to be split: ");
      strInput = s.nextLine();

      System.out.println(stringToListOfWords(strInput));

      System.out.print("Enter an item you want removed from the list: ");
      intInput = s.nextInt();
      //strInput = s.nextLine(); // for a String

      removeAllInstances(list, intInput); // for an int
      //removeAllInstances(strList, strInput); // for a String
    }
    // reads in a generic list and returns a boolean if the list has all unique elements
    public static <E> boolean unique(List<E> list){
      Set<E> listSet = new HashSet<E>(list); // this gets the set of all of the members of the list which will leave out dupes
      boolean check = true;
      if (listSet.size() != list.size()) // if the set doesn't equal the list the values are not unique
        check = false;
      return check;
    }
    // reads in a list of integers sums them up and returns a integer with  the sum
    public static int sum(List<Integer> list){
      Integer sum = 0;
      for (int i = 0; i < list.size(); i++)
        sum += list.get(i);
      return sum;
    }
    // reads in a integer list and a number and returns a list
    public static List allMultiples(List<Integer> list, int num){
      List<Integer> newList = new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
        if (list.get(i) % num == 0)
          newList.add(list.get(i));
      return newList;
    }
    // reads in a list of strings and an int length and returns a list of strings that have int length length
    public static List<String> allStringsOfSize(List<String> list, int length){
      List<String> newList = new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
        if (list.get(i).length() == length)
          newList.add(list.get(i));
      return newList;
    }
    // splits a string by spaces and sanitizes it
    public static List<String> stringToListOfWords(String sentence){
      List<String> newList = new ArrayList<>();
      String clean = sentence.replaceAll("[^a-zA-Z0-9]"," "); //  extra credit
      String[] parts = clean.split("\\s+");
      for (int i = 0; i < parts.length; i++)
        newList.add(parts[i]);
      return newList;
    }
    // removes all instances of an element from a list
    public static <E> void removeAllInstances(List<E> list, E item){
      for (int i = 0; i < list.size(); i++){
        if (list.get(i).equals(item) || list.get(i) == item){
          list.remove(i);
          i--;
        }
      }
      System.out.println(list);
    }
}
