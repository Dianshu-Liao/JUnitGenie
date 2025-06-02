package org.apache.commons.compress.harmony.unpack200;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IcTuple_hashCode_8_0_Test {

    private IcTuple tuple1;

    private IcTuple tuple2;

    private IcTuple tuple3;

    @BeforeEach
    public void setUp() {
        tuple1 = new IcTuple("ClassA", 1, "ClassB", "NestedClass", 0, 0, 0, 0);
        tuple2 = new IcTuple("ClassA", 1, "ClassB", "NestedClass", 0, 0, 0, 0);
        tuple3 = new IcTuple("ClassC", 2, "ClassD", null, 1, 1, 1, 1);
    }

    @Test
    public void testHashCodeEqualityForSameObjects() {
        // Test that two identical tuples have the same hash code
        assertEquals(tuple1.hashCode(), tuple2.hashCode());
    }

    @Test
    public void testHashCodeDifferentObjects() {
        // Test that two different tuples have different hash codes
        assertEquals(false, tuple1.hashCode() == tuple3.hashCode());
    }

    @Test
    public void testHashCodeWithNullC2() {
        // Test hashCode when C2 is null
        IcTuple tupleWithNullC2 = new IcTuple("ClassA", 1, null, "NestedClass", 0, 0, 0, 0);
        int expectedHashCode = 17 + "ClassA".hashCode() + "NestedClass".hashCode();
        assertEquals(expectedHashCode, tupleWithNullC2.hashCode());
    }

    @Test
    public void testHashCodeWithNullN() {
        // Test hashCode when N is null
        IcTuple tupleWithNullN = new IcTuple("ClassA", 1, "ClassB", null, 0, 0, 0, 0);
        int expectedHashCode = 17 + "ClassA".hashCode() + "ClassB".hashCode();
        assertEquals(expectedHashCode, tupleWithNullN.hashCode());
    }

    @Test
    public void testHashCodeWithAllNulls() {
        // Test hashCode when all relevant fields are null
        IcTuple tupleWithAllNulls = new IcTuple(null, 0, null, null, 0, 0, 0, 0);
        assertEquals(17, tupleWithAllNulls.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentValues() {
        // Test hashCode with different values
        IcTuple tupleDifferentValues = new IcTuple("ClassX", 5, "ClassY", "ClassZ", 2, 3, 4, 5);
        int expectedHashCode = 17 + "ClassX".hashCode() + "ClassY".hashCode() + "ClassZ".hashCode();
        assertEquals(expectedHashCode, tupleDifferentValues.hashCode());
    }
}
