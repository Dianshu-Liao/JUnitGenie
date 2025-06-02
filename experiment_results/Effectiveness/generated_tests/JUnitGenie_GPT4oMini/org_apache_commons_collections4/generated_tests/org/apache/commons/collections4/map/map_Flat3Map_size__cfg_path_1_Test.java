package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_Flat3Map_size__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSizeWhenDelegateMapIsNull() {
        Flat3Map<String, String> flat3Map = new Flat3Map<>();
        // Here, delegateMap is null, so size should return the value of the private size variable, which is initialized to 0.
        int result = flat3Map.size();
        assertEquals(0, result);
    }



}
