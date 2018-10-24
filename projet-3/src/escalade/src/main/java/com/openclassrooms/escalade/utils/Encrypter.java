package com.openclassrooms.escalade.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;


import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.io.IOException;


/**
 * -----------------------------------------------------------------------------
 * The following example implements a class for encrypting and decrypting
 * strings using several Cipher algorithms. The class is created with a key and
 * can be used repeatedly to encrypt and decrypt strings using that key.
 * Some of the more popular algorithms are:
 *      blowFish
 *      DES
 *      DESede
 *      PBEWithMD5AndDES
 *      PBEWithMD5AndTripleDES
 *      TripleDES
 * 
 * @version 1.0
 * @author  Jeffrey M. Hunter  (jhunter@idevelopment.info)
 * @author  http://www.idevelopment.info
 * -----------------------------------------------------------------------------
 */

public class Encrypter {

    Cipher ecipher;
    Cipher dcipher;


    /**
     * Constructor used to create this object.  Responsible for setting
     * and initializing this object's encrypter and decrypter Chipher instances
     * given a Secret Key and algorithm.
     * @param key        Secret Key used to initialize both the encrypter and
     *                   decrypter instances.
     * @param algorithm  Which algorithm to use for creating the encrypter and
     *                   decrypter instances.
     */
    Encrypter(SecretKey key, String algorithm) {
        try {
            ecipher = Cipher.getInstance(algorithm);
            dcipher = Cipher.getInstance(algorithm);
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchPaddingException e) {
            //System.out.println("EXCEPTION: NoSuchPaddingException");
        } catch (NoSuchAlgorithmException e) {
            //System.out.println("EXCEPTION: NoSuchAlgorithmException");
        } catch (InvalidKeyException e) {
            //System.out.println("EXCEPTION: InvalidKeyException");
        }
    }


  
    /**
     * Takes a single String as an argument and returns an Encrypted version
     * of that String.
     * @param str String to be encrypted
     * @return <code>String</code> Encrypted version of the provided String
     */
    public String encrypt(String str) {
        try {
            // Encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes("UTF8");

            // Encrypt
            byte[] enc = ecipher.doFinal(utf8);

            // Encode bytes to base64 to get a string
            return new sun.misc.BASE64Encoder().encode(enc);
            
   
        } catch (BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
        return null;
    }


    /**
     * Takes a encrypted String as an argument, decrypts and returns the 
     * decrypted String.
     * @param str Encrypted String to be decrypted
     * @return <code>String</code> Decrypted version of the provided String
     */
    public String decrypt(String str) {

        try {

            // Decode base64 to get bytes
           byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
           
           // Decrypt
            byte[] utf8 = dcipher.doFinal(dec);

            // Decode using utf-8
            return new String(utf8, "UTF8");

        } catch (BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
        return null;
    }


    /**
     * The following method is used for testing the String Encrypter class.
     * This method is responsible for encrypting and decrypting a sample
     * String using several symmetric temporary Secret Keys.
     */
    public static String encryptBF(String cardNumber) {
    	
    	 String desEncrypted ="";
    	 String encryptKey = "1234567890123456";
    	
        try {

            byte[] cle = hexToBytes(encryptKey);  
            SecretKey desKey = new SecretKeySpec(cle, "DES"); 

            // Create encrypter/decrypter class
             Encrypter desEncrypter = new Encrypter(desKey, "DES/ECB/PKCS5Padding");
           

            // Encrypt the string
             desEncrypted  = desEncrypter.encrypt(cardNumber);
             return desEncrypted;
            //System.out.println("    Original String  : " + cardNumber);
            //System.out.println("    Encrypted String : " + desEncrypted);
       
        } catch (Exception e) {
        }
        
        return desEncrypted;
    }

    /**
     * The following method is used for testing the String Encrypter class.
     * This method is responsible for encrypting and decrypting a sample
     * String using several symmetric temporary Secret Keys.
     */
    public static String decryptBF(String cardNumberEncrypted) {
    	
    	 String desDecrypted ="";
    	 String encryptKey = "1234567890123456";
        try {

            
        	byte[] cle = hexToBytes(encryptKey); 
            SecretKey desKey = new SecretKeySpec(cle, "DES"); 

            // Create encrypter/decrypter class
            Encrypter desEncrypter = new Encrypter(desKey, "DES/ECB/PKCS5Padding");
          
            // Decrypt the string
            desDecrypted  = desEncrypter.decrypt(cardNumberEncrypted);
          
            
        } catch (Exception e) {
        }
        
        return desDecrypted;
    }
    
    public static byte[] hexToBytes(String str) {
	      if (str==null) {
	         return null;
	      } else if (str.length() < 2) {
	         return null;
	      } else {
	         int len = str.length() / 2;
	         byte[] buffer = new byte[len];
	         for (int i=0; i<len; i++) {
	             buffer[i] = (byte) Integer.parseInt(
	                str.substring(i*2,i*2+2),16);
	         }
	         return buffer;
	      }

 }
 
}

