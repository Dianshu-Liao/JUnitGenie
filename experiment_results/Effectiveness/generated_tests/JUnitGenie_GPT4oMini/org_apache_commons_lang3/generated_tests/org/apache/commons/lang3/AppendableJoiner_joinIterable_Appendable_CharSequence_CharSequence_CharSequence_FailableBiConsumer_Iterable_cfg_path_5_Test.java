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

public class AppendableJoiner_joinIterable_Appendable_CharSequence_CharSequence_CharSequence_FailableBiConsumer_Iterable_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testJoinIterable() {
        try {
            // Prepare the parameters
            StringWriter appendable = new StringWriter();
            CharSequence prefix = "[";
            CharSequence suffix = "]";
            CharSequence delimiter = ", ";
            FailableBiConsumer<StringWriter, String, IOException> appender = (a, t) -> a.append(t);
            List<String> elements = Arrays.asList("one", "two", "three");

            // Access the private static method using reflection
            Method method = AppendableJoiner.class.getDeclaredMethod("joinIterable", Appendable.class, CharSequence.class, CharSequence.class, CharSequence.class, FailableBiConsumer.class, Iterable.class);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(null, appendable, prefix, suffix, delimiter, appender, elements);

            // Verify the result
            assertEquals("[one, two, three]", appendable.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}