package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.PotentialCreators;
import com.fasterxml.jackson.databind.introspect.PotentialCreator;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class introspect_PotentialCreators_hasPropertiesBased__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasPropertiesBasedWhenPropertiesBasedIsNull() {
        PotentialCreators potentialCreators = new PotentialCreators();
        potentialCreators.propertiesBased = null; // Set propertiesBased to null

        try {
            boolean result = potentialCreators.hasPropertiesBased();
            assertFalse(result); // Expecting false since propertiesBased is null
        } catch (Exception e) {
            // Handle exception if any occurs
            e.printStackTrace();
        }
    }



}
