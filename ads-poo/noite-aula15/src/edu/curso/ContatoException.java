package edu.curso;

public class ContatoException extends Exception {

	public ContatoException() {
	}

	public ContatoException(String arg0) {
		super(arg0);
	}

	public ContatoException(Throwable arg0) {
		super(arg0);
	}

	public ContatoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ContatoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
