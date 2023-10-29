package mypack;

import java.io.IOException;
import java.util.stream.IntStream;

public class Jack extends Player
{
    public Jack(int money)
    {
        super(money);
        name = "Jack";
    }
    public void addBet(Mascot mascot)
    {
        int i = IntStream.range(0, mascotList.size())
                           .filter(index -> mascot.isEqual(mascotList.get(index)))
                           .findFirst()
                           .orElse(-1);
        if(i != -1)
        {
            mascotList.get(i).setStake(mascot.getStake() + mascotList.get(i).getStake());
        }
        else
        {
            mascotList.add(mascot);
        }
    }
    @Override
    public void bet() 
    {
        System.out.println("Số tiền hiện có: $" + getMoney());
        System.out.println("Mời đặt cược (<linh vật> <tiền cược>)(e: để dừng đặt cược):");
        while(true)
        {
            System.out.printf("(Bạn đang có %d) ", getMoney());
            String input = Constant.Instance().scanner.nextLine();
            String[] inputArr = input.split(" ");
            try 
            {
                if(input.contains("e"))
                {
                    if(mascotList.size() <= 0)
                    {
                        throw new IOException("sorry IO error"); 
                    }
                    break;
                }
                int mascot = Integer.parseInt(inputArr[0]);
                int stake = Integer.parseInt(inputArr[1]);
                Mascot bet = new Mascot(mascot);
                if(!isValidStake(stake))
                {
                    throw new IOException("sorry IO error"); 
                }
                bet.setStake(stake);
                setMoney(getMoney() - stake);
                addBet(bet);
            }
            catch (Exception e)
            {
                System.out.println("Không hợp lệ!!!");
            }
        }
    }
}
