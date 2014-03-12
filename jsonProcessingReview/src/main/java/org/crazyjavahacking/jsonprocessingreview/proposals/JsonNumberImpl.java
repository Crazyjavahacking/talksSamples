package org.crazyjavahacking.jsonprocessingreview.proposals;

import java.math.BigDecimal;
import javax.json.JsonNumber;

/**
 * @author Martin Skurla  crazyjavahacking@gmail.com
 */
/*final*/ abstract class JsonNumberImpl implements JsonNumber {
    private /*final*/ BigDecimal bigDecimal;

//    ...

    @Override
    public int hashCode() {
        return bigDecimal.stripTrailingZeros().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        
        if (obj == this)
            return true;
        
        if (obj.getClass() != JsonNumberImpl.class)
            return false;

        JsonNumber other = (JsonNumber)obj;
        return bigDecimal.compareTo(other.getBigDecimalValue()) == 0;
    }
}
