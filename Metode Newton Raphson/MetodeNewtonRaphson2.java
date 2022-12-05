/*
 * Kelsy Amirah
 * 2108107010054
 * Lab Komnum C
 */

public class MetodeNewtonRaphson2 {
    
    // misalkan f adalah fungsi yang mendefinisikan f(x) = x^5 + 2x^2 - 4 = 0
    public static double f (double x){
        double nilai = (Math.pow(x, 3)) - (2 * (Math.pow(x, 2))) + 3 * x - 6;
        return nilai;
    }

    // misalkan g adalah fungsi yang mendefinisikan g(x) -> f'(x) = x^5 + 2x^2 - 4 = 0
    public static double g (double x){
        double nilai = 3 * Math.pow(x, 2) - 4 * x + 3;
        return nilai;
    }

    // fungsi untuk mencari akar persamaan
    public static double NewtonRaphson(){
        double x = 3;
        double error = 0.001;
        int iterasi = 0;

        double y1 = f(x);
        double y2 = g(x);

        System.out.println("iterasi " + iterasi);
        System.out.println("x0 = " + x);
        System.out.println("f(0) = " + y1);
        System.out.println("f'(0) = " + y2);

        while ((Math.abs(y1)>=error) && (iterasi<=10)){
            iterasi++;
            x = x - (y1/y2);

            y1 = f(x);
            y2 = g(x);
            
            System.out.println("-------------------------------");
            System.out.println("iterasi ke-" + iterasi);
            System.out.println("x(" + iterasi + ") = " + x); 
            System.out.println("f(" + iterasi + ") = " + y1);
            System.out.println("f'(" + iterasi + ") = " + y2);

        }

        System.out.println("\n");
        System.out.println("Jadi, salah satu akar dari persamaan x^3 -2x^2 + 3x - 6 = 0 adalah terletak  pada");
        System.out.println("x" + iterasi + " = " + x);
        System.out.println("f(" + iterasi + ") = " + y1);

        return x;

    }
 
    public static void main(String[] args) {
        System.out.println("+-----------------------------------------+");
        System.out.println("|PROGRAM PERHITUNGAN METODE NEWTON RAPHSON|");
        System.out.println("+-----------------------------------------+");
        System.out.println("Fungsi  : f(x) = x^3 - 2x^2 + 3x - 6");
        System.out.println("Turunan : f'(x) = 3x^2 - 4x + 3");
        System.out.println("\n");
        System.out.println("Diketahui:");
        System.out.println("Pendekatan awal (x0) = 3");
        System.out.println("Toleransi error (e)  = 0.001");
        System.out.println("Iterasi Maksimum (N) = 10");
        System.out.println("\n");
        System.out.println("Penyelesaian:");

        NewtonRaphson();

    }

}