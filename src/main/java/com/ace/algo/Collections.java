package com.ace.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collections
{
    public int getMaxArea(int[] height)
    {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
        {
            for (int j = i + 1; j < height.length; j++)
            {
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
                System.out.println(maxarea);
            }
        }
        return maxarea;
    }

    public List<Integer> addTwoNumbers(List<Integer> l1, List<Integer> l2)
    {
        List<Integer> result = new LinkedList<>();
        int largestSize = Math.max(l1.size(), l2.size());
        int cf = 0;
        for (int i = 0; i < largestSize; i++)
        {
            int a = i < l1.size() ? l1.get(l1.size() - 1 - i) : 0;
            int b = i < l2.size() ? l2.get(l2.size() - 1 - i) : 0;
            int ab = a + b + cf;
            result.add(i, ab > 9 ? ab - 10 : ab);
            cf = ab > 9 ? 1 : 0;
        }
        if (cf == 1)
        {
            result.add(cf);
        }
        return result;
    }

    public int[] sort(int[] unsorted)
    {
        int[] sorted = new int[unsorted.length];
        int leftIndex = 0;
        int rightIndex = unsorted.length - 1;
        int sortedIndex = unsorted.length - 1;
        for (int i = 0; i < unsorted.length; i++)
        {
            if (Math.abs(unsorted[leftIndex]) > Math.abs(unsorted[rightIndex]))
            {
                sorted[sortedIndex] = square(unsorted[leftIndex]);
                leftIndex += 1;
            }
            else
            {
                sorted[sortedIndex] = square(unsorted[rightIndex]);
                rightIndex -= 1;
            }
            sortedIndex -= 1;
        }

        return sorted;
    }

    private int square(int number)
    {
        return number * number;
    }

    public int getSubString(String input)
    {
        List<Character> result = new ArrayList<>();
        int longest = 0;
        for (int i = 0; i < input.length(); i++)
        {
            char letter = input.charAt(i);
            if (result.contains(letter))
            {
                longest = Math.max(longest, result.size());
                result = new ArrayList<>();
            }
            else
            {
                result.add(letter);
            }
        }
        return Math.max(longest, result.size());
    }
}
