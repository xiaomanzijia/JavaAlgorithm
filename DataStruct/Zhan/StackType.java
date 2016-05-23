package datastruct.ErChaShu.Zhan;

/**
 * Created by Administrator on 2015/3/30.
 */
public class StackType {
    static final int MAXLEN=50;
    DATA3[] data = new DATA3[MAXLEN+1];
    int top;

    //栈初始化
    StackType STInit(){
        StackType p;
        if((p=new StackType())!=null){
            p.top=0;
            return p;
        }
        return null;
    }

    //判断栈是否为空
    boolean STIsEmpty(StackType s){
        boolean t;
        t=(s.top==0);
        return t;
    }

    //判断栈是否已满
    boolean STIsFull(StackType s){
        boolean t;
        t=(s.top==MAXLEN);
        return  t;
    }

    //清空栈
    void STClear(StackType s){
        s.top=0;
    }

    //释放栈所占内存空间
    void STFree(StackType s){
     if(s!=null){
         s=null;
     }
    }

    //入栈操作
    int PushST(StackType s,DATA3 data){
        if(s.top+1>MAXLEN){
            System.out.print("栈溢出");
            return 0;
        }
        s.data[++top]=data;
        return 1;
    }

    //出栈操作
    DATA3 PopST(StackType s){
        if(s.top==0){
            System.out.print("栈为空");
            System.exit(0);
        }
        return (s.data[s.top--]);
    }
}
