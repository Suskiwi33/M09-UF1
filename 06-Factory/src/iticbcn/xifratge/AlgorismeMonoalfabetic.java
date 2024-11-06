package iticbcn.xifratge;

public class AlgorismeMonoalfabetic extends AlgorismeFactory {
    public AlgorismeMonoalfabetic (){
    
    }
  
    public Xifrador creaXifrador(){
      return new XifradorMonoalfabetic();
    }
}
