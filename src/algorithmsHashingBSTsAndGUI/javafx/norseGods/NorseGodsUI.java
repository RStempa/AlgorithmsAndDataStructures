package algorithmsHashingBSTsAndGUI.javafx.norseGods;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class showing information on the different gods by selecting them from a
 * list.
 * 
 * @author Robin
 *
 */
public class NorseGodsUI extends Application {

	private ArrayList<God> gods = new ArrayList<God>(); // list of the gods
	private VBox box; // vbox containing the texts name, race and description

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20));
		root.setPrefSize(600, 600);
        // creating new gods with the info
		God thor = new God();
		thor.setName("Thor");
		thor.setRace("Aesir");
		thor.setDesc(
				"In Norse mythology, Thor is a hammer-wielding god associated with thunder, lightning, storms, oak trees, strength, "
						+ "the protection of mankind, and also hallowing and fertility. The cognate deity in wider Germanic mythology and paganism was known in Old English "
						+ "as Þunor and in Old High German as Donar (runic þonar ᚦᛟᚾᚨᚱ), stemming from a Common Germanic *Þunraz (meaning \"thunder\").");

		God odin = new God();
		odin.setName("Odin");
		odin.setRace("Aesir");
		odin.setDesc(
				"In Germanic mythology, Odin (from Old Norse Óðinn) is a widely revered god. In Norse mythology, from which stems most of the information about the god,"
						+ " Odin is associated with wisdom, healing, death, royalty, the gallows, knowledge, battle, sorcery, poetry, frenzy, and the runic alphabet,"
						+ " and is the husband of the goddess Frigg. In wider Germanic mythology and paganism, Odin was known in Old English as Wōden, in Old Saxon as Wōdan,"
						+ " and in Old High German as Wuotan or Wōtan, all stemming from the reconstructed Proto-Germanic theonym *wōđanaz.");

		God freyja = new God();
		freyja.setName("Freyja");
		freyja.setRace("Vanir");
		freyja.setDesc(
				"In Norse mythology, Freyja is a goddess associated with love, sex, beauty, fertility, gold, seiðr, war, "
						+ "and death. Freyja is the owner of the necklace Brísingamen, rides a chariot pulled by two cats, accompanied by the boar Hildisvíni, "
						+ "and possesses a cloak of falcon feathers. By her husband Óðr, she is the mother of two daughters, Hnoss and Gersemi."
						+ " Along with her twin brother Freyr, her father Njörðr, and her mother (Njörðr's sister, unnamed in sources), "
						+ "she is a member of the Vanir. Stemming from Old Norse Freyja, modern forms of the name include Freya, Freyia, and Freja.");

		God balder = new God();
		balder.setName("Balder");
		balder.setRace("Aesir");
		balder.setDesc(
				"Baldr (also Balder, Baldur or Baldor) is the god of light and radiance, peace and forgiveness in Norse mythology. "
						+ "A member of the Æsir, he is the son of Odin and Frigg, and twin brother to the blind god of darkness, Höðr."
						+ " His wife is called Nanna, with whom he had a son named Forseti, god of justice. "
						+ "Prior to his death, Baldr possessed a ship called Hringhorni, "
						+ "said to be the largest ship ever built. His hall is called Breidablik. Based on the Merseburg charms, his Germanic name may have been Phol.");

		God frigg = new God();
		frigg.setName("Frigg");
		frigg.setRace("Aesir");
		frigg.setDesc(
				"In Germanic mythology, Frigg (Old Norse), Frija (Old High German), Frea (Langobardic), and Frige (Old English) is a goddess. "
						+ "In nearly all sources, she is described as the wife of the god Odin. In Old High German and Old Norse sources, "
						+ "she is also connected with the goddess Fulla. The English weekday name Friday (etymologically Old English \"Frīge's day\") bears her name.");

		God ymir = new God();
		ymir.setName("Ymir");
		ymir.setRace("Giant");
		ymir.setDesc(
				"In Norse mythology, Ymir, Aurgelmir, Brimir, or Bláinn is the ancestor of all jötnar. Ymir is attested in the Poetic Edda, "
						+ "compiled in the 13th century from earlier traditional material, in the Prose Edda, written by Snorri Sturluson in the 13th century, "
						+ "and in the poetry of skalds. Taken together, several stanzas from four poems collected in the Poetic Edda refer to Ymir as a primeval"
						+ " being who was born from venom that dripped from the icy rivers Élivágar and lived in the grassless void of Ginnungagap."
						+ " Ymir birthed a male and female from the pits of his arms, and his legs together begat a six-headed being. "
						+ "The gods Odin, Vili and Vé fashioned the Earth (elsewhere personified as a goddess; Jörð) from his flesh, "
						+ "from his blood the ocean, from his bones the mountains, from his hair the trees, from his brains the clouds, "
						+ "from his skull the heavens, and from his eyebrows the middle realm in which mankind lives, Midgard. In addition, "
						+ "one stanza relates that the dwarfs were given life by the gods from Ymir's flesh and blood (or the Earth and sea).");

		God loki = new God();
		loki.setName("Loki");
		loki.setRace("Giant");
		loki.setDesc("Loki, often Anglicized as /ˈloʊki/) is a god in Norse mythology. "
				+ "Loki is in some sources the son of Fárbauti and Laufey, and the brother of Helblindi and Býleistr. "
				+ "By the jötunn Angrboða, Loki is the father of Hel, the wolf Fenrir, and the world serpent Jörmungandr."
				+ " By his wife Sigyn, Loki is the father of Narfi and/or Nari. By the stallion Svaðilfari, "
				+ "Loki is the mother—giving birth in the form of a mare—to the eight-legged horse Sleipnir."
				+ " In addition, Loki is referred to as the father of Váli in Prose Edda, "
				+ "though this source also refers to Odin as the father of Váli twice, and Váli is found mentioned as a Son of Loki only once.");

		God skadi = new God();
		skadi.setName("Skadi");
		skadi.setRace("Giant");
		skadi.setDesc(
				"In Norse mythology, Skaði (sometimes anglicized as Skadi, Skade, or Skathi) is a jötunn and goddess associated with bowhunting, skiing, winter, and mountains."
						+ " Skaði is attested in the Poetic Edda, compiled in the 13th century from earlier traditional sources; the Prose Edda and in Heimskringla, "
						+ "written in the 13th century by Snorri Sturluson, and in the works of skalds.");

		gods.add(thor);
		gods.add(odin);
		gods.add(freyja);
		gods.add(balder);
		gods.add(frigg);
		gods.add(ymir);
		gods.add(loki);
		gods.add(skadi);

		Label header = new Label("Norse Gods and other Beings");
		header.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

		final ListView<String> lv = new ListView<String>(); // makes the text scrollable
		final ScrollPane scrollPane = new ScrollPane(); // scrollable layout
		scrollPane.setMinWidth(350);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

		lv.setPrefWidth(200);
		for (int i = 0; i < gods.size(); i++) {
			lv.getItems().add(gods.get(i).getName());
		}

		lv.setOnMouseClicked(e -> {
			String name = lv.getSelectionModel().getSelectedItem();
			box = new VBox();
			for (God g : gods) { // setting the information about correct god
				if (g.getName().equals(name)) {
					Text gname = new Text(g.getName());
					gname.setFont(new Font(30));
					Text grace = new Text(g.getRace() + "\n");
					Text gdesc = new Text(g.getDesc());
					gdesc.setWrappingWidth(350);

					box.getChildren().addAll(gname, grace, gdesc);
					box.setPadding(new Insets(10));
					scrollPane.setContent(box);
				}
			}
		});
		lv.setPadding(new Insets(10));

		root.setTop(header);
		root.setLeft(lv);
		root.setRight(scrollPane);

		Scene scene = new Scene(root);
		primaryStage.setTitle("Norse Gods");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
