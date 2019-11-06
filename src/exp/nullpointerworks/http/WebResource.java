/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import com.nullpointerworks.util.ArrayUtil;
import com.nullpointerworks.util.StringUtil;
import exp.nullpointerworks.http.types.MIMEType;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class WebResource
{
	private final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private final String filepath;
	private final String filename;
	private final String filelastMod;
	private final MIMEType fileMIME;
	private final byte[] filebytes;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public WebResource(String path) throws IOException
	{
		filepath = path;
		
		File f = new File(filepath);
		if (!f.exists()) throw new FileNotFoundException();
		filelastMod = sdf.format( f.lastModified() );
		
		String[] t = StringUtil.tokenize(path,"/");
		filename = t[t.length-1]; // get filename
		
		t = StringUtil.tokenize(filename,"\\.");
		var filetype = (t)[t.length-1]; // get extension
		fileMIME = MIMEType.fromFileExtension(filetype);
		
		Path rawpath = Paths.get( filepath );
		filebytes = Files.readAllBytes( rawpath );
	}
	
	/**
	 * 
	 * @throws IOException 
	 * @since 1.0.0
	 */
	public WebResource(File f) throws IOException
	{
		if (!f.exists()) throw new FileNotFoundException();
		filepath = f.getAbsolutePath();
		filename = f.getName();
		filelastMod = sdf.format( f.lastModified() );
		fileMIME = getMIMEType(filename);
		InputStream in = new FileInputStream(f);
		filebytes = readAllBytes(in);
		in.close();
	}
	
	/**
	 * 
	 * @throws IOException 
	 * @since 1.0.0
	 */
	public WebResource(InputStream in, String fileName) throws IOException
	{
		filepath = filename = fileName;
		filelastMod = "";
		fileMIME = MIMEType.BIN;
		filebytes = readAllBytes(in);
		in.close();
	}
	
	private final byte[] readAllBytes(InputStream in) throws IOException
    {
		byte[] buffer = new byte[8*1024];
		byte[] total = new byte[0];
		
		while (true)
		{
			byte[] read = readBytes(in, buffer);
			total = ArrayUtil.concatenate(total, read);
			if (read.length != buffer.length) break;
		}
		
		return total;
    }
	
	private final byte[] readBytes(InputStream in, byte[] toread) throws IOException
    {
    	byte[] bytes 	= new byte[0];
    	int allocate 	= in.read(toread);
		if (allocate>0)
		{
			bytes = new byte[allocate];
			int i=0;
			for (byte b : toread) 
			{ 
				if (i>=allocate) break;
				bytes[i++]=b;
			}
		}
		return bytes;
    }
	
	private final MIMEType getMIMEType(String file) 
	{
		String[] t = StringUtil.tokenize(file,"\\.");
		String filetype = (t)[t.length-1]; // get extension
		return MIMEType.fromFileExtension(filetype);
	}
	
	public boolean isNull() {return filebytes==null;}
	public String getName() {return filename;}
	public String getLastModified() {return filelastMod;}
	public String getPath() {return filepath;}
	public MIMEType getMIMEType() {return fileMIME;}
	public String getExtension() {return fileMIME.getExtension();}
	public byte[] getBytes() {return filebytes;}
	public int getLength() {return filebytes.length;}
}
