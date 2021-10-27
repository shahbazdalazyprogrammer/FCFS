package implementingfcfs;
import java.util.*;
public class Process implements Comparable<Process>{
    String ProcessName;
    int bt;
    int at;
    Process(String pn,int b,int a) {
        ProcessName = pn;
        bt = b;
        at = a;
    }
    public static void main(String[] args) {
        int j=0,k=0,s=0;
        int [] timeline = new int [100];
        int [] turnaround = new int [100];
        double att = 0;
        Scanner scn = new Scanner(System.in);   
        ArrayList <Process> ProcessInfo = new ArrayList ();
        
        while(true){ 
            System.out.println("how many processes do you want to input?");
            int n = scn.nextInt();
            for(int i = 0 ; i < n; i++){
                System.out.println("What is the name of the process?");
                String nm = scn.next();
                System.out.println("What is the burst time of the process?");
                int bt1 = scn.nextInt();
                System.out.println("What is the arrival time of the process?");
                int at1 = scn.nextInt();
                Process [] p = new Process[1000];
                p[k] = new Process(nm,bt1,at1);
                ProcessInfo.add(p[k]);            }
            Collections.sort(ProcessInfo);
            s = ProcessInfo.size();
            System.out.println(""+s);
            for(Process b:ProcessInfo){
               if(j == 0){
                   timeline[j] = b.at+b.bt;
                   turnaround[j] = timeline[j] - b.at;
                   att = att + turnaround[j];
                   //System.out.print("J="+j+" "+b.at+"-"+timeline[j] );
                   //System.out.println("\tTurnaround= "+turnaround[j]);
                   j++;
               }
               else{
                  
                   if(j < s){
                       timeline[j] = timeline[j-1] + ProcessInfo.get(j).bt;
                       turnaround[j] = timeline[j] - ProcessInfo.get(j).at;
                       att = att + turnaround[j];
                       //System.out.print("J="+j+" "+timeline[j-1]+"-"+timeline [j]);
                       //System.out.println("\tTurnaround= "+turnaround[j]);
                       j++;
                       /*if(s==j)
                       {
                       
                       }*/
                   }
               }
                
            }
            System.out.printf("\t Seq.NO \tProcess Name \tTimeline \tTurnaround time\n");
            int seqno=0;
            for(Process o : ProcessInfo){
                
                if(seqno==0){
                    System.out.print("\t "+seqno);
                    System.out.print("\t\t "+o.ProcessName);
                    System.out.print("\t\t "+o.at+"-"+timeline[seqno]);
                    System.out.println("\t\t "+turnaround[seqno]);
                    seqno++;
                }
                else{
                    System.out.print("\t "+seqno);
                    System.out.print("\t\t "+o.ProcessName);
                    System.out.print("\t\t "+timeline[seqno-1]+"-"+timeline[seqno]);
                    System.out.println("\t\t "+turnaround[seqno]);    
                    seqno++;
                }
            }
            System.out.println("\tA.T.T = "+att/s);
        }
    }

    @Override
    public int compareTo(Process t) {
        if(this.at > t.at) return 1;
        else if(this.at < t.at) return -1;
        else return 0;
    }
    
}

























                //System.out.printf("\t %d\t\t %s \t\t %d",sn,c.ProcessName,c.bt-c.at);
                
                /*if(j == 0){
                    int f = c.at + c.bt;
                    timeline[j] = f;
                    System.out.println("J="+j+" "+c.at+"-"+timeline[j] );
                    j++;
                }
                else
                {   
                    //System.out.println(""+timeline[j-1]);
                    timeline[j] = timeline[j-1] + c.bt;
                    System.out.println("J="+j+" "+timeline[j-1]+"-"+timeline [j]);
                    j++;   
                }*/
            