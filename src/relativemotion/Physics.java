/*
    Matt, Aisik, Michelle, Liam
    2019-06-11
    This is the template for the physics object (engine)
 */
package relativemotion;

/**
 *
 * @author lidea9928, malud0519
 */
public class Physics {
    double [] spacialPositions = new double [3]; 
    
    Vector [] forces = new Vector[9];
    Vector velocity = new Vector();
    private double mass; 
    
    Physics(double x, double y, double z, double spdx, double spdy, double spdz, double ms) { // default

        spacialPositions[0] = x;   // x dimension
        spacialPositions[1] = y;   // y dimension
        spacialPositions[2] = z;   // z dimension
        mass = ms;
        velocity.set(spdx, spdy, spdz); 
    }
    
    /**
     * 
     * @param ms 
     * sets the value of the object's mass (kilograms)
     */
    public void setMass(double ms) { 
        mass = ms;
    }
    
    /**
     * 
     * @return mass
     */
    public double getMass() {
        return mass;
    }
    
    // position getters
    
    /**
     * 
     * @return spacialPositions[0]
     * x-coordinate of rocket's position
     */
    public double getX() {
        return spacialPositions[0];
    }
    /**
     * 
     * @return spacialPositions[1]
     * y-coordinate of rocket's position
     */
    public double getY() {
        return spacialPositions[1];
    }
    /**
     * 
     * @return spacialPositions[2]
     * z-coordinate of rocket's position
     */
    public double getZ() {
        return spacialPositions[2];
    }
    
    
    /**
     * changes the velocity
     */
    public void go(){
        spacialPositions[0] += velocity.x();  // adds the velocity to the position
        spacialPositions[1] += velocity.y();
        spacialPositions[2] += velocity.z();
        useTheForce();  
       
    }
    /**
     * adds new forces to the forces list
     * @param vec 
     */
    public void addForce(Vector vec){  // adding any/all forces
        for (int i =1; i<forces.length; i++){
            if(forces[i]== null){
                forces[i] = vec;
            }
        }
    }
    /**
     * Applies forces to change the velocity
     */
    public void useTheForce(){  // each measure of velocity will be changed based on the acceleration
        for (int i = 0; i < forces.length; i++) { // no enhanced loop, java
            if(forces[i] != null) {
                velocity = new Vector(velocity.x()+ forces[i].x() / mass, 
                        velocity.y() + forces[i].y()/ mass,
                        velocity.z() + forces[i].z()/ mass);  // beautiful equation
            }
        }
    }
  
}