package pages;


import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class Menu {

    public void refresh(){
        $(".asf").click();
    }

    public void openSentMail(){
        $(By.linkText("Sent Mail")).click();
    }

    public void openInbox(){
        $(By.partialLinkText("Inbox")).click();
    }

}
