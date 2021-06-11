package com.ace.algo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ArrayLengthTest
{
    @Test
    public void shouldReturnLargestArrayLength()
    {
        assertThat(new ArrayLength().getLongestSubArray(new int[]{1, 9, 7, 8, 9, 10}, 17), is(3));
        assertThat(new ArrayLength().getLongestSubArray(new int[]{1, 2, 3, 7, 5}, 12), is(3));
    }
}