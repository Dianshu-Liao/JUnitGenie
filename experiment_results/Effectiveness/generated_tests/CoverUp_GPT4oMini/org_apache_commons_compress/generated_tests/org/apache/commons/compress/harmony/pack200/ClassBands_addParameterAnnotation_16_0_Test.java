package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.ClassBands;
import org.apache.commons.compress.harmony.pack200.Segment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition;
import org.apache.commons.compress.harmony.pack200.IcBands.IcTuple;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

@ExtendWith(MockitoExtension.class)
class ClassBands_addParameterAnnotation_16_0_Test {

    private ClassBands classBands;

    private Segment segment;

    @BeforeEach
    void setUp() throws IOException {
        segment = new Segment();
        classBands = new ClassBands(segment, 1, 0, false);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    @Test
    void testAddParameterAnnotationVisible() throws Exception {
        // Prepare test data
        int parameter = 0;
        String desc = "Lcom/example/MyAnnotation;";
        boolean visible = true;
        List<String> nameRU = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        List<Integer> caseArrayN = new ArrayList<>();
        List<String> nestTypeRS = new ArrayList<>();
        List<String> nestNameRU = new ArrayList<>();
        List<Integer> nestPairN = new ArrayList<>();
        // Add a flag to tempMethodFlags to simulate previous state
        setPrivateField(classBands, "tempMethodFlags", new ArrayList<Long>() {

            {
                add(0L);
            }
        });
        // Invoke the method using reflection
        Method method = ClassBands.class.getDeclaredMethod("addParameterAnnotation", int.class, String.class, boolean.class, List.class, List.class, List.class, List.class, List.class, List.class, List.class);
        method.setAccessible(true);
        method.invoke(classBands, parameter, desc, visible, nameRU, tags, values, caseArrayN, nestTypeRS, nestNameRU, nestPairN);
        // Verify the expected state after invocation
        assertNotNull(getPrivateField(classBands, "tempMethodRVPA"));
        assertEquals(1, ((List<Long>) getPrivateField(classBands, "tempMethodFlags")).size());
        assertEquals(1L << 23, ((List<Long>) getPrivateField(classBands, "tempMethodFlags")).get(0));
    }

    @Test
    void testAddParameterAnnotationInvisible() throws Exception {
        // Prepare test data
        int parameter = 1;
        String desc = "Lcom/example/MyAnnotation;";
        boolean visible = false;
        List<String> nameRU = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        List<Integer> caseArrayN = new ArrayList<>();
        List<String> nestTypeRS = new ArrayList<>();
        List<String> nestNameRU = new ArrayList<>();
        List<Integer> nestPairN = new ArrayList<>();
        // Add a flag to tempMethodFlags to simulate previous state
        setPrivateField(classBands, "tempMethodFlags", new ArrayList<Long>() {

            {
                add(0L);
            }
        });
        // Invoke the method using reflection
        Method method = ClassBands.class.getDeclaredMethod("addParameterAnnotation", int.class, String.class, boolean.class, List.class, List.class, List.class, List.class, List.class, List.class, List.class);
        method.setAccessible(true);
        method.invoke(classBands, parameter, desc, visible, nameRU, tags, values, caseArrayN, nestTypeRS, nestNameRU, nestPairN);
        // Verify the expected state after invocation
        assertNotNull(getPrivateField(classBands, "tempMethodRIPA"));
        assertEquals(1, ((List<Long>) getPrivateField(classBands, "tempMethodFlags")).size());
        assertEquals(1L << 24, ((List<Long>) getPrivateField(classBands, "tempMethodFlags")).get(0));
    }
}
