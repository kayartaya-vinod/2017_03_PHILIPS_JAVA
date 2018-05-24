package training.model;

public class InvalidParamException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidParamException() {
		super();
	}

	public InvalidParamException(String message) {
		super(message);
	}

	public InvalidParamException(Throwable cause) {
		super(cause);
	}

}
