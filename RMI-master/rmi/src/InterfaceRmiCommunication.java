import java.rmi.*;

public interface InterfaceRmiCommunication extends Remote 
{
    Integer getSuma(int num1, int num2) throws RemoteException; 
    Integer getResta(int num1,int num2) throws RemoteException;
    Integer getMultiplicacion (int num1,int num2) throws RemoteException;
    Integer getDivision(int num1,int num2)throws RemoteException;
    Integer getFactorial(int num1)throws RemoteException;
    String getBinario(int num1)throws RemoteException;
}
