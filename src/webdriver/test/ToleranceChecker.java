package webdriver.test;

public class ToleranceChecker {

	public boolean checkTolerance(int a, int b, int tol) {
		if ((a == b) || (a - b == tol)) {
			return true;
		}
		return false;
	}
}
