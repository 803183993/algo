package com.ace.algos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SortingTest
{
    private static final int[] UNSORTED_NUMBERS = new int[]{10, 17, 13, 15, 18, 11, 16, 10, 14, 2};

    @Test
    public void shouldUseMergeSortToSortNumbers()
    {
        assertThat(new Sorting().mergeSort(UNSORTED_NUMBERS), is(new int[]{2, 10, 10, 11, 13, 14, 15, 16, 17, 18}));
    }

    @Test
    public void shouldUseTimSortToSortNumbers()
    {
        assertThat(new Sorting().timSort(UNSORTED_NUMBERS), is(new int[]{2, 10, 10, 11, 13, 14, 15, 16, 17, 18}));
    }

    @Test
    public void shouldUseQuickSortToSortNumbers()
    {
        assertThat(new Sorting().quickSort(UNSORTED_NUMBERS), is(new int[]{2, 10, 10, 11, 13, 14, 15, 16, 17, 18}));
    }

    @Test
    public void shouldUseInsertionSortToSortNumbers()
    {
        assertThat(new Sorting().insertionSort(UNSORTED_NUMBERS), is(new int[]{2, 10, 10, 11, 13, 14, 15, 16, 17, 18}));
    }

    @Test
    public void shouldUseSelectionSortToSortNumbers()
    {
        assertThat(new Sorting().selectionSort(UNSORTED_NUMBERS), is(new int[]{2, 10, 10, 11, 13, 14, 15, 16, 17, 18}));
    }

    @Test
    public void shouldUseBubbleSortToSortNumbers()
    {
        assertThat(new Sorting().bubbleSort(UNSORTED_NUMBERS), is(new int[]{2, 10, 10, 11, 13, 14, 15, 16, 17, 18}));
    }
}