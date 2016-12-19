package edu.bu.ist.ci.jenkins;

import java.util.List;

public interface Job {

	String getName();

	List<? extends JobParameter> getParameters();
	
	void run();
}
