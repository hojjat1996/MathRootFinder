import java.util.* ;
 public class project050 {

    public static void main(String[] args) {
        BisectionMethod bm = new BisectionMethod(problem::g);
        
        ArrayList<Double> mainRoots ;

        
        mainRoots = bm.FindRoot(-15, 5, 100) ;
        for(int i=0; i<mainRoots.size(); i++){
            System.out.println(i+1 + ": " + mainRoots.get(i));
        }
       
        bm.setFunction(problem::f);
        mainRoots = bm.FindRoot(-10, 10, 100);
        for(int i=0; i<mainRoots.size(); i++){
            System.out.println(i+1 + ": " + mainRoots.get(i));
        }
        
    }
}

class problem{
    public static double f(double x){
        return 4 - 8.5 *(x - Math.sin(x)) ;
    }
    public static double g(double x){
        return x*x + 10*x - 10 ;
    }
    public static double hamid(double x){
        return 5 + x*(5 +x*(Math.sin(x) + Math.cos(x))) ;
    }
}

