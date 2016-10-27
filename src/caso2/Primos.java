/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso2;

/**
 *
 * @author ALUMNEDAM
 */
public class Primos implements Runnable{
    int inicio;
    int fin;

    public Primos(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public void run() {
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                System.out.println(i + " es primo.");
            }
        }
    }
    
    public static boolean esPrimo(int num) {
        int contador = 2;
        boolean primo = true;
        if (num % 2 == 0) {
            return false;
        }
        while ((primo) && (contador != num) && (contador > num/2)) {
            if (num % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }
}
