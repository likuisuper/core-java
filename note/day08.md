



# 对象关系

简介:对象与对象之间的关系.1:1,1:N,N:N,自关联.

关系具有方向性:

* 单向关联 - **为了减少开发的成本**,优先使用单向关联.
* 双向关联

## One To One

* **单向关联**

  一个A类中维护了另外一个B类的对象,但是另外一个B类中并没维护A类的对象

  并且1:1的俩个对象之间的关系是平等的.

  ~~~java
  public class Husband{
    private int id;
    
    private String name;
    
    //一个丈夫对象对应一个妻子对象
    //一个丈夫对象应该需要维护单个妻子对象
    private Wife wife;
  }
  
  public class Wife{
    private int id;
    
    private String name;
  }
  ~~~

  或者

  ~~~java
  public class Husband{
    private int id;
    
    private String name;
   
  }
  
  public class Wife{
    private int id;
    
    private String name;
    
    //一个妻子中维护了一个丈夫对象
    private Husband husband;
  }
  ~~~

* **双向关联**

  彼此俩个类互相关联.

  ***推荐toString只要打印基本的属性即可,关联的对象无需打印,需要用到的使用调用getter方法,防止出现***
  ***堆栈溢出异常.***

  ~~~java
  public class Husband{
    private int id;
    
    private String name;
    
    //丈夫也维护了妻子
    private Wife wife;
   
  }
  
  public class Wife{
    private int id;
    
    private String name;
    
    //一个妻子中维护了一个丈夫对象
    private Husband husband;
  }
  ~~~

  

## One To Many

简介:一对多

* 单向关联

  ~~~java
  public class Customer{
    private int id;
    
    private String cname;
    
    //一个客户维护多个订单
    private Order[] orders;
  }
  
  public class Order{
    private int id;
    
    private String orderNo;
    
    private double price;
    
  }
  ~~~

  或者

  ~~~java
  public class Customer{
    private int id;
    
    private String cname;
   
  }
  
  public class Order{
    private int id;
    
    private String orderNo;
    
    private double price;
    
    //一个订单对应一个客户.
    private Customer customers;
    
  }
  ~~~

* 双向关联

  ~~~java
  public class Customer{
    private int id;
    
    private String cname;
    
    //一个客户维护多个订单
    private Order[] orders;
  }
  
  public class Order{
    private int id;
    
    private String orderNo;
    
    private double price;
    
    //一个订单对应一个客户.
    private Customer customers;
  }
  ~~~

* Many To Many

  student

  | sid  | sname |      |
  | ---- | ----- | ---- |
  | 1    | tom   |      |
  | 2    | jack  |      |

  course

  | id   | cname  |      |
  | ---- | ------ | ---- |
  | 1    | java   |      |
  | 2    | python |      |

  sc

  | sid  | cid  |
  | ---- | ---- |
  | 1    | 1    |
  | 1    | 2    |
  | 2    | 2    |



# 业务类和实体类

作业中的**Employee类** - 定位的角色 - 实体类(**描述对象**的,现阶段实体类中应该就只包含属性,构造,getter.setter,toString),但是实体类中出现了addEmp等方法,而这些方法都是属于**业务方法**.

应该要遵守软件开发的设计原则(SRP - 单一职责原则 - 不要让一个类的"压力"太多 - 类的任务比较"多")



## 业务类和实体类合二为一

简介:实体类包含了业务方法.

~~~java
package tech.aistar.day08.relation;

/**
 * 本类用来演示:银行账户实体类
 *
 * 实体类和业务类要合二为一
 *
 * 实体类中包含了业务方法
 *
 * @author: success
 * @date: 2020/7/28 10:51 上午
 */
public class Account {
    private int id;

    private double balance;//账户余额

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 存钱
     * @param money
     */
    public void deposite(double money){
        if(money<=0){
            System.out.println("sorry,存入的金额不能是负数!");
            return;
        }
        this.balance += money;
    }

    /**
     * 取钱
     * @param money
     */
    public void withdraw(double money){
        //参数有效性判断
        if(money > this.balance){
            System.out.println("sorry,余额不足!");
            return;
        }
        this.balance-=money;
    }
}

~~~



## 业务类和实体类分开

* 实体类 - 描述对象 - **数据在内存中的载体.**强调的是数据的存储

* 业务类 -  操作对象中的数据的.强调的是数据的操作.

  推荐业务方法放在业务类中.

~~~java
package tech.aistar.day08.relation.biz;

/**
 * 本类用来演示: 银行账户业务类
 *
 * @author: success
 * @date: 2020/7/28 11:01 上午
 */
public class AccountBiz {


    //account ->   600.0d

    //acc
    public void deposite(Account acc,double money){
        if(money<=0){
            System.out.println("sorry,存入的金额不能是负数!");
            return;
        }
        acc.setBalance(acc.getBalance()+money);
    }


    /**
     * 一线城市 - 买不起
     *
     * 取钱
     */
    public void withdraw(Account acc,double money){
        if(acc.getBalance()<money){
            System.out.println("sorry,余额不足!");
            return;
        }
        //acc.setBalance(acc.getBalance()-money);

        double balance = acc.getBalance();
        balance-=money;
        acc.setBalance(balance);
    }
}

~~~



# 作业

* 昨天的作业进行实体类和业务类分离.



# 继承

