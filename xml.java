 XmlSerializer serializer = Xml.newSerializer();  
		    StringWriter writer = new StringWriter(); 
		    try{
		    	 serializer.setOutput(writer);  
		         serializer.startDocument("UTF-8",true);  
		        List<String> alist=new ArrayList<String>();//list是用来写入多行标签值的
		        List<String> blist=new ArrayList<String>();
                      for(int i=0;i<alist.size();i++){
			 serializer.startTag("","string");  
	         serializer.attribute("","name",blist.get(i)); 
	         serializer.text(alist.get(i).toString());  
	         serializer.endTag("","string");
		                                    }
                   serializer.endDocument();
         //前面是xml生成，下面是写入文件
          File newxmlfile = new File(Environment.getExternalStorageDirectory(),"aaa.xml");

        try{
          if(!newxmlfile.exists())
                 newxmlfile.createNewFile();
         }catch(IOException e){
             Log.e("IOException", "exception in createNewFile() method");
     
         }
        
        try  
        {  
        	FileOutputStream fos = new FileOutputStream(newxmlfile);
        	fos.write(writer.toString().getBytes());
        	fos.close();
        }  
        catch(Exception e){  
         e.printStackTrace();  
        }  
		
 
                       }catch(Exception e){}

                    
            