public class Rot13{

    public static final String abecedari = "abcdefghijklmnopqrstuvwxyzñ";
    public static final String abecedarimajus = "ABCDEFGHIJKLMNOPQRSTUVWXYZÑ";
    public static String xifraRot13 (String cadena){
        
        String cifrat = "";
        
    
        for(int i=0;i<cadena.length();i++){
            if(Character.isLetter(cadena.charAt(i))){
                
                for(int x=0;x<abecedari.length();x++){
                    if(cadena.charAt(i)==abecedari.charAt(x)){
                        String reempl = "";
                        if((x + 13)>=abecedari.length()){
                            int dif = (x + 13) - abecedari.length();
                            reempl = Character.toString(abecedari.charAt(dif));
                        }
                        else{
                            reempl = Character.toString(abecedari.charAt(x + 13));
                        }
                        cifrat = cifrat + reempl;
                    }
                    else{
                        
                            if(cadena.charAt(i)==abecedarimajus.charAt(x)){
                                String reemplx = "";
                                if((x + 13)>=abecedari.length()){
                                    int dif = (x + 13) - abecedarimajus.length();
                                    reemplx = Character.toString(abecedarimajus.charAt(dif));
                                }
                                else{
                                    reemplx = Character.toString(abecedarimajus.charAt(x + 13));
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

    public static String desxifraRot13 (String cadena){

        String descifrat="";


        for(int i=0;i<cadena.length();i++){
            if(Character.isLetter(cadena.charAt(i))){
                
                for(int x=0;x<abecedari.length();x++){
                    if(cadena.charAt(i)==abecedari.charAt(x)){
                        String reempl = "";
                        if((x - 13)< 0){
                            int dif = (x - 13) + abecedari.length();
                            reempl = Character.toString(abecedari.charAt(dif));
                        }
                        else{
                            reempl = Character.toString(abecedari.charAt(x - 13));
                        }
                        descifrat = descifrat + reempl;
                    }
                    else{
                        
                            if(cadena.charAt(i)==abecedarimajus.charAt(x)){
                                String reemplx = "";
                                if((x - 13)< 0){
                                    int dif = (x - 13) + abecedarimajus.length();
                                    reemplx = Character.toString(abecedarimajus.charAt(dif));
                                }
                                else{
                                    reemplx = Character.toString(abecedarimajus.charAt(x - 13));
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

    public static void main (String[]args){

        String prova = "Hola Como.Estas?";
        String xifrat = xifraRot13(prova);

        System.out.println("La cadena es: " + prova);
        System.out.println("La cadena cifrada es: " + xifraRot13(prova));
        System.out.println("La cadena descifrada es: " + desxifraRot13(xifrat));
    }
}