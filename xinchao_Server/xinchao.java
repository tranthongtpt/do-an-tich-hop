package xinchao_Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface xinchao extends Remote{
    public String Hello(String yourname)throws RemoteException
    
    
}
