package org.janine.jian.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 
 * @author jian
 *
 */
public class MD5Utils {
	public final static int SALT_LENGTH = 16;
	
	public static byte[] randomSalt() {
        SecureRandom sc= new SecureRandom();//拿到一个随机数组，作为盐  
        byte[] salt = new byte[SALT_LENGTH];  
        sc.nextBytes(salt);  
        
        return salt;
	}
	
	public static String encode(String passwd, byte[] salt){  
        byte[] pwd = null;  
         
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
	        md.update(salt); 
	        md.update(passwd.getBytes("UTF-8"));  
	        byte[] digest = md.digest();    
	        pwd = new byte[salt.length + digest.length];  
	        System.arraycopy(salt, 0, pwd, 0, SALT_LENGTH);  
	        System.arraycopy(digest, 0, pwd, SALT_LENGTH, digest.length); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
        return byteToHexString(pwd);  
    }
	
	public static String byteToHexString(byte[] salt){  
        StringBuffer hexString = new StringBuffer();  
        for (int i = 0; i < salt.length; i++) {  
            String hex = Integer.toHexString(salt[i] & 0xFF);  
            if(hex.length() == 1){  
                hex = '0' + hex;  
            }  
            hexString.append(hex.toUpperCase());  
        }  
        return hexString.toString();  
    } 
	
	public static byte[] toByteArray(String hexString) {
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() >> 1];
        int index = 0;
        for (int i = 0; i < hexString.length(); i++) {
            if (index  > hexString.length() - 1)
                return byteArray;
            byte highDit = (byte) (Character.digit(hexString.charAt(index), 16) & 0xFF);
            byte lowDit = (byte) (Character.digit(hexString.charAt(index + 1), 16) & 0xFF);
            byteArray[i] = (byte) (highDit << 4 | lowDit);
            index += 2;
        }
        return byteArray;
    }
	
	
	public static void main(String[] args) {
		//insert into sys_user(user_name,user_password,salt,register_date) values('admin','489BEF6ED98A2B06CE5A29B59DD8CF74520FA2FD79674AF471C41CC456D8BBEB','489BEF6ED98A2B06CE5A29B59DD8CF74',now());
	}

}
