package exp.nullpointerworks.http.encoding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;

/**
 * Lempel-Ziv coding (LZ77) with a 32 bit CRC
 * @since 1.0.0
 */
public class LZ77
{
	public static final int DEFAULT_BUFF_SIZE = 1024;
	protected int mBufferSize;
	protected Reader mIn;
	protected PrintWriter mOut;
	protected StringBuffer mSearchBuffer; 

	public LZ77() 
	{
	    this(DEFAULT_BUFF_SIZE);
	}
	  
	public LZ77(int buffSize) 
	{
	    mBufferSize = buffSize;
	    mSearchBuffer = new StringBuffer(mBufferSize);
	}

	private void trimSearchBuffer() 
	{
	    if (mSearchBuffer.length() > mBufferSize) 
	    {
	    	mSearchBuffer = mSearchBuffer.delete(0,  mSearchBuffer.length() - mBufferSize);
	    }
	}

	/**
	 * Uncompress method
	 * @param infile the name of the file to uncompress - automatically appends a ".lz77" extension to the supplied filename
	 * @exception IOException if an error occurs during file processing
	 * @since 1.0.0
	 */
	public void unCompress(String infile) throws IOException 
	{
	    mIn = new BufferedReader(new FileReader(infile+".lz77"));
	    
	    StreamTokenizer st = new StreamTokenizer(mIn);
	    st.ordinaryChar((int)' ');
		st.ordinaryChar((int)'.');
		st.ordinaryChar((int)'-');
		st.ordinaryChar((int)'\n');
		st.wordChars((int)'\n', (int)'\n');
		st.wordChars((int)' ', (int)'}');
		
		int offset, length;
		while (st.nextToken() != StreamTokenizer.TT_EOF) 
		{
			switch (st.ttype) 
			{
			case StreamTokenizer.TT_WORD:
				mSearchBuffer.append(st.sval);
				System.out.print(st.sval);
				// Adjust search buffer size if necessary
				trimSearchBuffer();
				break;
			case StreamTokenizer.TT_NUMBER:
				offset = (int)st.nval; // set the offset
				st.nextToken(); // get the separator (hopefully)
				if (st.ttype == StreamTokenizer.TT_WORD) 
				{
					// we got a word instead of the separator,
					// therefore the first number read was actually part of a word
					mSearchBuffer.append(offset+st.sval);
					System.out.print(offset+st.sval);
					break; // break out of the switch
				}
				// if we got this far then we must be reading a
				// substitution pointer
				st.nextToken(); // get the length
				length = (int)st.nval;
				// output substring from search buffer
				String output = mSearchBuffer.substring(offset, offset+length);
				System.out.print(output);
				mSearchBuffer.append(output);
				// Adjust search buffer size if necessary
				trimSearchBuffer();
				break;
			default: // consume a '~'
			}
	    }
	    mIn.close();
	 }
	
	/**
	 * Compress method
   	 *
   	 * @param infile the name of the file to compress. Automatically appends a ".lz77" extension to infile name when creating the output file
   	 * @exception IOException if an error occurs
	 * @since 1.0.0
	 */
	public void compress(String infile) throws IOException 
	{
	    // set up input and output
		mIn = new BufferedReader(new FileReader(infile));
		mOut = new PrintWriter(new BufferedWriter(new FileWriter(infile+".lz77")));
	
		int nextChar;
		String currentMatch = "";
		int matchIndex = 0, tempIndex = 0;
	
		// while there are more characters - read a character
		while ((nextChar = mIn.read()) != -1) 
		{
			// look in our search buffer for a match
			tempIndex = mSearchBuffer.indexOf(currentMatch + (char)nextChar);
			// if match then append nextChar to currentMatch
			// and update index of match
			if (tempIndex != -1) 
			{
				currentMatch += (char)nextChar;
				matchIndex = tempIndex;
			} 
			else 
			{
				// found longest match, now should we encode it?
				String codedString = "~"+matchIndex+"~"+currentMatch.length()+"~"+(char)nextChar;
				String concat = currentMatch + (char)nextChar;
				// is coded string shorter than raw text?
				if (codedString.length() <= concat.length()) 
				{
					mOut.print(codedString);
				  	mSearchBuffer.append(concat); // append to the search buffer
				  	currentMatch = "";
				  	matchIndex = 0;
				} 
				else 
				{
					// otherwise, output chars one at a time from
					// currentMatch until we find a new match or
					// run out of chars
					currentMatch = concat; matchIndex = -1;
				  	while (currentMatch.length() > 1 && matchIndex == -1) 
				  	{
				  		mOut.print(currentMatch.charAt(0));
				  		mSearchBuffer.append(currentMatch.charAt(0));
				  		currentMatch = currentMatch.substring(1, currentMatch.length());
				  		matchIndex = mSearchBuffer.indexOf(currentMatch);
				  	}
				}
				// Adjust search buffer size if necessary
				trimSearchBuffer();
			}
		}
		
		// flush any match we may have had when EOF encountered
		if (matchIndex != -1) 
		{
			String codedString = "~"+matchIndex+"~"+currentMatch.length();
		  	if (codedString.length() <= currentMatch.length()) 
		  	{
		  		mOut.print("~"+matchIndex+"~"+currentMatch.length());
		  	} 
		  	else 
		  	{
		  		mOut.print(currentMatch);
		  	}
		}
		
		// close files
	    mIn.close();
	    mOut.flush(); 
	    mOut.close();
	}
}
