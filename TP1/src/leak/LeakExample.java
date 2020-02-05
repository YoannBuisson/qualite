package leak;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yobuisson1
 */
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Vector;

public class LeakExample {

    static Vector myVector = new Vector();
    static HashSet pendingRequests = new HashSet();

    public void slowlyLeakingVector(int iter, int count) {
        for (int i = 0; i < iter; i++) {
            for (int n = 0; n < count; n++) {
                myVector.add(Integer.toString(n + i));
            }
            for (int n = count - 1; n >= 0; n--) {
                myVector.removeElementAt(n);
            }
        }
    }

    public void leakingRequestLog(int iter) {
        pendingRequests.clear();
        Random randomNumber = new Random();
        int newRequest = 0;
        for (int i = 0; i < iter; i++) {
            newRequest = randomNumber.nextInt();
            pendingRequests.add(newRequest);
            // processed request, but forgot to remove it
            // from pending requests
        }
        pendingRequests.clear();
    }

    public void leakingRequestLog2(int size) {
        HashSet tmpStore = new HashSet();
        for (int i = 0; i < size; ++i) {
            String leakingUnit = new String("Object: " + i);
            tmpStore.add(leakingUnit);
        }

    }
}
