
public class Vec {

    private int lenght;
    private double[] vec;

    final int min = 10; // Минимальное число для диапазона
    final int max = 100; // Максимальное число для диапазона
    final int rnd = rnd(min, max);


    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public void setVec(double[] vec) {
        this.vec = vec;
    }

    Vec(int l) {
        lenght = l;
        vec = new double[lenght];
    }

    public void print() {
        for (int i = 0; i < lenght; i++)
            System.out.print(vec[i] + " ");
    }


    public void setLenght(int lenght) {
        this.lenght = lenght;
    }


    public double[] genereate() {

        for (int i = 0; i < lenght; i++)
            vec[i] = rnd;

        return vec;
    }

    public void generateSpecial() {
        vec[0] = 0;
        vec[1] = 0;
        vec[2] = 4;
    }

    public double[] generateInit() {
        for (int i = 0; i < lenght; i++)
            vec[i] = 1;

        return vec;
    }

    public double[] generateNull() {
        for (int i = 0; i < lenght; i++)
            vec[i] = 0;

        return vec;
    }

    public int getLenght() {
        return lenght;
    }

    public double[] getVec() {
        return vec;
    }

    public double[] subtractionVec(Vec k) {
        for(int i=0; i<lenght; i++)
        {
            vec[i] = vec[i]-k.vec[i];
        }
        return vec;

    }

}
