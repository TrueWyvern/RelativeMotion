/* 
Matt, Aisik, Michelle, Liam
    2019-06-11
 * manages vector values
 */

package relativemotion;

/**
 *
 * @author lidea9928, malud0519
 */
public class Vector {   // (uses composition)
    double[] vec;

    Vector(double x,double y,double z){
        vec = new double[]{x,y,z};
    }
    Vector(){
        vec = new double[]{1,0,0};
    }
    
    /**
     * 
     * @return vector
     */
    public double[] get(){
        return vec;
    }
    /**
     * returns x factor of vector
     * @return x
     */
    public double x(){
        return vec[0];
    }
     /**
     * returns y factor of vector
     * @return y
     */
    public double y(){
        return vec[1];
    }
     /**
     * returns z factor of vector
     * @return z
     */
    public double z(){
        return vec[2];
    }
     /**
     * sets vector to up
     */
    public double[] up(){
        vec = new double[]{0,1,0};
        return vec;
    }
     /**
     * up with a scalar
     */
    public double[] up(double n){
        vec = new double[]{0,1*n,0};
        return vec;
    }
    /**
     * sets vector to RIGHT
     */
    public double[] right(){
        vec = new double[]{1,0,0};
        return vec;
    }
    /**
     * right with a scalar
     */
    public double[] right(double n){
        vec = new double[]{1*n,0,0};
        return vec;
    }
    /**
     * sets vector to forward
     */
    public double[] forward(double n){
        vec = new double[]{0,0,1*n};
        return vec;
    }
    /**
     * sets fector to forward
     * @return forward vector
     */
    public double[] forward(){
        vec = new double[]{0,0,1};
        return vec;
    }
    /**
     * sets the vector
     * @param x
     * @param y
     * @param z 
     */
    public void set(double x, double y, double z) {
        vec = new double[] {x,y,z};
    }
}