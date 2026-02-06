/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Logan Tran
 */
public class PlagiarismChecker {

    public static int[] paths;

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */

    public static int longestSharedSubstring(String doc1, String doc2) {
        String longer;
        String shorter;
        if(doc1.length() > doc2.length()) {
            longer = doc1;
            shorter = doc2;
        }
        else {
            longer = doc2;
            shorter = doc1;
        }

        // It will never be longer than the shorter string
        paths = new int[shorter.length()];

        for(int i = 0; i < longer.length(); i++) {
            for (int j = 0; j < shorter.length(); j++) {
                if(longer.charAt(i) == shorter.charAt(j)) {
                    paths[j] += 1;
                }
                else {
                    paths[j] = Math.max(paths[j], paths[j - 1]);
                }
            }

        }
        return paths[shorter.length()];
    }

}
