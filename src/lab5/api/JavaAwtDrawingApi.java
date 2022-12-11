package lab5.api;

import lab5.geometry.Line;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import lab5.geometry.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class JavaAwtDrawingApi extends Frame implements DrawingApi {
	private final int width = 600;
	private final int height = 400;
	private final List<Consumer<Graphics2D>> actions = new ArrayList<>();

	public long getDrawingAreaWidth() {
		return width;
	}

	public long getDrawingAreaHeight() {
		return height;
	}

	@Override
	public void addCircle(Point center, double radius) {
		actions.add(ga -> {
			ga.setPaint(Color.blue);
			ga.fill(new Ellipse2D.Double(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius));
		});
	}

	@Override
	public void addLine(Line line) {
		actions.add(ga -> {
			ga.setColor(Color.red);
			ga.drawLine(
					(int) line.getStart().getX(),
					(int) line.getStart().getY(),
					(int) line.getFinish().getX(),
					(int) line.getFinish().getY()
			);
		});
	}

	@Override
	public void draw() {
		Frame frame = this;
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		frame.setSize(width, height);
		frame.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D ga = (Graphics2D) g;
		actions.forEach(consumer -> consumer.accept(ga));
	}
}
