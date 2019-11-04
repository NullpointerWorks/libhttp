/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public enum MIMEType
{
	NULL("","null"),
	
	AAC("aac","audio/aac"),
	ABW("abw","application/x-abiword"),
	ARC("arc","application/x-freearc"),
	AVI("avi","video/x-msvideo"),
	AZW("azw","application/vnd.amazon.ebook"),
	
	BIN("bin","application/octet-stream"),
	BMP("bmp","image/bmp"),
	BZ("bz","application/x-bzip"),
	BZ2("bz2","application/x-bzip"),
	
	CSH("csh","application/x-csh"),
	CSS("css","text/css"),
	CSV("csv","text/csv"),
	
	DOC("doc","application/msword"),
	DOCX("docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
	
	EOT("eot","application/vnd.ms-fontobject"),
	EPUB("epub","application/epub+zip"),
	
	GIF("gif","image/gif"),
	
	HTM("htm","text/html"),
	HTML("html","text/html"),
	
	ICO("ico","image/vnd.microsoft.icon"),
	ICS("ics","text/calendar"),
	
	JAR("jar","application/java-archive"),
	JPEG("jpeg","image/jpeg"),
	JPG("jpg","image/jpeg"),
	
	MJS("mjs","text/javascript"),
	
	JS("js","text/javascript"),
	JSON("json","application/json"),
	JSONLD("jsonld","application/ld+json"),

	MID("mid","audio/midi"), 
	MIDI("midi","audio/midi"), // audio/x-midi
	MP3("mp3","audio/mpeg"),
	MPEG("mpeg","video/mpeg"),
	MPKG("mpkg","application/vnd.apple.installer+xml"),
	
	ODP("odp","application/vnd.oasis.opendocument.presentation"),
	ODS("ods","application/vnd.oasis.opendocument.spreadsheet"),
	ODT("odt","application/vnd.oasis.opendocument.text"),
	OGA("oga","audio/ogg"),
	OGV("ogv","video/ogg"),
	OGX("ogx","application/ogg"),
	OTF("otf","font/otf"),

	PNG("png","image/png"),
	PDF("pdf","application/pdf"),
	PPT("ppt","application/vnd.ms-powerpoint"),
	PPTX("pptx","application/vnd.openxmlformats-officedocument.presentationml.presentation"),
	
	RAR("rar","application/x-rar-compressed"),
	RTF("rtf","application/rtf"),
	
	SH("sh","application/x-sh"),
	SVG("svg","image/svg+xml"),
	SWF("swf","application/x-shockwave-flash"),
	
	TAR("tar","application/x-tar"),
	TIF("tif","image/tiff"),
	TIFF("tiff","image/tiff"),
	TTF("ttf","font/ttf"),
	TXT("txt","text/plain"),
	
	VSD("vsd","application/vnd.visio"),
	
	WAV("wav","audio/wav"),
	WEBA("weba","audio/webm"),
	WEBM("webm","video/webm"),
	WEBP("webp","image/webp"),
	WOFF("woff","font/woff"),
	WOFF2("woff2","font/woff2"),
	
	XHTML("xhtml","application/xhtml+xml"),
	XLS("xls","application/vnd.ms-excel"),
	XLSX("xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
	XML("xml","application/xml"), // text/xml
	XUL("xul","application/vnd.mozilla.xul+xml"),

	ZIP("zip","application/zip"),
	
	_3GP("3gp","video/3gpp"),
	_3G2("3g2","video/3gpp2"),
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
	public final String getType() {return type;}

	/**
	 * Returns the file extension associated with the MIME type as a String.
	 * @since 1.0.0
	 */
	public final String getExtension() {return exts;}
	
	/**
	 * Returns the MIME (Multipurpose Internet Mail Extension) type associated with the given extension.
	 * @since 1.0.0
	 */
	public static MIMEType getFromFileExtension(String extension)
	{
		switch(extension)
		{
			case "aac": return MIMEType.AAC;
			case "abw": return MIMEType.ABW;
			case "arc": return MIMEType.ARC;
			case "avi": return MIMEType.AVI;
			case "azw": return MIMEType.AZW;
			
			case "bin": return MIMEType.BIN;
			case "bmp": return MIMEType.BMP;
			case "bz": return MIMEType.BZ;
			case "bz2": return MIMEType.BZ2;
			
			case "csh": return MIMEType.CSH;
			case "css": return MIMEType.CSS;
			case "csv": return MIMEType.CSV;
			
			case "doc": return MIMEType.DOC;
			case "docx": return MIMEType.DOCX;
			
			case "eot": return MIMEType.AAC;
			case "epub": return MIMEType.AAC;
			
			case "gif": return MIMEType.GIF;
			
			case "htm": return MIMEType.HTM;
			case "html": return MIMEType.HTML;
			
			case "ico": return MIMEType.ICO;
			case "ics": return MIMEType.ICS;
			
			case "jar": return MIMEType.JAR;
			case "jpeg": return MIMEType.JPEG;
			case "jpg": return MIMEType.JPG;
			
			case "mjs": return MIMEType.MJS;
			
			case "js": return MIMEType.JS;
			case "json": return MIMEType.JSON;
			case "jsonld": return MIMEType.JSONLD;
			
			case "mid": return MIMEType.MID;
			case "midi": return MIMEType.MIDI;
			case "mp3": return MIMEType.MP3;
			case "mpeg": return MIMEType.MPEG;
			case "mpkg": return MIMEType.MPKG;
			
			case "odp": return MIMEType.ODP;
			case "ods": return MIMEType.ODS;
			case "odt": return MIMEType.ODT;
			case "oga": return MIMEType.OGA;
			case "ogv": return MIMEType.OGV;
			case "ogx": return MIMEType.OGX;
			case "otf": return MIMEType.OTF;
			
			case "png": return MIMEType.PNG;
			case "pdf": return MIMEType.PDF;
			case "ppt": return MIMEType.PPT;
			case "pptx": return MIMEType.PPTX;
			
			case "rar": return MIMEType.AAC;
			case "rtf": return MIMEType.AAC;
			
			case "sh": return MIMEType.SH;
			case "svg": return MIMEType.SVG;
			case "swf": return MIMEType.SWF;
			
			case "tar": return MIMEType.TAR;
			case "tif": return MIMEType.TIF;
			case "tiff": return MIMEType.TIFF;
			case "ttf": return MIMEType.TTF;
			case "txt": return MIMEType.TXT;
			
			case "vsd": return MIMEType.VSD;
			
			case "wav": return MIMEType.WAV;
			case "weba": return MIMEType.WEBA;
			case "webm": return MIMEType.WEBM;
			case "webp": return MIMEType.WEBP;
			case "woff": return MIMEType.WOFF;
			case "woff2": return MIMEType.WOFF2;
			
			case "xhtml": return MIMEType.XHTML;
			case "xls": return MIMEType.XLS;
			case "xlsx": return MIMEType.XLSX;
			case "xml": return MIMEType.XML;
			case "xul": return MIMEType.XUL;
			
			case "zip": return MIMEType.ZIP;
			
			case "3gp": return MIMEType._3GP;
			case "3g2": return MIMEType._3G2;
			case "7z": return MIMEType._7Z;
			
			default: return MIMEType.BIN;
		}
	}
}
