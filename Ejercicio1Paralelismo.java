public class Ejercicio1Paralelismo {

    static class Sumador extends Thread {
        private int inicio;
        private int fin;
        private long sumaParcial;

        public Sumador(int inicio, int fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        public void run() {
            sumaParcial = 0;
            for (int i = inicio; i <= fin; i++) {
                sumaParcial += i;
            }
            System.out.println(Thread.currentThread().getName()
                    + " sumó desde " + inicio + " hasta " + fin
                    + " = " + sumaParcial);
        }

        public long getSumaParcial() {
            return sumaParcial;
        }
    }

    public static void main(String[] args) {
        Sumador hilo1 = new Sumador(1, 250000);
        Sumador hilo2 = new Sumador(250001, 500000);
        Sumador hilo3 = new Sumador(500001, 750000);
        Sumador hilo4 = new Sumador(750001, 1000000);

        hilo1.setName("Hilo 1");
        hilo2.setName("Hilo 2");
        hilo3.setName("Hilo 3");
        hilo4.setName("Hilo 4");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long sumaTotal = hilo1.getSumaParcial()
                + hilo2.getSumaParcial()
                + hilo3.getSumaParcial()
                + hilo4.getSumaParcial();

        System.out.println("Suma total = " + sumaTotal);
    }
}