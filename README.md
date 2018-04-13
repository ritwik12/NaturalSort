# NaturalSort
Perform natural order comparisons of strings in Java

Most string comparators in programming languages compare strings based on the ASCII values of their individual characters. As an example, consider the following (unsorted) array of strings: <br>

``
[“test2.txt”, “test10.txt”, “test1.txt”] 
``

<br>
If we sort this array using the type an ASCII-value based comparator as described above, the result is the following:<br>

``
[“test1.txt”, “test10.txt”, “test2.txt”] 
``

<br>
However, if you were to create 3 files with these names in the same directory on your computer and viewed the contents of the directory sorted by name using a file manager application (such as the Windows Explorer or the Finder), you will notice that they are actually sorted as follows: <br>

``
[“test1.txt”, “test2.txt”, “test10.txt”]
``

<br>
This ordering is more intuitive to end-users because 10 is bigger than 2. <br>
A whole number is any sequence of numeric characters (0-9) that occur consecutively. So, "1 2 10" would come before "1 10 2" (each of these strings has 3 whole numbers and 2 is less than 10), but "1210" would come after "1102" (each of these strings has 1 whole number and 1102 is less than 1210). For the purposes of this problem, we will not consider any fractional numbers, so '.' and '/' should just be treated as delimiters like any other character. That is to say, "1/5" would come before "1/20" (each of these strings has 2 whole numbers that are compared and 5 is less than 20). We will also not consider negative numbers, meaning that ‘-‘ should be interpreted as a delimiter like any other character (“-1” would come before “-5” because ‘-‘ is equal in both strings and 1 is less than 5).

# Useful Links

[Interface Comparator](https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html) <br>
[Java Comparator interface](https://www.javatpoint.com/Comparator-interface-in-collection-framework)
