import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map.Pair;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class MapTest {

    /**
     * Invokes the appropriate {@code Map} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new map
     * @ensures constructorTest = {}
     */
    protected abstract Map<String, String> constructorTest();

    /**
     * Invokes the appropriate {@code Map} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new map
     * @ensures constructorRef = {}
     */
    protected abstract Map<String, String> constructorRef();

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private Map<String, String> createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private Map<String, String> createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    //test case for constructor

    @Test
    public void testConstructor(){
        Map<String, String> ref = this.constructorRef();
        Map<String, String> test = this.constructorTest();

        assertEquals(ref, test);
    }

    //test cases for add

    //add to empty
    @Test
    public void testAddToEmpty(){
        Map<String, String> ref = this.createFromArgsRef("a", "1");
        Map<String, String> test = this.createFromArgsTest();

        test.add("a", "1");

        assertEquals(ref, test);
    }

    //add to nonempty
    @Test
    public void testAddToNonEmpty(){
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2", "c", "3");
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2");

        test.add("c", "3");

        assertEquals(ref, test);
    }

    //test cases for remove

    //empty after remove
    @Test
    public void testEmptyAfterRemove(){
        Map<String, String> ref = this.createFromArgsRef();
        Map<String, String> test = this.createFromArgsTest("a", "1");

        Pair<String, String> removed = test.remove("a");

        assertEquals("a", removed.key());
        assertEquals("1", removed.value());
        assertEquals(ref, test);
    }

    //nonempty after remove
    @Test
    public void testNonEmptyAfterRemove(){
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2");
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2", "c", "3");

        Pair<String, String> removed = test.remove("c");

        assertEquals("c", removed.key());
        assertEquals("3", removed.value());
        assertEquals(ref, test);
    }

    //test cases for removeAny

    //only one element
    @Test
    public void testRemoveAnyOnlyOneElement(){
        Map<String, String> ref = this.createFromArgsRef();
        Map<String, String> test = this.createFromArgsTest("a", "1");

        Pair<String, String> removed = test.removeAny();

        assertEquals("a", removed.key());
        assertEquals("1", removed.value());
        assertEquals(ref, test);
    }

    //normal removeAny
    @Test
    public void testRemoveAnyNormal(){
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2", "c", "3");
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2", "c", "3");

        Pair<String, String> removed = test.removeAny();

        assertEquals(true, ref.hasKey(removed.key()));
        ref.remove(removed.key());
        assertEquals(ref, test);
    }

    //test cases for value

    @Test
    public void testValue(){
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2", "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2", "c", "3");

        assertEquals("1", test.value("a"));
        assertEquals("2", test.value("b"));
        assertEquals("3", test.value("c"));
        assertEquals(ref, test);
    }

    //test cases for hasKey

    //empty map for hasKey
    @Test
    public void testHasKeyEmpty(){
        Map<String, String> test = this.createFromArgsTest();
        Map<String, String> ref = this.createFromArgsRef();

        assertEquals(false, test.hasKey("a"));
        assertEquals(ref, test);
    }

    //normal case for hasKey
    @Test
    public void testHasKeyNonEmpty(){
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2", "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2", "c", "3");

        assertEquals(true, test.hasKey("a"));
        assertEquals(false, test.hasKey("d"));
        assertEquals(ref, test);
    }

    //test cases for size

    //empty case for size
    @Test
    public void testSizeEmpty(){
        Map<String, String> test = this.createFromArgsTest();
        Map<String, String> ref = this.createFromArgsRef();

        assertEquals(0, test.size());
        assertEquals(ref, test);
    }

    //normal case for size
    @Test
    public void testSizeNonEmpty(){
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2", "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2", "c", "3");

        assertEquals(3, test.size());
        assertEquals(ref, test);
    }

}
