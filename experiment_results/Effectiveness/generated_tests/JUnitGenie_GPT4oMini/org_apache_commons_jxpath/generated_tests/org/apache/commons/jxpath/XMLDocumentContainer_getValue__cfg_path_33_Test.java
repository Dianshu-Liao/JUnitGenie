package org.apache.commons.jxpath;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import static org.junit.Assert.assertNotNull;

public class XMLDocumentContainer_getValue__cfg_path_33_Test {

    private class MockSource extends StreamSource {
        private String systemId;
        private String publicId;

        public MockSource() {
            super();
        }

        @Override
        public void setSystemId(String systemId) {
            this.systemId = systemId;
            super.setSystemId(systemId);
        }

        @Override
        public String getSystemId() {
            return systemId;
        }

        @Override
        public void setPublicId(String publicId) {
            this.publicId = publicId;
            super.setPublicId(publicId);
        }

        @Override
        public String getPublicId() {
            return publicId;
        }
    }

    private class MockDelegate {
        public Object getValue() {
            return new Object();
        }
    }

    @Test(timeout = 4000)
    public void testGetValueWithSource() {
        Source mockSource = new MockSource();
        XMLDocumentContainer container = new XMLDocumentContainer(mockSource);
        
        Object result = container.getValue();
        
        assertNotNull(result);
    }




}
