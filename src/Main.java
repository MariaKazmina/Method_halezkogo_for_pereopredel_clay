public class Main {

    public static void main(String[] args) {

        Matrix matrix = new Matrix(2, 3);
        matrix.generateSpecial();
        Vec f = new Vec(matrix.getN());
        f.generateSpecial();
        System.out.println("f: ");
        f.print();
        System.out.println();
        Vec b = new Vec(matrix.getN()); //вектор весовых коэффициентов
        b.generateInit();


        Method method = new Method(matrix, b, f);
        method.rebuildSystem();


    }
}
