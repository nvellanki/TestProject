package org.gradle;

import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

/**
 * 
 * @author Naga Vellanki 11/09/2016 
 */

public class TestNASASoundsAPI {
	private JsonPath _jp;
	String _response;
	String _json;
	String _baseURLCreate;
	PropertiesLoader prop = new PropertiesLoader();

	@BeforeClass
	public void setUp() {
		_baseURLCreate = prop.getProperty("baseURL");

	}

	/**
	 * Test Case: Positive testcase of NASA sounds API
	 */
	@Test(dataProvider = "positiveCase", dataProviderClass = TestDataProvider.class)
	public void testPosGetNASASounds(String apiKey, String apiValue, String qKey, String qValue, String limitKey,
			int lValue) {

		_response = given().queryParam(apiKey, apiValue).queryParam(qKey, qValue).queryParam(limitKey, lValue)
				.contentType("application/json").expect().statusCode(HttpStatus.SC_OK).when().get(_baseURLCreate)
				.getBody().asString();
		_jp = new JsonPath(_response);
		Assert.assertEquals(_jp.get("count"), lValue);
		Assert.assertNotNull(_response);
	}

	/**
	 * Test Case: Positive testcase of NASA sounds API
	 */
	@Test(dataProvider = "negativeCase", dataProviderClass = TestDataProvider.class)
	public void testNegGetNASASounds(String apiKey, String apiValue, String qKey, String qValue, String limitKey,
			int lValue) {

		_response = given().queryParam(apiKey, apiValue).queryParam(qKey, qValue).queryParam(limitKey, lValue)
				.contentType("application/json").expect().statusCode(HttpStatus.SC_FORBIDDEN).when().get(_baseURLCreate)
				.getBody().asString();
		_jp = new JsonPath(_response);
		Assert.assertEquals(_jp.get("error.message"), "No api_key was supplied. Get one at https://api.nasa.gov");
	}
}