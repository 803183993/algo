package com.ace.algos;

import java.util.Random;

public class Sorting
{
    private static final int MIN_MERGE = 32;

    public int[] bucketSort(int[] numbers, int range)
    {
        int[] bucket = new int[range];
        int[] sortedNumbers = new int[numbers.length];

        for (int number : numbers)
        {
            bucket[number]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++)
        {
            for (int j = 0; j < bucket[i]; j++)
            {
                sortedNumbers[outPos++] = i;
            }
        }

        return sortedNumbers;
    }

    public int[] heapSort(int[] numbers)
    {
        int n = numbers.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(numbers, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--)
        {
            // Move current root to end
            int temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;

            // call max heapify on the reduced heap
            heapify(numbers, i, 0);
        }
        return numbers;
    }

    public int[] countingSort(int[] numbers, int range)
    {
        int n = numbers.length;
        int[] output = new int[n];
        int[] counts = new int[range];

        // store count of each number
        for (int number : numbers)
        {
            ++counts[number];
        }

        // store actual position of number
        for (int i = 1; i < counts.length; ++i)
        {
            counts[i] += counts[i - 1];
        }

        for (int i = n - 1; i >= 0; i--)
        {
            output[counts[numbers[i]] - 1] = numbers[i];
            --counts[numbers[i]];
        }

        System.arraycopy(output, 0, numbers, 0, n);
        return output;
    }

    public int[] mergeSort(int[] numbers)
    {
        print(numbers, 0);
        mergeSortLeftAndRight(numbers, numbers.length);
        return numbers;
    }

    public int[] quickSort(int[] numbers)
    {
        return quickSort(numbers, 0, numbers.length - 1);
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

    void heapify(int[] numbers, int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && numbers[l] > numbers[largest])
        {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && numbers[r] > numbers[largest])
        {
            largest = r;
        }

        // If largest is not root
        if (largest != i)
        {
            int swap = numbers[i];
            numbers[i] = numbers[largest];
            numbers[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(numbers, n, largest);
        }
    }

    private void mergeSortLeftAndRight(int[] numbers, int n)
    {
        if (n < 2)
        {
            return; // if its only two, we can sort and merge
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        // create new array with numbers to the left
        System.arraycopy(numbers, 0, left, 0, mid);
        // create new array with numbers to the right
        if (n - mid >= 0) System.arraycopy(numbers, mid, right, 0, n - mid);

        mergeSortLeftAndRight(left, mid);
        mergeSortLeftAndRight(right, n - mid);

        merge(numbers, left, right, mid, n - mid);
    }

    private void merge(int[] numbers, int[] l, int[] r, int left, int right)
    {
        System.out.println("Merging left and right");
        print(numbers, 0);
        print(l, left);
        print(r, right);

        int i = 0, j = 0, k = 0;
        while (i < left && j < right)
        {
            if (l[i] <= r[j])
            {
                numbers[k++] = l[i++];
            }
            else
            {
                numbers[k++] = r[j++];
            }
        }

        while (i < left) // copy left numbers
        {
            numbers[k++] = l[i++];
        }
        while (j < right) // copy right numbers
        {
            numbers[k++] = r[j++];
        }
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
