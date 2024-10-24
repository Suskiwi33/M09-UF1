package iticbcn.xifratge.src.iticbcn.xifratge;

public interface Xifrador {
    
    public TextXifrat xifra (String msg, String clau) throws ClauNoSuportada {

    }

    public TextXifrat desxifra (TextXifrat xifrat, String clau) throws ClauNoSuportada {

    }
}
