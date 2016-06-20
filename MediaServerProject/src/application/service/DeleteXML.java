package application.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import application.constant.Constant;
import application.entity.JavaIOFile;

public class DeleteXML { 
	
	public DeleteXML(JavaIOFile file)  {
    try {

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        File xml=new File(Constant.PATH_LIKED);
        Document document =documentBuilder.newDocument();
        if(!xml.exists()||xml.length()==0)
        	{xml.createNewFile();
        }
        else{
       document =documentBuilder.newDocument();}
        deleteFile(document, file);

    } catch (ParserConfigurationException ex) {
        ex.printStackTrace(System.out);
    } catch (SAXException ex) {
        ex.printStackTrace(System.out);
    } catch (IOException ex) {
        ex.printStackTrace(System.out);
    }
}


private static void deleteFile(Document document, JavaIOFile file) throws TransformerFactoryConfigurationError, DOMException, ParserConfigurationException, IOException, SAXException {


	Element files=document.createElement("Files");
	XMLParser parser=new XMLParser();
	List<JavaIOFile> javaFiles=parser.getList();
	
	for(JavaIOFile fil:javaFiles)
	{
		if(!((fil.getName().equals(file.getName())) && (fil.getPath().equals(file.getPath())))) {
    Element newFile = document.createElement("File");
    Element name = document.createElement("Name");
    name.setTextContent(fil.getName());
    Element isFile = document.createElement("IsFile");
    isFile.setTextContent(Boolean.toString(fil.getIsFile()));
    Element path = document.createElement("Path");
    path.setTextContent(fil.getPath());
    Element length = document.createElement("Length");
    if(fil.getLength()!=null)
    length.setTextContent(fil.getLength().toString());
    else  length.setTextContent("0");
    newFile.appendChild(name);
    newFile.appendChild(isFile);
    newFile.appendChild(path);
    newFile.appendChild(length);
    files.appendChild(newFile);
    }}
	document.appendChild(files);
    writeDocument(document);
}


private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
    try {
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(document);
        FileOutputStream fos = new FileOutputStream(Constant.PATH_LIKED);
        StreamResult result = new StreamResult(fos);
        tr.transform(source, result);
    } catch (TransformerException | IOException e) {
        e.printStackTrace(System.out);
    }
}
}
