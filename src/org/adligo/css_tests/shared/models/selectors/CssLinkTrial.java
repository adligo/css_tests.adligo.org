package org.adligo.css_tests.shared.models.selectors;

import org.adligo.css.shared.models.selectors.CssAttribute;
import org.adligo.css.shared.models.selectors.CssLink;
import org.adligo.css.shared.models.selectors.CssPseudoClass;
import org.adligo.css.shared.models.selectors.SequenceOfSimpleSelectors;
import org.adligo.css.shared.models.selectors.SequenceOfSimpleSelectorsMutant;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockitoSourceFileTrial;

import java.util.Collections;

@SourceFileScope (sourceClass=CssLink.class,minCoverage=10.0)
public class CssLinkTrial extends MockitoSourceFileTrial {


  
  @SuppressWarnings("boxing")
  @Test
  public void testEqualsHashCode() {
    SequenceOfSimpleSelectorsMutant mut = new SequenceOfSimpleSelectorsMutant();
    SequenceOfSimpleSelectorsMutant om = new SequenceOfSimpleSelectorsMutant();
    CssLink mutLink = new CssLink(mut);
    CssLink omLink = new CssLink(om);
    assertEquals(mutLink, omLink);
    assertEquals(mutLink.hashCode(), omLink.hashCode());
    
    om.setClassNames(Collections.singleton("someClassName"));
    mutLink = new CssLink(mut);
    omLink = new CssLink(om);
    assertNotEquals(mutLink, omLink);
    assertNotEquals(mutLink.hashCode(), omLink.hashCode());
    
    mut.setClassNames(Collections.singleton("someClassName"));
    mutLink = new CssLink(mut);
    omLink = new CssLink(om);
    assertEquals(mutLink, omLink);
    assertEquals(mutLink.hashCode(), omLink.hashCode());
  }
}
