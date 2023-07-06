package algorithmsHashingBSTsAndGUI.javafx.othersFx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Class animated character running back and forth
 * 
 * @author Robin
 *
 */
public class Running extends Application {

	private int i = 1; // number of image when running
	private int j = 5; // distance position for x when running

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();
		// setting the scene with images
		ImageView ivBg = new ImageView(new Image("png2/BG/BG.png"));
		ivBg.setFitWidth(800);
		ivBg.setFitHeight(600);

		ImageView ivRun = new ImageView(new Image("png/Run (1).png"));
		ivRun.setFitWidth(200);
		ivRun.setFitHeight(150);
		ivRun.setX(100);
		ivRun.setY(300);

		ImageView ivGr = new ImageView(new Image("png2/Tiles/2.png"));
		ivGr.setFitWidth(800);
		ivGr.setFitHeight(170);
		ivGr.setY(430);

		ImageView ivTr = new ImageView(new Image("png2/Object/Tree_2.png"));
		ivTr.setFitWidth(100);
		ivTr.setFitHeight(150);
		ivTr.setX(700);
		ivTr.setY(300);

		ImageView ivSm = new ImageView(new Image("png2/Object/SnowMan.png"));
		ivSm.setFitWidth(100);
		ivSm.setFitHeight(130);
		ivSm.setX(-5);
		ivSm.setY(300);

		Timeline tl = new Timeline(new KeyFrame(Duration.millis(30), e -> {
			ivRun.setX(ivRun.getX() + j); // moving the iv
			if (ivRun.getBoundsInLocal().intersects(ivTr.getBoundsInLocal())) { // check if iv reached end to turn
				ivRun.setScaleX(-1); // reversing
				j = -j;
			}
			if (ivRun.getBoundsInLocal().intersects(ivSm.getBoundsInLocal())) { // check for iv to turn again
				ivRun.setScaleX(1);
				j = 5;
			}
			if (i <= 10) // counting nr of image
				i += 1;
			else
				i = 1; // setting image from first again
			ivRun.setImage(new Image("png/Run (" + i + ").png"));
		}));
		tl.setCycleCount(Animation.INDEFINITE);
		tl.play();

		root.getChildren().addAll(ivBg, ivGr, ivRun, ivTr, ivSm);
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("Running sprite");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
