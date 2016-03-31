package com.main;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import org.junit.Test;
import pages.Gmail;
import pages.Mails;
import pages.Menu;


public class GmailTest {

    Gmail gmail = new Gmail();
    Mails mails = new Mails();
    Menu menu = new Menu();

    @Test
    public void testGmailSendSearch(){

        gmail.visit();

        gmail.logIn(TestData.email, TestData.pass);

        mails.newMessage("stas.zoria@gmail.com", mails.subjectText);

        menu.refresh();
        mails.assertVisibleMail(mails.subjectText);

        menu.openSentMail();
        mails.assertVisibleMail(mails.subjectText);

        mails.search.setValue("subject:(" + mails.subjectText +")").pressEnter();
        mails.arrivedResult.filter(visible).find(text(mails.subjectText));
    }

}
