package com.ace.algo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ArraysTest
{
    @Test
    public void shouldReturnSubArrayOfSpecifiedNumber()
    {
        assertThat(new Arrays().TwoSum(new int[]{2, 7, 11, 15}, 9), is("0,1"));
        assertThat(new Arrays().TwoSum(new int[]{3, 2, 4}, 6), is("1,2"));
        assertThat(new Arrays().TwoSum(new int[]{3, 3}, 6), is("0,1"));
        assertThat(new Arrays().TwoSum(new int[]{2, 7, 11, 15}, 22), is("1,3"));
    }
}