import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WcLibTest {
    private WcLib wc;
    String emptyText, singleLinedText, multiLinedText;

    @Before
    public void setUp() {
        wc = new WcLib();
        emptyText = "";
        singleLinedText = "This sentence is to test the byte length.";
        multiLinedText = "This sentence is to test the byte length.\nBy the way this is multi line.";
    }

    // tests for wc -c option
    @Test
    public void get_byte_count_of_empty_string() {
        int byteCount = wc.getByteCount(emptyText);
        assertEquals(0, byteCount);
    }

    @Test
    public void get_byte_count_of_single_line_string() {
        int byteCount = wc.getByteCount(singleLinedText);
        assertEquals(41, byteCount);
    }

    @Test
    public void get_byte_count_of_multi_line_string() {
        int byteCount = wc.getByteCount(multiLinedText);
        assertEquals(72, byteCount);
    }

    // tests for wc -l  option
    @Test
    public void get_line_count_of_empty_string() {
        int lineCount = wc.getLineCount(emptyText);
        assertEquals(0, lineCount);
    }

    @Test
    public void get_line_count_of_single_line_string() {
        int lineCount = wc.getLineCount(singleLinedText);
        assertEquals(0, lineCount);
    }

    @Test
    public void get_line_count_of_multi_line_string() {
        int lineCount = wc.getLineCount(multiLinedText);
        assertEquals(1, lineCount);
    }

    // Tests for wc -w option
    @Test
    public void get_word_count_of_empty_string() {
        int wordCount = wc.getWordCount(emptyText);
        assertEquals(0, wordCount);
    }

    @Test
    public void get_word_count_of_single_line_string() {
        int wordCount = wc.getWordCount(singleLinedText);
        assertEquals(8, wordCount);
    }

    @Test
    public void get_word_count_of_multi_line_string() {
        int wordCount = wc.getWordCount(multiLinedText);
        assertEquals(15, wordCount);
    }
}
