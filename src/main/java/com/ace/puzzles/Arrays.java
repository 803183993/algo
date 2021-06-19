package com.ace.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Arrays
{
    public String[] getPhoneNumberCombinations(String digits)
    {
        Map<Character, String> map = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        List<String> combinations = new ArrayList<>();
        String phoneDigits;
        if (digits.length() == 0)
        {
            return combinations.toArray(new String[0]);
        }
        phoneDigits = digits;
        backtrack(0, new StringBuilder(), phoneDigits, combinations, map);
        return combinations.toArray(new String[0]);
    }

    private void backtrack(int index, StringBuilder path, String phoneDigits, List<String> combinations, Map<Character, String> map)
    {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length())
        {
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = map.get(phoneDigits.charAt(index));
        for (char letter : possibleLetters.toCharArray())
        {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path, phoneDigits, combinations, map);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }

    public String longestCommonPrefix(String[] strs)
    {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (String next : strs)
        {
            while (!next.startsWith(prefix))
            {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String TwoSum(int[] nums, int target)
    {
        Map<Integer, Integer> coordinates = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            int remainder = target - nums[i];
            if (coordinates.get(remainder) != null)
            {
                return String.format("%s,%s", coordinates.get(remainder), i);
            }
            else
            {
                coordinates.put(nums[i], i);
            }
        }
        return null;
    }
}
