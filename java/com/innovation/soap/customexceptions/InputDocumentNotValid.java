package com.innovation.soap.customexceptions;

import java.lang.Exception;
/**
 * @author haiderm - This custom exception is thrown when soap request is not valid and status code = Failure.
 *
 */
public class InputDocumentNotValid extends Exception 
{
	/**
	 * The serialVersionUID is a universal version identifier for a Serializable class. 
	 * Deserialization uses this number to ensure that a loaded class corresponds exactly 
	 * to a serialized object. If no match is found, then an InvalidClassException is thrown.
	 * It's not mandatory, but should be added if possible, doesn't hurt though.
	 */
	
	private static final long serialVersionUID = 1L;

	public InputDocumentNotValid () 
	{
		super("XML Request is not valid.");
	}

}
