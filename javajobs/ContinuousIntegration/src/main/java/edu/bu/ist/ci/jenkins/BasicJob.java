package edu.bu.ist.ci.jenkins;

import java.util.ArrayList;
import java.util.List;

public class BasicJob implements Job {
	
	List<BasicJobParameter> parameters = new ArrayList<BasicJobParameter>();
	String name;

	@SuppressWarnings("unused")
	private BasicJob() { /* Restrict default constructor */ }
	
	public BasicJob(Object[] parms) {
		this(null, parms);
	}
	public BasicJob(String name, Object[] parameters) {
		this.name = name;
		for(int i=0; i<parameters.length; i++) {
			Object parm = parameters[i];
			if(parm == null)
				continue;
			String s = parm.toString();
			if(s.contains("=")) {
				String left = s.substring(0, s.indexOf("=")).trim();
				String right = s.substring(s.indexOf("=") + 1).trim();
				this.parameters.add(new BasicJobParameter(left, right));
			}
		}
	}
	@Override
	public List<BasicJobParameter> getParameters() {
		return parameters;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void run() {
		System.out.println("Not implemented!");
	}

}
