package Control;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class Encode {
	public static String toSHA1(String str) {
		String salt = "iuseh92q3yr9ow8q3r7y9whf938ay4rhw";
		String result = null;
		
		str = str + salt;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes));
		}
		catch(Exception e) {
			
		}
		return result;
		
	}
}
