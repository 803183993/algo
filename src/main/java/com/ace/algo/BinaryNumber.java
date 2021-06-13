package com.ace.algo;

public class BinaryNumber
{
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


