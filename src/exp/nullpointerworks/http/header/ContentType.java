/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.header;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @since 1.0.0
 */
public enum ContentType
{
	/**
	 * application/x-www-form-urlencoded
	 * @since 1.0.0
	 */
	URLENCODED("URLEncoded","application/x-www-form-urlencoded"),
	
	/**
	 * text/plain
	 * @since 1.0.0
	 */
	TEXTPLAIN("plain", "text/plain"),
	
	/**
	 * multipart/form-data
	 * @since 1.0.0
	 */
	MULTIPART("multipart", "multipart/form-data"),
	
	/**
	 * application/signed-exchange
	 * @since 1.0.0
	 */
	SIGNED_EXCHANGE("signed-exchange", "application/signed-exchange"),
	
	/**
	 * audio/aac
	 * @since 1.0.0
	 */
	AAC("aac","audio/aac"),
	
	/**
	 * application/x-abiword
	 * @since 1.0.0
	 */
	ABW("abw","application/x-abiword"),
	
	/**
	 * image/apng
	 * @since 1.0.0
	 */
	APNG("apng","image/apng"),
	
	/**
	 * application/x-freearc
	 * @since 1.0.0
	 */
	ARC("arc","application/x-freearc"),
	
	/**
	 * video/x-msvideo
	 * @since 1.0.0
	 */
	AVI("avi","video/x-msvideo"),
	
	/**
	 * image/avif
	 * @since 1.0.0
	 */
	AVIF("avif","image/avif"),
	
	/**
	 * application/vnd.amazon.ebook
	 * @since 1.0.0
	 */
	AZW("azw","application/vnd.amazon.ebook"),
	
	/**
	 * application/octet-stream
	 * @since 1.0.0
	 */
	BIN("bin","application/octet-stream"),
	
	/**
	 * image/bmp
	 * @since 1.0.0
	 */
	BMP("bmp","image/bmp"),
	
	/**
	 * application/x-bzip
	 * @since 1.0.0
	 */
	BZ("bz","application/x-bzip"),
	
	/**
	 * application/x-bzip
	 * @since 1.0.0
	 */
	BZ2("bz2","application/x-bzip"),
	
	/**
	 * application/x-csh
	 * @since 1.0.0
	 */
	CSH("csh","application/x-csh"),
	
	/**
	 * text/css
	 * @since 1.0.0
	 */
	CSS("css","text/css"),
	
	/**
	 * text/csv
	 * @since 1.0.0
	 */
	CSV("csv","text/csv"),
	
	/**
	 * application/msword
	 * @since 1.0.0
	 */
	DOC("doc","application/msword"),
	
