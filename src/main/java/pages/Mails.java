package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Mails {


    public ElementsCollection listMails = $$(".xT b");
    // этот силектор очень хорошо подходит для поиска мейлов
    // я даже пробовал по несколько мейлов искать, он отлично справляется

    public void newMessage(String recipient, String subject){
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(recipient);
        $(By.name("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }

    public void assertVisibleMail(String subject){
        listMails.filterBy(exactText(subject)).shouldHaveSize(1).first();
        /* почти так как ты писала, "что в СПИСКЕ писем - письмо одно и в его текст входит такой-то текст".
          Но у меня сначала фильтрует по тексту, а потом уже что письмо одно, и элемент первый
           надеюсь что порядок действий разницы не играет, но работает правильно. И это локаничнее чем 2 проверки */
    }

    public void searchBySubject(String subject){
        $(By.name("q")).setValue("subject:(" + subject +")").pressEnter();
    }

}
