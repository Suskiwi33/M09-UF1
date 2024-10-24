package iticbcn.xifratge;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class XifradorAES {
    public static void main(String[] args) {
        String msgs[] = {"Lorem ipsum dicet",
        
        "Hola Andrés cómo está tu cuñado",
        "Àgora ïlla Ôtto"};
        for (int i = 0; i < msgs.length; i++) {
        String msg = msgs[i];
        byte[] bXifrats = null;
        String desxifrat = "";
        try {
        bXifrats = xifraAES(msg, CLAU);
        desxifrat = desxifraAES (bXifrats, CLAU);

        } catch (Exception e) {
        System.err.println("Error de xifrat: "
        + e.getLocalizedMessage ());
        
        }
        System.out.println("--------------------" );
        System.out.println("Msg: " + msg);
        System.out.println("Enc: " + new String(bXifrats));
        System.out.println("DEC: " + desxifrat);
        }
    }

        public static final String ALGORISME_XIFRAT = "AES";
        public static final String ALGORISME_HASH = "SHA-256";
        public static final String FORMAT_AES = "AES/CBC/PKCS5Padding";

        private static final int MIDA_IV = 16;
        private static byte[] iv = new byte [MIDA_IV];
        private static final String CLAU = "LaClauSecretaQueVulguis";




        public static byte[] xifraAES(String msg, String clau) throws Exception {
            
            //Obtenir els bytes de l’String
            byte[] msgByte = msg.getBytes();
            // Genera IvParameterSpec
            SecureRandom securerandom = new SecureRandom();
            securerandom.nextBytes(iv);
            IvParameterSpec IPS = new IvParameterSpec(iv);
            // Genera hash
            MessageDigest md = MessageDigest.getInstance(ALGORISME_HASH);
            byte[] hash = md.digest(clau.getBytes());
            SecretKeySpec key = new SecretKeySpec(hash, ALGORISME_XIFRAT);
            // Encrypt.
            Cipher c = Cipher.getInstance(FORMAT_AES);
            c.init(Cipher.ENCRYPT_MODE, key, IPS);
            byte[] msgX = c.doFinal(msgByte);
            // Combinar IV i part xifrada.
            byte[] IViMsg = new byte[MIDA_IV + msgX.length];
            System.arraycopy(iv, 0, IViMsg, 0, iv.length);
            System.arraycopy(msgX, 0, IViMsg, iv.length, msgX.length);
            return IViMsg;
        }

        public static String desxifraAES (byte[] bIvIMsgXifrat , String clau) throws Exception {
            
            // Extreure l'IV.
            System.arraycopy(bIvIMsgXifrat, 0,iv , 0, MIDA_IV);
            IvParameterSpec IPS = new IvParameterSpec(iv);
            // Extreure la part xifrada.
            byte[] msgX = new byte[bIvIMsgXifrat.length - MIDA_IV];
            System.arraycopy(bIvIMsgXifrat, MIDA_IV,msgX , 0, bIvIMsgXifrat.length - MIDA_IV);
            // Fer hash de la clau
            MessageDigest md = MessageDigest.getInstance(ALGORISME_HASH);
            byte[] hash = md.digest(clau.getBytes());
            SecretKeySpec key = new SecretKeySpec(hash, ALGORISME_XIFRAT);
            // Desxifrar.
            Cipher c = Cipher.getInstance(FORMAT_AES);
            c.init(Cipher.DECRYPT_MODE, key, IPS);
            byte[] msgDes = c.doFinal(msgX);
            return new String(msgDes);
        }
}
