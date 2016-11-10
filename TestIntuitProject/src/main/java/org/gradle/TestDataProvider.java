package org.gradle;

import org.testng.annotations.DataProvider;

/**
 * 
 * @author Naga Vellanki 11/09/2016 
 */
public class TestDataProvider {
	@DataProvider(name = "positiveCase")
	public static Object[][] positiveTestcase() {
		return new Object[][] { { "API_KEY", "DEMO_KEY", "q", "APOLLO", "limit", 8 } };
	}

	@DataProvider(name = "negativeCase")
	public static Object[][] negativeTestcase() {
		return new Object[][] { { "API_KEY", null, "q", "APOLLO", "limit", 8 } };
	}

}