package com.eonsahead.swing;

public class Vector {

    private double[] elements = new double[4];

    public Vector() {
        this.elements[0] = 0.0;
        this.elements[1] = 0.0;
        this.elements[2] = 0.0;
        this.elements[3] = 0.0;
    } // Vector( double, double )

    public Vector(double x, double y, double z) {
        this.elements[0] = x;
        this.elements[1] = y;
        this.elements[2] = z;
        this.elements[3] = 1.0;
    } // Vector( double, double, double, double)
    
    public double dot(Vector v) {
        double xProduct = this.get(0) * v.get(0);
        double yProduct = this.get(1) * v.get(1);
        return xProduct + yProduct;
    } //dot (Vector)
    
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } //magnitude

    public double get(int choice) {
        switch (choice) {
            case 0:
                return this.elements[0];
            case 1:
                return this.elements[1];
            case 2:
                return this.elements[2];
            case 3:
                return this.elements[3];
            default:
                System.out.println("Error. Invalid parameter value.");
                return -1;
        }//switch (choice)
    } //get (int)
        
    public Vector normalize(){
        double length = this.magnitude();
        double xCoord = this.get(0)/length;
        double yCoord = this.get(1)/length;
        return new Vector(xCoord, yCoord, this.get(2));
    }
    
    public Vector cross (Vector v){
        double xProduct = (this.get(1)*v.get(2)) - (this.get(2)*v.get(1));
        double yProduct = (this.get(2)*v.get(0)) - (this.get(0)*v.get(2));
        double zProduct = (this.get(0)*v.get(1)) - (this.get(1)*v.get(0));
        return new Vector(xProduct, yProduct, zProduct);
    } //cross (Vector)

} // Vector
