package training.service.impl;

import training.service.HelloService;

public class DefaultHelloService implements HelloService {

	public DefaultHelloService() {
		System.out.println("Constructing DefaultHelloService bean...");
	}

	@Override
	public void sayHello() {
		System.out.println("Hello.");
	}

	@Override
	public void printMessage() {
		System.out.println("No message available");
	}
}
