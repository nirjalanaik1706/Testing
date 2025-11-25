package com.example.Assessment.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class AssessmentIntelligenceAPITest {

    static {
        RestAssured.baseURI = "http://localhost:5238";
    }

    @Test
    public void testGetCandidateResults_shouldReturn200() {
        given()
        .when()
            .get("/api/AssessmentIntelligence/Candidates/1/Year/2015")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0))           
            .body("[0].candidateId", equalTo(1))    
            .body("[0].score", equalTo(2))
            .body("[0].subjectTitle",equalTo("COREJAVA"));       
            }

    // @Test
    // public void testGetCandidateResults_NoData_shouldReturn404() {
    //     given()
    //     .when()
    //         .get("/api/AssessmentIntelligence/Candidates/999/Year/1990")
    //     .then()
    //         .statusCode(404);
    // }

    // @Test
    // public void testResponseFields_shouldBeValid() {
    //     given()
    //     .when()
    //         .get("/api/AssessmentIntelligence/Candidates/1/Year/2015")
    //     .then()
    //         .statusCode(200)
    //         .body("[0].candidateId", notNullValue())
    //         .body("[0].score", notNullValue())
    //         .body("[0].subjectTitle", notNullValue());
    // }
}

