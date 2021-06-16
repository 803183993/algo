package com.ace.algos.puzzles;

public class ArrayLength
{
    public int getLongestSubArray(int[] numbers, final int total)
    {
        int currentIndex = 0;
        int highestSubArraySize = 0;
        while (currentIndex < numbers.length)
        {
            int currentTotal = 0;
            for (int i = currentIndex; i < numbers.length; i++)
            {
                currentTotal += numbers[i];
                if (currentTotal >= total)
                {
                    if (currentTotal == total)
                    {
                        int currentSubArraySize = i - currentIndex + 1;
                        highestSubArraySize = Math.max(currentSubArraySize, highestSubArraySize);
                    }
                    break;
                }
            }
            currentIndex += 1;
        }
        return highestSubArraySize;
    }
}