package org.apache.commons.lang3;
import org.apache.commons.lang3.AppendableJoiner;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class AppendableJoiner_joinIterable_Appendable_CharSequence_CharSequence_CharSequence_FailableBiConsumer_Iterable_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testJoinIterable() {
        StringWriter appendable = new StringWriter();
        CharSequence prefix = "[";
        CharSequence suffix = "]";
        CharSequence delimiter = ", ";
        
        FailableBiConsumer<Appendable, String, IOException> appender = new FailableBiConsumer<Appendable, String, IOException>() {
            @Override
            public void accept(Appendable writer, String element) throws IOException {
                writer.append(element);
            }
        };
        
        Iterable<String> elements = Arrays.asList("one", "two", "three");

        try {
            // Accessing the private static method using reflection
            Method method = AppendableJoiner.class.getDeclaredMethod("joinIterable", Appendable.class, CharSequence.class, CharSequence.class, CharSequence.class, FailableBiConsumer.class, Iterable.class);
            method.setAccessible(true);
            method.invoke(null, appendable, prefix, suffix, delimiter, appender, elements);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String expected = "[one, two, three]";
        assertEquals(expected, appendable.toString());
    }


}