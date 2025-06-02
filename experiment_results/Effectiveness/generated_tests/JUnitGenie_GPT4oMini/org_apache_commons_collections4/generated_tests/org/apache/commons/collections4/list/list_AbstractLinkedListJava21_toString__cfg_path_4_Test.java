package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class list_AbstractLinkedListJava21_toString__cfg_path_4_Test {

    private class ConcreteLinkedList extends AbstractLinkedListJava21 {
        private List<Object> elements = new ArrayList<>();

        public ConcreteLinkedList() {
            super();
        }

        public ConcreteLinkedList(List<Object> collection) {
            super(collection);
            this.elements.addAll(collection);
        }

        @Override
        public boolean isEmpty() {
            return elements.isEmpty();
        }

        @Override
        public int size() {
            return elements.size();
        }

        @Override
        public Iterator<Object> iterator() {
            return elements.iterator();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Iterator<Object> it = iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    @Test(timeout = 4000)
    public void testToStringNonEmpty() {
        try {
            // Create an instance of ConcreteLinkedList with elements
            List<Object> initialElements = new ArrayList<>();
            initialElements.add("Element1");
            initialElements.add("Element2");
            initialElements.add("Element3");

            Constructor<ConcreteLinkedList> constructor = ConcreteLinkedList.class.getDeclaredConstructor(List.class);
            constructor.setAccessible(true);
            ConcreteLinkedList list = constructor.newInstance(initialElements);

            // Expected output
            String expected = "[Element1, Element2, Element3]";
            // Actual output
            String actual = list.toString();

            // Assert the expected output matches the actual output
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}