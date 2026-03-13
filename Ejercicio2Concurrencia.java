class CuentaBancaria {
    private int saldo = 1000;

    public synchronized void retirar(String cliente, int monto) {
        System.out.println(cliente + " intenta retirar " + monto);

        if (saldo >= monto) {
            System.out.println("Retiro aprobado para " + cliente);
            saldo -= monto;
            System.out.println(cliente + " retiró " + monto + ". Saldo restante: " + saldo);
        } else {
            System.out.println("Retiro rechazado para " + cliente + ". Saldo insuficiente: " + saldo);
        }
    }

    public int getSaldo() {
        return saldo;
    }
}

class Cliente extends Thread {
    private CuentaBancaria cuenta;
    private String nombre;
    private int monto;

    public Cliente(CuentaBancaria cuenta, String nombre, int monto) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.monto = monto;
    }

    @Override
    public void run() {
        cuenta.retirar(nombre, monto);
    }
}

public class Ejercicio2Concurrencia {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();

        Cliente cliente1 = new Cliente(cuenta, "Cliente 1", 400);
        Cliente cliente2 = new Cliente(cuenta, "Cliente 2", 400);
        Cliente cliente3 = new Cliente(cuenta, "Cliente 3", 400);

        cliente1.start();
        cliente2.start();
        cliente3.start();

        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + cuenta.getSaldo());
    }
}