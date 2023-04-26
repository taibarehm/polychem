package com.Bussin.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import  com.Bussin.client.GreetingService;
import com.Bussin.shared.AdminL;
import  com.Bussin.shared.Event;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

import gwt.material.design.jscore.client.api.Document;

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	   
	 int i=0;
     MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
     DB db = mongo.getDB("Scrub" );
     GridFS fss = new GridFS( db );
	 public static byte[] LoadImage(String filePath) throws Exception {
	        File file = new File(filePath);
	        int size = (int)file.length();
	        byte[] buffer = new byte[size];
	        FileInputStream in = new FileInputStream(file);
	        in.read(buffer);
	        in.close();
	        return buffer;
	    }

	@Override
	public String Login(String s1, String s2) throws IllegalArgumentException {
		String ss="not found";
		System.out.println(" Login(String s1, String s2)");
		try {
			
			 BasicDBObject query = new BasicDBObject();
			query.put("username" ,s1);
			query.put("pwd" ,s2);
			DBCollection colln= db.getCollection("Scrublogin");
		
			DBCursor auth=colln.find(query);
			if(auth.hasNext()) {
				System.out.println(colln.findOne());
				ss="yes";
			
		}
		}catch(Exception e)
		{
			System.out.print("datbase failed");
		}
		return ss;
	}


	@Override
	public Event[] eventdisplay(String s5) throws IllegalArgumentException {
		   System.out.println("into eventdisplay(String s5)");
		   DBCollection disAdminLoad = db.getCollection("Admload");
		   BasicDBObject query = new BasicDBObject();
		   DBCollection collectionAdminLoad1 = db.getCollection("fs.files");
			
			String s1=(String) query.get("productname");
			String s2= (String)query.get("Detail");
			String s3= (String) query.get("Cost");
			
			List<DBObject> itd= disAdminLoad.find(query).toArray();
			List<DBObject> image1= collectionAdminLoad1.find().toArray();
			
			  
			
			 
			System.out.println(itd);
			System.out.println(image1);
			Event e[]=new Event[itd.size()];
			try {
			//int k=(int) disAdminLoad.count();
			//while(it.hasNext())
			for(int a=0;a<itd.size();a++)
				
			{  
				String s14=(String)itd.get(a).get("_id");
				String s11=(String) itd.get(a).get("productname");
				String s22= (String)itd.get(a).get("Detail");
				String s33= (String)itd.get(a).get("Cost") ;
				String s24=(String)image1.get(a).get("_id");
				String filname=(String)image1.get(a).get("filename");
				String msd=(String)image1.get(a).get("md5");
				System.out.println(msd);
				if(s14.equals(s24)) {
			   e[a]=new Event();
			   
			   e[a].setPname(s11);
	           e[a].setDetail(s22);    
	           e[a].setCost(s33);
	           e[a].setImage(filname);
	           e[a].setMsd(msd);;
	           
				}
			   //i++;
			}
		} catch (Exception ev) {
			// TODO: handle exception
			ev.printStackTrace();
		}
		return e;
	}


	@Override
	public String Uploa(AdminL lo) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("into Uploa(AdminL lo)");
		//
		String ss="Submited";
		String s1=lo.img;
		String[ ] token=s1.split("[\\\\|/]");
		String Filenmae= token[token.length-1];
		
		if(s1.isEmpty())
		{
			ss="file Not found";
		}
		try{
			byte[] imageBytes = LoadImage("C:/Users/owner/eclipse-workspace/SamiyaTaiba/war/image/"+Filenmae);
			String newFileName = Filenmae;
			DBCollection collectionAdminLoad = db.getCollection("Admload");
			
			BasicDBObject dodet= new BasicDBObject();
			dodet.put( "_id" ,lo.ID);
			dodet.put("productname",lo.Name);
		    dodet.put("filename",Filenmae);
		    dodet.put("Detail",lo.Detail);
		    dodet.put("Cost",lo.Cost);
		    collectionAdminLoad.insert(dodet);
		        //Create GridFS object
		       
		      
		        //Save image into database
		        GridFSInputFile in = fss.createFile( imageBytes );
		        in.setFilename(newFileName);
		        in.setId(lo.ID);
		        in.save();

		        //Find saved image
		        GridFSDBFile out = fss.findOne(dodet);

		        //Save loaded image from database into new image file
		        FileOutputStream outputImage = new FileOutputStream("C:/Users/owner/eclipse-workspace/SamiyaTaiba/war/image/"+Filenmae);
		        

				DBCursor cursor = fss.getFileList();
				
				while (cursor.hasNext()) {
					System.out.println(cursor.next());
				
				}
				

				
				System.out.println("Done");
		        
		        outputImage.close();
		       
		}
    	catch(Exception e)
		
    	{
    		e.printStackTrace();
    		
    	}
		
		return ss;
	}


	

	
	
}
