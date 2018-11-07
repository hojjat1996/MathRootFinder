import java.util.ArrayList;
import java.util.function.* ;

public class BisectionMethod {
    //constructor that imports the function to this algorithm :
    public BisectionMethod(Function<Double,Double> function){
        this.function = function ;
    }
    //describing the function that can be as a variable :
    private Function<Double,Double> function = null;
    public Function<Double,Double> getFunction() {return function;}
    public void setFunction(Function<Double,Double> function) {this.function = function;}
    
    //Evaluation of the function :
    public double FunctionValue(double input){
        if(function == null){
            return Double.NaN;
        }
        return this.function.apply(input);
        
    }
    public ArrayList<Double> FindRoot(double a, double b, double maxit){
        
        ArrayList<Double> roots = new ArrayList<>();
        int section = 1000 ;
        double L = (b - a)/section ;
        double fa = FunctionValue(a) ;
        double fb = FunctionValue(b) ;
        if(fa == 0)roots.add(a);
        if(fb == 0)roots.add(b);
        
        double a1 = a ;
        double b1 = a+ L ;
        
        for(int i = 0; i < section; i++){
            double fa1 = FunctionValue(a1);
            if(fa1 == 0){
                roots.add(a1) ;
                System.out.println("fa1 === 0");
            }
            
            double fb1 = FunctionValue(b1);
            if(fb1 == 0){
                roots.add(b1) ;
                                System.out.println("fb1 === 0");
            }
            
            if(fa1*fb1 < 0){
                for(int it=0; it<maxit; it++){
                double m  = (b1+a1)/2 ;
                double fm = FunctionValue(m);
            
            if(fm == 0){
                roots.add(m);
                System.out.println("fm === 0");
                break;
            }
            
            if(fm*fa1>0){
                a1  = m  ;
                fa1 = fm ;
            }else{
                b1  =  m ;
                fb1 = fm ;
            }
              
            }
                roots.add(Math.abs(fa1)>Math.abs(fb1)? b1 : a1) ;
        }
            a1 = b1 ;
            b1 = b1 + L ;
    }
        return roots ;
        }       
}