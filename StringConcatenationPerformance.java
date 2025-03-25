class StringConcatenationComparison {
    public static void main(String[] args) {
        int iterations = 1000;
        String word = "Hello";

        // Using String
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += word;
        }
        long endTime = System.nanoTime();
        long stringTime = (endTime - startTime) / 1_000_000;

        // Using StringBuilder
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(word);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = (endTime - startTime) / 1_000_000;

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(word);
        }
        endTime = System.nanoTime();
        long stringBufferTime = (endTime - startTime) / 1_000_000;

        System.out.println("String Concatenation Time: " + stringTime + " ms");
        System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime + " ms");
        System.out.println("StringBuffer Concatenation Time: " + stringBufferTime + " ms");
    }
}
