package dna;

//
// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//


public class FastqRecord implements DNARecord 
{
	private String defline;
	private String sequence;
	private String quality;
	//
	// Add a precondition check: throw RecordFormatException if the 1st char of the defline is 
	// not '@'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message.
	//
	/**
	 * constructs a fastqrecord and initializes the instance variables
	 * @param theDefline the description for the DNA sequence
	 * @param theSequence the DNA sequence itself 
	 * @param theQuality represents the machine's confidence that the char in the 
	 * sequence is correct. Same length as the sequence. 
	 * minimum confidence represented by '!'
	 * @throws RecordFormatException throws an exception when the record format
	 * is wrong or causes an error
	 */
	public FastqRecord(String theDefline, String theSequence, String theQuality) throws RecordFormatException
	{

		if (!theDefline.startsWith("@"))//checks if first character in record isn't @
		{
			String err= "Bad Fastq record, expected '@'";
			RecordFormatException x=new RecordFormatException(err); //creates a new recordformatexception like an object
			throw x;//throws the exception
		}
		else
		{
			defline=theDefline;
			sequence=theSequence;
			quality=theQuality;
		}

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
	// Provide an equals() method that checks for deep equality of all 3 instance variables. 
	// When checking string variables, be sure to do it like this:  
	//              this.defline.equals(that.defline) 
	// and not like this:  
	//              this.defline == that.defline
	//
	/**
	 * checks for deep quality of all 3 instance variables by
	 * checking if the hash codes of the private variables match those 
	 * of the parameters of this method
	 * 
	 * @param that the fastqrecord that is being compared to
	 * @return false if any of the strings do not fulfill deep equality
	 */
	public boolean equals(FastqRecord that)
	{
		if(this.defline.equals(that.defline)&&this.sequence.equals(that.sequence)&&this.quality.equals(that.quality))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	//
	// Complete this according to the assignment instructions.
	//
	/**
	 * checks quality of string by checking if quality contains at least 1 $
	 * AND at least 1 
	 * since we're only checking if there are at least one of each, we do not need
	 * to keep track of them, only that BOTH exist in the string
	 * 
	 * @return true if quality contains at least one $ AND at least one #
	 */
	public boolean qualityIsLow()
	{
		return quality.contains("$")  &&  quality.contains("#");
	}
	
	
	//
	// Complete this. Return the sum of the hash codes of defline, sequence, and quality.
	//
	/**
	 * creates integer variables of the hashcodes of defline, sequence, and quality
	 * @return sum returns the sum of their hash codes
	 * 
	 */
	public int hashCode()
	{
		/*int dCode=defline.hashCode();
		int sCode=sequence.hashCode();
		int qCode=quality.hashCode();
		int sum=dCode+sCode+qCode;*/
		return defline.hashCode()+sequence.hashCode()+quality.hashCode();
	}
}
