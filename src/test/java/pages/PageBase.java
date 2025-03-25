package pages;

import com.github.javafaker.Faker;
import utility.Utility;


public class PageBase extends Utility {

    private final Faker faker;


    public PageBase(){

        faker =new Faker();

    }



    public Faker getFaker() {
        return faker;
    }


}
