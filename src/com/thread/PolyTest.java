package com.thread;

class Father{
 public String name = "Father";
 
 public void test(){
  System.out.println("this is Father");
 }
 
 public String display(long a){
  return "Father";
 }
}
 
class Son extends Father{
 public String name = "Son";
 
 @Override
 public void test(){
  System.out.println("this is Son");
 }
 
 public String display(int a){
  return "Son";
 }
}
 
 
 
 
public class PolyTest
{
 public static void main(String[] args)
 {
     //example1
  Father father = new Son();
  father.test();
  System.out.println(father.name);
  System.out.println(father.display(5));
  System.out.println(father.display(5L));
  
  System.out.println();
  
  //example2
  Son son = new Son();
  son.test();
  System.out.println(son.name);
  System.out.println(son.display(5));
  System.out.println(son.display(5L));
 }
}