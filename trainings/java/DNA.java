import java.util.regex.*;

class DNA {
    public static void main(String[] args) {
        System.out.println(makeComplement("TTAAG"));
    }

    private static String makeComplement(String dna) {
        if (dna != null && !dna.equals("")) {
            dna = dna.toUpperCase();
            Pattern pattern = Pattern.compile("[^[ATGC]]");
            Matcher matcher = pattern.matcher(dna);
            if (matcher.find()) {
                return null;
            }
        }
        char[] arr = dna.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'A':
                    arr[i] = 'T';
                    break;
                case 'T':
                    arr[i] = 'A';
                    break;
                case 'G':
                    arr[i] = 'C';
                    break;
                case 'C':
                    arr[i] = 'G';
                    break;
            }
        }
        return String.valueOf(arr);
    }

}