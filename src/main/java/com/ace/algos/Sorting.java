package com.ace.algos;

import java.util.Random;

public class Sorting
{
    private static final int MIN_MERGE = 32;

    public int[] quickSort(int[] numbers)
    {
        return quickSort(numbers, 0, numbers.length - 1);
    }

    private void insertionSort(int[] numbers, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = numbers[i];
            int j = i - 1;
            while (j >= left && numbers[j] > temp)
            {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = temp;
        }
    }

    private void merge(int[] numbers, int l, int m, int r)
    {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        System.arraycopy(numbers, l, left, 0, len1);
        for (int x = 0; x < len2; x++)
        {
            right[x] = numbers[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < len1 && j < len2)
        {
            if (left[i] <= right[j])
            {
                numbers[k] = left[i];
                i++;
            }
            else
            {
                numbers[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < len1)
        {
            numbers[k] = left[i];
            k++;
            i++;
        }
        while (j < len2)
        {
            numbers[k] = right[j];
            k++;
            j++;
        }
    }

    public int[] timSort(int[] numbers)
    {
        int minRun = getMinimumRunLength(numbers.length);

        for (int i = 0; i < numbers.length; i += minRun)
        {
            insertionSort(numbers, i, Math.min((i + MIN_MERGE - 1), (numbers.length - 1)));
        }

        for (int size = minRun; size < numbers.length; size = 2 * size)
        {
            for (int left = 0; left < numbers.length; left += 2 * size)
            {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (numbers.length - 1));
                if (mid < right) merge(numbers, left, mid, right);
            }
        }
        return numbers;
    }

    private int getMinimumRunLength(int n)
    {
        int r = 0;
        while (n >= MIN_MERGE)
        {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    private int[] quickSort(int[] numbers, int low, int high)
    {
        if (low < high + 1)
        {
            int p = partition(numbers, low, high);
            quickSort(numbers, low, p - 1);
            quickSort(numbers, p + 1, high);
        }
        return numbers;
    }

    private int partition(int[] numbers, int low, int high)
    {
        swap(numbers, low, getPivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++)
        {
            if (numbers[i] < numbers[low])
            {
                swap(numbers, i, border++);
            }
        }
        swap(numbers, low, border - 1);
        return border - 1;
    }

    private void swap(int[] numbers, int index1, int index2)
    {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }

    private int getPivot(int low, int high)
    {
        // return number between high and low inclusive
        return new Random().nextInt(high - low + 1) + low;
    }

    public int[] insertionSort(int[] numbers)
    {
        print(numbers, 0);
        int count = 1;

        // find smallest number and insert it into the correct place
        for (int i = 1; i < numbers.length; i++) // start from second index
        {
            int j = i;
            int toInsert = numbers[i];
            while ((j > 0) && (numbers[j - 1] > toInsert)) // find smallest number increasing search area by one each time
            {
                numbers[j] = numbers[j - 1];
                j--;

                count += 1;
            }
            numbers[j] = toInsert;
            print(numbers, count);
        }
        return numbers;
    }

    public int[] selectionSort(int[] numbers)
    {
        print(numbers, 0);
        int count = 1;
        for (int i = 0; i < numbers.length; i++) // iterate through each index
        {
            int min = i;
            for (int j = i; j < numbers.length; j++) // find the smallest number between current index and end
            {
                if (numbers[min] > numbers[j])
                {
                    min = j;
                }
            }
            // set the smallest number in the current index
            int temp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = temp;
            print(numbers, count);
            count += 1;
        }
        return numbers;
    }

    public int[] bubbleSort(int[] numbers)
    {
        print(numbers, 0);
        int count = 1;
        for (int i = numbers.length - 1; i > 0; i--) // iterate from last index
        {
            for (int j = 0; j < i; j++) // moving bigger numbers to the right and moving sorting area to the left
            {
                if (numbers[j] > numbers[j + 1])
                {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    print(numbers, count);
                    count += 1;
                }
            }
        }
        return numbers;
    }

    public int binarySearch(int[] unsortedNumbers, int value)
    {
        int[] sortedNumbers = bubbleSort(unsortedNumbers);
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
        int[] sortedNumbers = insertionSort(unsortedNumbers);

        for (int i = 0; i < sortedNumbers.length; i++)
        {
            if (sortedNumbers[i] == value)
            {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    private void print(int[] sortedList, int count)
    {
        System.out.printf("[%02d] | ", count);
        for (int num : sortedList)
        {
            System.out.printf("%d | ", num);
        }
        System.out.println();
    }
}
