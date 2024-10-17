package it2b.teves.midterm;
import java.util.Scanner;


public class IT2BTEVESMIDTERM {
 config conf = new config();
   

    public static void main(String[] args) {
      
        String resp;
        Scanner sc = new Scanner(System.in);
    
      do{ 
          System.out.println("-------------------------------");
          System.out.println("| ATTENDANCE APPLICATION |");
          System.out.println("-------------------------------");
          System.out.println("1. ADD ");
          System.out.println("2. VIEW ");
          System.out.println("3. EDIT ");
          System.out.println("4. DELETE");
          System.out.println("5.EXIT");
          System.out.print("Enter choice: ");
              int choices = sc.nextInt();
    while(choices> 5){ 
        System.out.print("Invalid input try again : ");
        choices = sc.nextInt();
    }   IT2BTEVESMIDTERM md = new IT2BTEVESMIDTERM();
             
             switch(choices){
                 case 1:
                    md.addattendance();
                     break;
                 case 2:
                     md.viewattendance();
                     break;
                 case 3:
                     md.viewattendance();
                      md.Updateattendance();
                      md.viewattendance();
                     break;
                     
                 case 4:
                     md.viewattendance();
                     md.deleteattendance();
                     md.viewattendance();
                     break;
                  case 5:
                      
                     break;
                                              
             } 
        System.out.print("do another transaction(yes/no): ");
        resp = sc.next();
        }while(resp.equalsIgnoreCase("yes"));
      
       
    }
    public void addattendance(){
        Scanner sc = new Scanner(System.in);
        System.out.print("date: ");
        String date = sc.next();
        System.out.print("status: ");
        String status = sc.next();
        System.out.print("remark: ");
        String remark = sc.next();
        
       
        String sql = "INSERT INTO tbl_attendance (a_date, a_status, a_remark) VALUES (?, ?, ?)";
        conf.addRecord(sql, date, status, remark);
    }
    
    public void viewattendance() {
        String sqlQuery = "SELECT * FROM tbl_attendance";
        String[] columnHeaders = {"ID", "date", "status", "remark"};
        String[] columnNames = {"a_id", "a_date", "a_status","a_remark"};

        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }
    
    public void Updateattendance(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter attendance ID to edit: ");
        int id = sc.nextInt();
        sc.nextLine();
         
        System.out.print("New date: ");
        String date = sc.nextLine();
        System.out.print("New status: ");
        String status = sc.next();
       
        System.out.print("New remark: ");
        String remark = sc.next();
       
    
    String sql = "UPDATE tbl_attendance SET a_date = ?, a_status = ?,a_remark = ? WHERE a_id = ?";
    config conf = new config();
    conf.updateRecord(sql , date ,status,remark  , id);
    }
    
     public void deleteattendance(){
         Scanner sc = new Scanner(System.in);
          System.out.print("Enter attendance ID to delete: ");
        int id = sc.nextInt();
        
        String sql = "DELETE FROM tbl_attendance WHERE a_id = ?";
        config conf = new config();
        conf.deleteRecord(sql, id);
    }
}
