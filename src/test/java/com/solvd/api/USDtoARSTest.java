package com.solvd.api;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.web.demoblaze.HomePage;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class USDtoARSTest extends AbstractTest {
    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://api-dolar-argentina.herokuapp.com/api").
                build();
    }

    @Test
    public void cheapestPhoneToOfficialUSD(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickPhones();

        int cheapestProductInUSD = homePage.getCheapestProduct().getPrice();
        double soldDolarOfficial = Double.parseDouble(given().spec(requestSpec).when().get("/dolaroficial").then().assertThat().statusCode(200).extract().path("venta"));
        double arsPrice = cheapestProductInUSD * soldDolarOfficial;

        Assert.assertEquals(given().spec(requestSpec).when().get("/dolaroficial").then().assertThat().statusCode(200).extract().path("venta"), Double.toString(soldDolarOfficial), "Values do not match");
        System.out.println("The price of the cheapest phone is: "+ arsPrice );
    }

    @Test
    public void expensivePhoneToOfficialUSD(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickPhones();

        int expensiveProductInUSD = homePage.getMostExpensiveProduct().getPrice();
        double soldDolarOfficial = Double.parseDouble(given().spec(requestSpec).when().get("/dolaroficial").then().assertThat().statusCode(200).extract().path("venta"));
        double arsPrice = expensiveProductInUSD * soldDolarOfficial;

        Assert.assertEquals(given().spec(requestSpec).when().get("/dolaroficial").then().assertThat().statusCode(200).extract().path("venta"), Double.toString(soldDolarOfficial), "Values do not match");
        System.out.println("The price of the expensive phone is: "+arsPrice );
    }

    @Test
    public void cheapestPhoneToBlueUSD(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickPhones();

        int cheapestProductInUSD = homePage.getCheapestProduct().getPrice();
        double soldDolarOfficial = Double.parseDouble(given().spec(requestSpec).when().get("/dolarblue").then().assertThat().statusCode(200).extract().path("venta"));
        double arsPrice = cheapestProductInUSD * soldDolarOfficial;

        Assert.assertEquals(given().spec(requestSpec).when().get("/dolarblue").then().assertThat().statusCode(200).extract().path("venta"), Double.toString(soldDolarOfficial), "Values do not match");
        System.out.println("The price of the cheapest phone is: "+ arsPrice );
    }

    @Test
    public void expensivePhoneToBlueUSD(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickPhones();

        int expensiveProductInUSD = homePage.getMostExpensiveProduct().getPrice();
        double soldDolarOfficial = Double.parseDouble(given().spec(requestSpec).when().get("/dolarblue").then().assertThat().statusCode(200).extract().path("venta"));
        double arsPrice = expensiveProductInUSD * soldDolarOfficial;

        Assert.assertEquals(given().spec(requestSpec).when().get("/dolarblue").then().assertThat().statusCode(200).extract().path("venta"), Double.toString(soldDolarOfficial), "Values do not match");
        System.out.println("The price of the expensive phone is: "+arsPrice );
    }
}
