import java.util.ArrayList;
import java.util.*;

public class Interface {

	public static void main(String[] args) {
		String z = "";
		String c = "";
		Scanner input = new Scanner(System.in);
		while (!z.equals("no")) {
			z = "";
			c = "";
			int size = 0;
			System.out.print("Please enter the size of puzzle: ");
			size = input.nextInt();
			int[] a = new int[size];
			System.out
					.println("Please enter the values in order from the top of the clock moving clockwise:");
			for (int x = 0; x < size; x++) {
				System.out.print("Value " + (x + 1) + ": ");
				a[x] = input.nextInt();
			}
			input.nextLine();
			Solver s = new Solver(a, size);
			ArrayList<Clock> list = new ArrayList<Clock>();
			list = s.Solution();
			if (list.size() == 0) {
				System.out.println("There are no solutions");
			} else {
				System.out
						.println("There are "
								+ s.getTotalSolutions()
								+ " answer(s) to this puzzle, would you like to see one, or all of the solutions? ");
				c = input.nextLine();
				c.trim();
				if (c.equals("all")) {
					for (int b = 0; b < list.size(); b++) {
						System.out.println(list.get(b).toString());
					}
				} else
					System.out.println(list.get(0).toString());
			}
			System.out.print("Would you like to enter another puzzel? ");
			z = input.nextLine();
			z.trim();
		}
	}

}
