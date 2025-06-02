package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.IOException;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class sym_CharsToNameCanonicalizer__addSymbol_char_____int_int_int_int_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testAddSymbolWithHashShared() {
        try {
            // Create an instance of CharsToNameCanonicalizer using reflection
            Class<?> clazz = CharsToNameCanonicalizer.class;
            Method initMethod = clazz.getDeclaredMethod("<init>", StreamReadConstraints.class, int.class, int.class);
            initMethod.setAccessible(true);
            CharsToNameCanonicalizer instance = (CharsToNameCanonicalizer) initMethod.invoke(null, null, 0, 0);

            // Prepare test parameters
            char[] buffer = {'a', 'b', 'c'};
            int start = 0;
            int len = 3;
            int h = 0;
            int index = 0;

            // Set _hashShared to true directly via reflection
            java.lang.reflect.Field _hashSharedField = clazz.getDeclaredField("_hashShared");
            _hashSharedField.setAccessible(true);
            _hashSharedField.set(instance, true);

            // Invoke the _addSymbol method
            Method addSymbolMethod = clazz.getDeclaredMethod("_addSymbol", char[].class, int.class, int.class, int.class, int.class);
            addSymbolMethod.setAccessible(true);
            String result = (String) addSymbolMethod.invoke(instance, buffer, start, len, h, index);

            // Assert that the symbol was added correctly
            assertEquals("abc", result);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception during test execution: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAddSymbolWithRehash() {
        try {
            // Create an instance of CharsToNameCanonicalizer
            Class<?> clazz = CharsToNameCanonicalizer.class;
            Method initMethod = clazz.getDeclaredMethod("<init>", StreamReadConstraints.class, int.class, int.class);
            initMethod.setAccessible(true);
            CharsToNameCanonicalizer instance = (CharsToNameCanonicalizer) initMethod.invoke(null, null, 0, 0);

            // Prepare test parameters
            char[] buffer = {'d', 'e', 'f'};
            int start = 0;
            int len = 3;
            int h = 0;
            int index = 0;

            // Set _sizeThreshold to trigger rehashing
            java.lang.reflect.Field _sizeThresholdField = clazz.getDeclaredField("_sizeThreshold");
            _sizeThresholdField.setAccessible(true);
            _sizeThresholdField.set(instance, 0);

            // Set _size to reach threshold
            java.lang.reflect.Field _sizeField = clazz.getDeclaredField("_size");
            _sizeField.setAccessible(true);
            _sizeField.set(instance, 1);

            // Invoke the _addSymbol method
            Method addSymbolMethod = clazz.getDeclaredMethod("_addSymbol", char[].class, int.class, int.class, int.class, int.class);
            addSymbolMethod.setAccessible(true);
            String result = (String) addSymbolMethod.invoke(instance, buffer, start, len, h, index);

            // Assert that the new symbol was added
            assertEquals("def", result);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception during test execution: " + e.getMessage());
        }
    }


}