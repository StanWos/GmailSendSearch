package com.main;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static pages.Gmail.*;


public class GmailTest {

    @Test
    public void testGmailSendSearch(){

        Configuration.timeout = 15000;

        open("https://mail.google.com/");

        email.setValue("stas.zoria").pressEnter();
        password.setValue("").pressEnter();

        newMessage("stas.zoria@gmail.com", "test message");

        inbox.click();
        ensureVisibleMail("Стас", "test message");

        sentMail.click();
        ensureVisibleMail("Стас", "test message");

        search.setValue("subject:(test message)").pressEnter();
        arrivedResult.filter(visible).shouldHaveSize(1);
    }

}
