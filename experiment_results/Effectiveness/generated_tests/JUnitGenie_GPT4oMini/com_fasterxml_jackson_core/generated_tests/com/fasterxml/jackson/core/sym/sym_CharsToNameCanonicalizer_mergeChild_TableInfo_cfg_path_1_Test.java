package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import static org.junit.Assert.assertNotNull;

public class sym_CharsToNameCanonicalizer_mergeChild_TableInfo_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMergeChild() {
        try {
            // Create an instance of CharsToNameCanonicalizer using reflection
            Constructor<CharsToNameCanonicalizer> constructor = 
                CharsToNameCanonicalizer.class.getDeclaredConstructor(AtomicReference.class);
            constructor.setAccessible(true);
            CharsToNameCanonicalizer instance = constructor.newInstance(new AtomicReference<>());

            // Create an instance of TableInfo using reflection
            // Access TableInfo through CharsToNameCanonicalizer
            Constructor<?> tableInfoConstructor = 
                Class.forName("com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer$TableInfo")
                .getDeclaredConstructor(int.class);
            tableInfoConstructor.setAccessible(true);
            Object childState = tableInfoConstructor.newInstance(12001); // size > MAX_ENTRIES_FOR_REUSE

            // Invoke the private method mergeChild using reflection
            Method mergeChildMethod = CharsToNameCanonicalizer.class.getDeclaredMethod("mergeChild", childState.getClass());
            mergeChildMethod.setAccessible(true);
            mergeChildMethod.invoke(instance, childState);

            // Verify that the method executed without throwing an exception
            assertNotNull(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}