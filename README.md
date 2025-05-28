📦 XMLParser
This is a small Java project designed to transform XML files representing orders into output XMLs representing products. It demonstrates the use of Java's built-in XML processing libraries (javax.xml, org.w3c.dom) for parsing and transformation tasks.
More Problem info in the following doc:
[XML Parser problem.pdf](https://github.com/dragosh45/XMLParser/files/10473037/XML.Parser.problem.pdf)

✅ Features
Parses input order XMLs (e.g., OrderInput.xml, OrderInput2.xml)

Converts data into Product Java objects

Generates structured XML files based on the extracted order data

Automatically watches a directory for new XML files to process

Deletes input files after successful processing

Modular, extensible design using standard Java libraries

📂 Folder Structure
graphql
Copy
Edit
XMLParser/
├── inputXML/       # Drop your input XML files here
├── outputXML/      # Processed XMLs are generated here
├── src/
│   ├── Main.java   # Entry point - contains paths to be adjusted
│   └── ...         # Supporting classes (e.g., parser, model)
└── XML Parser problem.pdf  # Project problem statement
🔧 Technologies Used
Java 8+

javax.xml.parsers & org.w3c.dom

Standard Java I/O

IntelliJ IDEA (Recommended IDE)

🚀 How to Run
1. Open in IntelliJ
Clone or unzip the project.

Open the project in IntelliJ IDEA.

2. Adjust Paths
Modify the input/output paths inside Main.java:

java
Copy
Edit
String inputXMLPath = "your/path/to/inputXML";
String outputXMLPath = "your/path/to/outputXML";
3. Run the Application
Run Main.java.

A continuous loop will watch the inputXMLPath folder for files.

Drop OrderInput.xml or modified variants in /inputXML.

Processed XMLs will appear in /outputXML.

Input files will be automatically deleted after processing.

📝 Input Files
OrderInput.xml: Base example

OrderInput2.xml, OrderInput3.xml: Variants with changes like order number, supplier

🧠 For better simulation of real-time processing, drop files manually one at a time.

📤 Output Files
Generated product XML files will reflect the content and structure derived from order data.

📘 References
See XML Parser problem.pdf for detailed description of the problem statement and expected XML structures.
