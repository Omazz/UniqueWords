public class FileThread extends Thread {
    public String filePath = "";
    public UniqueWords uniqueWords;
    public FileThread(UniqueWords uniqueWords, String filePath) {
        this.filePath = filePath;
        this.uniqueWords = uniqueWords;
    }
    public void run() {
        try {
            uniqueWords.readFile(filePath);
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public void waitAll() {
        try {
            join();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}