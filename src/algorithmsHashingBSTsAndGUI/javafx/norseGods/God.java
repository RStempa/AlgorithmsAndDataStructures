package algorithmsHashingBSTsAndGUI.javafx.norseGods;

/**
 * Class representing a god with getters and setters
 * 
 * @author Robin
 *
 */
public class God {

	private String name;
	private String race;
	private String desc;

	public God() {

	}

	public God(String n, String r, String d) {
		name = n;
		race = r;
		desc = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
