/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public double[] get(){
        return vec;
    }
    
    public double x(){
        return vec[0];
    }
    
    public double y(){
        return vec[1];
    }
    public double z(){
        return vec[2];
    }
    
    public double[] up(){
        vec = new double[]{0,1,0};
        return vec;
    }
    public double[] up(double n){
        vec = new double[]{0,1*n,0};
        return vec;
    }
    public double[] right(){
        vec = new double[]{1,0,0};
        return vec;
    }
    public double[] right(double n){
        vec = new double[]{1*n,0,0};
        return vec;
    }
    public double[] forward(double n){
        vec = new double[]{0,0,1*n};
        return vec;
    }
    
    public double[] forward(){
        vec = new double[]{0,0,1};
        return vec;
    }
    
    public void set(double x, double y, double z) {
        vec = new double[] {x,y,z};
    }
}