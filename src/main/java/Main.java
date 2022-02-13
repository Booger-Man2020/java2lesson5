import java.util.Arrays;

public class Main {
    static final int size = 1_000_000;
    static final int size2 = size / 2;


    public static void main(String[] args) {
        setArr();
        // System.out.println();
        treads();


    }

    public static void setArr() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0F);
        //System.out.println(Arrays.toString(arr));
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.print("Время работы первого метода: ");
        System.out.println(System.currentTimeMillis() - a);
        // System.out.println(Arrays.toString(arr));
    }

    public static void treads() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0F);
        float[] arr1 = new float[size2];
        float[] arr2 = new float[size2];
        System.arraycopy(arr, 0, arr1, 0, size2);
        System.arraycopy(arr, size2, arr2, 0, size2);
        long a = System.currentTimeMillis();


        Thread newArray = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < size2; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    //  System.out.println(Arrays.toString(arr1));
                }
            }
        });
        newArray.start();

        Thread MThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < size2; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

                }

            }

        });
        MThread.start();
        try {
            newArray.join();
            MThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arr, 0, size2);
        System.arraycopy(arr2, 0, arr, size2, size2);
        // System.out.println(Arrays.toString(arr));
        System.out.print("Время работы второго метода: ");
        System.out.println(System.currentTimeMillis() - a);
    }
}
