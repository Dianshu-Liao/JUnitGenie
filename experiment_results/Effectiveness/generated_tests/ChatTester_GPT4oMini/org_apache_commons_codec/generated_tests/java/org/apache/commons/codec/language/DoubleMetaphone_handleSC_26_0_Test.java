package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class DoubleMetaphone_handleSC_26_0_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphoneResult result;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = new DoubleMetaphoneResult();
    }


    private void invokeHandleSC(String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleSC", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        method.invoke(doubleMetaphone, value, result, index);
    }
}
