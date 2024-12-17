package it.univr;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdvancedOperationTest {
    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void ranking(){
        Utils.initDatabase();

        when()
            .get("/ranking")
        .then()
            .statusCode(200)
            .body("1.bookTitle", Matchers.is("La Divina Commedia"))
            .body("1.monthlyReaders", Matchers.is(1500))
            .body("2.bookTitle", Matchers.is("I Promessi Sposi"))
            .body("2.monthlyReaders", Matchers.is(1200))
            .body("3.bookTitle", Matchers.is("1984"))
            .body("3.monthlyReaders", Matchers.is(1000))
            .body("4.bookTitle", Matchers.is("Le Avventure di Pinocchio"))
            .body("4.monthlyReaders", Matchers.is(950))
            .body("5.bookTitle", Matchers.is("Orgoglio e Pregiudizio"))
            .body("5.monthlyReaders", Matchers.is(850))
            .body("6.bookTitle", Matchers.is("Moby Dick"))
            .body("6.monthlyReaders", Matchers.is(800))
            .body("7.bookTitle", Matchers.is("Cime Tempestose"))
            .body("7.monthlyReaders", Matchers.is(750))
            .body("8.bookTitle", Matchers.is("Il Gattopardo"))
            .body("8.monthlyReaders", Matchers.is(700))
            .body("9.bookTitle", Matchers.is("Cuore"))
            .body("9.monthlyReaders", Matchers.is(650))
            .body("10.bookTitle", Matchers.is("Il Principe"))
            .body("10.monthlyReaders", Matchers.is(600));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void bestBook(){ //the one with most monthly readers
        Utils.initDatabase();

        when()
            .get("/bestBook")
        .then()
            .statusCode(200)
            .body("bestBook", Matchers.is("La Divina Commedia"));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void allTitles(){ //the one with most monthly readers
        Utils.initDatabase();

        when()
            .get("/titles")

        .then()
            .statusCode(200)
            .body("titles", Matchers.containsInAnyOrder("La Divina Commedia", "I Promessi Sposi", "Moby Dick",
                                                                      "1984", "Le Avventure di Pinocchio",
                                                                      "Orgoglio e Pregiudizio", "Il Gattopardo",
                                                                      "Cuore", "Il Principe", "Cime Tempestose"));
    }
}
