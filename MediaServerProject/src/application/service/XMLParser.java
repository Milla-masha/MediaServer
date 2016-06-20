package application.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import application.constant.Constant;
import application.entity.JavaIOFile;

public class XMLParser {

	List <JavaIOFile> list;
	
	public List<JavaIOFile> getList() {
		return list;
	}

	public void setList(List<JavaIOFile> list) {
		this.list = list;
	}

	public XMLParser() throws ParserConfigurationException, IOException, SAXException{

			list=new ArrayList<JavaIOFile>();
	            try {	
	                File inputFile = new File(Constant.PATH_LIKED);
	                if(!inputFile.exists()||inputFile.length()==0)
	                	inputFile.createNewFile();
	                else{
	                DocumentBuilderFactory dbFactory 
	                   = DocumentBuilderFactory.newInstance();
	                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	                Document doc = dBuilder.parse(inputFile);
	                doc.getDocumentElement().normalize();
	                NodeList nList = doc.getElementsByTagName("File");
	                for (int temp = 0; temp < nList.getLength(); temp++) {
	                	JavaIOFile listFile=new JavaIOFile();
	                   Node nNode = nList.item(temp);
	                   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	                      Element eElement = (Element) nNode;
	                    listFile.setName( eElement
	                         .getElementsByTagName("Name")
	                         .item(0)
	                         .getTextContent());
	                     listFile.setFile(eElement
	                         .getElementsByTagName("IsFile")
	                         .item(0)
	                         .getTextContent());
	                      listFile.setPath( eElement
	                         .getElementsByTagName("Path")
	                         .item(0)
	                         .getTextContent());
	                      listFile.setLength( eElement
	                         .getElementsByTagName("Length")
	                         .item(0)
	                         .getTextContent());
	                   }
	                list.add(listFile);   
	                }
	                }
	             } catch (Exception e) {
	                e.printStackTrace();
	             }
	            }
	}
