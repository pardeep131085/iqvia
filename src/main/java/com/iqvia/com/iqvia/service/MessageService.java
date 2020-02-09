package com.iqvia.com.iqvia.service;

import org.quartz.SchedulerException;

/**
 * Service class for scheduling the message
 * 
 * @author Pardeep
 *
 */
public interface MessageService {
	public void scheduleMessage(String timestamp, String content) throws SchedulerException;
}
