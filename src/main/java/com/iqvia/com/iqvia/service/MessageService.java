package com.iqvia.com.iqvia.service;

/**
 * Service class for scheduling the message
 * 
 * @author Pardeep
 *
 */
public interface MessageService {
	public boolean scheduleMessage(String timestamp, String content);
}
