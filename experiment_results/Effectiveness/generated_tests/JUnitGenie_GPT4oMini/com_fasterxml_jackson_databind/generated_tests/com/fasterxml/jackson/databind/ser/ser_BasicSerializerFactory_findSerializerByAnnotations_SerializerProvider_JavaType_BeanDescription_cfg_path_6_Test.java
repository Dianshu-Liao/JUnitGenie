package com.fasterxml.jackson.databind.ser;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.BasicSerializerFactory;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.Annotated;
import org.junit.Test;
import org.junit.Before;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

public class ser_BasicSerializerFactory_findSerializerByAnnotations_SerializerProvider_JavaType_BeanDescription_cfg_path_6_Test {

    private BasicSerializerFactory factory;
    private SerializerProvider prov;
    private JavaType type;
    private BeanDescription beanDesc;



}
