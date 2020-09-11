package UniversalServiceRMI;

import UniversalServiceRMI.Services.DiceService;
import UniversalServiceRMI.Services.MiniMusicService;
import UniversalServiceRMI.Services.DayOfTheWeekService;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {

    /**
     * Сервисы хранятся в коллекции. Добавляется сразу 2 объекта -
     * ключ и значеник
     */
    HashMap serviceList;

    public static void main(String[] args) {

        try {
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Remote service is running");
    }

    public ServiceServerImpl() throws RemoteException {
        setUpServices();
    }

    private void setUpServices() {
        serviceList = new HashMap();
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day of the Week Service", new DayOfTheWeekService());
        serviceList.put("Visual Music Service", new MiniMusicService());
    }

    @Override
    public Object[] getServiceList() {
        System.out.println("in remote");

        /**
         * Клиент вызывает этот метод, чтобы получить список серверов
         * и отобразить их в обозревателе.
         */
        return serviceList.keySet().toArray();
    }

    @Override
    public Service getService(Object serviceKey) throws RemoteException {
        Service theService = (Service) serviceList.get(serviceKey);
        return theService;
    }
}
