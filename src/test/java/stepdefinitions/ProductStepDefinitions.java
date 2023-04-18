package stepdefinitions;

import controller.EnvironmentController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Product;

import net.thucydides.core.annotations.Steps;
import steps.ProductSteps;

import java.io.IOException;
import java.util.List;

public class ProductStepDefinitions {

    @Steps
    public ProductSteps productSteps;
    List<Product> expectedProductData;

    @Given("I want to see all the available {string} products in my e-commerce shop")
    public void iWantToSeeAllTheAvailableProductsInMyEcommerceShop(String product) throws IOException {
        expectedProductData = EnvironmentController.getJsonArrayFromFile(product);
    }

    @When("I search for all {string} products")
    public void iSearchForAllProducts(String product) {
        productSteps.getProduct(product);
    }

    @Then("I should retrieve a list of products")
    public void iShouldRetrieveAListOfProducts() {
        productSteps.verifyListOfProducts(expectedProductData);
    }

    @Given("I attempt to see unavailable products in my e-commerce shop")
    public void iAttemptToSeeUnavailableProductsInMyECommerceShop() {
        // Left empty intentionally for readability of BDD
    }

    @Then("I should see the correct error message {string} not found")
    public void iShouldSeeTheCorrectErrorMessageNotFound(String missingProduct) {
        productSteps.attemptToVerifyProductList(missingProduct);
    }
}
