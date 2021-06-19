package com.ace.puzzles;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FibonacciTest
{

    @Test
    public void getNumber()
    {
        assertThat(new Fibonacci().getNumber(6), is(8));
    }
}