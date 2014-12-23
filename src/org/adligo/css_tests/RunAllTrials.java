package org.adligo.css_tests;

import org.adligo.css_tests.shared.models.selectors.A_CssModelsSelectorsTrials;
import org.adligo.css_tests.use_case_trials.A_UseCaseTrials;
import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.factories.Tests4J_4MockitoPluginFactory;

public class RunAllTrials {
  private static A_CssModelsSelectorsTrials MODEL_TRIALS = new A_CssModelsSelectorsTrials();
  private static A_UseCaseTrials USE_CASE_TRIALS = new A_UseCaseTrials();
  
  public static void main(String [] args) {
    try {
      Tests4J_Params params = new Tests4J_Params();
     
      params.setCoveragePluginFactoryClass(Tests4J_4MockitoPluginFactory.class);
      params.addTrials(MODEL_TRIALS);
      params.addTrials(USE_CASE_TRIALS);
      
      Tests4J.run(params);
    } catch (Exception x) {
      x.printStackTrace();
    }
  }
}
