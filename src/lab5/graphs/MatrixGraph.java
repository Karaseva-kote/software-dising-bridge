package lab5.graphs;

import lab5.api.DrawingApi;
import lab5.geometry.Line;

import java.util.List;

public class MatrixGraph extends Graph {
	private final List<List<Boolean>> graph;

	public MatrixGraph(DrawingApi drawingApi, List<List<Boolean>> graph) {
		super(drawingApi, graph.size());
		this.graph = graph;
	}

	@Override
	public void drawGraph() {
		for (int i = 0; i < graph.size(); i++) {
			List<Boolean> list = graph.get(i);
			for(int j = i; j < list.size(); j++) {
				if (list.get(j)) {
					drawingApi.addLine(new Line(map.get(i), map.get(j)));
				}
			}
		}
		map.forEach(point -> drawingApi.addCircle(point, 10));
		drawingApi.draw();
	}
}
