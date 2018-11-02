package dna;

import java.io.*;


//
// Reads lines from a BufferedReader and builds a FastqRecord.
//


public class FastqReader 
{
	private BufferedReader br;
	
	/**
	 * constructs a buffered reader from the parameter and private variable
	 * @param theBufferedReader the bufferedreader to be initialized
	 */
	public FastqReader(BufferedReader theBufferedReader)
	{
		br=theBufferedReader;
	}
	
	// Returns next record in the file, or null if EOF (end-of-file).
	/**
	 * read a line from the buffered reader. 
	 * @return
	 * @throws IOException
	 * @throws RecordFormatException
	 * 
	 */
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Read the defline from the BufferedReader. Return null if you read null, 
		// indicating end of file.
		String defline=br.readLine();
		if(defline==null)//finds no lines so it returns null
		{
			return null;
		}
		
		// Read the next 3 lines from the buffered reader. Construct and return
		// a FastqRecord.
	
		String sequence = br.readLine();
		br.readLine();
		String quality = br.readLine();
		return new FastqRecord(defline, sequence, quality);
		
	}
}
