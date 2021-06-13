package com.ace.algo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SortedSquaredArrayTest
{
    @Test
    public void canSort()
    {
        assertThat(new SortedSquaredArray().sort(new int[]{-7, -3, -1, 4, 8, 12}), is(new int[]{1, 9, 16, 49, 64, 144}));
        assertThat(new SortedSquaredArray().sort(new int[]{-9, -6, -5, 4, 8, 9}), is(new int[]{16, 25, 36, 64, 81, 81}));
    }
}