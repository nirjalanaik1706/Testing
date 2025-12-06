package com.transflower.tflassessment;


import io.restassured.RestAssured;

public class AssessmentIntelligenceAPITest {

    static {
        RestAssured.baseURI = "http://localhost:5238";
    }


        
    // @Test
    // public void testGetCandidateResults_shouldReturn200() {
    //     given()
    //     .when()
    //         .get("/api/AssessmentIntelligence/Candidates/2/Year/2015")
    //     .then()
    //         .statusCode(200)
    //         .body("size()", greaterThan(0))           
    //         .body("[0].candidateId", equalTo(2))    
    //         .body("[0].score", equalTo(2))
    //         .body("[0].subjectTitle",equalTo("COREJAVA"));       
    //         }

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


