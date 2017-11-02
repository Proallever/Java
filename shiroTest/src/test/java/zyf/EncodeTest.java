package zyf;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;

/**
* @Author 庄元丰
* @CreateTime 2017年11月2日下午3:44:16
*/
public class EncodeTest {

	/**
	 * 测一下shiro带的Base64加密 和16进制加密
	 */
	@Test
	public void testBase64() {
		String str = "zyf";
		String encodeStr = Base64.encodeToString(str.getBytes());
		String hexEncodeStr = Hex.encodeToString(str.getBytes());
		System.out.println(encodeStr);
		System.out.println(hexEncodeStr);
		String decodeStr = Base64.decodeToString(encodeStr);
		String hexDexodeStr = new String(Hex.decode(hexEncodeStr.getBytes()));
		System.out.println(decodeStr);
		System.out.println(hexDexodeStr);
	}
	
	/**
	 * 散列
	 */
	@Test
	public void testSha1() {
		String str = "zyf";
		String salt = "123";
		
		String sha1 = new Sha256Hash(str, salt).toString();
		System.out.println(sha1);
	}
	
	
}
