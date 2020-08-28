package base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.testng.Assert;

import utilities.APIcall;
import utilities.DBCall;

public class ImageResizeFunction extends BaseDriver{
	
	MainFunction mainFunc = new MainFunction();
	String pathImageReset="img/mitrais.jpg";
	String sqlQuery="SELECT photo_profile_filename FROM profile WHERE user_id=38";


	public void resetPP(String email, String password) {
		APIcall.login(email,password);
		APIcall.updatePP(pathImageReset);
	}

	public void checkSize() throws ClassNotFoundException, SQLException, MalformedURLException {
		Connection con = mainFunc.setupDB();
        Statement stmt = con.createStatement();
		stmt = con.createStatement();
		ResultSet res = stmt.executeQuery(sqlQuery);
		res.next();
   		String picName = res.getString(1);			
    	String image= "http://chippermitrais.ddns.net/imagefile/download/"+picName;
    	System.out.println(image);
   		int imageSize = 0;

   		final URL uri=new URL(image);
    	URLConnection ucon;
    	try
    	  {
    	  ucon=uri.openConnection();
    	  ucon.connect();
    	  final String contentLengthStr=ucon.getHeaderField("content-length");
    	  imageSize=Integer.parseInt(contentLengthStr);  
  		  //...
   		  }
   		catch(final IOException e1)
   		  {
   		  }
 	
		Assert.assertFalse(imageSize>4194304);
	}

}
