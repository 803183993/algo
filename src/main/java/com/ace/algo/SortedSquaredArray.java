package com.ace.algo;

public class SortedSquaredArray
{
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
}
