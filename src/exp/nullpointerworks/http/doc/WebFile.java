/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.doc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import com.nullpointerworks.util.StringUtil;

import exp.nullpointerworks.http.types.MIMEType;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class WebFile implements IWebFile 
{
	private String filepath = "";
	private String filename = "";
	private String filelastMod = "";
	private MIMEType fileMIME = MIMEType.NULL;
	private byte[] filebytes = {};
	private boolean isloaded = false;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public WebFile() {}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public WebFile(String path)
	{
		filepath = path;
		processFile(filepath);
	}
	
	private void processFile(String path)
	{
		isloaded = false;
		String[] t = StringUtil.tokenize(path,"/");
		filename = t[t.length-1]; // get filename
		
		t = StringUtil.tokenize(filename,"\\.");
		var filetype = (t)[t.length-1]; // get extension
		fileMIME = MIMEType.fromFileExtension(filetype);
		
		File f = new File(filepath);
		if (!f.exists()) return;
		
		try
		{
			Path rawpath = Paths.get( filepath );
			filebytes = Files.readAllBytes( rawpath );
		} 
		catch (IOException e) {}
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		filelastMod = sdf.format( f.lastModified() );

		isloaded = true;
	}
	
	@Override public boolean isNull() {return !isloaded;}
	@Override public String getName() {return filename;}
	@Override public String getLastModified() {return filelastMod;}
	@Override public String getPath() {return filepath;}
	@Override public String getExtension() {return fileMIME.getExtension();}
	@Override public MIMEType getMIMEType() {return fileMIME;}
	@Override public int getLength() {return filebytes.length;}
	@Override public byte[] getBytes() {return filebytes;}
}
