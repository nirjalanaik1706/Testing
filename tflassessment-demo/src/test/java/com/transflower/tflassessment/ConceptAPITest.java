// package com.transflower.tflassessment;

// import static org.hamcrest.Matchers.equalTo;
// import org.testng.annotations.Test;

// import io.restassured.RestAssured;
// import static io.restassured.RestAssured.given;
// public class ConceptAPITest {
    
//     static{
//         RestAssured.baseURI="http://localhost:5238";
//     }
//     @Test
//     public void UpdateConcept(){
//         given()
//         .header("Content-Type","application/json")
//         .when()
//         .put("/api/Concepts/10/questions/64")
//         .then()
//         .statusCode(200)
//         .body(equalTo("true"));
//     }

//     @Test
//     public void UpdateSubject(){
//         given()
//         .header("Content-Type","application/json")
//         .when()
//         .put("/api/Concepts/8/subjects/2")
//         .then()
//         .statusCode(200)
//         .body(equalTo("true"));
//     }
    
//     @Test
//     public void InsertConcept(){
//         String requestBody="""
//             {
//             "id": 23,
//             "title": "Introduction to Algorithms",
//             "subjectId": 8
//             }
//                 """;
//             given()
//             .header("Content-Type","application/json")
//             .body(requestBody)
//             .when()
//             .post("/api/Concepts")
//             .then()
//             .statusCode(200)
//             .body(equalTo("false"));
//     }

//     @Test
//     public void GetConceptBySubjectId(){
//         given()
//         .when()
//         .get("/api/Concepts/1")
//         .then()
//         .statusCode(200)
//         .body("[0].id",equalTo(1))
//         .body("[0].title",equalTo("OOPS"))
//         .body("[0].subjectId",equalTo(1));
//     }
    
//     @Test
//     public void getConceptQuestionCount()
//     {
//         given()
//         .when()
//         .get("/api/Concepts/questioncount/1")
//         .then()
//         .statusCode(200)
//         .body("[0].questionCount",equalTo(5))
//         .body("[0].concepts[0].id",equalTo(1))
//         .body("[0].concepts[0].title",equalTo("OOPS"))
//         .body("[0].concepts[0].subjectId",equalTo(0)); 
//     }
// }
