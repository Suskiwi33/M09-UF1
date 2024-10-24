package iticbcn.xifratge.src.iticbcn.xifratge;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class XifradorPolialfabetic {

    private static final int seed = 24543;
    private static final char[] ALFABETO_COMPLETO = "AÁÀÄÂBCÇDÉÈËÊFGHIÍÌÏÎJKLMNÑÓÒÖÔPQRSTUÚÙÜÛVWXYZ".toCharArray();
    public static char[] permutacio = new char[ALFABETO_COMPLETO.length];
    private static Random random;
    
    
    public static void main(String[] args) {
        String msgs[] = {"Test 01 àrbritre, coixí, Perímetre",
        "Test 02 Taüll, DÍA, año",
        "Test 03 Peça, Òrrius, Bòvila"};
        String msgsXifrats[] = new String[msgs.length];
        
        System.out.println("Xifratge:\n--------");
        for (int i = 0; i < msgs.length; i++) {
        initRandom(seed);
        msgsXifrats[i] = xifraPoliAlfa(msgs[i]);
        System.out.printf("%-34s -> %s%n", msgs[i], msgsXifrats[i]);
        }
        
        System.out.println("Desxifratge:\n-----------");
        for (int i = 0; i < msgs.length; i++) {
        initRandom(seed);
        String msg = desxifraPoliAlfa(msgsXifrats[i]);
        System.out.printf("%-34s -> %s%n", msgsXifrats[i], msg);
        }
    }

    private static void initRandom(int seed) {
        random = new Random(seed);
    } 

    public static char[] permutaAlfabet(char[] alfabeto) {
        List<Character> listAlfabeto = Arrays.asList(toCharacterArray(alfabeto));
        Collections.shuffle(listAlfabeto, random);
        Character[] alfabetMezcla = listAlfabeto.toArray(new Character[0]);
        char[] alfabetM = new char[alfabetMezcla.length];

        for (int x = 0; x < alfabetMezcla.length; x++) {
            alfabetM[x] = alfabetMezcla[x];
        }
        return alfabetM;

    }

    private static Character[] toCharacterArray(char[] array) {
        Character[] resultat = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            resultat[i] = array[i];
        }
        return resultat;
    }

    public static String xifraPoliAlfa(String cadena) {
        initRandom(seed);
        String xifrat = ""; 
    
        for (int i = 0; i < cadena.length(); i++) {
            char[] alfabetPermutat = permutaAlfabet(ALFABETO_COMPLETO);
            char charActual = cadena.charAt(i);
            boolean trobat = false;
    
            if (Character.isLetter(charActual)) {
                for (int x = 0; x < ALFABETO_COMPLETO.length; x++) {
                    if (Character.toUpperCase(charActual) == ALFABETO_COMPLETO[x]) {
                        if(Character.isUpperCase(charActual)){
                            xifrat += Character.toUpperCase(alfabetPermutat[x]);
                            trobat = true;
                            
                        }else{
                            xifrat += Character.toLowerCase(alfabetPermutat[x]);
                            trobat = true;
                            
                        }
                        break;
                    }
                }
            }
    
            if (!trobat) { 
                xifrat += cadena.charAt(i);
            }
        }
    
        return xifrat;
    }


    public static String desxifraPoliAlfa(String cadena) {
        initRandom(seed);
        String desxifrat = "";
    
        for (int i = 0; i < cadena.length(); i++) {
            char[] alfabetPermutat = permutaAlfabet(ALFABETO_COMPLETO);
            char charActual = cadena.charAt(i);
            boolean trobat = false;
    
            if (Character.isLetter(charActual)) {
                for (int x = 0; x < alfabetPermutat.length; x++) {
                    if (Character.toUpperCase(charActual) == alfabetPermutat[x]) {
                        if(Character.isUpperCase(charActual)){
                            desxifrat += Character.toUpperCase(ALFABETO_COMPLETO[x]);
                            trobat = true;
                            
                        }else{
                            desxifrat += Character.toLowerCase(ALFABETO_COMPLETO[x]);
                            trobat = true;
                            
                        }
                        break;  
                    }
                }
            }
    
            if (!trobat) {
                desxifrat += cadena.charAt(i);
            }
        }
    
        return desxifrat;
    }

}
