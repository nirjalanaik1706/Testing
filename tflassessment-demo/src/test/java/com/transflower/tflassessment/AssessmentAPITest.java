// package com.transflower.tflassessment;

// import static org.hamcrest.Matchers.equalTo;
// import static org.hamcrest.Matchers.greaterThan;
// import static org.hamcrest.Matchers.nullValue;
// import org.testng.annotations.Test;

// import io.restassured.RestAssured;
// import static io.restassured.RestAssured.given;

// public class AssessmentAPITest {

//     static {
//         RestAssured.baseURI = "http://localhost:5238";
//     }

//     String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjEiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJyYXZpLnRhbWJhZGVAZXhhbXBsZS5jb20iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOiJhZG1pbiIsImV4cCI6MTc2NDIzMzI3NywiaXNzIjoiQXNzZXNzbWVudEFQSSIsImF1ZCI6IkFzc2Vzc21lbnRBUEkifQ.Z2UUJw2NINzmkVdPz1pmCGBPOqRH6QUrlz61tRZ8xY4";
//     String smetoken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjMiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJuaXJqYWxhLm5haWtAZXhhbXBsZS5jb20iLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOlsic21lIiwic3R1ZGVudCJdLCJleHAiOjE3NjQyMjYwNjQsImlzcyI6IkFzc2Vzc21lbnRBUEkiLCJhdWQiOiJBc3Nlc3NtZW50QVBJIn0.mzrsQ2F5cRbphDbAnLHDajVQHkFFbBiCXNw4jzLqhsY";
//     @Test
//     public void GetDetails() {
//         given()
//         .when()
//             .get("api/assessment/1")
//         .then()
//             .statusCode(200)
//             .body("id", equalTo(1))
//             .body("testName", equalTo("Basic MCQ Test"))
//             .body("subjectExpertId", equalTo(1))
//             .body("status", equalTo("created"))
//             .body("passingLevel", equalTo(6))
//             .body("firstName", equalTo("ravi"))
//             .body("lastName", equalTo("tambade"));
//     }

//     @Test
//     public void GetAll() {
//         given()
//         .when()
//             .get("/api/assessment/creationdate/fromDate/2025-11-25/toDate/2025-11-26")
//         .then()
//             .statusCode(200)
//             .body("size()", greaterThan(0))
//             .body("[1].id", equalTo(10))
//             .body("[1].testName", nullValue())
//             .body("[1].subjectId", equalTo(6))
//             .body("[1].duration", equalTo("00:00:00"))
//             .body("[1].subjectExpertId", equalTo(4))
//             .body("[1].creationDate", equalTo("0001-01-01T00:00:00"))
//             .body("[1].modificationDate", equalTo("2025-11-25T05:58:55"))
//             .body("[1].scheduledDate", equalTo("2025-11-25T11:28:00"))
//             .body("[1].status", equalTo("6"))
//             .body("[1].passingLevel", equalTo(0))
//             .body("[1].subject", nullValue())
//             .body("[1].firstName", nullValue())
//             .body("[1].lastName", nullValue());
//     }

//     @Test
//     public void GetAllAssesment() {
//         given()
//             .header("Authorization", "Bearer " + token)
//         .when()
//             .get("/api/assessment/assessments")
//         .then()
//             .statusCode(200)
//             .body("size()", greaterThan(0))
//             .body("[0].id", equalTo(1))
//             .body("[0].testName", equalTo("Basic MCQ Test"))
//             .body("[0].subjectId", equalTo(1))
//             .body("[0].duration", equalTo("00:00:00"))
//             .body("[0].subjectExpertId", equalTo(1))
//             .body("[0].creationDate", equalTo("2025-12-05T00:00:00"))
//             .body("[0].modificationDate", equalTo("2025-02-05T00:00:00"))
//             .body("[0].scheduledDate", equalTo("2024-01-01T00:00:00"))
//             .body("[0].status", equalTo("created"))
//             .body("[0].passingLevel", equalTo(0))
//             .body("[0].subject", equalTo("COREJAVA"))
//             .body("[0].firstName", equalTo("ravi"))
//             .body("[0].lastName", equalTo("tambade"));
//     }

//     @Test
//     public void GetAllEmployees() {
//         given()
//         .when()
//             .get("api/assessment/employees")
//         .then()
//             .statusCode(200)
//             .body("[0].id", equalTo(1))
//             .body("[0].userId", equalTo(1))
//             .body("[0].firstName", equalTo("ravi"))
//             .body("[0].lastName", equalTo("tambade"))
//             .body("[0].email", equalTo("ravi.tambade@example.com"))
//             .body("[0].contact", equalTo("9000000000"))
//             .body("[0].role", nullValue());
//     }

