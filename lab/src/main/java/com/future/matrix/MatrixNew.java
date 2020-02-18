package com.future.matrix;

import Jama.Matrix;

public class MatrixNew {
    private Matrix matrix;
    public MatrixNew(double[][] x) {
        Matrix m = new Matrix(x);
        this.matrix = m;
    }

    //一维数组转化为二维数组
    public static double[][] TwoArry(double[] onedouble){
        double[][] arr=new double[1][onedouble.length];
        for (int i = 0; i < onedouble.length; i++) {
            arr[0][i]=onedouble[i];
        }
        return arr;
    }

    //行列式
    public double toDet() {
        double detNum = matrix.det();
        detNum = Math.sqrt(detNum);
        return detNum;
    }
    //转置
    public double[][] transport() {
        Matrix m1 = matrix.transpose();
        double[][] array = m1.getArray();
        return array;
    }
    public double[][] minus(double[][] B) {
        Matrix m2 = new Matrix(B);
        Matrix m1 = matrix.minus(m2);
        double[][] array = m1.getArray();
        return array;
    }
    public double[][] time(double[][] B) {
        Matrix m2 = new Matrix(B);
        Matrix m1 = matrix.times(m2);
        double[][] array = m1.getArray();
        return array;
    }
    public double[][] plus(double[][] B) {
        Matrix m1 = new Matrix(B);
        Matrix m2 = matrix.plus(m1);
        double[][] array = m2.getArray();   //
        return array;
    }
    //求逆矩阵
    public double[][] inverse() {
        System.out.println("m2的秩：" + matrix.rank());
        Matrix m1 = matrix.inverse();
        double[][] array = m1.getArray();   //
        return array;
    }
    public double[][] QRinverse() {
        Matrix Q = matrix.qr().getQ();
        Matrix R = matrix.qr().getR();
        Matrix Q_trans = Q.transpose();
        Matrix R_trans = R.transpose();
        Matrix InvR = R_trans.times(R);
        InvR = InvR.inverse().times(R_trans);
        Matrix qrInv = InvR.times(Q_trans);
        double[][] array = qrInv.getArray();   //
        return array;
    }
    public double[][] getS() {
        Matrix m1 = matrix.svd().getS();
        double[][] array = m1.getArray();
        return array;
    }
    public double[][] getU() {
        Matrix m1 = matrix.svd().getU();
        double[][] array = m1.getArray();
        return array;
    }
    public double[][] getV() {
        Matrix m1 = matrix.svd().getV();
        double[][] array = m1.getArray();
        return array;
    }
}
