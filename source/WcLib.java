import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WcLib {
    public int getByteCount(String text) {
        if (text == null) return 0;
        return text.length();
    }

    public int getLineCount(String text) {
        Pattern pattern = Pattern.compile("\n");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }


    public int getWordCount(String text) {
        if (text == "") return 0;
        return text.trim().split("\\s+").length;
    }

    public int[] countAll(String text) {
        int[] counts = {getLineCount(text), getWordCount(text), getByteCount(text)};
        return counts;
    }
}