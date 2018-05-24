package training.entity;

public class Message {
	private String text;
	private String username;

	public Message() {
	}

	// accessor (getter) "text"
	public String getText() {
		return text;
	}

	// mutator (setter) "text"
	// spring can inject a value to a field using this setter property
	public void setText(String text) {
		this.text = text;
	}

	public String getFrom() {
		return username;
	}

	public void setFrom(String from) {
		this.username = from;
	}

}
