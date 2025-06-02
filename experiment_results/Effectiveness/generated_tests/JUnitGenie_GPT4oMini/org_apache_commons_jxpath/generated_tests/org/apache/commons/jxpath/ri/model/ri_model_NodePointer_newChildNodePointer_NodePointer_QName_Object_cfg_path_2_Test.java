package org.apache.commons.jxpath.ri.model;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.QName;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class ri_model_NodePointer_newChildNodePointer_NodePointer_QName_Object_cfg_path_2_Test {

    private static class TestNodePointer extends NodePointer {
        // Implementing abstract methods
        protected TestNodePointer(NodePointer parent) {
            super(parent);
        }

        @Override
        public Object getImmediateNode() {
            return null;
        }

        @Override
        public QName getName() {
            return null;
        }

        @Override
        public Object getBaseValue() {
            return null;
        }

        @Override
        public void setValue(Object value) {
        }

        @Override
        public boolean isLeaf() {
            return false;
        }

        @Override
        public boolean isCollection() {
            return false;
        }

        @Override
        public int compareChildNodePointers(NodePointer nodePointer1, NodePointer nodePointer2) {
            return 0;
        }

        @Override
        public int getLength() {
            return 0;
        }
    }




}
