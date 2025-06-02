package org.apache.commons.jxpath;
import org.apache.commons.jxpath.XMLDocumentContainer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class XMLDocumentContainer_getValue__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetValueWhenDocumentIsNullAndSourceIsNotNull() {
        // Arrange
        javax.xml.transform.Source source = new javax.xml.transform.stream.StreamSource(getClass().getResourceAsStream("/test.xml"));
        XMLDocumentContainer container = new XMLDocumentContainer(source);
        
        // Act
        Object result = container.getValue();
        
        // Assert
        assertNotNull("The document should not be null after calling getValue()", result);
    }

    @Test(timeout = 4000)
    public void testGetValueWhenDocumentIsNullAndSourceIsNull() {
        // Arrange
        XMLDocumentContainer container = new XMLDocumentContainer((javax.xml.transform.Source) null);
        
        // Act
        Object result = container.getValue();
        
        // Assert
        assertNotNull("The document should not be null after calling getValue() when source is null", result);
    }


}