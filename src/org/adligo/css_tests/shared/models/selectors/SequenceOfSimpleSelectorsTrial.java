package org.adligo.css_tests.shared.models.selectors;

import org.adligo.css.shared.models.selectors.CssAttribute;
import org.adligo.css.shared.models.selectors.CssPseudoClass;
import org.adligo.css.shared.models.selectors.SequenceOfSimpleSelectors;
import org.adligo.css.shared.models.selectors.SequenceOfSimpleSelectorsMutant;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockitoSourceFileTrial;

import java.util.Collections;

@SourceFileScope (sourceClass=SequenceOfSimpleSelectors.class,minCoverage=10.0)
public class SequenceOfSimpleSelectorsTrial extends MockitoSourceFileTrial {


  
  @SuppressWarnings("boxing")
  @Test
  public void testEqualsHashCode() {
    SequenceOfSimpleSelectorsMutant mutMut = new SequenceOfSimpleSelectorsMutant();
    SequenceOfSimpleSelectorsMutant omMut = new SequenceOfSimpleSelectorsMutant();
    
    SequenceOfSimpleSelectors mut = new SequenceOfSimpleSelectors(mutMut);
    SequenceOfSimpleSelectors om = new SequenceOfSimpleSelectors(omMut);
    assertEquals(mut, om);
    assertEquals(mut.hashCode(), om.hashCode());
    
    omMut.setClassNames(Collections.singleton("someClassName"));
    mut = new SequenceOfSimpleSelectors(mutMut);
    om = new SequenceOfSimpleSelectors(omMut);
    assertNotEquals(mut, om);
    assertNotEquals(mut.hashCode(), om.hashCode());
    
    mutMut.setClassNames(Collections.singleton("someClassName"));
    mut = new SequenceOfSimpleSelectors(mutMut);
    om = new SequenceOfSimpleSelectors(omMut);
    assertEquals(mut, om);
    assertEquals(mut.hashCode(), om.hashCode());
  }
}
