import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        //TODO : modify path to the one where OrderXML is copied
        //TODO : modify path to the one where OrderXML is copied
        String inputXMLPath = "C:\\XMLParser\\inputXML\\";
        String outputXMLPath = "C:\\XMLParser\\outputXML\\";
        ParseXML parseXML = new ParseXML(outputXMLPath);
        File directory = new File(inputXMLPath);
        File[] files = directory.listFiles();
        ArrayList<Product> productList = new ArrayList<>();
        int i = 0;
        while (true) {
            if (i < files.length) {
                productList = parseXML.getJavaObjects(files[i]);
                parseXML.generateXMLs(productList);
                files[i].delete();
                i++;
            }
            parseXML = new ParseXML(outputXMLPath);
            directory = new File(inputXMLPath);
            files = directory.listFiles();
            productList = new ArrayList<>();
            i = 0;
        }
    }
}




