package com.main;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import pages.GmailPage;
import pages.MailsPage;
import pages.MenuPage;


import static helpers.Helpers.getUniqueText;


public class GmailTest {

    static {
        Configuration.timeout = 15000;
    }

    GmailPage gmailPage = new GmailPage();
    MailsPage mailsPage = new MailsPage();
    MenuPage menuPage = new MenuPage();

    @Test
    public void testGmailSendSearch(){

        gmailPage.visit();

        gmailPage.logIn(TestData.email, TestData.password);

        mailsPage.newMessage(TestData.email, subjectText);

        menuPage.refresh();
        mailsPage.assertMail(0, subjectText);

        menuPage.openSentMail();
        mailsPage.assertMail(0, subjectText);

        menuPage.openInbox();
        mailsPage.searchBySubject(subjectText);

        mailsPage.assertMails(subjectText);
    }

    String subjectText = getUniqueText("test message");

}
