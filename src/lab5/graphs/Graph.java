package lab5.graphs;

import lab5.api.DrawingApi;
import lab5.geometry.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph {
	protected DrawingApi drawingApi;
	protected final List<Point> map;

	public Graph(DrawingApi drawingApi, int vertexCount) {
		this.drawingApi = drawingApi;
		this.map = new ArrayList<>();
		Point start = new Point(((double) drawingApi.getDrawingAreaWidth()) / 2, 40);
		Point center = new Point(
				((double) drawingApi.getDrawingAreaWidth()) / 2,
				((double) drawingApi.getDrawingAreaHeight()) / 2
		);
		double angle = 2 * Math.PI / vertexCount;
		for (int i = 0; i < vertexCount; i++) {
			map.add(start);
			start = start.rotation(center, angle);
		}
	}

	public abstract void drawGraph();
}