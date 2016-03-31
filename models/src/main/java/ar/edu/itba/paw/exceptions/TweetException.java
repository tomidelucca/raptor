package ar.edu.itba.paw.exceptions;

public class TweetException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TweetException() {
		super();
	}

	public TweetException(final String msg) {
		super(msg);
	}

	public TweetException(final String msg, Throwable cause) {
		super(msg, cause);
	}

	public TweetException(Throwable cause) {
		super(cause);
	}
}
