package exp.nullpointerworks.http.resource;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.nullpointerworks.util.FileUtil;

import exp.nullpointerworks.http.Resource;
import exp.nullpointerworks.http.types.MediaType;

public class GenericResource implements Resource
{
	private String filepath = "<dynamically generated>/";
	private String filename = "";
	private String filelastMod = "";
	private MediaType fileMIME = MediaType.NULL;
	private byte[] filebytes = {};
	private boolean isloaded = false;
	
	public GenericResource(String fname)
	{
		filename = fname;
		var filetype = FileUtil.getFileExtension(fname);
		fileMIME = MediaType.fromFileExtension(filetype);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		filelastMod = sdf.format( new Date() );
	}
	
	public void setData(byte[] data)
	{
		filebytes = data;
		isloaded = true;
	}
	
	@Override public String toString() {return "FILE "+getName()+" - MIME "+getMediaType().getString();}
	@Override public boolean isNull() {return !isloaded;}
	@Override public String getName() {return filename;}
	@Override public String getLastModified() {return filelastMod;}
	@Override public String getPath() {return filepath;}
	@Override public String getExtension() {return fileMIME.getExtension();}
	@Override public MediaType getMediaType() {return fileMIME;}
	@Override public int getLength() {return filebytes.length;}
	@Override public byte[] getBytes() {return filebytes;}
}
