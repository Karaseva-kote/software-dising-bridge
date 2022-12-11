package lab5.api;

import lab5.geometry.Line;
import lab5.geometry.Point;

public interface DrawingApi {
	long getDrawingAreaWidth();
	long getDrawingAreaHeight();
	void addCircle(Point center, double radius);
	void addLine(Line line);
	void draw();
}