package com.ace.puzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Puzzles
{
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
