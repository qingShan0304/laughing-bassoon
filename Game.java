package q2;

import com.sun.javaws.exceptions.ExitException;

import java.util.Random;

public class Game
{
    Random random = new Random();

    Player player = new Player();

    public Game()
    {
    }

    public Game(Player player)
    {
        this.player = player;
    }


    public String printStr(int choose)
    {
        // 通过循环生成要输出的字符串
        StringBuffer buffer = new StringBuffer();
        int strLength = LevelParam.levels[this.player.getLevelNo() - 1].getStrLength();
        for (int i = 0; i < strLength; i++) {
            int rand = random.nextInt(strLength); // 产生随机数
            // 根据随机数拼接字符串
            buffer.append(ZiFu.strs[choose-1][rand]);
        }//for结束
        return buffer.toString();
    }

    public void printResult(String outStr, String inStr) throws ExitException1
    {
        long currentTime = System.currentTimeMillis();
        player.setElapsedTime(player.getElapsedTime() + (int) ((currentTime - player.getStartTime()) / 1000));
        if (inStr.equals(outStr)) {//输入正确
            if ((currentTime - player.getStartTime()) / 1000  // 如果超时
                    > LevelParam.levels[player.getLevelNo() - 1].getTimeLimit()) {
                throw new ExitException1("你输入太慢了，已经超时，退出！");
            }
            // 计算玩家当前积分
            player.setCurScore(player.getCurScore() + LevelParam.levels[player.getLevelNo() - 1].getPerScore());
            //打印通关信息
            System.out.println("您的级别" + player.getLevelNo() + ",您的积分" + player.getCurScore() + ",已用时间" + player.getElapsedTime() + "秒");
        }else {//输入错误
//            System.out.println("输入错误,退出");
//            System.exit(1);
            throw new ExitException1("输入错误,退出");
        }
    }
}
