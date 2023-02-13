package run;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
//@ConfigurationParameter(key=" cucumber.publish.quiet", value="true")
public class RunCucumberTest {

}
