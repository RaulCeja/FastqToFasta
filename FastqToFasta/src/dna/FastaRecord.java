package dna;


public class FastaRecord implements DNARecord 
{	
	//
	// Add a precondition check: throw RecordGFormatException if the 1st char of the defline is 
	// not '>'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message.
	//
	private String defline;
	private String sequence;
	/**
	 * constructs a fastarecord and initializes the instance variables
	 * @param theDefline the description for the DNA sequence
	 * @param theSequence the DNA sequence itself 
	 * @throws RecordFormatException throws an exception when the record format
	 * is wrong or causes an error
	 */
	//do not touch this. also delete before submitting
	public FastaRecord(String theDefline, String theSequence) throws RecordFormatException
	{
		if (!theDefline.startsWith(">"))//checks if first character in record isn't '>'
		{
			String err= "Bad Fasta record, expected '>'";
			RecordFormatException x=new RecordFormatException(err); //creates a new recordformatexception like an object
			throw x;//throws the exception
		}

		defline=theDefline;//initializes defline to the instance variable
		sequence=theSequence;
	}
	
	
	// Initialize defline and sequence from the input record. The defline should be the
	// defline of the fastq record, but with a '>' in the first position rather than a '@'.
	// If you’re not sure how to do this, look up the substring method on the String API page.
	/**
	 * initializes instance variables with values from FastqRecord
	 * changes 1 character of defline to '>' from '@'
	 * @param fastqRec
	 */
	public FastaRecord(FastqRecord fastqRec)
	{
		
		this.defline = ">" + fastqRec.getDefline().substring(1);
		this.sequence = fastqRec.getSequence();

		//this.defline = ">" + fastqRec.getDefline().substring(1, fastqRec.getDefline().length());
	}
		

	// 
	// Provide the 2 methods that satisfy the interface.
	//
	/**
	 * gets the defline and returns it
	 */
	public String getDefline()
	{
		return defline;
	}
	
	/**
	 * gets the sequence and returns it
	 */
	public String getSequence()
	{
		return sequence;
	}
	
	
	//
	// Provide an equals() method. 
	//
	/**
	 * checks for deep equality of both defline and sequence
	 * both must satisfy deep equality
	 * @param that the fastarecord we're checking for deep equality
	 * @return true if deep equality satisfied, false if not
	 */
	public boolean equals(FastaRecord that)
	{
		if(this.defline.equals(that.defline)&&this.sequence.equals(that.sequence))
		{
			return true;
		}
		return false;
		
	}
	//
	// Provide a hashCode() method that returns the sum of the hashcodes of 
	// defline and sequence.
	//
	/**
	 * creates integer variables of the hashcodes of defline, and sequence
	 * @return sum returns the sum of their hash codes
	 * 
	 */
	public int hashCode()
	{
		return defline.hashCode()+sequence.hashCode();
	}
}
