package q2;

import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);
        Level level = new Level();
        Game game = new Game();
        Player player = new Player();
//      player.play();
        while (true){
            System.out.println("^_^");
            System.out.println("1.数字游戏");
            System.out.println("2.字母游戏");
            System.out.println("3.符号游戏");
            System.out.println("4.历史记录");
            System.out.println("5.退出游戏");
            int choose=input.nextInt();
            switch (choose){
                case 1:
                case 2:
                case 3:
                    try {
                        player.play(choose);
                    }
                    catch (ExitException1 e) {
                        continue;
                    }
                    break;
                case 4:
//                    player.history();
                    break;
                case 5:
                    System.exit(1);
                    break;
            }
        }
    }
}
