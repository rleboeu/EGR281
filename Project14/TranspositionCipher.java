package edu.mtc.egr281;

public class TranspositionCipher implements MessageEncoder, MessageDecoder {

	private int numTranspositions;
	
	public TranspositionCipher(int n) {
		this.numTranspositions = n;
	}// Ending bracket of constructor
	
	@Override
	public String decode(String cipherText) {
		StringBuffer sb = new StringBuffer();
		sb.append(cipherText);
		
		for (int i = 0; i < numTranspositions; i++) {
			sb.replace(0, sb.toString().length(), reverseShuffle(sb.toString()));
		}// Ending bracket of for
		
		return sb.toString();
	}// Ending bracket of method decode

	@Override
	public String encode(String plainText) {
		String ret = plainText;
		
		for (int i = 0; i < this.numTranspositions; i++) {
			ret = this.shuffle(ret);
		}// Ending bracket of for
		
		return ret;
	}// Ending bracket of method encode
	
	private String shuffle(String plainText) {
		StringBuffer sb = new StringBuffer();
		
		
		String firstHalf = plainText.substring(0, plainText.length() / 2 + 1);	// typically larger than secondHalf
		String secondHalf = plainText.substring(plainText.length() / 2 + 1);
		
		for (int i = 0; i < firstHalf.length(); i++) {
			sb.append(firstHalf.charAt(i));
			
			if (i < secondHalf.length()) {
				sb.append(secondHalf.charAt(i));
			}// ending bracket of if
		}// Ending bracket of for
	
		return sb.toString();
	}// Ending bracket of method shuffle
	
	private String reverseShuffle(String cipherText) {
		StringBuffer sb = new StringBuffer();
		
		String firstHalf = "";
		String secondHalf = "";
		
		for (int i = 0; i < cipherText.length(); i++) {
			// i == 0 or i == length-1 or i % 2 == 0
			if (i == 0 || i == cipherText.length() - 1 || (i & 1) == 0) {
				firstHalf += cipherText.charAt(i);
			} else {
				secondHalf += cipherText.charAt(i);
			}// Ending bracket of if
		}// Ending bracket of for
		
		sb.append(firstHalf);
		sb.append(secondHalf);
		
		return sb.toString();
	}// Ending bracket of method reverseShuffle
	
}// Ending bracket of class TranspositionCipher
