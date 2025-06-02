package org.apache.commons.compress.harmony.pack200;

import org.objectweb.asm.Label;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition;
import org.apache.commons.compress.harmony.pack200.IcBands.IcTuple;
import org.objectweb.asm.Opcodes;

public class ClassBands_renumberOffsetBci_35_0_Test {

    private ClassBands classBands;

    @BeforeEach
    public void setUp() throws Exception {
        Segment segment = new Segment();
        classBands = new ClassBands(segment, 1, 0, false);
    }

    private void invokeRenumberOffsetBci(List<Integer> relative, List<Integer> list, IntList bciRenumbering, Map<Label, Integer> labelsToOffsets) throws Exception {
        Method method = ClassBands.class.getDeclaredMethod("renumberOffsetBci", List.class, List.class, IntList.class, Map.class);
        // Allow access to the private method
        method.setAccessible(true);
        method.invoke(classBands, relative, list, bciRenumbering, labelsToOffsets);
    }

    @Test
    public void testRenumberOffsetBciWithEmptyLists() throws Exception {
        List<Integer> relative = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        IntList bciRenumbering = new IntList();
        Map<Label, Integer> labelsToOffsets = new HashMap<>();
        invokeRenumberOffsetBci(relative, list, bciRenumbering, labelsToOffsets);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRenumberOffsetBciWithSingleInteger() throws Exception {
        List<Integer> relative = new ArrayList<>();
        relative.add(5);
        List<Integer> list = new ArrayList<>();
        IntList bciRenumbering = new IntList();
        bciRenumbering.add(15);
        Map<Label, Integer> labelsToOffsets = new HashMap<>();
        invokeRenumberOffsetBci(relative, list, bciRenumbering, labelsToOffsets);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testRenumberOffsetBciWithLabel() throws Exception {
        List<Integer> relative = new ArrayList<>();
        relative.add(5);
        List<Integer> list = new ArrayList<>();
        Label label = new Label();
        IntList bciRenumbering = new IntList();
        bciRenumbering.add(15);
        Map<Label, Integer> labelsToOffsets = new HashMap<>();
        labelsToOffsets.put(label, 0);
        invokeRenumberOffsetBci(relative, list, bciRenumbering, labelsToOffsets);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }
}
