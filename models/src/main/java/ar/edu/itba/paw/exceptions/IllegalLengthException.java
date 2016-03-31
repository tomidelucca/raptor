package ar.edu.itba.paw.exceptions;

public class IllegalLengthException extends TweetException {

	private static final long serialVersionUID = 1L;
	
	public IllegalLengthException() {
		super();
	}

	public IllegalLengthException(final String msg) {
		super(msg);
	}

	public IllegalLengthException(final String msg, Throwable cause) {
		super(msg, cause);
	}

	public IllegalLengthException(Throwable cause) {
		super(cause);
	}
}
