package org.crazyjavahacking.jsonprocessingreview.proposals;

import javax.json.JsonConfiguration;
import javax.json.JsonFeature;

/**
 * @author Martin Skurla  crazyjavahacking@gmail.com
 */
public class CoolJsonLibraryFeatures {
    
    public static JsonFeature prettyPrintingWithTabIndentation(String newline) { return null; }
    public static JsonFeature prettyPrintingWithSpacesIndentation(String newline, int numberOfSpaces) { return null; }
    
    public static void main(String[] args) {
        JsonFeature feature1 = CoolJsonLibraryFeatures.prettyPrintingWithTabIndentation("\n");
        JsonFeature feature2 = CoolJsonLibraryFeatures.prettyPrintingWithSpacesIndentation("\n", 4);
        
        new JsonConfiguration().with(feature1);
    }
}
