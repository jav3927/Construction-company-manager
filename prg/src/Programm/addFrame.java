package Programm;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JComboBox;


public class addFrame {
    private static JFrame addFrame;
    private static JLabel label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10,
        label_11, label_12, label_13;
    private static JComboBox<String> comboBox1, comboBox2, comboBox3, comboBox4, comboBox5;   
    private static JTextField textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7,
        textField_8, textField_9, textField_10;
    static String[][] data1, data2, data3, data4, data5;
    static String id1, id2, id3, id4, id5, usQuery, Action, realQuery, Choise, Id;
    static ResultSet rs1;
    private static JButton requestButton;
    
    public static void createGUIAdd(String choise, String action, String id) {
        Action = action;
        Id = id;
        Choise = choise;
        addFrame = new JFrame();
        if(action.equals("redact")) {
            addFrame.setTitle("Редактирование " + choise);
        } else {
            addFrame.setTitle("Добавление " + choise);
        }
        addFrame.setBackground(new Color(0, 0, 255));
        addFrame.getContentPane().setBackground(Color.WHITE);
        addFrame.setResizable(false);
        addFrame.getContentPane().setLayout(null);
        //addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label_1 = new JLabel("Первый");
        label_1.setBounds(5, 0, 170, 20);
        addFrame.getContentPane().add(label_1);

        label_2 = new JLabel("Второй");
        label_2.setBounds(5, 40, 170, 20);
        addFrame.getContentPane().add(label_2);

        label_3 = new JLabel("Третий");
        label_3.setBounds(5, 80, 170, 20);
        addFrame.getContentPane().add(label_3);

        label_4 = new JLabel("Четвертый");
        label_4.setBounds(5, 120, 170, 20);
        addFrame.getContentPane().add(label_4);

        label_5 = new JLabel("Пятый");
        label_5.setBounds(5, 160, 170, 20);
        addFrame.getContentPane().add(label_5);

        label_6 = new JLabel("Шестой");
        label_6.setBounds(205, 0, 170, 20);
        addFrame.getContentPane().add(label_6);
        
        label_7 = new JLabel("Седьмой");
        label_7.setBounds(205, 40, 170, 20);
        addFrame.getContentPane().add(label_7);

        label_8 = new JLabel("Восьмой");
        label_8.setBounds(205, 80, 170, 20);
        addFrame.getContentPane().add(label_8);

        label_9 = new JLabel("Девятый");
        label_9.setBounds(205, 120, 170, 20);
        addFrame.getContentPane().add(label_9);

        label_10 = new JLabel("Десятый");
        label_10.setBounds(205, 160, 170, 20);
        addFrame.getContentPane().add(label_10);
        
        label_11 = new JLabel("Одинадцатый");
        label_11.setBounds(5, 200, 150, 20);
        addFrame.getContentPane().add(label_11);
        
        label_12 = new JLabel("Двенадцатый");
        label_12.setBounds(205, 200, 150, 20);
        addFrame.getContentPane().add(label_12);
        
        label_13 = new JLabel("Тринадцатый");
        label_13.setBounds(5, 240, 150, 20);
        addFrame.getContentPane().add(label_13);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(5, 20, 183, 20);
        addFrame.getContentPane().add(textField_1);        

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(5, 60, 183, 20);
        addFrame.getContentPane().add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(5, 100, 183, 20);
        addFrame.getContentPane().add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(5, 140, 183, 20);
        addFrame.getContentPane().add(textField_4);        

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(5, 180, 183, 20);
        addFrame.getContentPane().add(textField_5);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(205, 20, 175, 20);
        addFrame.getContentPane().add(textField_6);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(205, 60, 175, 20);
        addFrame.getContentPane().add(textField_7);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(205, 100, 175, 20);
        addFrame.getContentPane().add(textField_8);        

        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(205, 140, 175, 20);
        addFrame.getContentPane().add(textField_9);
        
        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(205, 180, 175, 20);
        addFrame.getContentPane().add(textField_10);
        
        comboBox1 = new JComboBox<String>();
        comboBox1.setBounds(5, 20, 182, 20);
        addFrame.getContentPane().add(comboBox1);
        
        comboBox2 = new JComboBox<String>();
        comboBox2.setBounds(5, 60, 182, 20);
        addFrame.getContentPane().add(comboBox2);
        
        comboBox3 = new JComboBox<String>();
        comboBox3.setBounds(5, 100, 182, 20);
        addFrame.getContentPane().add(comboBox3);
        
        comboBox4 = new JComboBox<String>();
        comboBox4.setBounds(5, 140, 182, 20);
        addFrame.getContentPane().add(comboBox4);
        
        comboBox5 = new JComboBox<String>();
        comboBox5.setBounds(5, 180, 182, 20);
        addFrame.getContentPane().add(comboBox5);
        
        requestButton = new JButton("Добавить");
        if(action.equals("redact")) {
            requestButton.setText("Отредактировать");
        } else {
            requestButton.setText("Добавить");
        }
        requestButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                switch (choise) {
                    case "Objects":
                        textFieldColor(6);textFieldColor(7);textFieldColor(8);
                        if (textField_6.getText().length() == 0 || textField_7.getText().length() == 0 || 
                            textField_8.getText().length() == 0) {
                          JOptionPane.showMessageDialog(addFrame, "Не все обязательные поля заполнены.", "Ошибка добавления",
                                  JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            id1 = getId(data1, (String)comboBox1.getSelectedItem());
                            id2 = getId(data2, (String)comboBox2.getSelectedItem());
                            id3 = getId(data3, (String)comboBox3.getSelectedItem());
                            id4 = getId(data4, (String)comboBox4.getSelectedItem());
                            if(action.equals("redact")) {
                                usQuery = "exec updateObjects \'"+id+"\',\'"+id1+"\',\'"+id2+"\',\'"+id3+"\',\'"+id4+"\'"
                                        + ",\'"+textField_6.getText()+"\',\'"+textField_7.getText()+"\',\'"+textField_8.getText()+"\'";
                                System.out.println(usQuery);
                                insRedRem(usQuery);    
                            } else {
                                usQuery = "insert into Objects values(newId(),\'" + textField_6.getText() + "\',\'" + id1
                                        + "\',\'" + id2 + "\',\'" + id3 + "\',\'" + textField_7.getText() + "\',\'" +
                                        textField_8.getText() + "\',\'" + id4 + "\')";
                                System.out.println(usQuery);
                                insRedRem(usQuery);   
                            }                            
                        }
                    redact.update();
                    break;
                    case "Estimates":
                        textFieldColor(1);textFieldColor(2);textFieldColor(3);
                        if (textField_1.getText().length() == 0 || textField_2.getText().length() == 0 || 
                            textField_3.getText().length() == 0) {
                          JOptionPane.showMessageDialog(addFrame, "Не все обязательные поля заполнены.", "Ошибка добавления",
                                  JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            id1 = getId(data1, (String)comboBox1.getSelectedItem());
                            if(action.equals("redact")) {
                                usQuery = "exec updateEstimate \'"+id1+"\',\'"+textField_1.getText()+"\',\'"+
                                        textField_2.getText()+"\',"+textField_3.getText() +",\'"+id+"\'";
                                System.out.println(usQuery);
                                insRedRem(usQuery);    
                            } else {
                                usQuery = "exec InsertNewEstimate \'"+id1+"\',\'"+textField_1.getText()+"\',\'"+
                                        textField_2.getText()+"\',"+textField_3.getText();
                                System.out.println(usQuery);
                                insRedRem(usQuery);    
                            }                        
                        }
                    redact.update();
                    break;
                    case "Acts":
                        textFieldColor(1);textFieldColor(2);textFieldColor(3);
                        if (textField_1.getText().length() == 0 || textField_2.getText().length() == 0 || 
                            textField_3.getText().length() == 0) {
                          JOptionPane.showMessageDialog(addFrame, "Не все обязательные поля заполнены.", "Ошибка добавления",
                                  JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            id1 = getId(data1, (String)comboBox1.getSelectedItem());
                            if(action.equals("redact")) {
                                usQuery = "exec updateAct \'"+id1+"\',\'"+textField_1.getText()+"\',\'"+
                                        textField_2.getText()+"\',"+textField_3.getText() + ",\'"+id+"\'";
                                System.out.println(usQuery);
                                insRedRem(usQuery);    
                            } else {
                                usQuery = "exec InsertNewAct \'"+id1+"\',\'"+textField_1.getText()+"\',\'"+
                                        textField_2.getText()+"\',"+textField_3.getText();
                                System.out.println(usQuery);
                                insRedRem(usQuery);    
                            }                            
                        }
                    redact.update(); 
                    break;
                    case "Contracts":
                        textFieldColor(1);textFieldColor(2);textFieldColor(3);textFieldColor(4);
                        if (textField_1.getText().length() == 0 || textField_2.getText().length() == 0 || 
                            textField_3.getText().length() == 0 || textField_4.getText().length() == 0) {
                            JOptionPane.showMessageDialog(addFrame, "Не все обязательные поля заполнены.", "Ошибка добавления",
                                  JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        id1 = getId(data1, (String)comboBox1.getSelectedItem());
                        if(action.equals("redact")) {
                            usQuery = "exec UpdateContract \'"+id1+"\',\'"+textField_1.getText()+"\',\'"+
                                    textField_2.getText()+"\',\'"+textField_3.getText() + "\',\'" + textField_4.getText()
                                    +"\',\'"+id+"\'";
                            System.out.println(usQuery);
                            insRedRem(usQuery);        
                        } else {
                            usQuery = "exec InsertNewContract \'"+id1+"\',\'"+textField_1.getText()+"\',\'"+
                                    textField_2.getText()+"\',\'"+textField_3.getText() + "\'," + textField_4.getText();
                            System.out.println(usQuery);
                            insRedRem(usQuery);        
                        }                
                    }
                        redact.update(); 
                    break;
                    case "Materials":
                        textFieldColor(1);textFieldColor(2);textFieldColor(3);
                        if (textField_1.getText().length() == 0 || textField_2.getText().length() == 0 || 
                            textField_3.getText().length() == 0) {
                            JOptionPane.showMessageDialog(addFrame, "Не все обязательные поля заполнены.", "Ошибка добавления",
                                  JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            if(action.equals("redact")) {
                                usQuery = "exec updateMaterial \'"+id+"\',\'"+textField_1.getText()+"\',\'"+
                                        textField_2.getText()+"\',"+textField_3.getText();            
                                System.out.println(usQuery);
                                insRedRem(usQuery);
                            } else {
                                usQuery = "exec InsertNewMaterial \'"+textField_1.getText()+"\',\'"+
                                        textField_2.getText()+"\',\'"+textField_3.getText()+"\'";            
                                System.out.println(usQuery);
                                insRedRem(usQuery);
                            }                     
                        }
                    redact.update(); 
                    break;
                    case "Employee":
                        textFieldColor(1);textFieldColor(2);textFieldColor(3);textFieldColor(4);
                        textFieldColor(6);textFieldColor(7);textFieldColor(3);textFieldColor(8);
                        textFieldColor(9);textFieldColor(10);
                        if (textField_1.getText().length() == 0 || textField_2.getText().length() == 0 || 
                            textField_3.getText().length() == 0 || textField_4.getText().length() == 0 ||
                            textField_6.getText().length() == 0 || textField_7.getText().length() == 0 || 
                            textField_8.getText().length() == 0 || textField_9.getText().length() == 0 || 
                            textField_10.getText().length() == 0) {
                          JOptionPane.showMessageDialog(addFrame, "Не все обязательные поля заполнены.", "Ошибка добавления",
                                  JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            id1 = getId(data1, (String)comboBox1.getSelectedItem());
                            id2 = getId(data2, (String)comboBox2.getSelectedItem());
                            id3 = getId(data3, (String)comboBox3.getSelectedItem());
                            if(action.equals("redact")) {
                                usQuery = "exec updateEmployee \'"+id+"\',\'"+textField_4.getText()+"\',\'"+id1+"\',\'"+
                                        textField_5.getText()+"\',\'"+textField_6.getText()+"\',\'"+id2+"\',\'"+
                                        textField_7.getText()+"\', \'"+textField_8.getText()+"\',\'"+textField_9.getText()+"\',"
                                        + "\'"+textField_10.getText()+"\',\'"+textField_1.getText()+"\',\'"+textField_2.getText()
                                        +"\', \'"+id3+"\', \'"+textField_3.getText()+"\'";     
                                System.out.println(usQuery);
                                insRedRem(usQuery);
                            } else {
                                usQuery = "exec InsertNewEmployee \'"+textField_4.getText()+"\',\'"+id1+"\',\'"+
                                        textField_5.getText()+"\',\'"+textField_6.getText()+"\',\'"+id2+"\',\'"+
                                        textField_7.getText()+"\', \'"+textField_8.getText()+"\',\'"+textField_9.getText()+"\',"
                                        + "\'"+textField_10.getText()+"\',\'"+textField_1.getText()+"\',\'"+textField_2.getText()
                                        +"\', \'"+id3+"\', \'"+textField_3.getText()+"\'";     
                                System.out.println(usQuery);
                                insRedRem(usQuery);
                            }                       
                        }
                    redact.update();
                    break;
                    case "EmployeeAccoutning":
                        textFieldColor(1);textFieldColor(2);
                        if (textField_1.getText().length() == 0 || textField_2.getText().length() == 0) {
                          JOptionPane.showMessageDialog(addFrame, "Не все обязательные поля заполнены.", "Ошибка добавления",
                                  JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            id1 = getId(data1, (String)comboBox1.getSelectedItem());
                            id2 = getId(data2, (String)comboBox2.getSelectedItem());                            
                            if(action.equals("redact")) {
                                String []argumArr = id.split("\n");
                                usQuery = "exec updateEmployeeAccounting \'"+argumArr[0]+"\', \'"+argumArr[1]+"\',"
                                        + " \'"+argumArr[2]+"\', " + textField_2.getText();            
                                System.out.println(usQuery);
                                insRedRem(usQuery);
                            } else {
                                usQuery = "insert into employeeaccounting values (\'"+id1+"\',\'"+id2+"\',\'"
                                        +textField_1.getText()+"\',"+ textField_2.getText() + ")";
                                    System.out.println(usQuery);
                                    insRedRem(usQuery);
                            }                              
                        }
                    redact.update();  
                    break;
                    case "Counterparty"://изменить
                        textFieldColor(1);textFieldColor(3);textFieldColor(4);
                        textFieldColor(5);textFieldColor(6);textFieldColor(7);
                        if (textField_1.getText().length() == 0 || textField_3.getText().length() == 0 || 
                            textField_4.getText().length() == 0 || textField_5.getText().length() == 0 || 
                            textField_6.getText().length() == 0 ||textField_7.getText().length() == 0) {
                          JOptionPane.showMessageDialog(addFrame, "Не все обязательные поля заполнены.", "Ошибка добавления",
                                  JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            id1 = getId(data1, (String)comboBox1.getSelectedItem());
                            id2 = getId(data2, (String)comboBox2.getSelectedItem());
                            if(action.equals("redact")) {
                                usQuery = "exec updateCounterparty \'"+id+"\',\'"+id1+"\',\'"+id2+"\',\'"+textField_3.getText()+
                                        "\',\'"+textField_4.getText()+"\',\'"+textField_5.getText()+"\',\'"+textField_6.getText()+
                                        "\',\'"+textField_7.getText()+"\',\'"+textField_8.getText()+"\',\'"+textField_9.getText()+
                                        "\',\'"+textField_10.getText()+"\',\'"+textField_1.getText()+"\',\'"+textField_2.getText()+"\'";     
                                System.out.println(usQuery);
                                insRedRem(usQuery);
                            } else {
                                usQuery = "insert into Counterparty values (newid(),\'"+id1+"\',\'"+textField_3.getText()+"\',\'"+
                                    textField_4.getText()+"\',\'"+textField_5.getText()+"\', \'"+textField_6.getText()+"\',"
                                    + "\'"+textField_7.getText()+"\',\'"+textField_8.getText()+"\',\'"+textField_9.getText()
                                    +"\',\'"+id2+"\',\'"+textField_10.getText()+"\',\'"+textField_1.getText()+"\',\'" +
                                    textField_2.getText()+"\')";
                                System.out.println(usQuery);
                                insRedRem(usQuery);
                            }                            
                        }
                    redact.update();
                    break;
                    case "OrdersMaterials":
                        textFieldColor(1);textFieldColor(2);
                        if (textField_1.getText().length() == 0 || textField_2.getText().length() == 0) {
                          JOptionPane.showMessageDialog(addFrame, "Не все обязательные поля заполнены.", "Ошибка добавления",
                                  JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            id1 = getId(data1, (String)comboBox1.getSelectedItem());
                            id2 = getId(data2, (String)comboBox2.getSelectedItem());
                            id3 = getId(data3, (String)comboBox3.getSelectedItem());
                            if(action.equals("redact")) {
                                usQuery = "exec updateOrdersMaterials \'"+id+"\',\'"+id1+"\',\'"+textField_1.getText()+
                                        "\',\'"+id2+"\',\'"+textField_2.getText()+"\',\'"+id3+"\'";                                        
                                System.out.println(usQuery);
                                insRedRem(usQuery);    
                            } else {
                                usQuery = "exec InsertNewOrderMaterial \'"+textField_1.getText()+"\',\'"+id1+"\',\'"+id2+"\',\'"
                                        +textField_2.getText()+"\',\'"+id3+"\'";   
                                System.out.println(usQuery);
                                insRedRem(usQuery);
                            }                            
                        }
                    redact.update();
                    break;
                    case "TechDocumentation":
                        textFieldColor(1);textFieldColor(2);textFieldColor(3);
                        textFieldColor(6);textFieldColor(7);textFieldColor(8);
                        if (textField_1.getText().length() == 0 || textField_2.getText().length() == 0 ||
                            textField_3.getText().length() == 0 || textField_6.getText().length() == 0 ||
                            textField_7.getText().length() == 0 || textField_8.getText().length() == 0) {
                            JOptionPane.showMessageDialog(addFrame, "Не все обязательные поля заполнены.", "Ошибка добавления",
                                JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            if(action.equals("redact")) {
                                usQuery = "exec updateTechDocumentation \'"+id+"\',\'"+textField_1.getText()+"\',\'"+
                                        textField_2.getText()+"\',\'"+textField_3.getText()+"\',\'"+textField_6.getText()+"\',\'"+
                                        textField_7.getText()+"\',\'"+textField_8.getText()+"\'";      
                                System.out.println(usQuery);
                                insRedRem(usQuery);
                            } else {
                                usQuery = "exec InsertNewTechDocumentation \'"+textField_1.getText()+"\',\'"+
                                        textField_2.getText()+"\',\'"+textField_3.getText()+"\',\'"+textField_6.getText()+"\',\'"+
                                        textField_7.getText()+"\',\'"+textField_8.getText()+"\'";      
                                System.out.println(usQuery);
                                insRedRem(usQuery);
                            }                         
                        }
                    redact.update();
                    break;
                    }
                }                 
        });
        requestButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        requestButton.setBounds(117, 238, 150, 20);
        addFrame.getContentPane().add(requestButton);
        
        addFrame.setBounds(500, 230, 400, 300);
        update(choise);
        addFrame.setVisible(true);
    }
    
    private static void update(String choise) {
        label_1.setVisible(false);label_2.setVisible(false);label_3.setVisible(false);label_4.setVisible(false);
        label_5.setVisible(false);label_6.setVisible(false);label_7.setVisible(false);label_8.setVisible(false);
        label_9.setVisible(false);label_10.setVisible(false); label_11.setVisible(false);label_12.setVisible(false);
        label_13.setVisible(false);
        textField_1.setVisible(false); textField_2.setVisible(false); textField_3.setVisible(false);
        textField_4.setVisible(false); textField_5.setVisible(false); textField_6.setVisible(false);
        textField_7.setVisible(false); textField_8.setVisible(false); textField_9.setVisible(false);
        textField_10.setVisible(false);
        comboBox1.setVisible(false); comboBox2.setVisible(false); comboBox3.setVisible(false);
        comboBox4.setVisible(false); comboBox5.setVisible(false); 
        data1 = CleanTheArray(data1); data2 = CleanTheArray(data2); data3 = CleanTheArray(data3); 
        data4 = CleanTheArray(data4); data5 = CleanTheArray(data5);
        id1 = ""; id2 = ""; id3 = ""; id4 = ""; id5 = ""; usQuery = "";
        switch (choise) {
        case "Objects":
            data1 = fillData("select Id, Name from Counterparty");
            for (int i = 0; i < data1.length; i++) {
                comboBox1.addItem(data1[i][0]);
            }
            data2 = fillData("select Id, Name from Counterparty");
            for (int i = 0; i < data2.length; i++) {
                comboBox2.addItem(data2[i][0]);
            }
            data3 = fillData("select Id, FullName from Employee");
            for (int i = 0; i < data3.length; i++) {
                comboBox3.addItem(data3[i][0]);
            }            
            data4 = fillData("select Id, Name from SourceOfFunding");
            for (int i = 0; i < data4.length; i++) {
                comboBox4.addItem(data4[i][0]);
            }
            comboBox1.setVisible(true); comboBox2.setVisible(true); comboBox3.setVisible(true);
            comboBox4.setVisible(true);
            textField_6.setVisible(true); textField_7.setVisible(true); textField_8.setVisible(true);
            label_1.setVisible(true);label_2.setVisible(true);label_3.setVisible(true);label_4.setVisible(true);
            label_6.setVisible(true);label_7.setVisible(true);label_8.setVisible(true);
            label_1.setText("Ген. подрядчик");label_2.setText("Клиент");label_3.setText("Ответственный");
            label_4.setText("Источник финансирования"); label_6.setText("Название");
            label_7.setText("Дата начала(дд.мм.гггг)");label_8.setText("Дата завершения(дд.мм.гггг)");
            if(Action.equals("redact")) {
                data5 = fillData("select * from Objects");
                comboBox1.setSelectedItem(data5[0][0]);comboBox2.setSelectedItem(data5[0][1]);
                comboBox3.setSelectedItem(data5[0][2]);comboBox4.setSelectedItem(data5[0][3]);
                textField_6.setText(data5[0][4]);textField_7.setText(data5[0][5]);textField_8.setText(data5[0][6]);
            } 
            break;
        case "Estimates":
            data1 = fillData("select Id, Name from Objects");
            for (int i = 0; i < data1.length; i++) {
                comboBox1.addItem(data1[i][0]);
            }
            label_1.setVisible(true); label_2.setVisible(true); label_3.setVisible(true); label_4.setVisible(true);
            label_1.setText("Объект");label_2.setText("Номер");label_3.setText("Дата"); label_4.setText("Сумма");
            textField_1.setVisible(true); textField_2.setVisible(true); textField_3.setVisible(true);
            comboBox1.setVisible(true); comboBox1.setBounds(71, 20, 183, 20); label_4.setBounds(71, 120, 150, 20);
            label_1.setBounds(71, 0, 150, 20); label_2.setBounds(71, 40, 150, 20); label_3.setBounds(71, 80, 150, 20);
            textField_1.setBounds(71, 60, 183, 20); textField_2.setBounds(71, 100, 183, 20);
            textField_3.setBounds(71, 140, 183, 20); requestButton.setBounds(87, 188, 150, 20);
            addFrame.setBounds(500, 230, 340, 250); 
            if(Action.equals("redact")) {
                data5 = fillData("select * from Estimate");
                comboBox1.setSelectedItem(data5[0][0]);
                textField_1.setText(data5[0][1]); 
                textField_2.setText(data5[0][2]);
                textField_3.setText(data5[0][3]);
            } 
            break;
        case "Acts":
            data1 = fillData("select Id, Name from Objects");
            for (int i = 0; i < data1.length; i++) {
                comboBox1.addItem(data1[i][0]);
            }
            label_1.setVisible(true); label_2.setVisible(true); label_3.setVisible(true); label_4.setVisible(true);
            label_1.setText("Объект");label_2.setText("Номер");label_3.setText("Дата подписания");
            textField_1.setVisible(true); textField_2.setVisible(true); textField_3.setVisible(true);
            comboBox1.setVisible(true);label_4.setText("Сумма");
            label_1.setBounds(71, 0, 150, 20); label_2.setBounds(71, 40, 150, 20); label_3.setBounds(71, 80, 150, 20);
            label_4.setBounds(71, 120, 150, 20);
            textField_1.setBounds(71, 60, 183, 20); textField_2.setBounds(71, 100, 183, 20);
            textField_3.setBounds(71, 140, 183, 20); comboBox1.setBounds(71, 20, 183, 20);            
            requestButton.setBounds(87, 188, 150, 20); addFrame.setBounds(500, 230, 340, 250);      
            if(Action.equals("redact")) {
                data5 = fillData("select * from Act");
                comboBox1.setSelectedItem(data5[0][0]);
                textField_1.setText(data5[0][1]); 
                textField_2.setText(data5[0][2]);
                textField_3.setText(data5[0][3]);
            } 
            break;
        case "Contracts":
            data1 = fillData("select Id, Name from Objects");
            for (int i = 0; i < data1.length; i++) {
                comboBox1.addItem(data1[i][0]);
            }
            label_1.setVisible(true); label_2.setVisible(true); label_3.setVisible(true); label_4.setVisible(true);
            label_1.setText("Объект");label_2.setText("Номер");label_3.setText("Тип");label_4.setText("Дата");
            textField_1.setVisible(true); textField_2.setVisible(true); textField_3.setVisible(true);
            textField_4.setVisible(true); comboBox1.setVisible(true); comboBox1.setBounds(71, 20, 183, 20);
            label_1.setBounds(71, 0, 150, 20); label_2.setBounds(71, 40, 150, 20); label_3.setBounds(71, 80, 150, 20);
            label_4.setBounds(71, 120, 150, 20); label_5.setBounds(71, 160, 150, 20);label_5.setText("Сумма");
            textField_1.setBounds(71, 60, 183, 20); textField_2.setBounds(71, 100, 183, 20); label_5.setVisible(true);
            textField_3.setBounds(71, 140, 183, 20); textField_4.setBounds(71, 180, 183, 20);            
            requestButton.setBounds(87, 228, 150, 20); addFrame.setBounds(500, 230, 340, 290); 
            if(Action.equals("redact")) {
                data5 = fillData("select * from Contract");
                comboBox1.setSelectedItem(data5[0][0]);
                textField_1.setText(data5[0][1]); 
                textField_2.setText(data5[0][2]);
                textField_3.setText(data5[0][3]);
                textField_4.setText(data5[0][4]);
            } 
            break;
        case "Materials":
            label_1.setVisible(true); label_2.setVisible(true); label_3.setVisible(true);
            label_1.setText("Название");label_2.setText("Единица измерения");label_3.setText("Стоимость");
            textField_1.setVisible(true); textField_2.setVisible(true); textField_3.setVisible(true);
            label_1.setBounds(71, 0, 150, 20); label_2.setBounds(71, 40, 150, 20); label_3.setBounds(71, 80, 150, 20);
            textField_1.setBounds(71, 20, 183, 20); textField_2.setBounds(71, 60, 183, 20);
            textField_3.setBounds(71, 100, 183, 20); requestButton.setBounds(87, 188, 150, 20);
            addFrame.setBounds(500, 230, 340, 250);
            if(Action.equals("redact")) {
                data5 = fillData("select * from Material");
                textField_1.setText(data5[0][0]); 
                textField_2.setText(data5[0][1]);
                textField_3.setText(data5[0][2]);
            } 
            break;
        case "Employee":
            data1 = fillData("select Id, Type from Position");
            for (int i = 0; i < data1.length; i++) {
                comboBox1.addItem(data1[i][0]);
            }
            data2 = fillData("select Id, Type from Education");
            for (int i = 0; i < data2.length; i++) {
                comboBox2.addItem(data2[i][0]);
            }
            data3 = fillData("select Id, Name from Bank");
            for (int i = 0; i < data3.length; i++) {
                comboBox3.addItem(data3[i][0]);
            }
            comboBox1.setVisible(true); comboBox2.setVisible(true); comboBox3.setVisible(true);
            textField_1.setVisible(true); textField_2.setVisible(true); textField_3.setVisible(true);
            textField_4.setVisible(true); textField_5.setVisible(true); textField_6.setVisible(true);
            textField_7.setVisible(true); textField_8.setVisible(true); textField_9.setVisible(true);
            textField_10.setVisible(true);label_1.setText("Должность");label_2.setText("Образование");
            label_3.setText("Банк");label_4.setText("ФИО");label_5.setText("Регистрация");
            label_6.setText("Номер телефона");label_7.setText("День рождения");label_8.setText("Дата трудоустройства");
            label_9.setText("Тип документа");label_10.setText("Серия");label_11.setText("Номер(документа)");
            label_12.setText("Персональный номер");label_13.setText("Страховой номер");
            label_1.setVisible(true);label_2.setVisible(true);label_3.setVisible(true);label_4.setVisible(true);
            label_5.setVisible(true);label_6.setVisible(true);label_7.setVisible(true);label_8.setVisible(true);
            label_9.setVisible(true);label_10.setVisible(true);label_11.setVisible(true); label_12.setVisible(true);
            label_13.setVisible(true); requestButton.setBounds(117, 288, 150, 20);
            textField_1.setBounds(5, 220, 183, 20); textField_2.setBounds(205, 220, 175, 20);
            textField_3.setBounds(5, 260, 183, 20);
            addFrame.setBounds(500, 230, 400, 350);
            if(Action.equals("redact")) {
                data5 = fillData("select * from Employee");
                comboBox1.setSelectedItem(data5[0][0]);comboBox2.setSelectedItem(data5[0][1]);
                comboBox3.setSelectedItem(data5[0][2]);textField_4.setText(data5[0][3]); 
                textField_5.setText(data5[0][4]);textField_6.setText(data5[0][5]);textField_7.setText(data5[0][6]);
                textField_8.setText(data5[0][7]);textField_9.setText(data5[0][8]);textField_10.setText(data5[0][9]);
                textField_1.setText(data5[0][10]);textField_2.setText(data5[0][11]); textField_3.setText(data5[0][12]);
            } 
            break;
        case "EmployeeAccoutning":
            data1 = fillData("select Id, Name from Objects");
            for (int i = 0; i < data1.length; i++) {
                comboBox1.addItem(data1[i][0]);
            }
            data2 = fillData("select Id, FullName from Employee");
            for (int i = 0; i < data2.length; i++) {
                comboBox2.addItem(data2[i][0]);
            }
            label_1.setVisible(true); label_2.setVisible(true); label_3.setVisible(true); label_4.setVisible(true);
            textField_1.setVisible(true); textField_2.setVisible(true); comboBox1.setVisible(true);
            comboBox2.setVisible(true);label_1.setText("Объект");label_2.setText("Сотрудник");label_3.setText("Дата");
            label_4.setText("Кол-во отработанных часов");label_1.setBounds(71, 0, 150, 20);
            label_2.setBounds(71, 40, 150, 20); label_3.setBounds(71, 80, 150, 20);label_4.setBounds(71, 120, 180, 20);
            textField_1.setBounds(71, 100, 183, 20); textField_2.setBounds(71, 140, 183, 20);
            comboBox1.setBounds(71, 20, 183, 20); comboBox2.setBounds(71, 60, 183, 20);           
            requestButton.setBounds(87, 188, 150, 20); addFrame.setBounds(500, 230, 340, 250);  
            if(Action.equals("redact")) {
                String []argumArr = Id.split("\n");
                comboBox1.setSelectedItem(argumArr[0]);comboBox2.setSelectedItem(argumArr[1]);
                textField_1.setText(argumArr[2]);textField_2.setText(argumArr[3]);
                comboBox1.setEnabled(false);comboBox2.setEnabled(false);textField_1.setEditable(false);
            } 
            break;
        case "Counterparty":
            data1 = fillData("select Id, Type from OwnershipType");
            for (int i = 0; i < data1.length; i++) {
                comboBox1.addItem(data1[i][0]);
            }
            data2 = fillData("select Id, Name from Bank");
            for (int i = 0; i < data2.length; i++) {
                comboBox2.addItem(data2[i][0]);
            }//
            comboBox1.setVisible(true); comboBox2.setVisible(true);
            textField_1.setVisible(true); textField_2.setVisible(true); textField_3.setVisible(true);
            textField_4.setVisible(true); textField_5.setVisible(true); textField_6.setVisible(true);
            textField_7.setVisible(true); textField_8.setVisible(true); textField_9.setVisible(true);
            textField_10.setVisible(true); label_11.setVisible(true); label_12.setVisible(true);
            label_1.setVisible(true);label_2.setVisible(true);label_3.setVisible(true);label_4.setVisible(true);
            label_5.setVisible(true);label_6.setVisible(true);label_7.setVisible(true);label_8.setVisible(true);
            label_9.setVisible(true);label_10.setVisible(true); requestButton.setBounds(117, 288, 150, 20);
            textField_1.setBounds(5, 220, 183, 20); textField_2.setBounds(205, 220, 175, 20);
            textField_3.setBounds(5, 100, 183, 20); addFrame.setBounds(500, 230, 400, 350);
            label_1.setText("Форма собственности");label_2.setText("Банк");label_3.setText("Название");
            label_4.setText("Адрес");label_5.setText("Почтовый адрес");label_6.setText("Электронная почта");
            label_7.setText("УНП");label_8.setText("Номер телефона");label_9.setText("Расчётный счёт");
            label_10.setText("ОКПО");label_11.setText("Директор");label_12.setText("На основании");
            if(Action.equals("redact")) {
                data5 = fillData("select * from Counterparty");
                comboBox1.setSelectedItem(data5[0][0]);comboBox2.setSelectedItem(data5[0][1]);
                textField_3.setText(data5[0][2]);textField_4.setText(data5[0][3]);textField_5.setText(data5[0][4]);
                textField_6.setText(data5[0][5]);textField_7.setText(data5[0][6]);textField_8.setText(data5[0][7]);
                textField_9.setText(data5[0][8]);textField_10.setText(data5[0][9]);
                textField_1.setText(data5[0][10]);textField_2.setText(data5[0][11]);
                
            }
            break;
        case "OrdersMaterials":
            data1 = fillData("select Id, Name from Objects");
            for (int i = 0; i < data1.length; i++) {
                comboBox1.addItem(data1[i][0]);
            }
            data2 = fillData("select Id, Name from Material");
            for (int i = 0; i < data2.length; i++) {
                comboBox2.addItem(data2[i][0]);
            }
            data3 = fillData("select Id, Name from Counterparty");
            for (int i = 0; i < data3.length; i++) {
                comboBox3.addItem(data3[i][0]);
            }
            comboBox1.setVisible(true); comboBox2.setVisible(true); comboBox3.setVisible(true);
            label_1.setVisible(true); label_2.setVisible(true); label_3.setVisible(true); label_4.setVisible(true);
            label_5.setVisible(true);textField_1.setVisible(true); textField_2.setVisible(true);
            label_1.setText("Объект");label_2.setText("Материал");label_3.setText("Поставщик");label_4.setText("Дата");
            label_5.setText("Количество");
            label_1.setBounds(71, 0, 150, 20); label_2.setBounds(71, 40, 150, 20); label_3.setBounds(71, 80, 150, 20);
            label_4.setBounds(71, 120, 150, 20); label_5.setBounds(71, 160, 150, 20);
            comboBox1.setBounds(71, 20, 183, 20); comboBox2.setBounds(71, 60, 183, 20);
            comboBox3.setBounds(71, 100, 183, 20); textField_1.setBounds(71, 140, 183, 20);
            textField_2.setBounds(71, 180, 183, 20);   
            requestButton.setBounds(87, 218, 150, 20); addFrame.setBounds(500, 230, 340, 280); 
            if(Action.equals("redact")) {
                data5 = fillData("select * from OrdersMaterials");
                comboBox1.setSelectedItem(data5[0][0]);comboBox2.setSelectedItem(data5[0][1]);
                comboBox3.setSelectedItem(data5[0][2]);textField_1.setText(data5[0][3]);textField_2.setText(data5[0][4]);
            } 
            break;
        case "TechDocumentation":
            label_1.setVisible(true); label_2.setVisible(true); label_3.setVisible(true);
            label_6.setVisible(true); label_7.setVisible(true); label_8.setVisible(true);
            label_1.setText("Шифр");label_2.setText("Название");label_3.setText("Создатель");
            label_6.setText("Дата приобритения");label_7.setText("Действует до");label_8.setText("Комментарии");
            textField_1.setVisible(true); textField_2.setVisible(true); textField_3.setVisible(true);
            textField_6.setVisible(true); textField_7.setVisible(true); textField_8.setVisible(true);
            addFrame.setBounds(500, 230, 400, 210); requestButton.setBounds(117, 148, 150, 20);
            if(Action.equals("redact")) {
                data5 = fillData("select * from TechDocumentation");
                textField_1.setText(data5[0][0]); 
                textField_2.setText(data5[0][1]);
                textField_3.setText(data5[0][2]);
                textField_6.setText(data5[0][3]);
                textField_7.setText(data5[0][4]);
                textField_8.setText(data5[0][5]);
            } 
            break;
        }
    }    
    
    private static String[][] fillData(String queryUs) {
        int count = 0;
        pool conection = new pool();
        try {
            ResultSet rs = conection.init(queryUs);
            while (rs.next()) {
                count++;
            }
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String[][] data = new String[count][13];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 13; j++) {
                data[i][j] = "";
            }
        }
        try {
            if(Action.equals("redact")) {
                switch(Choise) {
                    case "Objects":
                        realQuery = "select * from SelectFromObjectsRedact (\'"+Id+"\')";
                    break;
                    case "Estimates":
                        realQuery = "select * from SelectFromEstimates(\'"+Id+"\')";
                    break;
                    case "Acts":
                        realQuery = "select * from SelectFromAct(\'"+Id+"\')";
                        break;
                    case "Contracts":
                        realQuery = "select * from SelectFromContracts(\'"+Id+"\')";
                    break;
                    case "Materials":
                        realQuery = "select * from Material where Id=\'"+Id+"\'";
                        break;
                    case "Employee":
                        realQuery = "select * from SelectFromEmployeeRedact(\'"+Id+"\')";
                    break;
                    case "EmployeeAccoutning":
                        
                    break;
                    case "Counterparty":
                        realQuery = "select * from SelectFromCounterpartyRedact (\'"+Id+"\')";
                    break;
                    case "OrdersMaterials":
                        realQuery = "select * from SelectFromOrdersMaterialsRedact(\'"+Id+"\')";
                    break;
                    case "TechDocumentation":
                        realQuery = "select * from techdocumentation where Id=\'"+Id+"\'"; 
                    break;
                }
            }  
            ResultSet rs = conection.init(queryUs);
            
            if(Action.equals("redact") && !Choise.equals("EmployeeAccoutning")) 
                rs1 = conection.init(realQuery);
            System.out.println(realQuery);
            int i = 0;
            switch (queryUs) {
            case "select Id, Name from Counterparty":
                while (rs.next()) {
                    data[i][0] = rs.getString("Name");
                    data[i][1] = rs.getString("Id");
                    i++;
                }
                rs.close();
                break;
            case "select Id, FullName from Employee":
                while (rs.next()) {
                    data[i][0] = rs.getString("FullName");
                    data[i][1] = rs.getString("Id");
                    i++;
                }
                rs.close();
                break;
            case "select * from Employee":
                rs1.next();
                data[0][0] = rs1.getString("Position");
                data[0][1] = rs1.getString("Education");
                data[0][2] = rs1.getString("Bank");
                data[0][3] = rs1.getString("FIO");
                data[0][4] = rs1.getString("Registration");
                data[0][5] = rs1.getString("PhoneNumber");
                data[0][6] = rs1.getString("DateOfB");
                data[0][7] = rs1.getString("DateOfR");
                data[0][8] = rs1.getString("DocType");
                data[0][9] = rs1.getString("Series");
                data[0][10] = rs1.getString("Number");
                data[0][11] = rs1.getString("PrivNumber");
                data[0][12] = rs1.getString("InsurNumber");
                rs1.close();
                break;
            case "select * from Counterparty":
                rs1.next();
                data[0][0] = rs1.getString("ownType");
                data[0][1] = rs1.getString("bank");
                data[0][2] = rs1.getString("name");
                data[0][3] = rs1.getString("addr");
                data[0][4] = rs1.getString("mailAddr");
                data[0][5] = rs1.getString("email");
                data[0][6] = rs1.getString("ynp");
                data[0][7] = rs1.getString("phone");
                data[0][8] = rs1.getString("checkAc");
                data[0][9] = rs1.getString("okpo");
                data[0][10] = rs1.getString("director");
                data[0][11] = rs1.getString("based");
                rs1.close();
                break;
            case "select * from Objects":
                rs1.next();
                data[0][0] = rs1.getString("genContr");
                data[0][1] = rs1.getString("cust");
                data[0][2] = rs1.getString("resp");
                data[0][3] = rs1.getString("source");
                data[0][4] = rs1.getString("name");
                data[0][5] = rs1.getString("startDate");
                data[0][6] = rs1.getString("endDate");
                rs1.close();
                break;
            case "select * from Estimate":
                rs1.next();
                data[0][0] = rs1.getString("objName");
                data[0][1] = rs1.getString("Number");
                data[0][2] = rs1.getString("Date");
                data[0][3] = rs1.getString("Amount");
                rs1.close();
                break;
            case "select * from OrdersMaterials":
                rs1.next();
                data[0][0] = rs1.getString("objName");
                data[0][1] = rs1.getString("matName");
                data[0][2] = rs1.getString("provName");
                data[0][3] = rs1.getString("Date");
                data[0][4] = rs1.getString("Amount");
                rs1.close();
                break;
            case "select * from Contract":
                rs1.next();
                data[0][0] = rs1.getString("objName");
                data[0][1] = rs1.getString("Number");
                data[0][2] = rs1.getString("Type");
                data[0][3] = rs1.getString("Date");
                data[0][4] = rs1.getString("Amount");
                rs1.close();
                break;
            case "select * from Act":
                rs1.next();
                data[0][0] = rs1.getString("objName");
                data[0][1] = rs1.getString("Number");
                data[0][2] = rs1.getString("DateOfSinging");
                data[0][3] = rs1.getString("Amount");
                rs1.close();
                break;
            case "select Id, Name from SourceOfFunding":
                while (rs.next()) {
                    data[i][0] = rs.getString("Name");
                    data[i][1] = rs.getString("Id");
                    i++;
                }
                rs.close();
                break;
            case "select Id, Name from Objects":
                while (rs.next()) {
                    data[i][0] = rs.getString("Name");
                    data[i][1] = rs.getString("Id");
                    i++;
                }
                rs.close();
                break;
            case "select Id, Type from Position":
                while (rs.next()) {
                    data[i][0] = rs.getString("Type");
                    data[i][1] = rs.getString("Id");
                    i++;
                }
                rs.close();
                break;
            case "select Id, Type from Education":
                while (rs.next()) {
                    data[i][0] = rs.getString("Type");
                    data[i][1] = rs.getString("Id");
                    i++;
                }
                rs.close();
                break;
            case "select Id, Name from Bank":
                while (rs.next()) {
                    data[i][0] = rs.getString("Name");
                    data[i][1] = rs.getString("Id");
                    i++;
                }
                rs.close();
                break;
            case "select Id, Type from OwnershipType":
                while (rs.next()) {
                    data[i][0] = rs.getString("Type");
                    data[i][1] = rs.getString("Id");
                    i++;
                }
                rs.close();
                break;
            case "select Id, Name from Material":
                while (rs.next()) {
                    data[i][0] = rs.getString("Name");
                    data[i][1] = rs.getString("Id");
                    i++;
                }
                rs.close();
                break;
            case "select * from Material":
                rs1.next();
                data[0][0] = rs1.getString("Name");
                data[0][1] = rs1.getString("Unit");
                data[0][2] = rs1.getString("Cost");
                rs1.close();
                rs.close();
                break;
            case "select * from TechDocumentation":
                rs1.next();
                data[i][0] = rs1.getString("Cipher");
                data[i][1] = rs1.getString("Name");
                data[i][2] = rs1.getString("OrgDeveloper");
                data[i][3] = rs1.getString("PurchaseDate");
                data[i][4] = rs1.getString("ValidUntil");
                data[i][5] = rs1.getString("Comments");
                rs1.close();
                break;
            default:
                break;
            }
            rs.close();
            if(Action.equals("redact")  && !Choise.equals("EmployeeAccoutning")) 
                rs1.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    
    private static String[][] CleanTheArray(String [][]arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 13; j++) {
                    arr[i][j] = "";
                }
            }
            return arr;
        } else {
            return arr;
        }
    }

    static private void insRedRem(String query) {
        System.out.println(query);
         pool conection = new pool();
         try {
             conection.insertInto(query);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             System.out.println(e);
             e.printStackTrace();
         }
     }
    
    static private String getId(String[][] arr, String Name) {
        String resultId = "";
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][0].equals(Name)) {
                resultId = arr[i][1];
                return resultId;
            }
        }
        return resultId;
    }

    static private void textFieldColor(int number) {
        switch(number) {
        case 1:
            if(textField_1.getText().length() == 0)
                textField_1.setBackground(Color.RED);
            else
                textField_1.setBackground(Color.WHITE);
            break;
        case 2:
            if(textField_2.getText().length() == 0)
                textField_2.setBackground(Color.RED);
            else
                textField_2.setBackground(Color.WHITE);
            break;
        case 3:
            if(textField_3.getText().length() == 0)
                textField_3.setBackground(Color.RED);
            else
                textField_3.setBackground(Color.WHITE);
            break;
        case 4:
            if(textField_4.getText().length() == 0)
                textField_4.setBackground(Color.RED);
            else
                textField_4.setBackground(Color.WHITE);
            break;
        case 5:
            if(textField_5.getText().length() == 0)
                textField_5.setBackground(Color.RED);
            else
                textField_5.setBackground(Color.WHITE);
            break;
        case 6:
            if(textField_6.getText().length() == 0)
                textField_6.setBackground(Color.RED);
            else
                textField_6.setBackground(Color.WHITE);
            break;
        case 7:
            if(textField_7.getText().length() == 0)
                textField_7.setBackground(Color.RED);
            else
                textField_7.setBackground(Color.WHITE);
            break;
        case 8:
            if(textField_8.getText().length() == 0)
                textField_8.setBackground(Color.RED);
            else
                textField_8.setBackground(Color.WHITE);
            break;
        case 9:
            if(textField_9.getText().length() == 0)
                textField_9.setBackground(Color.RED);
            else
                textField_9.setBackground(Color.WHITE);
            break;
        case 10:
            if(textField_10.getText().length() == 0)
                textField_10.setBackground(Color.RED);
            else
                textField_10.setBackground(Color.WHITE);
            break;
        }
    }
}