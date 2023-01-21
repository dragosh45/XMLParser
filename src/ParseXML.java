import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class ParseXML {
    String outputXMLPath;
    public ParseXML(String outputXMLPath) {
        this.outputXMLPath = outputXMLPath;
    }

    public ArrayList<Product> getJavaObjects(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
        int orderId = 0;
        String supplierName = null;
        ArrayList<Product> productsArray = new ArrayList<Product>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        NodeList nodeOrderList = document.getDocumentElement().getChildNodes();
        for( int i=0; i<nodeOrderList.getLength(); i++) {
            Node nodeOrder = nodeOrderList.item(i);
            if(nodeOrder.getNodeName().equals("order")) {
                orderId = Integer.parseInt(nodeOrder.getAttributes().getNamedItem("ID").getNodeValue());
            }
            if(nodeOrder.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nodeOrder;
                for(int j=0;j<elem.getChildNodes().getLength();j++) {
                    if(elem.getElementsByTagName("supplier").item(j)!=null) {
                        String description = elem.getElementsByTagName("description").item(j).getChildNodes().item(0).getNodeValue();
                        Float price = Float.parseFloat(elem.getElementsByTagName("price").item(j).getChildNodes().item(0).getNodeValue());
                        String gtin = elem.getElementsByTagName("gtin").item(j).getChildNodes().item(0).getNodeValue();
                        supplierName = elem.getElementsByTagName("supplier").item(j).getChildNodes().item(0).getNodeValue();
                        Product product = new Product();
                        product.setDescription(description);
                        product.setGtin(gtin);
                        product.setPrice(price);
                        product.setOrderId(orderId);
                        product.setSupplierName(supplierName);
                        productsArray.add(product);
                        System.out.println(product.toString());
                    }
                }
            }
        }
        System.out.println(productsArray.size());
        return productsArray;
    }
    public void generateXMLs(ArrayList<Product> productList) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        for (int i=0; i<productList.size(); i++) {
            Product product = productList.get(i);
            //TODO : modify path to the one where ProductXML is generated
            File xmlFile = new File( outputXMLPath + product.getSupplierName() + product.getOrderId()/100 + ".xml");
            FileOutputStream outputFile = null;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            if (xmlFile.exists()) {
                Document documentExistent = docBuilder.parse(xmlFile);

                Element productNode = documentExistent.createElement("product");
                Element rootElement = documentExistent.getDocumentElement();
                rootElement.appendChild(productNode);

                Element description = documentExistent.createElement("description");
                description.setTextContent(product.getDescription());
                productNode.appendChild(description);

                Element gtin = documentExistent.createElement("gtin");
                gtin.setTextContent(product.getGtin());
                productNode.appendChild(gtin);

                Element price = documentExistent.createElement("price");
                price.setTextContent(String.valueOf(product.getPrice()));
                productNode.appendChild(price);

                Element orderId = documentExistent.createElement("orderid");
                orderId.setTextContent(String.valueOf(product.getOrderId()));
                productNode.appendChild(orderId);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(documentExistent);
                StreamResult result = new StreamResult(xmlFile);
                transformer.transform(source, result);

            } else {
                Document newDocument = docBuilder.newDocument();

                Element rootElement = newDocument.createElement("products");
                newDocument.appendChild(rootElement);

                Element productNode = newDocument.createElement("product");
                rootElement.appendChild(productNode);

                Element description = newDocument.createElement("description");
                description.setTextContent(product.getDescription());
                productNode.appendChild(description);

                Element gtin = newDocument.createElement("gtin");
                gtin.setTextContent(product.getGtin());
                productNode.appendChild(gtin);

                Element price = newDocument.createElement("price");
                price.setTextContent(String.valueOf(product.getPrice()));
                productNode.appendChild(price);

                Element orderId = newDocument.createElement("orderid");
                orderId.setTextContent(String.valueOf(product.getOrderId()));
                productNode.appendChild(orderId);

                outputFile = new FileOutputStream(xmlFile, false);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(newDocument);
                StreamResult result = new StreamResult(outputFile);
                transformer.transform(source, result);
            }
        }
    }
}
//TODO : 1. add actual values * done
//       2. write main loop true -> read -> parse
//       3. Refactor some code
//       4. make readme (mention path)