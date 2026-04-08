import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.sortingmachine.SortingMachine;
import components.sortingmachine.SortingMachine1L;

/**
 * Generate an HTML tag cloud from the input file.
 *
 * @author Eric Zhou
 */
public final class TagCloud {

    /**
     * private constrcutor.
     */
    private TagCloud() {

    }

    /**
     * Font size & magic number.
     */
    private static final int MIN_FONT = 11, MAX_FONT = 48;

    /**
     * Separators Set.
     */
    private static final String SEPARATORS = " \t\n\r,-.!?[]';:/\"";

    /**
     * Comparator that compares pairs by count.
     */
    private static final class CountOrder
            implements Comparator<Map.Pair<String, Integer>> {

        @Override
        public int compare(Map.Pair<String, Integer> p1,
                Map.Pair<String, Integer> p2) {
            return p2.value().compareTo(p1.value());
        }
    }

    /**
     * Comparator that compares pairs by word.
     */
    private static final class WordOrder
            implements Comparator<Map.Pair<String, Integer>> {

        @Override
        public int compare(Map.Pair<String, Integer> p1,
                Map.Pair<String, Integer> p2) {
            return p1.key().compareToIgnoreCase(p2.key());
        }
    }

    /**
     * Report whether the character is a separator.
     *
     * @param c
     *            the character to be examined
     * @return the result whether c is a sep
     */
    private static boolean isSep(char c) {
        boolean result = false;

        if (SEPARATORS.indexOf(c) >= 0) {
            result = true;
        }

        return result;
    }

    /**
     * Return the next word or sep.
     *
     * @param text
     *            the aim text
     * @param position
     *            the start point
     * @return next word or sep
     */
    private static String nextWordOrSep(String text, int position) {
        StringBuilder token = new StringBuilder();
        boolean mode = isSep(text.charAt(position));
        int index = position;
        while (index < text.length() && isSep(text.charAt(index)) == mode) {
            token.append(text.charAt(index));
            index++;
        }

        return token.toString();
    }

    /**
     * Counts all words in the input file.
     *
     * @param inFile
     *            the input file
     * @return the map contains words and counts
     */
    private static Map<String, Integer> count(SimpleReader inFile) {
        Map<String, Integer> counts = new Map1L<String, Integer>();

        while (!inFile.atEOS()) {
            String line = inFile.nextLine();
            int position = 0;
            while (position < line.length()) {
                String token = nextWordOrSep(line, position);
                if (!isSep(token.charAt(0))) {
                    String word = token.toLowerCase();

                    if (counts.hasKey(word)) {
                        counts.replaceValue(word, counts.value(word) + 1);
                    } else {
                        counts.add(word, 1);
                    }
                }

                position = position + token.length();
            }
        }

        return counts;
    }

    /**
     * Calculate the font size.
     *
     * @param count
     *            the count for the word
     * @param minCount
     *            the minimum count
     * @param maxCount
     *            the maximum count
     * @return the font size
     */
    private static int fontSize(int count, int minCount, int maxCount) {
        int result = MIN_FONT;

        if (maxCount != minCount) {
            result = MIN_FONT + (count - minCount) * (MAX_FONT - MIN_FONT)
                    / (maxCount - minCount);
        }

        return result;
    }

    /**
     * Print the header of the HTML file.
     *
     * @param out
     *            the output stream
     * @param inputfileName
     *            the name of the input file
     * @param n
     *            the number of words to be expected
     */
    private static void printHeader(SimpleWriter out, String inputfileName,
            int n) {
        out.println("<html>");
        out.println("<head>");
        out.println(
                "<title>Top " + n + " Words in " + inputfileName + "</title>");
        out.println(
                "<link href=\"https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/projects/tag-cloud-generator/data/tagcloud.css\" "
                        + "rel=\"stylesheet\" type=\"text/css\">");
        out.println(
                "<link href=\"tagcloud.css\" rel=\"stylesheet\" type=\"text/css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Top " + n + " Words in " + inputfileName + "</h2>");
        out.println("<hr>");
        out.println("<div class=\"cdiv\">");
        out.println("<p class=\"cbox\">");
    }

    /**
     * Print the footer of the HTML file.
     *
     * @param out
     *            the output stream
     */
    private static void printFooter(SimpleWriter out) {
        out.println("</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Output the words in order.
     *
     * @param out
     *            the output stream
     * @param alpMachine
     *            the sortmachine that restored words in alphabetical order
     * @param minCount
     *            minimum count
     * @param maxCount
     *            maximum count
     */
    private static void outputTags(SimpleWriter out,
            SortingMachine<Map.Pair<String, Integer>> alpMachine, int minCount,
            int maxCount) {
        alpMachine.changeToExtractionMode();

        while (alpMachine.size() > 0) {
            Map.Pair<String, Integer> pair = alpMachine.removeFirst();
            int size = fontSize(pair.value(), minCount, maxCount);

            out.println("<span style=\"cursor: default\" class=\"f" + size
                    + "\" title=\"count: " + pair.value() + "\">" + pair.key()
                    + "</span>");
        }
    }

    /**
     * Select top words.
     *
     * @param countsMap
     *            the map contains words and counts.
     * @param n
     *            top number
     * @param alpMachine
     *            the sorting machine to store the words in alpbetical order
     * @param minMax
     *            the map to store min and max count
     */
    private static void selectTop(Map<String, Integer> countsMap, int n,
            SortingMachine<Map.Pair<String, Integer>> alpMachine,
            Map<String, Integer> minMax) {
        SortingMachine<Map.Pair<String, Integer>> countMachine = new
                            SortingMachine1L<Map.Pair<String, Integer>>(new CountOrder());

        while (countsMap.size() > 0) {
            Map.Pair<String, Integer> pair = countsMap.removeAny();
            countMachine.add(pair);
        }

        countMachine.changeToExtractionMode();

        int num = 0;
        int min = 0;
        int max = 0;
        boolean first = true;

        while (num < n && countMachine.size() > 0) {
            Map.Pair<String, Integer> pair = countMachine.removeFirst();
            int currentCount = pair.value();
            alpMachine.add(pair);

            if (first) {
                min = currentCount;
                max = currentCount;
                first = false;
            } else {
                if (currentCount < min) {
                    min = currentCount;
                }
                if (currentCount > max) {
                    max = currentCount;
                }
            }

            num++;
        }

        minMax.add("min", min);
        minMax.add("max", max);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter the input file name: ");
        String inputFileName = in.nextLine();

        out.print("Enter the output file name: ");
        String outputFileName = in.nextLine();

        out.print("Enter the number of words: ");
        int n = Integer.parseInt(in.nextLine());

        SimpleReader inputFile = new SimpleReader1L(inputFileName);
        SimpleWriter outputFile = new SimpleWriter1L(outputFileName);

        Map<String, Integer> countsMap = count(inputFile);

        SortingMachine<Map.Pair<String, Integer>> alpMachine = new
                        SortingMachine1L<Map.Pair<String, Integer>>(new WordOrder());

        Map<String, Integer> minMax = new Map1L<String, Integer>();

        selectTop(countsMap, n, alpMachine, minMax);

        printHeader(outputFile, inputFileName, n);

        int minCount = minMax.value("min");
        int maxCount = minMax.value("max");
        outputTags(outputFile, alpMachine, minCount, maxCount);

        printFooter(outputFile);

        inputFile.close();
        outputFile.close();
        in.close();
        out.close();
    }
}
