package com.iqvia.com.iqvia.modal;

/**
 * <p>
 * Request Input modal
 * </p>
 * 
 * @author Pardeep
 *
 */
public class MessageInput {

	private String content;

	// format: 2015-02-20T06:30:00
	private String timestamp;

	public MessageInput() {
	}

	public MessageInput(String content, String timestamp) {
		super();
		this.content = content;
		this.timestamp = timestamp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
