package com.ace.algorithms2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FindKthLargestUnitTest
{
    private FindKthLargest findKthLargest;
    private static final Integer[] arr = {3, 7, 1, 2, 8, 10, 4, 5, 6, 9};

    @Before
    public void setup()
    {
        findKthLargest = new FindKthLargest();
    }

    @Test
    public void givenIntArray_whenFindKthLargestBySorting_thenGetResult()
    {
        int k = 3;
        assertThat(findKthLargest.findKthLargestBySorting(arr, k), is(8));
    }

    @Test
    public void givenIntArray_whenFindKthLargestBySortingDesc_thenGetResult()
    {
        int k = 3;
        assertThat(findKthLargest.findKthLargestBySortingDesc(arr, k), is(8));
    }

    @Test
    public void givenIntArray_whenFindKthLargestByQuickSelect_thenGetResult()
    {
        int k = 3;
        int kthLargest = arr.length - k;
        assertThat(findKthLargest.findKthElementByQuickSelect(arr, 0, arr.length - 1, kthLargest), is(8));
    }

    @Test
    public void givenIntArray_whenFindKthElementByQuickSelectIterative_thenGetResult()
    {
        int k = 3;
        int kthLargest = arr.length - k;
        assertThat(findKthLargest.findKthElementByQuickSelectWithIterativePartition(arr, 0, arr.length - 1, kthLargest), is(8));
    }

    @Test
    public void givenIntArray_whenFindKthSmallestByQuickSelect_thenGetResult()
    {
        int k = 3;
        assertThat(findKthLargest.findKthElementByQuickSelect(arr, 0, arr.length - 1, k - 1), is(3));
    }

    @Test
    public void givenIntArray_whenFindKthLargestByRandomizedQuickSelect_thenGetResult()
    {
        int k = 3;
        int kthLargest = arr.length - k;
        assertThat(findKthLargest.findKthElementByRandomizedQuickSelect(arr, 0, arr.length - 1, kthLargest), is(8));
    }
}

