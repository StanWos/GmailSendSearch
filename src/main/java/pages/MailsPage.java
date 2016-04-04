package pages;

import static com.codeborne.selenide.CollectionCondition.*;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MailsPage {


    public ElementsCollection listMails = $$(".zA");

    public void newMessage(String recipient, String subject){
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(recipient);
        $(By.name("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }

    public void assertVisibleMail(String subject){
        listMails.get(0).shouldHave(text(subject));
    }

    public void assertFilteringMail(String subject){
        listMails.filterBy(visible).shouldHave(texts(subject));
    }

    public void searchBySubject(String subject){
        $(By.name("q")).setValue("subject:(" + subject +")").pressEnter();
    }

}
