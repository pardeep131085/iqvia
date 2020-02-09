package com.iqvia.com.iqvia.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iqvia.com.iqvia.modal.MessageInput;
import com.iqvia.com.iqvia.service.MessageService;

/**
 * Entry point to Message Scheduler
 * 
 * @author Pardeep
 *
 */

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@PostMapping(path = "/schedule-message", produces = "application/json", consumes = "application/json")
	public HttpStatus scheduleMessage(@RequestBody MessageInput input) {

		try {
			this.messageService.scheduleMessage(input.getTimestamp(), input.getContent());
		} catch (SchedulerException e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR;			
		}

		return HttpStatus.ACCEPTED;
	}
	
}
