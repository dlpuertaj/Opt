package problems;

import java.util.Random;

public class MaxOnes {
	
	int lenght;
	
	public MaxOnes(int lenght) {
		this.lenght = lenght;
	}
	
	public double calc(String X) {
		double sum = 0;
		for(int i = 0 ; i < X.length() ; i++ ) {
			sum += X.charAt(i) == '1' ? 1 : 0;
		}
		return sum;
	}
	
	public String randomBitString() {
		String bits = "";
		Random rand = new Random();
		for(int i = 0 ; i < lenght ; i++)		
			bits = bits.concat(rand.nextBoolean() == true ? "1" : "0");
		return bits;
	}
	
	public String mutate(String bits) {
		 StringBuilder mutant = new StringBuilder(bits);
		 Random rand = new Random();
		 
		 int position = rand.nextInt(mutant.length());
	     mutant.setCharAt(position, mutant.charAt(position) == '1' ? '0' : '1');
		     
		 return mutant.toString();
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	
}
