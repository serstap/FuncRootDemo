package ru.avalon.javapp.j110.funcrootdemo;

public class Main {
    public static void main(String[] args) {
        final double EPS = 1e-5;
        
        // implementation with nested class
        // applicable for any interfaces (with any number of methods)
        DoubleFunc f1 = new ExpMinusHalf();
        System.out.println(RootFinder.findRoot(f1, 0.01, 2, EPS));
        
        // implementation with anonymous class
        // applicable for any interfaces (with any number of methods)
        DoubleFunc f2 = new DoubleFunc() {
            @Override
            public double eval(double x) {
                return Math.sin(x) - 0.75;
            }
        };
        System.out.println(RootFinder.findRoot(f2, 2, 3, EPS));
        
        // implementation with static method reference
        // applicable for functional interfaces only(!)
        DoubleFunc f3 = Math::tan;
        System.out.println(RootFinder.findRoot(f3, 2, 4, EPS));
        
        LnCubeMinusTwo o = new LnCubeMinusTwo();
        // implementation with instance method reference
        // applicable for functional interfaces only(!)
        DoubleFunc f4 = o::evalFunc;
        System.out.println(RootFinder.findRoot(f4, 1, 3, EPS));
        
        // implementation with lambda-expression
        // applicable for functional interfaces only(!)
        DoubleFunc f5 = x -> x*x*x - 8*x + 2;
        System.out.println(RootFinder.findRoot(f5, 1, 5, EPS));
    }
    
    private static class ExpMinusHalf implements DoubleFunc {
        @Override
        public double eval(double x) {
            return Math.exp(-x) - 0.5;
        }
    }
    
    private static class LnCubeMinusTwo {
        double evalFunc(double x) {
            return Math.log(x*x*x) - 2;
        }
    }
}
