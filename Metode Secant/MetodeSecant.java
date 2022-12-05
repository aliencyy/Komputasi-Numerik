/*
 * Kelsy Amirah
 * 2108107010054
 * Lab Komnum C
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class MetodeSecant {

    // misalkan f1 adalah fungsi yang mendefinisikan f(x) = x*exp(-x)+sin(2*x)
    public static double f1(double x) {
        double fungsi = (x * (Math.exp(-x))) + (Math.sin(2 * x));
        return fungsi;
    }

    // misalkan f2 adalah fungsi yang mendefinisikan f(x) = cos(x+1)+exp(-x+2)
    public static double f2(double x){
        double fungsi = (Math.cos(x + 1)) + (Math.exp(-x + 2));
        return fungsi;
    }

    // misalkan f3 adalah fungsi yang mendefinisikan f(x) = cos(x)-sin(x))
    public static double f3(double x){
        double fungsi = (Math.cos(x)) - (Math.sin(x));
        return fungsi;
    }

    // Nomor 1
    public static void Nomor1(){
        //------------------------------------------------------------|
        //                  METODE TABEL                              |
        //------------------------------------------------------------|
        double xbawah = 1;
        double xatas = 2.4;
        double x;
        double y;
        double fxa;
        double fxb;
        double H = (xatas-xbawah)/10;
        double e = 0.002;
        int i =0 ;

        DecimalFormat digit1=new DecimalFormat("0.0000");
        System.out.println("\n");
        System.out.println("f(x) = x*exp(-x)+sin(2*x)");
        System.out.println("x = [1, 2.4] \n");
        System.out.println("Lakukukan pencarian akar menggunakan metode tabel\nUntuk mendapatkan nilai X0 dan X1 nya.");
        System.out.println("h = " + digit1.format(H)+"\n");
        System.out.println("\t\t   METODE TABEL \t");
        System.out.println("-------------------------------------------------");
        System.out.println("|\ti\t|\tx\t|\tfx\t|");
        System.out.println("-------------------------------------------------");

        do{
            DecimalFormat d=new DecimalFormat("0.0000");
            x = xbawah + (i * H);
            i++;
            fxa = f1(x);
            y = xbawah + (i * H);
            fxb = f1(y);

            System.out.println("|\t"+i+"\t|\t"+d.format(x)+"\t|\t"+d.format(fxa)+"\t|");

            if(fxa*fxb<=0){
                break;
            }
            
        } while(i<=10);

        System.out.println("-------------------------------------------------");
        System.out.println("\nx0= "+digit1.format(x)+" dan x1= "+digit1.format(y));

        //------------------------------------------------------------|
        //                  METODE SECANT                             |
        //------------------------------------------------------------|
        double xa = x;      
        double xb = y;      
        double a;
        double fx0;         
        double fx1;         
        double fx,ft;
        double f;

        fx0 = f1(xa);
        fx1 = f1(xb);
        System.out.println("fx0= "+digit1.format(fx0)+" dan fx1= "+digit1.format(fx1)+"\n");
        
        f = fx1 - fx0;
        f = -f;

        System.out.println("\t\t   METODE SECANT \t");
        System.out.println("-------------------------------------------------");
        System.out.println("|\tx\t|\tfx\t|\terror\t|");
        System.out.println("-------------------------------------------------");
        System.out.println("|\t"+digit1.format(fxa)+"\t|\t"+digit1.format(fx0)+"\t|\t\t|");
        System.out.println("|\t"+digit1.format(fxb)+"\t|\t"+digit1.format(fx1)+"\t|\t"+digit1.format(f)+"\t|");

        do{
            i++;
            DecimalFormat digit=new DecimalFormat("0.0000");
            a = xb - (fx1 * ((xb - xa) / (fx1 - fx0)));
            fx = f1(a);
            f = fx - fx1;
            System.out.println("|\t"+digit.format(a)+"\t|\t"+digit.format(fx)+"\t|\t"+digit.format(f)+"\t|");
            
            if(f<0){
                ft = Math.abs(f);
                if(ft <= e){
                    System.out.println("-------------------------------------------------");
                    System.out.println("Jadi, akarnya adalah  x = " + digit1.format(a));
                    System.out.println("Nilai f(x) =" + digit1.format(fx));
                    break;
                }else{
                    continue;

                }
            }else if(f<=e){
                System.out.println("-------------------------------------------------");
                System.out.println("Jadi, akarnya adalah  x = " + digit1.format(a));
                System.out.println("Nilai f(x) =" + digit1.format(fx));
                
            }else{
                xa = xb;
                xb = a;
                fx0 = fx1;
                fx1 = fx;

            }
            
        }while(i <= 10);

    }

    // Nomor 2
    public static void Nomor2(){
        //------------------------------------------------------------|
        //                  METODE TABEL                              |
        //------------------------------------------------------------|
        double xbawah = 1;
        double xatas = 3;
        double x;
        double y;
        double fxa;
        double fxb;
        double H = (xatas-xbawah)/10;
        double e = 0.001;
        int i = 0 ;

        DecimalFormat digit1=new DecimalFormat("0.0000");
        System.out.println("\n");
        System.out.println("f(x) = cos(x+1)+exp(-x+2)");
        System.out.println("x = [1, 3] \n");
        System.out.println("Lakukukan pencarian akar menggunakan metode tabel\nUntuk mendapatkan nilai X0 dan X1 nya.");
        System.out.println("h = " + digit1.format(H)+"\n");
        System.out.println("\t\t   METODE TABEL \t");
        System.out.println("-------------------------------------------------");
        System.out.println("|\ti\t|\tx\t|\tfx\t|");
        System.out.println("-------------------------------------------------");

        do{
            DecimalFormat d=new DecimalFormat("0.0000");
            x = xbawah + (i * H);
            i++;
            fxa = f2(x);
            y = xbawah + (i * H);
            fxb = f2(y);

            System.out.println("|\t"+i+"\t|\t"+d.format(x)+"\t|\t"+d.format(fxa)+"\t|");

            if(fxa*fxb<=0){
                break;
            }
            
        } while(i<=10);

        System.out.println("-------------------------------------------------");
        System.out.println("\nx0= "+digit1.format(x)+" dan x1= "+digit1.format(y));

        //------------------------------------------------------------|
        //                  METODE SECANT                             |
        //------------------------------------------------------------|
        double xa = x;      
        double xb = y;      
        double a;
        double fx0;         
        double fx1;         
        double fx,ft;
        double f;

        fx0 = f2(xa);
        fx1 = f2(xb);
        System.out.println("fx0= "+digit1.format(fx0)+" dan fx1= "+digit1.format(fx1)+"\n");
        
        f = fx1 - fx0;
        f = -f;

        System.out.println("\t\t   METODE SECANT \t");
        System.out.println("-------------------------------------------------");
        System.out.println("|\tx\t|\tfx\t|\terror\t|");
        System.out.println("-------------------------------------------------");
        System.out.println("|\t"+digit1.format(fxa)+"\t|\t"+digit1.format(fx0)+"\t|\t\t|");
        System.out.println("|\t"+digit1.format(fxb)+"\t|\t"+digit1.format(fx1)+"\t|\t"+digit1.format(f)+"\t|");

        do{
            i++;
            DecimalFormat digit=new DecimalFormat("0.0000");
            a = xb - (fx1 * ((xb - xa) / (fx1 - fx0)));
            fx = f2(a);
            f = fx - fx1;
            System.out.println("|\t"+digit.format(a)+"\t|\t"+digit.format(fx)+"\t|\t"+digit.format(f)+"\t|");
            
            if(f<0){
                ft = Math.abs(f);
                if(ft <= e){
                    System.out.println("-------------------------------------------------");
                    System.out.println("Jadi, akarnya adalah  x = " + digit1.format(a));
                    System.out.println("Nilai f(x) =" + digit1.format(fx));
                    break;
                }else{
                    continue;

                }
            }else if(f<=e){
                System.out.println("-------------------------------------------------");
                System.out.println("Jadi, akarnya adalah  x = " + digit1.format(a));
                System.out.println("Nnilai f(x) =" + digit1.format(fx));
                
            }else{
                xa = xb;
                xb = a;
                fx0 = fx1;
                fx1 = fx;

            }
            
        }while(i <= 10);

    }

    // Nomor 3
    public static void Nomor3(){
        //------------------------------------------------------------|
        //                  METODE TABEL                              |
        //------------------------------------------------------------|
        double xbawah = 0;
        double xatas = 2;
        double x;
        double y;
        double fxa;
        double fxb;
        double H = (xatas-xbawah)/10;
        double e = 0.001;
        int i = 0;

        DecimalFormat digit1=new DecimalFormat("0.0000");
        System.out.println("\n");
        System.out.println("f(x) = cos(x)-sin(x)");
        System.out.println("x = [0, 2] \n");
        System.out.println("Lakukukan pencarian akar menggunakan metode tabel\nUntuk mendapatkan nilai X0 dan X1 nya.");
        System.out.println("h = " + digit1.format(H)+"\n");
        System.out.println("\t\t   METODE TABEL \t");
        System.out.println("-------------------------------------------------");
        System.out.println("|\ti\t|\tx\t|\tfx\t|");
        System.out.println("-------------------------------------------------");

        do{
            DecimalFormat d=new DecimalFormat("0.0000");
            x = xbawah + (i * H);
            i++;
            fxa = f3(x);
            y = xbawah + (i * H);
            fxb = f3(y);

            System.out.println("|\t"+i+"\t|\t"+d.format(x)+"\t|\t"+d.format(fxa)+"\t|");

            if(fxa*fxb<=0){
                break;
            }
            
        } while(i<=10);

        System.out.println("-------------------------------------------------");
        System.out.println("\nx0= "+digit1.format(x)+" dan x1= "+digit1.format(y));

        //------------------------------------------------------------|
        //                  METODE SECANT                             |
        //------------------------------------------------------------|
        double xa = x;      
        double xb = y;      
        double a;
        double fx0;         
        double fx1;         
        double fx,ft;
        double f;

        fx0 = f3(xa);
        fx1 = f3(xb);
        System.out.println("fx0= "+digit1.format(fx0)+" dan fx1= "+digit1.format(fx1)+"\n");
        
        f = fx1 - fx0;
        f = -f;

        System.out.println("\t\t   METODE SECANT \t");
        System.out.println("-------------------------------------------------");
        System.out.println("|\tx\t|\tfx\t|\terror\t|");
        System.out.println("-------------------------------------------------");
        System.out.println("|\t"+digit1.format(fxa)+"\t|\t"+digit1.format(fx0)+"\t|\t\t|");
        System.out.println("|\t"+digit1.format(fxb)+"\t|\t"+digit1.format(fx1)+"\t|\t"+digit1.format(f)+"\t|");

        do{
            i++;
            DecimalFormat digit=new DecimalFormat("0.0000");
            a = xb - (fx1 * ((xb - xa) / (fx1 - fx0)));
            fx = f3(a);
            f = fx - fx1;
            System.out.println("|\t"+digit.format(a)+"\t|\t"+digit.format(fx)+"\t|\t"+digit.format(f)+"\t|");
            
            if(f<0){
                ft = Math.abs(f);
                if(ft <= e){
                    System.out.println("-------------------------------------------------");
                    System.out.println("Jadi, akarnya adalah  x = " + digit1.format(a));
                    System.out.println("Nilai f(x) =" + digit1.format(fx));
                    break;
                }else{
                    continue;

                }
            }else if(f<=e){
                System.out.println("-------------------------------------------------");
                System.out.println("Jadi, akarnya adalah  x = " + digit1.format(a));
                System.out.println("Nilai f(x) =" + digit1.format(fx));
                
            }else{
                xa = xb;
                xb = a;
                fx0 = fx1;
                fx1 = fx;

            }
            
        }while(i <= 10);

    }

    // main
    public static void main(String[] args) {
        int pilihan;
        Scanner input = new Scanner(System.in);
        
        System.out.println("========================================================================");
        System.out.println("|Persamaan Non Linier menggunakan Metode Secant Dengan Modifikasi Tabel|");
        System.out.println("========================================================================");
        System.out.println("\nMenu Pilihan Soal :");
        System.out.println("1. Fungsi f(x) = x*exp(-x)+sin(2*x)");
        System.out.println("2. Fungsi f(x) = cos(x+1)+exp(-x+2)");
        System.out.println("3. Fungsi f(x) = cos(x)-sin(x))");
        System.out.print("Pilih Soal : ");

        pilihan = input.nextInt();

        if(pilihan==1){
            Nomor1();
        }
        else if(pilihan == 2){
            Nomor2();
        }else if(pilihan ==3){
            Nomor3();
        }else{
            System.out.println("Anda salah menginput");
        }

        input.close();
    }

}