package dna;


//
// FastqRecord and FastaRecord should implement this.
//
// Remember that in implementing classes, the methods
// listed in the interface have to be public.
//

/**

 * @author Dr.C
 *
 *interface allows all classes to pull getDefline and getSequence
 */

public interface DNARecord 
{
	String		getDefline();
	String		getSequence();
}
