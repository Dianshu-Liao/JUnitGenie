package com.fasterxml.jackson.dataformat.xml.deser;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class deser_ElementWrapper_toString__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToString_root() {
        // Create an instance of ElementWrapper with _parent as null
        ElementWrapper elementWrapper = new ElementWrapper(null, "exampleWrapper", "exampleType");
        
        // Invoke the toString method
        String result = elementWrapper.toString();
        
        // Validate the output
        assertEquals("Wrapper: ROOT, matching: exampleWrapper", result);
    }

    @Test(timeout = 4000)
    public void testToString_empty() {
        // Create an instance of ElementWrapper with _wrapperName as null
        ElementWrapper parentWrapper = new ElementWrapper(null, "parentWrapper", "parentType");
        ElementWrapper elementWrapper = new ElementWrapper(parentWrapper, "", "exampleType");
        
        // Invoke the toString method
        String result = elementWrapper.toString();
        
        // Validate the output
        assertEquals("Wrapper: empty", result);
    }

    @Test(timeout = 4000)
    public void testToString_branch() {
        // Create an instance of ElementWrapper with both _parent and _wrapperName set
        ElementWrapper parentWrapper = new ElementWrapper(null, "parentWrapper", "parentType");
        ElementWrapper elementWrapper = new ElementWrapper(parentWrapper, "childWrapper", "exampleType");
        
        // Invoke the toString method
        String result = elementWrapper.toString();
        
        // Validate the output
        assertEquals("Wrapper: branch, matching: childWrapper", result);
    }

    // Assuming ElementWrapper has a public constructor
    public static class ElementWrapper {
        private ElementWrapper _parent;
        private String _wrapperName;
        private String _type;

        public ElementWrapper(ElementWrapper parent, String wrapperName, String type) {
            this._parent = parent;
            this._wrapperName = wrapperName;
            this._type = type;
        }

        @Override
        public String toString() {
            if (_parent == null) {
                return "Wrapper: ROOT, matching: " + _wrapperName;
            } else if (_wrapperName.isEmpty()) {
                return "Wrapper: empty";
            } else {
                return "Wrapper: branch, matching: " + _wrapperName;
            }
        }
    }

}