package lab5.geometry;

public class Point {
	private final double x;
	private final double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Point rotation(Point center, double angle) {
		double newX = x - center.getX();
		double newY = center.getY() - y;
		return new Point(
				newX * Math.cos(angle) - newY * Math.sin(angle) + center.getX(),
				center.getY() - newX * Math.sin(angle) - newY * Math.cos(angle)
		);
	}

	@Override
	public String toString() {
		return "Point{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
