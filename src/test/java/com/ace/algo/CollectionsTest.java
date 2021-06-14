package com.ace.algo;

import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CollectionsTest
{
    @Test
    public void getLongestPalindrome()
    {
        assertThat(new Collections().getMaxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), is(49));
    }

    @Test
    public void shouldReturnLongestSubstringWithoutRepeatingCharacters()
    {
        assertThat(new Collections().getSubString("abcabcbb"), is(3));
        assertThat(new Collections().getSubString("bbbbb"), is(1));
        assertThat(new Collections().getSubString("pwwkew"), is(3));
    }

    @Test
    public void canSort()
    {
        assertThat(new Collections().sort(new int[]{-7, -3, -1, 4, 8, 12}), is(new int[]{1, 9, 16, 49, 64, 144}));
        assertThat(new Collections().sort(new int[]{-9, -6, -5, 4, 8, 9}), is(new int[]{16, 25, 36, 64, 81, 81}));
    }

    @Test
    public void shouldAddTwoLists()
    {
        assertThat(new Collections().addTwoNumbers(new LinkedList<>()
        {
            {
                add(2);
                add(4);
                add(3);
            }
        }, new LinkedList<>()
        {
            {
                add(5);
                add(6);
                add(4);
            }
        }), is(new LinkedList<>()
        {
            {
                add(7);
                add(0);
                add(8);
            }
        }));

        assertThat(new Collections().addTwoNumbers(new LinkedList<>()
        {
            {
                add(0);
            }
        }, new LinkedList<>()
        {
            {
                add(0);
            }
        }), is(new LinkedList<>()
        {
            {
                add(0);
            }
        }));

        assertThat(new Collections().addTwoNumbers(new LinkedList<>()
        {
            {
                add(9);
                add(9);
                add(9);
                add(9);
                add(9);
                add(9);
                add(9);
            }
        }, new LinkedList<>()
        {
            {
                add(9);
                add(9);
                add(9);
                add(9);
            }
        }), is(new LinkedList<>()
        {
            {
                add(8);
                add(9);
                add(9);
                add(9);
                add(0);
                add(0);
                add(0);
                add(1);
            }
        }));
    }
}