package com.foodstory.General;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptPassword {
	
	public CryptPassword() {}
	

	public String CryptPasswordSHA3256(String passwordPlainTex) {
		
		String sha3Hex = "";
		
		if (passwordPlainTex == null)
			passwordPlainTex = "@Medicare123";
			
		//*****************************
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA3-256");
			final byte[] hashbytes = digest.digest(
					passwordPlainTex.getBytes(StandardCharsets.UTF_8));
			
			sha3Hex = bytesToHex(hashbytes);
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		

		return sha3Hex;
		
	}


	
	public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte hashByte : bytes) {
            int intVal = 0xff & hashByte;
            if (intVal < 0x10) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(intVal));
        }
        return sb.toString();
    }

}
