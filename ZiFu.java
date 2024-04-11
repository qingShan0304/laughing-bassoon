package q2;

public class ZiFu
{

    static String strs[][] = new String[3][];

    // 静态代码块，用于初始化二维数组
    static {
        // 数字字符种类
        strs[0] = new String[]{"1", "2", "3", "4", "5", "6", "7"};
        // 字母字符种类（例如：QWERTASD）
        strs[1] = new String[]{"q", "w", "e", "r", "t", "a", "s", "d"};
        // 符号字符种类
        strs[2] = new String[]{">", "<", "*", "&", "%", "#", "$"};
    }
}
