package com.ibm.training;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import org.example.person.Person;

@Component
public class PersonRepository {
	private static final Map<String, Person> persons = new HashMap<>();

	@PostConstruct
	public void initData() {
		
		Person person = new Person();
		person.setName("aaa");
		person.setAge(5);
		person.setId(1);
		persons.put(person.getName(), person);
		person= new Person();
		person.setName("bbb");
		person.setAge(5);
		person.setId(2);
		persons.put(person.getName(), person);
		person = new Person();
		person.setName("ccc");
		person.setAge(5);
		person.setId(3);
		persons.put(person.getName(), person);
		person = new Person();
		person.setName("ddd");
		person.setAge(5);
		person.setId(4);
		persons.put(person.getName(), person);
		
		
		
		
	}

	public Person findPerson(String name) {
		Assert.notNull(name, "The Product name must not be null");
		return persons.get(name);
	}
}