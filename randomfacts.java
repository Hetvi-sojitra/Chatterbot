
import java.util.Random;

abstract class facts{
    abstract void call();
}

class randfact1 extends facts{
    void call(){
        System.out.println("It is impossible for most people to lick their own elbow. (try it!)");
    } 
}

class randfact2 extends facts{
    void call(){
        System.out.println("A crocodile cannot stick its tongue out.");
    } 
}

class randfact3 extends facts{
    void call(){
        System.out.println("It is physically impossible for pigs to look up into the sky");
    } 
}

class randfact4 extends facts{
    void call(){
        System.out.println("If you sneeze too hard, you could fracture a rib.");
    } 
}

class randfact5 extends facts{
    void call(){
        System.out.println("Wearing headphones for just an hour could increase the bacteria in your ear by 700 times.");
    } 
}

class randfact6 extends facts{
    void call(){
        System.out.println("Some lipsticks contain fish scales.");
    } 
}

class randfact7 extends facts{
    void call(){
        System.out.println("There are 293 ways to make change for a dollar.");
    } 
}


class randomfacts{
    public static void main(String args[]){

        //facts fact[]=new facts[10];
                randfact1 f1=new randfact1();
                randfact2 f2=new randfact2();
                randfact3 f3=new randfact3();
                randfact4 f4=new randfact4();
                randfact5 f5=new randfact5();
                randfact6 f6=new randfact6();
                randfact7 f7=new randfact7();

        int min=1;
        int max=7;
        Random rand=new Random();
        int rand_i=rand.nextInt(max)+min;
        System.out.println(rand_i);

        if (rand_i==1){
                facts f;
                f=f1;
                f.call();
        }

        else if (rand_i==3){
            facts f;
            f=f3;
            f.call();
    }

else if (rand_i==2){
    facts f;
    f=f2;
    f.call();
}

else if (rand_i==4){
    facts f;
    f=f4;
    f.call();
}

else if (rand_i==5){
    facts f;
    f=f5;
    f.call();
}

else if (rand_i==6){
    facts f;
    f=f6;
    f.call();
}

else{
    facts f;
    f=f7;
    f.call();
}


    }
}