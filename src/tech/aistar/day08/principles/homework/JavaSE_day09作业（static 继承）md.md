1. ```java
    public class Cygnus{
      static int value = 9;  
      
       private void printValue(){
          int value = 69; 
          System.out.println(this.value);
      }
      
      public static void main(String[] args) throws Exception{
          new Cygnus().printValue();
      }
      
   }
   这个程序会有下面哪种结果？
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
     		System.out.println("base static");
 		}
   		 public Base(){
     		System.out.println("base constructor");
 		}
}

public class Test extends Base{

		static{
   			 System.out.println("test static");
		}
 
		public Test(){
			super();
   			 System.out.println("test constructor");
		}
 
		public static void main(String[] args) {
    			new Test();
		}
}
```
---------------------------------------------------------------------------------------
#### 4. 写出以下程序的输出结果

```java
public class Test {

 static{
     System.out.println("test static 1");
 }
 public static void main(String[] args) {
      
 }

 static{
     System.out.println("test static 2");
 }
    
}
```



---------------------------------------------------------------------------------------
4. 

```java
public class test{
	static{
		 int x=5;
	}
	static int x,y;
	public static void main(String args[]){
   		x--;
   		myMethod( );
   		System.out.println(x+y+ ++x);
	}
	public static void myMethod( ){
  		y=x++ + ++x;
	}
}
A.	编译错误
B.	输出：1
C.	输出：2
D.	输出：3
E.	输出：7
F.	输出：8
```
#### 5. 阅读下列程序，选择哪一个是正确的输出结果 

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
#### 6. 以下代码的输出结果是？    

```java
public class B{
    public static B t1 = new B();
    public static B t2 = new B();
    
	{
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
#### 7. 下面代码在main方法代码后可以正常使用的是（ ）

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

#### 8. 下列程序执行后结果为( )

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
A.	Result=150Result=150
B.	Result=100Result=100
C.	Result=100Result=150
D.	Result=150Result=100
```

#### 9. 以下代码执行后输出结果为（ ）

```java
public class Test{
    public static Test t1 = new Test();
	{
    	 System.out.println("blockA");
	}

	static{
    	System.out.println("blockB");
	}

    public static void main(String[] args){
        Test t2 = new Test();
	}
}

A.	blockAblockBblockA
B.	blockAblockAblockB
C.	blockBblockBblockA
D.	blockBblockAblockB
```

#### 判断以下方法是不是方法重载

```java
public void fun1(int x,int y){}
public void fun1(int a,int b){}
public void fun1(int x,long y){}
public int fun1(int x){..}
public int fun1(long  y,int x){..}
```

#### 判断以下方法是不是方法重写

```java
class A{
    public void study(int x,int y){ ..}
    private void play(int x,int y){ ..}
}

class B extends A{
     public void study(int a,int b){ ..}
     public void play(int x,int y){ ..}
}

class C extends A{
     public void study(char a,char b){ ..}
}

class D extends A{
     public void study2(char a,char b){ ..}
     protected void study(int a,int b){ ..}
     public void study(float a,float b){ ..}
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
        System.out.println(p1 instanceof Dog);
        System.out.println(p1 instanceof Pet);
        p1.run();
        
        Dog d1 = (Dog)p1;
        System.out.println(d1 instanceof Dog);
        System.out.println(d1 instanceof Pet);
        d1.run();
        
        Pet p2 =  new Pet();
        Dog d2 = (Dog)p2;
        System.out.println(d2 instanceof Dog);
        System.out.println(d2 instanceof Pet);
    }
    
}
```

