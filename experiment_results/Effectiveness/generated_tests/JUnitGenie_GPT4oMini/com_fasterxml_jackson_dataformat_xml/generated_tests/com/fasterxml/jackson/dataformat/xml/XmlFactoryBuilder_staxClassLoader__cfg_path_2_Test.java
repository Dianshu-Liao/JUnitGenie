package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactoryBuilder;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class XmlFactoryBuilder_staxClassLoader__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testStaxClassLoaderWhenClassLoaderIsNull() {
        try {
            XmlFactoryBuilder builder = new XmlFactoryBuilder();
            Method method = XmlFactoryBuilder.class.getDeclaredMethod("staxClassLoader");
            method.setAccessible(true);
            ClassLoader classLoader = (ClassLoader) method.invoke(builder);
            assertNotNull("ClassLoader should not be null when _classLoaderForStax is null", classLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStaxClassLoaderWhenClassLoaderIsNotNull() {
        try {
            XmlFactoryBuilder builder = new XmlFactoryBuilder();
            // Using reflection to set the protected field _classLoaderForStax
            ClassLoader mockClassLoader = new ClassLoader() {};
            java.lang.reflect.Field field = XmlFactoryBuilder.class.getDeclaredField("_classLoaderForStax");
            field.setAccessible(true);
            field.set(builder, mockClassLoader);

            Method method = XmlFactoryBuilder.class.getDeclaredMethod("staxClassLoader");
            method.setAccessible(true);
            ClassLoader classLoader = (ClassLoader) method.invoke(builder);
            assertNotNull("ClassLoader should not be null when _classLoaderForStax is set", classLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}