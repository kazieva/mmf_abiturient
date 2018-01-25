package by.epam.training.kazieva.connect;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

  //  private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final int POOL_SIZE = 32;
    private static ConnectionPool instance;

    private BlockingQueue<WrapperConnection> availableConnections;
    private static final Lock LOCK = new ReentrantLock();

    private ConnectionPool() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            availableConnections = new ArrayBlockingQueue<>(POOL_SIZE);
            for (int i = 0; i < POOL_SIZE; i++) {
                createConnection();
            }
        } catch (ClassNotFoundException e) {
           // LOGGER.fatal(e);
            throw new RuntimeException("couldn't initialize connection pool");
        }
    }

    public static ConnectionPool getInstance() {
        try {
            LOCK.lock();
            if (instance == null) {
                instance = new ConnectionPool();
            }
        } finally {
            LOCK.unlock();
        }

        return instance;
    }

    WrapperConnection createConnection() {
        WrapperConnection connection = null;
        if (availableConnections.size() < POOL_SIZE) {
            connection = new WrapperConnection();
        } else {
         //   LOGGER.info("All availableConnections are busy");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
          //      LOGGER.error(e);
                System.out.println(e);
            }
        }
        availableConnections.add(connection);
        return connection;
    }

    public WrapperConnection getConnection() throws Exception {
        WrapperConnection connection = null;
            if (instance != null) {
                try {
                    connection = availableConnections.take();
                } catch (InterruptedException e) {
                  //  LOGGER.error(e);
                }
            } else {
                throw new Exception("The instance of connection pool is null");
            }
        return connection;
    }

    public void releaseConnection(WrapperConnection connection) {
        try {
            if (connection != null) {
                availableConnections.put(connection);
            }
        } catch (InterruptedException e) {
      //      LOGGER.error(e);
            System.out.println(e);
        }
    }

}
