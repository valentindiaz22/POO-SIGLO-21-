import java.util.Scanner;
import java.util.ArrayList;
public class Banco
{
    public static void main (String args[])
    {
        Scanner reader = new Scanner(System.in);
        int opcion = 0;
        int dni = 0;
        String nombre = "";
        String contraseña = "";
        Menu mn = new Menu();
        ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
        Cliente cliente1 = new Cliente(43680773,"Valentin Diaz","prueba123");
        Cliente cliente2 = new Cliente(20000000,"Ignacio Luis Picotto","poo321");
        Cliente cliente3 = new Cliente();
        arrayCliente.add(cliente1);
        arrayCliente.add(cliente2);
        CuentaPeso cuenta1 = new CuentaPeso(100000,cliente1);
        CuentaPeso cuenta2 = new CuentaPeso(200000,cliente2);
        CuentaPeso cuenta3 = new CuentaPeso(0,cliente3);
        CuentaDolar cuentaDolar1 = new CuentaDolar(200,cliente1);
        CuentaDolar cuentaDolar2 = new CuentaDolar(1500,cliente2);
        CuentaDolar cuentaDolar3 = new CuentaDolar(0,cliente3);
        Contacto contacto1 = new Contacto(870,"alias.prueba","Jorge Perez");
        System.out.println("Bienvenido al sistema de Home Banking del Banco de Entre Rios, por favor ingrese su dni: ");
        dni = reader.nextInt();
        if (dni == arrayCliente.get(0).getDni() || dni == arrayCliente.get(1).getDni())
        {
            if (dni == arrayCliente.get(0).getDni())
            {
                System.out.println("Bienvenido/a " + arrayCliente.get(0).getNombre() + ", Por favor ingrese su contraseña ");  
                contraseña = reader.nextLine();
                if (mn.comprobarContraseña(arrayCliente.get(0).getContraseña(),reader.nextLine()) == true)
                {
                    System.out.println("Inicio de sesión exitoso!");
                    menuOpciones(cuenta1,cuentaDolar1,arrayCliente.get(0),contacto1,mn,reader);
                }
                else
                {
                    System.out.println("Contraseña incorrecta");
                }
            }
            else
            {
                System.out.println("Bienvenido/a " + arrayCliente.get(1).getNombre() + ", Por favor ingrese su contraseña ");  
                contraseña = reader.nextLine();
                contraseña = reader.nextLine();
                if (mn.comprobarContraseña(arrayCliente.get(1).getContraseña(),contraseña) == true)
                {
                    System.out.println("Inicio de sesión exitoso!");
                    menuOpciones(cuenta2,cuentaDolar2,arrayCliente.get(1),contacto1,mn,reader);
                }
                else
                {
                    System.out.println("Contraseña incorrecta");
                }
            }
        }
        else
        {
            cliente3.setDni(dni);
            cuenta3.setDni(dni);
            System.out.println("Su dni no se encuentra en la base de datos, para proceder con la creación de un usuario, ingrese su nombre: ");
            nombre = reader.nextLine(); //Entiendo que ésta linea es incorrecta pero por alguna razón, sin ella, la linea de abajo no lee ningún dato por teclado.
            cliente3.setNombre(reader.nextLine());
            System.out.println("Para finalizar la carga de datos, ingrese su nueva contraseña");
            cliente3.setContraseña(reader.nextLine());
            arrayCliente.add(cliente3);
            System.out.println("Carga realizada con éxito, tus datos son los siguientes: " + arrayCliente.get(2).toString());
            System.out.println("Bienvenido/a " + arrayCliente.get(2).getNombre() + ", Por favor ingrese su contraseña ");  
            contraseña = reader.nextLine();
            if (mn.comprobarContraseña(cliente3.getContraseña(),contraseña) == true)
            {
                System.out.println("Inicio de sesión exitoso!");
                menuOpciones(cuenta3,cuentaDolar3,cliente3,contacto1,mn,reader);
            }
            else
            {
                System.out.println("Contraseña incorrecta");
            }
        }
    }
    
