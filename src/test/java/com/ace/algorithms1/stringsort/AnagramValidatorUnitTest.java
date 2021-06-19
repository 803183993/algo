package com.ace.algorithms1.stringsort;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnagramValidatorUnitTest
{

    @Test
    public void givenValidAnagrams_whenSorted_thenEqual()
    {
        boolean isValidAnagram = AnagramValidator.isValid("Avida Dollars", "Salvador Dali");

        assertTrue(isValidAnagram);
    }

    @Test
    public void givenNotValidAnagrams_whenSorted_thenNotEqual()
    {
        boolean isValidAnagram = AnagramValidator.isValid("abc", "def");

        assertFalse(isValidAnagram);
    }
}
