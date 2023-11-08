package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class amazone {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.amazon.in/");
            page.getByLabel("Select the department you want to search in").selectOption("search-alias=baby");
            page.getByPlaceholder("Search Amazon.in").fill("dress");
            page.getByPlaceholder("Search Amazon.in").press("Enter");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get It Today")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get It by Tomorrow")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Clear")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("₹1,000 - ₹2,000")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Baby Shoes")).click();
            Page page1 = page.waitForPopup(() -> {
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Antheron Baby Girls Mary Jane Flats Soft Sole Infant Moccasins Floral Sparkly Toddler Princess Dress Shoes")).first().click();
            });
            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("EMI options")).click();
            page1.getByLabel("Close", new Page.GetByLabelOptions().setExact(true)).click();
            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Amazon Pay ICICI Credit Card Processing Fee of ₹199 by Bank")).click();
            page1.close();
            page.getByLabel("Open Menu").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Fire TV")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Amazon Prime Video")).click();
        }
    }
}