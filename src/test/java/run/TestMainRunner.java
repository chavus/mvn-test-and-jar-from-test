package run;
import io.cucumber.core.cli.Main;

public class TestMainRunner {
    public static void main(String[] args) {

        String[] cucumberArgs = new String[] {
                "-g","steps",
                "classpath:features",
                "-p", "pretty"
        };

        Main.run(cucumberArgs);
    }
}
