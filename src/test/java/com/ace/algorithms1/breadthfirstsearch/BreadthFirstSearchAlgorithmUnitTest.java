package com.ace.algorithms1.breadthfirstsearch;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BreadthFirstSearchAlgorithmUnitTest
{
    private Tree<Integer> root;
    private Tree<Integer> rootFirstChild;
    private Tree<Integer> depthMostChild;
    private Tree<Integer> rootSecondChild;

    private Node<Integer> start;
    private Node<Integer> firstNeighbor;
    private Node<Integer> firstNeighborNeighbor;
    private Node<Integer> secondNeighbor;

    @Test
    public void givenTree_whenSearchTen_thenRoot()
    {
        initTree();
        assertThat(BreadthFirstSearchAlgorithm.search(10, root).isPresent(), is(true));
    }

    @Test
    public void givenTree_whenSearchThree_thenDepthMostValue()
    {
        initTree();
        assertThat(BreadthFirstSearchAlgorithm.search(3, root).get(), is(depthMostChild));
    }

    @Test
    public void givenTree_whenSearchFour_thenRootSecondChild()
    {
        initTree();
        assertThat(BreadthFirstSearchAlgorithm.search(4, root).get(), is(rootSecondChild));
    }

    @Test
    public void givenTree_whenSearchFive_thenNotFound()
    {
        initTree();
        assertThat(BreadthFirstSearchAlgorithm.search(5, root).isEmpty(), is(true));
    }

    private void initTree()
    {
        root = Tree.of(10);
        rootFirstChild = root.addChild(2);
        depthMostChild = rootFirstChild.addChild(3);
        rootSecondChild = root.addChild(4);
    }

    @Test
    public void givenNode_whenSearchTen_thenStart()
    {
        initNode();
        assertThat(BreadthFirstSearchAlgorithm.search(10, firstNeighborNeighbor).get(), is(start));
    }

    @Test
    public void givenNode_whenSearchThree_thenNeighborNeighbor()
    {
        initNode();
        assertThat(BreadthFirstSearchAlgorithm.search(3, firstNeighborNeighbor).get(), is(firstNeighborNeighbor));
    }

    @Test
    public void givenNode_whenSearchFour_thenSecondNeighbor()
    {
        initNode();
        assertThat(BreadthFirstSearchAlgorithm.search(4, firstNeighborNeighbor).get(), is(secondNeighbor));
    }

    @Test
    public void givenNode_whenSearchFive_thenNotFound()
    {
        initNode();
        assertThat(BreadthFirstSearchAlgorithm.search(5, firstNeighborNeighbor).isEmpty(), is(true));
    }

    private void initNode()
    {
        start = new Node<>(10);
        firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);

        firstNeighborNeighbor = new Node<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);

        secondNeighbor = new Node<>(4);
        start.connect(secondNeighbor);
    }
}