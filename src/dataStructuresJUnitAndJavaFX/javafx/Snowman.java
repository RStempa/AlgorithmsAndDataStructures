package dataStructuresJUnitAndJavaFX.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * Makes a snowman from different shapes
 * 
 * @author Robin
 *
 */
public class Snowman extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * start method
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group(); // root group

		Shape square1 = new Rectangle(0, 0, 1000, 650); // the sky
		square1.setFill(Color.DEEPSKYBLUE);
		Shape square2 = new Rectangle(0, 650, 1000, 200); // the ground
		square2.setFill(Color.WHITE);

		// the snowman and sun circles
		Shape circle1 = new Circle(500, 300, 50);
		circle1.setFill(Color.WHITE);
		Shape circle2 = new Circle(500, 415, 80);
		circle2.setFill(Color.WHITE);
		Shape circle3 = new Circle(500, 560, 110);
		circle3.setFill(Color.WHITE);
		Shape circle4 = new Circle(800, 150, 110);
		circle4.setFill(Color.YELLOW);

		Shape mouth = new Line(480, 310, 520, 310);
		mouth.setFill(Color.BLACK);
		mouth.setStrokeWidth(4);
		Shape eye1 = new Circle(485, 280, 5);
		Shape eye2 = new Circle(515, 280, 5);

		Shape c1 = new Circle(500, 370, 5);
		Shape c2 = new Circle(500, 410, 5);
		Shape c3 = new Circle(500, 450, 5);

		root.getChildren().addAll(square1, circle1, circle2, circle3, circle4, square2, c1, c2, c3, mouth, eye1, eye2);

		Scene scene = new Scene(root, 1000, 800);
		primaryStage.setTitle("Snowman");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
