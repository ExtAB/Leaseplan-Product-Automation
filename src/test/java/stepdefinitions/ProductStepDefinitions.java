package stepdefinitions;

import controller.EnvironmentController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Product;

import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import steps.ProductSteps;

import java.io.IOException;
import java.util.List;

public class ProductStepDefinitions {

    @Steps
    public ProductSteps productSteps;
    List<Product> expectedProductData;
    List<Product> currentProductDataFix;
    private String attribute;
    private String specification;

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

    @Given("I want to see all the available products in his shop with a specific attribute")
    public void iWantToSeeAllTheAvailableProductsInHisShopWithASpecificAttribute() {
        // Left empty intentionally for readability of BDD
    }

    @When("I searches for all {string} products with {string} attribute that includes {string}")
    public void iSearchesForAllProductsWithAttributeThatIncludes(String product, String attribute, String specification) {
        productSteps.getProduct(product);
        this.attribute = attribute;
        this.specification = specification;
    }

    private Product verifyElement(String attribute, String specification) {
        currentProductDataFix = EnvironmentController.getJsonArrayFromLastResponse();
        switch (attribute) {
            case "provider":
                return currentProductDataFix.stream().filter(att -> att.getProvider().contains(specification)).findFirst().orElse(null);
            //return currentProductDataFix.stream().map(Product::getProvider).filter(p -> p.contains(specification)).findAny().orElse(null); if we want a specific attribute not the entire product
            case "price":
                //same for all the attributes title,unit,isPromo etc
        }
        return null;
    }

    @Then("I should retrieve one or more product")
    public void iShouldRetrieveOneOrMoreProduct() {
        Assert.assertNotNull(verifyElement(attribute, specification));
    }
}
