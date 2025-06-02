package com.fasterxml.jackson.databind.deser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class deser_BeanDeserializerBase_handlePolymorphic_JsonParser_DeserializationContext_Object_TokenBuffer_cfg_path_2_Test {

    private BeanDeserializerBase beanDeserializer;
    private JsonParser jsonParser;
    private DeserializationContext deserializationContext;
    private Object bean;
    private TokenBuffer tokenBuffer;


    @Test(timeout = 4000)
    public void testHandlePolymorphic() {
        try {
            Object result = invokeHandlePolymorphic(beanDeserializer, jsonParser, deserializationContext, bean, tokenBuffer);
            assertNotNull(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object invokeHandlePolymorphic(BeanDeserializerBase beanDeserializer, JsonParser p, DeserializationContext ctxt, Object bean, TokenBuffer unknownTokens) throws IOException {
        try {
            Method method = BeanDeserializerBase.class.getDeclaredMethod("handlePolymorphic", JsonParser.class, DeserializationContext.class, Object.class, TokenBuffer.class);
            method.setAccessible(true);
            return method.invoke(beanDeserializer, p, ctxt, bean, unknownTokens);
        } catch (Exception e) {
            throw new IOException("Failed to invoke handlePolymorphic", e);
        }
    }


}
