package exp.nullpointerworks.http.doc;

import exp.nullpointerworks.http.HttpException;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public interface Directory
{
	/**
	 * Provide the root directory 
	 * @since 1.0.0
	 */
	void setDirectoryPath(String httpdocs);
	
	/**
	 * Returns the read directory
	 * @since 1.0.0
	 */
	String getDirectoryPath();
	
	/**
	 * Returns a Page object that represents the file in the home directory
	 * @since 1.0.0
	 */
	Page getPage(String page) throws HttpException;
	
	/**
	 * Returns a Page object that represents the file in the home directory. This method also allows for parameters passed with a page, like when using a GET method.
	 * @since 1.0.0
	 */
	Page getPage(String page, String... params) throws HttpException;
}