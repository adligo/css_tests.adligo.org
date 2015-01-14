package org.adligo.css_tests.shared.models.selectors;

import org.adligo.css.shared.models.selectors.CssNamespace;
import org.adligo.css.shared.models.selectors.CssNamespaceType;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockitoSourceFileTrial;

@SourceFileScope (sourceClass=CssNamespace.class,minCoverage=20.0)
public class CssNamespaceTrial extends MockitoSourceFileTrial {

  @Test
  public void testConstructors() {
    assertThrown(new ExpectedThrowable(
        new IllegalArgumentException(
            CssNamespace.NAMED_CSS_NAMESPACE_MUST_USE_THE_STRING_NAME_CONSTRUCTOR)),
        new I_Thrower() {
          
          @Override
          public void run() throws Throwable {
            new CssNamespace(CssNamespaceType.NAMED);
          }
        });
    
    CssNamespace ns = new CssNamespace(CssNamespaceType.ANY);
    assertEquals(CssNamespaceType.ANY, ns.getType());
    assertNull(ns.getName());
    
    ns = new CssNamespace(CssNamespaceType.NONE);
    assertEquals(CssNamespaceType.NONE, ns.getType());
    assertNull(ns.getName());
    
    
    ns = new CssNamespace("foo");
    assertEquals(CssNamespaceType.NAMED, ns.getType());
    assertEquals("foo", ns.getName());
  }
}
