import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Hashes {
    private int npass = 0;
    public static void main(String[] args) throws Exception {
        String salt = "qpoweiruañslkdfjz";
        String pw = "aaabF!";
        Hashes h = new Hashes();
        String[] aHashes = { h.getSHA512AmbSalt(pw, salt),
        h.getPBKDF2AmbSalt(pw, salt) };
        String pwTrobat = null;
        String[] algorismes = {"SHA-512", "PBKDF2"};
        for(int i=0; i< aHashes.length; i++){
        System.out.printf("===========================\n");
        System.out.printf("Algorisme: %s\n", algorismes[i]);
        System.out.printf("Hash: %s\n",aHashes[i]);
        System.out.printf("---------------------------\n");
        System.out.printf("-- Inici de força bruta ---\n");
        
        long t1 = System.currentTimeMillis();
        pwTrobat = h.forcaBruta(algorismes[i], aHashes[i], salt);
        long t2 = System.currentTimeMillis();
        
        System.out.printf("Pass : %s\n", pwTrobat);
        System.out.printf("Provats: %d\n", h.npass);
        System.out.printf("Temps : %s\n", h.getInterval(t1, t2));
        System.out.printf("---------------------------\n\n");
        }
    }


    public String getSHA512AmbSalt(String pw, String salt){

        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            
            String input = salt + pw;

           
            byte[] hashedBytes = md.digest(input.getBytes());

            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            
            npass ++;
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }


    public String getPBKDF2AmbSalt(String pw, String salt){
        int iterations = 65536; 
        int keyLength = 512; 

        try {
           
            PBEKeySpec spec = new PBEKeySpec(pw.toCharArray(), salt.getBytes(), iterations, keyLength);
            
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            
            byte[] hashedBytes = keyFactory.generateSecret(spec).getEncoded();
            npass++;
            return Base64.getEncoder().encodeToString(hashedBytes);
            
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error al generar el hash PBKDF2", e);
        }
    }


    public String forcaBruta(String alg, String hash, String salt){
        
        npass = 0;
        String charset = "abcdefABCDF1234567890!";
        char[] chars = charset.toCharArray();
        char[] Passw = new char[6];

        if(alg.equalsIgnoreCase("SHA-512")){
            for(int i = 0; i < charset.length(); i++){
                Passw[0]= chars[i];
                if(getSHA512AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                    return String.copyValueOf(Passw);
                }
                for(int x = 0; x < charset.length(); x++){
                    Passw[1]= chars[x];
                    if(getSHA512AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                        return String.copyValueOf(Passw);
                    }
                    for(int y = 0; y < charset.length(); y++){
                        Passw[2]= chars[y];
                        if(getSHA512AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                            return String.copyValueOf(Passw);
                        }
                        for(int z = 0; z < charset.length(); z++){
                            Passw[3]= chars[z];
                            if(getSHA512AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                                return String.copyValueOf(Passw);
                            }
                            for(int n = 0; n < charset.length(); n++){
                                Passw[4]= chars[n];
                                if(getSHA512AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                                    return String.copyValueOf(Passw);
                                }
                                for(int g = 0; g < charset.length(); g++){
                                    Passw[5]= chars[g];
                                    if(getSHA512AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                                        return String.copyValueOf(Passw);
                                    }
                                    Passw[5] = ' ';
                                }
                                Passw[4] = ' ';
                            }
                            Passw[3] = ' ';
                        }
                        Passw[2] = ' ';
                    }
                    Passw[1] = ' ';
                }
                
            }
        } else if(alg.equalsIgnoreCase("PBKDF2")){
            for(int i = 0; i < charset.length(); i++){
                Passw[0]= chars[i];
                if(getPBKDF2AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                    return String.copyValueOf(Passw);
                }
                for(int x = 0; x < charset.length(); x++){
                    Passw[1]= chars[x];
                    if(getPBKDF2AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                        return String.copyValueOf(Passw);
                    }
                    for(int y = 0; y < charset.length(); y++){
                        Passw[2]= chars[y];
                        if(getPBKDF2AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                            return String.copyValueOf(Passw);
                        }
                        for(int z = 0; z < charset.length(); z++){
                            Passw[3]= chars[z];
                            if(getPBKDF2AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                                return String.copyValueOf(Passw);
                            }
                            for(int n = 0; n < charset.length(); n++){
                                Passw[4]= chars[n];
                                if(getPBKDF2AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                                    return String.copyValueOf(Passw);
                                }
                                for(int g = 0; g < charset.length(); g++){
                                    Passw[5]= chars[g];
                                    if(getPBKDF2AmbSalt(String.copyValueOf(Passw), salt).equals(hash)){
                                        return String.copyValueOf(Passw);
                                    }
                                    Passw[5] = ' ';
                                }
                                Passw[4] = ' ';
                            }
                            Passw[3] = ' ';
                        }
                        Passw[2] = ' ';
                    }
                    Passw[1] = ' ';
                }
                
            }

        }
        else{
            return "Algoritme no implementat";
        }

        return "Contrasenya no trobada";
        
    }

    public String getInterval(long t1, long t2){

        long difMillis = Math.abs(t2 - t1);

        long dias = difMillis / (1000 * 60 * 60 * 24);
        difMillis %= (1000 * 60 * 60 * 24);

        long hores = difMillis / (1000 * 60 * 60);
        difMillis %= (1000 * 60 * 60);

        long minuts = difMillis / (1000 * 60);
        difMillis %= (1000 * 60);

        long segons = difMillis / 1000;
        long milisegons = difMillis % 1000;

        return String.format("Temps : %d dies / %d hores / %d minuts / %d segons / %d millis", 
                              dias, hores, minuts, segons, milisegons);
    }

}