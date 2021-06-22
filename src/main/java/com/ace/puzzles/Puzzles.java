package com.ace.puzzles;

import java.util.*;

public class Puzzles
{

    public String frequencySort(String s)
    {
        if (s == null || s.isEmpty()) return s;

        // Count up the occurances.
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray())
        {
            if (c != ' ')
            {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
        }

        int maximumFrequency = java.util.Collections.max(counts.values());

        // Make the list of buckets and apply bucket sort.
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maximumFrequency; i++)
        {
            buckets.add(new ArrayList<>());
        }
        for (Character key : counts.keySet())
        {
            int freq = counts.get(key);
            buckets.get(freq).add(key);
        }

        // Build up the string.
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.size() - 1; i >= 1; i--)
        {
            for (Character c : buckets.get(i))
            {
                for (int j = 0; j < i; j++)
                {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public Integer getKthLargestElement(int[] numbers, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int number : numbers)
        {
            minHeap.add(number);
            if (minHeap.size() > k)
            {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public Integer getKthSmallestElement(int[] numbers, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(java.util.Collections.reverseOrder());
        for (int number : numbers)
        {
            minHeap.add(number);
            if (minHeap.size() > k)
            {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public int getMidpoint(int low, int high)
    {
        return (low + high) >>> 1;
    }

    public int[] convertIntToBytes(int number)
    {
        int[] bytes = new int[number + 1];
        for (int i = 1; i <= number; ++i)
        {
            bytes[i] = (i >> 1) + (i & 1);
        }
        return bytes;
    }

    public Integer[] getDuplicates(int[] numbers)
    {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[Math.abs(numbers[i]) - 1] < 0)
            {
                duplicates.add(Math.abs(numbers[i]));
            }
            numbers[Math.abs(numbers[i]) - 1] = -numbers[Math.abs(numbers[i]) - 1];
        }
        return duplicates.toArray(new Integer[0]);
    }

}
