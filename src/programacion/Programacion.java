package programacion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;


public class Programacion {

    public static void main(String[] args) throws InterruptedException {
        
        /**
        con el thread pool executor hacemos los hilos que queremos para hacer la tare
        en menos tiempo y con mas cpu
        */
         final ThreadPoolExecutor executor;

         executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

         /**
         Hacemos dos listas iniciales y las rellenamos con numeros del 2 al 100
         Cada una de las listas tendrá diferentes objetivos, una se utilizará 
         para sacar los futures de las divisiones entre 2 y la otra entre 3
         
         */
        List<Divisio> llistaInicial_2 = new ArrayList<>();
        List<Divisio> llistaInicial_3 = new ArrayList<>();
        
        for (int i = 2; i < 100; i++) {
            Divisio divisions_2 = new Divisio(i, 2);
           llistaInicial_2.add(divisions_2);
           Divisio divisions_3 = new Divisio(i, 3);
           llistaInicial_3.add(divisions_3);
        }
        
        List<Future<Integer>> llistaFinal_2 = new ArrayList<>();
        List<Future<Integer>> llistaFinal_3 = new ArrayList<>();
        
        for (int i = 0; i < 98; i++) {
            
            Future <Integer>  future_2 = executor.submit(llistaInicial_2.get(i));
            Future <Integer> future_3 = executor.submit(llistaInicial_3.get(i));
            llistaFinal_2.add(future_2);
            llistaFinal_3.add(future_3);
        }
        
                executor.shutdown();
        
        for (Future<Integer> future : llistaFinal_2) {
            for (Future<Integer> future1 : llistaFinal_3) {
               try {
                 if(future.get() == future1.get() && future.get() != -1){
                     System.out.println(future.get());
                 }
             } catch (ExecutionException ex) {
             } 
            }
       
        }




    }    

}
