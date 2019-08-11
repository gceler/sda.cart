package pl.sda.automationpractice;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DodawanieDoKoszyka {
    @Test
    public void dodajProduktDoKoszyka() {
        ChromeDriver przegladarka = new ChromeDriver();
        Actions akcje = new Actions(przegladarka);

        przegladarka.manage().window().setSize(new Dimension(1024,768));

        przegladarka.get("http://automationpractice.com/index.php");
        List<WebElement> przyciski = przegladarka.findElementsByCssSelector("#homefeatured .ajax_add_to_cart_button");

        akcje.moveToElement(przyciski.get(3)).perform();

        przyciski.get(3).click();

    }
}
