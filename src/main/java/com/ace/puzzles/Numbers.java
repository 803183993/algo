package com.ace.puzzles;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Numbers
{
    int romanToInt(String s)
    {
        Map<String, Integer> values = new HashMap<>()
        {
            {
                put("M", 1000);
                put("D", 500);
                put("C", 100);
                put("L", 50);
                put("X", 10);
                put("V", 5);
                put("I", 1);
            }
        };

        String lastSymbol = s.substring(s.length() - 1);
        int lastValue = values.get(lastSymbol);
        int total = lastValue;

        for (int i = s.length() - 2; i >= 0; i--)
        {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol);
            if (currentValue < lastValue)
            {
                total -= currentValue;
            }
            else
            {
                total += currentValue;
            }
            lastValue = currentValue;
        }
        return total;
    }

    String convertToRoman(int num)
    {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }

    boolean getPalindromeNumber(final int x)
    {
        if (x < 0)
        {
            return false;
        }
        int rev = 0;
        @SuppressWarnings("SuspiciousNameCombination") int y = x;
        while (y != 0)
        {
            int remainder = y % 10;
            rev = rev * 10 + remainder;
            y /= 10;
        }
        return rev == x;
    }

    int reverse(int x)
    {
        int rev = 0;
        while (x != 0)
        {
            int pop = x % 10;
            x /= 10;
            if (rev > MAX_VALUE / 10 || (rev == MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < MIN_VALUE / 10 || (rev == MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public String add(String aString, String bString)
    {
        int length = Math.max(aString.length(), bString.length());
        StringBuilder result = new StringBuilder();
        String cf = "0";
        for (int i = 1; i < length + 1; i++)
        {
            char aChar = i > aString.length() ? 'x' : aString.charAt(aString.length() - i);
            char bChar = i > bString.length() ? 'x' : bString.charAt(bString.length() - i);
            if (aChar == '1' && bChar == '1')
            {
                cf = "1";
                result.insert(0, "0");
            }
            else if ((aChar == '1' || bChar == '1') && cf.equals("1"))
            {
                result.insert(0, "0");
            }
            else if (aChar == '1' || bChar == '1')
            {
                result.insert(0, "1");
            }
            else
            {
                result.insert(0, (cf.equals("1") ? "1" : "0"));
                cf = "0";
            }
        }
        return cf.equals("1") ? String.format("1%s", result) : result.toString();
    }
}


