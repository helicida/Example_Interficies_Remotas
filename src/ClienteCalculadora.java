import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by sergi on 03/03/16.
 */
public class ClienteCalculadora {

    private static String operacion = "3 + 4";  // Operacion

    public static void main(String[] args) {

        InterficiesRemotas server;  // Interficie

        // Menú
        Scanner teclat = new Scanner(System.in);

        System.out.println("Introduce la operación que quieres realizar (SOLO DOS MIEMBROS)");
            operacion = teclat.nextLine();

        if(operacion.contains("+")){
            try {
                // Apuntamos a la ip y puerto y buscamos la palabra clave "interfaces"
                Registry registro = LocateRegistry.getRegistry("localhost", 5555);
                server = (InterficiesRemotas) registro.lookup("interfaces");

                System.out.println("\nEl resultado de '" + operacion + "' es: " + server.sumar(operacion));
            }
            catch ( RemoteException | NotBoundException exception) {
                exception.printStackTrace();
            }
        }
        else if(operacion.contains("-")){
            // Resta
            try {
                // Apuntamos a la ip y puerto y buscamos la palabra clave "interfaces"
                Registry registro = LocateRegistry.getRegistry("localhost", 5555);
                server = (InterficiesRemotas) registro.lookup("interfaces");

                System.out.println("\nEl resultado de '" + operacion + "' es: " + server.restar(operacion));

            }
            catch (RemoteException | NotBoundException exception) {
                exception.printStackTrace();
            }
        }
        else if (operacion.contains("*")){
            // Multiplicar
            try {
                // Apuntamos a la ip y puerto y buscamos la palabra clave "interfaces"
                Registry registro = LocateRegistry.getRegistry("localhost", 5555);
                server = (InterficiesRemotas) registro.lookup("interfaces");

                System.out.println("\nEl resultado de '" + operacion + "' es: " + server.multiplicar(operacion));

            }
            catch (RemoteException | NotBoundException exception) {
                exception.printStackTrace();
            }
        }
        else if (operacion.contains("/")) {
            // Dividir
            try {
                // Apuntamos a la ip y puerto y buscamos la palabra clave "interfaces"
                Registry registro = LocateRegistry.getRegistry("localhost", 5555);
                server = (InterficiesRemotas) registro.lookup("interfaces");

                System.out.println("\nEl resultado de '" + operacion + "' es: " + server.dividir(operacion));

            }
            catch (RemoteException | NotBoundException exception) {
                exception.printStackTrace();
            }
        }
        else{
            System.out.println("Carácter erroneo");
        }
    }
}