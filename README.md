# Water Calculator for a landscape with hills and pits 
Test application implementing water calculator for a landscape with hills and pits provided as a collection of heights. 
After rain happens, it's needed to calculate the water amount inside pits between hills.
Max number of positions and max height are 32000.

Technologies
------------

* Java 8
* JUnit 5
* Maven

Running the Application
-----------------------

Run the application as follows:
>     mvn clean package exec:java

You will be asked about the number of positions on the landscape:
>     Please enter the number of positions in landscape:
For example, you can enter 9.
After that you will be asked to provide the heights for each position:
>     Please enter 0 element 5
>     Please enter 1 element 2
>     Please enter 2 element 3
>     Please enter 3 element 4
>     Please enter 4 element 5
>     Please enter 5 element 4
>     Please enter 6 element 0
>     Please enter 7 element 3
>     Please enter 8 element 1
The result will be:
>     Water amount is 9

Tests
-----

The application includes tests to cover several positive and negative scenarios 
