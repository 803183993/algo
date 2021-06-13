package com.ace.algo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BinaryNumberTest
{
    @Test
    public void shouldAddBinaryString()
    {
        assertThat(new BinaryNumber().add("1010", "1011"), is("10101"));
        assertThat(new BinaryNumber().add("1101", "100"), is("10001"));
        assertThat(new BinaryNumber().add("1101", "10"), is("1111"));
    }

    @Test
    public void shouldReverseNumbers()
    {
        assertThat(new BinaryNumber().reverse(12345678), is(87654321));
        assertThat(new BinaryNumber().reverse(1234), is(4321));
        assertThat(new BinaryNumber().reverse(100), is(1));
        assertThat(new BinaryNumber().reverse(1100), is(11));
        assertThat(new BinaryNumber().reverse(30), is(3));
    }
}