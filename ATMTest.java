package code;

import java.util.Scanner;

/**
 * @program:class
 * @description：模拟ATM机（包括存款，取款，查询）
 * @Author:xiameng
 * @create:2019-12-08 21:24
 **/
//Account类封装
class Account{
    private int id;
    private String name;
    private int password;
    private double money;

    public Account(int id,String name,int password,double money) {
        this.id = id;
        this.name=name;
        this.password=password;
        this.money=money;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }

    public double getMoney() {
        return money;
    }

    public void subBlance(double mon){
        //余额减少
        money-=mon;
    }
    public   void addBlance(double mon){
        //余额增加
        money+=mon;
    }
}

class ATM{
    Account act;
    public ATM(){
        act=new Account(1111,"张三",123456,10000);
    }

    //欢迎界面
    protected void Welcome(){
        String str="------------------";
        System.out.println(str);
        System.out.print("1.查询\n"+"2.取款\n"+"3.存款\n"+"4.退出系统\n");
        System.out.println(str);
    }

    //登录
    protected void Load(){
        int id;
        int password;
        int count=0;
        do
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的卡号：");
            id=sc.nextInt();
            System.out.println("请输入您的密码：");
            password=sc.nextInt();
            if(id!=act.getId() || password!=act.getPassword()){
                System.out.println("卡号或密码输入错误！");
                count++;
            }else{
                System();
            }
        } while (count<3);
        System.exit(1);
    }

    //信息查询
    protected void Get(){
        System.out.println("账号："+act.getId()+"\n"+"姓名："+act.getName()+"\n"+"余额："+act.getMoney());
        System();
    }

    //取款
    public void GetBlannce(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("请输入取款金额：");
            int number=sc.nextInt();
            if (number > act.getMoney()) {
                System.out.println("余额不足，请重新输入：");
            } else {
                act.subBlance(number);
                System.out.println("取款成功，您的账户余额为：" + act.getMoney());
                Welcome();
                System();
            }
        }while (true);
    }

    //存款
    public void AddBlance(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("请输入存款金额：");
            int number = sc.nextInt();
            act.addBlance(number);
            System.out.println("存款成功，您的账户余额为：" + act.getMoney());
            Welcome();
            System();
        }while (true);
    }

    //结束系统
    protected void Exit(){
        System.out.println("感谢您使用本系统，再见！");
        System.exit(1);
    }

    //系统提示
    protected void System(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择您的操作：");
        int num = sc.nextInt();
        switch (num){
            case 1:
                Get();
                break;
            case 2:
                GetBlannce();
                break;
            case 3:
                AddBlance();
                break;
            case 4:
                Exit();
                break;
        }
        System.exit(1);
    }
}

public class ATMTest {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.Welcome();
        atm.Load();
    }
}
