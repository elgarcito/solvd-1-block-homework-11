# hardware store
Progressive exercises of QA automation training, using maven and git.

## Project description:
In this project, we have a hardware store that sells different products.

<p align="center">
<img src="https://t4.ftcdn.net/jpg/03/39/67/57/360_F_339675724_zKIsiEcSss6x2KOXUfHMfBrK9b0qbYCQ.jpg" alt="Image of a hardware store" width="300" height="200">
</p>

We represent this product using classes.
We can see the classes and some examples of products that they are going to content:
1. ConstructionProduct: nails, screws, cement, sand etc. we sell it by it units, for ex.
   10 kg of sand.
2. ElectricProduct: cables, electric tape, socket outlet,power drills, hole puncher, etc.
3. HandTool: hammer, hand saw, etc.
4. GardenProduct:shovel, plant pot, etc.
5. HouseholdItem: kettle, broom, brush, etc.
6. WaterProduct:water filter, water pump, etc.
7. GasProduct: gas valve, etc.

Besides that, we have the persons that interact with the store these are:
1. Employee: these are the employees of the store and could be: seller, deposit or owner
2. Supplier: the one that sells us the products
3. BigClient: at the moment, the store only works with big clients that are an small amount and are registered.

## Exercises and references:

### 30/11/2023
* Add 7 collection streaming in the hierarchy with terminal and non-terminal operations.
* Using reflection extract information (modifiers, return types, parameters, etc)
about fields, constructors, methods. 
* Create object and call method using the only reflection.

### Solution
The seven collections streaming were added:
Three of them in the main method, the use for each one:
1. Stream example 1: return a list of only electrical products from an ArrayList<Products>.
2. Stream example 2: return only the product that doesn't have its voltage set from a List<ElectricProduct>, and set it in 230V.
3. Stream example 3: find any Electric product from a List<ElectricProduct> that doesn't have the voltage set.

The next four could be found in the ReadingFile.java class in
the following static methods:
1. findUniqueWord(String wordToFind, String inputFilePath): 
This method looks for a given word in the input file and throws a message
if it exists or if it does not exist.
2. orderWordsByLength(String inputFilePath, String outputFilePath):
This method orders the given words of the input from top to down, according to their length.
After that, write it in the orderWordsByLengthOutput.txt in the resources package.
3. countCharacters(String inputFilePath):
This method counts all the characters in a file (spaces and punctuation are not counted)
4. findAnyNumber(String inputFilePath):
This method throws a message if finds any number in owr text.

The example of using these static functions in each case could be seen in the main method.

To be more clear in the activities output in the console, 
the reflection activity is going to be in the repository:
* solvd-1-block-homework-10-part-2





