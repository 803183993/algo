package com.ace.puzzles;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ArraysTest
{
    @Test
    public void shouldReturnLettersRepresentingPhoneNumbers()
    {
        assertThat(new Arrays().getPhoneNumberCombinations("23"), is(new String[]{"ad","ae","af","bd","be","bf","cd","ce","cf"}));
    }

    @Test
    public void shouldGetLongestPrefix()
    {
        assertThat(new Arrays().longestCommonPrefix(new String[]{"flower", "flow", "flight"}), is("fl"));
        assertThat(new Arrays().longestCommonPrefix(new String[]{"deadpan", "deadpool", "deadline"}), is("dead"));
        assertThat(new Arrays().longestCommonPrefix(new String[]{"dog", "car", "racecar"}), is(""));
    }

    @Test
    public void shouldReturnSubArrayOfSpecifiedNumber()
    {
        assertThat(new Arrays().TwoSum(new int[]{2, 7, 11, 15}, 9), is("0,1"));
        assertThat(new Arrays().TwoSum(new int[]{3, 2, 4}, 6), is("1,2"));
        assertThat(new Arrays().TwoSum(new int[]{3, 3}, 6), is("0,1"));
        assertThat(new Arrays().TwoSum(new int[]{2, 7, 11, 15}, 22), is("1,3"));
    }
}