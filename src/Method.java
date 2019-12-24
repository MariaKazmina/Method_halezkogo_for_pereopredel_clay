public class Method {
    private Matrix A;  //исходная матрица
    private Vec b;     //вектор весовых коэффициентов
    private Vec f;     //вектор правой части
    private Vec x;     //вектор решения
    private Vec r;    //вектор-невязки
    //  private double p;
    private int ROW;   //строки
    private int COLUMN;  //столбцы
    private Matrix Ar;   //преобразованная правая часть
    private Vec fr;  //преобразованный вектор правой части


    Method(Matrix a, Vec B, Vec F) {
        A = a;
        ROW = a.getN();
        COLUMN = a.getS();
        b = B;
        f = F;
    }


    public void rebuildSystem() {
        A.print();
        Ar = A.transposeMatrix();
        Ar.print();
        Matrix B = new Matrix(ROW, COLUMN);
        B.generateDiagonal(b);
        B.print();
        Ar.multiplyMatrix(B);
        Ar.print();
        Ar.multiplyMatrix(A);
        Ar.print();

        Matrix Ar1 = A.transposeMatrix();
        Ar1.multiplyMatrix(B);
        fr = Ar1.multiplyOnVec(f);
        System.out.println("F: ");
        fr.print();
        System.out.println();
        System.out.println();
        Systema sys = new Systema(Ar, fr);

        double[] e = sys.Halezkiy();
        x.setVec(e);
        double[] w = vecNevjazki();
        r.setVec(w);
        System.out.println("Вектор-невязки: ");
        r.print();


    }

    public double[] vecNevjazki() {

        Vec r = new Vec(A.getN());  //вектор-невязки
        Vec a = A.multiplyOnVec(x);
        double[] u = f.subtractionVec(a);
        r.setVec(u);
        r.print();

        return r.getVec();


    }


}
