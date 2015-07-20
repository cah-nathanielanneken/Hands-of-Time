import java.util.ArrayList;

public class Solver {

	private int[] clockFace;
	private int size;
	private int totalSolutions = 0;
	private ArrayList<Clock> list = new ArrayList<Clock>();

	public Solver(int[] clockFace, int size) {
		this.size = size;
		this.clockFace = new int[size];
		for (int temp = 0; temp < size; temp++) {
			this.clockFace[temp] = clockFace[temp];
		}
	}

	public int getTotalSolutions() {
		return this.totalSolutions;
	}

	private int getClockErrorPlus(int currentPosition) {
		int clockErrorPlus = 0;
		if (this.clockFace[currentPosition] + currentPosition >= this.size)
			clockErrorPlus = this.clockFace[currentPosition] + currentPosition
					- (this.size);
		else
			clockErrorPlus = this.clockFace[currentPosition] + currentPosition;
		return clockErrorPlus;
	}

	private int getClockErrorMinus(int currentPosition) {
		int clockErrorMinus = 0;
		if (currentPosition - this.clockFace[currentPosition] < 0)
			clockErrorMinus = (currentPosition - this.clockFace[currentPosition])
					+ this.size;
		else
			clockErrorMinus = currentPosition - this.clockFace[currentPosition];
		return clockErrorMinus;
	}

	private boolean canMoveClockwise(Clock c, int clockErrorPlus) {
		boolean canMove = !c.positionUsed(clockErrorPlus);
		return canMove;
	}

	private boolean canMoveCounterClockwise(Clock c, int clockErrorMinus) {
		boolean canMove = !c.positionUsed(clockErrorMinus);
		return canMove;
	}

	private void moveClockWise(int clockErrorPlus, Clock c) {
		if (canMoveClockwise(c, clockErrorPlus)) {
			c.addPosition(clockErrorPlus);
			c.setcurrentPosition(clockErrorPlus);
		} else
			c.notCorrect();
	}

	private void moveCounterClockwise(int clockErrorMinus, Clock c) {
		if (canMoveCounterClockwise(c, clockErrorMinus)) {
			c.addPosition(clockErrorMinus);
			c.setcurrentPosition(clockErrorMinus);
		} else
			c.notCorrect();
	}

	private void SolutionF(Clock a) {

		Clock c = new Clock(a);
		Clock d = new Clock(a);
		int clockErrorPlus = 0, clockErrorMinus = 0;

		clockErrorPlus = getClockErrorPlus(c.getCurrentPosition());
		clockErrorMinus = getClockErrorMinus(c.getCurrentPosition());
		moveClockWise(clockErrorPlus, c);
		if (c.getIsCorrect()) {
			SolutionF(c);
		}

		clockErrorPlus = getClockErrorPlus(d.getCurrentPosition());
		clockErrorMinus = getClockErrorMinus(d.getCurrentPosition());
		moveCounterClockwise(clockErrorMinus, d);
		if (d.getIsCorrect())
			SolutionF(d);

		c.checkCompleation();
		d.checkCompleation();

		if (c.isCompleated()) {
			if (list.size() == 0) {
				this.list.add(c);
				this.totalSolutions++;
			} else {
				boolean notThere1 = true;
				for (int x = 0; x < list.size(); x++) {
					if (c.compareSolution(list)) {
						notThere1 = false;
					}
				}
				if (notThere1) {
					this.list.add(c);
					this.totalSolutions++;
				}
			}
		}
		if (d.isCompleated()) {
			if (list.size() == 0) {
				this.list.add(d);
				this.totalSolutions++;
			} else {
				boolean notThere2 = false;
				for (int y = 0; y < list.size(); y++) {
					if (d.compareSolution(list)) {
						notThere2 = false;
					}
				}
				if (notThere2) {
					this.list.add(d);
					this.totalSolutions++;
				}
			}
		}

	}

	public ArrayList<Clock> Solution() {

		for (int startingPosition = 0; startingPosition < this.size; startingPosition++) {
			Clock c = new Clock(this.size, startingPosition);
			SolutionF(c);
		}

		return list;

	}
}
