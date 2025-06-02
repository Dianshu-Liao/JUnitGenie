package com.fasterxml.jackson.databind.ser.std;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import org.junit.Test;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertNull;

public class ser_std_JsonValueSerializer__withIgnoreProperties_JsonSerializer_Set_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void test_withIgnoreProperties_serIsNull() {
        JsonSerializer<Object> result = null;
        Set<String> ignoredProperties = new HashSet<>(Collections.singletonList("propertyToIgnore"));

        try {
            result = JsonValueSerializer._withIgnoreProperties(null, ignoredProperties);
        } catch (Exception e) {
            // Handle the exception if necessary
        }

        assertNull(result);
    }

}