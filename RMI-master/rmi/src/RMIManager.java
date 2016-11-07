
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.spec.InvalidKeySpecException;

public class RMIManager implements InterfaceRmiCommunication {

    //Operational Classes
    private static Registry _registry;
    private static InterfaceRmiCommunication _stub;

    //Constructors
    public RMIManager(int rmiPort) throws IOException, InvalidKeySpecException, Exception {
        _registry = LocateRegistry.createRegistry(rmiPort);
        this._stub = (InterfaceRmiCommunication) UnicastRemoteObject.exportObject(this, 0);

        try {
            System.setProperty("java.security.policy", "java.policy");
            System.setSecurityManager(new RMISecurityManager());
            _registry.bind("rmiServer", _stub);
            System.out.println("Esperando peticiones del cliente...");
        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println("Server exception: " + e.toString());
        }
    }

    @Override
    public Integer getSuma(int num1, int num2) throws RemoteException {
        return num1 + num2;
    }

    @Override
    public Integer getResta(int num1, int num2) throws RemoteException {
        return num1 - num2;
    }

    @Override
    public Integer getMultiplicacion(int num1, int num2) throws RemoteException {
        return num1 * num2;
    }

    @Override
    public Integer getDivision(int num1, int num2) throws RemoteException {
        return num1 / num2;
    }

    @Override
    public Integer getFactorial(int num1) throws RemoteException {
        int resultado = 1;
        for (int i = 1; i <= num1; i++) {
            resultado *= i;
        }
        return resultado;
    }

    @Override
    public String getBinario(int num1) throws RemoteException {
        return Integer.toBinaryString(num1);
    }
}