    public static void menuOpciones(CuentaPeso cuenta, CuentaDolar cuentaDolar, Cliente cliente, Contacto contacto, Menu mn, Scanner reader)
    {
        int aux = 0;
        System.out.println("Para continuar, elija una opción:"+"\n"+"1: Conocer tu saldo en pesos"+"\n"+"2: Conocer tu saldo en dolares"+"\n"+"3: Enviar pesos o dolares");
        System.out.println("4: Agregar saldo en pesos"+"\n"+"5: Comprar o vender dolares"+"\n"+"6: Ver tu lista de contactos"+"\n"+"7: Cambiar tu contraseña"+"\n"+"8: Salir");
        aux = reader.nextInt();
        switch (aux)
        {
            case 0:
                menuOpciones(cuenta,cuentaDolar,cliente,contacto,mn,reader);
                break;
            case 1:
                System.out.println("-----------------------------"+"\n");
                System.out.println(mn.opcion1(cuenta));
                System.out.println("-----------------------------");
                menuOpciones(cuenta,cuentaDolar,cliente,contacto,mn,reader);
                break;
            case 2:
                System.out.println("-----------------------------"+"\n");
                System.out.println(mn.opcion2(cuentaDolar));
                System.out.println("-----------------------------");
                menuOpciones(cuenta,cuentaDolar,cliente,contacto,mn,reader);
                break;
            case 3:
                int i = 0;
                int cantidad = 0;
                System.out.println("-----------------------------"+"\n");
                System.out.println("Digite 1 para enviar pesos, digite 2 para enviar dolares:");
                System.out.println("-----------------------------");
                i = reader.nextInt();
                System.out.println("-----------------------------"+"\n");
                System.out.println("Ingrese cuantos pesos o dolares quiere enviar: ");
                System.out.println("-----------------------------");
                cantidad = reader.nextInt();
                if (i == 1 || i == 2)
                {
                    if (i == 1)
                    {
                      int cbu = 0;
                      System.out.println("-----------------------------"+"\n");
                      System.out.println("Tu lista de contactos es la siguiente: "+contacto.toString());
                      System.out.println("-----------------------------");
                      System.out.println("-----------------------------"+"\n");
                      System.out.println("Ingrese el cbu del contacto al que va a enviar los pesos: ");
                      System.out.println("-----------------------------");
                      cbu = reader.nextInt();
                      System.out.println(mn.opcion3(cuenta, cantidad, cbu, contacto));  
                    }
                    else
                    {
                        String alias = "";
                        System.out.println("-----------------------------"+"\n");
                        System.out.println("Tu lista de contactos es la siguiente: "+contacto.toString());
                        System.out.println("-----------------------------");
                        System.out.println("-----------------------------"+"\n");
                        System.out.println("Ingrese el alias del contacto al que va a enviar los dolares: ");
                        alias = reader.nextLine();
                        System.out.println("-----------------------------");
                        alias = reader.nextLine();
                        System.out.println(mn.opcion3b(cuentaDolar, cantidad, alias, contacto));
                    }
                }
                else
                {
                    System.out.println("Número incorrecto");
                    break;
                }
                menuOpciones(cuenta,cuentaDolar,cliente,contacto,mn,reader);
                break;
            case 4:
                int cant = 0;
                System.out.println("-----------------------------"+"\n");
                System.out.println("Ingrese cuantos pesos quiere agregar");
                System.out.println("-----------------------------");
                cant = reader.nextInt();
                mn.opcion4(cuenta,cant);
                System.out.println("$"+cant+" Agregados correctamente a tu cuenta.");
                menuOpciones(cuenta,cuentaDolar,cliente,contacto,mn,reader);
                break;
            case 5:
                int dls = 0;
                int opcion = 0;
                System.out.println("-----------------------------"+"\n");
                System.out.println("Digite 1 para comprar, y 2 para vender dolares");
                System.out.println("-----------------------------");
                opcion = reader.nextInt();
                System.out.println("-----------------------------"+"\n");
                System.out.println("Ingrese cuantos dolares quiere comprar/vender");
                System.out.println("-----------------------------");
                dls = reader.nextInt();
                System.out.println(mn.opcion5(opcion, cuentaDolar, cuenta, dls));
                menuOpciones(cuenta,cuentaDolar,cliente,contacto,mn,reader);
                break;
            case 6:
                System.out.println("-----------------------------"+"\n");
                System.out.println("Tu lista de contactos es la siguiente: " + mn.opcion6(contacto));
                System.out.println("-----------------------------");
                menuOpciones(cuenta,cuentaDolar,cliente,contacto,mn,reader);
                break;
            case 7:
                String contra = "";
                String nuevaContra = "";
                System.out.println("-----------------------------"+"\n");
                System.out.println("Para cambiar su contraseña, por favor introduzca su contraseña actual: ");
                contra = reader.nextLine();
                System.out.println("-----------------------------");
                contra = reader.nextLine();
                System.out.println("-----------------------------"+"\n");
                System.out.println("Ingrese su nueva contraseña");
                System.out.println("-----------------------------");
                nuevaContra = reader.nextLine();
                System.out.println("-----------------------------"+"\n");
                System.out.println(mn.opcion7(cliente,contra,nuevaContra));
                System.out.println("-----------------------------");
                menuOpciones(cuenta,cuentaDolar,cliente,contacto,mn,reader);
                break;
            case 8:
                System.out.println("-----------------------------"+"\n");
                System.out.println("Gracias por utilizar nuestros servicios.");
                System.out.println("-----------------------------");
                break;
        }
    }
}
