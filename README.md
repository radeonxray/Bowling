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

### Incomplete Work and minor thoughts V1

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
 
 #
 
 ### Incomplete Work, issues and minor thoughts V2
 
 * Generel
    * A LOT better overview and code readability
    * GET and POST are still working with the new calculations
    
* Calculations
    * New and improved calculations!
    * Because of the rule that if a game ends prematurely the last score has to counted as just a normal-score, no matter if it was a strike or spare, thus no bonus, I decided that it would have a knock-on effect of the previous scores also.
      * Ex: The last 3 scores are strikes, X, X,X, the final score will then be [10,20,30]

* Test 
    * Lots more Test have been done!
    * While a lot more testing has been done than previously, it could have been more thoroughly and more detailed

* Issues
    * There are a few issues with the Calculations in SpareCalculationsVerTwo, Testing shows this too.
        
 
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
 * Wanted to simulate as close as possible to the application calculating each score as they are presented, from left to right, like on a real bowling-ally
 * Kept working on the calculations, bloating the Calculations.java-file
 * Main.java also got semi-bloated
 * Few stabs at testing with JUNIT
 * Big clean-up of code, but never enough.
 
 ---------
 
 * Handed-in link to Michael sunday evening
 * I was very disappointed, frustrated, irritated and annoyed by my case-performance 
 * Decided to make a few adjustments to the version that I submitted, particularly the code overview, that still ended up being a mess
 * Effects of finishing studies 4 months ago, cool-down, too much excitement and energy to prove myself, might have resulted in my rush and lack of quality and functionality.
 * Despite the expiration of the Deadline, I decided to redo the calculations from scratch (minus the POST and GET functionality).
 * Focused on working in a slower tempo, build and construct more in-line of what I would expect, with comments and better use of classes, functions and OOP.
 * Testing was done a lot more in conjunction while writing the code
 * Finally got a better handling of the Algorithm.
 * Despite all the greate improvements, I did not manage to completely finish the algorithm.
 * There is are few issue with the calculation of Spares in the SpareCalculationsVerTwo.java, which the Test that I've created for the class also shows.
 * I left some souts in the code, mostly so I can more easilier identify what and where the issues are, but I've cut a lot back.
 * Wrapped up development, made sure that the Main got updated with the new CalculationsVerTwo and that the GET and POST calls work in conjunction with the new Calculations.
 * Despite not being 100% complete with the assignment, I'm a lot more satisfied about my work. 
  
***Note: This update was written at 05:28 13/05-2020... about 3 hours before the interview*** 
 ##
 
 ### Misc   
 ![alt text](bowlingp1.JPEG)
 ![alt text](bowlingp2.JPEG)
 ![alt text](bowlingp3.JPEG)
 ## 
     
