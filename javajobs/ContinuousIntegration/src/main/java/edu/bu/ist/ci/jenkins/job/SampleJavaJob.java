package edu.bu.ist.ci.jenkins.job;

import java.util.List;

import edu.bu.ist.ci.JobDef;
import edu.bu.ist.ci.JobParameter;
import edu.bu.ist.ci.jenkins.AbstractJenkinsJob;
import edu.bu.ist.ci.jenkins.JenkinsJobEnvironment;

public class SampleJavaJob extends AbstractJenkinsJob {

	public SampleJavaJob(JobDef jobDef) {
		super(jobDef, new JenkinsJobEnvironment());
	}
	
	public SampleJavaJob(JobDef jobDef, JenkinsJobEnvironment env) {
		super(jobDef, env);
	}

	@Override
	public JobDef getJobDef() {
		return super.jobDef;
	}
	
	@Override
	public void run(List<JobParameter> parameters) {
		
		System.out.println(this.getJobDef().toJSON());
		
		for(JobParameter parm : parameters) {
			System.out.println();
			System.out.println(parm);
		}
	}

	@Override
	public String getView(String parameterName, List<JobParameter> parameters) {
		
		StringBuilder html = new StringBuilder();
		String parm1 = null;
		String parm2 = null;
		String parm3 = null;
		
		for(JobParameter parm : parameters) {			
			String name = parm.getJobParameterDef().getName().toLowerCase();
			switch(name) {
			case "myparmdef1":
				parm1 = String.valueOf(parm.getValue()); break;
			case "myparmdef2":
				parm2 = String.valueOf(parm.getValue()); break;
			case "myparmdef3":
				parm3 = String.valueOf(parm.getValue()); break;
			}				
		}
			
		String[] options = null;
		
		switch(parameterName.toLowerCase()) {
		case "myparmdef1": options = new String[]{"fruit", "dairy", "vegetables"}; break;
		case "myparmdef2":
			switch(parm1) {
			case "fruit": options = new String[]{"apples", "oranges", "melons"}; break;
			case "vegetables": options = new String[]{"lettuce", "tomatoes", "onions"}; break;
			case "dairy": options = new String[]{"cheese", "yogurt", "milk"}; break;
			}
			break;
		case "myparmdef3":
			switch(parm2) {
			case "apples": options = new String[]{"macintosh", "granny smith", "red delicious"}; break;
			case "oranges": options = new String[]{"navel", "tangerine", "valencia"}; break;
			case "melons": options = new String[]{"honeydew", "watermelon", "cantaloupe"}; break;
			case "lettuce": options = new String[]{"iceberg", "romaine", "red leaf"}; break;
			case "tomatoes": options = new String[]{"cherry", "roma", "campari"}; break;
			case "onions": options = new String[]{"vidalia", "red", "yellow"}; break;
			case "cheese": options = new String[]{"cheddar", "mozzarella", "swiss"}; break;
			case "yogurt": options = new String[]{"greek", "traditional", "frozen"}; break;
			case "milk": options = new String[]{"whole", "skim", "soy"}; break;
			}
		}				

		html.append("<table cellpadding=5 border=0><tr><td>")
		 .append(parameterName)
		 .append("</td><td><select name='")
		 .append(parameterName)
		 .append("' style='width:200px;'>");
		for(String option : options) {
			html.append("<option value='").append(option).append("'>").append(option).append("</option>");
		}
			
			html.append("</select></td></tr></table>");
		
		return html.toString();
	}
}
