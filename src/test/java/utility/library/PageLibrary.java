package utility.library;

import pages.RegisterUserPage;
import pages.RegisterUserPage_DS;


public class PageLibrary {

    RegisterUserPage registerUserPage;
RegisterUserPage_DS registerUserPage_ds;


    public PageLibrary() {


        registerUserPage=new RegisterUserPage();
        registerUserPage_ds=new RegisterUserPage_DS();
    }




    public RegisterUserPage getRegisterUserPage(){return registerUserPage;}
    public RegisterUserPage_DS getRegisterUserPage_ds(){return registerUserPage_ds;}

}
