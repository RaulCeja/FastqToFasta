package dna;

import java.io.*;
import java.util.*;


public class FileConverter 
{
	private File fastq;
	private File fasta;
	
	/**
	 * constructor that initializes Files fastq and fasta with instance variables
	 * @param fq fastq file
	 * @param fa fasta file
	 */
	public FileConverter(File fq, File fa)
	{
		fastq=fq;
		fasta=fa;
	}
	
	//
	// Writes a fasta file consisting of conversion of all records from the fastq with
	// sufficient quality and unique defline.
	//
	
	/**
	 * writes a fasta file from converted fastq file with acceptable quality and
	 * a unique defline
	 * @throws IOException
	 */
	public void convert() throws IOException
	{
		// Build chain of readers.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Build chain of writers.
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);

		// Read, translate, write.
		boolean done=false;
		while(!done)
		{
			try
			{
				
				FastqRecord fastqRec = fqr.readRecord();
				if (fastqRec == null)//if fastqrec does not exist
					done = true;//then we're finished
				else//the fastqrec DOES exist
				{
					if (!fastqRec.qualityIsLow())//and fastqrec is not of low quality
					{
						FastaRecord fastaRec = new FastaRecord(fastqRec);//create new fastarecord from fastqrec
						faw.writeRecord(fastaRec);//write the new fastarec using the fastawriter
					}
				}
			}
				catch(RecordFormatException x)
				{
					System.out.println("Invalid Fastq format: "+ x.getMessage());

				}
			}


		// Close fr, br, fw, and pw in reverse order of creation.
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}

		
	/**
	 * reads and converts fastq file in data folder
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Starting");
		try
		{
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		}
		catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
