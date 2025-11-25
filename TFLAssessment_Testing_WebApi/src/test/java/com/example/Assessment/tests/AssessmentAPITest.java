package com.example.Assessment.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.nullValue;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class AssessmentAPITest {

    static {
        RestAssured.baseURI = "http://localhost:5238";
    }

    String token =  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjEiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJyYXZpLnRhbWJhZGVAZXhhbXBsZS5jb20iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJhZG1pbiIsImV4cCI6MTc2NDA1OTE2MSwiaXNzIjoiQXNzZXNzbWVudEFQSSIsImF1ZCI6IkFzc2Vzc21lbnRBUEkifQ.SVL4mkSOYpj1wuh7yKGxAUjIi6UpzE10rZA40t89z40";

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
            .get("/api/assessment/creationdate/fromDate/2025-11-25/toDate/2025-11-26")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .body("[1].id", equalTo(10))
            .body("[1].testName",nullValue())
            .body("[1].subjectId", equalTo(6))
            .body("[1].duration", equalTo("00:00:00"))
            .body("[1].subjectExpertId", equalTo(4))
            .body("[1].creationDate", equalTo("0001-01-01T00:00:00"))
            .body("[1].modificationDate", equalTo("2025-11-25T05:58:55"))
            .body("[1].scheduledDate", equalTo("2025-11-25T11:28:00"))
            .body("[1].status", equalTo("6"))
            .body("[1].passingLevel", equalTo(0))
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
    public void getConcept(){
        given()
        .when()
        .get("api/assessment/concepts")
        .then()
        .statusCode(200)
        .body("[0].id",equalTo(1))
        .body("[0].title",equalTo("OOPS"))
        .body("[0].subjectId",equalTo(1));
    }
    @Test
    public void  GetConceptsBySubject(){
        given()
        .when()
        .get("/api/assessment/concepts/subjects/1")
        .then()
        .statusCode(200)
        .body("[0].id",equalTo(1))
        .body("[0].title",equalTo("OOPS"))
        .body("[0].subjectId",equalTo(1));
    }
    @Test
    public void GetAllBySubjectMatterExpert()
    {
        given()
        .when()
        .get("/api/assessment/subjectexperts/4")
        .then()
        .body("[0].id",equalTo(10))
        .body("[0].testName",nullValue())
        .body("[0].subjectId",equalTo(6))
        .body("[0].duration",equalTo("00:30:00"))
        .body("[0].subjectExpertId",equalTo(0))
        .body("[0].creationDate",equalTo("2025-11-25T05:58:55"))
        .body("[0].modificationDate",equalTo("2025-11-25T05:58:55"))
        .body("[0].scheduledDate",equalTo("2025-11-25T11:28:00"))
        .body("[0].status",equalTo( "created"))
        .body("[0].passingLevel",equalTo(0))
        .body("[0].subject",nullValue())
        .body("[0].firstName",nullValue())
        .body("[0].lastName",nullValue());
    }

    @Test
    public void CreateTest(){
        String requestBody="""
        {
        "subjectId": 6,
        "name": "Java Basics",
        "duration": "00:30:00",
        "subjectExpertId": 4,
        "creationDate": "2025-11-25T05:58:55",
        "modificationDate": "2025-11-25T05:58:55",
        "scheduledDate": "2025-11-25T11:28:00",
        "passingLevel": 0
        }
        """;
        given()
        .header("Content-Type", "application/json")
        .body(requestBody)
        .when()
        .post("/api/Assessment/createtest")
        .then()
        .statusCode(200)
        .body("message", equalTo("Test created successfully"));
    }

    @Test
    public void AddQuestion(){
        given()
        .header("Content-Type", "application/json")
        .when()
        .post("api/Assessment/addquestion/assessments/1/questions/10")
        .then()
        .statusCode(200)
        .body(equalTo("true"));
    }

    @Test
    public void AddQuestions(){
        given()
        .header("Content-Type", "application/json")
        .when()
        .post("/api/Assessment/addmultiplequestions/assessments/9")
        .then()
        .statusCode(200)
        .body(equalTo("false"));
    }

    @Test
}
