package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Mails {

    public SelenideElement subjectMail = $(".xT b");

    public SelenideElement search = $(By.name("q"));
    public ElementsCollection arrivedResult = $$(".xT .y6");
    public SelenideElement mailsCounter = $(".Dj b");

    final Random random = new Random();

    public String subjectText = "test message" + random.nextInt();

    public void newMessage(String recipient, String subject){
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(recipient);
        $(By.name("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }

    public void assertVisibleMail(String subject){
        subjectMail.shouldHave(exactText(subject));
        mailsCounter.shouldHave(exactText("1"));
    } // надеюсь, я правильно понял тебя по поводу оперирования

}
