public class Cliente
{
    private int dni;
    private String nombre;
    private String contraseña;
    
    public Cliente(int dni, String nombre, String contraseña)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    
    public Cliente()
    {
    }

    public int getDni()
    {
        return dni;
    }
    
    public void setDni(int nuevoDni)
    {
        dni = nuevoDni;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nuevoNombre)
    {
        nombre = nuevoNombre;
    }
    
    public String getContraseña()
    {
        return contraseña;
    }
    
    public void setContraseña(String nuevaContraseña)
    {
        contraseña = nuevaContraseña;
    }
    
    public void cambiarContraseña(String contraseña, String nuevaContraseña)
    {
        if (contraseña == this.contraseña)
        {
            this.contraseña = nuevaContraseña;
        }
    }
    
    @Override
    public String toString()
    {
        return "Dni: " + this.dni + ", Nombre: " + this.nombre + ", Contraseña: " + this.contraseña + "";
    }
}
