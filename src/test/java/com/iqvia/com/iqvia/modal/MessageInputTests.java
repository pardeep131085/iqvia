package com.iqvia.com.iqvia.modal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageInputTests {

	@Test
	public void testConstructor() {
		MessageInput messageInput = new MessageInput("hello world", "2020-02-08T21:46:00");

		assertThat(messageInput.getTimestamp()).isEqualTo("2020-02-08T21:46:00");
		assertThat(messageInput.getContent()).isEqualTo("hello world");
	}

	@Test
	public void testGet() {
		MessageInput messageInput = new MessageInput();
		messageInput.setContent("hello world");
		messageInput.setTimestamp("2020-02-08T21:46:00");
		assertThat(messageInput.getTimestamp()).isEqualTo("2020-02-08T21:46:00");
		assertThat(messageInput.getContent()).isEqualTo("hello world");
	}
}
