package mypack;

import mypack.enumType.MascotType;

public class Mascot
{
    private MascotType mascot;
    private int stake;
    
    public Mascot(boolean random) 
    {
        if(random)
        {
            int rand = Constant.Instance().getRandomInt(0, MascotType.NUMBER_OF_MASCOT);
            this.mascot = MascotType.ConvertInt(rand);
        }
    }
    public Mascot(int index)
    {
        this.mascot = MascotType.ConvertInt(index);
    }
    public Mascot(MascotType mascot) 
    {
        this.mascot = mascot;
    }
    //#region getters and setters
    public MascotType getMascot() 
    {
        return mascot;
    }
    public void setMascot(MascotType mascot) 
    {
        this.mascot = mascot;
    }
    public int getStake()
    {
        return stake;
    }
    public void setStake(int stake)
    {
        this.stake = stake > 0 ? stake : 0;
    }
    //#endregion
    public boolean isEqual(Mascot mascot)
    {
        return getMascot() == mascot.getMascot();
    }
    @Override
    public String toString() {
        return String.format("%s $%d", mascot.name(), stake);
    }
    
}
