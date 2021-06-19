package com.ace.algorithms2.entities;

import java.util.*;

public class Graph<T>
{
    private final T value;
    private final Set<Graph<T>> neighbours;

    public Graph(T value)
    {
        this.value = value;
        this.neighbours = new HashSet<>();
    }

    public T getValue()
    {
        return value;
    }

    public Set<Graph<T>> getNeighbours()
    {
        return neighbours;
    }

    public void connect(Graph<T> node)
    {
        if (this == node) throw new IllegalArgumentException("Can't connect node to itself");
        this.neighbours.add(node);
        node.neighbours.add(this);
    }

    /**
     * It adds a node to the queue at most once, therefore visiting it at most once also.
     * Thus, if n is the number of nodes in the tree, the time complexity of the algorithm will be O(n).
     * Now, for the graph algorithm, things are a little bit more complicated. We'll go through each node
     * at most once, but to do so we'll make use of operations having linear-complexity such as addAll() and removeAll().
     * Let's consider n the number of nodes and c the number of connections of the graph. Then, in the worst case (being
     * no node found), we might use addAll() and removeAll() methods to add and remove nodes up to the number of
     * connections, giving us O(c) complexity for these operations. So, provided that c > n, the complexity of the overall
     * algorithm will be O(c). Otherwise, it'll be O(n). This is generally noted O(n + c), which can be interpreted as a
     * complexity depending on the greatest number between n and c.
     */
    public static <T> Optional<Graph<T>> breadthFirstSearch(T value, Graph<T> start)
    {
        Queue<Graph<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Graph<T> currentNode;

        //Set<Node<T>> alreadyVisited = new HashSet<>();
        while (!queue.isEmpty())
        {
            currentNode = queue.remove();
            System.out.println("Visited node with value: {}" + currentNode.getValue());

            if (currentNode.getValue().equals(value))
            {
                return Optional.of(currentNode);
            }
            else
            {
                //alreadyVisited.add(currentNode);
                queue.addAll(currentNode.getNeighbours());
                //queue.removeAll(alreadyVisited);
            }
        }

        return Optional.empty();
    }
}
