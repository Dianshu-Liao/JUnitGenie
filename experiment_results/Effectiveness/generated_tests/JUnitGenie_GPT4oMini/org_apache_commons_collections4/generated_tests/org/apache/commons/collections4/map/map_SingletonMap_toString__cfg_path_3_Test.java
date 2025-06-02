package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.SingletonMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_SingletonMap_toString__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToStringWithDifferentKeyAndValue() {
        // Arrange
        SingletonMap<String, String> singletonMap = new SingletonMap<>("key", "value");

        // Act
        String result = singletonMap.toString();

        // Assert
        assertEquals("{key=value}", result);
    }

    @Test(timeout = 4000)
    public void testToStringWithKeyAsThis() {
        // Arrange
        SingletonMap<SingletonMap<String, String>, String> singletonMap = new SingletonMap<>(new SingletonMap<>("key", "value"), "value");

        // Act
        String result = singletonMap.toString();

        // Assert
        assertEquals("{(this Map)=value}", result);
    }

    @Test(timeout = 4000)
    public void testToStringWithValueAsThis() {
        // Arrange
        SingletonMap<String, SingletonMap<String, String>> singletonMap = new SingletonMap<>("key", new SingletonMap<>("key", "value"));

        // Act
        String result = singletonMap.toString();

        // Assert
        assertEquals("{key=(this Map)}", result);
    }

}