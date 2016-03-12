import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by sergi on 03/03/16.
 */
public interface InterficiesRemotas extends Remote {
    // Métodos para realizar las operaciones
    double sumar(String suma) throws RemoteException;
    double restar(String resta) throws RemoteException;
    double multiplicar(String multiplicacion) throws RemoteException;
    double dividir(String division) throws RemoteException;
}