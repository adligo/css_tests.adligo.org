package org.adligo.css_tests.use_case_trials;

import org.adligo.css.shared.models.CssType;
import org.adligo.css.shared.models.ExpectedCssMutant;
import org.adligo.css.shared.models.StyleSheet;
import org.adligo.css.shared.models.StyleSheetParser;
import org.adligo.css.shared.models.common.CssI18nConstants;
import org.adligo.css.shared.models.selectors.Selector;
import org.adligo.css.shared.models.selectors.SequenceOfSimpleSelectors;
import org.adligo.tests4j.system.shared.trials.PackageScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j.system.shared.trials.UseCaseScope;
import org.adligo.tests4j_4mockito.MockitoApiTrial;

/**
 * TODO change this to a use case trial, after 
 * tests4j starts working with requirements.xml files
 * @author scott
 *
 */
@PackageScope (packageName="org.adligo.css.shared")
public class ParseCssStringWithStarCommentAndFontSizePxTrial extends MockitoApiTrial {
  StyleSheetParser parser = new StyleSheetParser();
  
  @SuppressWarnings("boxing")
  @Test
  @UseCaseScope (name="Parse CSS String with a comment (/* blah */) inside of virtual machine (JVM or JavaScript engine) in order to get a font-size px integer.")
  public void testParseCssString() {
    Selector selector = new Selector(new SequenceOfSimpleSelectors("someClassName"));
    StyleSheet sheet = parser.parse( "/* \n"
        + " blah \n"
        + "*/ \n"
        + ".someClassName { \n" +
                  "   font-size: 24px;\n" +
                  "}", new ExpectedCssMutant(selector,
                      "font-size",
                      CssType.PX), CssI18nConstants.INSTANCE);
    int val = sheet.getInteger(selector, "font-size");
    assertEquals(24, val);
  }
}