	/**
	 * application/vnd.openxmlformats-officedocument.wordprocessingml.document
	 * @since 1.0.0
	 */
	DOCX("docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
	
	/**
	 * application/vnd.ms-fontobject
	 * @since 1.0.0
	 */
	EOT("eot","application/vnd.ms-fontobject"),
	
	/**
	 * application/epub+zip
	 * @since 1.0.0
	 */
	EPUB("epub","application/epub+zip"),
	
	/**
	 * image/gif
	 * @since 1.0.0
	 */
	GIF("gif","image/gif"),
	
	/**
	 * text/html
	 * @since 1.0.0
	 */
	HTML("html","text/html"),
	
	/**
	 * text/html
	 * @since 1.0.0
	 */
	HTM("htm","text/html"),
	
	/**
	 * image/vnd.microsoft.icon
	 * @since 1.0.0
	 */
	ICO("ico","image/vnd.microsoft.icon"),
	
	/**
	 * text/calendar
	 * @since 1.0.0
	 */
	ICS("ics","text/calendar"),
	
	/**
	 * application/java-archive
	 * @since 1.0.0
	 */
	JAR("jar","application/java-archive"),
	
	/**
	 * image/jpeg
	 * @since 1.0.0
	 */
	JPEG("jpeg","image/jpeg"),
	
	/**
	 * image/jpeg
	 * @since 1.0.0
	 */
	JPG("jpg","image/jpeg"),
	
	/**
	 * text/javascript
	 * @since 1.0.0
	 */
	MJS("mjs","text/javascript"),
	
	/**
	 * text/javascript
	 * @since 1.0.0
	 */
	JS("js","text/javascript"),
	
	/**
	 * application/json
	 * @since 1.0.0
	 */
	JSON("json","application/json"),
	
	/**
	 * application/ld+json
	 * @since 1.0.0
	 */
	JSONLD("jsonld","application/ld+json"),
	
	/**
	 * audio/midi
	 * @since 1.0.0
	 */
	MID("mid","audio/midi"), 
	
	/**
	 * audio/midi
	 * @since 1.0.0
	 */
	MIDI("midi","audio/midi"), // audio/x-midi
	
	/**
	 * audio/mpeg
	 * @since 1.0.0
	 */
	MP3("mp3","audio/mpeg"),
	
	/**
	 * video/mpeg
	 * @since 1.0.0
	 */
	MPEG("mpeg","video/mpeg"),
	
	/**
	 * application/vnd.apple.installer+xml
	 * @since 1.0.0
	 */
	MPKG("mpkg","application/vnd.apple.installer+xml"),
	
	/**
	 * application/vnd.oasis.opendocument.presentation
	 * @since 1.0.0
	 */
	ODP("odp","application/vnd.oasis.opendocument.presentation"),
	
	/**
	 * application/vnd.oasis.opendocument.spreadsheet
	 * @since 1.0.0
	 */
	ODS("ods","application/vnd.oasis.opendocument.spreadsheet"),
	
	/**
	 * application/vnd.oasis.opendocument.text
	 * @since 1.0.0
	 */
	ODT("odt","application/vnd.oasis.opendocument.text"),
	
	/**
	 * audio/ogg
	 * @since 1.0.0
	 */
	OGA("oga","audio/ogg"),
	
	/**
	 * video/ogg
	 * @since 1.0.0
	 */
	OGV("ogv","video/ogg"),
	
	/**
	 * application/ogg
	 * @since 1.0.0
	 */
	OGX("ogx","application/ogg"),
	
	/**
	 * font/otf
	 * @since 1.0.0
	 */
	OTF("otf","font/otf"),
	
	/**
	 * image/png
	 * @since 1.0.0
	 */
	PNG("png","image/png"),
	
	/**
	 * application/pdf
	 * @since 1.0.0
	 */
	PDF("pdf","application/pdf"),
	
	/**
	 * application/vnd.ms-powerpoint
	 * @since 1.0.0
	 */
	PPT("ppt","application/vnd.ms-powerpoint"),
	
	/**
	 * application/vnd.openxmlformats-officedocument.presentationml.presentation
	 * @since 1.0.0
	 */
	PPTX("pptx","application/vnd.openxmlformats-officedocument.presentationml.presentation"),
	
	/**
	 * application/x-rar-compressed
	 * @since 1.0.0
	 */
	RAR("rar","application/x-rar-compressed"),
	
	/**
	 * application/rtf
	 * @since 1.0.0
	 */
	RTF("rtf","application/rtf"),
	
	/**
	 * application/x-sh
	 * @since 1.0.0
	 */
	SH("sh","application/x-sh"),
	
	/**
	 * text/event-stream
	 * @since 1.0.0
	 */
	EVENT("event-stream","text/event-stream"),
	
	/**
	 * image/svg+xml
	 * @since 1.0.0
	 */
	SVG("svg","image/svg+xml"),
	
	/**
	 * application/x-shockwave-flash
	 * @since 1.0.0
	 */
	SWF("swf","application/x-shockwave-flash"),
	
	/**
	 * application/x-tar
	 * @since 1.0.0
	 */
	TAR("tar","application/x-tar"),
	
	/**
	 * image/tiff
	 * @since 1.0.0
	 */
	TIF("tif","image/tiff"),
	
	/**
	 * image/tiff
	 * @since 1.0.0
	 */
	TIFF("tiff","image/tiff"),
	
	/**
	 * font/ttf
	 * @since 1.0.0
	 */
	TTF("ttf","font/ttf"),
	
	/**
	 * text/plain
	 * @since 1.0.0
	 */
	TXT("txt","text/plain"),
	
	/**
	 * application/vnd.visio
	 * @since 1.0.0
	 */
	VSD("vsd","application/vnd.visio"),
	
	/**
	 * audio/wav
	 * @since 1.0.0
	 */
	WAV("wav","audio/wav"),
	
	/**
	 * audio/webm
	 * @since 1.0.0
	 */
	WEBA("weba","audio/webm"),
	
	/**
	 * video/webm
	 * @since 1.0.0
	 */
	WEBM("webm","video/webm"),
	
	/**
	 * image/webp
	 * @since 1.0.0
	 */
	WEBP("webp","image/webp"),
	
	/**
	 * font/woff
	 * @since 1.0.0
	 */
	WOFF("woff","font/woff"),
	
	/**
	 * font/woff2
	 * @since 1.0.0
	 */
	WOFF2("woff2","font/woff2"),
	
	/**
	 * application/xhtml+xml
	 * @since 1.0.0
	 */
	XHTML("xhtml","application/xhtml+xml"),
	
	/**
	 * application/vnd.ms-excel
	 * @since 1.0.0
	 */
	XLS("xls","application/vnd.ms-excel"),
	
	/**
	 * application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
	 * @since 1.0.0
	 */
	XLSX("xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
	
	/**
	 * application/xml
	 * @since 1.0.0
	 */
	XML("xml","application/xml"), // text/xml
	
	/**
	 * application/vnd.mozilla.xul+xml
	 * @since 1.0.0
	 */
	XUL("xul","application/vnd.mozilla.xul+xml"),
	
	/**
	 * Legacy compressed archive. Used by all Microsoft operating systems and adopted by many others. (application/zip)
	 * @since 1.0.0
	 */
	ZIP("zip","application/zip"),
	
	/**
	 * video/3gpp
	 * @since 1.0.0
	 */
	_3GP("3gp","video/3gpp"),
	
	/**
	 * video/3gpp2
	 * @since 1.0.0
	 */
	_3G2("3g2","video/3gpp2"),
	
	/**
	 * Compressed archive used by 7zip software. (application/x-7z-compressed)
	 * @since 1.0.0
	 */
	_7Z("7z","application/x-7z-compressed");
	
	private String e;
	private String mime;
	private ContentType(String e, String m)
	{this.e=e;this.mime=m;}
	public String getName() {return e;}
	public String getString() {return mime;}

	/**
	 * 
	 * @since 1.0.0
	 */
	public static ContentType fromName(String extension)
	{
		extension = extension.toLowerCase();
		ContentType[] list = values();
		for (ContentType mt : list)
		{
			if (mt.getName().equals(extension))
			{
				return mt;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static ContentType fromContentType(String mime)
	{
		mime = mime.toLowerCase();
		ContentType[] list = values();
		for (ContentType mt : list)
		{
			if (mt.getString().equals(mime))
			{
				return mt;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static ContentType[] startsWith(String mime)
	{
		mime = mime.toLowerCase();
		ContentType[] list = values();
		List<ContentType> found = new ArrayList<ContentType>();
		for (ContentType mt : list)
		{
			if (mt.getString().startsWith(mime))
			{
				found.add(mt);
			}
		}
		
		ContentType[] result = new ContentType[found.size()];
		for (int i=0,l=found.size(); i<l; i++) result[i] = found.get(i);
		return result;
	}
}
