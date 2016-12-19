package edu.bu.ist.ci.jenkins;

public class BasicJobParameter implements JobParameter {

	private String name;
	private String value;
	
	public BasicJobParameter(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getValue() {
		return value;
	}

}
