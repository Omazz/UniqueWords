public class Main {
    public static void main(String[] args) {
            UniqueWords uniqueWords = new UniqueWords();
            try {
            long time = System.currentTimeMillis();
            for (String arg : args) {
                uniqueWords.readFile(arg);
            }
            System.out.println("Time without threads:" + (System.currentTimeMillis()-time));
            time = System.currentTimeMillis();
            uniqueWords.readFiles(args);
            System.out.println("Time with threads:" + (System.currentTimeMillis()-time));
            System.out.println(uniqueWords);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

