package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.PotentialCreators;
import com.fasterxml.jackson.databind.introspect.PotentialCreator;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class introspect_PotentialCreators_hasPropertiesBased__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasPropertiesBased_WhenPropertiesBasedIsNull_ReturnsFalse() {
        PotentialCreators potentialCreators = new PotentialCreators();
        potentialCreators.propertiesBased = null; // setting propertiesBased to null
        
        try {
            boolean result = potentialCreators.hasPropertiesBased();
            assertFalse(result); // expecting it to return false
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}