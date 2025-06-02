package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.Test;
import java.math.BigDecimal;
import java.lang.reflect.Method;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class deser_FromXmlParser__convertNumberToBigDecimal__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testConvertNumberToBigDecimalWithValidInt() {
        try {
            // Arrange
            FromXmlParser parser = new FromXmlParser(null, 0, 0, null, null, null);
            // Set the protected fields using reflection
            setField(parser, "_numTypesValid", 1); // NR_INT
            setField(parser, "_numberInt", 42); // Example integer value

            // Act
            Method method = FromXmlParser.class.getDeclaredMethod("_convertNumberToBigDecimal");
            method.setAccessible(true);
            BigDecimal result = (BigDecimal) method.invoke(parser);

            // Assert
            assertEquals(BigDecimal.valueOf(42), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setField(Object obj, String fieldName, int value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(obj, value);
    }


}