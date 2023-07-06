package dataStructuresJUnitAndJavaFX.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class that calculates compund interest on a loan
 * 
 * @author Robin
 *
 */
public class CompoundInterest extends Application {

	private double amount;
	private double interest;
	private double time;
	private double tot;

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * Start method
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane root = new GridPane(); // the root node
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(10));
		root.setVgap(10);
		root.setHgap(5);
		root.setPrefWidth(600);

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(50);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(50);
		root.getColumnConstraints().addAll(column1, column2);

		Text text = new Text("Compound Interest");
		Font font = new Font(65);
		Font font2 = new Font(20);

		text.setFont(font);
		GridPane.setConstraints(text, 0, 0); // column=0 row=0

		Label label1 = new Label("Start amount:");
		label1.setFont(font2);
		GridPane.setConstraints(label1, 0, 1); // column=0 row=1

		final TextField tf = new TextField(); // for the input 1
		GridPane.setConstraints(tf, 1, 1);

		Label label2 = new Label("Interest:");
		label2.setFont(font2);
		GridPane.setConstraints(label2, 0, 2);

		final TextField tf2 = new TextField(); // for the input 2
		GridPane.setConstraints(tf2, 1, 2);

		Label label3 = new Label("Number of years:");
		label3.setFont(font2);
		GridPane.setConstraints(label3, 0, 3);

		final TextField tf3 = new TextField(); // for the input 3
		GridPane.setConstraints(tf3, 1, 3);

		Button btn = new Button("Calculate");
		btn.setFont(font2);
		GridPane.setConstraints(btn, 0, 4);

		final Label result = new Label();
		result.setFont(font2);
		GridPane.setConstraints(result, 0, 5);
		// lambda, when button is clicked - gets input and calculates compound interest
		btn.setOnAction(e -> {
			try {
				amount = Double.parseDouble(tf.getText());
				interest = Double.parseDouble(tf2.getText()) / 100 + 1;
				time = Double.parseDouble(tf3.getText());
				interest = Math.pow(interest, time);
				tot = amount * interest;
				result.setText("In total that will be " + Math.round(tot)); // sets result text in label
			} catch (NumberFormatException e1) {
				result.setText("All input must be numbers!");
				e1.printStackTrace();
			}
		});

		root.getChildren().addAll(label1, tf, label2, tf2, btn, text, label3, tf3, result);

		Scene scene = new Scene(root, 600, 350);
		primaryStage.setTitle("Compound interest");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
