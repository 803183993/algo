package com.ace.puzzles;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class LinkedListTest
{
    @Test
    public void shouldSortLinkedList()
    {
        assertThat(new LinkedList().sortList(new LinkedList.ListNode()), notNullValue());
    }
}