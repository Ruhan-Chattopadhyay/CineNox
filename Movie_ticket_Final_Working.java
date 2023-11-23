import java.util.*;
import java.io.*;
class FinalMatrix{
    String a[][]=new String[10][12];
        static String path="";
        static String path1="";

    public static void main(String args[])
    
    {   
        System.out.println("\n\t\t\t\tWELCOME TO CINENOX E-TICKET BOOKING SYSTEM\n\n");
        FinalMatrix ob1=new FinalMatrix();
        ob1.login();
        Scanner sc=new Scanner(System.in);
        
        ob1.displayMenu();
        int choice=sc.nextInt();
        System.out.println("Press 1 for 12:30 p.m. show\nPress 2 for 5:30 p.m. show\nPress 3 for 7:30 p.m. show");
        int time=sc.nextInt();
        if(choice==1)
            path+="MISSION IMPOSSIBLE DEAD RECKONING II";
        else
            path+="JOHN WICK CHAPTER 4";

        switch(time){
            case 1: path+="_12_30p.m._";
                break;
            case 2: path+="_5_30p.m._";
                break;
            case 3: path+="_7_30p.m._";
                break;
            default:System.out.println("Wrong timing choice");
                System.exit(0);
        }
        path1=path+"_userid.txt";
        path+=".txt";
        ob1.onboarding(path);
        path="";
    }

    void login() //initial process
    {   Scanner sc=new Scanner(System.in);
        System.out.println("Press\n1 for new guest user\n2 for existing user");
        int x=sc.nextInt(); // x is the choice of user
        switch(x)
        {
            case 1:
                newuser();
                break;

            case 2:
                existingUser();
                break;
        }
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
            name=id;
            sc.reset();
            System.out.println("Enter password");
            String pass=sc.next(); //store password
            FileReader fr=new FileReader("movie_userid.txt");
            BufferedReader br= new BufferedReader(fr);
           String s=br.readLine();

            while( s!=null) //check for duplicate user
            {   String checker=id+" "+pass;
                if(s.equals(checker))
                {
                    System.out.println("User already exists");
                    System.exit(0);
                }
                s=br.readLine();
            }
            br.close();
            fr.close();
              
            pw.println(id+" "+pass);
            System.out.println("Welcome "+id);
            pw.close();
            bw.close();
            fw.close();
            

        }
        catch(Exception e)
        {
            System.out.println(e);
            System.exit(0);
        }
    }
    
    void existingUser() //for existing user
    {   try

        {       FileWriter fw=new FileWriter("movie_userid.txt",true);
                fw.close();
               Scanner sc=new Scanner(System.in);
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
                    System.out.println("UserId or Password incorrect");
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
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void CreateMatrix(){
        char ch='J'; int x;
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
        System.out.println("Press 1 for MISSION IMPOSSIBLE DEAD RECKONING II\nPress 2 for JOHN WICK CHAPTER 4");
    }
    String seatno[];
    void onboarding(String path){
        try
        {   FileWriter fw2=new FileWriter(path,true);
              Print();
              System.out.println("\n* Represents Booked Seats\n");
              fw2.close();
            Scanner sc=new Scanner(System.in);
            System.out.println("\n\nEnter number of seats to be booked:");
            int no=sc.nextInt();
            seatno=new String[no]; int x=0;
            for(int i=1;i<=no;)
            {
                System.out.println("\nEnter seat alphabet and number:");
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
                System.out.println("Entered Seat Alphabet Does not Exist");
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
                                seatno[x++]=s;
                                pw.print(s+" ");
                                i++;fl1=1;
                                pw.close();

                            }
                           
                        }
                        fl2=1;
                        if(fl1==0) System.out.println("Seat Already Occupied, Kindly Choose an empty seat");
                        else
                        {   
                            break;

                        }
                    }

                }
            
                if(fl2==0) System.out.println("Wrong choice");
            }
        }
            //Print();
            System.out.print("Press\n 1. To view Payment Bill \n 2. To Order Food Items");
            int opt=sc.nextInt();
            switch(opt){
                case 1: BillPrint(path1);break;
                case 2: Food();break;
                default: System.out.println("Invalid choice, Food Item unable to add");BillPrint(path1);
            }
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
            }System.out.println("\n");
        }
        System.out.println("NORMAL: Rs. 200");

        System.out.println("\n\n\t\t\t ALL EYES HERE PLEASE!!!");
    }
    
    void BillPrint(String path1){
        try{
        FileWriter fw=new FileWriter(path1,true);
                                BufferedWriter bw=new BufferedWriter(fw);
                                PrintWriter pw=new PrintWriter(bw);
        System.out.println("\n\n\n\t\t\t\t_Payment Bill_");int sum=0;
        System.out.println("\n\t\t\t\tName of customer: "+name);pw.print(name+" ");
        String movieName=path.substring(0,(path.indexOf("_")));
        
        String movieTime= path.substring((path.indexOf("_"))+1,(path.lastIndexOf("_")));
        movieTime=movieTime.replace("_", ":");
        System.out.println("\n\t\t\t\tMovie Name: "+movieName);pw.print(movieName+" ");
        System.out.println("\n\t\t\t\tShow Timing: "+movieTime);pw.print(movieTime+" ");
        System.out.print("\n\t\t\t\tSeats occupied: ");
        for(int i=0;i<seatno.length;i++){
            char p=seatno[i].charAt(0);
            if(p<='C') sum+=200;
            else if(p<='G') sum+=300;
            else sum+=550;
            System.out.print(seatno[i]+" ");pw.print(seatno[i]+" ");
        }
        System.out.println();
        System.out.println("\n\t\t\t\tTotal cost of seats: "+sum+".00");
        if(foodCost!=0)
        { 
            sum+=foodCost;System.out.println("\n\t\t\t\tCost of Food: "+foodCost);
        }
        double tax,finalSum; 
        tax= (0.18*sum);
        finalSum= sum+tax;
        System.out.println("\n\t\t\t\tTax Amount: Rs. "+tax);
        
        pw.print(finalSum+" ");
        System.out.println("\n\t\t\t\tTotal Amount To Be Paid: "+ finalSum);
        System.out.println("\n\t\t\t\tENJOY YOUR SHOW!!");
        pw.println();
        pw.close();
    }
    catch(Exception e){
        System.out.println(e);
}
}
int foodCost=0;
void Food(){
    Scanner sc=new Scanner(System.in);
    System.out.println("Press\n 1. for Popcorn \n 2. for Cold Drinks");
    int opt=sc.nextInt();
    switch(opt){
        case 1: System.out.println("Press\n 1. For Small Rs.  90\n 2. for Medium Rs. 120\n 3. for Large Rs. 150");
        int size=sc.nextInt();
        System.out.println("Enter no. of orders");
        int no=sc.nextInt();
        switch(size)
        {
            case 1: foodCost=90*no; break;
            case 2: foodCost=120*no; break;
            case 3: foodCost= 150*no; break;
            default: System.out.println("Invalid choice"); break;
        }
            break;
            case 2: System.out.println("Press\n 1. For Small Rs.  40\n 2. for Medium Rs. 60\n 3. for Large Rs. 70");
        int size2=sc.nextInt();
        System.out.println("Enter no. of orders");
        int no2=sc.nextInt();
        switch(size2)
        {
            case 1: foodCost=40*no2; break;
            case 2: foodCost=60*no2; break;
            case 3: foodCost= 70*no2; break;
            default: System.out.println("Invalid choice"); break;
        }
            break;
            default: System.out.println("Invalid choice");
        }
      BillPrint(path1);
    }
    
}//end of class