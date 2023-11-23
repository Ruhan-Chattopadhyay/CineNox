import java.util.*;
import java.io.*;
class FinalMatrix{
    String a[][]=new String[10][12];
    static String path="";//contains seats which are booked already
    static String path1="";//contains all details from bill payment
    static int exitallowed=0;
    int foodCost=0;//cost of food booked
    String name="";//name of user
    public static void main(String args[])

    {   
            System.out.println("\n\t\t\t\tWELCOME TO CINENOX E-TICKET BOOKING SYSTEM\n\n");
            while (true){// after each successfull booking user gets options to continue or exit
            FinalMatrix ob1=new FinalMatrix();//object to call other methods
            if(exitallowed==1)//so that at first iteration menu is not printed
            {
                Scanner sc=new Scanner(System.in);
                System.out.println("Press\n1.To go back to first menu\n2.To exit");
                if(sc.nextInt()==2)//if user wants to exit the program
                {   System.out.println("\t\t\tThanks for giving us your time");
                    System.exit(0);
                }
                sc.close();
            }
            exitallowed=1;//so that in all next iterations the options to continue or exit is given to user
            ob1.login();//calls login method
            Scanner sc=new Scanner(System.in);

            ob1.displayMenu();//calls menu displaying method to provide movie options
            int choice=sc.nextInt();
            System.out.println("Press 1 for 12:30 p.m. show\nPress 2 for 5:30 p.m. show\nPress 3 for 7:30 p.m. show");
            int time=sc.nextInt();
            if(choice==1)
                path+="MISSION IMPOSSIBLE DEAD RECKONING II";//first movie option
            else
                path+="JOHN WICK CHAPTER 4";//second movie option

            switch(time){
                case 1: path+="_12_30p.m._";//timing concatenated in file name for future convenience
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
            ob1.onboarding(path);//calls onboarding method where user enters seat of his/her choice
            path="";
        }
    }

    void login() //initial process
    {   Scanner sc=new Scanner(System.in);
        System.out.println("Press\n1 For new guest user\n2 For existing user");
        int x=sc.nextInt(); // x is the choice of user
        switch(x)
        {
            case 1:
                newuser();//calls new user method
                break;

            case 2:
                existingUser();//calls existing user method
                break;
                default:
                    System.out.println("Wrong choice was selected");//if user enters other digits   
                    System.exit(0);
                    break;
        }
    }

    //new user
    
    void newuser()
    {   
        try
        {   Scanner sc=new Scanner(System.in);
            FileWriter fw=new FileWriter("movie_userid.txt",true);//text file where all user id's and password are stored
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
            {   String checker=id+":"+pass;
                if(s.equals(checker))
                {
                    System.out.println("User already exists");
                    System.exit(0);
                }
                s=br.readLine();
            }
            br.close();
            fr.close();

            pw.println(id+":"+pass);//username and password seperated by : so that later it can be splitted for checking in file
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
            fw.close();//when FileReader is called for first time, the file is not created so it shows exception. So FileWriter used to create file at first iteration
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
                if(s==null)//if userid is not found in the entire text file
                {
                    System.out.println("UserId or Password incorrect");
                    System.exit(0);
                }

                String[] words=s.split(":");

                if(words[0].equals(id1) && words[1].equals(pass1))//if userid is found then checking for validity 
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
        for(int i=0;i<3;i++)//for royal recliner part
        {
            x=1;
            for(int j=0;j<12;j++)
            {
                if(j==0)        
                    a[i][j]=""+ch;//seat alphabet storage
                else if(j>2 && j<10)//to adjust with the layout of hall
                {
                    a[i][j]=""+x;//digit printing
                    x++; 
                } 
                else a[i][j]="";//to adjust with layout
            }
            ch--;//alphabet decreases as matrix goes down
        }
        for(int i=3;i<7;i++)//for executive section
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

        for(int i=7;i<10;i++)//for normal section
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

    String seatno[];//to store seat numbers entered by user 

    void onboarding(String path){
        try
        {   FileWriter fw2=new FileWriter(path,true);//for avoiding exception in FileReader at first iteration
            Print();//prints layout of the theatre
            System.out.println("\n\t\t\t* Represents Booked Seats\n");
            fw2.close();
            Scanner sc=new Scanner(System.in);
            System.out.println("\n\nEnter number of Seats to be Booked:");
            int no=sc.nextInt();
            seatno=new String[no]; int x=0;
            for(int i=1;i<=no;)//loop continues till user enters desired number of seats    
            {
                System.out.println("\nEnter Seat Alphabet and Number:\n Example: A1\n");
                String s=sc.next();
                String p=""+s.charAt(0);//alphabet seperated from the seat digit
                p=p.toUpperCase();
                String q=s.substring(1);  int fl2=0; int fl1=0;
                int qcopy=Integer.parseInt(q); //use for check of seat so user does not input wrong choice
                String checkNumberOfSeats="ABCJIH";//the alphabets where 7 seats available not 11
                int numberOfSeats=0;
                if(checkNumberOfSeats.indexOf(p)!=-1)
                    numberOfSeats=7;
                else
                    numberOfSeats=11
                    ;

                if(qcopy>numberOfSeats||qcopy<=0)//if invalid seat digit is given   
                    System.out.println("Entered Seat Does Not Exist");
                else
                {
                    for(int j=0;j<10;j++)
                    {   
                        check(path);//so that we have the matrix with all the updates to the occupied seats   
                        if(a[j][0].equals(p))//if alphabet is valid
                        {
                            for(int k=0;k<12;k++)
                            {
                                if(a[j][k].equals(q))//if digit is valid and available(not occupied)
                                {   FileWriter fw=new FileWriter(path,true);
                                    BufferedWriter bw=new BufferedWriter(fw);
                                    PrintWriter pw=new PrintWriter(bw);
                                    seatno[x++]=s;//enters seats entered by user in an array to print in Bill Payment section
                                    pw.print(s+" ");//enters seat detail in file so that it can be updated in check()
                                    i++;fl1=1;
                                    pw.close();

                                }

                            }
                            fl2=1;
                            if(fl1==0) System.out.println("Seat Already Occupied, Kindly Choose an Empty Seat");
                            else
                            {   
                                break;

                            }
                        }

                    }

                    if(fl2==0) System.out.println("Entered Seat Does Not Exist");
                }
            }
            System.out.println("Press\n 1. To view Payment Bill \n 2. To Order Food Items");
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
            CreateMatrix();//matrix is created  
            FileReader fr=new FileReader(path);
            BufferedReader br=new BufferedReader(fr);
            String s=br.readLine();//reads the entire sentence consisting of all seats occupied 

            if(s!=null)//if it is not first iteration
            { 
                String splitted[]=s.split(" ");//splits all the seats in an array for ease of checking

                for(int i=0;i<splitted.length;i++)
                {   
                    String x=splitted[i];
                    String p= (""+x.charAt(0)).toUpperCase();//alphabet
                    String q=x.substring(1);//digit 
                    for(int j=0;j<10;j++)
                    { 
                        if(a[j][0].equals(p))
                        {
                            for(int k=0;k<12;k++)
                                if(a[j][k].equals(q))
                                    a[j][k]="*";//booked seats replaced by an asterisk sign
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

    void Print()//for printing the layout of the movie theatre
    {
        check(path);//so that all asterisks get printed
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

    void BillPrint(String path1)//prints the bill for user
    {
        try{
            FileWriter fw=new FileWriter(path1,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            System.out.println("\n\n\n\t\t\t\t\t_______Payment Bill_______");int sum=0;
            System.out.println("\n\t\t\t\tName of customer: "+name);pw.print(name+" ");
            String movieName=path.substring(0,(path.indexOf("_")));

            String movieTime= path.substring((path.indexOf("_"))+1,(path.lastIndexOf("_")));
            movieTime=movieTime.replace("_", ":");
            System.out.println("\n\t\t\t\tMovie Name: "+movieName);pw.print(movieName+" ");
            System.out.println("\n\t\t\t\tShow Timing: "+movieTime);pw.print(movieTime+" ");
            System.out.print("\n\t\t\t\tSeats Occupied: ");
            for(int i=0;i<seatno.length;i++)//loop for calculating the sum of tickets
            {
                char p=seatno[i].charAt(0);//alphabet seperation
                if(p<='C') sum+=200;
                else if(p<='G') sum+=300;
                else sum+=550;
                System.out.print(seatno[i].toUpperCase()+" ");pw.print(seatno[i].toUpperCase()+" ");
            }
            System.out.println();
            System.out.println("\n\t\t\t\tTotal Cost Of Seats: "+sum+".00");
            if(foodCost!=0)
            { 
                sum+=foodCost;System.out.println("\n\t\t\t\tCost of Food: "+foodCost);
            }
            //tax calculations
            double tax,finalSum; 
            tax= (0.18*sum);
            finalSum= sum+tax;
            System.out.print("\n\t\t\t\tTax Amount: Rs. ");
            System.out.printf("%.2f",tax);
            System.out.println();
            pw.print(finalSum+" ");
            System.out.print("\n\t\t\t\tTotal Amount To Be Paid: ");
            System.out.printf("%.2f",finalSum);
            System.out.println();
            System.out.println("\n\t\t\t\t\t________ENJOY YOUR SHOW!!________");
            pw.println();
            pw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    

    void Food(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Press\n 1. For Popcorn \n 2. For Cold Drinks\n");
        int opt=sc.nextInt();
        switch(opt){
            case 1: System.out.println("Press\n 1. For Small Rs.  90\n 2. For Medium Rs. 120\n 3. For Large Rs. 150");
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
            case 2: System.out.println("Press\n 1. For Small Rs.  40\n 2. For Medium Rs. 60\n 3. For Large Rs. 70");
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

}//end of class