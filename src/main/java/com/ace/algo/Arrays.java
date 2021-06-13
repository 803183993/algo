package com.ace.algo;

import java.util.HashMap;
import java.util.Map;

public class Arrays
{
    public String TwoSum(int[] nums, int target)
    {
        Map<Integer, Integer> coordinates = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            int remainder = target - nums[i];
            if (coordinates.get(remainder) != null)
            {
                return String.format("%s,%s", coordinates.get(remainder), i);
            }
            else
            {
                coordinates.put(nums[i], i);
            }
        }
        return null;
    }
}
