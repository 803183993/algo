package com.ace.algorithms1.suffixtree;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class SuffixTreeUnitTest
{
    private static SuffixTree suffixTree;

    @BeforeClass
    public static void setUp()
    {
        suffixTree = new SuffixTree("havanabanana");
        printTree();
    }

    @Test
    public void givenSuffixTree_whenSearchingForA_thenReturn6Matches()
    {
        List<String> matches = suffixTree.searchText("a");
        matches.stream()
                .forEach(m -> System.out.println(m));
        Assert.assertArrayEquals(new String[]{"h[a]vanabanana", "hav[a]nabanana", "havan[a]banana", "havanab[a]nana", "havanaban[a]na", "havanabanan[a]"}, matches.toArray());
    }

    @Test
    public void givenSuffixTree_whenSearchingForNab_thenReturn1Match()
    {
        List<String> matches = suffixTree.searchText("nab");
        matches.stream()
                .forEach(m -> System.out.println(m));
        Assert.assertArrayEquals(new String[]{"hava[nab]anana"}, matches.toArray());
    }

    @Test
    public void givenSuffixTree_whenSearchingForNag_thenReturnNoMatches()
    {
        List<String> matches = suffixTree.searchText("nag");
        matches.stream()
                .forEach(m -> System.out.println(m));
        Assert.assertArrayEquals(new String[]{}, matches.toArray());
    }

    @Test
    public void givenSuffixTree_whenSearchingForBanana_thenReturn2Matches()
    {
        List<String> matches = suffixTree.searchText("ana");
        matches.stream()
                .forEach(m -> System.out.println(m));
        Assert.assertArrayEquals(new String[]{"hav[ana]banana", "havanab[ana]na", "havanaban[ana]"}, matches.toArray());
    }

    @Test
    public void givenSuffixTree_whenSearchingForNa_thenReturn4Matches()
    {
        List<String> matches = suffixTree.searchText("na");
        matches.stream()
                .forEach(m -> System.out.println(m));
        Assert.assertArrayEquals(new String[]{"hava[na]banana", "havanaba[na]na", "havanabana[na]"}, matches.toArray());
    }

    @Test
    public void givenSuffixTree_whenSearchingForX_thenReturnNoMatches()
    {
        List<String> matches = suffixTree.searchText("x");
        matches.stream()
                .forEach(m -> System.out.println(m));
        Assert.assertArrayEquals(new String[]{}, matches.toArray());
    }

    private static void printTree()
    {
        suffixTree.printTree();

        System.out.println("\n" + suffixTree.printTree());
        System.out.println("==============================================");
    }
}
