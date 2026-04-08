import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.simplereader.SimpleReader;
import components.simplewriter.SimpleWriter;

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
     * Print the footer of the HTML file
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
}
