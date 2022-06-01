/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

// int QuerryNo;
/**
 *
 * @author Rathvsm
 */
public class UniversityFrontEnd extends javax.swing.JFrame 
{
    String query;
    int QueryNo; //It stores the Query No. Selected
   String header[] = new String[10]; //Giving some Large Number
   // String header[];
    
DefaultTableModel dtm = new DefaultTableModel(0, 0);
    /**
     * Creates new form UniversityFrontEnd
     */
    public UniversityFrontEnd() {
        initComponents();
       
        // TODO code application logic here
        
        //Intitial Setting
         jTextField1.setText("List the contents of Course Table\n");
                query = "Select * from courses";
                QueryNo=1; //To initialise columns etc while executing since we are not going through Combobox
               // query= "select a.Id, a.Name, b.Name from courses a, department b where a.ByDept=b.id";
                
      //  DefaultTableModel dtm = new DefaultTableModel(0, 0);
        /*
         jTextField1.setText("The Courses with details like duration\n"
                + "min Qualification Required, date of commencement and total \n"
                + "No. of vacancies; those are offered by the Uty");
        String query = "SELECT a.cid, a.cname,a.cdurmonths,a.doc, b.name,c.name \n"
+ "from course as a, qualification as b, department as c \n"
+ "where a.MinQualId=b.QId and a.DepId= c.DId";
        */
// ExecuteQuery1();
    }//University Front End
        // TODO code application logic here
    /*
     ExecuteQuery1() 
     {
        try{
                       System.out.println("Rath.......... ");  //load and register the driver
           
	// Connection  con= DriverManager.getConnection ("jdbc:mysql://localhost:3306/professor","root","ruas");  //establish the connection
                         //  Connection  con= DriverManager.getConnection ("jdbc:mysql://localhost:3306/rathvsm","root","ruas");  //establish the connection
            Connection  con= DriverManager.getConnection ("jdbc:mysql://localhost:3306/university","root","ruas");  //establish the connection
                           System.out.println("Rath..........2 "); 
		Statement st=con.createStatement();  // create statement object
     	System.out.println("Rath..........3 ");
      
	
        ResultSet rs1=st.executeQuery(query);   //execute the query
         
             PutRsInTable (rs1);         
            // System.out.println(name);
           // }
             System.out.println("Rath...........");

             st.close();
             con.close();   //close the connection
        }// End of Try
        catch (Exception e)
        {
            System.out.println("Rath Exceptions...........");
        }// End of Catch
    }//Execute Query 1
*/
    //Putting Data in table 10 Oct 2021
    private void PutRsInTable (ResultSet rs1)
    {
           //String header[] = new String[3];
       //  dtm.getDataVector().clear(); //to clear the table, Doe not work
        dtm.getDataVector().removeAllElements(); //Clear the table
            try
            {
                
                switch (QueryNo){
                    
                    case 1: //See the details of Course Table
                        // header =  new String[]{ "Course Id", "Course Name", "Offered by Dept"};
                            header = new String[]{ "Course Id", "Course Name", "Offered by Dept"};
                         break;
                         
                    case 2: //See the Details of Dept Table
                       header =  new String[]{ "Dept Id", "Dept Name", "Location"};
                        break;
                        
                    case 3: //Show the Courses which are undrtaken by CSE Dept
                        header =  new String[]{ "Dept", "Course"};
                        
                                                                   
                    
                }// End of Switch
                 System.out.println(header);
    // create object of table and table model
                // JTable1 tbl = new JTable1();
                 // DefaultTableModel dtm = new DefaultTableModel(0, 0);

                // add header of the table
                //String header[] = new String[] { "Course Id", "Course Name", "Offered by Dept",
                    //"DoC", "Min Qual", "Department" };
                 //jTable1.setColumnModel(dtm);
                 // add header in table model     
                dtm.setColumnIdentifiers(header);
                //set model into the table object
                //tbl.setModel(dtm);
                 jTable1.setModel(dtm);
                 // add row dynamically into the table      
              /*
                    while(rs1.next() )   //!=NULL) doesnot work. next () Moves the pointer to the next
                    {
                        
                        dtm.addRow(new Object[] { rs1.getString(1), rs1.getString(2), 
                        rs1.getString(3), rs1.getDate(4), rs1.getString(5), rs1.getString(6) });
                        rs1.next();
                        
                       
                    }
            */
              switch (QueryNo){
                  case 1: //Course Table
                      while(rs1.next()) //The the Result Set rs1 reaches the Bottom
                       {
             		//String name=rs1.getString(1) + "  " + rs1.getString(2) + 
                               // "  " + rs1.getString(3);    // + "  " + rs.getDate(4)+"  " + rs.getString(5) +
                                // "  " + rs.getString(6);     //process the result
             		// System.out.println(name);
                        dtm.addRow(new Object[] { rs1.getString(1), rs1.getString(2), rs1.getString(3)});
                         //, rs.getDate(4), rs.getString(5), rs.getString(6) );
                    }
                      break;
                      
                      
                  case 2: //Department
                      while(rs1.next())
                       {
             		//String name=rs1.getString(1) + "  " + rs1.getString(2) + 
                               // "  " + rs1.getString(3);    // + "  " + rs.getDate(4)+"  " + rs.getString(5) +
                                // "  " + rs.getString(6);     //process the result
             		// System.out.println(name);
                        dtm.addRow(new Object[] { rs1.getString(1), rs1.getString(2), rs1.getString(3)});
                         //, rs.getDate(4), rs.getString(5), rs.getString(6) );
	}
                      break;
                      
                  case 3: //Courses Offered by CSE Dept
                      while(rs1.next())
                       {
             		//String name=rs1.getString(1) + "  " + rs1.getString(2) + 
                               // "  " + rs1.getString(3);    // + "  " + rs.getDate(4)+"  " + rs.getString(5) +
                                // "  " + rs.getString(6);     //process the result
             		// System.out.println(name);
                        dtm.addRow(new Object[] { rs1.getString(1), rs1.getString(2)});
                         //, rs.getDate(4), rs.getString(5), rs.getString(6) );
	}
                      break;
                      
                  
              }//End Switch for Display of Data
              while(rs1.next())
                       {
             		//String name=rs1.getString(1) + "  " + rs1.getString(2) + 
                                //"  " + rs1.getString(3);    // + "  " + rs.getDate(4)+"  " + rs.getString(5) +
                                // "  " + rs.getString(6);     //process the result
             		// System.out.println(name);
                        dtm.addRow(new Object[] { rs1.getString(1), rs1.getString(2)});
                         //, rs.getDate(4), rs.getString(5), rs.getString(6) );
	}
                    
                    
                        //dtm.addRow(rs1);
               //  }//for
            }//try
            catch (Exception e)
           {
               System.out.println("Rath End Exceptions in Table Model******...........");
           }
                        
                    
 
    } //End of PutRsInTable
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        EditUnivDB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("UniversityFrame"); // NOI18N
        setUndecorated(true);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 255));
        jButton1.setText("Exit");
        jButton1.setToolTipText("");
        jButton1.setName("Exit"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("University Database");
        jLabel1.setToolTipText("");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Query 1", "Query 2", "Query 3", "Uma" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");
        jTextField1.setSelectedTextColor(new java.awt.Color(51, 51, 255));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Execute");
        jButton2.setToolTipText("");
        jButton2.setName("BtnExecute"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        EditUnivDB.setText("Edit University DB");
        EditUnivDB.setToolTipText("");
        EditUnivDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditUnivDBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jTextField1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(EditUnivDB)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(EditUnivDB)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(29, 29, 29)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
   if  (jComboBox1.getSelectedItem() =="Query 1")       
        {
        // TODO add your handling code here:
            /*
        jTextField1.setText("The Courses with details like duration\n"
                + "min Qualification Required, date of commencement and total \n"
                + "No. of vacancies; those are offered by the Uty");
            
        
        query = "SELECT a.cid, a.cname,a.cdurmonths,a.doc, b.name,c.name \n"
+ "from course as a, qualification as b, department as c \n"
+ "where a.MinQualId=b.QId and a.DepId= c.DId";
            */
            
              jTextField1.setText("List the contents of Course Table\n");
              query="select * from courses";
              QueryNo=1;
             // String header[] = new String[] { "Course Id", "Course Name", "Offered by Dept"};
                    
               // query = "Select * from courses"; // Working
               // query= "select a.Id, a.Name, b.Name from courses a, department b where a.ByDept=b.id";
        
        }// End of if
   
   if  (jComboBox1.getSelectedItem() =="Query 2")       
        {
        // TODO add your handling code here:
        jTextField1.setText("List the Conents of the Department Table");
        //QueryNo = 2;
        query= "select * from Department";
        QueryNo=2;
       // String header[] = new String[] { "Dept Id", "Dept Name", "Location"};
                     
        
                
        }// End of if
   if  (jComboBox1.getSelectedItem() =="Query 3")       
        {
        // TODO add your handling code here:
        jTextField1.setText("List the Course Details which are handled by CSE Dept");
        query = "select d.name as Dept, c.name as Course from Department d, courses c where c.ByDept = d.Id and d.name = 'CSE'";
               QueryNo=3; 
        }// End of if
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //Execute Button
        
        //switch (QueryNo) {
        
         try{
	 System.out.println("\nComing to try ....");
         
                        Class.forName("com.mysql.jdbc.Driver");  //load and register the driver
                        
                        System.out.println("\nComing out after Registration");
                        
                       //  Connection  con= DriverManager.getConnection ("jdbc:mysql://localhost:3306/rathvsm2020","root","ruas");  //establish the connection
                        System.out.println("\nComing out after Connection");
	Connection  con= DriverManager.getConnection ("jdbc:mysql://localhost:3306/university","root","root");  //establish the connection
                        Statement st=con.createStatement();  // create statement object
     	// query = "Select * from courses";
                       // query = "ïnsert into course values (jTextFiled1.text, .....);"
                            //   st.executeUpdate(query);
	// ResultSet rs=st.executeQuery("Select * from course");   //execute the query
                        ResultSet rs=st.executeQuery(query);
        PutRsInTable (rs); //Function call for putting the Result Set in the Table
        /*
                       while(rs.next())
                       {
             		String name=rs.getString(1) + "  " + rs.getString(2) + 
                                "  " + rs.getString(3);    // + "  " + rs.getDate(4)+"  " + rs.getString(5) +
                                // "  " + rs.getString(6);     //process the result
             		// System.out.println(name);
                        dtm.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3)});
                         //, rs.getDate(4), rs.getString(5), rs.getString(6) );
	}
                       */
                      //  System.out.println(name);
                        con.close();   //close the connection
                        st.close();
                       // PutRsInTable (rs);
             }//End of try
            catch (Exception e)
            {
                System.out.println("Error !!!");
            }
        //} //End of switch  
    }//GEN-LAST:event_jButton2ActionPerformed

    //Edit UnivDataBase Button
    private void EditUnivDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditUnivDBActionPerformed
        // TODO add your handling code here:
         EditUnivDB form = new EditUnivDB();
        form.setVisible(true);
    }//GEN-LAST:event_EditUnivDBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UniversityFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UniversityFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UniversityFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UniversityFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UniversityFrontEnd().setVisible(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditUnivDB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
