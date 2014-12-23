package org.adligo.css_tests.shared.models.selectors;

import org.adligo.css.shared.models.selectors.CssLink;
import org.adligo.css.shared.models.selectors.Selector;
import org.adligo.css.shared.models.selectors.SequenceOfSimpleSelectorsMutant;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockitoSourceFileTrial;

import java.util.Collections;

@SourceFileScope (sourceClass=CssLink.class,minCoverage=10.0)
public class SelectorTrial extends MockitoSourceFileTrial {


  
  @SuppressWarnings("boxing")
  @Test
  public void testEqualsHashCode() {
    SequenceOfSimpleSelectorsMutant mut = new SequenceOfSimpleSelectorsMutant();
    SequenceOfSimpleSelectorsMutant om = new SequenceOfSimpleSelectorsMutant();
    Selector mutSel = new Selector(new CssLink(mut));
    Selector omSel = new Selector(new CssLink(om));
    assertEquals(mutSel, omSel);
    assertEquals(mutSel.hashCode(), omSel.hashCode());
    
    om.setClassNames(Collections.singleton("someClassName"));
    mutSel = new Selector(new CssLink(mut));
    omSel = new Selector(new CssLink(om));
    assertNotEquals(mutSel, omSel);
    assertNotEquals(mutSel.hashCode(), omSel.hashCode());
    
    mut.setClassNames(Collections.singleton("someClassName"));
    mutSel = new Selector(new CssLink(mut));
    omSel = new Selector(new CssLink(om));
    assertEquals(mutSel, omSel);
    assertEquals(mutSel.hashCode(), omSel.hashCode());
  }
}
