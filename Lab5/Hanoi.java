import java.util.ArrayList;
import java.util.Scanner;
public class Hanoi {
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	Stack<Integer> s3 = new Stack<>();
	public static int size;
	public void move_recursive(int x, Stack<Integer> s11, Stack<Integer> s22, Stack<Integer> s33) {
		if (x != 0) {
			move_recursive(x-1, s11, s33, s22);
      display();
			s33.push(s11.pop());
			move_recursive(x-1, s22, s11, s33);
		}
	}
	public void display() {
		String endString = "";
		endString = endString + show(s1, "A");
		endString = endString + show(s2, "B");
		endString = endString + show(s3, "C");
    System.out.println(endString);
	}
	private String show(Stack<Integer> stack, String base) {
		String val = "";
		ArrayList<Integer> list = new ArrayList<>();
		while (stack.size() != 0)
			list.add(stack.pop());
		for (Integer each : list)
			val = val + "|" + each + "|\n";
		  val = val + "|"+ base + "|\n\n";
		for (int i = list.size() - 1; i >= 0; i--)
			stack.push(list.get(i));
		return val;
	}
	public static void main(String args[]) {
		Hanoi tower = new Hanoi();
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter size of tower: ");
    size = sc.nextInt();
    int n = size;
    for (int i = n; i > 0; i--)
			tower.s1.push(i);
		tower.move_recursive(tower.size, tower.s1, tower.s2, tower.s3);
    tower.display();
	}
}
