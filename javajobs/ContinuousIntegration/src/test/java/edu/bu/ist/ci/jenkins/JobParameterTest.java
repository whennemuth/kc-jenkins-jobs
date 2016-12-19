package edu.bu.ist.ci.jenkins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JobParameterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		JobParameter parm = new BasicJobParameter("parm1",  "val");
		assertEquals("parm1", parm.getName());
		assertEquals("val", parm.getValue());
	}

}
