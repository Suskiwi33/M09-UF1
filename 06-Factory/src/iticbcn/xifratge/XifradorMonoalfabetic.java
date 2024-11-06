package iticbcn.xifratge;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class XifradorMonoalfabetic implements Xifrador{

    

    public TextXifrat xifra(String msg, String clau) throws ClauNoSuportada {
    if (clau != null) throw new ClauNoSuportada("Xifratxe monoalfabètic no suporta clau != null");

    String result = xifraMonoAlfa(msg);

    return new TextXifrat(result.getBytes());
  }
  public String desxifra (TextXifrat xifrat, String clau) throws ClauNoSuportada {
    if (clau != null) throw new ClauNoSuportada("Xifratxe monoalfabètic no suporta clau != null");

    String textXifrat = new String(xifrat.getBytes());

    return desxifraMonoAlfa(textXifrat);
  }




    static Character[] alfabetoCompleto = {
        'A', 'Á', 'À', 'Ä', 'Â', 'B', 'C', 'Ç', 'D', 'E', 'É', 'È', 'Ë', 'Ê', 'F', 'G', 'H', 'I', 'Í', 'Ì', 'Ï', 'Î',
        'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'Ó', 'Ò', 'Ö', 'Ô', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'Ù', 'Ü', 'Û', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'á', 'à', 'ä', 'â', 'b', 'c', 'ç', 'd', 'e', 'é', 'è', 'ë', 'ê', 'f', 'g', 'h', 'i', 'í', 'ì', 'ï', 'î',
        'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'ó', 'ò', 'ö', 'ô', 'p', 'q', 'r', 's', 't', 'u', 'ú', 'ù', 'ü', 'û', 'v', 'w', 'x', 'y', 'z'
    };

    static char[] alfabetPermutat= permutaAlfabet(alfabetoCompleto);

    public static char[] permutaAlfabet(Character[]alfabeto){
        List<Character> listAlfabeto = Arrays.asList(alfabeto);
        Collections.shuffle(listAlfabeto);
        Character[] alfabetMezcla = listAlfabeto.toArray(new Character[0]);
        char[] alfabetM = new char[alfabetMezcla.length];

        for(int x=0; x <alfabetMezcla.length;x++){
            alfabetM[x]=alfabetMezcla[x];
        }
        return alfabetM;
    }

    public static String xifraMonoAlfa(String cadena){

        String xifrat = "";

        
            for(int i=0; i<cadena.length();i++){
                if(Character.isLetter(cadena.charAt(i))){
                    for(int x=0;x<alfabetoCompleto.length;x++){
                        if(cadena.charAt(i)==(alfabetoCompleto[x])){
                            xifrat=xifrat + Character.toString(alfabetPermutat[x]);
                        }
                    }
                }else{
                    xifrat=xifrat + Character.toString(cadena.charAt(i));
                }
            }

        return xifrat;
    }

    public static String desxifraMonoAlfa(String cadena){
        String desxifrat = "";

        for(int i=0; i<cadena.length();i++){
            if(Character.isLetter(cadena.charAt(i))){
                for(int x=0;x<alfabetPermutat.length;x++){
                    if(cadena.charAt(i)==(alfabetPermutat[x])){
                        desxifrat=desxifrat + Character.toString(alfabetoCompleto[x]);
                    }
                }
            }else{desxifrat=desxifrat + Character.toString(cadena.charAt(i));}
        }

        return desxifrat;
    }

    public static void main(String []args){
        permutaAlfabet(alfabetoCompleto);
        System.out.println(xifraMonoAlfa("Hola que tal"));
        System.out.println(desxifraMonoAlfa(xifraMonoAlfa("Hola que tal")));
    }
    
}