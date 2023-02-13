package steps;

import io.cucumber.java.en.Given;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestSteps {
    @Given("I can read property from property file")
    public void iCanReadProperty() {
        System.out.println("I can read property testkey:");
        System.out.println(getPropertyFromFile("test.properties","testkey"));
    }

    public static String getPropertyFromFile(String filePathAndName, String propertyName){
        try{
            InputStream resourceAsStream = TestSteps.class.getClassLoader().getResourceAsStream(filePathAndName);
            Properties prop = new Properties();
            prop.load(resourceAsStream);
            return prop.getProperty(propertyName);
        } catch (IOException e) {
            return null;
        }
    }

}
