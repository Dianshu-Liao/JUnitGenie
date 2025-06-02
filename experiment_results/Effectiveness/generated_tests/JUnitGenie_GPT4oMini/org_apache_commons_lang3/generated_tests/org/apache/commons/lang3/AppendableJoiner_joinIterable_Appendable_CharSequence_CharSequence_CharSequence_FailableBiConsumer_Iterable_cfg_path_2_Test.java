package org.apache.commons.lang3;
import org.apache.commons.lang3.AppendableJoiner;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class AppendableJoiner_joinIterable_Appendable_CharSequence_CharSequence_CharSequence_FailableBiConsumer_Iterable_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testJoinIterable() {
        // Prepare the parameters
        StringWriter appendable = new StringWriter();
        CharSequence prefix = "[";
        CharSequence suffix = "]";
        CharSequence delimiter = ", ";
        Iterable<String> elements = Arrays.asList("one", "two", "three");

        // Create a FailableBiConsumer implementation
        FailableBiConsumer<Appendable, String, IOException> appender = new FailableBiConsumer<Appendable, String, IOException>() {
            @Override
            public void accept(Appendable appendable, String element) throws IOException {
                appendable.append(element);
            }
        };

        try {
            // Access the private static method using reflection
            Method method = AppendableJoiner.class.getDeclaredMethod("joinIterable", Appendable.class, CharSequence.class, CharSequence.class, CharSequence.class, FailableBiConsumer.class, Iterable.class);
            method.setAccessible(true);
            method.invoke(null, appendable, prefix, suffix, delimiter, appender, elements); // Invoke the method statically
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verify the result
        String expected = "[one, two, three]";
        assertEquals(expected, appendable.toString());
    }


}