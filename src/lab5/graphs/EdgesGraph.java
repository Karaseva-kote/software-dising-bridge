package lab5.graphs;

import lab5.api.DrawingApi;
import lab5.geometry.Line;

import java.util.List;

public class EdgesGraph extends Graph {
	private final List<Edge> graph;

	public EdgesGraph(DrawingApi drawingApi, List<Edge> graph) {
		super(
				drawingApi,
				graph.stream().map(edge -> Math.max(edge.getX(), edge.getY()) + 1).max(Integer::compareTo).orElse(0)
		);
		this.graph = graph;
	}

	@Override
	public void drawGraph() {
		for (Edge edge : graph) {
			drawingApi.addLine(new Line(map.get(edge.getX()), map.get(edge.getY())));
		}
		map.forEach(point -> drawingApi.addCircle(point, 10));
		drawingApi.draw();
	}
}
