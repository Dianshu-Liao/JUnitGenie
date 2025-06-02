package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Separators;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class util_DefaultPrettyPrinter__withSpaces_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void test_withSpaces_true() {
        try {
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
            Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
            method.setAccessible(true);
            DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, true);
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void test_withSpaces_false() {
        try {
            DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
            Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
            method.setAccessible(true);
            DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, false);
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}