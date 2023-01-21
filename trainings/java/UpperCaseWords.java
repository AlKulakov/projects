class UpperCaseWords {
    public static void main(String[] args) {
        System.out.println(toJadenCase("Hello, i am aleksandr"));
    }

    private static String toJadenCase(String phrase) {
        char[] arr;
        if (phrase != null && !phrase.equals("")) {
            arr = phrase.toCharArray();
        } else
            return null;
        arr[0] = Character.toUpperCase(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ' ') {
                arr[i + 1] = Character.toUpperCase(arr[i + 1]);
            }
        }
        phrase = String.valueOf(arr);
        return phrase;
    }
}