import java.util.ArrayList;

public class Clock {

	private int[] solution;
	private boolean isCorrect = true;
	private int currentPosition;
	private boolean compleated = false;

	public Clock(int size, int currentPosition) {
		int x;
		this.solution = new int[size];
		this.currentPosition = currentPosition;
		this.solution[0] = this.currentPosition;
		for (x = 1; x < size; x++)
			this.solution[x] = -1;
	}

	public Clock(Clock c) {
		this(c.solution.length, c.currentPosition);
		for (int x = 0; x < c.solution.length; x++) {
			this.solution[x] = c.solution[x];
		}
	}

	public boolean compareSolution(ArrayList<Clock> c) {
		boolean theSame = false;
		for (int x = 0; x < c.size(); x++) {
			int y = 0;
			for (y = 0; y < c.get(x).getSolution().length; y++) {
				if (this.solution[y] == c.get(x).getSolution()[y]) {
				} else
					y = c.get(x).getSolution().length;

				if ((y == c.get(x).getSolution().length - 1))
					return true;
			}
		}
		return theSame;
	}

	public int[] getSolution() {
		return this.solution;
	}

	public boolean positionUsed(int position) {
		int x;
		for (x = 0; x < this.solution.length; x++) {
			if (this.solution[x] == position) {
				return true;
			}
		}
		return false;

	}

	public void notCorrect() {
		this.isCorrect = false;
	}

	public String toString() {
		String p = "";
		for (int s = 0; s < this.solution.length; s++)
			p = p + " " + (this.solution[s]+1);
		return p;
	}

	public void addPosition(int position) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int x = 0; x < this.solution.length; x++) {
			a.add(this.solution[x]);
		}
		int y = a.indexOf(-1);
		a.set(y, position);
		for (int z = 0; z < this.solution.length; z++)
			this.solution[z] = a.get(z);
	}

	public int getCurrentPosition() {
		return this.currentPosition;
	}

	public boolean getIsCorrect() {
		return this.isCorrect;
	}

	public void setcurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public boolean isCompleated() {
		return this.compleated;
	}

	public void checkCompleation() {
		if (this.solution[this.solution.length - 1] == -1)
			this.compleated = false;
		else
			this.compleated = true;
	}
}
