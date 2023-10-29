package mypack;

import java.util.ArrayList;

import mypack.enumType.MascotType;

public class Bookie 
{
    private ArrayList<MascotType> dices;
    private final int NUMBER_OF_DICE = 3;
    private int money;
    public static Bookie instance;
    private Bookie()
    {
        dices = new ArrayList<MascotType>();
    }
    public static Bookie Instance()
    {
        if(instance == null)
        {
            instance = new Bookie();
        }
        return instance;
    }
    public void StartGame(Player... playerList)
    {
        System.out.println("0.[Bầu] 1.[Cua] 2.[Tôm]\n3.[Cá]  4.[Nai] 5.[Gà]");
        for(Player player : playerList)
        {
            player.bet();
            System.out.print(player.toString());   
        }
        Bookie.Instance().putMoneys(playerList);
        Bookie.Instance().RollDices();
        for(Player player : playerList)
        {
            Bookie.Instance().getReward(player);
            System.out.printf("\n<%s> còn $%d\n", player.name, player.getMoney()); 
        }
        System.out.println("Nhà cái còn $" + getMoney());
    }
    public void RollDices()
    {
        dices.clear();
        for(int i = 0; i < NUMBER_OF_DICE; i++)
        {
            dices.add(MascotType.RandomType());
        }
        System.out.println("\nNhà cái tung xúc sắc: " + dices);
    }
    //#region getters and setters
    public ArrayList<MascotType> getDices() {
        return dices;
    }
    public void setDices(ArrayList<MascotType> dices) {
        this.dices = dices;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    //#endregion
    public void putMoneys(Player... playerList)
    {
        for(Player player : playerList) 
        {
            this.money += player
                .getBets()
                .stream()
                .reduce(0, (data, mascot) -> data + mascot.getStake(), Integer::sum);
        }
    }
    public void getReward(Player player)
    {
        if(dices.size() <= 0)
            return;
        ArrayList<Mascot> playerBet = player.getBets();
        playerBet.stream().forEach(mascot -> {
            int numberOfMatch = (int)dices
                .stream()
                .filter(dice -> dice.equals(mascot.getMascot()))
                .count();
            int stake = mascot.getStake(); 
            if(numberOfMatch > 0)
            {
                this.money -= stake * (numberOfMatch + 1);
                player.setMoney(player.getMoney() + stake);
                player.won(stake * numberOfMatch);
            }
            else
            {
                this.money += stake;
                player.loss(stake);
            }
        });
        player.clearBets();
    }
}
