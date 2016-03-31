package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by stan on 30.03.16.
 */
public class Gmail {

    static {
        Configuration.timeout = 15000;
    }

    public void visit(){
        open("https://mail.google.com/");
    }

    public void logIn(String email, String pass){
        $("#Email").setValue(email).pressEnter();
        $("#Passwd").setValue(pass).pressEnter();
    }


}
