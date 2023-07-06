package dataStructuresJUnitAndJavaFX.javafx;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Yatzee game
 * 
 * @author Robin
 *
 */
public class Yatzee extends Application {

	private int counter = 0; // counter for nr of dice rolls
	private int nr1; // numbers of the dice, randoms 1-6
	private int nr2;
	private int nr3;
	private int nr4;
	private int nr5;
	private int[] arr = new int[5]; // Array holding the dice numbers
	private Label result = new Label();; 
	private String points; // string containing points from the rolls

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
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER_LEFT);
		root.setPadding(new Insets(5, 5, 5, 5));
		root.setSpacing(5);

		Label heading = new Label("Yahtzee");
		Font font = new Font(70);
		heading.setFont(font);

		VBox vb1 = new VBox(); // vbox for first dice and checkbox together
		Image d1 = new Image("1.png");
		ImageView iv1 = new ImageView();
		CheckBox cb1 = new CheckBox();
		iv1.setImage(d1);
		vb1.setAlignment(Pos.BASELINE_CENTER);
		cb1.setDisable(true);
		vb1.getChildren().addAll(iv1, cb1);

		VBox vb2 = new VBox(); // vbox for second dice and checkbox together so on
		Image d2 = new Image("2.png");
		ImageView iv2 = new ImageView();
		CheckBox cb2 = new CheckBox();
		vb2.setAlignment(Pos.BASELINE_CENTER);
		iv2.setImage(d2);
		cb2.setDisable(true);
		vb2.getChildren().addAll(iv2, cb2);

		VBox vb3 = new VBox();
		Image d3 = new Image("3.png");
		ImageView iv3 = new ImageView();
		CheckBox cb3 = new CheckBox();
		vb3.setAlignment(Pos.BASELINE_CENTER);
		iv3.setImage(d3);
		cb3.setDisable(true);
		vb3.getChildren().addAll(iv3, cb3);

		VBox vb4 = new VBox();
		Image d4 = new Image("4.png");
		ImageView iv4 = new ImageView();
		CheckBox cb4 = new CheckBox();
		vb4.setAlignment(Pos.BASELINE_CENTER);
		iv4.setImage(d4);
		cb4.setDisable(true);
		vb4.getChildren().addAll(iv4, cb4);

		VBox vb5 = new VBox();
		Image d5 = new Image("5.png");
		ImageView iv5 = new ImageView();
		CheckBox cb5 = new CheckBox();
		vb5.setAlignment(Pos.BASELINE_CENTER);
		iv5.setImage(d5);
		cb5.setDisable(true);
		vb5.getChildren().addAll(iv5, cb5);

		HBox diceBox = new HBox(); // hbox for all vboxes with image and checkbox
		diceBox.setSpacing(5);
		diceBox.getChildren().addAll(vb1, vb2, vb3, vb4, vb5);

		Button btn = new Button();
		btn.setText("Roll the dice!");
		Font font2 = new Font(20);
		btn.setFont(font2);
		btn.setPrefWidth(180);

		final HBox hb = new HBox(); // hbox for button and result
		hb.setPadding(new Insets(20, 20, 10, 10));
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER_LEFT);
		hb.getChildren().addAll(btn, result);

		btn.setOnAction(e -> {
			Random rand = new Random();
			counter++;
			if (counter < 3)
			result.setText("You have " + (3-counter) + " rolls left" );

			if (counter < 3) {
				cb1.setDisable(false); // activating checkboxes
				cb2.setDisable(false);
				cb3.setDisable(false);
				cb4.setDisable(false);
				cb5.setDisable(false);

				if (!cb1.isSelected()) {
					nr1 = rand.nextInt(6) + 1;
					iv1.setImage(new Image(nr1 + ".png"));
					arr[0] = nr1;
				}
				if (!cb2.isSelected()) {
					nr2 = rand.nextInt(6) + 1;
					iv2.setImage(new Image(nr2 + ".png"));
					arr[1] = nr2;
				}
				if (!cb3.isSelected()) {
					nr3 = rand.nextInt(6) + 1;
					iv3.setImage(new Image(nr3 + ".png"));
					arr[2] = nr3;
				}
				if (!cb4.isSelected()) {
					nr4 = rand.nextInt(6) + 1;
					iv4.setImage(new Image(nr4 + ".png"));
					arr[3] = nr4;
				}
				if (!cb5.isSelected()) {
					nr5 = rand.nextInt(6) + 1;
					iv5.setImage(new Image(nr5 + ".png"));
					arr[4] = nr5;
				}
			} else if (counter == 3)
				setPoints();
		});

		root.getChildren().addAll(heading, diceBox, hb);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Yahtzee");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void setPoints() {
		points = ""; // int to string built of points from array
		int[] matches = new int[6]; // Array holding number of matches
    
		boolean threeOfaKind = false;
		boolean pair = false;
		boolean fourOfaKind = false;
		boolean fullHouse = false;
		boolean yatzee = false;
		boolean largeStraight = false;
		boolean smallStraight = false;

		for (int i = 0; i < 5; i++) {
			points += Integer.toString(arr[i]); // sets string of points from all numbers of the dice
		}

		int ones = (int) points.chars().filter(ch -> ch == '1').count(); // gets the ones from string points so on
		int twos = (int) points.chars().filter(ch -> ch == '2').count();
		int threes = (int) points.chars().filter(ch -> ch == '3').count();
		int foures = (int) points.chars().filter(ch -> ch == '4').count();
		int fives = (int) points.chars().filter(ch -> ch == '5').count();
		int sixes = (int) points.chars().filter(ch -> ch == '6').count();

		matches[0] = ones; // adds the amount of ones so on
		matches[1] = twos;
		matches[2] = threes;
		matches[3] = foures;
		matches[4] = fives;
		matches[5] = sixes;
		
		if (points.contains("23456")) // setting the results boolean
			largeStraight = true;
		if (points.contains("12345"))
			smallStraight = true;		

		for (int i : matches) { // setting the results boolean
			if (i == 5)
				yatzee = true;
			if (i == 4)
				fourOfaKind = true;
			if (i == 3)
				threeOfaKind = true;
			if (i == 2)
				pair = true;
		}
		// checking and printing score		
		if (yatzee)
			result.setText("Yatzee");
		else if (fourOfaKind)
			result.setText("Four of a kind");
		else if (threeOfaKind)
			result.setText("Three of a kind");
		else if (fullHouse)
			result.setText("Full house");
		else if (largeStraight)
			result.setText("largeStraight");
		else if (smallStraight)
			result.setText("smallStraight");
		else if (pair)
			result.setText("pair");
		else
			result.setText("Nothing");
	}
}
