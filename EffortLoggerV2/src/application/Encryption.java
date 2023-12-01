package application;

import javax.crypto.Cipher; 
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/***** This class is used to implement the AES (Advanced Encryption Standard) Encryption method to encrypt and decrypt 
 * user input data to improve software security and privacy.
 *  
 * @author: Duy Tran
 * 
 */

public class Encryption {
	private static SecretKey key;
	private static String encoding = "UTF-8";
	private static String alias = "cse360";
	private static String pw = "teamth1";
	private static String path = "src/application/keystore.jks";
	
	// Constructor
	public Encryption() {
		try {
			key = loadKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// Encrypts the input
	public static byte[] encrypt(String input) throws Exception {
		Key secretKey = new SecretKeySpec(key.getEncoded(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(input.getBytes(encoding));
	}
	
	// Decrypts the input
	public static String decrypt(byte[] encryptedData) throws Exception {
		Key secretKey = new SecretKeySpec(key.getEncoded(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedData);
        return new String(decryptedBytes, encoding);
	}
	
	// Load the key store (jks file) to get the secret key.
	public static SecretKey loadKey() throws Exception {
		KeyStore keystore = KeyStore.getInstance("JCEKS");
		char[] password = pw.toCharArray();
		SecretKey key = null;
		
		// Load the key store
		try (FileInputStream keystoreFile = new FileInputStream(path)) {
			keystore.load(keystoreFile, password);
			key = (SecretKey) keystore.getKey(alias, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return key;
	}
}
