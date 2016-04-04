package com.main;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import pages.Gmail;
import pages.Mails;
import pages.Menu;


import static helpers.Helpers.subjectText;


public class GmailTest {

    static {
        Configuration.timeout = 15000;
    }

    Gmail gmailPage = new Gmail();
    Mails mailsPage = new Mails();
    Menu menuPage = new Menu();

    @Test
    public void testGmailSendSearch(){

        gmailPage.visit();

        gmailPage.logIn(TestData.email, TestData.password);

        mailsPage.newMessage(TestData.email, subjectText);

        menuPage.refresh();
        mailsPage.assertVisibleMail(subjectText);

        menuPage.openSentMail();
        mailsPage.assertVisibleMail(subjectText);

        menuPage.openInbox();
        mailsPage.searchBySubject(subjectText);

        mailsPage.assertVisibleMail(subjectText);
    }

    String subjectText = subjectText();

}
