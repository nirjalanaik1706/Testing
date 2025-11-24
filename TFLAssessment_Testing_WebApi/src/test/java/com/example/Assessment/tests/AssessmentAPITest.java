package com.example.Assessment.tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class AssessmentAPITest {

    static {
        RestAssured.baseURI = "http://localhost:5238";
    }

    String token =  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjMiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJuaXJqYWxhLm5haWtAZXhhbXBsZS5jb20iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsic21lIiwic3R1ZGVudCJdLCJleHAiOjE3NjM5OTA2MDQsImlzcyI6IkFzc2Vzc21lbnRBUEkiLCJhdWQiOiJBc3Nlc3NtZW50QVBJIn0.A_mmMu7ttn1aAsd5lrppZi4YuRFLU37JNg5JTN8Tcvs";

    @Test
    public void GetDetails(){
        given()
        .when()
            .get("api/assessment/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("testName", equalTo("Basic MCQ Test"))
            .body("subjectExpertId", equalTo(1))
            .body("status", equalTo("scheduled"))
            .body("passingLevel", equalTo(6))
            .body("firstName", equalTo("ravi"))
            .body("lastName", equalTo("tambade"));
    }

    @Test
    public void GetAll(){
        given()
        .when()
            .get("/api/assessment/creationdate/fromDate/2025-08-13/toDate/2025-08-14")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .body("[1].id", equalTo(10))
            .body("[1].subjectId", equalTo(1))
            .body("[1].duration", equalTo("00:00:00"))
            .body("[1].subjectExpertId", equalTo(1))
            .body("[1].creationDate", equalTo("0001-01-01T00:00:00"))
            .body("[1].modificationDate", equalTo("2025-08-13T10:55:36"))
            .body("[1].scheduledDate", equalTo("2025-08-13T16:30:00"))
            .body("[1].status", equalTo("1"))
            .body("[1].passingLevel", equalTo(0))
            .body("[1].testName", nullValue())
            .body("[1].subject", nullValue())
            .body("[1].firstName", nullValue())
            .body("[1].lastName", nullValue());
    }

    @Test
    public void GetAllAssesment(){
        given()
            .header("Authorization", "Bearer " + token)
        .when()
            .get("/api/assessment/assessments")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .body("[0].id", equalTo(1))
            .body("[0].testName", equalTo("Basic MCQ Test"))
            .body("[0].subjectId", equalTo(1))
            .body("[0].duration", equalTo("00:00:00"))
            .body("[0].subjectExpertId", equalTo(1))
            .body("[0].creationDate", equalTo("2025-12-05T00:00:00"))
            .body("[0].modificationDate", equalTo("2025-02-05T00:00:00"))
            .body("[0].scheduledDate", equalTo("2025-02-07T00:00:00"))
            .body("[0].status", equalTo("scheduled"))
            .body("[0].passingLevel", equalTo(0))
            .body("[0].subject", equalTo("COREJAVA"))
            .body("[0].firstName", equalTo("ravi"))
            .body("[0].lastName", equalTo("tambade"));
    }

    @Test
    public void GetAllEmployees(){
        given()
        .when()
        .get("api/assessment/employees")
        .then()
        .statusCode(200)
        .body("[0].id",equalTo(1))
        .body("[0].userId",equalTo(1))
        .body("[0].firstName",equalTo("ravi"))
        .body("[0].lastName",equalTo("tambade"))
        .body("[0].email",equalTo("ravi.tambade@example.com"))
        .body("[0].contact",equalTo("9000000000"))
        .body("[0].role",nullValue());
    }

    @Test
    public void GetEmployeeById(){
        given()
        .when()
        .get("api/assessment/employee/1")
        .then()
        .statusCode(200)
        .body("id",equalTo(1))
        .body("userId",equalTo(1))
        .body("firstName",equalTo("ravi"))
        .body("lastName",equalTo("tambade"))
        .body("email",equalTo("ravi.tambade@example.com"))
        .body("contact",equalTo("9000000000"))
        .body("role",nullValue());
    }

    @Test
    public void GetAllSubjects(){
        given()
        .when()
        .get("api/assessment/subjects")
        .then()
        .statusCode(200)
        .body("[0].id",equalTo(1))
        .body("[0].title",equalTo("COREJAVA"));
    }

    @Test
    public void getEvalutionCriterias(){
        given()
        .when()
        .get("api/assessment/criterias")
        .then()
        .statusCode(200)
        .body("[0].id",equalTo(1))
        .body("[0].title",equalTo("OOPS"))
        .body("[0].subjectId",equalTo(1));
    }
}
