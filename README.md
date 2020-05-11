# Bowling Assignment

Original Assignment Description [found here](https://github.com/skat/bowling-opgave)

**Language**: *Java* 
  
**Version**: *Java 11.0.2* - *JDK 10.0.2*  

**Project Type**: *Java Maven*

**Created with IDE**: *IntelliJ 2020.1*

##
### How to run:

* Open the project folder *Bowling* using an IDE that can compile and run *Java* Applications (Ex: [Netbeans](https://netbeans.org/) or [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows))
* Make sure the IDE is pointing on the ***Main***-java. 
    * Alternative, right click on the ***Main***-file (should be located *Bowling/src/main/java/com.company/main.java*)
* Current results should be shown in the console as text elements
* Run the application
    * Results are shown in the console and posted through the POST-API
#

### Incomplete Work and minor thoughts

* General
    * Assignment is far from complete, which I'm not happy or satisfied with, at all.
    * Not keeping in line with SOLID principles
    * Java Application with Maven Framework, for quick and easy access to new libraries and dependencies.
    * Code should be generally well-commented, perhaps too much.
    
* Bowling Score
    * Not working 100% as intended
    * The project does not present a "true" algorithm, right now, it's more functions and methods.
    * Code is (as of this writing) is not very nice
    * While some attempts might provided successful results, there are still an unknown amount of cases and scenarios, that needs to be handled and managed.

* Retrieve Data
    * Application is able to fetch the data with no issues.
    * The Data is managed and converted for better handling with OOP.
    * Though the application is capable of retrieving the data, I'm not satisfied with the way I'm converting the data to a manageable Object, mainly due to the choice of JSON-library
    
* Send Data
    * The functionality for sending data has been build.
    * Only missing work needed, is testing sending actual data and results.
         
* Test
    * JUnit 5.4 was chosen for the project 
    * Did not complete any major or minor testing of the actual program
 
 ##
 #### Order of Approach
 
 * Back to *Java*
 * Adding *Maven*-framework, in order to easier access external libraries through dependencies
 * GET the data
 * Create objects to contain the data
 * Convert the data to be more easily accessible 
 * Manipulate the data
 * Exploration into how to do the calculations
 * Make it possible to POST the data
 * Commenting code
 * Getting trapped in the creation of the calculations
 * Kept working on the calculations, bloating the Calculations.java-file
 * Main.java also got semi-bloated
 * Few stabs at testing with JUNIT
 * Big clean-up of code, but never enough.
 
 ##
 
 ### Misc   
 ![alt text](bowlingp1.JPEG)
 ![alt text](bowlingp2.JPEG)
 ![alt text](bowlingp3.JPEG)
 ## 
     