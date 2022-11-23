/*
 * Kelsy Amirah 
 * 2108107010054
 * Lab Komnum C
 */

 /*MENYELESAIKAN PERSAMAAN NON LINIER METODE BISEKSI */

public class MetodeBiseksi{

    static double fungsi(double x){
        double fx = x*x*x*x + x*x*x - 2*x*x -12;
        return fx;
    }

    public static void main(String[] args){

        double a = -2;              // batas xbawah
        double b = 0;               // batas xatas
        double error = 0.0001;      // toleransi error
        int N = 18;                 // iterasi maksimal/maksimum  
        
        double xr = (a + b)/2;      // hitung   
        double fxr = fungsi(xr);

        double fa = fungsi(a);
        double fb = fungsi(b);

        System.out.println("---------------------------------");
        System.out.println("Penyelesaian Persamaan Non Linier");
        System.out.println("\tMetode Biseksi\t");
        System.out.println("---------------------------------");

        if (fa * fb > 0){
            System.out.println("Proses dihentikan karena tidak ada akar");
        }
        else{
            int kondisi = 1;
            int iterasi = 0;

            while (kondisi == 1){
                iterasi++;
                xr = (a + b)/2;

                fxr = fungsi(xr);

                double c = b - a;

                if ((Math.abs(c))<error || iterasi>N){
                    kondisi = 0;
                }
                
                    if (fa * fxr < 0){
                        b = xr;
                        fb = fxr;
                    }
                    else{
                        a = xr;
                        fa = fxr; 
                    }
            }

            System.out.println("Iterasi ke    : " + iterasi);
            System.out.println("Nilai akar xr : " + xr);
            System.out.println("Nilai fxr     : " + fxr); 
        }
    }
}