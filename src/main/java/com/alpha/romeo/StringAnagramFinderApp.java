package com.alpha.romeo;


import java.io.IOException;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class StringAnagramFinderApp {

    public static void main( String[] args ) throws IOException {

        // Check if required number of arguments are given.
        if(args.length < 1) {
            System.out.println("Usage: Input file path must be specified.");
            return;
        }
        System.out.println("Reading file: " + args[0] + "\n");
        DataReader reader = new FileDataReader(args[0]);

        AnagramFinder anagramFinder = new StringKeyedAnagramFinder(reader);

        Map result = anagramFinder.getAnagramMap();

        System.out.println(new PrettyPrintingMap(result));
    }

}
