public class DoubleVector {
    private double[] vector = null;

    public DoubleVector(double[] vector){
        this.vector = vector;
    }

    // Скалярний добуток векторів
    public double mult(DoubleVector anotherVector){
        return mult(this, anotherVector);
    }

    public static double mult(DoubleVector a, DoubleVector b){
        double s = 0;

        for ( int i = 0; i < a.vector.length; i++ ){
            s += a.vector[i] * b.vector[i];
        }

        return s;
    }

    // Додавання векторів
    public void add(DoubleVector anotherVector){
        add(this, anotherVector);
    }

    public static void add(DoubleVector a, DoubleVector b){
        if(a.vector.length != b.vector.length){
            return;
        }

        double[] resVector = new double[a.vector.length];

        for (int i = 0; i < resVector.length; ++i){
            resVector[i] = a.vector[i] + b.vector[i];
        }

        outputArrayItems(resVector);

        System.out.println();
    }

    // Віднімання векторів
    public void sub(DoubleVector anotherVector){
        sub(this, anotherVector);
    }

    public static void sub(DoubleVector a, DoubleVector b){
        if(a.vector.length != b.vector.length){
            return;
        }

        double[] resVector = new double[a.vector.length];

        for (int i = 0; i < resVector.length; ++i){
            resVector[i] = a.vector[i] - b.vector[i];
        }

        outputArrayItems(resVector);

        System.out.println();
    }

    // Виведення елементів масиву
    public static void outputArrayItems(double[] arr){
        for (int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }

    // Множення вектора на число
    public static void mulByNumber(DoubleVector a, double number){
        if(a.vector.length <= 0){
            return;
        }

        double[] resVector = new double[a.vector.length];

        for (int i = 0; i < resVector.length; ++i){
            resVector[i] = a.vector[i] * number;
        }

        outputArrayItems(resVector);

        System.out.println();
    }
    
    public static void main(String[] args){
        double[] a = {1, 2, 3, 4};
        double[] b = {1, 1, 1, 1};
        double[] c = {2, 2, 2, 2};

        DoubleVector v1 = new DoubleVector(a);
        DoubleVector v2 = new DoubleVector(b);
        DoubleVector v3 = new DoubleVector(c);

        System.out.println("v1*v2=" + v1.mult(v2));
        System.out.println("v1*v2=" + DoubleVector.mult(v1, v2));
        System.out.println("v1*v3=" + v1.mult(v3));

        System.out.println("Додавання векторів");

        v1.add(v2);
        DoubleVector.add(v1, v2);
        v1.add(v3);

        System.out.println("Віднімання векторів");

        v1.sub(v2);
        DoubleVector.sub(v1, v2);
        v1.sub(v3);

        System.out.println("Множення вектора на число 10");

        DoubleVector.mulByNumber(v1, 10);
        DoubleVector.mulByNumber(v2, 10);
        DoubleVector.mulByNumber(v3, 10);
    }
}
