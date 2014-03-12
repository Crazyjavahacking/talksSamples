package javax.json.tck;

import java.io.StringReader;
import java.math.BigDecimal;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.*;

/**
 * @author Martin Skurla  crazyjavahacking@gmail.com
 */
public class EqualitySemanticsTest {
   
    @Test(enabled = false) // as this test was designed to fail
    public void jsonObjectEqualsMethod_shouldHandleFloatingNumbersCorrectly() {
        JsonReader jsonReader = new JsonReader(new StringReader("{ \"number\": 10.0 }"));
        JsonObject readJsonObject = jsonReader.readObject();
        
        JsonObject builtJsonObject = new JsonObjectBuilder().add("number", BigDecimal.TEN).build();
        
        assertThat(readJsonObject).isEqualTo(builtJsonObject);
    }
    
    @Test(enabled = false) // this would fail as well (but not dealing with BigDecimals directly)
    public void jsonObjectEqualsMethod_shouldHandleFloatingPointsCorrectly_2() {
        JsonReader jsonReader1 = new JsonReader(new StringReader("{ \"number\": 10.0 }"));
        JsonObject readJsonObject1 = jsonReader1.readObject();
        
        JsonReader jsonReader2 = new JsonReader(new StringReader("{ \"number\": 10.00 }"));
        JsonObject readJsonObject2 = jsonReader2.readObject();

        assertThat(readJsonObject1).isEqualTo(readJsonObject2);
    }
}
