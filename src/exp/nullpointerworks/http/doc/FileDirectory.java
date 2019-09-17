/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.doc;

import exp.nullpointerworks.http.HttpException;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class FileDirectory implements Directory
{
	private String docsPath = "";
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public FileDirectory() { }
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public FileDirectory(String docsPath) 
	{
		setDirectoryPath(docsPath);
	}
	
	/**
	 * Return the document path from which the directory reads
	 * @since 1.0.0
	 */
	public String getPath()
	{
		return docsPath;
	}
	
	@Override
	public void setDirectoryPath(String path) 
	{
		docsPath = path;
	}
	
	@Override
	public String getDirectoryPath()
	{
		return docsPath;
	}
	
	@Override
	public Page getPage(String page) throws HttpException
	{
		String dir = docsPath + page;
		FilePage np = new FilePage(dir);
		if (np.isNull())
		{
			throw new HttpException(404);
		}
		return np;
	}
	
	@Override
	public Page getPage(String page, String... params) throws HttpException
	{
		return getPage(page);
	}
}
