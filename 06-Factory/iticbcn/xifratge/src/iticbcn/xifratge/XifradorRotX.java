package iticbcn.xifratge;
public class XifradorRotX{

    public static final String abecedari = "abcdefghijklmnopqrstuvwxyzñàáèéíòóúäëïöü";
    public static final String abecedarimajus = "ABCDEFGHIJKLMNOPQRSTUVWXYZÑÀÁÈÉÍÒÓÚÄËÏÖÜ";
    
    public static String xifraRotX (String cadena, int desplaçament){
        
        String cifrat = "";
        
    
        for(int i=0;i<cadena.length();i++){
            if(Character.isLetter(cadena.charAt(i))){
                
                for(int x=0;x<abecedari.length();x++){
                    if(cadena.charAt(i)==abecedari.charAt(x)){
                        String reempl = "";
                        if((x + desplaçament)>=abecedari.length()){
                            int dif = (x + desplaçament) - abecedari.length();
                            reempl = Character.toString(abecedari.charAt(dif));
                        }
                        else{
                            reempl = Character.toString(abecedari.charAt(x + desplaçament));
                        }
                        cifrat = cifrat + reempl;
                    }
                    else{
                        
                            if(cadena.charAt(i)==abecedarimajus.charAt(x)){
                                String reemplx = "";
                                if((x + desplaçament)>=abecedari.length()){
                                    int dif = (x + desplaçament) - abecedarimajus.length();
                                    reemplx = Character.toString(abecedarimajus.charAt(dif));
                                }
                                else{
                                    reemplx = Character.toString(abecedarimajus.charAt(x + desplaçament));
                                }
                                cifrat = cifrat + reemplx;
                            }
                        

                    }
                }

            }
            else{cifrat = cifrat + Character.toString(cadena.charAt(i));}
            
        }
        
        return cifrat;
        
    }

    public static String desxifraRotX (String cadena, int desplaçament){

        String descifrat="";


        for(int i=0;i<cadena.length();i++){
            if(Character.isLetter(cadena.charAt(i))){
                
                for(int x=0;x<abecedari.length();x++){
                    if(cadena.charAt(i)==abecedari.charAt(x)){
                        String reempl = "";
                        if((x - desplaçament)< 0){
                            int dif = (x - desplaçament) + abecedari.length();
                            reempl = Character.toString(abecedari.charAt(dif));
                        }
                        else{
                            reempl = Character.toString(abecedari.charAt(x - desplaçament));
                        }
                        descifrat = descifrat + reempl;
                    }
                    else{
                        
                            if(cadena.charAt(i)==abecedarimajus.charAt(x)){
                                String reemplx = "";
                                if((x - desplaçament)< 0){
                                    int dif = (x - desplaçament) + abecedarimajus.length();
                                    reemplx = Character.toString(abecedarimajus.charAt(dif));
                                }
                                else{
                                    reemplx = Character.toString(abecedarimajus.charAt(x - desplaçament));
                                }
                                descifrat = descifrat + reemplx;
                            }
                        

                    }
                }

            }
            else{descifrat = descifrat + Character.toString(cadena.charAt(i));}
            
        }


        return descifrat;
    }

    public static void forcaBrutaRotX(String cadenaXifrada){

        for(int x= 0; x<abecedari.length();x++){
           System.out.println( desxifraRotX(cadenaXifrada, x));
        }

    }

    public static void main (String[]args){

        String prova = "Höla Como.Estas?";
        int desplaçament = 4; // maxim 30
        String xifrat = xifraRotX(prova, desplaçament);

        System.out.println("La cadena es: " + prova);
        System.out.println("El desplaçament es: " + desplaçament);
        System.out.println("La cadena cifrada es: " + xifraRotX(prova, desplaçament));
        System.out.println("La cadena descifrada es: " + desxifraRotX(xifrat, desplaçament));
        forcaBrutaRotX(xifrat);
    }
}
