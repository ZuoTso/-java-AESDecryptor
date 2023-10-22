package AESPackge;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES {
    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException,
            BadPaddingException, NoSuchPaddingException, InvalidKeyException {
        
        String samples = "!\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        String cipher = "";
        
        // E14106375 
        int X = 0;
        String key_str = "",key1 = "",key2 = "",key3 = "",key4 = "",key5 = "";
        
      //for (int X = 0; X <= 0; X++) {
        
        switch (X) {
        case 0:
        	cipher = "2NHkjlDyk82JBke5q8CnMQZ1iiHID8QEst+/Ld6lWFMP5omXXh/1LnmrYKOD04idKfzfL+6C96391/iN7+X0eg==";
        	key1 = "$\""; key2 = "vXl"; key3 = "K"; key4 = "\\/{9Fp";
        	break;
        case 1:
        	cipher = "INNkAZHIpe5u9LvzhH24VyORcZQVDCFXzV6V/l9M7rpgqskMxvaRbGwR2dZaxMDZ";
        	key1 = " 0lOS"; key2 = "b]"; key3 = "&N)"; key4 = "w"; key5 = "@+";
        	break;
        case 2:
        	cipher = "NnJyrVT80DxOU5jOxHdZ9NRlaLPRhaAUYANfaVACUeqcrPoXz5eeTs9m6X2fVJC9SJ+X03mu3zD/WTiUjwzIyg==";
        	key1 = "Bk"; key2 = "fom]"; key3 = "H"; key4 = "(J"; key5 = "'|,";
        	break;
        case 3:
        	cipher = "89NEvN56VtNjo1w5x3whmFUOZOqTaRyoMnIrPjCGKUv5n7kgGFHDmStzEgDFAU7QnZOK9MLeO/FW4etzIOhpKfOsw5xSD4Em72X1O2FRfaM=";
        	key1 = "2"; key2 = "?"; key3 = "mYD;@"; key4 = ";x"; key5 = "v\"i";
        	break;
        case 4:
        	cipher = "FZp57a6p84EUNC7I/ENj4RhPZtryOJr4che9JbA8ng1eI8ZMTlsl8kzicBDqkOqkFj3lwC69KR2MeA8lscVlig==";
        	key1 = "|q"; key2 = "~k="; key3 = "&?I$Fx"; key4 = "N";
        	break;
        default:
        	return;
        }
        
        label: for (int i = 0; i < samples.length(); i++) {
        	for (int j = 0; j < samples.length(); j++) {
        		for (int k = 0; k < samples.length(); k++) {
        			for (int x = 0; x < samples.length(); x++) {
        				key_str = key1 + samples.charAt(i) + key2 + samples.charAt(j) + key3 + samples.charAt(k) + key4 + samples.charAt(x) + key5;
                        
                        SecretKeySpec key = new SecretKeySpec(key_str.getBytes(StandardCharsets.UTF_8), "AES");
                        Cipher aesCipher1 = Cipher.getInstance("AES/ECB/NoPadding");
                        aesCipher1.init(Cipher.DECRYPT_MODE, key);
                        byte[] byte_plaintext = aesCipher1.doFinal(Base64.getDecoder().decode(cipher));
                        String plaintext = new String(byte_plaintext, StandardCharsets.UTF_8);
                        if (plaintext.matches("[a-zA-Z0-9 !\"#$%&\'()*+,.@/:;\\-<=>?^_`\\[\\]{|}~\0]{1,}")) {
                            plaintext = plaintext.replaceAll("\0", "");
                            System.out.println("X = " + X);
                            System.out.println("Key : " + key_str);
                            System.out.println(plaintext);
                            System.out.println("\n------------------------------");
                            try {
                                PrintWriter writer = new PrintWriter(new FileOutputStream("C:/MyCodeHistory/AES.txt", true));
                                writer.println("X = " + X);
                                writer.println("Key : " + key_str);
                                writer.println(plaintext);
                                writer.println("\n------------------------------");
                                writer.flush();
                                writer.close();
                                if(X != 4) break label;
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }
            }
        //}
    }
}
