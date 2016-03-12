import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


/**
 * Created by sergi on 03/03/16.
 */
public class ServidorCalculadora implements InterficiesRemotas {

    private static ServidorCalculadora rmiCalculatorServer = new ServidorCalculadora();

    @Override
    public double sumar(String suma) throws RemoteException {

        // Variables con los numeros de la opreacion
        double a = 0;
        double b = 0;

        // Dividimos en dos nuestro String
        suma = suma.replace(" ", "");

        // Asignamos a cada variable cada factor de la operacion
        a = Double.parseDouble(suma.split("\\+")[0]);
        b = Double.parseDouble(suma.split("\\+")[1]);

        return a+b;
    }

    @Override
    public double restar(String resta) throws RemoteException {

        // Variables con los numeros de la opreacion
        double a = 0;
        double b = 0;

        // Dividimos en dos nuestro String
        resta = resta.replace(" ", "");

        // Asignamos a cada variable cada factor de la operacion
        a = Double.parseDouble(resta.split("-")[0]);
        b = Double.parseDouble(resta.split("-")[1]);

        return a-b;
    }

    @Override
    public double multiplicar(String multiplicacion) throws RemoteException {

        // Variables con los numeros de la opreacion
        double a = 0;
        double b = 0;

        // Dividimos en dos nuestro String
        multiplicacion = multiplicacion.replace(" ", "");

        // Asignamos a cada variable cada factor de la operacion
        a = Double.parseDouble(multiplicacion.split("\\*")[0]);
        b = Double.parseDouble(multiplicacion.split("\\*")[1]);

        return a*b;
    }

    @Override
    public double dividir(String division) throws RemoteException {

        // Variables con los numeros de la opreacion
        double a = 0;
        double b = 0;

        // Dividimos en dos nuestro String
        division = division.replace(" ", "");

        // Asignamos a cada variable cada factor de la operacion
        a = Double.parseDouble(division.split("\\/")[0]);
        b = Double.parseDouble(division.split("\\/")[1]);

        return a/b;
    }

    public static void main(String[] args) {

        Registry reg = null;

        try {
            reg = LocateRegistry.createRegistry(5555);
        }
        catch (Exception two) {
            two.printStackTrace();
        }

        try {
            reg.rebind("interfaz", UnicastRemoteObject.exportObject(rmiCalculatorServer, 0));
            System.out.println("\nEl metodo ha sido subido a Internet para que sea accesible de forma remota.");
        }
        catch (Exception three){
            System.out.println("\nERROR: No se ha podido subir el metodo a Internet.");
            three.printStackTrace();
        }
        System.out.println("El Servidor esta escuchando.\nAhora Ejecuta el Cliente para hacer los calculos.");
    }
}