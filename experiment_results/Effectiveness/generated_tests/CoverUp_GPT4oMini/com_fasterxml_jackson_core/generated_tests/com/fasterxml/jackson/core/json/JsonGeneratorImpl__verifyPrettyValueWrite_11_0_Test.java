package com.fasterxml.jackson.core.json;

import java.io.IOException;
import java.lang.reflect.Field;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonGeneratorImpl;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class JsonGeneratorImpl__verifyPrettyValueWrite_11_0_Test {

    private JsonGeneratorImpl jsonGenerator;

    @Mock
    private IOContext ioContext;

    @Mock
    private JsonWriteContext writeContext;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        jsonGenerator = mock(JsonGeneratorImpl.class, withSettings().useConstructor(ioContext, 0, null).defaultAnswer(CALLS_REAL_METHODS));
        // Use reflection to set the protected fields
        Field writeContextField = GeneratorBase.class.getDeclaredField("_writeContext");
        writeContextField.setAccessible(true);
        writeContextField.set(jsonGenerator, writeContext);
        Field cfgPrettyPrinterField = JsonGeneratorImpl.class.getDeclaredField("_cfgPrettyPrinter");
        cfgPrettyPrinterField.setAccessible(true);
        cfgPrettyPrinterField.set(jsonGenerator, mock(PrettyPrinter.class));
    }

    @Test
    public void testVerifyPrettyValueWrite_StatusOkAfterComma() throws IOException, Exception {
        jsonGenerator._verifyPrettyValueWrite("test", JsonWriteContext.STATUS_OK_AFTER_COMMA);
        verify((PrettyPrinter) getField(jsonGenerator, "_cfgPrettyPrinter")).writeArrayValueSeparator(jsonGenerator);
    }

    @Test
    public void testVerifyPrettyValueWrite_StatusOkAfterColon() throws IOException, Exception {
        jsonGenerator._verifyPrettyValueWrite("test", JsonWriteContext.STATUS_OK_AFTER_COLON);
        verify((PrettyPrinter) getField(jsonGenerator, "_cfgPrettyPrinter")).writeObjectFieldValueSeparator(jsonGenerator);
    }

    @Test
    public void testVerifyPrettyValueWrite_StatusOkAfterSpace() throws IOException, Exception {
        jsonGenerator._verifyPrettyValueWrite("test", JsonWriteContext.STATUS_OK_AFTER_SPACE);
        verify((PrettyPrinter) getField(jsonGenerator, "_cfgPrettyPrinter")).writeRootValueSeparator(jsonGenerator);
    }

    @Test
    public void testVerifyPrettyValueWrite_StatusOkAsIs_InArray() throws IOException, Exception {
        when(writeContext.inArray()).thenReturn(true);
        jsonGenerator._verifyPrettyValueWrite("test", JsonWriteContext.STATUS_OK_AS_IS);
        verify((PrettyPrinter) getField(jsonGenerator, "_cfgPrettyPrinter")).beforeArrayValues(jsonGenerator);
    }

    @Test
    public void testVerifyPrettyValueWrite_StatusOkAsIs_InObject() throws IOException, Exception {
        when(writeContext.inArray()).thenReturn(false);
        when(writeContext.inObject()).thenReturn(true);
        jsonGenerator._verifyPrettyValueWrite("test", JsonWriteContext.STATUS_OK_AS_IS);
        verify((PrettyPrinter) getField(jsonGenerator, "_cfgPrettyPrinter")).beforeObjectEntries(jsonGenerator);
    }

    @Test
    public void testVerifyPrettyValueWrite_StatusExpectName() {
        assertThrows(IOException.class, () -> {
            jsonGenerator._verifyPrettyValueWrite("test", JsonWriteContext.STATUS_EXPECT_NAME);
        });
    }

    @Test
    public void testVerifyPrettyValueWrite_InvalidStatus() {
        assertThrows(IllegalStateException.class, () -> {
            jsonGenerator._verifyPrettyValueWrite("test", -1);
        });
    }

    private Object getField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
