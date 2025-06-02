package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.ElementWrapper;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.lang.reflect.Constructor;

public class deser_ElementWrapper_isMatching__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsMatchingWhenWrapperNameIsNull() {
        try {
            // Using reflection to access the private constructor
            Constructor<ElementWrapper> constructor = ElementWrapper.class.getDeclaredConstructor(ElementWrapper.class, String.class, String.class);
            constructor.setAccessible(true); // Allow access to the private constructor
            
            ElementWrapper elementWrapper = constructor.newInstance((ElementWrapper) null, null, null);
            
            // Now we call the method under test
            boolean result = elementWrapper.isMatching();
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}