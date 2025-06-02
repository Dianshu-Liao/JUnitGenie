package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.math.BigInteger;
import static org.junit.Assert.assertEquals;

public class deser_FromXmlParser__convertNumberToDouble__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConvertNumberToDouble() {
        try {
            // Create an instance of FromXmlParser using the constructor
            FromXmlParser parser = new FromXmlParser(null, 0, 0, null, null, null);
            
            // Set the protected fields using reflection
            Field numTypesValidField = FromXmlParser.class.getDeclaredField("_numTypesValid");
            numTypesValidField.setAccessible(true);
            numTypesValidField.setInt(parser, 4); // Set to NR_BIGINT
            
            Field numberBigIntField = FromXmlParser.class.getDeclaredField("_numberBigInt");
            numberBigIntField.setAccessible(true);
            numberBigIntField.set(parser, BigInteger.valueOf(123456789)); // Set a BigInteger value
            
            // Access the protected method using reflection
            Method method = FromXmlParser.class.getDeclaredMethod("_convertNumberToDouble");
            method.setAccessible(true);
            
            // Invoke the method and assert the expected result
            double result = (double) method.invoke(parser);
            assertEquals(123456789.0, result, 0.0001);
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }


}