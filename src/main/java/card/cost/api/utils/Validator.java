package card.cost.api.utils;

import java.math.BigInteger;

/**
 * Request Validation method collection
 */
public class Validator {


    /**
     * Validates the PAN length
     * @param pan
     * @return Boolean.TRUE/Boolean.FALSE
     */
    public static Boolean hasPanValidLength(BigInteger pan)  {

        if (pan != null) {
            int panLength = pan.toString().length();
            return 8<=panLength  && panLength<=19;
        }
        return Boolean.FALSE;
    }
}
