package org.adligo.css_tests.shared.models.selectors;

import org.adligo.css.shared.models.selectors.CssAttribute;
import org.adligo.css.shared.models.selectors.CssPseudoClass;
import org.adligo.css.shared.models.selectors.SequenceOfSimpleSelectorsMutant;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockitoSourceFileTrial;

@SourceFileScope (sourceClass=SequenceOfSimpleSelectorsMutant.class,minCoverage=10.0)
public class SequenceOfSimpleSelectorsMutantTrial extends MockitoSourceFileTrial {

  @Test
  public void testHasNullElementNameButOtherSimpleSelector() {
    SequenceOfSimpleSelectorsMutant mut = new SequenceOfSimpleSelectorsMutant();
    assertFalse(SequenceOfSimpleSelectorsMutant.hasNonElementNameSimpleSelector(mut));
    
    mut.addAttribute(new CssAttribute("width"));
    assertTrue(SequenceOfSimpleSelectorsMutant.hasNonElementNameSimpleSelector(mut));
   
    mut = new SequenceOfSimpleSelectorsMutant();
    mut.addId("id");
    assertTrue(SequenceOfSimpleSelectorsMutant.hasNonElementNameSimpleSelector(mut));
    
    mut = new SequenceOfSimpleSelectorsMutant();
    mut.addClassName("className");
    assertTrue(SequenceOfSimpleSelectorsMutant.hasNonElementNameSimpleSelector(mut));
    
    mut = new SequenceOfSimpleSelectorsMutant();
    mut.addPseudoClass(new CssPseudoClass<String>("className"));
    assertTrue(SequenceOfSimpleSelectorsMutant.hasNonElementNameSimpleSelector(mut));
    
    mut = new SequenceOfSimpleSelectorsMutant();
    mut.addPseudoClass(new CssPseudoClass<String>("hey"));
    assertTrue(SequenceOfSimpleSelectorsMutant.hasNonElementNameSimpleSelector(mut));
  }
}
