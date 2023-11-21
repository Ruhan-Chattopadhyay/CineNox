import java.util.*;
import java.io.*;
class FinalMatrix{
    String a[][]=new String[10][12];

    void CreateMatrix(){
        char ch='J'; int b=1; int x;
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

    void main()
    {   try
        {
            FileWriter fw=new FileWriter("LastStatus1.txt",true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter number of seats to be booked:");
            int no=sc.nextInt();
            for(int i=1;i<=no;)
            {
                System.out.println("Enter seat alphabet and number:");
                String s=sc.next();
                String p=""+s.charAt(0);
                String q=s.substring(1);  int fl2=0; int fl1=0;
                for(int j=0;j<10;j++)
                {
                    check();

                    if(a[j][0].equals(p))
                    {

                        for(int k=0;k<12;k++)
                        {
                            if(a[j][k].equals(q))
                            {

                                pw.print(s+" ");
                                i++;fl1=1;

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
            pw.close();
            Print();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void check(){

        try
        {
            CreateMatrix();
            FileReader fr=new FileReader("LastStatus1.txt");
            BufferedReader br=new BufferedReader(fr);
            String s=br.readLine();

            if(s!=null)
            { 
                String splitted[]=s.split(" ");

                for(int i=0;i<splitted.length;i++)
                {   
                    String x=splitted[i];
                    String p= ""+x.charAt(0);
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
        check();
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