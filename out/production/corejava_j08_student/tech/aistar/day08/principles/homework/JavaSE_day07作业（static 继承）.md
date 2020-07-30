1. ```java
    public class Cygnus{
      static int value = 9;  
      
       private void printValue(){
         //局部变量的基本数据类型在栈里面... 
         int value = 69; //非静态方法中是可以直接使用静态属性的.
          //static int value = 69;//非静态方法中是不能够去定义静态方法的.
         
         //User user = new User();//堆里面
         
          //静态的成员但是仍然可以使用对象进行调用的.
          System.out.println(this.value);
     }
     
     public static void main(String[] args) throws Exception{
         new Cygnus().printValue();
     }
     
   }
   这个程序会有下面哪种结果？  B
   A. 编译错误
   B. 打印9
   C. 打印69
   D. 运行时抛出异常
   ```





---------------------------------------------------------------------------------------
#### 2. 写出以下程序的输出结果

```java
 class Base{
    	static{
     		System.out.println("base static ");
 		}
   		 public Base(){
     		System.out.println("base constructor ");
 		}
}
//只要被JVM加载的类中的静态资源都会被分配空间和执行
public class Test extends Base{
		
		static{
   			 System.out.println("test static ");
		}
 
		public Test(){
			super();
   	  System.out.println("test constructor");
		}
 
		public static void main(String[] args) {
    			new Test();
		}
}
base static test static base constructor test constructor
```
---------------------------------------------------------------------------------------
#### 4. 写出以下程序的输出结果

```java
public class Test {

  //多个静态代码块自上而下
 static{
     System.out.println("test static 1");
 }
 public static void main(String[] args) {
      
 }

 static{
     System.out.println("test static 2");
 }
    
}
test static 1 test static 2
```



---------------------------------------------------------------------------------------
4. 

```java
public class test{
	static{
		  int x=5;//第二步..作用域仍然在{}中
	}
  //全局变量
	static int x,y;//第一步...
  
	public static void main(String args[]){
   		x--;//x = -1 - static修饰的x
   		myMethod( );
    
    //1 + 0 + 2 = 3
   		System.out.println(x+y+ ++x);
	}
	public static void myMethod( ){
  		y=x++ + ++x;
      y = -1 + 1 = 0
	}
}
A.	编译错误
B.	输出：1
C.	输出：2
D.	输出：3    ok
E.	输出：7
F.	输出：8
```
#### 5. 阅读下列程序，选择哪一个是正确的输出结果 (C)

```java
class HelloA{
	public HelloA()	{
        	System.out.println("I’m A class ");
    	}
	static{
	    	System.out.println("static A");
	}
}

public class HelloB extends HelloA{
    public HelloB(){
        System.out.println("I’m B class");
    }
    static{
        System.out.println("static B");
    }
    

	public static void main (String[] args){
    	new HelloB();
	}
}

A.	static A I’m A class static B I’m B class
B.	I’m A class I’m B class static A static B
C.	static A static B I’m A class I’m B class
D.	I’m A class static A I’m B class static B
```
---------------------------------------------------------------------------------------
#### 6. 以下代码的输出结果是？    (C)

```java
public class B{
    //1. 给所有的静态属性分配空间和赋值.
    public static B t1 = new B();
    public static B t2 = new B();
    
	 {
       //每次创建对象都会执行普通代码块
   		 System.out.println("构造块");
	 }
   
	static{
    	System.out.println("静态块");
	}

	public static void main(String[] args){
   		 B t = new B();
	}
 }

A.	静态块 构造块 构造块 构造块
B.	构造块 静态块 构造块 构造块
C.	构造块 构造块 静态块 构造块	
D.	构造块 构造块 构造块 静态块

```
#### 7. 下面代码在main方法代码后可以正常使用的是（ A,D）

```java
public class Test{
    private int a=10;
    int b=20;
    static int c=1;
    public static void main(String arg[]){
        Test t = new Test();
    }
 }

A.	t.a
B.	this.c
C.	Test.b
D.	Test.c

```

#### 8. 下列程序执行后结果为(A )

```java
class A {
    public int func1(int a, int b) {
        return a - b;
    }
}
class B extends A {
    public int func1(int a, int b) {
        return a + b;
    }
}

public class ChildClass {
    public static void main(String[] args) {
    A a = new B();
    B b = new B();
      
    System.out.println("Result=" + a.func1(100, 50));
    System.out.println("Result=" + b.func1(100, 50));
    }
}
A.	Result=150 Result=150   ok
B.	Result=100 Result=100
C.	Result=100 Result=150
D.	Result=150 Result=100
```

#### 9. 以下代码执行后输出结果为（ A）

```java
public class Test{
    public static Test t1 = new Test();//①
    
	{
    	 System.out.println("blockA");//②  ④
	}

	static{
    	System.out.println("blockB");③
	}

    public static void main(String[] args){
        Test t2 = new Test();
	}
}

A.	blockAblockBblockA    ok
B.	blockAblockAblockB
C.	blockBblockBblockA
D.	blockBblockAblockB
```

#### 判断以下方法是不是方法重载

前提:同一个类,同名,看参数列表

```java
public void fun1(int x,int y){}

public void fun1(int a,int b){}  - error
  
public void fun1(int x,long y){} - ok
public int fun1(int x){..} - ok
public int fun1(long  y,int x){..} - ok
```

#### 判断以下方法是不是方法重写

```java
class A{
    public void study(int x,int y){ ..}
    private void play(int x,int y){ ..}
}

class B extends A{
     public void study(int a,int b){ ..} - ok - 方法的重构
     public void play(int x,int y){ ..} - error
}

class C extends A{
     public void study(char a,char b){ ..}
}

class D extends A{
     public void study2(char a,char b){ ..} - 名称都不一样
     protected void study(int a,int b){ ..} - 不可以
       
     //方法的重载
     public void study(float a,float b){ ..} - 不是
}

 
```

写出以下程序执行结果，有误的请指出

```java
class Pet{
    public void run(){
       System.out.println("pet is running");
    }
}

class Dog extends Pet{
    public void run(){
       System.out.println("dog is running");
    }
}
//测试类
class Test{
    public static void main(String[] args){
        Pet p1 =  new Dog();
        System.out.println(p1 instanceof Dog);//ok
        System.out.println(p1 instanceof Pet);//ok
        p1.run();//dog is running
        
        Dog d1 = (Dog)p1;//ok
        System.out.println(d1 instanceof Dog);//ok
        System.out.println(d1 instanceof Pet);//ok
        d1.run();//dog is running
        
        Pet p2 =  new Pet();//需要注意
      
        Dog d2 = (Dog)p2;//error java.lang.ClassCastException
        System.out.println(d2 instanceof Dog);//ok
        System.out.println(d2 instanceof Pet);//ok
        System.out.println(p2 instanceof Dog);//error
    }
    
}
```

