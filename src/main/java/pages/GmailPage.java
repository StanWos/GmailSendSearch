package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GmailPage {

    public void visit(){
        open("https://mail.google.com/");
    }

    public void logIn(String email, String pass){
        $("#Email").setValue(email).pressEnter();
        $("#Passwd").setValue(pass).pressEnter();
    }


}
