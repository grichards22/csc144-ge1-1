package com.eonsahead.swing;

/**
 * Model a matrix.
 *
 * @author Leon Tabak
 * @version 1 April 2020
 */
public class Matrix {

    private final double[][] elements;

    public Matrix() {
        this.elements = new double[4][4];
        this.identity();
    } // Matrix()

    public double get(int row, int column) {
        return this.elements[row][column];
    } // get( int, int )

    public void set(int row, int column, double value) {
        this.elements[row][column] = value;
    } // set( int, int, double )

    public final void identity() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    this.set(i, j, 1.0);
                } // if
                else {
                    this.set(i, j, 0.0);
                } // else
            } // for
        } // for
    } // identity()

    public void rotationX(double angle) {
        this.identity();
        this.set(1, 1, Math.cos(angle));
        this.set(2, 1, -Math.sin(angle));
        this.set(1, 2, Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    } // rotationX( double )

    public void rotationY(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 2, -Math.sin(angle));
        this.set(2, 0, Math.sin(angle));
        this.set(2, 2, Math.cos(angle));
    } // rotationY( double )

    public void rotationZ(double angle) {
        this.identity();
        this.set(0, 0, Math.cos(angle));
        this.set(0, 1, -Math.sin(angle));
        this.set(1, 0, Math.sin(angle));
        this.set(1, 1, Math.cos(angle));
    } // rotationZ( double )

    public Matrix multiply(Matrix otherMatrix) {
        Matrix product = new Matrix();
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                double sum = 0.0;
                for (int k = 0; k < 4; k++) {
                    sum += this.elements[row][k]
                            * otherMatrix.elements[k][column];
                } // for
                product.set(row, column, sum);
            } // for
        } // for
        return product;
    } // multiply( Matrix )

    private String rowToString(int row) {
        StringBuilder result = new StringBuilder();
        result.append("( ");
        for (int i = 0; i < 3; i++) {
            result.append(this.get(row, i));
            result.append(",");
        } // for
        result.append(this.get(row, 3));
        result.append(" )");
        return result.toString();
    } // rowToString( int )

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < 4; i++) {
            result.append(rowToString(i));
        } //
        result.append(" ]");
        return result.toString();
    } // toString()

    public static void main(String[] args) {
        Matrix identity = new Matrix();
        System.out.println("identity = " + identity);

        Matrix product = identity.multiply(identity);
        System.out.println("product = " + product);

        Matrix ccw = new Matrix();
        ccw.rotationZ(Math.PI / 4);
        System.out.println("counter-clockwise rotation = " + ccw);

        Matrix cw = new Matrix();
        cw.rotationZ(-Math.PI / 4);
        System.out.println("clockwise rotation = " + cw);

        Matrix netRotation = ccw.multiply(cw);
        System.out.println("net rotation = " + netRotation);
    } // main( String [] )

    public void scale(double x, double y, double z) {
        for (int i = 0; i <4; i++){
            this.set(i, 0, this.elements[i][0] * x);
        }
        for (int i = 0; i <4; i++){
            this.set(i, 1, this.elements[i][1] * y);
        }
        for (int i = 0; i <4; i++){
            this.set(i, 2, this.elements[i][2] * z);
        }
    } //scale(double, double, double)

    public void translate(double deltaX, double deltaY, double deltaZ) {
        this.identity();
        this.set(0, 3, deltaX);
        this.set(1, 3, deltaY);
        this.set(2, 3, deltaZ);
    } // translate( double, double, double )

    public Vector multiply(Vector v) {
        double resultX = 0.0;
        double resultY = 0.0;
        double resultZ = 0.0; 
        double resultH = 0.0;
        for (int j = 0; j < 4; j++){
            resultX += this.elements[0][j];
        }
        for (int j = 0; j < 4; j++){
            resultY += this.elements[1][j];
        }
        for (int j = 0; j < 4; j++){
            resultZ += this.elements[2][j];
        }
        for (int j = 0; j < 4; j++){
            resultH += this.elements[3][j]; //Not used?
        }
        return new Vector(resultX, resultY, resultZ);
    } //multiply(Vector)

} // Matrix
