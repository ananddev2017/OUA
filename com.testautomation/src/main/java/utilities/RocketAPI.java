package utilities;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
 
public class RocketAPI {
 
    /**
     * Rocket Java API Example
     * Your HTML 2 PDF Rocket API Key, and password to login to our website is: 7c2c63b2-0d2e-44ce-a093-23f59c798ba6
     * Run thru commandline 
     * Param 1: APIKey
     * Param 2: URL or HTML add quote if you have spaces. use single quotes instead of double
     * Param 3: Any extra params you want to add i.e &extra1=value&extra2=value
     * 
     */
 
    static String BaseURL="http://api.html2pdfrocket.com/pdf";
 
    public static void main(String[] args) {
        String API="";
        String Value="";
        String FileName="";
        String ExtraParams="";
        if(args.length>0) API=args[0];
        if(args.length>1) Value=args[1];
        if(args.length>2) FileName=args[2];
        if(args.length>3) ExtraParams=args[3];
        getFile(API,Value,FileName,ExtraParams);
    }
 
    private static void getFile(String APIKey,String value,String Filename,String ExtraParams){
        URL url;
        String Params="";
        try {
            if(ExtraParams!=null&&!"".equals(ExtraParams)){
                Params=ExtraParams;
                if(!Params.substring(0,1).equals("&")){
                    Params="&"+Params;
                }
            }
             
            value=URLEncoder.encode(value,java.nio.charset.StandardCharsets.UTF_8.toString() );
            value+=Params;
 
            // Validate parameters
            if(APIKey==null||"".equals(APIKey)) throw(new Exception("API key is empty"));
            if(Filename==null||"".equals(Filename)) throw(new Exception("Filename is empty"));
 
            // Append parameters for API call
            url = new URL(BaseURL+"?apikey="+APIKey+"&value="+value);
         
            // Download PDF file
            URLConnection connection = url.openConnection();
            InputStream Instream = connection.getInputStream();
 
            // Write PDF file 
            BufferedInputStream BISin = new BufferedInputStream(Instream);
            FileOutputStream FOSfile = new FileOutputStream(Filename);
            BufferedOutputStream out = new BufferedOutputStream(FOSfile);
             
            int i;
            while ((i = BISin.read()) != -1) {
                out.write(i);
            }
 
            // Clean up
            out.flush();
            out.close();
            System.out.println("File "+Filename+" created");
 
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}