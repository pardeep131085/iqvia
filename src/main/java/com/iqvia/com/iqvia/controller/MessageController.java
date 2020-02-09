package com.iqvia.com.iqvia.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iqvia.com.iqvia.modal.MessageInput;
import com.iqvia.com.iqvia.service.MessageService;

/**
 * Entry point to Message Scheduler
 * 
 * @author Pardeep
 *
 */

@RequestMapping(path = "/messages")
@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@PostMapping(path = "/schedule", produces = "application/json", consumes = "application/json")
	public HttpStatus scheduleMessage(@RequestBody MessageInput input) {

		Boolean isScheduled = this.messageService.scheduleMessage(input.getTimestamp(), input.getContent());
		if (!isScheduled) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return HttpStatus.ACCEPTED;
	}

}
