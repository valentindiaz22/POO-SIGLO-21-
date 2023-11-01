public class Contacto
{
    private int cbu;
    private String alias;
    private String nombre;
    public Contacto(int cbu, String alias, String nombre)
    {
        this.cbu = cbu;
        this.alias = alias;
        this.nombre = nombre;
    }
    
    public int getCbu()
    {
        return cbu;
    }
    
    public void setCbu(int nuevoCbu)
    {
        cbu = nuevoCbu;
    }
    
    public String getAlias()
    {
        return alias;
    }

    public void setAlias (String nuevoAlias)
    {
        alias = nuevoAlias;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nuevoNombre)
    {
        nombre = nuevoNombre;
    }
    
    @Override
    public String toString()
    {
        return "Cbu: " + this.cbu + ", Alias: " + this.alias + ", Nombre: " + this.nombre + "";
    }

}
