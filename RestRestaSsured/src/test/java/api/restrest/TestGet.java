package api.restrest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGet {

	@Test
	public void getTestStatsCode() {
		Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
		int code = response.getStatusCode();
		System.out.println("O status code retornado é " + code);
		assertEquals(200, code);
	}

	@Test
	public void getTestValidarBody() {
		Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
		String bodyResponse = response.asPrettyString();
		System.out.println(bodyResponse);
		assertTrue(bodyResponse.contains("Kurtis Weissnat"));

	}

	@Test
	public void getTestValidarName() {
		Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
		String nome = response.jsonPath().getString("name");
		System.out.println("O nome retornado é " + nome);
	}

}
