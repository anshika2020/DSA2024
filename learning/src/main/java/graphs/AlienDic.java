package graphs;

public class AlienDic {

    /*
    There is a new alien language that uses the english alphabet. However the order among is unknow to you.
    Given a sorted dictionary of an alien language, find the order of characters in the alphabet.
    You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.
Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.
Example One
Input: ["baa", "abcd", "abca", "cab", "cad"]
Output: "bdac"
  */
/*
 leetcode 269. Alien Dictionary

 learning source: https://www.youtube.com/watch?v=_u1Mn4_2hIo
 */
    /*
    Approach 1: use DAG(Directed Acyclic graph which has no cycle), using topological sort
    We
     */

    public String alienOrder(String[] words) {
    // build adjancency list and indegree list




        //bfs

        return null;
    }
}
