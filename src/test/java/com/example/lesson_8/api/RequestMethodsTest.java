package com.example.lesson_8.api;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lesson_8.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestMethodsTest {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }
    @Test
    public void
    givenQueryParams_whenGetRequest_thenStatus200 (){
        long id = 0;
        given().queryParam("id", id)
                .when().get("/get")
                .then()
                .log().body().statusCode(200)
                .and().body("args.id", equalTo("0"))
                .and().body("url",equalTo("https://postman-echo.com/get?id=0"));

    }

    @Test
    public void
    givenJson_whenPostRequest_thenStatus200 (){
        Person person = new Person(234689);
        given()
                .log().uri()
                .contentType("application/json")
                .body(person)
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(200)
                .and().body("data.id", equalTo(person.getId()));
    }

    @Test
    public void givenFormData_whenPostRequest_thenStatus200() {
        int id = 787355;
        String name = "Test User";

        given()
                .log().uri()
                .contentType("multipart/form-data")
                .multiPart("id", String.valueOf(id))
                .multiPart("name", name)
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("form.id", equalTo(String.valueOf(id)))
                .body("form.name", equalTo(name));
    }
    @Test
    public void
    whenUpdatePerson_thenGetStatus200(){
        Person person = new Person(34);
        given()
                .log().uri()
                .log().body()
                .contentType("application/json")
                .body(person)
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.id", equalTo(person.getId()));
    }
    @Test
    public void givenJson_whenPatchRequest_thenStatus200() {
        Person person = new Person(42);

        given()
                .log().uri()
                .log().body()
                .contentType(ContentType.JSON)
                .body(person)
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.id", equalTo(person.getId()));
    }
    @Test
    public void givenQueryParam_whenDeleteRequest_thenStatus200() {
        int id = 123;

        given()
                .log().uri()
                .queryParam("id", id)
                .when()
                .delete("/delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("args.id", equalTo(String.valueOf(id)))
                .body("url", equalTo("https://postman-echo.com/delete?id=" + id));
    }
}
