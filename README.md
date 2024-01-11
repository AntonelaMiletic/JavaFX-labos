Project Overview  
This project is a Java application that manages and categorizes various items, focusing on food and technical products. The application includes functionalities for 
reading data from text files in JavaFX, creating entities such as categories, items, factories, and stores, and storing them in corresponding data structures. 
It allows users to add, search, and view information about these entities through a graphical user interface.
The application uses files (categories.txt, factories.txt, items.txt, stores.txt) to store and retrieve information about categories, factories, items, and stores.
This Java application showcases fundamental concepts such as object-oriented programming,
file handling, generics, and enums. It serves as a foundation for managing and categorizing items in different domains, offering potential for further expansion and refinement.
  
Structure (src/main)  
Java Classes(Model)  
•	Category: represents a product category  
•	Item: base class for different types of items (edible, technical)  
•	Edible: interface defining methods for edible items  
•	Technical: interface defining methods for technical items  
•	Factory: represents a factory that produces items  
•	Store: represents a store that sells items  
  
Enums  
•	Gradovi: enum defining different cities  
  
Generic classes  
•	FoodStore: generic class representing a store specializing in food items  
•	TechnicalStore: generic class representing a store specializing in technical items  
•	FoodStore: generic class representing a store specializing in food items  
•	TechnicalStore: generic class representing a store specializing in technical items  
  
File Handling  
The FileUtils class provides methods to read data from text files and populate corresponding data structures. It includes methods to get categories, items, factories, and stores from files.  
  
AddressBuilder  
The AddressBuilder class is a builder pattern implementation for creating Address objects.  
  
Screen Controllers  
•	Users can search for entities based on ID  
•	The search results are displayed in a TableView  
  
Add Controllers  
•	Users can input entities' details  
•	Clicking the "Add" button triggers the addition of entity to the database.  
  
Hello Application  
•	responsible for launching the JavaFX application and initializing the main stage  
• contains lists for categories, items, factories, and stores, which are loaded from external files using FileUtils  
  
FXML  
FXML code for several JavaFX views  
  
•	JavaFX: Used for building the graphical user interface.  
•	Maven: Project management and build tool.  
•	JUnit: Testing framework for unit testing.  
  
How to use  
2.	Open the project in your preferred Java IDE(I used intellij)  
3.	Run the application, and it will read data from the provided text files (categories.txt, factories.txt, items.txt, stores.txt)   

