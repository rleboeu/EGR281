package edu.mtc.egr281;

/*
 * SubstitutionCipher.java
 * 
 * Does NOT limit to alphabetical characters, all ASCII characters are allowed.
 * For example, the cipher WILL shift spaces and special characters (!,@,#,$,%...)
 */

public class SubstitutionCipher implements MessageEncoder, MessageDecoder {

	private int shift;
	
	public SubstitutionCipher(int shiftBy) {
		this.shift = shiftBy;
	}// Ending bracket of constructor
	
	@Override
	public String decode(String cipherText) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < cipherText.length(); i++) {
			sb.append((char) (cipherText.charAt(i) - this.shift));
		}// Ending bracket of for
		
		return sb.toString();
	}// Ending bracket of method decode

	@Override
	public String encode(String plainText) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < plainText.length(); i++) {
			sb.append( (char) (plainText.charAt(i) + this.shift) );
		}// Ending bracket of for
		
		return sb.toString();
	}// Ending bracket of method encode

}// Ending bracket of class SubstitutionCipher
