import static java.lang.Math.sqrt;

public class Systema {

    private Matrix Ar;  //переработанная матрица А
    private Vec fr;   //переработанный вектор правой части
    private Vec xr;  //решение
    private Vec y;
    private int column;
    private int row;
    private Matrix L; //матрица разложения Аr на нижнетреугольную и верхнетреугольную



    Systema(Matrix A, Vec frr )
    {
        Ar = A;
        fr = frr;
        column = Ar.getS();
        row = Ar.getN();
    }

    public Matrix getAr() {
        return Ar;
    }



    public void setAr(Matrix ar) {
        Ar = ar;
    }

    public void setFr(Vec fr) {
        this.fr = fr;
    }


    public double[] Halezkiy() {

        double c;
        L = new Matrix(column, column);
        double[][] l = new double[row][row];
        double[][] A = Ar.getA();

        for (int j = 0; j < row; ++j) {
            for (int i = j; i < row; ++i) {
                c = A[i][j];
                for (int k = 0; k < j; ++k) {
                    c -= l[i][k] * l[k][j];
                }
                l[i][j] = c;
                c = A[j][i];
                if (i != j) {
                    for (int k = 0; k < j; ++k) {
                        c -= l[j][k] * l[k][i];
                    }

                        l[j][i] = c / l[j][j];


                }


            }
        }
        L.setA(l);
        L.print();
        SolveY();
        double[] X = SolveX();
        return X;



    }

    void SolveY()
    {
        y = new Vec(row);
        y.generateNull();
        double[]Y = y.getVec();
        double[]Fr = fr.getVec();
        double[][]l = L.getA();

        double c;
        for (int i = 0; i < row; ++i)
        {
            c = 0;
            for (int j = 0; j < i; ++j)
            {
                c += Y[j]*l[i][j];
            }
            c = Fr[i] - c;
            Y[i] = c / l[i][i];

        }
        y.setVec(Y);
        y.print();

    }

    double[] SolveX()
    {
        double[]Y = y.getVec();
        double[][]l = L.getA();
        xr = new Vec(row);
        double[] Xr = xr.getVec();
        double c;
        for (int i = row - 1; i >= 0; --i)
        {
            c = 0;
            for (int j = row - 1; j > i; --j)
            {
                c += Xr[j]*l[i][j];
            }
            Xr[i] = Y[i] - c;
        }
        xr.setVec(Xr);
        System.out.println();
        xr.print();
        return xr.getVec();
    }




}



