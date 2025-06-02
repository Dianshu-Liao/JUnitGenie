package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.LinkedList;

public class JsonMappingException_prependPath_Reference_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPrependPathWhenPathIsNull() {
        JsonMappingException exception = new JsonMappingException("Test Exception");
        Reference reference = new Reference(null, null); // Assuming a constructor that takes null values is valid

        // Call the method under test
        exception.prependPath(reference);

        // Verify that _path is initialized and contains the reference
        assertEquals(1, exception._path.size());
        assertEquals(reference, exception._path.getFirst());
    }

    @Test(timeout = 4000)
    public void testPrependPathWhenPathIsNotNullAndSizeIsLessThanMax() {
        JsonMappingException exception = new JsonMappingException("Test Exception");
        Reference reference1 = new Reference(null, null);
        Reference reference2 = new Reference(null, null);

        // Initialize _path
        exception._path = new LinkedList<>();
        exception._path.add(reference1);

        // Call the method under test
        exception.prependPath(reference2);

        // Verify that _path contains both references
        assertEquals(2, exception._path.size());
        assertEquals(reference2, exception._path.getFirst());
    }

    @Test(timeout = 4000)
    public void testPrependPathWhenPathSizeIsAtMax() {
        JsonMappingException exception = new JsonMappingException("Test Exception");
        Reference reference1 = new Reference(null, null);
        Reference reference2 = new Reference(null, null);
        Reference reference3 = new Reference(null, null);

        // Initialize _path to max size
        exception._path = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            exception._path.add(new Reference(null, null));
        }

        // Call the method under test
        exception.prependPath(reference1);

        // Verify that _path size remains at max and does not add the new reference
        assertEquals(1000, exception._path.size());
    }


}