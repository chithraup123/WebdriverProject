package webdriver.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ToleranceCheckerTest {

	ToleranceChecker checker;
	Boolean actualToleranceVal;

	@Before
	public void init() {
		checker = new ToleranceChecker();
	}

	@Test
	public void checkToleranceTest1() {

		actualToleranceVal = checker.checkTolerance(5, 5, 1);
		assertTrue(actualToleranceVal);
	}

	@Test
	public void checkToleranceTest2() {

		actualToleranceVal = checker.checkTolerance(5, 3, 2);
		assertTrue(actualToleranceVal);
	}

	@Test
	public void checkToleranceTest3() {

		actualToleranceVal = checker.checkTolerance(5, 3, 1);
		assertFalse(actualToleranceVal);
	}

	@Test
	public void checkToleranceTest4() {

		actualToleranceVal = checker.checkTolerance(3, 5, -2);
		assertTrue(actualToleranceVal);
	}

	@Test
	public void checkToleranceTest5() {

		actualToleranceVal = checker.checkTolerance(3, 5, 2);
		assertFalse(actualToleranceVal);
	}

	@Test
	public void checkToleranceTest6() {

		actualToleranceVal = checker.checkTolerance(-1, 0, 1);
		assertFalse(actualToleranceVal);
	}

	@Test
	public void checkToleranceTest7() {

		actualToleranceVal = checker.checkTolerance(-1, -1, 2);
		assertTrue(actualToleranceVal);
	}

	@Test
	public void checkToleranceTest8() {

		actualToleranceVal = checker.checkTolerance(-1, -2, 0);
		assertFalse(actualToleranceVal);
	}

	@Test
	public void checkToleranceTest9() {

		actualToleranceVal = checker.checkTolerance(1, 2, -1);
		assertTrue(actualToleranceVal);
	}

}
