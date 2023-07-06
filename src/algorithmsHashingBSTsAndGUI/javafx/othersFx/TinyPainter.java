package algorithmsHashingBSTsAndGUI.javafx.othersFx;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * Simple paint application. For Dot and Line a size must be selected.
 * 
 * @author Robin
 *
 */
public class TinyPainter extends Application {
	private double x, y; // x and y coordinates of mouseclick when shape has been selected.

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();
		root.setPrefSize(700, 700);

		ComboBox<String> shapes = new ComboBox<>();
		ComboBox<String> sizes = new ComboBox<>();
		shapes.getItems().addAll("Rectangle", "Circle", "Dot", "Line");
		sizes.getItems().addAll("1.0", "5.0", "10.0", "20.0", "40.0");
		ColorPicker colorPicker = new ColorPicker(); // final???
		colorPicker.setValue(Color.CORAL);

		HBox hb = new HBox();
		hb.getChildren().addAll(shapes, sizes, colorPicker);
		hb.setPadding(new Insets(5));
		hb.setSpacing(5);

		root.getChildren().add(hb);
		Scene scene = new Scene(root, 700, 700);

		root.setOnMousePressed(e -> {
			x = e.getX(); // setting x and y coordinates.
			y = e.getY();
			String shape;
			Double size;

			if (!sizes.getSelectionModel().isEmpty()) // set size that has been selected.
				size = Double.parseDouble(sizes.getSelectionModel().getSelectedItem());
			else
				size = 0.0; // if no size selected.

			if (!shapes.getSelectionModel().isEmpty()) {
				shape = shapes.getSelectionModel().getSelectedItem();

				if (shape.equals("Rectangle")) {
					Rectangle rec = new Rectangle();
					rec.setFill(colorPicker.getValue());
					rec.setX(e.getX());
					rec.setY(e.getY());
					root.getChildren().add(rec);
				}
				if (shape.equals("Dot")) {
					Rectangle dot = new Rectangle();
					dot.setWidth(size);
					dot.setHeight(size);
					dot.setFill(colorPicker.getValue());
					dot.setX(e.getX());
					dot.setY(e.getY());
					root.getChildren().add(dot);
				}
				if (shape.equals("Line")) {
					Line line = new Line();
					line.setStartX(e.getX());
					line.setStartY(e.getY());
					line.setEndX(e.getX());
					line.setEndY(e.getY());
					line.setStroke(colorPicker.getValue());
					line.setStrokeWidth(size);
					root.getChildren().add(line);
				}
				if (shape.equals("Circle")) {
					Circle circle = new Circle();
					circle.setCenterX(e.getX());
					circle.setCenterY(e.getY());
					circle.setFill(colorPicker.getValue());
					root.getChildren().add(circle);
				}
			}
		});

		root.setOnMouseDragged(e -> {
			double deltaX = e.getSceneX() - x;
			double deltaY = e.getSceneY() - y;

			if (!shapes.getSelectionModel().isEmpty()) {
				Shape shape = (Shape) root.getChildren().get(root.getChildren().size() - 1); // gets the last added
																								// shape
				if (shape instanceof Rectangle) {
					if (shapes.getSelectionModel().getSelectedItem().equals("Dot")) {
						((Rectangle) shape).setX(e.getSceneX());
						((Rectangle) shape).setY(e.getSceneY());
					} else if (shapes.getSelectionModel().getSelectedItem().equals("Rectangle")) {
						((Rectangle) shape).setWidth(deltaX);
						((Rectangle) shape).setHeight(deltaY);
					}
				}
				if (shape instanceof Line) {
					((Line) shape).setEndX(e.getSceneX());
					((Line) shape).setEndY(e.getSceneY());
				}
				if (shape instanceof Circle) {
					double radius = Math.sqrt((Math.pow(deltaX, 2)) + (Math.pow(deltaY, 2))); // r2 = (x−h)2+(y−k)2
					((Circle) shape).setCenterX(x);
					((Circle) shape).setCenterY(y);
					((Circle) shape).setRadius(radius);
				}
			}
		});
		primaryStage.setTitle("Tiny Painter");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
