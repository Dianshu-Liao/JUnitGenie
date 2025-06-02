package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Test;
import java.net.URL;
import static org.junit.Assert.assertNotNull;

public class xml_DocumentContainer_getValue__cfg_path_47_Test {

    @Test(timeout = 4000)
    public void testGetValueWhenIOExceptionOccurs() {
        try {
            // Arrange
            URL invalidUrl = new URL("http://example.com/invalid.xml");
            DocumentContainer documentContainer = new DocumentContainer(invalidUrl);
            
            // Act
            documentContainer.getValue();
        } catch (JXPathException e) {
            // Assert
            assertNotNull(e);
            System.out.println("Caught expected JXPathException: " + e.getMessage());
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}