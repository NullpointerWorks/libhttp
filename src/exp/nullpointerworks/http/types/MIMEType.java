package exp.nullpointerworks.http.types;

public class MIMEType
{
	private MIMEType() {}
	
	/**
	 * Multi-purpose Internet Mail Extensions. Returns the MIME type associated with the given extension
	 */
	public static String getFromFileExtension(String extension)
	{
		String fileMIME = "";
		// determine MIME subtype
		switch(extension)
		{
			case "aac": fileMIME = "audio/aac"; break;
			case "abw": fileMIME = "application/x-abiword"; break;
			case "arc": fileMIME = "application/x-freearc"; break;
			case "avi": fileMIME = "video/x-msvideo"; break;
			case "azw": fileMIME = "application/vnd.amazon.ebook"; break;
			case "bin": fileMIME = "application/octet-stream"; break;
			case "bmp": fileMIME = "image/bmp"; break;
			case "bz":
			case "bz2": fileMIME = "application/x-bzip"; break;
			case "csh": fileMIME = "application/x-csh"; break;
			case "css": fileMIME = "text/css"; break;
			case "csv": fileMIME = "text/csv"; break;
			case "doc": fileMIME = "application/msword"; break;
			case "docx": fileMIME = "application/vnd.openxmlformats-officedocument.wordprocessingml.document"; break;
			case "eot": fileMIME = "application/vnd.ms-fontobject"; break;
			case "epub": fileMIME = "application/epub+zip"; break;
			case "gif": fileMIME = "image/gif"; break;
			case "htm":
			case "html": fileMIME = "text/html"; break;
			case "ico": fileMIME = "image/vnd.microsoft.icon"; break;
			case "ics": fileMIME = "text/calendar"; break;
			case "jar": fileMIME = "application/java-archive"; break;
			case "jpeg":
			case "jpg": fileMIME = "image/jpeg"; break;
			case "mjs":
			case "js": fileMIME = "text/javascript"; break;
			case "json": fileMIME = "application/json"; break;
			case "jsonld": fileMIME = "application/ld+json"; break;
			case "mid":
			case "midi": fileMIME = "audio/midi"; break; // audio/x-midi
			case "mp3": fileMIME = "audio/mpeg"; break;
			case "mpeg": fileMIME = "video/mpeg"; break;
			case "mpkg": fileMIME = "application/vnd.apple.installer+xml"; break;
			case "odp": fileMIME = "application/vnd.oasis.opendocument.presentation"; break;
			case "ods": fileMIME = "application/vnd.oasis.opendocument.spreadsheet"; break;
			case "odt": fileMIME = "application/vnd.oasis.opendocument.text"; break;
			case "oga": fileMIME = "audio/ogg"; break;
			case "ogv": fileMIME = "video/ogg"; break;
			case "ogx": fileMIME = "application/ogg"; break;
			case "otf": fileMIME = "font/otf"; break;
			case "png": fileMIME = "image/png"; break;
			case "pdf": fileMIME = "application/pdf"; break;
			case "ppt": fileMIME = "application/vnd.ms-powerpoint"; break;
			case "pptx": fileMIME = "application/vnd.openxmlformats-officedocument.presentationml.presentation"; break;
			case "rar": fileMIME = "application/x-rar-compressed"; break;
			case "rtf": fileMIME = "application/rtf"; break;
			case "sh": fileMIME = "application/x-sh"; break;
			case "svg": fileMIME = "image/svg+xml"; break;
			case "swf": fileMIME = "application/x-shockwave-flash"; break;
			case "tar": fileMIME = "application/x-tar"; break;
			case "tif":
			case "tiff": fileMIME = "image/tiff"; break;
			case "ttf": fileMIME = "font/ttf"; break;
			case "txt": fileMIME = "text/plain"; break;
			case "vsd": fileMIME = "application/vnd.visio"; break;
			case "wav": fileMIME = "audio/wav"; break;
			case "weba": fileMIME = "audio/webm"; break;
			case "webm": fileMIME = "video/webm"; break;
			case "webp": fileMIME = "image/webp"; break;
			case "woff": fileMIME = "font/woff"; break;
			case "woff2": fileMIME = "font/woff2"; break;
			case "xhtml": fileMIME = "application/xhtml+xml"; break;
			case "xls": fileMIME = "application/vnd.ms-excel"; break;
			case "xlsx": fileMIME = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"; break;
			case "xml": fileMIME = "application/xml"; break; // text/xml
			case "xul": fileMIME = "application/vnd.mozilla.xul+xml"; break;
			case "zip": fileMIME = "application/zip"; break;
			case "3gp": fileMIME = "video/3gpp"; break; // audio/3gpp
			case "3g2": fileMIME = "video/3gpp2"; break; // audio/3gpp2
			case "7z": fileMIME = "application/x-7z-compressed"; break;
			default: fileMIME = "application/octet-stream"; break;
		}
		return fileMIME;
	}
}
