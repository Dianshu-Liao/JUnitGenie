package com.fasterxml.jackson.core.base;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class base_GeneratorBase_close__cfg_path_2_Test {

    private GeneratorBase generatorBase;

    @Before
    public void setUp() throws Exception {
        // Using reflection to access the protected constructor
        Constructor<GeneratorBase> constructor = GeneratorBase.class.getDeclaredConstructor(int.class, Object.class, IOContext.class);
        constructor.setAccessible(true);
        // Create a mock IOContext for testing
        IOContext ioContext = new IOContext(null, null, false);
        generatorBase = constructor.newInstance(0, null, ioContext);
    }

    @Test(timeout = 4000)
    public void testClose() {
        try {
            // Ensure _closed is false before calling close
            assertFalse(getClosedField(generatorBase)); // Now assertFalse is recognized
            // Call the close method
            generatorBase.close();
            // Verify that _closed is now true
            assertTrue(getClosedField(generatorBase));
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    private boolean getClosedField(GeneratorBase generatorBase) throws NoSuchFieldException, IllegalAccessException {
        java.lang.reflect.Field closedField = GeneratorBase.class.getDeclaredField("_closed");
        closedField.setAccessible(true);
        return closedField.getBoolean(generatorBase);
    }


}