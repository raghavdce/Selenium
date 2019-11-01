package testNG;

import org.testng.annotations.Test;

public class TestPriority {
	@Test(priority = 8)
	public void z() {
	}

	@Test(priority = -1, dependsOnMethods = "z")
	public void t() {
	}

	@Test(priority = 5)
	public void g() {
	}

	@Test(priority = -9)
	public void w() {
	}

}
