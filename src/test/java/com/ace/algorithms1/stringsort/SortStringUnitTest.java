package com.ace.algorithms1.stringsort;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class SortStringUnitTest
{

    @Test
    void givenString_whenSort_thenSorted()
    {
        String abcd = "bdca";
        char[] chars = abcd.toCharArray();

        Arrays.sort(chars);
        String sorted = new String(chars);

        assertThat(sorted, is("abcd"));
    }

    @Test
    void givenString_whenSortJava8_thenSorted()
    {
        String sorted = "bdca".chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        assertThat(sorted, is("abcd"));
    }
}
