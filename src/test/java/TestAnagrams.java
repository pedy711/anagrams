import org.example.Anagram;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestAnagrams {
    Anagram anagram = Anagram.getInstance();
    @Test
    public void testAreTextsAnagrams_WithAnagrams() {
        assertTrue(anagram.areTextsAnagrams("silent", "listen"));
        assertTrue(anagram.areTextsAnagrams("New York Times", "monkeys write"));
        assertTrue(anagram.areTextsAnagrams("Uncle Sam's standard rot", "McDonald's restaurants"));
    }

    @Test
    public void testAreTextsAnagrams_WithNonAnagrams() {
        assertFalse(anagram.areTextsAnagrams("hello", "world"));
        assertFalse(anagram.areTextsAnagrams("Anagram", "Anagram Tester"));
        assertFalse(anagram.areTextsAnagrams("Java", "Python"));
    }

    @Test
    public void testSortString() {
        assertEquals("abc", anagram.sortString("cba"));
        assertEquals("12345", anagram.sortString("54321"));
    }

    @Test
    public void testMemory() {
        anagram.areTextsAnagrams("silent", "listen");
        anagram.areTextsAnagrams("silent", "tnesil");
        anagram.areTextsAnagrams("silent", "silent2");
        anagram.areTextsAnagrams("silent", "enlist");

        List<String> silentAnagrams = anagram.getAllAnagrams("silent");
        List<String> silentAnagramsSorted = silentAnagrams.stream().sorted().toList();

        assertEquals(Arrays.asList("enlist", "listen", "tnesil"), silentAnagramsSorted);
        assertEquals(silentAnagrams.size(), 3);

        List<String> listenAnagrams = anagram.getAllAnagrams("listen");
        List<String> listenAnagramsSorted = listenAnagrams.stream().sorted().toList();

        assertEquals(Arrays.asList("enlist", "silent", "tnesil"), listenAnagramsSorted);
        assertEquals(listenAnagrams.size(), 3);
    }
}
