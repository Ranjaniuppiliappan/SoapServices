package com.ibm.training;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import org.example.person.Person;
import org.example.person.PersonDetailsRequest;
import org.example.person.PersonDetailsResponse;

@Endpoint
public class PersonEndpoint {
	private static final String NAMESPACE_URI = "http://www.example.org/person";

	private PersonRepository PersonRepository;

	@Autowired
	public PersonEndpoint(PersonRepository PersonRepository) {
		this.PersonRepository = PersonRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PersonDetailsRequest")
	@ResponsePayload
	public PersonDetailsResponse getPerson(@RequestPayload PersonDetailsRequest request) {
		PersonDetailsResponse response = new PersonDetailsResponse();
		response.setPerson(PersonRepository.findPerson(request.getName()));

		return response;
	}
}