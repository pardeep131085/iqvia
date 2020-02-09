package com.iqvia.com.iqvia.service;

/**
 * <p>
 * Service class for scheduling the message
 * </p>
 * 
 * @author Pardeep
 *
 */
public interface MessageService {
	public boolean scheduleMessage(String timestamp, String content);
}
