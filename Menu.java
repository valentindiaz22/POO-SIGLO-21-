import java.util.ArrayList;

public class Menu
{   
    public boolean comprobarContraseña(String contraseñaCliente, String contraseña)
    {
        System.out.println(contraseña);
        if(contraseñaCliente.equals(contraseña))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String opcion1(Cuenta cuenta)
    {
        return ("Tu saldo en pesos es : $"+cuenta.getSaldo()+"\n");
    }
    
    public String opcion2(CuentaDolar cuenta)
    {
        return ("Tu saldo en dolares es : U$D"+cuenta.getSaldo()+"\n");
    }
    
    public String opcion3(Cuenta cuenta, int cantidad, int cbu, Contacto contacto)
    {
        return (cuenta.enviarDinero(cantidad,cbu,contacto));
    }
    
    public String opcion3b(CuentaDolar cuenta, int cantidad, String alias, Contacto contacto)
    {
        return (cuenta.enviarDinero(cantidad,alias,contacto));
    }
    
    public void opcion4(Cuenta cuenta, int cant)
    {
        cuenta.setSaldo(cuenta.getSaldo() + cant);
    }
    
    public String opcion5(int opcion, CuentaDolar cuentaDolar, Cuenta cuenta, int dls)
    {
        if (opcion == 1 || opcion == 2)
                {
                    if (opcion == 1)
                    {
                       return (cuentaDolar.comprarDolar(cuentaDolar,cuenta, dls));
                    }
                    else
                    {
                       return (cuentaDolar.venderDolar(cuentaDolar,cuenta, dls));
                    }
                }
                else
                {
                    return("Número incorrecto");
                }
    }
    
    public String opcion6(Contacto contacto)
    {
        return contacto.toString();
    }
    
    public String opcion7(Cliente cliente, String contraseña, String nuevaContraseña)
    {
        if (cliente.getContraseña().equals(contraseña))
        {
            cliente.setContraseña(nuevaContraseña);
            return "Cambio de contraseña exitoso!, tus datos son los siguientes: "+"\n"+cliente.toString();
        }
        else
        {
            return "Contraseña incorrecta";
        }
    }
    
}
