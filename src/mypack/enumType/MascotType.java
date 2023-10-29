package mypack.enumType;

import mypack.Constant;

public enum MascotType
{
    Bầu,
    Cua,
    Tôm,
    Cá,
    Nai,
    Gà;

    public static final int NUMBER_OF_MASCOT = 6;
    private static MascotType[] values = null;
    public static MascotType ConvertInt(int i) 
    {
        if(MascotType.values == null)
        {
            MascotType.values = MascotType.values();
        }
        return MascotType.values[i];
    }
    public static MascotType RandomType() 
    {
        int index = Constant.Instance().getRandomInt(0, NUMBER_OF_MASCOT);
        return ConvertInt(index) ;
    }
}
