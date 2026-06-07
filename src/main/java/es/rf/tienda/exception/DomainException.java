package es.rf.tienda.exception;

@SuppressWarnings("serial")
public class DomainException extends Exception {

	public DomainException(String mensajes) {
		super(mensajes);
	}

	public DomainException(String mensajes, Throwable cause) {
		super(mensajes, cause);
	}

}
