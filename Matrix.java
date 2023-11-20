import java.io.*;
class Matrix{
    String a[][]=new String[10][12];
    void CreateMatrix(){
        char ch='J'; int b=1; int x;
        for(int i=0;i<3;i++){
            x=1;
            for(int j=0;j<12;j++){
                if(j==0)        
                    a[i][j]=""+ch;
                else if(j>2 && j<10){
                    a[i][j]=""+x;
                    x++; } 
                else a[i][j]="";
            }
            ch--;
        }
        for(int i=3;i<7;i++){
            x=1;
            for(int j=0;j<12;j++){
                if(j==0)
                    a[i][j]=""+ch;
                else{
                    a[i][j]=""+x;
                    x++;
                }
            }
            ch--;
        }

        for(int i=7;i<10;i++){
            x=1;
            for(int j=0;j<12;j++){
                if(j==0)
                    a[i][j]=""+ch;
                else if(j>2 && j<10){
                    a[i][j]=""+x;
                    x++; } 
                else a[i][j]="";
            }
            ch--;
        }
    }

    void MatrixDatabase(){
        try{
            FileWriter fw=new FileWriter("Matrix.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            for(int i=0;i<10;i++){

                for(int j=0;j<12;j++){
                    if(j==3 || j==10) {pw.print("\t\t");}
                    pw.print(a[i][j]+"   ");}
                pw.println();
            }
            pw.close();}
        catch(Exception e){
            System.out.println(e);
        }
    }

    void PrintMatrix(){
        try{
            FileReader fr=new FileReader("Matrix.txt");
            BufferedReader br=new BufferedReader(fr);
            for(int i=0;i<10;i++){
                if(i==3){
                    System.out.println("ROYAL RECLINER: Rs. 550"); System.out.println();
                }
                if(i==7){
                    System.out.println("EXECUTIVE: Rs. 300"); System.out.println();
                }
                System.out.print(br.readLine());
                System.out.println();System.out.println();
            }
            System.out.println("NORMAL: Rs. 200");

            System.out.println("\n\n\t\t\t ALL EYES HERE PLEASE!!!");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    void Choice(){
        CreateMatrix(); //later do it via object creation
        java.util.Scanner sc=new java.util.Scanner(System.in);
        System.out.println("Enter number of seats:");
        int no=sc.nextInt(); int k=1;
        while(k<=no){
            System.out.println("Enter seat alphabet");
            char s=sc.next().charAt(0);
            System.out.println("Enter seat number");
            int m=sc.nextInt(); int fl1=0,fl2=0; //fl1 for seat occupied fl2 for invalid choice
            for(int i=0;i<10;i++){
                if(a[i][0].equals(""+s))
                {   fl2=1;
                    for(int j=0;j<12;j++){
                        if(a[i][j].equals(""+m))
                        { a[i][j]="*";k++;
                            fl1=1;
                        }

                    }
                    if(fl1==0)
                        System.out.println("Seat occupied, please choose another seat");
                }

            }
            if(fl2==0)
                System.out.println("Invalid choice. Please choose within range");
        }
        MatrixDatabase();
    }
}