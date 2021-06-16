package com.ace.algos.puzzles;

public class Fibonacci
{
    public int getNumber(int fib)
    {
        if (fib == 1 || fib == 2)
        {
            return 1;
        }
        int[] fibSequence = new int[fib + 1];
        fibSequence[1] = 1;
        fibSequence[2] = 1;
        for (int i = 3; i < fibSequence.length; i++)
        {
            fibSequence[i] = fibSequence[i - 1] + fibSequence[i - 2];
        }
        return fibSequence[fib];
    }
}
