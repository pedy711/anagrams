package org.example;

import java.util.*;

public class Anagram {
    private static class Holder {
        private static final Anagram INSTANCE = new Anagram();
    }

    private final Map<String, TextSubject> memory = new HashMap<>();

    private Anagram() {
    }

    public static Anagram getInstance() {
        return Holder.INSTANCE;
    }

    public boolean areTextsAnagrams(String text1, String text2) {
        if (text1 == null || text2 == null) {
            throw new IllegalArgumentException("Input strings cannot be null.");
        }

        String text1NoSpace = text1.replaceAll("\\s", "");
        String text2NoSpace = text2.replaceAll("\\s", "");

        if (text1NoSpace.length() != text2NoSpace.length()) {
            return false;
        } else {
            String text1NoSpaceSorted = sortString(text1NoSpace.toLowerCase());
            String text2NoSpaceSorted = sortString(text2NoSpace.toLowerCase());

            if (text1NoSpaceSorted.equals(text2NoSpaceSorted)) {
                memorize(text1, text2);
                return true;
            }
        }
        return false;
    }

    public void memorize(String text1, String text2) {
        createOrUpdateList(text1, text2);
    }

    public List<String> getAllAnagrams(String key) {
        TextSubject textSubject = memory.get(key);
        return (textSubject != null) ? textSubject.getAnagrams().stream().map(TextSubject::getText).toList() : new ArrayList<>();
    }

    private void createOrUpdateList(String text1, String text2) {
        TextSubject textSubject1 = getOrCreateTextSubject(text1);
        TextSubject textSubject2 = getOrCreateTextSubject(text2);
        textSubject1.addObserver(textSubject2);
    }

    private TextSubject getOrCreateTextSubject(String text) {
        TextSubject textSubject = memory.get(text);
        if (textSubject == null) {
            textSubject = new TextSubject(text);
            memory.put(text, textSubject);
        }
        return textSubject;
    }

    public String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
