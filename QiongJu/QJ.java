package datastruct.ErChaShu.QiongJu;

/**
 * Created by Administrator on 2015/4/4.
 */
public class QJ {
    static int checken,rabbits,j;
    public void Total(int checken,int rabbits){
        for(int i=0;i<checken;i++){
            j=checken-i;
                if((i*2+j*4)==rabbits){
                    checken=i;
                    rabbits=j;
                }

        }
        System.out.printf("鸡有%d只，兔有%d只。\n",checken,rabbits);
    }
}
