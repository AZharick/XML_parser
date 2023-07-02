package MLabs;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = dbf.newDocumentBuilder();
      Document doc = builder.parse("data.xml");
      NodeList bookNodeList = doc.getElementsByTagName("book");
      List<Book> bookList = new ArrayList<>();

      for (int i = 0; i < bookNodeList.getLength(); i++) {
         if (bookNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
            Element bookElement = (Element) bookNodeList.item(i);
            Book book = new Book();
            NodeList children = bookElement.getChildNodes();

            for (int j = 0; j < children.getLength(); j++) {
               if(children.item(j).getNodeType() == Node.ELEMENT_NODE){
                  Element child = (Element) children.item(j);

                  switch (child.getNodeName()) {
                     case "name":
                        book.name = child.getTextContent();
                        break;
                     case "author":
                        book.author = child.getTextContent();
                        break;
                  }
               }
            }
            bookList.add(book);
         }
      }
      for (Book b:bookList) {
         System.out.println(b.toString());
      }

   } //end of psvm
}