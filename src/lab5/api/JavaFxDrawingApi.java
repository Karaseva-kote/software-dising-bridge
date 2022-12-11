package lab5.api;

import lab5.geometry.Line;
import lab5.geometry.Point;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class JavaFxDrawingApi implements DrawingApi {
	private static final int width = 600;
	private static final int height = 400;
	private static final Canvas canvas = new Canvas(width, height);
	private final List<Consumer<GraphicsContext>> actions = new ArrayList<>();

	@Override
	public long getDrawingAreaWidth() {
		return width;
	}

	@Override
	public long getDrawingAreaHeight() {
		return height;
	}

	@Override
	public void addCircle(Point center, double radius) {
		actions.add(gc -> {
			gc.setFill(Color.GREEN);
			gc.fillOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
		});
	}

	@Override
	public void addLine(Line line) {
		actions.add(gc -> {
			gc.setFill(Color.RED);
			gc.strokeLine(
					line.getStart().getX(),
					line.getStart().getY(),
					line.getFinish().getX(),
					line.getFinish().getY()
			);
		});
	}

	@Override
	public void draw() {
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		actions.forEach(action -> action.accept(gc));

		JavaFxDrawingGraphApp.init(canvas);
		Application.launch(JavaFxDrawingGraphApp.class);
	}
}
