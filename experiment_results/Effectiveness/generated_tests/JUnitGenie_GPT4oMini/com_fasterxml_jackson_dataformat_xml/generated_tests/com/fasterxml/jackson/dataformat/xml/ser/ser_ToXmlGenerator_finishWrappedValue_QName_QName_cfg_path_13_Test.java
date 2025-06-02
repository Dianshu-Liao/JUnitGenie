package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.namespace.QName;
import org.junit.Test;
import java.io.IOException;

public class ser_ToXmlGenerator_finishWrappedValue_QName_QName_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testFinishWrappedValueWithNullWrapperName() {
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, null, null);
        QName wrapperName = null;
        QName wrappedName = new QName("http://example.com", "wrapped");

        try {
            generator.finishWrappedValue(wrapperName, wrappedName);
        } catch (IOException e) {
            // Handle the exception as needed
            e.printStackTrace();
        }
    }

}