//     @Test
//     public void GetEmployeeById() {
//         given()
//         .when()
//             .get("api/assessment/employee/1")
//         .then()
//             .statusCode(200)
//             .body("id", equalTo(1))
//             .body("userId", equalTo(1))
//             .body("firstName", equalTo("ravi"))
//             .body("lastName", equalTo("tambade"))
//             .body("email", equalTo("ravi.tambade@example.com"))
//             .body("contact", equalTo("9000000000"))
//             .body("role", nullValue());
//     }

//     @Test
//     public void GetAllSubjects() {
//         given()
//         .when()
//             .get("api/assessment/subjects")
//         .then()
//             .statusCode(200)
//             .body("[0].id", equalTo(1))
//             .body("[0].title", equalTo("COREJAVA"));
//     }

//     @Test
//     public void getConcept() {
//         given()
//         .when()
//             .get("api/assessment/concepts")
//         .then()
//             .statusCode(200)
//             .body("[0].id", equalTo(1))
//             .body("[0].title", equalTo("OOPS"))
//             .body("[0].subjectId", equalTo(1));
//     }

//     @Test
//     public void GetConceptsBySubject() {
//         given()
//         .when()
//             .get("/api/assessment/concepts/subjects/1")
//         .then()
//             .statusCode(200)
//             .body("[0].id", equalTo(1))
//             .body("[0].title", equalTo("OOPS"))
//             .body("[0].subjectId", equalTo(1));
//     }

//     @Test
//     public void GetAllBySubjectMatterExpert() {
//         given()
//         .when()
//             .get("/api/assessment/subjectexperts/4")
//         .then()
//             .body("[0].id", equalTo(10))
//             .body("[0].testName", nullValue())
//             .body("[0].subjectId", equalTo(6))
//             .body("[0].duration", equalTo("00:30:00"))
//             .body("[0].subjectExpertId", equalTo(0))
//             .body("[0].creationDate", equalTo("2025-11-25T05:58:55"))
//             .body("[0].modificationDate", equalTo("2025-11-25T05:58:55"))
//             .body("[0].scheduledDate", equalTo("2025-11-25T11:28:00"))
//             .body("[0].status", equalTo("created"))
//             .body("[0].passingLevel", equalTo(0))
//             .body("[0].subject", nullValue())
//             .body("[0].firstName", nullValue())
//             .body("[0].lastName", nullValue());
//     }

//     @Test
//     public void CreateTest() {
//         String requestBody = """
//         {
//             "subjectId": 6,
//             "name": "Java Basics",
//             "duration": "00:30:00",
//             "subjectExpertId": 4,
//             "creationDate": "2025-11-25T05:58:55",
//             "modificationDate": "2025-11-25T05:58:55",
//             "scheduledDate": "2025-11-25T11:28:00",
//             "passingLevel": 0
//         }
//         """;

//         given()
//         .header("Content-Type", "application/json")
//         .body(requestBody)
//         .when()
//             .post("/api/Assessment/createtest")
//         .then()
//             .statusCode(200)
//             .body("message", equalTo("Test created successfully"));
//     }

//     @Test
//     public void AddQuestion() {
//         given()
//         .header("Content-Type", "application/json")
//         .when()
//             .post("api/Assessment/addquestion/assessments/1/questions/10")
//         .then()
//             .statusCode(200)
//             .body(equalTo("true"));
//     }

//     @Test
//     public void RemoveQuestion() {
//         given()
//         .header("Content-Type", "application/json")
//         .when()
//             .delete("/api/Assessment/1/questions/9")
//         .then()
//             .statusCode(200)
//             .body(equalTo("false"));
//     }

//     @Test
//     public void ChangeDuration() {
//         given()
//         .header("Content-Type", "application/json")
//         .when()
//             .put("/api/Assessment/1/duration/40")
//         .then()
//             .statusCode(200)
//             .body(equalTo("true"));
//     }

//     @Test
//     public void Reschedule() {
//         given()
//         .header("Content-Type", "application/json")
//         .when()
//             .put("/api/Assessment/1/reschedule/2024-01-01")
//         .then()
//             .statusCode(200)
//             .body(equalTo("true"));
//     }

//     @Test
//     public void RemoveQuestions() {
//         String requestBody = """
//         [41]
//         """;

//         given()
//         .headers("Content-Type", "application/json")
//         .body(requestBody)
//         .when()
//             .delete("/api/Assessment/deletequestions")
//         .then()
//             .statusCode(200)
//             .body(equalTo("false"));
//     }

//     @Test
//     public void AddTest() {
//         String requestBody = """
//         {
//             "subjectId": 1,
//             "name": "Java",
//             "duration": "01:30:00",
//             "smeId": 5,
//             "scheduledDate": "2025-11-25T14:30:00",
//             "passingLevel": 70,
//             "questionIds": [10, 12, 15, 18]
//         }
//         """;

//         given()
//         .header("Authorization", "Bearer " + smetoken)
//         .headers("Content-Type", "application/json")
//         .body(requestBody)
//         .when()
//             .post("/api/Assessment/addtest")
//         .then()
//             .statusCode(200)
//             .body("message", equalTo("Test created"));
//     }

