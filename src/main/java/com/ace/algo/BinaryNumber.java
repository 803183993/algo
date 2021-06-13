package com.ace.algo;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class BinaryNumber
{
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


