package com.iqvia.com.iqvia.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.iqvia.com.iqvia.modal.MessageInput;
import com.iqvia.com.iqvia.service.MessageService;

/**
 * Test MessageController class
 * 
 * @author Pardeep
 *
 */
@SpringBootTest
public class MessageControllerTests {

	@InjectMocks
	private MessageController messageController;
	@Mock
	private MessageService messageService;
	@Mock
	MessageInput messageInput;

	@Test
	public void sucessScheduleMessage() {
		when(messageService.scheduleMessage(messageInput.getTimestamp(), messageInput.getContent())).thenReturn(true);
		assertThat(messageController.scheduleMessage(messageInput)).isEqualTo(HttpStatus.ACCEPTED);
	}

	@Test
	public void failScheduleMessage() {
		when(messageService.scheduleMessage(messageInput.getTimestamp(), messageInput.getContent())).thenReturn(false);
		assertThat(messageController.scheduleMessage(messageInput)).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
