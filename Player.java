package q2;

import java.util.Scanner;

public class Player
{
    //    Player
//-levelNo : int
//-curScore :int
//-startTime : long
//-elapsedTime :int
    private int levelNo, curScore, elapsedTime,choose;
    private long startTime;

    public void play(int choose) throws ExitException1
    {
        this.choose=choose;
        Scanner input = new Scanner(System.in);
        Game game = new Game(this);
        setLevelNo(1);
        setCurScore(0);
        setElapsedTime(0);
        while (levelNo <= LevelParam.levels.length) {
            startLevel();
            completeLevel(game, input);
            levelNo++;
            this.elapsedTime=0;
        }
        System.out.println("恭喜通关");
    }

    private void startLevel()
    {
        startTime = System.currentTimeMillis();
        curScore = 0;
    }

    private void completeLevel(Game game, Scanner input) throws ExitException1
    {
        for (int j = 0; j < LevelParam.levels[levelNo - 1].getStrTimes(); j++) {
            String outStr = game.printStr(choose);
            System.out.println(outStr);

            String inStr = input.next();
            game.printResult(outStr, inStr);

            if (isTimeout(LevelParam.levels[levelNo - 1].getTimeLimit())) {
                System.out.println("你输入太慢了，已经超时，退出！");
                break;
            }
        }
    }

    private boolean isTimeout(int timeLimit)
    {
        long currentTime = System.currentTimeMillis();
        return (currentTime - startTime) / 1000 > timeLimit;
    }

    //初始化玩家参数时,自动将关卡设置为第一关
    public Player()
    {
        this.levelNo = 1;
        this.curScore = 0;
        this.elapsedTime = 0;
        this.startTime = 0;
    }


    public int getLevelNo()
    {
        return levelNo;
    }

    public void setLevelNo(int levelNo)
    {
        this.levelNo = levelNo;
    }

    public int getCurScore()
    {
        return curScore;
    }

    public void setCurScore(int curScore)
    {
        this.curScore = curScore;
    }

    public int getElapsedTime()
    {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime)
    {
        this.elapsedTime = elapsedTime;
    }

    public long getStartTime()
    {
        return startTime;
    }

    public void setStartTime(long startTime)
    {
        this.startTime = startTime;
    }
}
