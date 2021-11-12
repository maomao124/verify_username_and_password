import java.awt.*;
import java.util.Scanner;

/**
 * Project name(项目名称)：验证用户名和密码
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/12
 * Time(创建时间)： 20:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    public boolean validateLogin(String username, String password)
    {
        boolean userAndPass = false;    //用户名和密码是否正确
        boolean userFormat = false;    // 用户名格式是否正确
        try
        {
            if (username.length() >= 6 && username.length() <= 10)
            {
                for (int i = 0; i < username.length(); i++)
                {
                    char ch = username.charAt(i);
                    if (ch >= '0' && ch <= '9') //数字
                    {
                        userFormat = true;
                    }
                    else
                    {
                        // 不是0~9的数字，拋出异常
                        userFormat = false;
                        throw new LoginException("用户名中包含有非数字的字符！");
                    }
                }
            }
            else
            {
                //长度不是6-10位，拋出异常
                throw new LoginException("用户名长度必须为6到10位！");
            }
            if (userFormat)
            {
                if (password.length() == 6)
                {
                    // 密码长度等于6
                    userAndPass = true;
                }
                else
                {    //密码长度不等于6，拋出异常
                    userAndPass = false;
                    throw new LoginException("密码长度必须为6位！");
                }
            }
        }
        catch (LoginException e)
        {
            // 捕获 LoginException 异常
            System.out.println(e.getMessage());
        }
        return userAndPass;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        test t = new test();
        boolean result = t.validateLogin(username, password);
        if (result)
        {
            System.out.println("登录成功！");
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("登录失败！");
        }
    }
}
