package restAPI;

import net.serenitybdd.rest.SerenityRest;

public class ProductClient {

    public void getProduct(String product) {
        SerenityRest.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .get(Endpoints.BASE.getPath() + Endpoints.SEARCH.getPath() + product);
    }
}
