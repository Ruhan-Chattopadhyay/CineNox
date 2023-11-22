import java.util.*;
import java.io.*;
class FinalMatrix{
    String a[][]=new String[10][12];
        static String path="";

    public static void main(String args[])
    
    {   FinalMatrix ob1=new FinalMatrix();
        Scanner sc=new Scanner(System.in);
        ob1.displayMenu();
        int choice=sc.nextInt();
        System.out.println("Press 1 for 12:30pm show\nPress 2 for 5:30pm show\nPress 3 for 7:30pm show");
        int time=sc.nextInt();

        if(choice==1)
            path+="Oppenheimer";
        else
            path+="Jawan";

        switch(time){
            case 1: path+="12_30_pm";
                break;
            case 2: path+="5_30_pm";
                break;
            case 3: path+="7_30_pm";
                break;
            default:System.out.println("Wrong timing choice");
                System.exit(0);
        }
        path+=".txt";
        ob1.onboarding(path);
        path="";
    }

    void login() //initial process
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
    String name="";
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
                name=id1;
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
    void CreateMatrix(){
        char ch='J';  int x;
        for(int i=0;i<3;i++)
        {
            x=1;
            for(int j=0;j<12;j++)
            {
                if(j==0)        
                    a[i][j]=""+ch;
                else if(j>2 && j<10)
                {
                    a[i][j]=""+x;
                    x++; 
                } 
                else a[i][j]="";
            }
            ch--;
        }
        for(int i=3;i<7;i++)
        {
            x=1;
            for(int j=0;j<12;j++)
            {
                if(j==0)
                    a[i][j]=""+ch;
                else{
                    a[i][j]=""+x;
                    x++;
                }
            }
            ch--;
        }

        for(int i=7;i<10;i++)
        {
            x=1;
            for(int j=0;j<12;j++)
            {
                if(j==0)
                    a[i][j]=""+ch;
                else if(j>2 && j<10)
                {
                    a[i][j]=""+x;
                    x++; 
                } 
                else a[i][j]="";
            }
            ch--;
        } 
    }
    

    void displayMenu()
    {
        System.out.println("Press 1 for Oppenheimer\nPress 2 for Jawan");
    }

    void onboarding(String path){
        try
        {   FileWriter fw2=new FileWriter(path,true);
              Print();
              fw2.close();
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter number of seats to be booked:");
            int no=sc.nextInt();
            for(int i=1;i<=no;)
            {
                System.out.println("Enter seat alphabet and number:");
                String s=sc.next();
                String p=""+s.charAt(0);
                p=p.toUpperCase();
                String q=s.substring(1);  int fl2=0; int fl1=0;
                int qcopy=Integer.parseInt(q); //use for check of seat so user does nt input wrong choice
                String checkNumberOfSeats="ABCJIH";
                int numberOfSeats=0;
                if(checkNumberOfSeats.indexOf(p)!=-1)
                numberOfSeats=7;
                else
                numberOfSeats=11
                ;
                
                if(qcopy>numberOfSeats||qcopy<=0)
                System.out.println("Wrong Choice");
                else
                {
                for(int j=0;j<10;j++)
                {   FileWriter fw1=new FileWriter(path,true);
                    check(path);
                    fw1.close();
                    if(a[j][0].equals(p))
                    {
                        for(int k=0;k<12;k++)
                        {
                            if(a[j][k].equals(q))
                            {   FileWriter fw=new FileWriter(path,true);
                                BufferedWriter bw=new BufferedWriter(fw);
                                PrintWriter pw=new PrintWriter(bw);
                                
                                pw.print(s+" ");
                                i++;fl1=1;
                                pw.close();

                            }
                            
                        }
                        fl2=1;
                        if(fl1==0) System.out.println("Occupied");
                        else
                        {   
                            break;

                        }
                    }

                }
            
                if(fl2==0) System.out.println("Wrong choice");
            }
        }
            Print();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void check(String path){

        try
        {
            CreateMatrix();
            FileReader fr=new FileReader(path);
            BufferedReader br=new BufferedReader(fr);
            String s=br.readLine();

            if(s!=null)
            { 
                String splitted[]=s.split(" ");

                for(int i=0;i<splitted.length;i++)
                {   
                    String x=splitted[i];
                    String p= (""+x.charAt(0)).toUpperCase();
                    String q=x.substring(1);
                    for(int j=0;j<10;j++)
                    { 
                        if(a[j][0].equals(p))
                        {
                            for(int k=0;k<12;k++)
                                if(a[j][k].equals(q))
                                    a[j][k]="*";
                        }
                    }
                    br.close();fr.close();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    void Print()
    {
        check(path);
        for(int i=0;i<10;i++)
        {
            if(i==3){
                System.out.println();System.out.println("ROYAL RECLINER: Rs. 550"); System.out.println();
            }
            if(i==7){
                System.out.println();System.out.println("EXECUTIVE: Rs. 300"); System.out.println();
            }
            for(int j=0;j<12;j++){
                System.out.print(a[i][j]+"     ");
            }System.out.println();
        }
        System.out.println("NORMAL: Rs. 200");

        System.out.println("\n\n\t\t\t ALL EYES HERE PLEASE!!!");
    }
}