import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Generate an HTML tag cloud from the input file in real java.
 *
 * @author Eric Zhou
 */
public final class TagCloudJCF {

    /**
     * private constrcutor.
     */
    private TagCloudJCF() {

    }

    /**
     * Font size & magic number.
     */
    private static final int MIN_FONT = 11, MAX_FONT = 48;

    /**
     * Separators Set.
     */
    private static final String SEPARATORS = " \t\n\r,-.!?[]()';:/\"";

    /**
     * Comparator that compares pairs by count.
     */
    private static final class CountOrder
            implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> e1,
                Map.Entry<String, Integer> e2) {
            int result = e2.getValue().compareTo(e1.getValue());

            if (result == 0) {
                result = e1.getKey().compareTo(e2.getKey());
            }

            return result;
        }
    }

    /**
     * Comparator that compares pairs by word.
     */
    private static final class WordOrder
            implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> e1,
                Map.Entry<String, Integer> e2) {
            int result = e1.getKey().compareTo(e2.getKey());

            if (result == 0) {
                result = e1.getValue().compareTo(e2.getValue());
            }

            return result;
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
        return SEPARATORS.indexOf(c) >= 0;
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
        boolean mode = isSep(text.charAt(position));
        int index = position;

        while (index < text.length() && isSep(text.charAt(index)) == mode) {
            index++;
        }

        return text.substring(position, index);
    }

    /**
     * Read the input file and count the words.
     *
     * @param in
     *            the input stream
     * @return the final count map
     */
    private static Map<String, Integer> count(BufferedReader in)
            throws IOException {

        Map<String, Integer> counts = new HashMap<>();
        String line = in.readLine();

        while (line != null) {
            int position = 0;

            while (position < line.length()) {
                String token = nextWordOrSep(line, position);

                if (!isSep(token.charAt(0))) {
                    String word = token.toLowerCase();

                    if (counts.containsKey(word)) {
                        counts.put(word, counts.get(word) + 1);
                    } else {
                        counts.put(word, 1);
                    }
                }
                position = position + token.length();
            }
            line = in.readLine();
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
     * @param inputFileName
     *            the name of the input file
     * @param n
     *            the number of words to be expected
     */
    private static void printHeader(PrintWriter out, String inputFileName,
            int n) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en-US\">");

        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println(
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println(
                "<title>Top " + n + " Words in " + inputFileName + "</title>");
        out.println(
                "<link href=\"https://cse22x1.engineering.osu.edu/2231/web-sw2/assignments/projects/tag-cloud-generator/data/tagcloud.css\" "
                        + "rel=\"stylesheet\" type=\"text/css\">");
        out.println(
                "<link href=\"tagcloud.css\" rel=\"stylesheet\" type=\"text/css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Top " + n + " Words in " + inputFileName + "</h2>");
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
    private static void printFooter(PrintWriter out) {
        out.println("</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Return the top n words from the word count.
     *
     * @param counts
     *            the map that contains all words and their counts
     * @param n
     *            top n words
     * @return the arraylist with top n words
     */
    private static List<Map.Entry<String, Integer>> selectTopWords(
            Map<String, Integer> counts, int n) {
        List<Map.Entry<String, Integer>> allEntries = new ArrayList<>(
                counts.entrySet());
        List<Map.Entry<String, Integer>> topWords = new ArrayList<>();
        int limit = n;
        int index = 0;

        Collections.sort(allEntries, new CountOrder());

        if (limit > allEntries.size()) {
            limit = allEntries.size();
        }

        while (index < limit) {
            topWords.add(allEntries.get(index));
            index++;
        }

        Collections.sort(topWords, new WordOrder());

        return topWords;
    }

    /**
     * The min count and the max count.
     *
     * @param entries
     *            the list to find min and max
     * @return the array contains min and max
     */
    private static int[] minMax(List<Map.Entry<String, Integer>> entries) {
        int[] result = new int[2];
        if (entries.size() > 0) {
            int index = 0;
            int min = entries.get(0).getValue();
            int max = entries.get(0).getValue();

            while (index < entries.size()) {
                int current = entries.get(index).getValue();

                if (current < min) {
                    min = current;
                }

                if (current > max) {
                    max = current;
                }

                index++;
            }

            result[0] = min;
            result[1] = max;
        }

        return result;
    }

    /**
     * Output the html tags.
     *
     * @param out
     *            the output stream
     * @param topwords
     *            the list contains all top words
     * @param minCount
     *            the minimum count of words
     * @param maxCount
     *            the maximum count of words
     */
    private static void outputTags(PrintWriter out,
            List<Map.Entry<String, Integer>> topwords, int minCount,
            int maxCount) {
        int index = 0;

        while (index < topwords.size()) {
            Map.Entry<String, Integer> pair = topwords.get(index);
            int size = fontSize(pair.getValue(), minCount, maxCount);

            out.println("<span style=\"cursor: default\" class=\"f" + size
                    + "\" title=\"count: " + pair.getValue() + "\">"
                    + pair.getKey() + "</span>");
            index++;
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the input file name: ");
        String inputFileName = input.nextLine();

        System.out.print("Enter the output file name: ");
        String outputFileName = input.nextLine();

        System.out.print("Enter the number of words: ");
        int n = input.nextInt();

        BufferedReader in;
        PrintWriter out;

        try {
            in = new BufferedReader(new FileReader(inputFileName));
            out = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputFileName)));
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }

        try {
            Map<String, Integer> counts = count(in);
            List<Map.Entry<String, Integer>> topWords = selectTopWords(counts, n);

            int[] minMax = minMax(topWords);
            int min = minMax[0];
            int max = minMax[1];

            printHeader(out, inputFileName, topWords.size());
            outputTags(out, topWords, min, max);
            printFooter(out);

        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }

        try {
            in.close();
        } catch (IOException e) {
            System.err.println("Error closing input file: " + e.getMessage());
        }

        out.close();
        input.close();
    }
}
