package com.ace.puzzles;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;

public class BinaryTree
{
    private final int value;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int value, BinaryTree left, BinaryTree right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    private BinaryTree(int value)
    {
        this(value, null, null);
    }

    public static BinaryTree fromUnsorted(Integer[] numbers)
    {
        return createUnsorted(numbers, 1);
    }

    public static BinaryTree fromSorted(int[] numbers)
    {
        return constructSorted(numbers, 0, numbers.length - 1);
    }

    private static BinaryTree createUnsorted(Integer[] input, int index)
    {
        if (index <= input.length)
        {
            Integer value = input[index - 1];
            if (value != null)
            {
                BinaryTree t = new BinaryTree(value);
                t.left = createUnsorted(input, index * 2);
                t.right = createUnsorted(input, index * 2 + 1);
                return t;
            }
        }
        return null;
    }

    private static BinaryTree constructSorted(int[] numbers, int left, int right)
    {
        if (left > right)
        {
            return null;
        }
        int midpoint = (left + right) >>> 1;
        BinaryTree leftNode = constructSorted(numbers, left, midpoint - 1);
        BinaryTree rightNode = constructSorted(numbers, midpoint + 1, right);

        return new BinaryTree(numbers[midpoint], leftNode, rightNode);
    }

    public int getValue()
    {
        return value;
    }

    public BinaryTree getLeft()
    {
        return left;
    }

    public BinaryTree getRight()
    {
        return right;
    }

    public static void printNodesInorder(BinaryTree node)
    {
        if (node == null)
        {
            return;
        }

        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }

    private static void printInorder(BinaryTree root)
    {
        printNodesInorder(root);
    }

    public int getMinimumDepth()
    {
        BinaryTree root = this;
        LinkedList<Pair<BinaryTree, Integer>> queue = new LinkedList<>();
        queue.add(new MutablePair<>(root, 1));

        int currentDepth = 0;
        while (!queue.isEmpty())
        {
            Pair<BinaryTree, Integer> current = queue.poll();
            root = current.getKey();
            currentDepth = current.getValue();
            if (root.left == null && root.right == null)
            {
                break;
            }
            if (root.right != null)
            {
                queue.add(new MutablePair<>(root.left, currentDepth + 1));
            }
            if (root.right != null)
            {
                queue.add(new MutablePair<>(root.right, currentDepth + 1));
            }

        }
        return currentDepth;
    }
}
