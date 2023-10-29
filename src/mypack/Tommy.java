package mypack;

import java.util.ArrayList;
import java.util.Arrays;

import mypack.enumType.MascotType;

public class Tommy extends Player 
{
    public Tommy(int money)
    {
        super(money);
        name = "Tommy";
    }
    public void mascotLogic()
    {
        int number = Constant.Instance().getRandomInt(1, MascotType.NUMBER_OF_MASCOT + 1);
        ArrayList<MascotType> list = new ArrayList<>(Arrays.asList(MascotType.values()));
        while(number > 0)
        {
            int index = Constant.Instance().getRandomInt(0, list.size());
            Mascot mascot = new Mascot(list.remove(index));
            mascotList.add(mascot);
            number--;
        }
    }
    public void stakeLogic()
    {
        mascotList.forEach((mascot) -> {
            int stake = 1;
            int i = 0;
            do 
            {
                stake = Constant.Instance().getRandomInt(1, 100);
                i++;
            } 
            while(!isValidStake(stake) && i < 50);
            setMoney(getMoney() - stake);
            mascot.setStake(stake);
        });
    }
    @Override
    public void bet() 
    {
        mascotLogic();
        stakeLogic();
    }
}
