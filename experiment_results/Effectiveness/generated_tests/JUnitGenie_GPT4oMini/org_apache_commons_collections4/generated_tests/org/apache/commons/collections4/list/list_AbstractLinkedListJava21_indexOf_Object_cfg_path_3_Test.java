package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.apache.commons.collections4.CollectionUtils;

public class list_AbstractLinkedListJava21_indexOf_Object_cfg_path_3_Test extends AbstractLinkedListJava21 {
    
    // Concrete implementation of the abstract class
    public list_AbstractLinkedListJava21_indexOf_Object_cfg_path_3_Test() {
        super(); // Call the protected constructor
    }

    @Override
    protected boolean isEqualValue(Object value1, Object value2) {
        return value1.equals(value2);
    }


    // Node class for testing purposes
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }
    }


}
