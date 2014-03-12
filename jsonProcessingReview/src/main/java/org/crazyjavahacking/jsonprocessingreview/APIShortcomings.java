package org.crazyjavahacking.jsonprocessingreview;

import java.io.StringReader;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonValue;

/**
 * @author Martin Skurla  crazyjavahacking@gmail.com
 */
public class APIShortcomings {
    
    public void inconsistentMethodNaming() {
        JsonArray jsonArray = null;
        String someItemText = jsonArray.getValue(0, JsonString.class).getValue();
        someItemText = jsonArray.getStringValue(0); // semanticall same as the previous call
        
        JsonObject jsonObject = null;
        String somePropertyText = jsonObject.getValue("property", JsonString.class).getValue();
        somePropertyText = jsonObject.getStringValue("property"); // semanticall same as the previous call
    }
    
    public void jsonValueNullVsNullLiteralMismatch() {
        JsonObject jsonObject = new JsonReader(
                                new StringReader("{ \"optVal\" : null }")).readObject();
        
        //jsonObject.getStringValue("optVal");  // throws ClassCastException
        //jsonObject.getStringValue("optVal2"); // throws NullPointerException

        jsonObject.getValue("optVal",  JsonValue.class); // returns JsonValue.NULL
        jsonObject.getValue("optVal2", JsonValue.class); // returns null
        
        jsonObject.get("optVal");  // returns JsonValue.NULL
        jsonObject.get("optVal2"); // returns null
    }
    
    public void misleadingToStringForJsonValueNULL() {
        JsonObject jsonObjectWithNull = new JsonReader(new StringReader("{ \"val\": null }")).readObject();
        
        System.out.println(jsonObjectWithNull); // prints: {"val":null}
        
        if (jsonObjectWithNull.get("val") != null) { // true
            System.out.println("jsonObjectWithNull.get(\"val\") != null");
        }
        if (jsonObjectWithNull.get("val") == JsonValue.NULL) { // true
            System.out.println("jsonObjectWithNull.get(\"val\") == JsonValue.NULL");
        }
    }
    
    public void misleadingToStringForJsonValueTrueAndFalse() {
        JsonObject jsonObjectWithBoolean = new JsonReader(new StringReader("{ \"bool\": true }")).readObject();
        
        System.out.println(jsonObjectWithBoolean); // prints: {"bool":true}
        
        // surprisingly compilation error: "incomparable types: JsonValue and boolean"
//        if (jsonObjectWithBoolean.get("bool") == true) {
//        }
        
        if (jsonObjectWithBoolean.get("bool") == JsonValue.TRUE) { // true
            System.out.println("jsonObjectWithBoolean.get(\"bool\") == JsonValue.TRUE");
        }
    }
}
