package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Com.kia/src/test/java/Features", glue={"Stepdefinition"},tags="",plugin="")
public class TestRunner {


}
