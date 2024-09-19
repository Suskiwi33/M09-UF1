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

    public static void main (String[]args){
        System.out.println(xifraRot13("Hola Como.Estas?"));
    }
}