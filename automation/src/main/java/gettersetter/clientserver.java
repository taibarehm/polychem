package gettersetter;

public class clientserver {
	
	String Xpath="//*[@class='gLFyf gsfi']";
	String qt="//*[@class='g']//a[@href='https://www.instagram.com/']";
	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getXpath() {
		return Xpath;
	}

	public void setXpath(String xpath) {
		Xpath = xpath;
	}
	

}
