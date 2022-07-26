package Clases.OperacionesBanco;
 
public class BancoNoSincronizado {
    public static void main(String[] args) {

        Banco primerBanco = new Banco(100);



    }
}

class Banco {
    int cantidadCuentas;
    CuentaBancaria[] listaCuentas;

    public Banco(int cantidad) {
        cantidadCuentas = cantidad;
        listaCuentas = new CuentaBancaria[cantidadCuentas];
        for (int i = 0; i < listaCuentas.length; i++) {
            listaCuentas[i] = new CuentaBancaria(2_000);
        }
    }

    public String transferirMonto(CuentaBancaria origen, CuentaBancaria destino, double monto) {
        System.out.println(Thread.currentThread());
        double saldoInicialO = origen.saldo;
        double saldoInicialD = destino.saldo;
        if (monto >= 0 && monto <= origen.saldo) {
            origen.saldo = origen.saldo - monto;
            destino.saldo = destino.saldo + monto;

            System.out.printf("La cuenta " + origen.idCuenta + " ha transferido " + monto
                    + " a la cuenta " + destino.idCuenta + ".");
            System.out.println("La cuenta de origen tenia " + saldoInicialO + " y actualmente tiene "
                    + origen.saldo + " de saldo.");
            System.out.println("La cuenta de destino tenia " + saldoInicialD + " y actualmente tiene "
                    + destino.saldo + " de saldo.");
        } else if (monto < 0) {
            return ("La transferencia no puede ser menor a 0.");
        }
            return ("El saldo no es suficiente para la transferencia.");
    }

    public double obtenerTotal() {
        double total = 0;
        for (CuentaBancaria cb: listaCuentas) {
            total += cb.saldo;
        }
        return total;
    }

}

class CuentaBancaria {
    double saldo;
    int idCuenta;
    static int idSiguiente = 1;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
        establecerId();
    }

    private void establecerId() {
        idCuenta = idSiguiente;
        idSiguiente++;
    }
}