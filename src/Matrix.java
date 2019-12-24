import java.util.ArrayList;
import java.util.Random;

public class Matrix {

    private int ROW;   //число уравнений  = строки
    private int COLUMN;   //число неизвестных  = столбцы
    private double[][] A;  //матрица с коэффициентами

    final int min = 10; // Минимальное число для диапазона
    final int max = 100; // Максимальное число для диапазона




    public double[][] getA() {
        return A;
    }




    public int getN() {
        return ROW;
    }

    public int getS() {
        return COLUMN;
    }

    public void setA(double[][] a) {
        A = a;
    }

    //Для матриц нужно: нахождение транспонированной, умножение на вектор, умножение на матрицу


    Matrix(int column, int row) {
        ROW = row;
        COLUMN = column;
        A = new double[ROW][COLUMN];
    }


   /* public double[][] nullGenerate() {   //нулевая матрица
        build();
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = 0;
            }
        }
        return A;
    }*/

    public double[][] generateDiagonal(Vec a) {   //диагональная, с элеменатами вектора на диагонали it work


        double[] c = a.getVec();
        int k = 0;
        Matrix m = new Matrix(a.getLenght(), a.getLenght());

        for (int i = 0; i < m.ROW; i++) {
            for (int j = 0; j < m.COLUMN; j++) {
                if (i == j) {
                    m.A[i][j] = c[k];
                    k++;
                }

            }
        }

        ROW = m.ROW;
        COLUMN = m.COLUMN;
        A = m.A;
        return m.A;


    }

    public void setN(int row) {
        this.ROW = row;
    }

    public void setS(int column) {
        this.COLUMN = column;
    }

    private void setA() {
        this.A = new double[ROW][COLUMN];
    }

    public void generateMatrix()  //спросить про рандом
    {

        int k = 1;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                Random random = new Random();
                int num = random.nextInt(100);
                A[i][j] = num;
                k++;
            }
        }

    }

    public void generateSpecial()
    {
        A[0][0] = 1;
        A[1][0] = 0;
        A[2][0] = 1;
        A[0][1] = 0;
        A[1][1] = 1;
        A[2][1] = 2;

    }

    public Matrix transposeMatrix() {    //транспонирование матрицы

        Matrix K = new Matrix(ROW, COLUMN);
        for (int i = 0; i < ROW; i++)  //идем по строке
        {
            for (int j = 0; j < COLUMN; j++) {
                K.A[j][i] = A[i][j];
            }
        }
        //A = K.A;
        return K;

    }

    public double[][] multiplyMatrix(Matrix K) {
        double[][] result = new double[ROW][K.COLUMN];

        if (COLUMN == K.ROW) {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < K.COLUMN; j++) {
                    double step = 0;
                    for (int k = 0; k < K.ROW; k++)
                        step += A[i][k] * K.A[k][j];
                    result[i][j] = step;
                }

            }
        }


        A = result;
        COLUMN = K.COLUMN;
        return result;


    }

    public Vec multiplyOnVec(Vec k) {  //работает( вроде как)
        Vec res = new Vec(ROW);
        double[] r = new double[ROW];
        double[] ke = k.getVec();

        if (COLUMN == k.getLenght()) {

            for (int i = 0; i < ROW; ++i) {
                double step = 0;
                for (int j = 0; j < COLUMN; j++) {
                    step += A[i][j] * ke[j];
                }
                r[i] = step;
            }
        }
        res.setVec(r);

        return res;
    }

    void print()
    {
        for (int i = 0; i<ROW; i++)
        {
            for (int j = 0; j<COLUMN; j++)
                System.out.print(A[i][j]+ " ");
            System.out.println();
        }
        System.out.println();
    }




}



