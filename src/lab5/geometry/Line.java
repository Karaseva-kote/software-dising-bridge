package lab5.geometry;

public class Line {
	private final Point start;
	private final Point finish;

	public Line(Point start, Point finish) {
		this.start = start;
		this.finish = finish;
	}

	public Point getStart() {
		return start;
	}

	public Point getFinish() {
		return finish;
	}
}
