package mypack;

import java.util.Random;
import java.util.Scanner;

public final class Constant
{
    public Scanner scanner;
    public Random random;
    public static Constant instance;
    private Constant()
    {
        scanner = new Scanner(System.in);
        random = new Random();
    }
    public static Constant Instance()
    {
        if(instance == null)
        {
            instance = new Constant();
        }
        return instance;
    }
    public int getRandomInt(int min, int max)
    {
        return instance.random.nextInt(max - min) + min;
    }
    public float getRandomFloat(float min, float max)
    {
        return instance.random.nextFloat(max - min) + min;
    }
}
