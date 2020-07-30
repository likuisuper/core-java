



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



[**多态的应用之一 - 面向父类编程**]()

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

* 方法的参数类型可以写成父类,调用方法的时候,可以传入这个类的任何一个子类的对象.

* 方法的返回类型是父类,方法的的返回值可以是这个父类的任何一个子类对象.



# 设计原则

设计模式（Design Pattern）**是一套被反复使用、多数人知晓的、经过分类的、代码设计经验的总结**。

使用设计模式的目的：为了**代码可重用性**、让代码更容易被他人理解、保证代码可靠性。 设计模式使代码**编写真正工程化**；设计模式是软件工程的基石脉络，如同大厦的结构一样。

项目中合理地运用设计模式可以完美地解决很多问题，每种模式在现实中都有相应的原理来与之对应，**每种模式都描述了一个在我们周围不断重复发生的问题，以及该问题的核心解决方案**，这也是设计模式能被广泛应用的原因。



##单一职责原则

***简介:单一职责原则（Single Responsiblity Principle SRP）***

**接口或类只提供一种业务实现。**
单一职责原则宗旨是每个接口、类的功能，只能用来做专门的事，强调系统内业务职责唯一，避免职责扩散，做到业务统一管理.



## 开闭原则

***简介:总原则:开闭原则（Open Close Principle）***

**开闭原则就是说对扩展开放，对修改关闭**。在程序需要进行拓展的时候，不能去修改原有的代 码，而是要扩展原有代码，实现一个热插拔的效果。所以一句话概括就是：为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，**我们需要使用接口和抽象类等**，后面的具体设计中我们会提到这点。 单一职责原则不要存在多于一个导致类变更的原因，也就是说每个类应该实现单一的职责，如若不然，就应该把类拆分。 



## 依赖倒转原则

***简介:依赖倒转原则（Dependence Inversion Principle）*** 

**这个是开闭原则的基础**，具体内容：**面向接口编程，依赖于抽象而不依赖于具体**。写代码时用到具体类时，不与具体类交互，而与具体类的上层接口交互。 



## 里氏替换原则

***简介:里氏替换原则（Liskov Substitution Principle）***

里氏代换原则(Liskov Substitution Principle LSP)面向对象设计的基本原则之一。 里氏代换原则中说，**任何基类可以出现的地方，子类一定可以出现**。 LSP 是继承复用的基石，只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。里氏代换原则是对“开-闭”原则的补充。实现“开-闭”原则的关键步骤就是抽象化。而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实 现抽象化的具体步骤的规范。**里氏替换原则中，子类对父类的方法尽量不要重写和重载**。**因为父类代表了定义好的结构，通过这个规范的接口与外界交互，子类不应该随便破坏它。**



**因为继承带来的侵入性，增加了耦合性，也降低了代码灵活性，父类修改代码，子类也会受到影响，此时就需要里氏替换原则。**

- 子类必须实现父类的抽象方法，但不得重写（覆盖）父类的非抽象（已实现）方法。
- 子类中可以增加自己特有的方法。
- 当子类覆盖或实现父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更宽松。
- 当子类的方法实现父类的抽象方法时，方法的后置条件（即方法的返回值）要比父类更严格。



## 迪米特法则

***简介:迪米特法则（最少知道原则）（Demeter Principle)***

就是说：一个类对自己依赖的类知道的越少越好。也就是说无论被依赖的类多么复杂，都应该将逻辑封装方法的内部，通过 public 方法提供给外部。这样当被依赖的类变化时，才能最小的影响该类。 最少知道原则的另一个表达方式是：***只与直接的朋友通信***。类之间只要有耦合关系，就叫朋友关系。***耦合分为依赖、关联、聚合、组合等***。***我们称出现为成员变量、方法参数、方法返回值中的类为直接朋友***。***局部变量、临时变量则不是直接的朋友。我们要求陌生的类不要作为局部 变量出现在类中。*** 



案例: 人 买 房

场景一: 人 直接 找房源 - 人 和 自己不熟悉的事物(房源) 直接 产生了联系(耦合).

修改

场景二:人 -> 中介 -> 房源 - 人只会跟中介直接进行交互,至于中介如何去找房源,人是不需要关心的 - "最少知道原则".

场景三:升级和改造 - 中介这个人可能会跑路,房源可能没了.

人 -> **中介公司** - > 安排一个中介 -> **房地产公司** -> 带领看房源.

* 中介公司是用来解耦合人和中介
* 房地产公司用来解耦合 中介 和 房源 的耦合
* 人和房源也是解耦合的



## 合成复用原则

***简介:合成复用原则（Composite Reuse Principle)***

原则是尽量首先使用合成/聚合的方式，而不是使用继承。



对象与对象之间的关系分成两大类

* 纵向关系 - 继承,实现
* 横向关系 - 依赖,关联,聚合,组合等关系 - UML(统一建模语言)



## 接口隔离原则



# instanceof关键字

补充多态知识点.判断类型的归属的.

对象 instanceof 类型

应用场景:程序代码中出现了将父类类型强制转换成子类类型的时候,为了避免出现**java.lang.ClassCastException**类型转换失败异常,需要在类型转换之前,先进行类型的判断.

~~~java
 Animal[] animals = new Animal[2];

animals[0] = dog;
animals[1] = cat;

//animal中既包含狗,又包含猫
for (Animal animal : animals) {
  //调用Animal类中提供的公共的方法...
  animal.sleeping();

  //继续调用子类中特有的方法..
  //解决方案: 强制类型转换.

  //java.lang.ClassCastException 类型转换失败异常
  //为了避免类型转换失败异常的出现 - 在进行强制类型转换的时候
  //需要先进行类型的判断
  if(animal instanceof Dog) {
    Dog dogs = (Dog) animal;
    dogs.watchDoor();
  }

  if(animal instanceof Cat) {
    Cat cats = (Cat) animal;
    cats.catchMouse();
  }

  System.out.println("=====");
}
~~~







