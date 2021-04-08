package ru.avalon.javapp.j110.funcrootdemo;

public class RootFinder {
    public static double findRoot(DoubleFunc func,
            double xa, double xb, double eps) {
        while((xb - xa) > eps) {        // (3)
            double xm = (xa + xb) / 2;  // (1)
            if(func.eval(xm) == 0)      // (2)
                return xm;
                                        // (4)
            if(Math.signum(func.eval(xa)) != Math.signum(func.eval(xm)))
                xb = xm;
            else
                xa = xm;
        }
        return xa;
    }
}
