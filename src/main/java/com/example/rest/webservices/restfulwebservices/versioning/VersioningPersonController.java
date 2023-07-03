package com.example.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	//Versioning using URLs ===================
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionPersonUrl() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionPersonUrl() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	// Versioning using Request Parameters ===================
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionPersonRequestParameter() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	// Versioning using Request Headers ===================
	
	@GetMapping(path = "/person", headers = "api-version=1")
	public PersonV1 getFirstVersionPersonRequestHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person", headers = "api-version=2")
	public PersonV2 getSecondVersionPersonRequestHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	// Versioning using Media Types (Accept Header) ===================================
	
	@GetMapping(path = "/person/accept", produces = "application/example.app-v1+json")
	public PersonV1 getFirstVersionPersonAcceptHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/example.app-v2+json")
	public PersonV2 getSecondtVersionPersonAcceptHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
}