//     @Test
//     public void GetAllQuestionsBySubject() {
//         given()
//         .when()
//             .get("/api/Assessment/allquestionsbysubject/6")
//         .then()
//             .statusCode(200)
//             .body("[0].questionBankId", equalTo(25))
//             .body("[0].title", equalTo("Which of the following tool is used to manage the GAC in .NET Framework?"))
//             .body("[0].a", equalTo("RegSvr.exe "))
//             .body("[0].b", equalTo("GacUtil.exe"))
//             .body("[0].c", equalTo("GacSvr32.exe"))
//             .body("[0].d", equalTo("GacMgr.exe"));
//     }

//     @Test
//     public void GetSmeBySubject() {
//         given()
//         .when()
//             .get("/api/Assessment/getsme/1")
//         .then()
//             .body("[0].id", equalTo(1))
//             .body("[0].userId", equalTo(1))
//             .body("[0].firstName", equalTo("ravi"))
//             .body("[0].lastName", equalTo("tambade"))
//             .body("[0].email", equalTo("ravi.tambade@example.com"))
//             .body("[0].contact", equalTo("9000000000"))
//             .body("[0].role", nullValue());
//     }

    

//     @Test
//     public void GetAllTests(){
//         given()
//          .header("Authorization", "Bearer " + token)
//         .headers("Content-Type", "application/json")
//         .when()
//         .get("/api/Assessment/getalltest/from/2025-11-24/to/2025-11-26")
//         .then()
//         .body("[0].id",equalTo(9))
//         .body("[0].name",equalTo("Advance java"))
//         .body("[0].scheduledDate",equalTo("2025-11-25T11:26:00"))
//         .body("[0].status",equalTo("created"));
//     }

//     @Test
//     public void GetTestDetails(){
//         given()
//         .when()
//         .get("/api/Assessment/testdetails/3")
//         .then()
//         .statusCode(200)
//         .body("id", equalTo(3))
//         .body("name", equalTo("Short Quiz on Basics"))
//         .body("subjectId", equalTo(1))
//         .body("duration", equalTo("00:20:00"))
//         .body("smeId", equalTo(1))
//         .body("passingLevel", equalTo(7))
//         .body("status", equalTo("created"))
//         .body("questions.size()", greaterThan(0));
//     }  
    
//     @Test 
//     public void GetQuestionsByConceptId(){
//         given()
//         .when()
//         .get("/api/Assessment/questionsbyconcepts/1")
//         .then()
//         .statusCode(200)
//         .body("[0].id",equalTo(0))
//         .body("[0].title",equalTo("Which keyword is used to inherit a class in Java?"))
//         .body("[0].a",equalTo("super"))
//         .body("[0].b",equalTo("extends"))
//         .body("[0].c",equalTo("implements"))
//         .body("[0].d",equalTo("inherits"))
//         .body("[0].subjectId",equalTo(1))
//         .body("[0].answerKey",equalTo("B"))
//         .body("[0].conceptId",equalTo(1));
//     }

//     @Test
//     public void UpdateQuestion(){
//         String requestBody = """
//         {
//             "id": 2,
//             "title": "Which exception is thrown when an array is accessed out of bounds in Java?",
//             "a": "NullPointerException",
//             "b": "ArrayIndexOutOfBoundsException",
//             "c": "IllegalArgumentException",
//             "d": "IndexException",
//             "subjectId": 10,
//             "answerKey": "B",
//             "conceptId": 106
//             }
//         """;
//         given()
//         .headers("Content-Type", "application/json")
//         .body(requestBody)
//         .when()
//         .put("/api/Assessment/updatequestion/2")
//         .then()
//         .statusCode(200)
//         .body("message", equalTo("Question updated successfully."));
//     }

    
//     @Test
//     public void UpdateTestStatus(){
//         String requestBody = """
//         {
//         "status":"created"
//         }
//         """;
//         given()
//         .headers("Content-Type", "application/json")
//         .body(requestBody)
//         .when()
//         .put("/api/Assessment/updateteststatus/1")
//         .then()
//         .statusCode(200)
//         .body("message", equalTo("Test updated successfully."));
//     }

//     @Test
//     public void GetAllTestByEmpId(){
//         given()
//         .when()
//         .get("/api/Assessment/alltestbyempid/1")
//         .then()
//         .statusCode(200)
//         .body("[0].id",equalTo(1))
//         .body("[0].testName",equalTo("Basic MCQ Test"))
//         .body("[0].passingLevel",equalTo("6"))
//         .body("[0].duration",equalTo("00:00:40"))
//         .body("[0].scheduledStart",equalTo("2025-08-13T16:30:00"))
//         .body("[0].scheduledEnd",equalTo("2025-08-13T16:30:00"))
//         .body("[0].status",equalTo("1"));
//     }
    

// }
