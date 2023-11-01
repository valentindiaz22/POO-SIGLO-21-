import java.util.Scanner;
public class CuentaDolar extends Cuenta
{
    private int saldo;
    private Cliente dniDueño;

    public CuentaDolar(int saldo, Cliente dniDueño)
    {
        super(saldo,dniDueño);
    }

    public String comprarDolar(CuentaDolar cuentaDolar, Cuenta cuenta, int aux)
    {
        if (cuenta.getSaldo() >= aux*1100)
        {
            cuentaDolar.setSaldo(cuentaDolar.getSaldo() + (aux));
            cuenta.setSaldo(cuenta.getSaldo() - (aux*1100));
            return ("Compra exitosa. Su saldo en dolares es: " + cuentaDolar.getSaldo() + "\n" + "Su saldo en pesos es: " + cuenta.getSaldo());

        }
        else
        {
            return "Saldo insuficiente";
        }
    }
    
    public String venderDolar(CuentaDolar cuentaDolar, Cuenta cuenta, int aux)
    {
        if (cuentaDolar.getSaldo() >= aux)
        {
            cuentaDolar.setSaldo(cuentaDolar.getSaldo()-aux);
            cuenta.setSaldo(cuenta.getSaldo() + (aux*1100));
            return ("Venta exitosa. Su saldo en dolares es : " + cuentaDolar.getSaldo() + "\n" + "Su saldo en pesos es: " + cuenta.getSaldo());
        }
        else
        {
            return "Saldo insuficiente";
        }
    }
}
