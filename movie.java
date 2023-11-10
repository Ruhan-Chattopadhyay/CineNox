import java.util.*;
import java.io.*;
class movie
{   
    int fl=0; //check if user is admin or not
    public static void main(String args[])
    {   
        movie ob1=new movie();
        ob1.onboarding();
    }

    void onboarding() //initial process
    {   Scanner sc=new Scanner(System.in);
        movie ob1=new movie();
        System.out.println("Press\n1 for new guest user\n2 for existing user");
        int x=sc.nextInt(); // x is the choice of user
        switch(x)
        {
            case 1:
                ob1.newuser();
                break;

            case 2:
                ob1.existingUser();
                break;
        }
        sc.close();
    }
        
    //new user
    void newuser()
    {   
        try
        {   Scanner sc=new Scanner(System.in);
            FileWriter fw=new FileWriter("movie_userid.txt",true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            System.out.println("Enter user id");
            String id=sc.next(); //store user id;
            sc.reset();
            System.out.println("Enter password");
            String pass=sc.next(); //store password
            pw.println(id+" "+pass+" 0");
            
            pw.close();
            bw.close();
            fw.close();
            sc.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
            System.exit(0);
        }
    }

    void existingUser() //for existing user
    {   try
        {   Scanner sc=new Scanner(System.in);
            System.out.println("Enter user id");
            String id1=sc.next(); //store user id to check;
            System.out.println("Enter password");
            String pass1=sc.next(); //store password to check
            FileReader fr=new FileReader("movie_userid.txt");
            BufferedReader br=new BufferedReader(fr);
            String s; 
            while (true)
            {   
                s=br.readLine();
                if(s==null)
                {
                    System.out.println("User not found");
                    System.exit(0);
                }

                String[] words=s.split(" ");
                
                if(words[0].equals(id1) && words[1].equals(pass1))
                {
                System.out.println("Welcome "+id1);

                    if(words[0].equals("admin")&&words[1].equals("admin")&&words[2].equals("1"))
                    {
                        fl=1;
                    }
                
                    
                    break;
                }
                
            }
            br.close();
            fr.close();
            sc.close();
            
            

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    String movieListViewer() //to view movie list
    {   Scanner sc=new Scanner(System.in);
        try
        {
            FileReader fr=new FileReader("movie_list.txt");
            BufferedReader br=new BufferedReader(fr);
            int movieindex=1,timingindex=1;
            while(true)
            {
                String s=br.readLine();
                if(s==null)
                {
                    break;
                }
                String[] words=s.split(" ");
                for(int i=0;i<words.length;i++)
                {
                    if(i==0)
                    {
                        System.out.println(movieindex+". "+words[i]);
                        movieindex++;
                    }
                    else
                    {
                        System.out.println("\t"+(char)(timingindex+96)+". "+words[i]);
                        timingindex++;
                    }
                }
            }
            br.close();
            fr.close();
        }

        catch(Exception e)
        {
            System.out.println(e);
        }

        System.out.println("Enter the number present to the left of the movie you want to watch");
        int movieChoice=sc.nextInt(); //store value of movie choice;
        System.out.println("Enter the alphabet present to the left of the timing of the movie you want to watch");
        int timechoice=(int)(sc.next().charAt(0))-96;
        sc.close();

        String returnValue=movieChoice+" "+timechoice;
        return returnValue;
    }
    void movieListAdder()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            FileWriter fw=new FileWriter("movie_list.txt",true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            System.out.println("Enter movie name");
            String name=sc.next(); //store movie name;
            sc.reset();
            System.out.println("How many times will the show be screened per day?");
            pw.print(name+" ");
            int times=sc.nextInt(); //store number of times show will be played
            for(int i=0;i<times;i++)
            {   System.out.println("Enter timing of "+(i+1)+" screening");
                pw.print(sc.next()+" ");
            }
            pw.println();
            pw.close();
            bw.close();
            fw.close();
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    void menu2()
    {
        if(fl==0)//i.e if guest
        {
          String choice =  movieListViewer();
          // int seatChoice = seatViewer(choice); work in progress
        }
        
    }
}


 
   