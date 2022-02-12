import java.util.Arrays;

public class Main {
    static final int size= 1000000;
    static final int size2=size/2;


    public static void main(String[] args) {
        setArr();
        Thread threadSetNewArray =new Thread();

    }


    public static void setArr(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0F);
        //System.out.println(Arrays.toString(arr));
        long a = System.currentTimeMillis();
        for (int i=0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
        System.out.println(Arrays.toString(arr));
    }

    public static class ThreadSetNewArray () extends Thread {
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0F);
        float [] arr1=new float[size2];
        System.arraycopy(arr, 0, arr1, 0,size2);
        System.out.println(Arrays.toString( arr));

    }
}
