KMP算法
public class KMP {
    public int getIndex(String str,String match){
        int[] next=getNext(match);
        int i=0;
        int j=0;
        while(i<str.length()&&j<match.length()){
            if(str.charAt(i)==match.charAt(j)){
                i++;
                j++;
            }else if(next[j]==-1){
                i++;
            }else{
                j=next[j];
            }
        }
        return j==match.length()?i-j:-1;
    }

    private int[] getNext(String match){
        if(match.length()==1) return new int[]{-1};
        int[] next=new int[match.length()];
        next[0]=-1;
        next[1]=0;
        int pos=2;
        int c=0;
        while(pos<match.length()){
            if(match.charAt(pos-1)==match.charAt(c)){
                next[pos++]=++c;
            }else if(c>0){
                c=next[c];
            }else{
                next[pos++]=0;
            }
        }
        return next;
    }
}


public class Random1TO7 {
    //用1-5随机产生1-7
    public int random1T7(){
        int i=0;
        do{
            i=(random1T5()-1)*5+(random1T5()-1);
        }while(i>20);
        return i%7+1;
    }

    private int random1T5(){
        return (int)(Math.random()*5+1);
    }

    //概率产生0 1来实现等概率产生1-6
    public int random1T6(){
        int num=0;
        do{
            num=random0T3()*4+random0T3();
        }while(num>11);
        return num%6+1;
    }
    private int random0T3(){
        return random01()*2+random01();
    }
    public int random01(){
        int num=0;
        do{
            num=random01P();
        }while(num==random01P());
        return num;
    }
    private int random01P(){
        double p=0.89;
        return Math.random()<p?0:1;
    }
}


求最大公约数:辗转相除法
public class Gcd {
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}

public class ZeroNums {
    //n的阶乘中0的个数
    public int zeroNums(int n){
        if(n<5){
            return 0;
        }
        return n/5+zeroNums(n/5);
    }

    //n的阶乘的二进制中最右侧的1的位置
    public int rightOne1(int n){
        int num=0;
        while(n!=0){
            n>>=1;
            num+=n;
        }
        return num;
    }
    
    public int rightOne2(int n){
        int count=0;
        int tmp=n;
        while(tmp!=0){
            tmp&=(tmp-1);
            count++;
        }
        return n-count;
    }

}


public class IsINside {
    //判断一个点是否在矩形内部
    public boolean isInside(double x1,double y1,double x2,double y2,double x3,double y3,
                            double x4,double y4,double x,double y){
        if(y1==y2) return isInside(x1,y1,x4,y4,x,y);
        double c=Math.abs(y4-y3);
        double r=Math.abs(x4-x3);
        double t=Math.sqrt(c*c+r*r);
        double sin=c/t;
        double cos=r/t;
        double x1t=cos*x1+sin*y1;
        double y1t=-sin*x1+cos*y1;
        double x4t=cos*x4+sin*y4;
        double y4t=-sin*x4+cos*y4;
        double xt=cos*x+sin*y;
        double yt=-sin*x+cos*y;
        return isInside(x1t,y1t,x4t,y4t,xt,yt);
    }
    private boolean isInside(double x1,double y1,double x4,double y4,double x,double y){
        if(x<=x1||x>=x4) return false;
        return !(y <= y1) && !(y >= y4);
    }
    

}


折纸问题
public class PrintAllFolds {
    public void printAll(int n){
        print(1,2,true);
    }
    private void print(int i,int n,boolean down){
        if(i>n) return;
        print(i+1,n,true);
        System.out.println(down?"down":"up");
        print(i+1,n,false);
    }
}