package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_ReflectionToStringBuilder_toString__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToStringWithNullObject() {
        // Arrange
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(null, ToStringStyle.DEFAULT_STYLE);

        // Act
        String result = builder.toString();

        // Assert
        String expected = ToStringStyle.DEFAULT_STYLE.getNullText();
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToStringWithValidObject() {
        // Arrange
        TestObject testObject = new TestObject("testValue");
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(testObject, ToStringStyle.DEFAULT_STYLE);

        // Act
        String result = builder.toString();

        // Assert
        // Here you would assert the expected string representation of the testObject
        // For example, if the expected output is "TestObject[testValue]", you would do:
        // assertEquals("TestObject[testValue]", result);
    }

    private static class TestObject {
        private String value;

        public TestObject(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}