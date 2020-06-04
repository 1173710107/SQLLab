package lab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
 
public class JframeMain extends JFrame{
  JButton btn1=new JButton("重置");
  JButton btn2=new JButton("查询");
  JLabel label0 = new JLabel("   ",  SwingConstants.LEFT); 
  JLabel label9 = new JLabel("   ",  SwingConstants.LEFT); 
  JLabel label10 = new JLabel("  ",  SwingConstants.LEFT); 
  JLabel label11 = new JLabel("  ",  SwingConstants.LEFT); 
  JLabel label1 = new JLabel("学号",  SwingConstants.LEFT); 
  JLabel label2 = new JLabel("姓名",  SwingConstants.LEFT); 
  JLabel label3 = new JLabel("性别",  SwingConstants.LEFT); 
  JLabel label4 = new JLabel("年龄",  SwingConstants.LEFT); 
  JLabel label5 = new JLabel("-",  SwingConstants.LEFT); 
  JLabel label6 = new JLabel("班级",  SwingConstants.LEFT); 
  JLabel label7 = new JLabel("地址",  SwingConstants.LEFT); 
  JLabel label8 = new JLabel("系别",  SwingConstants.LEFT); 
  
  //创建一个文本区域
  final JTextArea textArea = new JTextArea(1, 7);
  // 创建一个文本区域
  final JTextArea textArea0 = new JTextArea(1, 7);
  final JTextArea textArea1 = new JTextArea(1, 7);
  final JTextArea textArea2 = new JTextArea(1, 4);
  final JTextArea textArea3 = new JTextArea(1, 4);
  final JTextArea textArea4 = new JTextArea(1, 7);
  final JTextArea textArea5 = new JTextArea(1, 7);
  final JTextArea textArea6 = new JTextArea(1, 7);
  final JTextArea textArea7 = new JTextArea(2, 35);
  Object[][] tablelist1 = new Object[4000][10];
  Object[] list1 = {"学号","姓名","性别","系别","年龄","班级","地址"};
  JTable table1 =new JTable(tablelist1,list1);
  public String []columnNames={"病人ID","病人姓名","病人年龄","病人性别","出生日期","出生地","籍贯","情况","费用"};//定义数组
  private JScrollPane JScrollPane1=new JScrollPane();
  private static JTable table;
  private static  DefaultTableModel dtm;
  
  
  final JFrame jf = new JFrame("数据库查询软件");
    JframeMain(){
    	try {
    		  Class.forName("com.mysql.cj.jdbc.Driver");   //com.mysql.jdbc为驱动所在包
    	        String url="jdbc:mysql://localhost:3306/bootdo112?useUnicode=true&characterEcoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    	        String username="root";
    	        String password="123456";
    	        Connection conn=DriverManager.getConnection(url, username, password);
    	        
    	        
    	      
      
	   init();
	   jf.setTitle("数据库查询软件");
	   jf.setResizable(true);
	   jf.setSize(1000, 1200);
	   jf.setLocationRelativeTo(null);
	   jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   jf.setVisible(true);
	   btn1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("重置  被点击");
               textArea.setText("");
               textArea0.setText("");
               textArea1.setText("");
               textArea2.setText("");
               textArea3.setText("");
               textArea4.setText("");
               textArea5.setText("");
               textArea6.setText("");
               textArea7.setText("");
               int row = dtm.getRowCount() - 1;
      			if (row != -1) {
      				for (int i1 = row; i1 >= 0; i1--) {
      					dtm.removeRow(i1); // 删除Jtable中的所有行
      				}
      				dtm.setRowCount(0); // 将Jtable中的行数设为零
      			}	
           }
       });
	   btn2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("查询  被点击");
               int row = dtm.getRowCount() - 1;
   			if (row != -1) {
   				for (int i1 = row; i1 >= 0; i1--) {
   					dtm.removeRow(i1); // 删除Jtable中的所有行
   				}
   				dtm.setRowCount(0); // 将Jtable中的行数设为零
   			}	
               try {
            	   Statement sta=conn.createStatement();   //接收一定要用java里面的  导包导SQL里的
                   String sql="select * from student ";
                   boolean flag = false;
                   if(!textArea.getText().equals(""))
                   {
                	   //System.out.println("!!!"+textArea.getText()+"!!!!");
                	   flag = true;
                	   sql  = sql + " where id like '"+ textArea.getText()+"'";
                   }
                   if(!textArea0.getText().equals(""))
                   {
                	   if(flag)
                	   {
                    	   sql  = sql + " and name like '"+ textArea0.getText()+"'";
                	   }else {
                		   flag = true;
                    	   sql  = sql + " where name like '"+ textArea0.getText()+"'";
					}
                   }
                   if(!textArea1.getText().equals(""))
                   {
                	   if(flag)
                	   {
                    	   sql  = sql + " and sex like '"+ textArea1.getText()+"'";
                	   }else {
                		   flag = true;
                    	   sql  = sql + " where sex like '"+ textArea1.getText()+"'";
					}
                   }
                   if(!textArea4.getText().equals(""))
                   {
                	   if(flag)
                	   {
                    	   sql  = sql + " and class like '"+ textArea4.getText()+"'";
                	   }else {
                		   flag = true;
                    	   sql  = sql + " where class like '"+ textArea4.getText()+"'";
					}
                   }
                   if(!textArea5.getText().equals(""))
                   {
                	   if(flag)
                	   {
                    	   sql  = sql + " and address like '"+ textArea5.getText()+"'";
                	   }else {
                		   flag = true;
                    	   sql  = sql + " where address like '"+ textArea5.getText()+"'";
					}
                   }
                   if(!textArea6.getText().equals(""))
                   {
                	   if(flag)
                	   {
                    	   sql  = sql + " and dept like '"+ textArea6.getText()+"'";
                	   }else {
                		   flag = true;
                    	   sql  = sql + " where dept like '"+ textArea6.getText()+"'";
					}
                   }
                   if(!textArea2.getText().equals(""))
                   {
                	   if(flag)
                	   {
                    	   sql  = sql + " and age  >= "+ textArea2.getText();
                	   }else {
                		   flag = true;
                    	   sql  = sql + " where age >= "+ textArea2.getText();
					}
                   }
                   if(!textArea3.getText().equals(""))
                   {
                	   if(flag)
                	   {
                    	   sql  = sql + " and age <="+ textArea3.getText();
                	   }else {
                		   flag = true;
                    	   sql  = sql + " where age <="+ textArea3.getText();
					}
                   }
                  
                   textArea7.setText(sql);
						
						  ResultSet rs=sta.executeQuery(sql); 
						  while(rs.next()){
							  System.out.println(rs.getString("id"));
						  String [] date = new String[7];
			              	date[0] = rs.getString("id");
			              	date[1] = rs.getString("name");
			              	date[2] = rs.getString("sex");
			              	date[3] = rs.getString("dept");
			              	date[4] = rs.getString("age");
			              	date[5] = rs.getString("class");
			              	date[6] = rs.getString("address");
							dtm.addRow(date); // 在Jtable中添加
						  }
						 
                
              	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
                        }
       });
    	} catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
  }
  void init(){
	  Font font1=new Font("微软雅黑",Font.BOLD,25);
	  textArea.setFont(font1);
	  textArea0.setFont(font1);
	  textArea1.setFont(font1);
	  textArea2.setFont(font1);
	  textArea3.setFont(font1);
	  textArea4.setFont(font1);
	  textArea5.setFont(font1);
	  textArea6.setFont(font1);
	  textArea7.setFont(font1);
	  btn1.setPreferredSize(new Dimension(100,40));
	  btn2.setPreferredSize(new Dimension(100,40));
	  Font font = new Font("宋体", Font.PLAIN, 25);//创建1个字体实例
	  label1.setFont(font);//设置JLabel的字体
	  label1.setForeground(Color.BLACK);//设置文字的颜色
	  label2.setFont(font);//设置JLabel的字体
	  label2.setForeground(Color.BLACK);//设置文字的颜色
	  label3.setFont(font);//设置JLabel的字体
	  label3.setForeground(Color.BLACK);//设置文字的颜色
	  label4.setFont(font);//设置JLabel的字体
	  label4.setForeground(Color.BLACK);//设置文字的颜色
	  label5.setFont(font);//设置JLabel的字体
	  label5.setForeground(Color.BLACK);//设置文字的颜色
	  label6.setFont(font);//设置JLabel的字体
	  label6.setForeground(Color.BLACK);//设置文字的颜色
	  label7.setFont(font);//设置JLabel的字体
	  label7.setForeground(Color.BLACK);//设置文字的颜色
	  label8.setFont(font);//设置JLabel的字体
	  label8.setForeground(Color.BLACK);//设置文字的颜色
	  jf.setLayout(new FlowLayout(FlowLayout.LEFT,35,10)); //默认为居中;水平间距10，垂直间距5
   
      jf.add(label1);
      jf.add(textArea);
      jf.add(label2);
      jf.add(textArea0);
      jf.add(label3);
      jf.add(textArea1);
      jf.add(label0);
      jf.add(label6);
      jf.add(textArea4);
      jf.add(label7);
      jf.add(textArea5);
      jf.add(label8);
      jf.add(textArea6);
      jf.add(label9);
      jf.add(label4);
      jf.add(textArea2);
      jf.add(label5);
      jf.add(textArea3);
      jf.add(label10);
      jf.add(label11);
      jf.add(btn1);
      jf.add(btn2);
      jf.add(textArea7);
      //jf.add(new JScrollPane(table1));
      dtm=new DefaultTableModel(list1,0);  //添加首行元素数据
	  table=new JTable(dtm);
	   JScrollPane1.setBounds(new  Rectangle(0,50,1000,185));  //滚动条的创建
    	 jf.add(JScrollPane1);         //添加到面板上
    	JScrollPane1.setViewportView(table); 
    	table.setPreferredScrollableViewportSize(new Dimension(880, 500));
    	 table.setRowHeight(35);
  }
  public static void main(String args[]){
    new JframeMain();
  }
}