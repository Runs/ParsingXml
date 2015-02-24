package Dom;

import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
  

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerConfigurationException;  
import javax.xml.transform.TransformerException;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  
  

import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomUpdateXml {
	
    public void update() {  
        Document document = null;  
        try {  
              
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("three_net_signed_zipalign/AndroidManifest.xml");  
             
            Element root = document.getDocumentElement(); 
            document.getDocumentElement().normalize();  
 		   
 		   NodeList  nList = document.getElementsByTagName("meta-data");  
 		   
 		   System.out.println("hello");
 		   for(int  i = 0 ; i<nList.getLength();i++)
 		   {  
 			  // System.out.println("world");
 			   Node  node = nList.item(i);  
 			   Element  ele = (Element)node;  

 			   if(node.getNodeType() == Element.ELEMENT_NODE)
 			   {  
 				  // System.out.println("hello world");
                    if (ele.getAttribute("android:name").equals("wostore_billing_otherpay"))
                    {
                    	System.out.println("have");
                    	ele.setAttribute("android:value", "false");
                    	output(root, "three_net_signed_zipalign/AndroidManifest.xml"); 
                    }
	    		}

 		   }
         
//            root.getElementsByTagName(index).item(count).setTextContent(value);  
//            output(root, "AndroidManifest.xml");  
              
               
        } catch (SAXException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (ParserConfigurationException e) {  
            e.printStackTrace();  
        }  
    }  


    private void updateXml(String xmlFileName,String nodeList,String sAttribute,String sAttributeValue,String updateAttribute,String updateAttributeValue) {
        Document document = null;  
        try {  
              
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFileName);  
             
            Element root = document.getDocumentElement(); 
            document.getDocumentElement().normalize();  
 		   
 		   NodeList  nList = document.getElementsByTagName(nodeList);  
 		   
 		   System.out.println("hello");
 		   for(int  i = 0 ; i<nList.getLength();i++)
 		   {  
 			  // System.out.println("world");
 			   Node  node = nList.item(i);  
 			   Element  ele = (Element)node;  

 			   if(node.getNodeType() == Element.ELEMENT_NODE)
 			   {  
 				  // System.out.println("hello world");
                    if (ele.getAttribute(sAttribute).equals(sAttributeValue))
                    {
                    	System.out.println("have");
                    	ele.setAttribute(updateAttribute, updateAttributeValue);
                    	output(root, xmlFileName); 
                    }
	    		}

 		   }
         
        } catch (SAXException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (ParserConfigurationException e) {  
            e.printStackTrace();  
        }  

	}
    public static void output(Node node, String filename) {  
        TransformerFactory transFactory = TransformerFactory.newInstance();  
        try {  
          Transformer transformer = transFactory.newTransformer();  
          // 设置各种输出属性  
          transformer.setOutputProperty("encoding", "utf-8");  
          transformer.setOutputProperty("indent", "yes");  
          DOMSource source = new DOMSource();  
          // 将待转换输出节点赋值给DOM源模型的持有者(holder)  
          source.setNode(node);  
          StreamResult result = new StreamResult();  
          if (filename == null) {  
            // 设置标准输出流为transformer的底层输出目标  
            result.setOutputStream(System.out);  
          } else {  
            result.setOutputStream(new FileOutputStream(filename));  
          }  
          // 执行转换从源模型到控制台输出流  
          transformer.transform(source, result);  
        } catch (TransformerConfigurationException e) {  
          e.printStackTrace();  
        } catch (TransformerException e) {  
          e.printStackTrace();  
        } catch (FileNotFoundException e) {  
          e.printStackTrace();  
        }  
      }


}
