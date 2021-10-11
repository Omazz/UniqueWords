import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class UniqueWords {
    private final HashMap<String, Integer> hashMap;
    
    public UniqueWords() {
        hashMap = new HashMap<>();
    }
    public synchronized void add(String word) {
        if (hashMap.containsKey(word)) {
            hashMap.put(word, hashMap.get(word) + 1);
        } else {
            hashMap.put(word, 1);
        }
    }
    public void readFiles(String[] filePaths) throws Exception {
        FileThread[] threads = new FileThread[filePaths.length];
        int i = 0;
        for (String it : filePaths) {
            threads[i] = new FileThread(this, it);
            threads[i].start();
            i++;
        }
        for (int j = 0; j < i; j++) {
            threads[j].waitAll();
        }
    }
    public void readFile(String filePath) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String word = "", pointer = "";
        System.out.println("Start of reading file: " + filePath);
        while ((pointer = in.readLine()) != null) {
            for (int i = 0; i < pointer.length(); i++) {
                while (pointer.charAt(i) != ' ') {
                    word += pointer.charAt(i);
                    if (pointer.length() == i + 1) {
                        break;
                    } else {
                        i++;
                    }
                }
                add(word);
                word = "";
            }
        }
        System.out.println("Reading of file is finished");
        in.close();
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hashMap.size(); i++) {
            stringBuilder.append(hashMap.keySet().toArray()[i]).append(" ").append(hashMap.values().toArray()[i]).append('\n');
        }
        return stringBuilder.toString();
    }
}