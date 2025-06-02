package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Text;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.NodeList;
import org.junit.Before;
import org.junit.Test;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_7_Test {

    private DOMNodePointer domNodePointer;
    private Document document;

    @Before
    public void setUp() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        domNodePointer = new DOMNodePointer(document, Locale.getDefault());
    }

    @Test(timeout = 4000)
    public void testStringValueWithTextNode() throws Exception {
        Text textNode = document.createTextNode("   Sample Text   ");
        document.getDocumentElement().appendChild(textNode);
        
        String result = invokeStringValue(textNode);

        assertEquals("Sample Text", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithCDataSection() throws Exception {
        CDATASection cdataSection = document.createCDATASection("   Some CDATA   ");
        document.getDocumentElement().appendChild(cdataSection);

        String result = invokeStringValue(cdataSection);

        assertEquals("Some CDATA", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() throws Exception {
        Node commentNode = document.createComment(" This is a comment ");
        document.getDocumentElement().appendChild(commentNode);

        String result = invokeStringValue(commentNode);

        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithProcessingInstruction() throws Exception {
        ProcessingInstruction pi = document.createProcessingInstruction("xml-stylesheet", "type='text/xsl' href='style.xsl'");
        document.getDocumentElement().appendChild(pi);

        String result = invokeStringValue(pi);

        assertEquals("type='text/xsl' href='style.xsl'", result);
    }

    private String invokeStringValue(Node node) throws Exception {
        Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
        method.setAccessible(true);
        return (String) method.invoke(domNodePointer, node);
    }

}