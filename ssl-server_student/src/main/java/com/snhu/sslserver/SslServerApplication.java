package com.snhu.sslserver;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}
}

@RestController
class ServerController{
	public static String getSHA(String input, String salt) throws NoSuchAlgorithmException {
		// Request instance of MessageDigest to compute SHA-256 hash
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		// Add Salt 
	    md.update(salt.getBytes(StandardCharsets.UTF_8)); // Add salt
		// Compute hash of MessageDigest
		byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
		// Convert hash into BigInteger 
		BigInteger number = new BigInteger(1, hash);
		// Convert message digest into hex value
		StringBuilder hexString = new StringBuilder(number.toString(16));
		// Pad with leading zeros to ensure displayed string is 64 long. 
		while (hexString.length() < 64)
		{
			hexString.insert(0, '0');
			}
		return hexString.toString();
		}
	
	// Generate a salt value based on length
	public static String generateSalt(int length) throws NoSuchAlgorithmException {
	    // Create a SecureRandom object 
	    SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
	    // Generate a random byte array of the desired length
	    byte[] saltBytes = new byte[length];
	    random.nextBytes(saltBytes);
	    // Convert the byte array to a hex string for storage 
	    StringBuilder saltString = new StringBuilder(2 * length);
	    // Append salt format 
	    for (byte b : saltBytes) {
	        saltString.append(String.format("%02x", b));
	    }
	    // Return saltString
	    return saltString.toString();
	}
	
	// Maps HTTP requests with /hash endpoint 
	@RequestMapping("/hash")
	public String myHash() throws NoSuchAlgorithmException{
		String data = "Hello, Ryan!";
		// Check if input is empty or null
		if (data.isEmpty() || data == null) {
			// Throw exception if so, provide error message
			throw new IllegalArgumentException("Input cannot be empty.");
		}
		// If input contains characters outside of accepted chars
		if (data.matches("[^\\p{L}\\p{Nd}\\p{Z}\\s]")) {
			// Throw error if so, provide error message
		    throw new IllegalArgumentException("Input has invalid characters.");
		}
		// Initiate try catch for calculate checksum and return data
		try {
			// Set salt to outcome of generateSalt function so it's 32 bytes. 
			String salt = generateSalt(32);
			// Calculate SHA-256 checksum of "data" string with salt value passed 
			String checkSum = getSHA(data, salt);
			return "data: " + data + " Checksum: " + "SHA-256 : " + checkSum;
		}
		// Catch in case an error occurs
		catch (NoSuchAlgorithmException e) {
			// Log exception
			e.printStackTrace();
			return "Error calculating hash: " + e.getMessage();
		}
	}
}


