package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    @Override
    public String sayHello() {
        return "Сервер говорит: Привет!";
    }

    public MyRemoteImpl() throws RemoteException {

    }

    public static void main(String[] args) {

        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("Удалённый привет" , service);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
