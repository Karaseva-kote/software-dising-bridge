package lab5;

import lab5.api.DrawingApi;
import lab5.api.JavaAwtDrawingApi;
import lab5.api.JavaFxDrawingApi;
import lab5.graphs.Edge;
import lab5.graphs.Graph;
import lab5.graphs.MatrixGraph;
import lab5.graphs.EdgesGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String requireArgumentsMessage = "expect 2 argument:\napi: awt or fx\ngraph type: matrix or edges";
		if (args == null || args.length != 2) {
			throw new IllegalArgumentException(requireArgumentsMessage);
		}

		DrawingApi api;
		switch (args[0]) {
			case "awt": {
				api = new JavaAwtDrawingApi();
				break;
			}
			case "fx": {
				api = new JavaFxDrawingApi();
				break;
			}
			default: throw new IllegalArgumentException(requireArgumentsMessage);
		}

		Graph graph ;
		switch (args[1]) {
			case "matrix": {
				graph = new MatrixGraph(api, readMatrix());
				break;
			}
			case "edges": {
				graph = new EdgesGraph(api, readEdges());
				break;
			}
			default: throw new IllegalArgumentException(requireArgumentsMessage);
		}

		graph.drawGraph();
	}

	private static List<List<Boolean>> readMatrix() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<List<Boolean>> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			List<Boolean> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				int a = scanner.nextInt();
				list.add(a != 0);
			}
			result.add(list);
		}
		return result;
	}

	private static List<Edge> readEdges() {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		List<Edge> result = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			result.add(new Edge(a - 1, b - 1));
		}
		return result;
	}
}
