package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import java.lang.reflect.Method;
import java.io.IOException;
import static org.junit.Assert.assertFalse;

public class filter_FilteringGeneratorDelegate__checkBinaryWrite__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCheckBinaryWrite_ItemFilterIsNull() {
        try {
            // Arrange
            FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(
                null, // JsonGenerator is not needed for this test
                null, // TokenFilter is not needed for this test
                false,
                false
            );

            // Access the protected method using reflection
            Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkBinaryWrite");
            method.setAccessible(true);

            // Act
            boolean result = (boolean) method.invoke(delegate);

            // Assert
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}