package com.example.catalog.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;


public class ProductAPITest{

    @Test
    public void testGetAllProducts(){
        RestAssured.baseURI="http://localhost:6070";


        given()
           .when().get("/api/products")
           .then()
           .statusCode(200)
           .body("size()",greaterThan(0))
           .body("[0].name",notNullValue());
    }

    @Test
    public void getProductById_showReturnOne(){
        RestAssured.baseURI="http://localhost:6070";
        given()
        .when()
             .get("/api/products/1")
        .then()
             .statusCode(200);
            // .body("name",notNullValue())
          //   .body("price",greaterThan(14000));
    }

    @Test
    public void createProduct_shouldReturn201(){
        RestAssured.baseURI="http://localhost:6070";
        String newProductJson="""
                {
        "id":4,
        "name":"Iphone18",
        "price" :180000.00
        }
        """;

        given()
            .contentType(ContentType.JSON)
            .body(newProductJson)
            .when()
                  .post("/api/products")
            .then()
                .statusCode(201)
                .body("id",notNullValue())
                .body("name",equalTo("Iphone18"))
                .body("price",equalTo(180000.00));
    }

    @Test
    public void updateProduct_showReturn400(){
        RestAssured.baseURI="http://localhost:6070";
        String updateProductJson="""
                {
        "id:1,
        "name":"redmi"
        "price":15000.00
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(updateProductJson)
        .when()
                .put("/api/products/1")
        .then()
                .statusCode(400)
                .body("name",equalTo("redmi"))
                .body("price",equalTo(15000.00));
       }

    @Test
    public void deleteProduct_showReturn200(){
        RestAssured.baseURI="http://localhost:6070";
        given()
        .when()
            .delete("/api/products/1")
        .then()
            .statusCode(200);
    }
}