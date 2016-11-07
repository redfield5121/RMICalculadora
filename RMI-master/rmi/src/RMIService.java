
import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.RemoteException;
import java.security.spec.InvalidKeySpecException;

public class RMIService {

    //Operational Classes
    private static RMIManager _rmiManager;
    private static final int RMIPort = 1234;

    //Constructors
    public RMIService() throws InvalidKeySpecException, IOException, Exception {
        try (ServerSocket serverSocket = new ServerSocket(RMIPort)) {
            System.out.println("puerto disponible...");
            serverSocket.close();
            this._rmiManager = new RMIManager(RMIPort);

        } catch (IOException x) {
            System.out.println("el puerto esta ocupado..." + x);
        }
    }

    public int getSuma(int num1, int num2) throws RemoteException {
        Integer _translationRule = _rmiManager.getSuma(num1, num2);
        return _translationRule;
    }

    public int getResta(int num1, int num2) throws RemoteException {
        Integer _translationRule = _rmiManager.getResta(num1, num2);
        return _translationRule;
    }

    public int getMultiplicacion(int num1, int num2) throws RemoteException {
        Integer _translationRule = _rmiManager.getMultiplicacion(num1, num2);
        return _translationRule;
    }

    public int getDivision(int num1, int num2) throws RemoteException {
        Integer _translationRule = _rmiManager.getDivision(num1, num2);
        return _translationRule;
    }

    public int getFactorial(int num1) throws RemoteException {
        Integer _translationRule = _rmiManager.getFactorial(num1);
        return _translationRule;
    }

    public String getBinario(int num1) throws RemoteException {
        String _translationRule = _rmiManager.getBinario(num1);
        return _translationRule;
    }

    

}
