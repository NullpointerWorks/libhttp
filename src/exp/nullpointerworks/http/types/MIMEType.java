/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.types;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public enum MIMEType
{
	/**
	 * 
	 * @since 1.0.0
	 */
	NULL("","null"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	AAC("aac","audio/aac"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ABW("abw","application/x-abiword"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ARC("arc","application/x-freearc"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	AVI("avi","video/x-msvideo"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	AZW("azw","application/vnd.amazon.ebook"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	BIN("bin","application/octet-stream"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	BMP("bmp","image/bmp"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	BZ("bz","application/x-bzip"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	BZ2("bz2","application/x-bzip"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CSH("csh","application/x-csh"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CSS("css","text/css"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CSV("csv","text/csv"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	DOC("doc","application/msword"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	DOCX("docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	EOT("eot","application/vnd.ms-fontobject"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	EPUB("epub","application/epub+zip"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	GIF("gif","image/gif"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	HTM("htm","text/html"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	HTML("html","text/html"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ICO("ico","image/vnd.microsoft.icon"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ICS("ics","text/calendar"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	JAR("jar","application/java-archive"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	JPEG("jpeg","image/jpeg"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	JPG("jpg","image/jpeg"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	MJS("mjs","text/javascript"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	JS("js","text/javascript"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	JSON("json","application/json"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	JSONLD("jsonld","application/ld+json"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	MID("mid","audio/midi"), 
	
	/**
	 * 
	 * @since 1.0.0
	 */
	MIDI("midi","audio/midi"), // audio/x-midi
	
	/**
	 * 
	 * @since 1.0.0
	 */
	MP3("mp3","audio/mpeg"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	MPEG("mpeg","video/mpeg"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	MPKG("mpkg","application/vnd.apple.installer+xml"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ODP("odp","application/vnd.oasis.opendocument.presentation"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ODS("ods","application/vnd.oasis.opendocument.spreadsheet"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ODT("odt","application/vnd.oasis.opendocument.text"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	OGA("oga","audio/ogg"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	OGV("ogv","video/ogg"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	OGX("ogx","application/ogg"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	OTF("otf","font/otf"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PNG("png","image/png"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PDF("pdf","application/pdf"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PPT("ppt","application/vnd.ms-powerpoint"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PPTX("pptx","application/vnd.openxmlformats-officedocument.presentationml.presentation"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	RAR("rar","application/x-rar-compressed"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	RTF("rtf","application/rtf"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SH("sh","application/x-sh"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SVG("svg","image/svg+xml"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SWF("swf","application/x-shockwave-flash"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TAR("tar","application/x-tar"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TIF("tif","image/tiff"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TIFF("tiff","image/tiff"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TTF("ttf","font/ttf"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TXT("txt","text/plain"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	VSD("vsd","application/vnd.visio"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WAV("wav","audio/wav"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WEBA("weba","audio/webm"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WEBM("webm","video/webm"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WEBP("webp","image/webp"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WOFF("woff","font/woff"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WOFF2("woff2","font/woff2"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	XHTML("xhtml","application/xhtml+xml"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	XLS("xls","application/vnd.ms-excel"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	XLSX("xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	XML("xml","application/xml"), // text/xml
	
	/**
	 * 
	 * @since 1.0.0
	 */
	XUL("xul","application/vnd.mozilla.xul+xml"),
	
	/**
	 * Legacy compressed archive. Used by all Microsoft operating systems and adopted by many others.
	 * @since 1.0.0
	 */
	ZIP("zip","application/zip"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	_3GP("3gp","video/3gpp"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	_3G2("3g2","video/3gpp2"),
	
	/**
	 * Compressed archive used by 7zip software
	 * @since 1.0.0
	 */
	_7Z("7z","application/x-7z-compressed");

	private final String exts;
	private final String type;
	private MIMEType(String exts, String type) 
	{
		this.exts = exts;
		this.type = type;
	}
	
	/**
	 * Returns the MIME type as a String.
	 * @since 1.0.0
	 */
	public final String getString() {return type;}

	/**
	 * Returns the file extension associated with the MIME type as a String.
	 * @since 1.0.0
	 */
	public final String getExtension() {return exts;}
	
	/**
	 * Returns the MIME (Multipurpose Internet Mail Extension) type associated with the given extension.
	 * @since 1.0.0
	 */
	public static MIMEType fromFileExtension(String extension)
	{
		extension = extension.toLowerCase();
		MIMEType[] list = MIMEType.values();
		for (MIMEType mt : list)
		{
			if (mt.getExtension().equals(extension))
			{
				return mt;
			}
		}
		return MIMEType.BIN;
	}
}
