package com.ace.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
    public String[] findPalindromes(String s)
    {
        ArrayList<String> palindromes = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i)
        {
            String p1 = getNextPalindrome(s, i, i); // where middle chars not the same e.g. racecar
            String p2 = getNextPalindrome(s, i, i + 1);

            String palindrome = p1.length() > p2.length() ? p1 : p2;

            if (palindrome.length() > 2)
            {
                palindromes.add(palindrome);
            }
        }
        return palindromes.toArray(new String[0]);
    }

    private String getNextPalindrome(String s, int left, int right)
    {
        if (left > right)
        {
            return "";
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) // within string and left + right match
        {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public String findMaxCharacter(String s)
    {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray())
        {
            if (c != ' ')
            {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
        }

        int maximumFrequency = java.util.Collections.max(counts.values());
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maximumFrequency; i++)
        {
            buckets.add(new ArrayList<>());
        }

        for (char key : counts.keySet())
        {
            buckets.get(counts.get(key)).add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.size() - 1; i >= 1; i--)
        {
            for (char c : buckets.get(i))
            {
                sb.append(String.valueOf(c).repeat(i));
            }
        }
        return sb.toString();
    }

    public int findInstancesOfString(String s, String pattern)
    {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        int count = 0;
        while (m.find())
        {
            count += 1;
        }
        return count;
    }

    public boolean findRepeatedString(String s)
    {
        return (s + s).indexOf(s, 1) != s.length(); // partial string not found
    }
}
