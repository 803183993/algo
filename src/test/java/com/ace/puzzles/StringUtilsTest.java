package com.ace.puzzles;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StringUtilsTest
{
    @Test
    public void findPalindromeOfGreaterThanTwoCharacters()
    {
        assertThat(new StringUtils().findPalindromes("abaabcaba"), is(new String[]{"aba", "baab", "aba"}));
        assertThat(new StringUtils().findPalindromes("abbaabcaba"), is(new String[]{"abba", "baab", "aba"}));
        assertThat(new StringUtils().findPalindromes("myracecarmy"), is(new String[]{"racecar"}));
    }

    @Test
    public void shouldReturnIfRepeatedSubStringPattern()
    {
        assertThat(new StringUtils().findRepeatedString("abab"), is(true));
        assertThat(new StringUtils().findRepeatedString("cabcabcab"), is(true));
        assertThat(new StringUtils().findRepeatedString("ababc"), is(false));
        assertThat(new StringUtils().findRepeatedString("My news room produces good news"), is(false));
    }

    @Test
    public void shouldFindNumberOfInstancesOfSpecifiedString()
    {
        assertThat(new StringUtils().findInstancesOfString("My news room produces good news", "news"), is(2));
    }

    @Test
    public void shouldReturnMaxCharacterInstance()
    {
        assertThat(new StringUtils().findMaxCharacter("My news room produces good news"), is("oooooeeesssddnnrrwwcgMmpuy"));
    }
}