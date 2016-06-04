# criminal_db

### Use

To use the software, navigate to the directory containing ``CrimeBoard.jar`` in terminal and issue the command:

>``>> java -jar CrimeBoard.jar``

**NOTE:** Make sure that a Concourse server is running, otherwise the database will not function.

### Introduction

I decided to implement a criminal database using ConcourseDB, to mimic the functionality of classic crime boards, as shown below.

![A classic crime board](resources/crime_board.png "A classic crime board")

When reading about the architecture of the ConcourseDB model, an image of scattered data with interconnections popped into my mind. The lack of schema promotes this, and the model is perfect for modeling clumps of "records" that can be linked together. This is very similar to the concept of the crime board, and the lightweight nature of ConcourseDB encouraged me to implement such a database for potentially large cases that would be inadequately solved using a traditional relational database.

This philosophy further encouraged me to pursue an aspect of visualization in my application, in order to truly imitate the function of the crime board. Thus, users are able to visualize the database they are building, and quickly see which cases are linked together in order to uncover some underlying pattern or truth.


### Overview

Here is a rundown of the basic application:

There are three tabs:

1. **Data Entry.** Here, users can enter a crime to be established as a record in the database. They input the perpetrator's name, the victim's name, the location of the offense, the kind of offense, and whether or not the perpetrator was captured.

2. **Data Connection.** Here, users are able to link together crimes in order to build their crime board. This is an essential component of ConcourseDB, and enables discrete clusters of data to exist as part of larger structures.

3. **Data Visualization.** Here, users can see the database they have built. Hovering over each circle allows the user to see the crime, and explore patterns.

### Scope for extension

This was a quick and dirty implementation, but there is great scope for this application. For one, a more sophisticated entry system could be developed to allow for multiple perps or victims, and detail regarding weapons, time, and more. Another potential extension is to improve the visualization such that hovering over a crime highlights all crimes to which it is linked. With a large database, this would be easier than following lines which may get confusing. Lastly, allowing the user to query the data would be useful, and would use Concourse as completely as possible given its natural language querying functionality.
