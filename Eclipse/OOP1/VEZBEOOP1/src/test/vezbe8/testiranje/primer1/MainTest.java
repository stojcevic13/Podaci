package test.vezbe8.testiranje.primer1;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testMainMethod1() {
		assertTrue(1 != 2);
	}

	@Test
	public void testMainMethod2() {
	}

}
