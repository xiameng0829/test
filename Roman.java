package code;

/**
 * @program:class
 * @description：罗马数字转整数
 *  例如，罗马数字2写做II，即为两个并列的1。12写做XII，即为X +II。27 写做XXVII,即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例,例如4不写做III，而是IV。
 * 数字1在数字5的左边，所表示的数等于大数5减小数1得到的数值4。同样地，数字9表示为IX。
 * 这个特殊的规则只适用于以下六种情况:
 *       I可以放在V (5)和X (10)的左边，来表示4和9。
 *       X可以放在L(50)和C(100)的左边，来表示40和90。
 *       C可以放在D(500)和M(1000)的左边，来表示400和900。
 *       给定一一个罗马数字，将其转换成整数。输入确保在1到3999的范围内。
 * @Author:xiameng
 * @create:2019-12-21 17:39
 **/
public class Roman {
    public static int romanToInt(String s){
        char[] ch = s.toCharArray();
        int result=0;
        for(int i=0;i<ch.length;++i){
            switch(ch[i]){
                case 'M':
                    result+=1000;
                    break;
                case'D':
                    result+=500;
                    break;
                case'L':
                    result+=50;
                    break;
                case'V':
                    result+=5;
                    break;
                case'I':
                    if(i+1<ch.length && (ch[i+1]=='V' || ch[i+1]=='X')){
                        result-=1;
                    }else{
                        result+=1;
                    }
                    break;
                case'X':
                    if(i+1<ch.length && (ch[i+1]=='L' || ch[i+1]=='C')){
                        result-=10;
                    }
                    else{
                        result+=10;
                    }
                    break;
                case'C':
                    if(i+1<ch.length && (ch[i+1]=='D' || ch[i+1]=='M')){
                        result-=100;
                    }else{
                        result+=100;
                    }
                    break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(romanToInt("III"));
    }
}
