/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leak;

/**
 *
 * @author yobuisson1
 */
public class Main extends Finalizer {

    public static void main(String[] args) throws Throwable {
        while (true) {

            for (int i = 0; i < 100000; i++) {
                Thread.sleep(100);
                (new Finalizer()).finalize();
            }

            System.out.println("" + Runtime.getRuntime().freeMemory() + " bytes free!");
        }
    }
}
