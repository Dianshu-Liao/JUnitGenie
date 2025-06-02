package org.apache.commons.collections4;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>> itorCollectionItorIteratorEnumeration0 = new org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>();
        java.util.ArrayList<org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>> collectionItorIteratorEnumerationList1 = new java.util.ArrayList<org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>>();
        boolean boolean2 = collectionItorIteratorEnumerationList1.add(itorCollectionItorIteratorEnumeration0);
        Transformer<org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>> collectionItorIteratorEnumerationTransformer3 = null;
        MultiMap<java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>> itorIterableFunctionMap4 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.collection.IndexedCollection<java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>> itorIterableFunctionCollection6 = new org.apache.commons.collections4.collection.IndexedCollection<java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>>((java.util.Collection<org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>>) collectionItorIteratorEnumerationList1, collectionItorIteratorEnumerationTransformer3, itorIterableFunctionMap4, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        OrderedMapIterator<org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>, MultiSet<ResettableIterator<Comparable<String>>>> collectionItorIteratorEnumerationItor0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.iterators.AbstractOrderedMapIteratorDecorator<org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>, MultiSet<ResettableIterator<Comparable<String>>>> collectionItorIteratorEnumerationItor1 = new org.apache.commons.collections4.iterators.AbstractOrderedMapIteratorDecorator<org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>, MultiSet<ResettableIterator<Comparable<String>>>>(collectionItorIteratorEnumerationItor0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: iterator");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        java.util.Map<java.util.Iterator<Comparable<String>>, java.io.Serializable> strComparableItorMap0 = null;
        ResettableIterator<Comparable<String>> strComparableItor2 = IteratorUtils.singletonIterator((Comparable<String>) "hi!");
        org.apache.commons.collections4.keyvalue.TiedMapEntry<java.util.Iterator<Comparable<String>>, java.io.Serializable> strComparableItorTiedMapEntry3 = new org.apache.commons.collections4.keyvalue.TiedMapEntry<java.util.Iterator<Comparable<String>>, java.io.Serializable>(strComparableItorMap0, (java.util.Iterator<Comparable<String>>) strComparableItor2);
        org.junit.Assert.assertNotNull(strComparableItor2);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        Factory<Object> objFactory1 = FactoryUtils.constantFactory((Object) (-1));
        org.junit.Assert.assertNotNull(objFactory1);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        Predicate predicate0 = org.apache.commons.collections4.functors.TruePredicate.INSTANCE;
        org.junit.Assert.assertNotNull(predicate0);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        org.apache.commons.collections4.bloomfilter.BitMapExtractor bitMapExtractor0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.bloomfilter.IndexExtractor indexExtractor1 = org.apache.commons.collections4.bloomfilter.IndexExtractor.fromBitMapExtractor(bitMapExtractor0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: bitMapExtractor");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        ResettableListIterator resettableListIterator0 = IteratorUtils.EMPTY_LIST_ITERATOR;
        org.junit.Assert.assertNotNull(resettableListIterator0);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        // The following exception was thrown during execution in test generation
        try {
            ResettableIterator<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> abstractMultiSetArrayComparatorListItor1 = IteratorUtils.arrayIterator((Object) false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Argument is not an array");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        org.apache.commons.collections4.multiset.HashMultiSet<ResettableIterator<Comparable<String>>> strComparableItorCollection0 = new org.apache.commons.collections4.multiset.HashMultiSet<ResettableIterator<Comparable<String>>>();
        // The following exception was thrown during execution in test generation
        try {
            ResettableIterator<Comparable<String>> strComparableItor2 = CollectionUtils.get((Iterable<ResettableIterator<Comparable<String>>>) strComparableItorCollection0, 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Entry does not exist: 100");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        org.w3c.dom.Node node0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.iterators.NodeListIterator nodeListIterator1 = IteratorUtils.nodeListIterator(node0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: node");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        Class<java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> abstractMultiSetArrayComparatorListClass0 = null;
        Class[] classArray2 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray3 = (Class<?>[]) classArray2;
        Class[] classArray6 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray7 = (Class<?>[]) classArray6;
        Object[] objArray9 = new Object[] { true };
        org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>> comparableItorIterableInvokerTransformer10 = new org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>("", wildcardClassArray7, objArray9);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.functors.InstantiateFactory<java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> abstractMultiSetArrayComparatorListInstantiateFactory11 = new org.apache.commons.collections4.functors.InstantiateFactory<java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>(abstractMultiSetArrayComparatorListClass0, (Class<?>[]) classArray2, (Object[]) wildcardClassArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(classArray2);
        org.junit.Assert.assertArrayEquals(classArray2, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray3);
        org.junit.Assert.assertArrayEquals(wildcardClassArray3, new Class[] {});
        org.junit.Assert.assertNotNull(classArray6);
        org.junit.Assert.assertArrayEquals(classArray6, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray7);
        org.junit.Assert.assertArrayEquals(wildcardClassArray7, new Class[] {});
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[true]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[true]");
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        Transformer[] transformerArray1 = new Transformer[0];
        @SuppressWarnings("unchecked")
        Transformer<? super java.util.ListIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, ? extends java.util.ListIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>[] wildcardTransformerArray2 = (Transformer<? super java.util.ListIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, ? extends java.util.ListIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>[]) transformerArray1;
        org.apache.commons.collections4.functors.ChainedTransformer<java.util.ListIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>> iterableInvokerTransformerItorChainedTransformer3 = new org.apache.commons.collections4.functors.ChainedTransformer<java.util.ListIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>(wildcardTransformerArray2);
        org.junit.Assert.assertNotNull(transformerArray1);
        org.junit.Assert.assertArrayEquals(transformerArray1, new Transformer[] {});
        org.junit.Assert.assertNotNull(wildcardTransformerArray2);
        org.junit.Assert.assertArrayEquals(wildcardTransformerArray2, new Transformer[] {});
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        org.apache.commons.collections4.multiset.AbstractMultiSet[] abstractMultiSetArray1 = new org.apache.commons.collections4.multiset.AbstractMultiSet[0];
        @SuppressWarnings("unchecked")
        org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[] comparableItorCollectionArray2 = (org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1;
        org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>> comparableItorCollectionItor4 = new org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>((org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1, 0);
        comparableItorCollectionItor4.reset();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>> strComparableItorCollection6 = comparableItorCollectionItor4.next();
            org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException; message: null");
        } catch (java.util.NoSuchElementException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(abstractMultiSetArray1);
        org.junit.Assert.assertArrayEquals(abstractMultiSetArray1, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
        org.junit.Assert.assertNotNull(comparableItorCollectionArray2);
        org.junit.Assert.assertArrayEquals(comparableItorCollectionArray2, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        java.util.LinkedHashSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>> iterableInvokerTransformerEntrySet0 = new java.util.LinkedHashSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>();
        org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>> itorIterableInvokerTransformerItor1 = new org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>((java.util.Set<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>) iterableInvokerTransformerEntrySet0);
        java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>> comparableItorIterableFunction2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>> comparableItorIterableFunction3 = itorIterableInvokerTransformerItor1.setValue(comparableItorIterableFunction2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: null");
        } catch (IllegalStateException e) {
            // Expected exception.
        }
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        org.apache.commons.collections4.bloomfilter.IndexExtractor indexExtractor0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.bloomfilter.BitMapExtractor bitMapExtractor2 = org.apache.commons.collections4.bloomfilter.BitMapExtractor.fromIndexExtractor(indexExtractor0, (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: extractor");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        Closure<Object[]> objArrayClosure0 = ClosureUtils.exceptionClosure();
        org.junit.Assert.assertNotNull(objArrayClosure0);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        Transformer<Transformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> itorIterableTransformerTransformer1 = TransformerUtils.invokerTransformer("");
        org.junit.Assert.assertNotNull(itorIterableTransformerTransformer1);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        Throwable throwable1 = null;
        FunctorException functorException2 = new FunctorException("hi!", throwable1);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorList1 = new java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>();
        boolean boolean2 = abstractMultiSetArrayComparatorList1.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain0);
        java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparator4 = null;
        // The following exception was thrown during execution in test generation
        try {
            abstractMultiSetArrayComparatorList1.add((-1), abstractMultiSetArrayComparator4);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: -1, Size: 1");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        Class[] classArray2 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray3 = (Class<?>[]) classArray2;
        Object[] objArray5 = new Object[] { true };
        org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>> comparableItorIterableInvokerTransformer6 = new org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>("", wildcardClassArray3, objArray5);
        java.util.ListIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>> itorIterableInvokerTransformerItor7 = IteratorUtils.singletonListIterator(comparableItorIterableInvokerTransformer6);
        org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>> itorCollectionItorIteratorEnumeration8 = new org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>();
        // The following exception was thrown during execution in test generation
        try {
            MultiSet<ResettableIterator<Comparable<String>>> strComparableItorCollection9 = comparableItorIterableInvokerTransformer6.transform((Object) itorCollectionItorIteratorEnumeration8);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.collections4.FunctorException; message: InvokerTransformer: The method '' on 'class org.apache.commons.collections4.iterators.IteratorEnumeration' does not exist");
        } catch (FunctorException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(classArray2);
        org.junit.Assert.assertArrayEquals(classArray2, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray3);
        org.junit.Assert.assertArrayEquals(wildcardClassArray3, new Class[] {});
        org.junit.Assert.assertNotNull(objArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray5), "[true]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray5), "[true]");
        org.junit.Assert.assertNotNull(itorIterableInvokerTransformerItor7);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        java.util.Map<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap0 = null;
        java.util.Map<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap1 = null;
        org.apache.commons.collections4.map.CompositeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap2 = new org.apache.commons.collections4.map.CompositeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>(iterableInvokerTransformerItorMap0, iterableInvokerTransformerItorMap1);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Map<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap3 = MapUtils.synchronizedMap(iterableInvokerTransformerItorMap0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        Predicate<CharSequence> charSequencePredicate0 = PredicateUtils.falsePredicate();
        org.junit.Assert.assertNotNull(charSequencePredicate0);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        org.apache.commons.collections4.map.AbstractReferenceMap.ReferenceStrength referenceStrength1 = org.apache.commons.collections4.map.AbstractReferenceMap.ReferenceStrength.resolve((int) (short) 1);
        org.junit.Assert.assertTrue("'" + referenceStrength1 + "' != '" + org.apache.commons.collections4.map.AbstractReferenceMap.ReferenceStrength.SOFT + "'", referenceStrength1.equals(org.apache.commons.collections4.map.AbstractReferenceMap.ReferenceStrength.SOFT));
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        org.apache.commons.collections4.list.TreeList<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayList0 = new org.apache.commons.collections4.list.TreeList<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        java.util.LinkedHashSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>> iterableInvokerTransformerEntrySet0 = new java.util.LinkedHashSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>();
        org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>> itorIterableInvokerTransformerItor1 = new org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>((java.util.Set<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>) iterableInvokerTransformerEntrySet0);
        boolean boolean2 = itorIterableInvokerTransformerItor1.hasNext();
        itorIterableInvokerTransformerItor1.reset();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        org.apache.commons.collections4.bloomfilter.BitMapExtractor bitMapExtractor0 = null;
        org.apache.commons.collections4.bloomfilter.BitMapExtractor bitMapExtractor1 = null;
        // The following exception was thrown during execution in test generation
        try {
            int int2 = org.apache.commons.collections4.bloomfilter.SetOperations.hammingDistance(bitMapExtractor0, bitMapExtractor1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        org.apache.commons.collections4.comparators.BooleanComparator booleanComparator1 = new org.apache.commons.collections4.comparators.BooleanComparator(false);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        java.io.PrintStream printStream0 = null;
        java.util.Map<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap2 = null;
        java.util.Map<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap3 = null;
        org.apache.commons.collections4.map.CompositeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap4 = new org.apache.commons.collections4.map.CompositeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>(iterableInvokerTransformerItorMap2, iterableInvokerTransformerItorMap3);
        // The following exception was thrown during execution in test generation
        try {
            MapUtils.debugPrint(printStream0, (Object) (short) 0, iterableInvokerTransformerItorMap3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        MapIterator mapIterator0 = org.apache.commons.collections4.iterators.EmptyMapIterator.INSTANCE;
        org.junit.Assert.assertNotNull(mapIterator0);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        org.apache.commons.collections4.properties.PropertiesFactory propertiesFactory0 = org.apache.commons.collections4.properties.PropertiesFactory.INSTANCE;
        java.io.File file1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Properties properties2 = propertiesFactory0.load(file1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(propertiesFactory0);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        org.apache.commons.collections4.multiset.HashMultiSet<KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>> comparableItorKeyValueCollection0 = new org.apache.commons.collections4.multiset.HashMultiSet<KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>>();
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        boolean boolean1 = abstractMultiSetArrayComparatorChain0.isLocked();
        // The following exception was thrown during execution in test generation
        try {
            abstractMultiSetArrayComparatorChain0.setReverseSort((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: bitIndex < 0: -1");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        org.apache.commons.collections4.bloomfilter.IndexExtractor indexExtractor0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.bloomfilter.BitMapExtractor bitMapExtractor2 = org.apache.commons.collections4.bloomfilter.BitMapExtractor.fromIndexExtractor(indexExtractor0, (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: extractor");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        Class<?>[] wildcardClassArray1 = null;
        java.util.Set[] setArray3 = new java.util.Set[0];
        @SuppressWarnings("unchecked")
        java.util.Set<org.apache.commons.collections4.multiset.AbstractMapMultiSet<ResettableIterator<Comparable<String>>>>[] itorCollectionSetArray4 = (java.util.Set<org.apache.commons.collections4.multiset.AbstractMapMultiSet<ResettableIterator<Comparable<String>>>>[]) setArray3;
        org.apache.commons.collections4.set.CompositeSet<org.apache.commons.collections4.multiset.AbstractMapMultiSet<ResettableIterator<Comparable<String>>>> comparableItorCollectionSet5 = new org.apache.commons.collections4.set.CompositeSet<org.apache.commons.collections4.multiset.AbstractMapMultiSet<ResettableIterator<Comparable<String>>>>(itorCollectionSetArray4);
        // The following exception was thrown during execution in test generation
        try {
            Transformer<OrderedIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>, FunctorException> itorCollectionItorTransformer6 = TransformerUtils.invokerTransformer("hi!", wildcardClassArray1, (Object[]) itorCollectionSetArray4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The parameter types must match the arguments");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(setArray3);
        org.junit.Assert.assertArrayEquals(setArray3, new java.util.Set[] {});
        org.junit.Assert.assertNotNull(itorCollectionSetArray4);
        org.junit.Assert.assertArrayEquals(itorCollectionSetArray4, new java.util.Set[] {});
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        java.util.Map<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap0 = null;
        java.util.Map<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap1 = null;
        org.apache.commons.collections4.map.CompositeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap2 = new org.apache.commons.collections4.map.CompositeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>(iterableInvokerTransformerItorMap0, iterableInvokerTransformerItorMap1);
        java.util.Map<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap3 = null;
        java.util.Map<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap4 = null;
        org.apache.commons.collections4.map.CompositeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap5 = new org.apache.commons.collections4.map.CompositeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>(iterableInvokerTransformerItorMap3, iterableInvokerTransformerItorMap4);
        java.util.Map<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> iterableInvokerTransformerItorMap6 = MapUtils.emptyIfNull(iterableInvokerTransformerItorMap4);
        // The following exception was thrown during execution in test generation
        try {
            iterableInvokerTransformerItorMap2.putAll(iterableInvokerTransformerItorMap4);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: No mutator specified");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(iterableInvokerTransformerItorMap6);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        MultiSet<java.util.stream.Stream<ResettableIterator<Comparable<String>>>> comparableItorStreamCollection0 = MultiSetUtils.emptyMultiSet();
        org.junit.Assert.assertNotNull(comparableItorStreamCollection0);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        KeyValue<org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat> itorCollectionItorKeyValue0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.map.SingletonMap<org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat> itorCollectionItorMap1 = new org.apache.commons.collections4.map.SingletonMap<org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat>(itorCollectionItorKeyValue0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet0 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet1 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        charSequenceSet0.removeComposited((java.util.Set<CharSequence>) charSequenceSet1);
        java.util.List<java.util.Set<CharSequence>> charSequenceSetList3 = charSequenceSet0.getSets();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet4 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet5 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        charSequenceSet4.removeComposited((java.util.Set<CharSequence>) charSequenceSet5);
        java.util.List<java.util.Set<CharSequence>> charSequenceSetList7 = charSequenceSet4.getSets();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet8 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet9 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        charSequenceSet8.removeComposited((java.util.Set<CharSequence>) charSequenceSet9);
        java.util.List<java.util.Set<CharSequence>> charSequenceSetList11 = charSequenceSet8.getSets();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet12 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet13 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        charSequenceSet12.removeComposited((java.util.Set<CharSequence>) charSequenceSet13);
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet15 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet16 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        charSequenceSet15.removeComposited((java.util.Set<CharSequence>) charSequenceSet16);
        java.util.List<java.util.Set<CharSequence>> charSequenceSetList18 = charSequenceSet15.getSets();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet19 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        java.util.Set[] setArray21 = new java.util.Set[6];
        @SuppressWarnings("unchecked")
        java.util.Set<CharSequence>[] charSequenceSetArray22 = (java.util.Set<CharSequence>[]) setArray21;
        charSequenceSetArray22[0] = charSequenceSet0;
        charSequenceSetArray22[1] = charSequenceSet4;
        charSequenceSetArray22[2] = charSequenceSet8;
        charSequenceSetArray22[3] = charSequenceSet12;
        charSequenceSetArray22[4] = charSequenceSet15;
        charSequenceSetArray22[5] = charSequenceSet19;
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet35 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>(charSequenceSetArray22);
        org.junit.Assert.assertNotNull(charSequenceSetList3);
        org.junit.Assert.assertNotNull(charSequenceSetList7);
        org.junit.Assert.assertNotNull(charSequenceSetList11);
        org.junit.Assert.assertNotNull(charSequenceSetList18);
        org.junit.Assert.assertNotNull(setArray21);
        org.junit.Assert.assertNotNull(charSequenceSetArray22);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        org.apache.commons.collections4.queue.CircularFifoQueue<CharSequence> charSequenceQueue1 = new org.apache.commons.collections4.queue.CircularFifoQueue<CharSequence>((int) ' ');
        boolean boolean2 = charSequenceQueue1.isAtFullCapacity();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        Class<Get<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>> invokerTransformerItorGetClass0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.functors.InstantiateFactory<Get<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>> invokerTransformerItorGetInstantiateFactory1 = new org.apache.commons.collections4.functors.InstantiateFactory<Get<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>>(invokerTransformerItorGetClass0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        org.apache.commons.collections4.map.MultiKeyMap<java.util.Set<CharSequence>, Closure<Object[]>> charSequenceSetMap0 = new org.apache.commons.collections4.map.MultiKeyMap<java.util.Set<CharSequence>, Closure<Object[]>>();
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        Class[] classArray1 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray2 = (Class<?>[]) classArray1;
        org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]> wildcardClassArrayItor3 = new org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]>((Class<?>[]) classArray1);
        org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]> wildcardClassArrayItor5 = new org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]>((Class<?>[]) classArray1, true);
        org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]> wildcardClassArrayItor6 = new org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]>((Class<?>[]) classArray1);
        org.junit.Assert.assertNotNull(classArray1);
        org.junit.Assert.assertArrayEquals(classArray1, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray2);
        org.junit.Assert.assertArrayEquals(wildcardClassArray2, new Class[] {});
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain1 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorList2 = new java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>();
        boolean boolean3 = abstractMultiSetArrayComparatorList2.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain0);
        boolean boolean4 = abstractMultiSetArrayComparatorList2.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain1);
        boolean boolean6 = abstractMultiSetArrayComparatorList2.equals((Object) 0.0f);
        java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparator7 = ListUtils.getFirst((java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>) abstractMultiSetArrayComparatorList2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(abstractMultiSetArrayComparator7);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        boolean boolean1 = abstractMultiSetArrayComparatorChain0.isLocked();
        int int2 = abstractMultiSetArrayComparatorChain0.size();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain1 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        boolean boolean2 = abstractMultiSetArrayComparatorChain1.isLocked();
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain3 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        boolean boolean4 = abstractMultiSetArrayComparatorChain3.isLocked();
        java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorList5 = new java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>();
        boolean boolean6 = abstractMultiSetArrayComparatorList5.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain0);
        boolean boolean7 = abstractMultiSetArrayComparatorList5.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain1);
        boolean boolean8 = abstractMultiSetArrayComparatorList5.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain3);
        boolean boolean10 = abstractMultiSetArrayComparatorList5.remove((Object) '4');
        java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparator11 = ListUtils.getFirst((java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>) abstractMultiSetArrayComparatorList5);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(abstractMultiSetArrayComparator11);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        org.apache.commons.collections4.bloomfilter.IndexExtractor indexExtractor0 = null;
        org.apache.commons.collections4.bloomfilter.CellExtractor cellExtractor1 = org.apache.commons.collections4.bloomfilter.CellExtractor.from(indexExtractor0);
        org.junit.Assert.assertNotNull(cellExtractor1);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        org.apache.commons.collections4.multiset.AbstractMultiSet[] abstractMultiSetArray1 = new org.apache.commons.collections4.multiset.AbstractMultiSet[0];
        @SuppressWarnings("unchecked")
        org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[] comparableItorCollectionArray2 = (org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1;
        org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>> comparableItorCollectionItor4 = new org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>((org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1, 0);
        org.apache.commons.collections4.multiset.AbstractMultiSet[][] abstractMultiSetArray5 = new org.apache.commons.collections4.multiset.AbstractMultiSet[][] { abstractMultiSetArray1 };
        org.apache.commons.collections4.list.TreeList<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayList6 = new org.apache.commons.collections4.list.TreeList<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        boolean boolean7 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayList6, abstractMultiSetArray5);
        Object[] objArray8 = abstractMultiSetArrayList6.toArray();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.multiset.AbstractMultiSet[] abstractMultiSetArray10 = abstractMultiSetArrayList6.get((int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Invalid index:100, size=1");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(abstractMultiSetArray1);
        org.junit.Assert.assertArrayEquals(abstractMultiSetArray1, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
        org.junit.Assert.assertNotNull(comparableItorCollectionArray2);
        org.junit.Assert.assertArrayEquals(comparableItorCollectionArray2, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
        org.junit.Assert.assertNotNull(abstractMultiSetArray5);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(objArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray8), "[[]]");
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        Iterable<? extends java.util.Set<CharSequence>> wildcardIterable0 = null;
        Iterable[] iterableArray2 = new Iterable[1];
        @SuppressWarnings("unchecked")
        Iterable<? extends java.util.Set<CharSequence>>[] wildcardIterableArray3 = (Iterable<? extends java.util.Set<CharSequence>>[]) iterableArray2;
        wildcardIterableArray3[0] = wildcardIterable0;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.iterators.CartesianProductIterator<java.util.Set<CharSequence>> charSequenceSetItor6 = new org.apache.commons.collections4.iterators.CartesianProductIterator<java.util.Set<CharSequence>>(wildcardIterableArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: iterable");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(iterableArray2);
        org.junit.Assert.assertArrayEquals(iterableArray2, new Iterable[] { null });
        org.junit.Assert.assertNotNull(wildcardIterableArray3);
        org.junit.Assert.assertArrayEquals(wildcardIterableArray3, new Iterable[] { null });
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        org.apache.commons.collections4.set.ListOrderedSet<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> abstractMultiSetArrayComparatorListSet0 = new org.apache.commons.collections4.set.ListOrderedSet<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>();
        java.util.List<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> abstractMultiSetArrayComparatorListList1 = abstractMultiSetArrayComparatorListSet0.asList();
        org.junit.Assert.assertNotNull(abstractMultiSetArrayComparatorListList1);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        Class[] classArray2 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray3 = (Class<?>[]) classArray2;
        Object[] objArray5 = new Object[] { true };
        org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>> comparableItorIterableInvokerTransformer6 = new org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>("", wildcardClassArray3, objArray5);
        java.util.ListIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>> itorIterableInvokerTransformerItor7 = IteratorUtils.singletonListIterator(comparableItorIterableInvokerTransformer6);
        org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>> comparableItorIterableInvokerTransformer8 = itorIterableInvokerTransformerItor7.next();
        org.junit.Assert.assertNotNull(classArray2);
        org.junit.Assert.assertArrayEquals(classArray2, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray3);
        org.junit.Assert.assertArrayEquals(wildcardClassArray3, new Class[] {});
        org.junit.Assert.assertNotNull(objArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray5), "[true]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray5), "[true]");
        org.junit.Assert.assertNotNull(itorIterableInvokerTransformerItor7);
        org.junit.Assert.assertNotNull(comparableItorIterableInvokerTransformer8);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        Transformer[] transformerArray1 = new Transformer[0];
        @SuppressWarnings("unchecked")
        Transformer<? super java.util.function.Consumer<Object[]>, ? extends java.util.function.Consumer<Object[]>>[] wildcardTransformerArray2 = (Transformer<? super java.util.function.Consumer<Object[]>, ? extends java.util.function.Consumer<Object[]>>[]) transformerArray1;
        Transformer<java.util.function.Consumer<Object[]>, java.util.function.Consumer<Object[]>> objArrayConsumerTransformer3 = org.apache.commons.collections4.functors.ChainedTransformer.chainedTransformer(wildcardTransformerArray2);
        org.junit.Assert.assertNotNull(transformerArray1);
        org.junit.Assert.assertArrayEquals(transformerArray1, new Transformer[] {});
        org.junit.Assert.assertNotNull(wildcardTransformerArray2);
        org.junit.Assert.assertArrayEquals(wildcardTransformerArray2, new Transformer[] {});
        org.junit.Assert.assertNotNull(objArrayConsumerTransformer3);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.iterators.ArrayListIterator<org.apache.commons.collections4.list.GrowthList<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>> invokerTransformerItorListItor2 = new org.apache.commons.collections4.iterators.ArrayListIterator<org.apache.commons.collections4.list.GrowthList<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>((Object) 1, (int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Argument is not an array");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        Bag bag0 = BagUtils.EMPTY_BAG;
        org.junit.Assert.assertNotNull(bag0);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet0 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet1 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        charSequenceSet0.removeComposited((java.util.Set<CharSequence>) charSequenceSet1);
        java.util.List<java.util.Set<CharSequence>> charSequenceSetList3 = charSequenceSet0.getSets();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet4 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet5 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        charSequenceSet4.removeComposited((java.util.Set<CharSequence>) charSequenceSet5);
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet7 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet8 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        charSequenceSet7.removeComposited((java.util.Set<CharSequence>) charSequenceSet8);
        java.util.Set[] setArray11 = new java.util.Set[2];
        @SuppressWarnings("unchecked")
        java.util.Set<CharSequence>[] charSequenceSetArray12 = (java.util.Set<CharSequence>[]) setArray11;
        charSequenceSetArray12[0] = charSequenceSet4;
        charSequenceSetArray12[1] = charSequenceSet8;
        charSequenceSet0.addComposited(charSequenceSetArray12);
        org.junit.Assert.assertNotNull(charSequenceSetList3);
        org.junit.Assert.assertNotNull(setArray11);
        org.junit.Assert.assertNotNull(charSequenceSetArray12);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        org.apache.commons.collections4.map.PassiveExpiringMap.ExpirationPolicy<java.util.Enumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>, java.util.function.Supplier<Object[]>> collectionItorEnumerationExpirationPolicy0 = null;
        java.util.Map<java.util.Enumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>, java.util.function.Supplier<Object[]>> collectionItorEnumerationMap1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.map.PassiveExpiringMap<java.util.Enumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>, java.util.function.Supplier<Object[]>> collectionItorEnumerationMap2 = new org.apache.commons.collections4.map.PassiveExpiringMap<java.util.Enumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>, java.util.function.Supplier<Object[]>>(collectionItorEnumerationExpirationPolicy0, collectionItorEnumerationMap1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: map");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        org.apache.commons.collections4.sequence.EditScript<java.util.stream.BaseStream<ResettableIterator<Comparable<String>>, java.util.stream.Stream<ResettableIterator<Comparable<String>>>>> comparableItorBaseStreamEditScript0 = new org.apache.commons.collections4.sequence.EditScript<java.util.stream.BaseStream<ResettableIterator<Comparable<String>>, java.util.stream.Stream<ResettableIterator<Comparable<String>>>>>();
        int int1 = comparableItorBaseStreamEditScript0.getLCSLength();
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.iterators.ArrayIterator<ResettableIterator<Comparable<String>>> strComparableItorItor2 = new org.apache.commons.collections4.iterators.ArrayIterator<ResettableIterator<Comparable<String>>>((Object) true, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Argument is not an array");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet0 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet1 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        charSequenceSet0.removeComposited((java.util.Set<CharSequence>) charSequenceSet1);
        int int3 = charSequenceSet1.size();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        org.apache.commons.collections4.multiset.AbstractMultiSet[] abstractMultiSetArray1 = new org.apache.commons.collections4.multiset.AbstractMultiSet[0];
        @SuppressWarnings("unchecked")
        org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[] comparableItorCollectionArray2 = (org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1;
        org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>> comparableItorCollectionItor4 = new org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>((org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1, 0);
        org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>> comparableItorCollectionItor5 = new org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>((org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1);
        org.junit.Assert.assertNotNull(abstractMultiSetArray1);
        org.junit.Assert.assertArrayEquals(abstractMultiSetArray1, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
        org.junit.Assert.assertNotNull(comparableItorCollectionArray2);
        org.junit.Assert.assertArrayEquals(comparableItorCollectionArray2, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorList1 = new java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>();
        boolean boolean2 = abstractMultiSetArrayComparatorList1.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain0);
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain3 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>((java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>) abstractMultiSetArrayComparatorList1);
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain5 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorList6 = new java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>();
        boolean boolean7 = abstractMultiSetArrayComparatorList6.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain5);
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain8 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>((java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>) abstractMultiSetArrayComparatorList6);
        java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparator9 = ComparatorUtils.reversedComparator((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain8);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparator10 = abstractMultiSetArrayComparatorList1.set(1, (java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain8);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 1, Size: 1");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(abstractMultiSetArrayComparator9);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        org.apache.commons.collections4.properties.OrderedPropertiesFactory orderedPropertiesFactory0 = org.apache.commons.collections4.properties.OrderedPropertiesFactory.INSTANCE;
        java.io.InputStream inputStream1 = null;
        org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat propertyFormat2 = org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML;
        org.apache.commons.collections4.properties.OrderedProperties orderedProperties3 = orderedPropertiesFactory0.load(inputStream1, propertyFormat2);
        java.io.File file4 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.properties.OrderedProperties orderedProperties5 = orderedPropertiesFactory0.load(file4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(orderedPropertiesFactory0);
        org.junit.Assert.assertTrue("'" + propertyFormat2 + "' != '" + org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML + "'", propertyFormat2.equals(org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML));
        org.junit.Assert.assertNull(orderedProperties3);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        org.apache.commons.collections4.bloomfilter.BitMapExtractor bitMapExtractor0 = null;
        org.apache.commons.collections4.bloomfilter.BitMapExtractor bitMapExtractor1 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = org.apache.commons.collections4.bloomfilter.SetOperations.jaccardDistance(bitMapExtractor0, bitMapExtractor1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        Iterable[] iterableArray1 = new Iterable[0];
        @SuppressWarnings("unchecked")
        Iterable<? extends FunctorException>[] wildcardIterableArray2 = (Iterable<? extends FunctorException>[]) iterableArray1;
        org.apache.commons.collections4.iterators.CartesianProductIterator<FunctorException> functorExceptionItor3 = new org.apache.commons.collections4.iterators.CartesianProductIterator<FunctorException>(wildcardIterableArray2);
        org.junit.Assert.assertNotNull(iterableArray1);
        org.junit.Assert.assertArrayEquals(iterableArray1, new Iterable[] {});
        org.junit.Assert.assertNotNull(wildcardIterableArray2);
        org.junit.Assert.assertArrayEquals(wildcardIterableArray2, new Iterable[] {});
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        ListValuedMap<Enum<org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat>, org.apache.commons.collections4.keyvalue.AbstractKeyValue<Class<?>[], java.util.Collection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>[]>> propertyFormatEnumListValuedMap0 = MultiMapUtils.newListValuedHashMap();
        org.junit.Assert.assertNotNull(propertyFormatEnumListValuedMap0);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        MapIterator mapIterator0 = IteratorUtils.EMPTY_MAP_ITERATOR;
        org.junit.Assert.assertNotNull(mapIterator0);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        Class[] classArray1 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray2 = (Class<?>[]) classArray1;
        org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]> wildcardClassArrayItor3 = new org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]>((Class<?>[]) classArray1);
        org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]> wildcardClassArrayItor5 = new org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]>((Class<?>[]) classArray1, true);
        org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]> wildcardClassArrayItor7 = new org.apache.commons.collections4.iterators.SingletonIterator<Class<?>[]>((Class<?>[]) classArray1, false);
        org.junit.Assert.assertNotNull(classArray1);
        org.junit.Assert.assertArrayEquals(classArray1, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray2);
        org.junit.Assert.assertArrayEquals(wildcardClassArray2, new Class[] {});
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        org.apache.commons.collections4.comparators.FixedOrderComparator<java.util.Collection<ResettableIterator<Comparable<String>>>> comparableItorCollectionFixedOrderComparator0 = new org.apache.commons.collections4.comparators.FixedOrderComparator<java.util.Collection<ResettableIterator<Comparable<String>>>>();
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        org.apache.commons.collections4.multiset.AbstractMultiSet[] abstractMultiSetArray1 = new org.apache.commons.collections4.multiset.AbstractMultiSet[0];
        @SuppressWarnings("unchecked")
        org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[] comparableItorCollectionArray2 = (org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1;
        org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>> comparableItorCollectionItor4 = new org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>((org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1, 0);
        boolean boolean5 = comparableItorCollectionItor4.hasNext();
        org.junit.Assert.assertNotNull(abstractMultiSetArray1);
        org.junit.Assert.assertArrayEquals(abstractMultiSetArray1, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
        org.junit.Assert.assertNotNull(comparableItorCollectionArray2);
        org.junit.Assert.assertArrayEquals(comparableItorCollectionArray2, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        org.apache.commons.collections4.multiset.AbstractMultiSet[] abstractMultiSetArray1 = new org.apache.commons.collections4.multiset.AbstractMultiSet[0];
        @SuppressWarnings("unchecked")
        org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[] comparableItorCollectionArray2 = (org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1;
        org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>> comparableItorCollectionItor4 = new org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>((org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[]) abstractMultiSetArray1, 0);
        org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>[] comparableItorCollectionArray5 = comparableItorCollectionItor4.getArray();
        org.junit.Assert.assertNotNull(abstractMultiSetArray1);
        org.junit.Assert.assertArrayEquals(abstractMultiSetArray1, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
        org.junit.Assert.assertNotNull(comparableItorCollectionArray2);
        org.junit.Assert.assertArrayEquals(comparableItorCollectionArray2, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
        org.junit.Assert.assertNotNull(comparableItorCollectionArray5);
        org.junit.Assert.assertArrayEquals(comparableItorCollectionArray5, new org.apache.commons.collections4.multiset.AbstractMultiSet[] {});
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        org.apache.commons.collections4.properties.OrderedPropertiesFactory orderedPropertiesFactory0 = org.apache.commons.collections4.properties.OrderedPropertiesFactory.INSTANCE;
        java.io.InputStream inputStream1 = null;
        org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat propertyFormat2 = org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML;
        org.apache.commons.collections4.properties.OrderedProperties orderedProperties3 = orderedPropertiesFactory0.load(inputStream1, propertyFormat2);
        java.io.InputStream inputStream4 = null;
        ArrayStack<Enum<org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat>> propertyFormatEnumList5 = new ArrayStack<Enum<org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat>>();
        org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat propertyFormat6 = org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML;
        Enum<org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat> propertyFormatEnum7 = propertyFormatEnumList5.push((Enum<org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat>) propertyFormat6);
        org.apache.commons.collections4.properties.OrderedProperties orderedProperties8 = orderedPropertiesFactory0.load(inputStream4, propertyFormat6);
        org.junit.Assert.assertNotNull(orderedPropertiesFactory0);
        org.junit.Assert.assertTrue("'" + propertyFormat2 + "' != '" + org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML + "'", propertyFormat2.equals(org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML));
        org.junit.Assert.assertNull(orderedProperties3);
        org.junit.Assert.assertTrue("'" + propertyFormat6 + "' != '" + org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML + "'", propertyFormat6.equals(org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML));
        org.junit.Assert.assertTrue("'" + propertyFormatEnum7 + "' != '" + org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML + "'", propertyFormatEnum7.equals(org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML));
        org.junit.Assert.assertNull(orderedProperties8);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        CharSequence[] charSequenceArray1 = new CharSequence[] { "hi!" };
        org.apache.commons.collections4.queue.CircularFifoQueue<CharSequence> charSequenceQueue2 = new org.apache.commons.collections4.queue.CircularFifoQueue<CharSequence>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<CharSequence>) charSequenceQueue2, charSequenceArray1);
        boolean boolean5 = charSequenceQueue2.add((CharSequence) "");
        CharSequence charSequence6 = charSequenceQueue2.remove();
        int int7 = charSequenceQueue2.size();
        org.junit.Assert.assertNotNull(charSequenceArray1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertEquals("'" + charSequence6 + "' != '" + "hi!" + "'", charSequence6, "hi!");
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain1 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        boolean boolean2 = abstractMultiSetArrayComparatorChain1.isLocked();
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain3 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        boolean boolean4 = abstractMultiSetArrayComparatorChain3.isLocked();
        java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorList5 = new java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>();
        boolean boolean6 = abstractMultiSetArrayComparatorList5.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain0);
        boolean boolean7 = abstractMultiSetArrayComparatorList5.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain1);
        boolean boolean8 = abstractMultiSetArrayComparatorList5.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain3);
        boolean boolean10 = abstractMultiSetArrayComparatorList5.remove((Object) '4');
        boolean boolean11 = abstractMultiSetArrayComparatorList5.isEmpty();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        Bag bag0 = BagUtils.EMPTY_SORTED_BAG;
        org.junit.Assert.assertNotNull(bag0);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        org.apache.commons.collections4.properties.OrderedPropertiesFactory orderedPropertiesFactory0 = org.apache.commons.collections4.properties.OrderedPropertiesFactory.INSTANCE;
        java.io.InputStream inputStream1 = null;
        org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat propertyFormat2 = org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML;
        org.apache.commons.collections4.properties.OrderedProperties orderedProperties3 = orderedPropertiesFactory0.load(inputStream1, propertyFormat2);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.properties.OrderedProperties orderedProperties5 = orderedPropertiesFactory0.load("");
            org.junit.Assert.fail("Expected exception of type java.io.FileNotFoundException; message:  (No such file or directory)");
        } catch (java.io.FileNotFoundException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(orderedPropertiesFactory0);
        org.junit.Assert.assertTrue("'" + propertyFormat2 + "' != '" + org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML + "'", propertyFormat2.equals(org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML));
        org.junit.Assert.assertNull(orderedProperties3);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        SetValuedMap<java.util.function.Supplier<Object[]>, Comparable<String>> objArraySupplierSetValuedMap0 = MultiMapUtils.newSetValuedHashMap();
        org.junit.Assert.assertNotNull(objArraySupplierSetValuedMap0);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        int int0 = CollectionUtils.INDEX_NOT_FOUND;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + (-1) + "'", int0 == (-1));
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        int int0 = org.apache.commons.collections4.functors.DefaultEquator.HASHCODE_NULL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + (-1) + "'", int0 == (-1));
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.bloomfilter.Shape shape3 = org.apache.commons.collections4.bloomfilter.Shape.fromPMK((double) 0, 2, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Probability must be greater than 0 and less than 1: 0.0");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        java.util.Collection<java.util.stream.BaseStream<ResettableIterator<Comparable<String>>, java.util.stream.Stream<ResettableIterator<Comparable<String>>>>> comparableItorBaseStreamCollection0 = null;
        java.util.Collection[] collectionArray2 = new java.util.Collection[1];
        @SuppressWarnings("unchecked")
        java.util.Collection<java.util.stream.BaseStream<ResettableIterator<Comparable<String>>, java.util.stream.Stream<ResettableIterator<Comparable<String>>>>>[] itorBaseStreamCollectionArray3 = (java.util.Collection<java.util.stream.BaseStream<ResettableIterator<Comparable<String>>, java.util.stream.Stream<ResettableIterator<Comparable<String>>>>>[]) collectionArray2;
        itorBaseStreamCollectionArray3[0] = comparableItorBaseStreamCollection0;
        org.apache.commons.collections4.collection.CompositeCollection<java.util.stream.BaseStream<ResettableIterator<Comparable<String>>, java.util.stream.Stream<ResettableIterator<Comparable<String>>>>> comparableItorBaseStreamCollection6 = new org.apache.commons.collections4.collection.CompositeCollection<java.util.stream.BaseStream<ResettableIterator<Comparable<String>>, java.util.stream.Stream<ResettableIterator<Comparable<String>>>>>(itorBaseStreamCollectionArray3);
        org.junit.Assert.assertNotNull(collectionArray2);
        org.junit.Assert.assertArrayEquals(collectionArray2, new java.util.Collection[] { null });
        org.junit.Assert.assertNotNull(itorBaseStreamCollectionArray3);
        org.junit.Assert.assertArrayEquals(itorBaseStreamCollectionArray3, new java.util.Collection[] { null });
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        org.apache.commons.collections4.list.GrowthList<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>> iterableInvokerTransformerItorList0 = new org.apache.commons.collections4.list.GrowthList<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>();
        org.apache.commons.collections4.multimap.HashSetValuedHashMap<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>> invokerTransformerItorListHashSetValuedHashMap1 = new org.apache.commons.collections4.multimap.HashSetValuedHashMap<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>>();
        boolean boolean2 = iterableInvokerTransformerItorList0.equals((Object) invokerTransformerItorListHashSetValuedHashMap1);
        java.util.ListIterator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>> iterableInvokerTransformerItorItor3 = iterableInvokerTransformerItorList0.listIterator();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(iterableInvokerTransformerItorItor3);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        org.apache.commons.collections4.comparators.BooleanComparator booleanComparator0 = org.apache.commons.collections4.comparators.BooleanComparator.getTrueFirstComparator();
        org.junit.Assert.assertNotNull(booleanComparator0);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        java.util.StringTokenizer stringTokenizer0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<String> strList1 = EnumerationUtils.toList(stringTokenizer0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        org.apache.commons.collections4.collection.CompositeCollection<org.apache.commons.collections4.multiset.HashMultiSet<ResettableIterator<Comparable<String>>>> comparableItorCollectionCollection0 = new org.apache.commons.collections4.collection.CompositeCollection<org.apache.commons.collections4.multiset.HashMultiSet<ResettableIterator<Comparable<String>>>>();
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet0 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        org.apache.commons.collections4.set.CompositeSet<CharSequence> charSequenceSet1 = new org.apache.commons.collections4.set.CompositeSet<CharSequence>();
        charSequenceSet0.removeComposited((java.util.Set<CharSequence>) charSequenceSet1);
        int int3 = charSequenceSet0.size();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        org.apache.commons.collections4.keyvalue.DefaultKeyValue<Class<?>[], java.util.Collection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>[]> wildcardClassArrayDefaultKeyValue0 = new org.apache.commons.collections4.keyvalue.DefaultKeyValue<Class<?>[], java.util.Collection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>[]>();
        Class<?>[] wildcardClassArray1 = wildcardClassArrayDefaultKeyValue0.getKey();
        org.junit.Assert.assertNull(wildcardClassArray1);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain1 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorList2 = new java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>();
        boolean boolean3 = abstractMultiSetArrayComparatorList2.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain0);
        boolean boolean4 = abstractMultiSetArrayComparatorList2.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain1);
        boolean boolean6 = abstractMultiSetArrayComparatorList2.equals((Object) 0.0f);
        int int8 = abstractMultiSetArrayComparatorList2.lastIndexOf((Object) 1.0d);
        org.apache.commons.collections4.set.ListOrderedSet<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorSet9 = org.apache.commons.collections4.set.ListOrderedSet.listOrderedSet((java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>) abstractMultiSetArrayComparatorList2);
        java.util.function.UnaryOperator<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorUnaryOperator10 = null;
        // The following exception was thrown during execution in test generation
        try {
            abstractMultiSetArrayComparatorList2.replaceAll(abstractMultiSetArrayComparatorUnaryOperator10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNotNull(abstractMultiSetArrayComparatorSet9);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        org.apache.commons.collections4.map.PassiveExpiringMap.ExpirationPolicy<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, Predicate> itorIterableInvokerTransformerExpirationPolicy0 = null;
        java.util.Map<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, Predicate> itorIterableInvokerTransformerMap1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.map.PassiveExpiringMap<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, Predicate> itorIterableInvokerTransformerMap2 = new org.apache.commons.collections4.map.PassiveExpiringMap<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, Predicate>(itorIterableInvokerTransformerExpirationPolicy0, itorIterableInvokerTransformerMap1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: map");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>> itorCollectionItorIteratorEnumeration0 = new org.apache.commons.collections4.iterators.IteratorEnumeration<ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>();
        java.util.Iterator<? extends ResettableListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>> wildcardItor1 = itorCollectionItorIteratorEnumeration0.getIterator();
        org.junit.Assert.assertNull(wildcardItor1);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain1 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        boolean boolean2 = abstractMultiSetArrayComparatorChain1.isLocked();
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain3 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        boolean boolean4 = abstractMultiSetArrayComparatorChain3.isLocked();
        java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorList5 = new java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>();
        boolean boolean6 = abstractMultiSetArrayComparatorList5.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain0);
        boolean boolean7 = abstractMultiSetArrayComparatorList5.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain1);
        boolean boolean8 = abstractMultiSetArrayComparatorList5.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain3);
        boolean boolean10 = abstractMultiSetArrayComparatorList5.remove((Object) '4');
        Object obj11 = abstractMultiSetArrayComparatorList5.clone();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(obj11);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        int int0 = org.apache.commons.collections4.bloomfilter.BloomFilter.SPARSE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain1 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorList2 = new java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>();
        boolean boolean3 = abstractMultiSetArrayComparatorList2.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain0);
        boolean boolean4 = abstractMultiSetArrayComparatorList2.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain1);
        boolean boolean6 = abstractMultiSetArrayComparatorList2.equals((Object) 0.0f);
        ResettableListIterator<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorItor7 = IteratorUtils.loopingListIterator((java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>) abstractMultiSetArrayComparatorList2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(abstractMultiSetArrayComparatorItor7);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        OrderedMapIterator orderedMapIterator0 = IteratorUtils.EMPTY_ORDERED_MAP_ITERATOR;
        org.junit.Assert.assertNotNull(orderedMapIterator0);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        java.util.LinkedHashSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>> iterableInvokerTransformerEntrySet0 = new java.util.LinkedHashSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>();
        org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>> itorIterableInvokerTransformerItor1 = new org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>((java.util.Set<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>) iterableInvokerTransformerEntrySet0);
        java.util.ArrayList<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>> invokerTransformerEntrySetList2 = new java.util.ArrayList<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>();
        boolean boolean3 = invokerTransformerEntrySetList2.add((java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>) iterableInvokerTransformerEntrySet0);
        org.apache.commons.collections4.collection.CompositeCollection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>> invokerTransformerEntrySetCollection4 = new org.apache.commons.collections4.collection.CompositeCollection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>((java.util.Collection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>) invokerTransformerEntrySetList2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        java.util.LinkedHashSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.properties.PropertiesFactory>> iterableInvokerTransformerEntrySet0 = new java.util.LinkedHashSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.properties.PropertiesFactory>>();
        org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.properties.PropertiesFactory> itorIterableInvokerTransformerItor1 = new org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.properties.PropertiesFactory>((java.util.Set<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, org.apache.commons.collections4.properties.PropertiesFactory>>) iterableInvokerTransformerEntrySet0);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        org.apache.commons.collections4.map.ConcurrentReferenceHashMap.ReferenceType referenceType0 = org.apache.commons.collections4.map.ConcurrentReferenceHashMap.ReferenceType.STRONG;
        org.junit.Assert.assertTrue("'" + referenceType0 + "' != '" + org.apache.commons.collections4.map.ConcurrentReferenceHashMap.ReferenceType.STRONG + "'", referenceType0.equals(org.apache.commons.collections4.map.ConcurrentReferenceHashMap.ReferenceType.STRONG));
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        Iterable[] iterableArray1 = new Iterable[0];
        @SuppressWarnings("unchecked")
        Iterable<? extends org.apache.commons.collections4.map.FixedSizeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>>[] wildcardIterableArray2 = (Iterable<? extends org.apache.commons.collections4.map.FixedSizeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>>[]) iterableArray1;
        org.apache.commons.collections4.iterators.CartesianProductIterator<org.apache.commons.collections4.map.FixedSizeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>> invokerTransformerItorMapItor3 = new org.apache.commons.collections4.iterators.CartesianProductIterator<org.apache.commons.collections4.map.FixedSizeMap<org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>, java.util.AbstractList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>>(wildcardIterableArray2);
        org.junit.Assert.assertNotNull(iterableArray1);
        org.junit.Assert.assertArrayEquals(iterableArray1, new Iterable[] {});
        org.junit.Assert.assertNotNull(wildcardIterableArray2);
        org.junit.Assert.assertArrayEquals(wildcardIterableArray2, new Iterable[] {});
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        org.apache.commons.collections4.list.GrowthList<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>> iterableInvokerTransformerItorList0 = new org.apache.commons.collections4.list.GrowthList<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>();
        MapIterator<Throwable, org.apache.commons.collections4.queue.CircularFifoQueue<CharSequence>> throwableItor1 = IteratorUtils.emptyMapIterator();
        int int2 = iterableInvokerTransformerItorList0.indexOf((Object) throwableItor1);
        org.junit.Assert.assertNotNull(throwableItor1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        org.apache.commons.collections4.map.HashedMap<CharSequence, org.apache.commons.collections4.iterators.IteratorOperations<Comparable<String>>> charSequenceMap1 = new org.apache.commons.collections4.map.HashedMap<CharSequence, org.apache.commons.collections4.iterators.IteratorOperations<Comparable<String>>>((int) 'a');
        CharSequence[] charSequenceArray3 = new CharSequence[] { "[]" };
        java.util.LinkedHashSet<CharSequence> charSequenceSet4 = new java.util.LinkedHashSet<CharSequence>();
        boolean boolean5 = java.util.Collections.addAll((java.util.Collection<CharSequence>) charSequenceSet4, charSequenceArray3);
        org.apache.commons.collections4.set.ListOrderedSet<CharSequence> charSequenceSet6 = org.apache.commons.collections4.set.ListOrderedSet.listOrderedSet((java.util.Set<CharSequence>) charSequenceSet4);
        org.apache.commons.collections4.iterators.IteratorOperations<Comparable<String>> strComparableItor7 = charSequenceMap1.remove((Object) charSequenceSet4);
        int int8 = charSequenceMap1.size();
        org.junit.Assert.assertNotNull(charSequenceArray3);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(charSequenceSet6);
        org.junit.Assert.assertNull(strComparableItor7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        java.util.Comparator<Boolean> booleanComparator1 = ComparatorUtils.booleanComparator(false);
        org.junit.Assert.assertNotNull(booleanComparator1);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        int int0 = org.apache.commons.collections4.bloomfilter.BloomFilter.SPARSE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain0 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        boolean boolean1 = abstractMultiSetArrayComparatorChain0.isLocked();
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain2 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>> abstractMultiSetArrayComparatorList3 = new java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>();
        boolean boolean4 = abstractMultiSetArrayComparatorList3.add((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain2);
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain5 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>((java.util.List<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>) abstractMultiSetArrayComparatorList3);
        java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparator6 = ComparatorUtils.reversedComparator((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain5);
        abstractMultiSetArrayComparatorChain0.addComparator(abstractMultiSetArrayComparator6);
        org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]> abstractMultiSetArrayComparatorChain8 = new org.apache.commons.collections4.comparators.ComparatorChain<org.apache.commons.collections4.multiset.AbstractMultiSet[]>();
        abstractMultiSetArrayComparatorChain0.addComparator((java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>) abstractMultiSetArrayComparatorChain8);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(abstractMultiSetArrayComparator6);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        OrderedIterator orderedIterator0 = IteratorUtils.EMPTY_ORDERED_ITERATOR;
        org.junit.Assert.assertNotNull(orderedIterator0);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        org.apache.commons.collections4.multimap.HashSetValuedHashMap<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>> invokerTransformerItorListHashSetValuedHashMap0 = new org.apache.commons.collections4.multimap.HashSetValuedHashMap<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>>();
        MapIterator<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>> invokerTransformerItorListItor1 = invokerTransformerItorListHashSetValuedHashMap0.mapIterator();
        org.apache.commons.collections4.list.GrowthList<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>> iterableInvokerTransformerItorList2 = new org.apache.commons.collections4.list.GrowthList<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>();
        java.util.ListIterator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>> iterableInvokerTransformerItorItor3 = iterableInvokerTransformerItorList2.listIterator();
        Bag<KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>> comparableItorKeyValueCollection4 = MultiMapUtils.getValuesAsBag((MultiValuedMap<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>>) invokerTransformerItorListHashSetValuedHashMap0, (org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>) iterableInvokerTransformerItorList2);
        // The following exception was thrown during execution in test generation
        try {
            java.util.ListIterator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>> iterableInvokerTransformerItorItor6 = iterableInvokerTransformerItorList2.listIterator(2);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 2");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(invokerTransformerItorListItor1);
        org.junit.Assert.assertNotNull(iterableInvokerTransformerItorItor3);
        org.junit.Assert.assertNotNull(comparableItorKeyValueCollection4);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        CharSequence[] charSequenceArray1 = new CharSequence[] { "hi!" };
        org.apache.commons.collections4.queue.CircularFifoQueue<CharSequence> charSequenceQueue2 = new org.apache.commons.collections4.queue.CircularFifoQueue<CharSequence>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<CharSequence>) charSequenceQueue2, charSequenceArray1);
        boolean boolean5 = charSequenceQueue2.add((CharSequence) "");
        charSequenceQueue2.clear();
        // The following exception was thrown during execution in test generation
        try {
            CharSequence charSequence7 = charSequenceQueue2.element();
            org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException; message: queue is empty");
        } catch (java.util.NoSuchElementException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charSequenceArray1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        org.apache.commons.collections4.iterators.TransformIterator<org.apache.commons.collections4.list.AbstractListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, OrderedBidiMap<String, org.apache.commons.collections4.functors.ComparatorPredicate.Criterion>> invokerTransformerItorListItor0 = new org.apache.commons.collections4.iterators.TransformIterator<org.apache.commons.collections4.list.AbstractListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, OrderedBidiMap<String, org.apache.commons.collections4.functors.ComparatorPredicate.Criterion>>();
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.collections4.map.LRUMap<org.apache.commons.collections4.bidimap.AbstractDualBidiMap<java.util.function.Supplier<Object[]>, org.apache.commons.collections4.properties.PropertiesFactory>, org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>> objArraySupplierMapMap2 = new org.apache.commons.collections4.map.LRUMap<org.apache.commons.collections4.bidimap.AbstractDualBidiMap<java.util.function.Supplier<Object[]>, org.apache.commons.collections4.properties.PropertiesFactory>, org.apache.commons.collections4.iterators.ObjectArrayListIterator<org.apache.commons.collections4.multiset.AbstractMultiSet<ResettableIterator<Comparable<String>>>>>((int) (byte) -1, true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Initial capacity must be a non negative number");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        org.apache.commons.collections4.properties.PropertiesFactory propertiesFactory0 = org.apache.commons.collections4.properties.PropertiesFactory.INSTANCE;
        java.io.InputStream inputStream1 = null;
        org.apache.commons.collections4.properties.OrderedPropertiesFactory orderedPropertiesFactory2 = org.apache.commons.collections4.properties.OrderedPropertiesFactory.INSTANCE;
        java.io.InputStream inputStream3 = null;
        org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat propertyFormat4 = org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML;
        org.apache.commons.collections4.properties.OrderedProperties orderedProperties5 = orderedPropertiesFactory2.load(inputStream3, propertyFormat4);
        java.util.Properties properties6 = propertiesFactory0.load(inputStream1, propertyFormat4);
        org.junit.Assert.assertNotNull(propertiesFactory0);
        org.junit.Assert.assertNotNull(orderedPropertiesFactory2);
        org.junit.Assert.assertTrue("'" + propertyFormat4 + "' != '" + org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML + "'", propertyFormat4.equals(org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.XML));
        org.junit.Assert.assertNull(orderedProperties5);
        org.junit.Assert.assertNull(properties6);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        org.apache.commons.collections4.multimap.HashSetValuedHashMap<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>> invokerTransformerItorListHashSetValuedHashMap0 = new org.apache.commons.collections4.multimap.HashSetValuedHashMap<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>>();
        MapIterator<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>> invokerTransformerItorListItor1 = invokerTransformerItorListHashSetValuedHashMap0.mapIterator();
        org.apache.commons.collections4.multimap.HashSetValuedHashMap<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>> invokerTransformerItorListHashSetValuedHashMap2 = new org.apache.commons.collections4.multimap.HashSetValuedHashMap<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>>((MultiValuedMap<org.apache.commons.collections4.list.AbstractSerializableListDecorator<MapIterator<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>, KeyValue<java.util.Iterator<Comparable<String>>, java.io.Serializable>>) invokerTransformerItorListHashSetValuedHashMap0);
        org.junit.Assert.assertNotNull(invokerTransformerItorListItor1);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat propertyFormat0 = org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.PROPERTIES;
        org.junit.Assert.assertTrue("'" + propertyFormat0 + "' != '" + org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.PROPERTIES + "'", propertyFormat0.equals(org.apache.commons.collections4.properties.AbstractPropertiesFactory.PropertyFormat.PROPERTIES));
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        org.apache.commons.collections4.bidimap.DualTreeBidiMap<java.util.function.Supplier<Object[]>, org.apache.commons.collections4.properties.PropertiesFactory> objArraySupplierMap0 = new org.apache.commons.collections4.bidimap.DualTreeBidiMap<java.util.function.Supplier<Object[]>, org.apache.commons.collections4.properties.PropertiesFactory>();
        java.util.Comparator<? super java.util.function.Supplier<Object[]>> wildcardComparator1 = objArraySupplierMap0.comparator();
        org.junit.Assert.assertNull(wildcardComparator1);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        org.apache.commons.collections4.bidimap.DualTreeBidiMap<java.util.function.Supplier<Object[]>, org.apache.commons.collections4.properties.PropertiesFactory> objArraySupplierMap0 = new org.apache.commons.collections4.bidimap.DualTreeBidiMap<java.util.function.Supplier<Object[]>, org.apache.commons.collections4.properties.PropertiesFactory>();
        java.util.Comparator<? super org.apache.commons.collections4.properties.PropertiesFactory> wildcardComparator1 = objArraySupplierMap0.valueComparator();
        org.junit.Assert.assertNull(wildcardComparator1);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        Closure<? super CharSequence> wildcardClosure0 = null;
        Closure[] closureArray2 = new Closure[1];
        @SuppressWarnings("unchecked")
        Closure<? super CharSequence>[] wildcardClosureArray3 = (Closure<? super CharSequence>[]) closureArray2;
        wildcardClosureArray3[0] = wildcardClosure0;
        org.apache.commons.collections4.functors.ChainedClosure<CharSequence> charSequenceChainedClosure6 = new org.apache.commons.collections4.functors.ChainedClosure<CharSequence>(wildcardClosureArray3);
        org.apache.commons.collections4.functors.ChainedClosure<CharSequence> charSequenceChainedClosure7 = new org.apache.commons.collections4.functors.ChainedClosure<CharSequence>(wildcardClosureArray3);
        org.junit.Assert.assertNotNull(closureArray2);
        org.junit.Assert.assertArrayEquals(closureArray2, new Closure[] { null });
        org.junit.Assert.assertNotNull(wildcardClosureArray3);
        org.junit.Assert.assertArrayEquals(wildcardClosureArray3, new Closure[] { null });
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        int[] intArray4 = new int[] { 100, 6, (short) 10, 0 };
        org.apache.commons.collections4.bloomfilter.IndexExtractor indexExtractor5 = org.apache.commons.collections4.bloomfilter.IndexExtractor.fromIndexArray(intArray4);
        org.apache.commons.collections4.bloomfilter.CellExtractor cellExtractor6 = org.apache.commons.collections4.bloomfilter.CellExtractor.from(indexExtractor5);
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] { 100, 6, 10, 0 });
        org.junit.Assert.assertNotNull(indexExtractor5);
        org.junit.Assert.assertNotNull(cellExtractor6);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        java.util.Iterator<Comparable<String>> strComparableItor0 = null;
        org.apache.commons.collections4.iterators.ExtendedIterator<Comparable<String>> strComparableItor1 = org.apache.commons.collections4.iterators.ExtendedIterator.createNoRemove(strComparableItor0);
        org.junit.Assert.assertNotNull(strComparableItor1);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        org.apache.commons.collections4.set.ListOrderedSet<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> abstractMultiSetArrayComparatorListSet0 = new org.apache.commons.collections4.set.ListOrderedSet<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>();
        org.apache.commons.collections4.map.SingletonMap<org.apache.commons.collections4.set.AbstractSerializableSetDecorator<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>, Comparable<String>> comparatorListSetMap2 = new org.apache.commons.collections4.map.SingletonMap<org.apache.commons.collections4.set.AbstractSerializableSetDecorator<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>, Comparable<String>>((org.apache.commons.collections4.set.AbstractSerializableSetDecorator<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>) abstractMultiSetArrayComparatorListSet0, (Comparable<String>) "");
        boolean boolean3 = comparatorListSetMap2.isFull();
        boolean boolean4 = comparatorListSetMap2.isEmpty();
        boolean boolean5 = comparatorListSetMap2.isEmpty();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        org.apache.commons.collections4.set.ListOrderedSet<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>> abstractMultiSetArrayComparatorListSet0 = new org.apache.commons.collections4.set.ListOrderedSet<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>();
        String str1 = abstractMultiSetArrayComparatorListSet0.toString();
        org.apache.commons.collections4.multiset.HashMultiSet<ResettableIterator<Comparable<String>>> strComparableItorCollection2 = new org.apache.commons.collections4.multiset.HashMultiSet<ResettableIterator<Comparable<String>>>();
        boolean boolean3 = strComparableItorCollection2.isEmpty();
        boolean boolean4 = abstractMultiSetArrayComparatorListSet0.removeAll((java.util.Collection<ResettableIterator<Comparable<String>>>) strComparableItorCollection2);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "[]" + "'", str1, "[]");
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        Transformer<org.apache.commons.collections4.map.ConcurrentReferenceHashMap.ReferenceType, org.apache.commons.collections4.map.ConcurrentReferenceHashMap.ReferenceType> referenceTypeTransformer0 = TransformerUtils.nopTransformer();
        org.junit.Assert.assertNotNull(referenceTypeTransformer0);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        java.util.Comparator<java.util.RandomAccess> randomAccessComparator0 = null;
        org.apache.commons.collections4.comparators.ComparatorChain<java.util.RandomAccess> randomAccessComparatorChain2 = new org.apache.commons.collections4.comparators.ComparatorChain<java.util.RandomAccess>(randomAccessComparator0, false);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        org.apache.commons.collections4.bidimap.DualTreeBidiMap<java.util.function.Supplier<Object[]>, org.apache.commons.collections4.properties.PropertiesFactory> objArraySupplierMap0 = new org.apache.commons.collections4.bidimap.DualTreeBidiMap<java.util.function.Supplier<Object[]>, org.apache.commons.collections4.properties.PropertiesFactory>();
        Factory<Object[]> objArrayFactory1 = FactoryUtils.nullFactory();
        // The following exception was thrown during execution in test generation
        try {
            java.util.SortedMap<java.util.function.Supplier<Object[]>, org.apache.commons.collections4.properties.PropertiesFactory> objArraySupplierMap2 = objArraySupplierMap0.tailMap((java.util.function.Supplier<Object[]>) objArrayFactory1);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: org.apache.commons.collections4.functors.ConstantFactory cannot be cast to java.lang.Comparable");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(objArrayFactory1);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        org.apache.commons.collections4.bidimap.TreeBidiMap<String, org.apache.commons.collections4.functors.ComparatorPredicate.Criterion> strMap0 = new org.apache.commons.collections4.bidimap.TreeBidiMap<String, org.apache.commons.collections4.functors.ComparatorPredicate.Criterion>();
        OrderedMapIterator<String, org.apache.commons.collections4.functors.ComparatorPredicate.Criterion> strItor1 = strMap0.mapIterator();
        org.apache.commons.collections4.map.DefaultedMap<org.apache.commons.collections4.collection.AbstractCollectionDecorator<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>, BidiMap<String, org.apache.commons.collections4.functors.ComparatorPredicate.Criterion>> comparatorListCollectionMap2 = new org.apache.commons.collections4.map.DefaultedMap<org.apache.commons.collections4.collection.AbstractCollectionDecorator<java.util.ArrayList<java.util.Comparator<org.apache.commons.collections4.multiset.AbstractMultiSet[]>>>, BidiMap<String, org.apache.commons.collections4.functors.ComparatorPredicate.Criterion>>((BidiMap<String, org.apache.commons.collections4.functors.ComparatorPredicate.Criterion>) strMap0);
        org.apache.commons.collections4.functors.ComparatorPredicate.Criterion criterion4 = org.apache.commons.collections4.functors.ComparatorPredicate.Criterion.EQUAL;
        org.apache.commons.collections4.functors.ComparatorPredicate.Criterion criterion5 = strMap0.put("[]", criterion4);
        String str7 = strMap0.previousKey("");
        org.junit.Assert.assertNotNull(strItor1);
        org.junit.Assert.assertTrue("'" + criterion4 + "' != '" + org.apache.commons.collections4.functors.ComparatorPredicate.Criterion.EQUAL + "'", criterion4.equals(org.apache.commons.collections4.functors.ComparatorPredicate.Criterion.EQUAL));
        org.junit.Assert.assertNull(criterion5);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        java.util.Collection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>> invokerTransformerEntrySetCollection0 = null;
        java.util.Collection[] collectionArray2 = new java.util.Collection[1];
        @SuppressWarnings("unchecked")
        java.util.Collection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>[] entrySetCollectionArray3 = (java.util.Collection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>[]) collectionArray2;
        entrySetCollectionArray3[0] = invokerTransformerEntrySetCollection0;
        org.apache.commons.collections4.collection.CompositeCollection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>> invokerTransformerEntrySetCollection6 = new org.apache.commons.collections4.collection.CompositeCollection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>(entrySetCollectionArray3);
        org.apache.commons.collections4.collection.CompositeCollection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>> invokerTransformerEntrySetCollection7 = new org.apache.commons.collections4.collection.CompositeCollection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>((java.util.Collection<java.util.AbstractSet<java.util.Map.Entry<org.apache.commons.collections4.functors.InvokerTransformer<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>, java.util.function.Function<Iterable<ResettableIterator<Comparable<String>>>, MultiSet<ResettableIterator<Comparable<String>>>>>>>) invokerTransformerEntrySetCollection6);
        org.junit.Assert.assertNotNull(collectionArray2);
        org.junit.Assert.assertArrayEquals(collectionArray2, new java.util.Collection[] { null });
        org.junit.Assert.assertNotNull(entrySetCollectionArray3);
        org.junit.Assert.assertArrayEquals(entrySetCollectionArray3, new java.util.Collection[] { null });
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        org.apache.commons.collections4.map.AbstractReferenceMap.ReferenceStrength referenceStrength0 = org.apache.commons.collections4.map.AbstractReferenceMap.ReferenceStrength.HARD;
        org.junit.Assert.assertTrue("'" + referenceStrength0 + "' != '" + org.apache.commons.collections4.map.AbstractReferenceMap.ReferenceStrength.HARD + "'", referenceStrength0.equals(org.apache.commons.collections4.map.AbstractReferenceMap.ReferenceStrength.HARD));
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        org.apache.commons.collections4.bloomfilter.Shape shape2 = org.apache.commons.collections4.bloomfilter.Shape.fromKM(10, 100);
        java.util.function.IntPredicate intPredicate3 = null;
        java.util.function.IntPredicate intPredicate4 = org.apache.commons.collections4.bloomfilter.IndexFilter.create(shape2, intPredicate3);
        org.junit.Assert.assertNotNull(shape2);
        org.junit.Assert.assertNotNull(intPredicate4);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        Factory factory0 = org.apache.commons.collections4.functors.ExceptionFactory.INSTANCE;
        org.junit.Assert.assertNotNull(factory0);
    }
}

