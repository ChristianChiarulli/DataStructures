import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class GenList<E>{
    public static void main(String[] args){
      //GenList<E> g = new GenList<E>();

      List<String> list = new ArrayList<String>();
      Scanner s = new Scanner(System.in);

      System.out.print("Enter some names or something: ");
      input = s.nextLine();

      for (int i = 0; i < 4; i++){
        System.out.print("anotha one: ");
        input = s.nextLine();
        list.add(input);
      }

      System.out.println(list);
      unique(list);
    }

    private static String input = " ";


    public static <E> boolean unique(List<E> list, E item){

      for (int i = 0; i < list.length(); i++){
        list[i] = "unique";
      }
    }
}
