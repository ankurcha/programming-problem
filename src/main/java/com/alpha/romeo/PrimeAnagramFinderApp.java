package com.alpha.romeo;


import java.io.IOException;
import java.util.Map;

/**
 * Uses the prime number implementation of the anagram finder
 *
 */
public class PrimeAnagramFinderApp {

    public static void main( String[] args ) throws IOException {

        // Check if required number of arguments are given.
        if(args.length < 1) {
            System.out.println("Usage: Input file path must be specified.");
            return;
        }

        DataReader reader = new FileDataReader(args[0]);

        AnagramFinder anagramFinder = new PrimeLongKeyedAnagramFinder(reader);

        Map result = anagramFinder.getAnagramMap();

        System.out.println(new PrettyPrintingMap(result));
    }

}
