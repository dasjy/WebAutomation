package Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class TracingTest {
    public static  void main(String... args){
        Playwright playwright =Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);

        Browser browser =playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        Page page = context.newPage();
        page.navigate("https://demo.guru99.com/test/login.html");
        page.getByLabel("Email address").click();
        page.getByLabel("Email address").press("Control+V");
        page.getByLabel("Password").click();
        page.getByLabel("Password").press("Control+V");
        page.getByLabel("Password").fill("");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Forgot your password?")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Forgot your password?")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Successfully Logged in...")).click();
        page.locator(".error-copy > a").click();
        page.navigate("https://demo.guru99.com/test/success.html");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Bank Project")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Telecom Project")).click();

        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
    }
}
