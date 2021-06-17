package com.ace.algos;

import com.ace.algos.entities.Node;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchTest
{
    private static final int[] UNSORTED_NUMBERS = new int[]{10, 17, 13, 15, 2, 11, 16, 10, 14, 18};

    @Test
    public void shouldReturnSpecifiedNumberFromTreeUsingBreadthFirstSearch()
    {
        Node<Integer> start = new Node<>(10);
        Node<Integer> firstChild = new Node<>(2);
        start.connect(firstChild);

        Node<Integer> childOfFirstChild = new Node<>(3);
        firstChild.connect(childOfFirstChild);
        childOfFirstChild.connect(start);

        Node<Integer> secondChild = new Node<>(4);
        start.connect(secondChild);

        //noinspection OptionalGetWithoutIsPresent
        assertThat(Node.breadthFirstSearch(4, start).get().getValue(), is(secondChild.getValue()));
        //noinspection OptionalGetWithoutIsPresent
        assertThat(Node.breadthFirstSearch(3, secondChild).get().getValue(), is(childOfFirstChild.getValue()));
    }

    @Test
    public void shouldUseLinearSearchToFindSpecifiedNumber()
    {
        assertThat(new Search().linearSearchByValue(UNSORTED_NUMBERS, 11), is(3));
        assertThat(new Search().linearSearchByValue(UNSORTED_NUMBERS, 13), is(4));
        assertThat(new Search().linearSearchByValue(UNSORTED_NUMBERS, 17), is(8));
        assertThat(new Search().linearSearchByValue(UNSORTED_NUMBERS, 18), is(9));
        assertThat(new Search().linearSearchByValue(UNSORTED_NUMBERS, 2), is(0));
    }

    @Test
    public void shouldUseBinarySearchToFindSpecifiedNumber()
    {
        assertThat(new Search().binarySearch(UNSORTED_NUMBERS, 11), is(3));
        assertThat(new Search().binarySearch(UNSORTED_NUMBERS, 13), is(4));
        assertThat(new Search().binarySearch(UNSORTED_NUMBERS, 17), is(8));
        assertThat(new Search().binarySearch(UNSORTED_NUMBERS, 18), is(9));
        assertThat(new Search().binarySearch(UNSORTED_NUMBERS, 2), is(0));
    }
}