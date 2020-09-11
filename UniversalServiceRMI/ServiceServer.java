package UniversalServiceRMI;

import java.rmi.*;

/**
 * RMI-интерфейс, описывает два метода,
 * которыми должен обладать удалённый сервис
 */

public interface ServiceServer extends Remote {
    Object[] getServiceList() throws RemoteException;
    Service getService(Object serviceKey) throws RemoteException;
}
