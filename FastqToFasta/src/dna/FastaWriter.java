package dna;

import java.io.*;


/**
 * writes a fasta record to a print writer
 * @author Dr.C
 *
 */

public class FastaWriter 
{

	private PrintWriter pw;
	
	/**
	 * initializes the printwriter with value in instance variable
	 * @param thePW
	 */
	public FastaWriter(PrintWriter thePW)
	{
		pw=thePW;
	}
	
	// Write the rec as 2 separate lines: first the defline, then the sequence.
	// To write something on a separate line, use the println() method of PrintWriter.
	/**
	 * writes the fasta record in correct fasta format
	 * to the printwriter
	 * @param rec
	 * @throws IOException
	 */
	
	public void writeRecord(FastaRecord rec) throws IOException
	{
		pw.println(rec.getDefline());
		pw.println(rec.getSequence());//"hey pw, write this"
		
	}
}
