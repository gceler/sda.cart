package pl.sda.automationpractice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DodawanieDoKoszyka {
    ChromeDriver przegladarka;
    Actions actions;
    List<WebElement> przyciski;
    WebElement kontynuuj;
    WebElement kasa;
    String iloscProduktow;

    @Before
    public void otwarcie() {
        przegladarka = new ChromeDriver();
        actions = new Actions(przegladarka);
        przegladarka.manage().window().setSize(new Dimension(1024,768));
        przegladarka.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void zamkniecie() {
        przegladarka.quit();
    }
    @Test
    public void dodajProduktDoKoszyka() {

        przegladarka.get("http://automationpractice.com/index.php");

        przyciski = przegladarka.findElementsByCssSelector("#homefeatured .ajax_add_to_cart_button");

        //actions.moveToElement(przyciski.get(3)).perform(); - u mnie przechodzi bez tego

        przyciski.get(3).click();

        kontynuuj = przegladarka.findElementByCssSelector(".continue");

        kontynuuj.click();

        przyciski.get(3).click();

        kasa = przegladarka.findElementByCssSelector(".button-medium");

        kasa.click();

        iloscProduktow = przegladarka.findElementByCssSelector(".cart_quantity_input").getAttribute("value");

        Assert.assertEquals ("2",iloscProduktow);
    }
}

