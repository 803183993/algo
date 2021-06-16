package com.ace.algos;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SortingTest
{
    private static final int[] UNSORTED_NUMBERS = new int[]{10, 17, 13, 15, 18, 11, 16, 10, 14, 2};

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

    @Test
    public void shouldUseLinearSearchToFindSpecifiedNumber()
    {
        assertThat(new Sorting().linearSearchByValue(UNSORTED_NUMBERS, 11), is(3));
        assertThat(new Sorting().linearSearchByValue(UNSORTED_NUMBERS, 13), is(4));
        assertThat(new Sorting().linearSearchByValue(UNSORTED_NUMBERS, 17), is(8));
        assertThat(new Sorting().linearSearchByValue(UNSORTED_NUMBERS, 18), is(9));
        assertThat(new Sorting().linearSearchByValue(UNSORTED_NUMBERS, 2), is(0));
    }

    @Test
    public void shouldUseBinarySearchToFindSpecifiedNumber()
    {
        assertThat(new Sorting().binarySearch(UNSORTED_NUMBERS, 11), is(3));
        assertThat(new Sorting().binarySearch(UNSORTED_NUMBERS, 13), is(4));
        assertThat(new Sorting().binarySearch(UNSORTED_NUMBERS, 17), is(8));
        assertThat(new Sorting().binarySearch(UNSORTED_NUMBERS, 18), is(9));
        assertThat(new Sorting().binarySearch(UNSORTED_NUMBERS, 2), is(0));
    }
}