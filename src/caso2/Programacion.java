
package caso2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Programacion {


    public static void main(String[] args) {
        int cadamil = 4;

        ScheduledExecutorService executor = (ScheduledExecutorService) Executors.newScheduledThreadPool(cadamil);
        
        for (int i = 0; i < cadamil; i++) {
            int inicio = (i - 1) * 1000 + 1;
            int fin = 1000*i;

            Runnable hiloPrimos = (Runnable) new caso2.Primos(inicio, fin);
            new Thread(hiloPrimos).start();
            
            Primos primos = new Primos(inicio, fin);
                   executor.scheduleWithFixedDelay(primos, 1, 1, TimeUnit.SECONDS);
        }
    }
    
}
