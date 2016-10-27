/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion;

import java.util.concurrent.Callable;

/**
 *Aqui basicamente se reciben tanto el dividendo como el divisor y se dictamina
 * si se pueden dividir, en caso que se pueda devuelve que nuemro se puede
 * dividir, en caso contrario se devuelve un -1
 * @author ALUMNEDAM
 */
public class Divisio implements Callable<Integer> {

    int num, divisor;
    int mal = -1;

    public Divisio(int num, int divisor) throws InterruptedException {
        this.num = num;
        this.divisor = divisor;
    }


    @Override
    public Integer call() {
        
        if(num % divisor == 0){
         return num;   
        }else{
         return mal;
        }
    }

}
