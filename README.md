# XMLParser
XML Parser Project problem.  Problem info in the following doc:
[XML Parser problem.pdf](https://github.com/dragosh45/XMLParser/files/10473037/XML.Parser.problem.pdf)

Solution description:

1. The program will create Product Java Objects from the Order.xml file
2. Then it will generate Product.xml files from the Objects
3. A continuous loop runs reading new XML files and deleting XML files after they are processed

-it uses javax.xml and org.w3c.dom libraries to parse and transform

How to use:

1.Open project with IntelliJ 
2.Modify path for input and output XMLs 
    -modify String inputXMLPath in Main.java
    -modify String outputXMLPath in Main.java
3.Run the program from Main class
4.Copy XML files from the /src in the /inputXML
   -the OrderInput.xml is the original XML file
   -the OrderInput2.xml and OrderInput3.xml have small modifications like order number and    supplier name
    -can copy and paste files 1 by one in order to reflect the problem use case
5.Right click on the project name directory and left click Reload From Disk 
6.Product XML files will appear in the outputXML

