package training.dao;

public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	// used for converting any exception into DaoException (decorator)
	public DaoException(Throwable cause) {
		super(cause);
	}

}
