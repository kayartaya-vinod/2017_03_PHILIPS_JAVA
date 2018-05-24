package training.service.impl;

import training.entity.Message;
import training.service.HelloService;

public class MessageHelloService implements HelloService{

	// field (dependency)
	private Message message;

	public MessageHelloService() {
	}

	public MessageHelloService(Message message) {
		this.message = message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	@Override
	public void sayHello() {
		System.out.println("Hello, World!");
	}

	@Override
	public void printMessage() {
		System.out.printf("%s - %s\n", message.getText(), message.getFrom());
	}
}
