package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import static org.junit.Assert.assertNotNull;

public class XmlFactory_createParser_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        XmlFactory xmlFactory = new XmlFactory();
        String content = "<root></root>"; // Sample XML content

        try {
            JsonParser parser = xmlFactory.createParser(content);
            assertNotNull("Parser should not be null", parser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}