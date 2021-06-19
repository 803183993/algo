package com.ace.algorithms2.entities;

import java.util.*;

public class Tree<T>
{
    private final T value;
    private final List<Tree<T>> children;

    private Tree(T value)
    {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public static <T> Tree<T> of(T value)
    {
        return new Tree<>(value);
    }

    public T getValue()
    {
        return value;
    }

    private List<Tree<T>> getChildren()
    {
        return children;
    }

    public Tree<T> addChild(T value)
    {
        Tree<T> newChild = new Tree<>(value);
        children.add(newChild);
        return newChild;
    }

    public static <T> Optional<Tree<T>> breadthFirstSearch(T value, Tree<T> root)
    {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            Tree<T> currentNode = queue.remove();
            if (currentNode.getValue().equals(value))
            {
                return Optional.of(currentNode);
            }
            else
            {
                queue.addAll(currentNode.getChildren());
            }
        }

        return Optional.empty();
    }
}
