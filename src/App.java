import mypack.*;


public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Player jack = new Jack(100);
        Player tommy =  new Tommy(100);
        Bookie.Instance().setMoney(100);
        while (true) 
        {
            System.out.print("\033[H\033[2J");
            Bookie.Instance().StartGame(jack, tommy);
            if(jack.getMoney() <= 0)
            {
                System.out.println("Bạn đã cháy túi!!!");
                break;
            } 
            else if(tommy.getMoney() <= 0)
            {
                System.out.println();
                System.out.println("Tommy đã cháy túi và rời khỏi cuộc chơi!!!");
                break;
            }
            else if(Bookie.Instance().getMoney() <= 0)
            {
                System.out.println("Sập nhà cái!!!");
                break;
            }
            System.out.println("Nhấn q để dừng cuộc chơi hoặc phím khác để tiếp tục...");
            String input = Constant.Instance().scanner.nextLine();
            if(input.contains("q")) 
                break;
        }
        System.out.println("GAME OVER!!!");
        System.out.println("Tiền của bạn: $" + jack.getMoney());
    }
}
