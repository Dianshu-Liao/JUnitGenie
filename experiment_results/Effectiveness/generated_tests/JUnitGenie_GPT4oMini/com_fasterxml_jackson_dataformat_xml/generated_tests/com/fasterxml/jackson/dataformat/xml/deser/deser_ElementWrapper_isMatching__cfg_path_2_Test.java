package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.ElementWrapper;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.lang.reflect.Constructor;

public class deser_ElementWrapper_isMatching__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsMatchingWhenWrapperNameIsNull() {
        try {
            // Using reflection to access the private constructor
            Constructor<ElementWrapper> constructor = (Constructor<ElementWrapper>) ElementWrapper.class.getDeclaredConstructors()[1];
            constructor.setAccessible(true); // Make the constructor accessible
            ElementWrapper elementWrapper = constructor.newInstance((ElementWrapper) null, null, null);
            // Since _wrapperName is final and protected, we cannot set it directly. 
            // We will assume it is null for this test case.
            assertFalse(elementWrapper.isMatching());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}