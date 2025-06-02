package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ReverseComparator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ri_JXPathContextReferenceImpl_removeAll_String_Expression_cfg_path_38_Test {

    private class TestExpression extends Expression {
        private final ArrayList<Object> pointers;

        public TestExpression(ArrayList<Object> pointers) {
            this.pointers = pointers;
        }

        @Override
        public Object computeValue(EvalContext context) {
            return pointers.iterator();
        }

        @Override
        public boolean computeContextDependent() {
            return false;
        }

        @Override
        public Object compute(EvalContext context) {
            return pointers;
        }
    }



}
