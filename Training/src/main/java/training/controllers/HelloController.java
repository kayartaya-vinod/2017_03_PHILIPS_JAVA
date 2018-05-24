package training.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import training.model.Message;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

	@RequestMapping(produces = "text/plain")
	public String helloText() {
		return "Hello, World!";
	}

	@RequestMapping(produces = { "application/json", "application/xml" })
	public Message helloMessage() {
		return new Message("Vinod", "Hello, World");
	}
}
