package br.com.produtos.exception;

public class ProdutoNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3358622775806814090L;

	public ProdutoNotFoundException() {
		super();
	}

	public ProdutoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProdutoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProdutoNotFoundException(String message) {
		super(message);
	}

	public ProdutoNotFoundException(Throwable cause) {
		super(cause);
	}
	
		
	
}
