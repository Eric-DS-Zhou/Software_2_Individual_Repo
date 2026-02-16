import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Eric Zhou
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

    /**
     *  magic number.
     */

    private final int three = 3;

    // Test constructors

    /**
     * Test the nonarg consturctor.
     */
    @Test
    public void testEmptyConstructor() {
        Map<String, String> test = this.constructorTest();
        Map<String, String> ref = this.constructorRef();

        assertEquals(ref, test);
    }

    // Test add

    /**
     * add to the empty map.
     */
    @Test
    public void addToEmpty() {
        Map<String, String> test = this.constructorTest();
        Map<String, String> ref = this.createFromArgsRef("a", "1");

        test.add("a", "1");

        assertEquals(ref, test);

    }

    /**
     * add to the map with one element.
     */
    @Test
    public void addToOneElement() {
        Map<String, String> test = this.createFromArgsTest("a", "1");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2");

        test.add("b", "2");

        assertEquals(ref, test);

    }

    /**
     * add to the map with more than one element.
     */
    @Test
    public void addToMoreThanOneElement() {
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2",
                "c", "3");

        test.add("c", "3");

        assertEquals(ref, test);

    }

    // Test remove

    /**
     * remove the only element.
     */
    @Test
    public void removeTheOnlyElement() {
        Map<String, String> test = this.createFromArgsTest("a", "1");
        Map<String, String> ref = this.createFromArgsRef();

        Map.Pair<String, String> removed = test.remove("a");

        assertEquals("a", removed.key());
        assertEquals("1", removed.value());
        assertEquals(ref, test);

    }

    /**
     * remove element (normal).
     */
    @Test
    public void removeNormalElement() {
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2",
                "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "c", "3");

        Map.Pair<String, String> removed = test.remove("b");

        assertEquals("b", removed.key());
        assertEquals("2", removed.value());
        assertEquals(ref, test);

    }

    // Test removeAny

    /**
     * removeAny from the map with only one element.
     */
    @Test
    public void removeAnyFromOnlyOneElement() {
        Map<String, String> test = this.createFromArgsTest("a", "1");
        Map<String, String> ref = this.createFromArgsRef();

        Map.Pair<String, String> removed = test.removeAny();

        assertEquals("a", removed.key());
        assertEquals("1", removed.value());
        assertEquals(ref, test);

    }

    /**
     * removeAny from the normal map.
     */
    @Test
    public void removeAnyNormalMap() {
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2",
                "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2",
                "c", "3");

        Map.Pair<String, String> removed = test.removeAny();
        Map.Pair<String, String> removedref = ref.remove(removed.key());

        assertEquals(removedref, removed);
        assertEquals(ref, test);

    }

    // Test value

    /**
     * test the first value of map.
     */
    @Test
    public void getTheFirstValue() {
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2",
                "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2",
                "c", "3");

        String value = test.value("a");

        assertEquals("1", value);
        assertEquals(ref, test);

    }

    /**
     * test the middle value of map.
     */
    @Test
    public void getThemiddleValue() {
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2",
                "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2",
                "c", "3");

        String value = test.value("b");

        assertEquals("2", value);
        assertEquals(ref, test);

    }

    /**
     * test the last value of map.
     */
    @Test
    public void getTheLastValue() {
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2",
                "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2",
                "c", "3");

        String value = test.value("c");

        assertEquals("3", value);
        assertEquals(ref, test);

    }

    // Test haskey

    /**
     * empty map.
     */
    @Test
    public void emptyhasKeyFalse() {
        Map<String, String> test = this.createFromArgsTest();
        Map<String, String> ref = this.createFromArgsRef();

        boolean found = test.hasKey("a");

        assertEquals(false, found);
        assertEquals(ref, test);

    }

    /**
     * Nonempty map & the result is true.
     */
    @Test
    public void nonEmptyhasKeyTrue() {
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2",
                "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2",
                "c", "3");

        boolean found = test.hasKey("a");

        assertEquals(true, found);
        assertEquals(ref, test);

    }

    /**
     * Nonempty map & the result is false.
     */
    @Test
    public void nonEmptyhasKeyFalse() {
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2",
                "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2",
                "c", "3");

        boolean found = test.hasKey("d");

        assertEquals(false, found);
        assertEquals(ref, test);

    }

    // Test size

    /**
     * the size is empty.
     */

    @Test
    public void emptySize() {
        Map<String, String> test = this.createFromArgsTest();
        Map<String, String> ref = this.createFromArgsRef();

        assertEquals(0, test.size());
        assertEquals(ref, test);

    }

    /**
     * the size is nonempty.
     */

    @Test
    public void nonEmptySize() {
        Map<String, String> test = this.createFromArgsTest("a", "1", "b", "2",
                "c", "3");
        Map<String, String> ref = this.createFromArgsRef("a", "1", "b", "2",
                "c", "3");

        assertEquals(this.three, test.size());
        assertEquals(ref, test);

    }

}
