package wisoft.io.spring.functionapi.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

	private final String name;

	private final int age;

	public Account(@JsonProperty("name") String name, @JsonProperty("age") int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return "Account{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
