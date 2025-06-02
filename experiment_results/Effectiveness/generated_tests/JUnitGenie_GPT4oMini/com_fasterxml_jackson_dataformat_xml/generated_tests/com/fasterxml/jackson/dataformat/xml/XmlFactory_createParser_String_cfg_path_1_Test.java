package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;

public class XmlFactory_createParser_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        XmlFactory xmlFactory = new XmlFactory();
        String content = "<example><test>value</test></example>";
        
        try {
            JsonParser parser = xmlFactory.createParser(content);
            // Using Assert.assertNotNull to verify the parser's functionality
            Assert.assertNotNull(parser);
        } catch (IOException e) {
            // Handle the exception for testing purposes
            e.printStackTrace();
        }
    }


}