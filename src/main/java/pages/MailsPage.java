package pages;

import static com.codeborne.selenide.CollectionCondition.*;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MailsPage {


    public ElementsCollection listMails = $$("[role = 'main'] .zA");

    public void newMessage(String recipient, String subject){
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(recipient);
        $(By.name("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }

    public void assertMail(int index, String subject){
        listMails.get(index).shouldHave(text(subject));
    }

    public void assertMails(String... subjects){
        listMails.shouldHave(texts(subjects));
    }

    public void searchBySubject(String subject){
        $(By.name("q")).setValue("subject:(" + subject +")").pressEnter();
    }

}
