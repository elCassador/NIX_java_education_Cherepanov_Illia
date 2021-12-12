
package nix.education.java.banking;


import java.util.Scanner;

public class MainThread extends Thread {

    OperationMenuThread operationMenuThread = new OperationMenuThread();

    @Override
    public void run() {
        Connect db = new Connect();
        db.createCardTable();
        operationMenuThread.run();
    }
}
