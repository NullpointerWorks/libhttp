/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import com.nullpointerworks.util.ArrayUtil;
import com.nullpointerworks.util.StringUtil;

import exp.nullpointerworks.http.HttpException;
import exp.nullpointerworks.http.Resource;
import exp.nullpointerworks.http.types.MediaType;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class FileResource implements Resource
{
	private final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private final String filepath;
	private final String filename;
	private final String filelastMod;
	private final MediaType fileMIME;
	private final byte[] filebytes;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public FileResource(String path) throws HttpException, IOException
	{
		this( new File(path) );
	}
	
	/**
	 * 
	 * @throws IOException 
	 * @since 1.0.0
	 */
	public FileResource(File f) throws HttpException, IOException
	{
		if (!f.exists()) throw new HttpException(404);
		
		filepath = f.getAbsolutePath();
		filelastMod = sdf.format( f.lastModified() );
		
		String[] t = StringUtil.tokenize(filepath,"/");
		filename = t[t.length-1];
		
		t = StringUtil.tokenize(filename,"\\.");
		var filetype = (t)[t.length-1]; // get extension
		fileMIME = MediaType.fromFileExtension(filetype);
		
		Path rawpath = Paths.get( filepath );
		filebytes = Files.readAllBytes( rawpath );
	}
	
	/**
	 * 
	 * @throws IOException 
	 * @since 1.0.0
	 */
	public FileResource(InputStream in, String fileName) throws IOException
	{
		filepath 	= filename = fileName;
		filelastMod = "";
		fileMIME 	= MediaType.fromFileExtension(fileName);
		filebytes 	= readAllBytes(in);
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
	
	@Override public boolean isNull() {return filebytes==null;}
	@Override public String getName() {return filename;}
	@Override public String getLastModified() {return filelastMod;}
	@Override public String getPath() {return filepath;}
	@Override public MediaType getMediaType() {return fileMIME;}
	@Override public String getExtension() {return fileMIME.getExtension();}
	@Override public byte[] getBytes() {return filebytes;}
	@Override public int getLength() {return filebytes.length;}
}
