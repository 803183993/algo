package com.ace.algorithms2;

import com.ace.algorithms2.entities.Graph;
import com.ace.algorithms2.entities.Tree;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchTest
{
    private static final int[] UNSORTED_NUMBERS = new int[]{10, 17, 13, 15, 2, 11, 16, 10, 14, 18};

    @Test
    public void shouldReturnSpecifiedNumberFromTreeUsingBreadthFirstSearchAndDepthFirstSearch()
    {
        Tree<Integer> root = Tree.of(10);
        Tree<Integer> rootFirstChild = root.addChild(2);
        Tree<Integer> rootSecondChild = root.addChild(4);
        Tree<Integer> childOfSecondChild = rootFirstChild.addChild(3);

        //noinspection OptionalGetWithoutIsPresent
        assertThat(Tree.breadthFirstSearch(2, root).get().getValue(), is(rootFirstChild.getValue()));
        //noinspection OptionalGetWithoutIsPresent
        assertThat(Tree.breadthFirstSearch(4, root).get().getValue(), is(rootSecondChild.getValue()));
        //noinspection OptionalGetWithoutIsPresent
        assertThat(Tree.breadthFirstSearch(3, root).get().getValue(), is(childOfSecondChild.getValue()));
    }

    @Test
    public void shouldReturnSpecifiedNumberFromGraphUsingBreadthFirstSearch()
    {
        Graph<Integer> start = new Graph<>(10);
        Graph<Integer> firstChild = new Graph<>(2);
        start.connect(firstChild);

        Graph<Integer> childOfFirstChild = new Graph<>(3);
        firstChild.connect(childOfFirstChild);
        childOfFirstChild.connect(start);

        Graph<Integer> secondChild = new Graph<>(4);
        start.connect(secondChild);

        //noinspection OptionalGetWithoutIsPresent
        assertThat(Graph.breadthFirstSearch(4, firstChild).get().getValue(), is(secondChild.getValue()));
        //noinspection OptionalGetWithoutIsPresent
        assertThat(Graph.breadthFirstSearch(3, firstChild).get().getValue(), is(childOfFirstChild.getValue()));
        //noinspection OptionalGetWithoutIsPresent
        assertThat(Graph.breadthFirstSearch(3, secondChild).get().getValue(), is(childOfFirstChild.getValue()));
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