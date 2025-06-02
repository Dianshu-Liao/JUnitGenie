package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlBeanDeserializerModifier;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Collections;
import static org.junit.Assert.assertNull;

public class deser_XmlBeanDeserializerModifier__findSoleTextProp_DeserializationConfig_Iterator_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testFindSoleTextProp() {
        try {
            // Create an instance of XmlBeanDeserializerModifier with a String argument
            XmlBeanDeserializerModifier modifier = new XmlBeanDeserializerModifier("test");

            // Create a mock DeserializationConfig using ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            DeserializationConfig config = mapper.getDeserializationConfig();

            // Create an empty iterator for SettableBeanProperty
            Iterator<SettableBeanProperty> propIt = Collections.emptyIterator();

            // Access the private method _findSoleTextProp using reflection
            Method method = XmlBeanDeserializerModifier.class.getDeclaredMethod("_findSoleTextProp", DeserializationConfig.class, Iterator.class);
            method.setAccessible(true);

            // Invoke the method
            SettableBeanProperty result = (SettableBeanProperty) method.invoke(modifier, config, propIt);

            // Assert that the result is null as expected
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}