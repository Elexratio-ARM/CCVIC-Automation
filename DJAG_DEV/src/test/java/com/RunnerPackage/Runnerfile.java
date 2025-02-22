package com.RunnerPackage;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    //features = "Feature/StartACase.feature"
    		 features = "Feature/case.feature", // Update the path to match your project structure
    glue = {"com.stepdefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
    		 , tags ="@FileaDocumentForMagistrate" 
    				 )
public class Runnerfile {

}