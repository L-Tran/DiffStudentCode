/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Logan Tran
 */
public class PlagiarismChecker {

    public static int[][] paths;

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */

    // Tabulation implementation
    public static int longestSharedSubstring(String doc1, String doc2) {

        // Lengths of strings
        int m = doc1.length();
        int n = doc2.length();

        // Initialize array with padding
        paths = new int[m + 1][n + 1];

        // Iterate through tabulation array
        for(int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current letter is equal
                if(doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    // Paths at location + 1 because of match
                    paths[i][j] = paths[i - 1][j - 1] + 1;
                }
                // If the current letters are not the same
                else {
                    // Get the max of both possible paths back from strings
                    paths[i][j] = Math.max(paths[i - 1][j], paths[i][j - 1]);
                }
            }
        }
        return paths[m][n];
    }

}
