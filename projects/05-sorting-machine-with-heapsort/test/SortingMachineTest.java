import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

import components.sortingmachine.SortingMachine;

/**
 * JUnit test fixture for {@code SortingMachine<String>}'s constructor and
 * kernel methods.
 *
 * @author Eric Zhou
 *
 */
public abstract class SortingMachineTest {

    /**
     * Invokes the appropriate {@code SortingMachine} constructor for the
     * implementation under test and returns the result.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @return the new {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures constructorTest = (true, order, {})
     */
    protected abstract SortingMachine<String> constructorTest(
            Comparator<String> order);

    /**
     * Invokes the appropriate {@code SortingMachine} constructor for the
     * reference implementation and returns the result.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @return the new {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures constructorRef = (true, order, {})
     */
    protected abstract SortingMachine<String> constructorRef(
            Comparator<String> order);

    /**
     *
     * Creates and returns a {@code SortingMachine<String>} of the
     * implementation under test type with the given entries and mode.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @param insertionMode
     *            flag indicating the machine mode
     * @param args
     *            the entries for the {@code SortingMachine}
     * @return the constructed {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * createFromArgsTest = (insertionMode, order, [multiset of entries in args])
     * </pre>
     */
    private SortingMachine<String> createFromArgsTest(Comparator<String> order,
            boolean insertionMode, String... args) {
        SortingMachine<String> sm = this.constructorTest(order);
        for (int i = 0; i < args.length; i++) {
            sm.add(args[i]);
        }
        if (!insertionMode) {
            sm.changeToExtractionMode();
        }
        return sm;
    }

    /**
     *
     * Creates and returns a {@code SortingMachine<String>} of the reference
     * implementation type with the given entries and mode.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @param insertionMode
     *            flag indicating the machine mode
     * @param args
     *            the entries for the {@code SortingMachine}
     * @return the constructed {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * createFromArgsRef = (insertionMode, order, [multiset of entries in args])
     * </pre>
     */
    private SortingMachine<String> createFromArgsRef(Comparator<String> order,
            boolean insertionMode, String... args) {
        SortingMachine<String> sm = this.constructorRef(order);
        for (int i = 0; i < args.length; i++) {
            sm.add(args[i]);
        }
        if (!insertionMode) {
            sm.changeToExtractionMode();
        }
        return sm;
    }

    /**
     * Comparator<String> implementation to be used in all test cases. Compare
     * {@code String}s in lexicographic order.
     */
    private static class StringLT implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }

    }

    /**
     * Comparator instance to be used in all test cases.
     */
    private static final StringLT ORDER = new StringLT();

    /*
     * Sample test cases.
     */

    /**
     * test for constructor.
     */
    @Test
    public final void testConstructor() {
        SortingMachine<String> m = this.constructorTest(ORDER);
        SortingMachine<String> mExpected = this.constructorRef(ORDER);
        assertEquals(mExpected, m);
    }

    /**
     * test for add in empty.
     */
    @Test
    public final void testAddEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "green");
        m.add("green");
        assertEquals(mExpected, m);
    }

    // test cases for add

    /**
     * add in nonempty (one element).
     */
    @Test
    public final void testAddNonEmptyOneElement() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "a");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "a", "b");
        m.add("b");
        assertEquals(mExpected, m);
    }

    /**
     * add in nonempty (more than one element).
     */
    @Test
    public final void testAddNonEmptyMoreThanOneElement() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "a",
                "b");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "a", "b", "c");
        m.add("c");
        assertEquals(mExpected, m);
    }

    // test cases for changeToExtractionMode

    /**
     * changeToExtractionMode in empty.
     */
    @Test
    public final void testchangeToExtractionModeEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false);
        m.changeToExtractionMode();
        assertEquals(mExpected, m);
    }

    /**
     * changeToExtractionMode in nonempty (one element).
     */
    @Test
    public final void testchangeToExtractionModeNonemptyOne() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "a");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "a");
        m.changeToExtractionMode();
        assertEquals(mExpected, m);
    }

    /**
     * changeToExtractionMode in nonempty (more than one element).
     */
    @Test
    public final void testchangeToExtractionModeNonemptyMore() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "a",
                "b");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "a", "b");
        m.changeToExtractionMode();
        assertEquals(mExpected, m);
    }

    // test cases for removeFirst

    /**
     * removeFirst in one element.
     */
    @Test
    public final void testRemoveFirstInOneElement() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "a");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false);
        String actual = m.removeFirst();
        String expected = "a";
        assertEquals(mExpected, m);
        assertEquals(expected, actual);
    }

    /**
     * removeFirst in more than one element (sorted).
     */
    @Test
    public final void testRemoveFirstInOneMoreElementSorted() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "a",
                "b", "c");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "b", "c");
        String actual = m.removeFirst();
        String expected = "a";
        assertEquals(mExpected, m);
        assertEquals(expected, actual);
    }

    /**
     * removeFirst in more than one element (Unsorted).
     */
    @Test
    public final void testRemoveFirstInOneMoreElementUnsorted() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "b",
                "a", "c");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "b", "c");
        String actual = m.removeFirst();
        String expected = "a";
        assertEquals(mExpected, m);
        assertEquals(expected, actual);
    }

    // test cases for isInInsertionMode

    /**
     * result is true.
     */
    @Test
    public final void testisInInsertionModeTrue() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "b",
                "a", "c");
        boolean actual = m.isInInsertionMode();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    /**
     * result is false.
     */
    @Test
    public final void testisInInsertionModeFalse() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "b",
                "a", "c");
        boolean actual = m.isInInsertionMode();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    // test cases for order

    /**
     * test order for insetion mode.
     */
    @Test
    public final void testOrderForInsertionMode() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "b",
                "a", "c");
        assertEquals(ORDER, m.order());
    }

    /**
     * test order for extraction mode.
     */
    @Test
    public final void testOrderForExtractionMode() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "b",
                "a", "c");
        assertEquals(ORDER, m.order());
    }

    // test cases for size

    /**
     * test size for insetion mode (empty).
     */
    @Test
    public final void testSizeForInsertionModeEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true);
        int actual = m.size();
        assertEquals(mExpected, m);
        assertEquals(0, actual);
    }

    /**
     * test size for insetion mode (one element).
     */
    @Test
    public final void testSizeForInsertionModeOne() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "a");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "a");
        int actual = m.size();
        assertEquals(mExpected, m);
        assertEquals(1, actual);
    }

    /**
     * test size for insetion mode (more than one element).
     */
    @Test
    public final void testSizeForInsertionModeMore() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "a",
                "b", "c");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "a", "b", "c");
        int actual = m.size();
        assertEquals(mExpected, m);
        assertEquals(3, actual);
    }

    /**
     * test size for extraction mode (empty).
     */
    @Test
    public final void testSizeForExtractionModeEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false);
        int actual = m.size();
        assertEquals(mExpected, m);
        assertEquals(0, actual);
    }

    /**
     * test size for extraction mode (one element).
     */
    @Test
    public final void testSizeForExtractionModeOne() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "a");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "a");
        int actual = m.size();
        assertEquals(mExpected, m);
        assertEquals(1, actual);
    }

    /**
     * test size for extraction mode (more than one element).
     */
    @Test
    public final void testSizeForExtractionModeMore() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false, "a",
                "b", "c");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "a", "b", "c");
        int actual = m.size();
        assertEquals(mExpected, m);
        assertEquals(3, actual);
    }

}
