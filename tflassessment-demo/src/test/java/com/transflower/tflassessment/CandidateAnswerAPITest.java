// package com.transflower.tflassessment;

// import java.io.File;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// import static org.hamcrest.Matchers.equalTo;
// import org.testng.annotations.Test;

// import com.fasterxml.jackson.core.type.TypeReference;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.transflower.tflassessment.demo.entities.CandidateAnswer;
// import com.transflower.tflassessment.demo.entities.ExpectedOutput;

// import io.restassured.RestAssured;
// import static io.restassured.RestAssured.given;
// import io.restassured.http.ContentType;

// public class CandidateAnswerAPITest {
//     static {
//         RestAssured.baseURI = "http://localhost:5238/api/candidateanswer";
//     }
// String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjEiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJyYXZpLnRhbWJhZGVAZXhhbXBsZS5jb20iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJhZG1pbiIsImV4cCI6MTc2NDIzMzI3NywiaXNzIjoiQXNzZXNzbWVudEFQSSIsImF1ZCI6IkFzc2Vzc21lbnRBUEkifQ.Z2UUJw2NINzmkVdPz1pmCGBPOqRH6QUrlz61tRZ8xY4"; 
// String smetoken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjMiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJuaXJqYWxhLm5haWtAZXhhbXBsZS5jb20iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsic21lIiwic3R1ZGVudCJdLCJleHAiOjE3NjQyMjYwNjQsImlzcyI6IkFzc2Vzc21lbnRBUEkiLCJhdWQiOiJBc3Nlc3NtZW50QVBJIn0.mzrsQ2F5cRbphDbAnLHDajVQHkFFbBiCXNw4jzLqhsY";
    
//     @Test 
//     public void insertCandidateAnswersTest()
//     {
//         ObjectMapper mapper=new ObjectMapper();
//         List<CandidateAnswer>answerList=new ArrayList<>();
//         List<ExpectedOutput> expectedList=new ArrayList<>();
//         try {
//             answerList=mapper.readValue(new File("src/main/resources/candidateAnswer.json"), 
//             new TypeReference<List<CandidateAnswer>>(){});            
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         try {
//             expectedList =mapper.readValue(
//                 new File("src/main/resources/candidateAnswersOutput.json"), 
//                 new TypeReference<List<ExpectedOutput>>() {}
//                 );
//         } catch ( IOException e) {
//             e.printStackTrace();
//         }
//         for(int i=0; i<answerList.size();i++){
//             CandidateAnswer cAnswer=answerList.get(i);
//             ExpectedOutput eOutput=expectedList.get(i);

//             String requestBody="""
//                      [
//                     {
//                         "CandidateId": %d,
//                         "TestQuestionId": %d,
//                         "AnswerKey": "%s"
//                     }
//                 ]
//                     """.formatted(cAnswer.getCandidateId(),cAnswer.getTestQuestionId(),cAnswer.getAnswerKey());
//             given()
//             .contentType(ContentType.JSON)
//             .body(requestBody)
//             .when()
//             .post("/assessmentanswers/candidates/"+cAnswer.getCandidateId())
//             .then()
//             .statusCode(200)
//             .body("message", equalTo(eOutput.getMessage()))
//             .body("status",equalTo(eOutput.isStatus()));
//                 }
//     }
    // @Test
    // public void InsertCandidateAnswers(){
    //     String requestBody="""      
    //     [
    //         {
    //             "CandidateId": 1,
    //             "TestQuestionId": 16,
    //             "AnswerKey": "B"
    //         }
    //         ]
    //             """;
    //     given()
    //     .header("Content-Type", "application/json")
    //     .body(requestBody)
    //     .when()
    //     .post("/assessmentanswers/candidates/17")
    //     .then()
    //     .body("message", equalTo("Candidate answers inserted successfully."))
    //     .body("status",equalTo(true));
    // }

    // @Test
    // public void GetCandidateAnswers(){
    //     given()
    //     .when()
    //     .get("/assessmentanswers/candidates/1/testId/1")
    //     .then()
    //     .statusCode(200)
    //     .body("[0].id",equalTo(2))
    //     .body("[0].candidateId",equalTo(1))
    //     .body("[0].testQuestionId",equalTo(2))
    //     .body("[0].answerKey",equalTo("c"));
        
    // }

    // @Test
    // public void GetCandidateAnswerResults(){
    //     given()
    //     .when()
    //     .get("/assessmentanswers/candidates/1/tests/1/results")
    //     .then()
    //     .statusCode(200)
    //     .body("[0].testQuestionId",equalTo(2))
    //     .body("[0].candidateAnswer",equalTo("c"))
    //     .body("[0].correctAnswer",equalTo("B"))
    //     .body("[0].isCorrect",equalTo(false));
    // }

    // @Test
    // public void GetCandidateTestDetails(){
    //     given()
    //     .when()
    //     .get("/assessmentanswers/candidates/3/tests/1/details")
    //     .then()
    //     .statusCode(200)
    //     .body("candidateId",equalTo(3))
    //     .body("candidateName",equalTo("nirjala"))
    //     .body("testId",equalTo(1))
    //     .body("testName",equalTo("Basic MCQ Test"))
    //     .body("testDate",equalTo("2024-01-01T00:00:00"))
    //     .body("testPassingLevel",equalTo(6));
    // }
    
//}
