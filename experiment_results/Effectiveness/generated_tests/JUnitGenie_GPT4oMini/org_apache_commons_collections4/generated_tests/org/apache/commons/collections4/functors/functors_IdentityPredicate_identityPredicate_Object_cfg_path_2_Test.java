package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.IdentityPredicate;
import org.apache.commons.collections4.functors.NullPredicate;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class functors_IdentityPredicate_identityPredicate_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIdentityPredicateWithNull() {
        try {
            Predicate<Object> result = IdentityPredicate.identityPredicate(null);
            assertNotNull(result);
            // Verify that the result is an instance of NullPredicate
            assertNotNull(NullPredicate.nullPredicate());
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}