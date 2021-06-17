package com.ace.algos;

public class Search
{
    public int binarySearch(int[] unsortedNumbers, int value)
    {
        int[] sortedNumbers = new Sorting().bubbleSort(unsortedNumbers);
        int lowIndex = 0;
        int highIndex = sortedNumbers.length - 1;

        if (sortedNumbers[highIndex] == value)
        {
            return highIndex;
        }
        while (lowIndex <= highIndex)
        {
            int middleIndex = (highIndex + lowIndex) / 2;
            if (sortedNumbers[middleIndex] < value)
            {
                lowIndex = middleIndex;
            }
            else if (sortedNumbers[middleIndex] > value)
            {
                highIndex = middleIndex;
            }
            else
            {
                return middleIndex;
            }
        }
        throw new IllegalArgumentException();
    }

    public int linearSearchByValue(int[] unsortedNumbers, int value)
    {
        int[] sortedNumbers = new Sorting().insertionSort(unsortedNumbers);

        for (int i = 0; i < sortedNumbers.length; i++)
        {
            if (sortedNumbers[i] == value)
            {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }
}
