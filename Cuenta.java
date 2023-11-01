public abstract class Cuenta
{
    private int saldo;
    private Cliente dniDueño;
    
    public Cuenta(int saldo, Cliente dniDueño)
    {
        this.saldo = saldo;
        this.dniDueño = dniDueño;
    }

    public int getSaldo()
    {
        return saldo;
    }
    
    public void setSaldo(int nuevoSaldo)
    {
        saldo = nuevoSaldo;
    }
    
    public int getDniDueño()
    {
        return dniDueño.getDni();
    }
    
    public void setDni(int nuevoDni)
    {
        dniDueño.setDni(nuevoDni);
    }
    
    public String enviarDinero(int cantidad, int cbu, Contacto contacto)
    {
        if ((saldo >= cantidad) && (cbu == contacto.getCbu()))
        {
            saldo -= cantidad;
            return ("Transferencia exitosa");
        }
        else
        {
            return("Saldo insuficiente o cbu incorrecto.");
        }
    }
    
    public String enviarDinero(int cantidad, String alias, Contacto contacto)
    {
        if ((saldo >= cantidad) && (alias.equals(contacto.getAlias())))
        {
            saldo -= cantidad;
            return ("Transferencia exitosa");
        }
        else
        {
            return("Saldo insuficiente o alias incorrecto.");
        }
    }
    
}
