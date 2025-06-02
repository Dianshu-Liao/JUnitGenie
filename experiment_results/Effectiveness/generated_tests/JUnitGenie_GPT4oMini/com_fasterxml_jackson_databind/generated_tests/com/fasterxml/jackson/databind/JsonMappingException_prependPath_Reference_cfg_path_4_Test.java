package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonMappingException_prependPath_Reference_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPrependPath() {
        // Arrange
        JsonMappingException exception = new JsonMappingException("Test Exception");
        Reference reference = new Reference("Test Reference");
        
        // Act
        exception.prependPath(reference);
        
        // Assert
        assertEquals(1, exception._path.size());
        assertEquals(reference, exception._path.getFirst());
    }

    @Test(timeout = 4000)
    public void testPrependPathWhenPathIsNull() {
        // Arrange
        JsonMappingException exception = new JsonMappingException("Test Exception");
        Reference reference = new Reference("Test Reference");
        
        // Act
        exception.prependPath(reference);
        
        // Assert
        assertEquals(1, exception._path.size());
        assertEquals(reference, exception._path.getFirst());
    }

    @Test(timeout = 4000)
    public void testPrependPathWhenPathIsFull() {
        // Arrange
        JsonMappingException exception = new JsonMappingException("Test Exception");
        for (int i = 0; i < 1000; i++) {
            exception.prependPath(new Reference("Reference " + i));
        }
        Reference newReference = new Reference("New Reference");
        
        // Act
        exception.prependPath(newReference);
        
        // Assert
        assertEquals(1000, exception._path.size());
        assertEquals(newReference, exception._path.getFirst());
    }

}