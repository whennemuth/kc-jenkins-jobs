package edu.bu.ist.ci.jenkins;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class JobTest {

	private String[] parmArray1 = new String[] {
			"parm1=val1", "parm2 = val2", "parm3=val3=val4", "  parm4 = val: 5 + 6 = 11  "
	};
	
	@Test
	public void test() {
		BasicJob job = new BasicJob("job1", parmArray1);
		
		assertEquals("job1", job.getName());
		
		List<BasicJobParameter> parms = job.getParameters();
		assertEquals(parmArray1.length, parms.size());
		assertEquals("parm1", parms.get(0).getName());
		assertEquals("parm2", parms.get(1).getName());
		assertEquals("parm3", parms.get(2).getName());
		assertEquals("parm4", parms.get(3).getName());
		
		assertEquals("val1", parms.get(0).getValue());
		assertEquals("val2", parms.get(1).getValue());
		assertEquals("val3=val4", parms.get(2).getValue());
		assertEquals("val: 5 + 6 = 11", parms.get(3).getValue());
	}

}
