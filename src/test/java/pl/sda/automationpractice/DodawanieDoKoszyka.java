package pl.sda.automationpractice;

import org.junit.*;
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
        otworzStroneGlowna();
        dodajProduktNr(1);
        kontynuujZakupy();
        dodajProduktNr(2);
        przejdzDoKasy();
        sprawdzIloscProduktow("2");
    }

    private void otworzStroneGlowna() {
        przegladarka.get("http://automationpractice.com/index.php");
    }

    private void dodajProduktNr(int i) {
        przyciski = przegladarka.findElementsByCssSelector("#homefeatured .ajax_add_to_cart_button");
        przyciski.get(i-1).click();
    }

    private void kontynuujZakupy() {
        kontynuuj = przegladarka.findElementByCssSelector(".continue");
        kontynuuj.click();
    }

    private void przejdzDoKasy() {
        kasa = przegladarka.findElementByCssSelector(".button-medium");
        kasa.click();
    }

    private void sprawdzIloscProduktow(String x) {
        iloscProduktow = przegladarka.findElementByCssSelector(".ajax_cart_quantity").getText();
        Assert.assertEquals (x,iloscProduktow);
    }
}

