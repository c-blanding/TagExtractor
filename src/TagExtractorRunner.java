import java.nio.file.Path;
import java.util.*;

public class TagExtractorRunner {

    public static void main(String[] args) {

        Map<String, Integer> tagsExtracted = new TreeMap<>();
        Set<String> stopWordsSet = new HashSet<>();
        Path bookWords = TagExtractorRead.getFile();
        Path stopWords = TagExtractorRead.getFile();

        try {

            Scanner bookFile = new Scanner(bookWords);
            Scanner stopFile = new Scanner(stopWords);

            while (stopFile.hasNextLine()) {
                    stopWordsSet.add(stopFile.nextLine());
            }


            while (bookFile.hasNext()) {
                String line = bookFile.nextLine();
                String[] words = line.split(" ");
                for (String word: words) {
                    if (!stopWordsSet.contains(word.toLowerCase())) {
                        tagsExtracted.merge(word.toLowerCase(), 1, (oldvalue, newvalue) -> oldvalue + 1);
                        break;
                    }
                }


            }

            TagExtractorWrite.writeFile(tagsExtracted);

        }catch (Exception e) {
            System.out.println(e);
        }


    }

}