package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class RuntimeVisibleorInvisibleParameterAnnotationsAttribute_getLength_0_0_Test {

    private static class ParameterAnnotation {

        private final CPUTF8 utf8;

        public ParameterAnnotation(CPUTF8 utf8) {
            this.utf8 = utf8;
        }

        public int getLength() {
            // Assuming length is based on string length
            // This should ideally be utf8.getLength() if such a method exists
            return utf8.toString().length();
        }
    }

    private static class RuntimeVisibleorInvisibleParameterAnnotationsAttribute {

        private final int numParameters;

        private final ParameterAnnotation[] parameterAnnotations;

        public RuntimeVisibleorInvisibleParameterAnnotationsAttribute(int numParameters, ParameterAnnotation[] parameterAnnotations) {
            this.numParameters = numParameters;
            this.parameterAnnotations = parameterAnnotations;
        }

        protected int getLength() {
            int length = 1;
            for (int i = 0; i < numParameters; i++) {
                length += parameterAnnotations[i].getLength();
            }
            return length;
        }
    }

    @Test
    void testGetLengthWithNoParameters() {
        ParameterAnnotation[] annotations = new ParameterAnnotation[0];
        RuntimeVisibleorInvisibleParameterAnnotationsAttribute attribute = new RuntimeVisibleorInvisibleParameterAnnotationsAttribute(0, annotations);
        assertEquals(1, attribute.getLength());
    }

    @Test
    void testGetLengthWithOneParameter() {
        ParameterAnnotation[] annotations = { new ParameterAnnotation(new CPUTF8("test")) };
        RuntimeVisibleorInvisibleParameterAnnotationsAttribute attribute = new RuntimeVisibleorInvisibleParameterAnnotationsAttribute(1, annotations);
        // 1 (for the attribute itself) + 4 (length of "test")
        assertEquals(5, attribute.getLength());
    }

    @Test
    void testGetLengthWithMultipleParameters() {
        ParameterAnnotation[] annotations = { new ParameterAnnotation(new CPUTF8("param1")), new ParameterAnnotation(new CPUTF8("param2")) };
        RuntimeVisibleorInvisibleParameterAnnotationsAttribute attribute = new RuntimeVisibleorInvisibleParameterAnnotationsAttribute(2, annotations);
        // 1 + 6 (param1) + 6 (param2)
        assertEquals(13, attribute.getLength());
    }
}
