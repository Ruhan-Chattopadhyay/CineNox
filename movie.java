import java.util.*;
import java.io.*;
class movie
{   
    
    public static void main(String args[])
    {   
        movie ob=new movie();
        ob.onboarding();
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
            System.out.println("Error");
        }
    }

    void existingUser()
    {   try
        {   Scanner sc=new Scanner(System.in);
            System.out.println("Enter user id");
            String id1=sc.next(); //store user id to check;
            System.out.println("Enter password");
            String pass1=sc.next(); //store password to check
            FileReader fr=new FileReader("movie_userid.txt");
            BufferedReader br=new BufferedReader(fr);
            String s; int flag=0; //check if user is found. ELse exit program; Work in progress
            while (true)
            {   
                s=br.readLine();
                if(s==null)
                {
                    System.out.println("User not found");
                    flag=1;
                    break;
                }

                String[] words=s.split(" ");
                
                if(words[0].equals(id1) && words[1].equals(pass1))
                {
                System.out.println("User found");
                flag=1;
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
}


 
   