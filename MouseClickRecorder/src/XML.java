//package de.vogella.xml.stax.writer;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class XML {
	private String hight,width,size,author,title,directory;
	private HashMap<String,String> dataSets;
	private File configFile;
	public XML(){
		configFile = null;
		hight = null;
		width = null;
		author = null;
		title = null;
		directory = null;
		dataSets = new HashMap<String,String>();
	}
	
	
	public void setFile(File configFile) {
		this.configFile = configFile;
	}
	public File getFile(){
		return configFile;
	
	}
	public void setHight(String hight) {
		this.hight = hight;
	}

	public String getHight() {
		return hight;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	public String getWidth() {
		return width;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getDirectory() {
		return directory;
	}
	public void data(String x, String y){
		dataSets.put(x, y);
	}
    public void generateXML(){
    	
        if (configFile == null){
           	JOptionPane.showMessageDialog(null,
           		    "No file has been selected.",
           		    "File Error",
           		    JOptionPane.ERROR_MESSAGE);

       }else{
    	    
    	   	
   			
   		try{
                   DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                   Document document = documentBuilder.newDocument();
                   Element rootElement = document.createElement(title);
                   document.appendChild(rootElement);
                   Comment MCR = document.createComment      ("'MouseClickRecorder' version:\t 1.1");
                   Comment Author = document.createComment   ("Anotaters_Name        : "+author);
                   Comment FileName = document.createComment ("Image_filename        : "+title);
                   Comment Directory = document.createComment("Image_file_directory  : "+directory);
                   Comment FileSize = document.createComment ("Image_file_size       : "+size);
                   Comment FileHight = document.createComment("Image_height          : "+hight);
                   Comment FileWidth = document.createComment("Image_width           : "+width);
                   rootElement.appendChild(MCR);
                   rootElement.appendChild(Author);
                   rootElement.appendChild(FileName);
                   rootElement.appendChild(Directory);
                   rootElement.appendChild(FileHight);
                   rootElement.appendChild(FileWidth);
                   rootElement.appendChild(FileSize);
                   
                   
                   Set<String> s =dataSets.keySet();
                   Iterator<String> it = s.iterator();
                   System.out.println("Dir: "+directory);
                   while(it.hasNext()){
                	   Element root = document.createElement("DataSet");
                	   String x = it.next();
                	   String data = dataSets.get(x);
                	   System.out.println("Data = "+data);
                	   String element = "Coordinates";
                	   Element Cordinates = document.createElement(element);
                	   Cordinates.appendChild(document.createTextNode(x));
                	   Element Label = document.createElement("Comment");
                	   Label.appendChild(document.createTextNode(data));
                	   root.appendChild(Cordinates);
                	   root.appendChild(Label);
                	   rootElement.appendChild(root);
                   }
                   FileOutputStream fos; 
                   DataOutputStream dos;
                   //File out = new File("D:\\MyFile.xml");
                   fos = new FileOutputStream(configFile);
                   dos = new DataOutputStream(fos);
                   //dos.write(12);
           	   	   //BufferedWriter bf = new BufferedWriter(out);
                   TransformerFactory transformerFactory = TransformerFactory.newInstance();
                   Transformer transformer = transformerFactory.newTransformer();
                   DOMSource source = new DOMSource(document);
                   StreamResult result =  new StreamResult(dos);
                   transformer.transform(source, result);
                   
                   dos.close();
   		}catch(Exception e){
   			System.err.println(e.getMessage());
   			
   		}
      }
   }
}
