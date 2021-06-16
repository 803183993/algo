package com.ace.algos.puzzles;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NumbersTest
{
    @Test
    public void shouldReturnIntFromRoman()
    {
        assertThat(new Numbers().romanToInt("IV"), is(4));
        assertThat(new Numbers().romanToInt("MCMXCIV"), is(1994));
        assertThat(new Numbers().romanToInt("X"), is(10));
        assertThat(new Numbers().romanToInt("LVIII"), is(58));
    }

    @Test
    public void shouldReturnRomanNumerals()
    {
        assertThat(new Numbers().convertToRoman(1994), is("MCMXCIV"));
        assertThat(new Numbers().convertToRoman(10), is("X"));
        assertThat(new Numbers().convertToRoman(58), is("LVIII"));
    }

    @Test
    public void shouldReturnTrueIfPalindromeNumber()
    {
        assertThat(new Numbers().getPalindromeNumber(121), is(true));
        assertThat(new Numbers().getPalindromeNumber(-121), is(false));
        assertThat(new Numbers().getPalindromeNumber(123), is(false));
        assertThat(new Numbers().getPalindromeNumber(11), is(true));
    }

    @Test
    public void shouldAddBinaryString()
    {
        assertThat(new Numbers().add("1010", "1011"), is("10101"));
        assertThat(new Numbers().add("1101", "100"), is("10001"));
        assertThat(new Numbers().add("1101", "10"), is("1111"));
    }

    @Test
    public void shouldReverseNumbers()
    {
        assertThat(new Numbers().reverse(12345678), is(87654321));
        assertThat(new Numbers().reverse(1234), is(4321));
        assertThat(new Numbers().reverse(100), is(1));
        assertThat(new Numbers().reverse(1100), is(11));
        assertThat(new Numbers().reverse(30), is(3));
    }
}