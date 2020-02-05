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
public class Finalizer {

    @Override
    protected void finalize() throws Throwable {
        throw new Exception("x");
    }
}
