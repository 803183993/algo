package com.ace.puzzles;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PuzzlesTest
{
    @Test
    public void shouldFindKthLargestElement()
    {
        assertThat(new Puzzles().getKthLargestElement(new int[]{3, 2, 1, 5, 6, 4}, 2), is(5));
        assertThat(new Puzzles().getKthLargestElement(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4), is(4));
    }

    @Test
    public void shouldFindKthSmallestElement()
    {
        assertThat(new Puzzles().getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15}, 3), is(7));
        assertThat(new Puzzles().getKthSmallestElement(new int[]{2, 2, 1, 5, 6, 4}, 3), is(2));
    }

    @Test
    public void shouldGetMinimumDepthOfBinaryTree()
    {
        BinaryTree tree1 = BinaryTree.fromUnsorted(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertThat(tree1.getMinimumDepth(), is(2));
    }

    @Test
    public void shouldCreateBinaryTree()
    {
        BinaryTree tree1 = BinaryTree.fromUnsorted(new Integer[]{1, 2, 3, 4, 5, 6, 6, 6, 6});
        BinaryTree.printNodesInorder(tree1);
    }

    @Test
    public void shouldGetMidpoint()
    {
        assertThat(new Puzzles().getMidpoint(0, 10), is(5));
        assertThat(new Puzzles().getMidpoint(2, 8), is(5));
    }

    @Test
    public void shouldConvertIntToBytes()
    {
        assertThat(new Puzzles().convertIntToBytes(2), is(new int[]{0, 1, 1}));
        assertThat(new Puzzles().convertIntToBytes(5), is(new int[]{0, 1, 1, 2, 2, 3}));
    }

    @Test
    public void shouldCreateBinaryTreeFromSortedArray()
    {
        BinaryTree root1 = BinaryTree.fromSorted(new int[]{-10, -3, 0, 5, 9});
        assertThat(root1.getValue(), is(0));
        assertThat(root1.getLeft().getValue(), is(-10));
        assertThat(root1.getRight().getValue(), is(5));
        assertThat(root1.getLeft().getRight().getValue(), is(-3));
        assertThat(root1.getRight().getRight().getValue(), is(9));

        BinaryTree root2 = BinaryTree.fromSorted(new int[]{-11, -10, -3, 0, 5, 9, 10});
        assertThat(root2.getValue(), is(0));
        assertThat(root2.getLeft().getValue(), is(-10));
        assertThat(root2.getRight().getValue(), is(9));
        assertThat(root2.getLeft().getLeft().getValue(), is(-11));
        assertThat(root2.getLeft().getRight().getValue(), is(-3));
        assertThat(root2.getRight().getLeft().getValue(), is(5));
        assertThat(root2.getRight().getRight().getValue(), is(10));
    }

    @Test
    public void shouldFindDuplicatesInArray()
    {
        assertThat(new Puzzles().getDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), is(new Integer[]{2, 3}));
        assertThat(new Puzzles().getDuplicates(new int[]{4, 3, 2, 7, 8, 8, 3, 1}), is(new Integer[]{8, 3}));
    }
}