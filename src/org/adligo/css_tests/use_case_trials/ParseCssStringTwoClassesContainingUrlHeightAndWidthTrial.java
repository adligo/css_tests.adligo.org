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
public class ParseCssStringTwoClassesContainingUrlHeightAndWidthTrial extends MockitoApiTrial {
  StyleSheetParser parser = new StyleSheetParser();
  
  @SuppressWarnings("boxing")
  @Test
  @UseCaseScope (name="Parse CSS String inside of virtual machine (JVM or JavaScript engine) with a url, height and width in a two classes.")
  public void testParseCssString() {
    Selector selector = new Selector(new SequenceOfSimpleSelectors("menuTitleImage"));
    Selector selector4Ad = new Selector(new SequenceOfSimpleSelectors("menuLeaderboardAd"));
    StyleSheet sheet = parser.parse( ".menuTitleImage { \n" +
                  "   height: 90px;\n" +
                  "   width: 500px;\n" +
                  "   url: images/beeTitle.png;\n" +
                  "} \n" +
                  "\n" +
                  ".menuLeaderboardAd { \n" +
                  "   height: 91px;\n" +
                  "   width: 728px;\n" +
                  "   url: ads/bidvertiser.com/leaderboard.html;\n" +
                  "} \n", null, CssI18nConstants.INSTANCE);
    String val = sheet.getValue(selector, "height");
    assertEquals("90px", val);
    String width = sheet.getValue(selector, "width");
    assertEquals("500px", width);
    String url = sheet.getValue(selector, "url");
    assertEquals("images/beeTitle.png", url);
    
    val = sheet.getValue(selector4Ad, "height");
    assertEquals("91px", val);
    width = sheet.getValue(selector4Ad, "width");
    assertEquals("728px", width);
    url = sheet.getValue(selector4Ad, "url");
    assertEquals("ads/bidvertiser.com/leaderboard.html", url);
  }
}
