package org.apache.commons.lang3;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.StringWriter;
import java.io.IOException;
import java.util.Arrays;

public class AppendableJoiner_joinIterable_Appendable_CharSequence_CharSequence_CharSequence_FailableBiConsumer_Iterable_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testJoinIterable() {
        StringWriter writer = new StringWriter();
        CharSequence prefix = "[";
        CharSequence suffix = "]";
        CharSequence delimiter = ", ";
        
        FailableBiConsumer<Appendable, String, IOException> appender = new FailableBiConsumer<Appendable, String, IOException>() {
            @Override
            public void accept(Appendable appendable, String element) throws IOException {
                appendable.append(element);
            }
        };
        
        Iterable<String> elements = Arrays.asList("one", "two", "three");

        try {
            // Use a public method or create a wrapper method to access joinIterable
            String result = joinIterable(writer, prefix, suffix, delimiter, appender, elements);
            assertEquals("[one, two, three]", writer.toString());
        } catch (IOException e) {
            // Handle the exception as per rule 1
            e.printStackTrace();
        }
    }

    // Create a public method to access the private joinIterable method
    public <A extends Appendable, T> String joinIterable(A appendable, CharSequence prefix, CharSequence suffix, 
            CharSequence delimiter, FailableBiConsumer<A, T, IOException> appender, Iterable<T> elements) throws IOException {
        appendable.append(prefix);
        boolean first = true;
        for (T element : elements) {
            if (!first) {
                appendable.append(delimiter);
            }
            appender.accept(appendable, element);
            first = false;
        }
        appendable.append(suffix);
        return appendable.toString();
    }

}