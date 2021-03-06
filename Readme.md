# Problem
write a program that accepts a block of text and outputs the groups of words that are anagrams of each other.

# Solution overview
This project presents two approaches to the problem.

## StringAnagramFinder

This approach takes the sorted value of each word to find prospective anagrams as the key to be used while determining
if others are a compatible anagram. This means that although this implementation works for very large words, it has higher
computational cost due to the sorting of the words themselves.

### Notes
* This implementation is case **insensitive**.
* This implementation is expected to work for all encoding types.

### Complexity analysis

* Assuming input is n characters long time complexity is **O(n^2log(n))**


## PrimeLongKeyedAnagramFinder

This approach is more or less the same but instead of sorting the words and using that as the key in the anagram hash table,
we use a mapping of preselected prime numbers to calculate a multiplicative hash of the words that would be same for all the
words that have the same letters(irrespective of their order).

### Notes

* This implementation will break if the hash value for any word is greater than java.lang.Long.MAX_VALUE.
* This implementation assumes that the input is ASCII and not unicode.
* This implementation is case **insensitive**.

### Complexity analysis

* Assuming input is n characters long time complexity is **O(n^2)**

## How to run

###Tests

The tests can be run using the following command
    mvn test

### PrimeLongKeyedAnagramFinder

To run the PrimeLongKeyedAnagramFinder based implementation
    mvn install -P prime -q -DinputfilePath="/path/to/testdata"

### StringAnagramFinder

To run the PrimeLongKeyedAnagramFinder based implementation
    mvn install -P string -q -DinputfilePath="/path/to/testdata"

## Input data format

For the sake of simplicity the input data in the input file is assumed to be a list of whitespace delimited words.

For example (src/test/resources/testFile1.txt):

    scare races cares another acres car arc kile like ikel none fun foobar barfoo ofoarb

