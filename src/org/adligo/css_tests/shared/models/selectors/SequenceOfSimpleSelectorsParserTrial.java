package org.adligo.css_tests.shared.models.selectors;

import org.adligo.css.shared.models.selectors.CssNamespace;
import org.adligo.css.shared.models.selectors.CssNamespaceType;
import org.adligo.css.shared.models.selectors.NamespaceAndElement;
import org.adligo.css.shared.models.selectors.SequenceOfSimpleSelectors;
import org.adligo.css.shared.models.selectors.SequenceOfSimpleSelectorsParser;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_4mockito.MockitoSourceFileTrial;

import java.util.List;

@SourceFileScope (sourceClass=SequenceOfSimpleSelectorsParser.class,minCoverage=10.0)
public class SequenceOfSimpleSelectorsParserTrial extends MockitoSourceFileTrial {
  private SequenceOfSimpleSelectorsParser parser_ = new SequenceOfSimpleSelectorsParser();
  
  @Test
  public void testSimpleElement() {
    SequenceOfSimpleSelectors ss =  parser_.parse("hr");
    assertNotNull(ss);
    NamespaceAndElement en = ss.getNamespaceAndElement();
    assertNotNull(en);
    assertEquals("hr",en.getName());
    CssNamespace ns = en.getNamespace();
    assertEquals(CssNamespaceType.ANY, ns.getType());
    assertNull(ns.getName());
    
  }
  
  @Test
  public void testSimpleElementNoNamespace() {
    SequenceOfSimpleSelectors ss =  parser_.parse("|hr");
    NamespaceAndElement en = ss.getNamespaceAndElement();
    assertNotNull(en);
    assertEquals("hr",en.getName());
    CssNamespace ns = en.getNamespace();
    assertEquals(CssNamespaceType.NONE, ns.getType());
    assertNull(ns.getName());
  }
  
  @Test
  public void testSimpleElementCustomNamespace() {
    SequenceOfSimpleSelectors ss =  parser_.parse("foo|hr");
    NamespaceAndElement en = ss.getNamespaceAndElement();
    assertNotNull(en);
    assertEquals("hr",en.getName());
    CssNamespace ns = en.getNamespace();
    assertEquals(CssNamespaceType.NAMED, ns.getType());
    assertEquals("foo", ns.getName());
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testSimpleClass() {
    SequenceOfSimpleSelectors ss =  parser_.parse(".myClass");
    assertNotNull(ss);
    NamespaceAndElement en = ss.getNamespaceAndElement();
    assertNotNull(en);
    assertNull(en.getName());
    CssNamespace ns = en.getNamespace();
    assertEquals(CssNamespaceType.ANY, ns.getType());
    assertNull( ns.getName());
    
    List<String> classNames = ss.getClassNames();
    assertNotNull(classNames);
    assertContains(classNames, "myClass");
    assertEquals(1, classNames.size());
    
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testSimplClassNoNamespace() {
    SequenceOfSimpleSelectors ss =  parser_.parse("|.myClass");
    NamespaceAndElement en = ss.getNamespaceAndElement();
    assertNotNull(en);
   
    CssNamespace ns = en.getNamespace();
    assertEquals(CssNamespaceType.NONE, ns.getType());
    assertNull( ns.getName());
    
    List<String> classNames = ss.getClassNames();
    assertNotNull(classNames);
    assertContains(classNames, "myClass");
    assertEquals(1, classNames.size());
  }
  
  @Test
  public void testSimpleClassCustomNamespace() {
    SequenceOfSimpleSelectors ss =  parser_.parse("foo|.myClass");
    NamespaceAndElement en = ss.getNamespaceAndElement();
    assertNotNull(en);
    
    CssNamespace ns = en.getNamespace();
    assertEquals(CssNamespaceType.NAMED, ns.getType());
    assertEquals("foo", ns.getName());
    
    List<String> classNames = ss.getClassNames();
    assertNotNull(classNames);
    assertContains(classNames, "myClass");
  }
}
