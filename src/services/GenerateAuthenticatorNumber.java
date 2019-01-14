package services;

import java.util.Random;

//randomNumber to metoda sluzaca do generowanie losowej liczby
public class GenerateAuthenticatorNumber {

	
	public int randomNumber() {
		Random random = new Random();
		int randomNumber = 0;
		randomNumber = random.nextInt();
		
		
		return randomNumber;
	}
}
