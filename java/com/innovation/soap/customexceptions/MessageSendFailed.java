package com.innovation.soap.customexceptions;

/**
 * @author haiderm - This custom exception is thrown when a request XML is sent to get a response but message sent failed. value in
 */
public class MessageSendFailed extends Exception
{
	private static final long serialVersionUID = 1L;

	public MessageSendFailed ()
	{
		super ("Test Case Validation Failed - Possible Reasons are" + "\n" + "1. Interface Service id down" + "\n" +
			"2. Connection timed out" + "\n" + "3. There might a PROXY issue in your machine");
	}
}
