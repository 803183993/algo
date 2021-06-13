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
}