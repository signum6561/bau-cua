package mypack;

import java.util.ArrayList;

public abstract class Player 
{
    protected String name;
    protected ArrayList<Mascot> mascotList;
    private int money;
    public Player(int money)
    {
        mascotList = new ArrayList<Mascot>();
        this.money = money;
    }
    //#region getters and setters
    public int getMoney() 
    {
        return money;
    }
    public void setMoney(int money) 
    {
        this.money = money <= 0 ? 0 : money;
    }
    public ArrayList<Mascot> getBets()
    {
        return mascotList;
    }
    //#endregion
    @Override
    public String toString() 
    {
        return String.format("\n<%s> đặt %s", name, mascotList);
    }
    public void printBets()
    {
        mascotList.forEach((mascot) -> System.out.printf("\n<%s> đặt %s", name, mascot.toString()));
    }
    public void clearBets()
    {
        mascotList.clear();
    }
    public void loss(int value)
    {
        System.out.printf("\n<%s> mất -$%d", name, value);
    }
    public void won(int value)
    {
        if(value > 0)
            setMoney(money + value);
        System.out.printf("\n<%s> lời +$%d", name, value);
    }
    protected boolean isValidStake(int value)
    {
        return value <= money && value != 0;
    }
    public abstract void bet();
}
