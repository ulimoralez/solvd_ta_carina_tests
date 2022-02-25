package com.solvd.web.demoblaze;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

public class RestAssureTest {

    @DataProvider (name = "zipCodesAndPlaces")
    public Object[][] zipCodesAndPlaces(){
        return new Object[][] {{ "us", "90210", "Beverly Hills" },
                { "us", "12345", "Schenectady" },
                { "ca", "B2R", "Waverley"}};
    }

    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails() {
        given().
                log().all().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                log().body();
    }

    @Test
    public void requestUsZipCode90210_checkStateNameInResponseBody_expectCalifornia()
    {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places[0].state", equalTo("California"));
    }

    @Test
    public void requestUsZipCode90210_checkListOfPlaceNamesInResponseBody_expectContainsBeverlyHills()
    {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasItem("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_checkNumberOfPlaceNamesInResponseBody_expectOne() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasSize(1));
    }

    @Test (dataProvider = "zipCodesAndPlaces")
    public void requestZipCodesFromCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceName(String countryCode, String zipCode, String expectedPlaceName)
    {
        given().
                pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
                when().
                get("http://zippopotam.us/{countryCode}/{zipCode}").
                then().
                assertThat().
                body("places[0].'place name'", equalTo(expectedPlaceName));
    }
}