简介:继承Encapsulation,继承是面向对象语言中最为显著的特点.根据某个已经存在的类来派生出

更多的子类.**子类可以吸收(继承)父类中的非私有成员**.一个类如果没有明确指定它的父类的时候,

那么这个类将会直接继承java.lang.Object.java中的类的继承具有层次性,**单继承(单重继承),**

一个类只能拥有唯一的一个直接的父类,但是一个父类可以拥有多个子类.

使用继承可以提高代码的**复用性**和**可拓展性**,提高程序的开发性能.



## 什么时候使用继承

业务中满足 ***a is b*** 语义的时候才能使用继承.继承不能滥用(不能为了继承而继承,不能为了代码的复用而滥用继承)

 是 水果 - 水果是父类,是子类.

狗 是 动物 - 动物是父类,狗是子类.



我们会将业务中多个对象具有的共同的特征抽离出来形成一个"类别" - 父类,基类,根类.

**父类中存放的是各个子类共同的"特征"以及"行为".**

**子类中可以提供各个子类独有的"特征"以及"行为".**

~~~java
//动物园的管理系统

public class Animal{//动物类
  private String name;
  
  private int age;
}

//Dog类继承Animal类
public class Dog extends Animal{//动物的子类
  
}

//Cat类继承Animal类
public class Cat extends Animal{
  
}
~~~



# 子类创建对象的过程

~~~java
//创建一个Dog对象
//先有对象,再有构造方法.

//        Animal空参构造被调用了...
//        Dog()空参构造被调用了...
Dog dog = new Dog();
~~~

发现调用Dog()的时候,Animal()空参构造也被调用了.

* 创建子类对象的时候,会优先先创建父类的对象
* 创建完父类的对象之后,会给这个父类对象中的所有的非静态成员分配空间以及初始化
* 等父类全部创建完毕之后,那么才轮到子类创建自己的对象以及初始化(非静态成员)



## super关键字

* 在子类中的任何一个构造方法中,系统都会默认分配一个super();

  super() - 调用父类中已经存在的空参构造

  前提:子类中的构造中没有手动提供任何一个super([参数列表]).

  super(参数) - 调用父类中存在的带参构造.

* 当调用父类中的成员的时候,这个成员和子类本身中的某个成员同名的时候,这个时候需要使用

  super.成员来强制使用**父类的成员.**



# 继承的传递性

A extends B

B extends C

A间接继承C,A也是可以被允许使用C中的非私有的成员的



# 继承的层次性

**Java中类与类之间如果需要继承,那么肯定是单继承.**好处:保证的类的层次性,避免出现网状结构.

C++是支持多重继承的.

**Java中的接口[替代业务类 - 功能]与接口之间是可以支持多重继承**



# 为什么使用继承

~~~java
//某个产品的第一个版本
public class Robot{
   
  public void benpao(){
    System.out.println("benpao...")
  }
 
}

//版本升级 - 功能变强.

//第一种升级方式 - 直接修改旧的Robot类.
public class Robot{
   
  public void benpao(){
    //也要进行修改..
    System.out.println("benpao...")
  }
  
  public void fly(){
    System.out.println("fly...")
  }
}
//肯定是不推荐修改旧代码.
//因为要符合软件的设计原则 - "开闭原则" - 对内禁止修改,对外可进行拓展.

public class AIRobot extends Robot{
  //新增新的功能...
  @Override
  public void benpao(){
    //也要进行修改..
    System.out.println("benpao...")
  }
  
   public void fly(){
    System.out.println("fly...")
  }
}
~~~



# 方法的重写

简介:@Override

前提:发生的前提是父子类,一定要存在继承关系.

当使用子类对象调用某个方法的时候,如果子类中没有提供这个方法,那么默认调用父类中提供的这个方法.

如果这个子类中提供了这个方法[重写的父类中的方法],那么就会采取的就是"就近原则",调用子类自己重写之后的.



注意点:

* 重写的方法名称父子类要保持一致.

* 修饰符的优先级

  * 安全性角度 **private>缺省的>protected>public**

    子类重写的方法的访问修饰符<=父类中的被重写的方法.

  * 可见域 public > protected > 缺省的 > private

* 子类重写的方法的返回类型
  * **基本类型 - 俩者保持一致**
  * 对象类型 - 子类重写的方法的返回类型<=父类中的方法的返回类型.

* 当子类重写的方法和父类中提供的这个方法高度保持一致的时候 - 重写的特殊场景 - **"方法的重构"**



***笔试题: 方法的重载和重写有什么区别?***



# 多态

***Polymorphism***

多态：同一操作作用于不同的对象，可以有不同的解释，产生不同的执行结果。在运行时，可以通过指向基类的指针，来调用实现派生类中的方法。



多态的应用之一:

* 对象的编译时类型可以写成父类,对象的运行时类型可以写成子类.

  ~~~java
  编译时类型 对象名 = new 运行时类型();
  Animal dog = new Dog();
  ~~~

  * 对象的编译时类型决定了对象的访问能力

    ~~~java
    此处的dog对象只能访问到编译时类型Animal中提供的成员.
    ~~~

  * 对象的运行时类型决定了对象的行为能力

    ~~~java
    如果运行时类型重写了编译时类型中的方法的时候,那么在程序运行的期间.
    最终执行的是运行时类型重写之后的方法.
    ~~~

    





