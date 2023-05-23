package demo.signature;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.concurrent.TimeUnit;
import demo.keygenerator.MyKeyPair;

public class App 
{
    public static void main(String[] args) throws Exception
    {
        //DEMO: create the keypair
        MyKeyPair.create();
        PublicKey publicKey = MyKeyPair.getPublicKey();
        PrivateKey privateKey = MyKeyPair.getPrivateKey();

        MySignature sig = new MySignature();

        String data = "simple digital signature demo";
        System.out.println("Data: " + data);

        // Sign the data w/ private key
        String signature = sig.sign(data, privateKey);
        System.out.println("Signature: " + signature);

        System.out.println("\n> Transfering...");
        TimeUnit.SECONDS.sleep(3);
        
        // verify with public Key
        System.out.println();
        boolean isValid = sig.verify("simple digital signature demo", signature, publicKey);
        System.out.println((isValid) ? ">> Correct!" : ">> Incorrect!");
        
        System.out.print("> Done...");
    }
}
