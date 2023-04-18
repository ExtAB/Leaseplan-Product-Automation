package steps;

import controller.EnvironmentController;
import model.Product;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import restAPI.ProductClient;

import java.util.List;

import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class ProductSteps {

    @Steps
    ProductClient productClient;
    List<Product> currentProductDataFix;

    public void getProduct(String product) {
        productClient.getProduct(product);
    }

    public void verifyListOfProducts(List<Product> expectedPayloadData) {
        then().statusCode(SC_OK);
        currentProductDataFix = EnvironmentController.getJsonArrayFromLastResponse();
        assertEquals(currentProductDataFix.size(), expectedPayloadData.size());
    }

    public void attemptToVerifyProductList(String missingProduct) {
        then().assertThat().statusCode(SC_NOT_FOUND);
        assertThat("The product in search is missing from our e-commerce shop", SerenityRest.lastResponse().getBody().jsonPath().get("detail.requested_item").equals(missingProduct));
    }

}
