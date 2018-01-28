package leetcode.easy.numbers;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class RectangleOverlap {

	// Returns true if two rectangles (l1, r1) and (l2, r2) overlap
	boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
		// If one rectangle is on left side of other
		if (l1.x > r2.x || l2.x > r1.x)
			return false;

		// If one rectangle is above other
		if (l1.y < r2.y || l2.y < r1.y)
			return false;

		return true;
	}

	/* Driver program to test above function */
	public static void main() {
		Point l1 = new Point(0, 10);
		Point r1 = new Point(10, 0);

		Point l2 = new Point(5, 5);
		Point r2 = new Point(15, 0);
		RectangleOverlap rec = new RectangleOverlap();

		boolean isoverlap = rec.doOverlap(l1, r1, l2, r2);

		if (isoverlap)
			System.out.println("Rectangles Overlap");
		else
			System.out.println("Rectangles Don't Overlap");

	}
}
