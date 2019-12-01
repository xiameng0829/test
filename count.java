package packaging;

/**
 * @program:class
 * @description
 * @Author:xiameng
 * @create:2019-12-01 18:39
 **/

class Account{
    //被public 修饰的属性或方法，随意访问
    public int id;
    //private修饰的属性或方法表示类的私有域，出了此类其他类根本不知道其存在，也无法访问（保护属性）
    private String password;
    private double sal;

    /*
    //getter方法，取得值
    public String getPassword() {
        return password;
    }
    //setter方法，修改值
    public void setPassword(String password) {
        this.password=password;
    }

    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    */
    public Account(int id,String password,double sal){
        this.id=id;
        this.password=password;
        this.sal=sal;
    }

    @Override
    //将任意类的对象转为字符串
    public String toString() {
        return "Account{"+id+","+password+","+sal+"}";
    }
}
public class count{
    public static void main(String[] args) {
        Account account=new Account(123,"test",0.0);
        new Account(123,"test",0.0); //匿名对象，只能用一次
        /*
        account.id=123;
        account.setPassword("java30");
        account.setSal(100.0);
        System.out.println(account.id);
        System.out.println(account.getPassword());
        System.out.println(account.getSal());
        */
        System.out.println(account);
        System.out.println(new Account(666,"test",0.0)); //匿名对象
    }
}
