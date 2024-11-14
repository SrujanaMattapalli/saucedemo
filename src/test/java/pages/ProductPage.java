// src/test/java/pages/InventoryPage.java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductPage extends BasePage {
    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPrices;

    private WebElement selectedItem;
    private double highestPrice = 0.0;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void findHighestPricedItem() {
        waitForElementsToBeVisible(itemPrices);

        for (int i = 0; i < itemPrices.size(); i++) {
            String priceText = itemPrices.get(i).getText().replace("$", "");
            double currentPrice = Double.parseDouble(priceText);

            if (currentPrice > highestPrice) {
                highestPrice = currentPrice;
                selectedItem = inventoryItems.get(i);
            }
        }
    }

    public void addHighestPricedItemToCart() {
        if (selectedItem != null) {
            WebElement addToCartButton = selectedItem.findElement(
                    org.openqa.selenium.By.cssSelector("button[id^='add-to-cart']"));
            waitForElementToBeClickable(addToCartButton);
            addToCartButton.click();
        }
    }
}
