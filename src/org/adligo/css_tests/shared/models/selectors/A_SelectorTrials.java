package org.adligo.css_tests.shared.models.selectors;

import org.adligo.tests4j.run.api.Tests4J;
import org.adligo.tests4j.system.shared.api.I_Tests4J_TrialList;
import org.adligo.tests4j.system.shared.api.Tests4J_Params;
import org.adligo.tests4j.system.shared.trials.I_Trial;
import org.adligo.tests4j_4jacoco.plugin.factories.Tests4J_4MockitoPluginFactory;

import java.util.ArrayList;
import java.util.List;

public class A_SelectorTrials implements I_Tests4J_TrialList {

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
  
  @Override
  public List<Class<? extends I_Trial>> getTrials() {
    List<Class< ? extends I_Trial>> trials = new ArrayList<Class< ? extends I_Trial>>();
    trials.add(CssNamespaceTrial.class);
    trials.add(SequenceOfSimpleSelectorsMutantTrial.class);
    trials.add(SequenceOfSimpleSelectorsParserTrial.class);
    return trials;
  }

}
