package com.alpha.charlie;

/**
 * User: achauhan
 * Date: 10/12/12
 */
public class TreeParser {


    public int find_depth( String s )
    {
        int openCount = 0;
        int totalOpenCount  = 0;
        int nodeCount = 0;
        int depth = -1;

        int i = 0;
        // ((00)(00))
        while (i < s.length()) {
            char a = s.charAt( i );
            switch(a){

                case '(':
                    openCount++; totalOpenCount++;
                    break;

                case '0':
                    nodeCount++;
                    break;

                case ')':
                    openCount--;
                    if( depth < openCount) depth = openCount;
                    break;

                default:
                    return -1;
            }
            i++;
        }
        // A tree with 'n' number of nodes has exactly 'n-1' branches or degree.
        return nodeCount == totalOpenCount + 1 ? depth : -1;
    }

}
