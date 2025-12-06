package com.transflower.tflassessment;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class QuestionBankAPITest {
    static{
        RestAssured.baseURI="http://localhost:5238";
    }
    @Test
    public void GetAllQuestions(){
        given()
        .when()
        .get("/api/questionbank/questions")
        .then()
        .statusCode(200)
        .body("[0].id",equalTo(1))
        .body("[0].title",equalTo("Which keyword is used to inherit a class in Java?"));
    }
      @Test
    public void GetQuestion(){
        given()
        .when()
        .get("/api/questionbank/questions/2")
        .then()
        .statusCode(200)
        .body("id",equalTo(2))
        .body("title",equalTo("Which exception is thrown when an array is accessed out of bounds in Java?"))
        .body("a",equalTo("NullPointerException"))
        .body("b",equalTo("ArrayIndexOutOfBoundsException"))
        .body("c",equalTo("IllegalArgumentException"))
        .body("d",equalTo("IndexException"))
        .body("subjectId",equalTo(1))
        .body("answerKey",equalTo("B"))
        .body("conceptId",equalTo(1));
    }
     @Test
    public void GetConcept(){
        given()
        .when()
        .get("/api/questionbank/questions/subjects/COREJAVA/questions/1")
        .then()
        .statusCode(200)
        .body(equalTo("OOPS"));
    }

    @Test
    public void GetQuestionsBySubjects(){
        given()
        .when()
        .get("/api/questionbank/questions/subjects/2")
        .then()
        .statusCode(200)
        .body("[0].questionId",equalTo(6))
        .body("[0].question",equalTo("Spring Boot is used for developing?"))
        .body("[0].subjectId",equalTo(2))
        .body("[0].subject",equalTo("ADVJAVA"));
    }

      @Test
    public void GetQuestions(){
        given()
        .when()
        .get("/api/questionbank/questions/tests/1")
        .then()
        .statusCode(200)
        .body("[0].id",equalTo(2))
        .body("[0].title",equalTo("Which exception is thrown when an array is accessed out of bounds in Java?"))
        .body("[0].a",equalTo("NullPointerException"))
        .body("[0].b",equalTo("ArrayIndexOutOfBoundsException"))
        .body("[0].c",equalTo("IllegalArgumentException"))
        .body("[0].d",equalTo("IndexException"))
        .body("[0].subjectId",equalTo(1))
        .body("[0].answerKey",nullValue())
        .body("[0].conceptId",equalTo(1));
    }
    
    @Test
    public void GetQuestionsBySubjectAndConcept(){
        given()
        .when()
        .get("/api/questionbank/questions/subjects/4/concepts/1")
        .then()
        .statusCode(200)
        .body("[0].id",equalTo(26))
        .body("[0].question",equalTo("Which method of DBContext class reflects changes to database for CRUD Operation in .net while implementing Entity Framework?"))
        .body("[0].questionId",equalTo(26))
        .body("[0].subject",equalTo("MICROSERVICES"))
        .body("[0].criteria",equalTo("OOPS"));
    }

     @Test
    public void GetQuestionsWithSubjectAndConcept(){
        given()
        .when()
        .get("/api/questionbank/questions/subjects/concepts")
        .then()
        .statusCode(200)
        .body("[0].id",equalTo(1))
        .body("[0].question",equalTo("Which keyword is used to inherit a class in Java?"))
        .body("[0].questionId",equalTo(0))
        .body("[0].subject",equalTo("COREJAVA"))
        .body("[0].criteria",equalTo("OOPS"));
    }

     @Test
    public void UpdateAnswer(){
        given()
        .when()
        .put("api/questionbank/question/1/updateanswer/c")
        .then()
        .statusCode(200)
        .body(equalTo("true"));
    }

     @Test
    public void UpdateQuestionOptions(){
        String requestBody="""
        {
        "id": 64,
        "subjectId": 4,
        "title": "Microservices – Inter-service Communication",
        "A": "HTTPS",
        "B": "SMTP",
        "C": "FTP",
        "D": "SNMP",
        "answerKey": "HTTP",
        "evaluationCriteriaId": 1
        }

        """;
        given()
        .body(requestBody)
        .header("Content-Type","application/json")
        .when()
        .put("/api/questionbank/update/options/question/64")
        .then()
        .statusCode(200)
        .body(equalTo("false"));
    }

     @Test
    public void InsertQuestion(){
        String requestBody="""
        {
            "Id": 64,
            "SubjectId": 4,
            "Title": "Microservices – Inter-service Communication",
            "A": "HTTP",
            "B": "SMTP",
            "C": "FTP",
            "D": "SNMP",
            "AnswerKey": "A",
            "EvaluationCriteriaId": 1,
            "ConceptId": 1
            }
        """;
        given()
        .body(requestBody)
        .header("Content-Type","application/json")
        .when()
        .post("/api/questionbank/question")
        .then()
        .statusCode(200)
        .body(equalTo("true"));
    }

        @Test
    public void GetSubjectQuestionCount()
    {
        given()
        .when()
        .get("/api/questionbank/questionCount")
        .then()
        .statusCode(200)
        .body("[0].questionCount",equalTo(10))
        .body("[0].subject.id",equalTo(1))
        .body("[0].subject.title",equalTo("COREJAVA")); 
    }
    
        // @Test
//    public void GetSubjectQuestionCount()
//   {
     //   given()
     //   .when()
      //  .get("/api/questionbank/questionCount")
      //  .then()
     //   .statusCode(200)
     //   .body("[0].questionCount",equalTo(10))
     //   .body("[0].subject.id",equalTo(1))
     //   .body("[0].subject.title",equalTo("COREJAVA")); 
//    }

    // @Test
    // public void GetSubject(){
        //   given()
     //   .when()
      //  .get("/api/questionbank/questionCount")
      //  .then()
     //   .statusCode(200)
    //}

    
}
