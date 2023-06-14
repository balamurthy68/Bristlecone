package runners;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.core.options.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("newCucumberProject")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "html:target/loginhtml.html")
@ConfigurationParameter(key = Constants.ANSI_COLORS_DISABLED_PROPERTY_NAME,value="true")
@ConfigurationParameter(key= Constants.FEATURES_PROPERTY_NAME,value="src/test/resources/features/search.feature")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Negative") 
@ConfigurationParameter(key=Constants.GLUE_PROPERTY_NAME,value="Steps")
@ConfigurationParameter(key=Constants.PLUGIN_PUBLISH_URL_PROPERTY_NAME,value="target/htmlreports")
public class RunCucumberTest {
}
