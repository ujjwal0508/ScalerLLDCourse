package DesignPattern.Singleton.DoubleCheckedSingleton;

public class DatabaseConnection {

    private static DatabaseConnection instance = null;

    private DatabaseConnection() {
    }

//    public synchronized DatabaseConnection getInstance(){
//        if(instance == null)
//            instance = new DatabaseConnection();
//
//        return instance;
//    }

    public synchronized DatabaseConnection getInstance(){
        if(instance == null) {
            synchronized (DatabaseConnection.class) {
                if(instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }

        return instance;
    }

}
