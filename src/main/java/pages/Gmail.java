package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by stan on 30.03.16.
 */
public class Gmail {

    public static SelenideElement email = $("#Email");
    public static SelenideElement password = $("#Passwd");

    public static SelenideElement compose = $(byText("COMPOSE"));
    public static SelenideElement recipientBox = $(By.name("to"));
    public static SelenideElement subjectBox = $(By.name("subjectbox"));
    public static SelenideElement send = $(byText("Send"));

    public static SelenideElement inbox = $(By.partialLinkText("Inbox"));
    public static SelenideElement senderName = $("div>span");
    public static SelenideElement subjectMail = $(".xT b");

    public static SelenideElement sentMail = $(By.linkText("Sent Mail"));
    public static SelenideElement search = $("#gbqfq");
    public static ElementsCollection arrivedResult = $$("tr.zA.zE");

    public static void newMessage(String recipient, String subject){
        compose.click();
        recipientBox.setValue(recipient);
        subjectBox.setValue(subject);
        send.click();
    }

    public static void ensureVisibleMail(String name, String subject){
        senderName.shouldHave(exactText(name));
        subjectMail.shouldHave(exactText(subject));
    }
}
