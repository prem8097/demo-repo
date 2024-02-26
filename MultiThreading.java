package CoreJava;
// Multi threading in java 

//--------------------------------------------
/* 
NEW : The thread has not yet started execution.
RUNNABLE : A thread in execution.
BLOCKED : A thread in a blocked state.
WAITING : A thread in a waiting state.
TIMED_WAITING : A state for a waiting thread with a specified waiting time.
This is multithreading java program
*/
class MultiThreading extends Thread{
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("\n"+i + " of "+ this.getName()+ " id is " + this.getId() + " and state is " + this.getState());
            try{
                 Thread.sleep(3000);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
           
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MultiThreading h=new MultiThreading();
        MultiThreading g=new MultiThreading();
        System.out.println("\nCurrent state of Thread h is " + h.getState());
        h.setName("First Thread");
        g.setName("Second Thread");
        g.start();
        try{
            /*it stops the execution of the main method and wait for thread g to complete*/
            g.join();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("\nHello World 1");
        h.start();
         /*it stops the execution of the main method and wait for thread h to complete*/
         
        h.join();
        System.out.println("\nHello World 2");
    }
}