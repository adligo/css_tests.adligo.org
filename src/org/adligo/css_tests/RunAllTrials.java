package org.adligo.css_tests;

import org.adligo.css_tests.shared.models.selectors.A_SelectorTrials;
import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j_4jacoco.plugin.factories.Tests4J_4MockitoPluginFactory;

public class RunAllTrials {

  public static void main(String [] args) {
    try {
      Tests4J_Params params = new Tests4J_Params();
     
      A_SelectorTrials me = new A_SelectorTrials();
      params.setCoveragePluginFactoryClass(Tests4J_4MockitoPluginFactory.class);
      params.addTrials(me);
      
      Tests4J.run(params);
    } catch (Exception x) {
      x.printStackTrace();
    }
  }
}
