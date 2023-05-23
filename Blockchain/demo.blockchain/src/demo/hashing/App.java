package demo.hashing;

import java.util.Base64;
import java.util.LinkedList;

public class App {

	// Demo: hashCode/hash/ hashOutput
	// Process: input -> hash-function -> output
	
	public static void main(String[] args) {
		//Ever data object/items has a hashCode!
		
		String s = "hello";
		//System.out.println(String.join("|",s, String.valueOf(s.hashCode())));
		System.out.println(String.join("|","world", String.valueOf("world".hashCode())));
		
		//working with collection?
		
		var lst = new LinkedList<String>();
		lst.add("aaa");
		lst.add("bbb");
		lst.add("ccc");
		System.out.println(lst.hashCode()); //75709313
		lst.add("ddd");
		System.out.println(lst.hashCode()); //-1327879293
		// problem the hachCode can be easily predicted
		// Solution: increasing the complexity of the hashCoding algorithms. (Secure Hash Algorithms)

		
		
		
		
		String passwd = "Hello!";
		// digest the passwd
		byte[] salt = Salt.generate();
		String hash = Hasher.sha256(passwd, salt);
		String pwd = "123456";
		
		System.out.print(String.join("|", passwd, hash));
		
		var mysalt = Base64.getEncoder().encodeToString(Salt.generate());
		//var salt = Salt.generate();
		
		System.out.println("\nUnsalted hash: " + String.join("|", pwd, Hasher.sha256(pwd)));
		System.out.println("Salted hash: " + String.join("|", pwd, Hasher.sha256(pwd, salt)));
		
		System.out.println("Salt: " + mysalt);
	}
	
		
	
}
