package API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class apiTest {

    int seasonYear = 2017;
    int raceNumber = 2;
    //Possible to make baseUri variable (not base url!)

    @Test
    public void apiDemo() {

        when().get("http://ergast.com/api/f1/current/last/results.json").
                then().statusCode(200);
    }

    @Test
    public void apiDriverIdVerstappen() {

        String body = given().when().get("http://ergast.com/api/f1/{season}/drivers/verstappen/results.json", seasonYear).getBody().prettyPrint();
        System.out.println(body);

        given().when().get("http://ergast.com/api/f1/{season}/drivers/verstappen/results.json", seasonYear).
                then().statusCode(200).body("MRData.RaceTable.driverId", equalTo("max_verstappen"));
    }

    @Test
    public void pathParam(){

        given().pathParam("season", 2016).when().get("http://ergast.com/api/f1/{season}/last/results.json").
                then().statusCode(200);
    }

    @Test
    public void pathParamTwo(){

        //Variables must be added in order of appearance
        given().when().get("http://ergast.com/api/f1/{season}/{race}/results.json", seasonYear, raceNumber).
                then().statusCode(200);
    }

    @Test
    public void pathParamThree(){

        given().pathParam("season", seasonYear).when().get("http://ergast.com/api/f1/{season}/{race}/results.json").
                then().statusCode(200);
    }

}
