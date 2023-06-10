package Programm;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;

public class redact {//пока что 11 таблиц диалоговые окна
    static String[] columnObjects = { "Название", "Заказчик", "Сумма","Начально выполнения","Окончание выполнения" };
    static String[] columnEstimates = { "Номер", "Дата", "Сумма" };
    static String[] columnActs = { "Название объекта", "№ акта за месяц","Дата подписания","Сумма"};
    static String[] columnContracts = { "Вид договора","№ договора","Дата","Сумма"};
    static String[] columnMaterials = { "Название", "Единица измерения","Стоимость" };
    static String[] columnEmployee = { "ФИО", "Должность", "Номер телефона" };//диалоговое окно
    static String[] columnEmployeeAccounting = { "Объект", "Сотрудник", "Дата", "Кол-во часов" };
    static String[] columnCounterparty = { "Название", "УНП" };//диалоговое
    static String[] columnOrdersMaterials = { "Объект", "Дата", "Материал", "Количество", "Поставщик", "Статус" };
    static String[] columnTechDocumentation = { "Шифр", "Название", "Организация разработчик", "Дата приобритения",
            "Срок действия", "Примечание", "Статус"};
    static String[][] data, dataQuery;
    static DefaultTableModel model1, model2, model3, model4, model5, model6, model7, model8, model9, model10;
    static JTable table1, table2, table3, table4, table5, table6, table7, table8, table9, table10;
    static JScrollPane scrollPane1, scrollPane2, scrollPane3, scrollPane4, scrollPane5, scrollPane6, scrollPane7,
            scrollPane8, scrollPane9, scrollPane10;
    private static String choise = "";
    private static int selectedRow = 0;
    private static JButton requestButton, requestButton1, requestButton2, requestButton3;
    private static JFrame frame;
    private static String tmpId = "";
    private static String[] items = { "Объекты", "Сметы", "Акты", "Договора", "Материалы", "Сотрудники", 
            "Учёт сотрудников", "Контрагенты", "Заказы материалов", "Техническая документация" };
    private static JMenuBar menuBar;
    private static JMenuItem menuAdd,menuEdit,menuRemove;
    private static JTextField textField_1, textField_2;
    private static JLabel label_1, label_2;

    /**
     * @wbp.parser.entryPoint
     */
    public static void createGUI() {
        frame = new JFrame("Менеджер");
        //choise = "Objects";
        frame.setBackground(new Color(0, 0, 255));
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("1.jpg")))));
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(0, 0, 1100, 650);
        frame.getContentPane().add(scrollPane1);
        fillData("select * from SelectFromObjects()");
        model1 = new DefaultTableModel(data, columnObjects);
        table1 = new JTable(model1);
        table1.setSelectionMode(0);
        table1.setDefaultEditor(Object.class, null);
        scrollPane1.setViewportView(table1);

        scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(0, 0, 1100, 650);
        frame.getContentPane().add(scrollPane2);
        model2 = new DefaultTableModel(data, columnEstimates);
        table2 = new JTable(model2);
        table2.setSelectionMode(0);
        table2.setDefaultEditor(Object.class, null);
        scrollPane2.setViewportView(table2);
        scrollPane2.setVisible(false);

        scrollPane3 = new JScrollPane();
        scrollPane3.setBounds(0, 0, 1100, 650);
        frame.getContentPane().add(scrollPane3);
        model3 = new DefaultTableModel(data, columnActs);
        table3 = new JTable(model3);
        table3.setSelectionMode(0);
        table3.setDefaultEditor(Object.class, null);
        scrollPane3.setViewportView(table3);
        scrollPane3.setVisible(false);

        scrollPane4 = new JScrollPane();
        scrollPane4.setBounds(0, 0, 1100, 650);
        frame.getContentPane().add(scrollPane4);
        model4 = new DefaultTableModel(data, columnContracts);
        table4 = new JTable(model4);
        table4.setSelectionMode(0);
        table4.setDefaultEditor(Object.class, null);
        scrollPane4.setViewportView(table4);
        scrollPane4.setVisible(false);

        scrollPane5 = new JScrollPane();
        scrollPane5.setBounds(0, 0, 1100, 650);
        frame.getContentPane().add(scrollPane5);
        model5 = new DefaultTableModel(data, columnMaterials);
        table5 = new JTable(model5);
        table5.setSelectionMode(0);
        table5.setDefaultEditor(Object.class, null);
        scrollPane5.setViewportView(table5);
        scrollPane5.setVisible(false);

        scrollPane6 = new JScrollPane();
        scrollPane6.setBounds(0, 0, 1100, 650);
        frame.getContentPane().add(scrollPane6);
        model6 = new DefaultTableModel(data, columnEmployee);
        table6 = new JTable(model6);
        table6.setSelectionMode(0);
        table6.setDefaultEditor(Object.class, null);
        scrollPane6.setViewportView(table6);
        scrollPane6.setVisible(false);

        scrollPane7 = new JScrollPane();
        scrollPane7.setBounds(0, 0, 1100, 650);
        frame.getContentPane().add(scrollPane7);
        model7 = new DefaultTableModel(data, columnEmployeeAccounting);
        table7 = new JTable(model7);
        table7.setSelectionMode(0);
        table7.setDefaultEditor(Object.class, null);
        scrollPane7.setViewportView(table7);
        scrollPane7.setVisible(false);

        scrollPane8 = new JScrollPane();
        scrollPane8.setBounds(0, 0, 1100, 650);
        frame.getContentPane().add(scrollPane8);
        model8 = new DefaultTableModel(data, columnCounterparty);
        table8 = new JTable(model8);
        table8.setSelectionMode(0);
        table8.setDefaultEditor(Object.class, null);
        scrollPane8.setViewportView(table8);
        scrollPane8.setVisible(false);

        scrollPane9 = new JScrollPane();
        scrollPane9.setBounds(0, 0, 1100, 650);
        frame.getContentPane().add(scrollPane9);
        model9 = new DefaultTableModel(data, columnOrdersMaterials);
        table9 = new JTable(model9);
        table9.setSelectionMode(0);
        table9.setDefaultEditor(Object.class, null);
        scrollPane9.setViewportView(table9);
        scrollPane9.setVisible(false);

        scrollPane10 = new JScrollPane();
        scrollPane10.setBounds(0, 0, 1100, 650);
        frame.getContentPane().add(scrollPane10);
        model10 = new DefaultTableModel(data, columnTechDocumentation);
        table10 = new JTable(model10);
        table10.setSelectionMode(0);
        table10.setDefaultEditor(Object.class, null);
        scrollPane10.setViewportView(table10);
        scrollPane10.setVisible(false);        

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(1101, 56, 180, 23);
        frame.getContentPane().add(textField_1);        

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(1101, 100, 180, 23);
        frame.getContentPane().add(textField_2);
        
        label_1 = new JLabel("Год(гггг)");
        label_1.setBounds(1101, 34, 180, 23);
        frame.getContentPane().add(label_1);

        label_2 = new JLabel("Месяц(мм)");
        label_2.setBounds(1101, 78, 180, 23);
        frame.getContentPane().add(label_2);
        
        requestButton1 = new JButton("Договора");
        requestButton1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent arg0) {
                if(choise.equals("Objects")) {
                    dataQuery = CleanTheArray(dataQuery);
                    selectedRow = table1.getSelectedRow();
                    if (selectedRow > -1) {                        
                      pool conection = new pool();
                      int count = 0;
                      try {
                          ResultSet rs = conection.init("select * from SelectContracts (\'"+ 
                                  table1.getValueAt(selectedRow, 0).toString() + "\')");
                          while (rs.next()) {
                              count++;
                          }
                          rs.close();
                      } catch (ClassNotFoundException e) {
                          e.printStackTrace();
                      } catch (SQLException e) {
                          e.printStackTrace();
                      }
                      if(count == 0) {
                          JOptionPane.showMessageDialog(frame,"По данному объекту отсутствуют записи о договорах!",
                                  "Предупреждение", JOptionPane.YES_NO_OPTION);
                      } else {
                          dataQuery = new String[count][11];
                          for (int i = 0; i < count; i++) {
                              for (int j = 0; j < 11; j++) {
                                  dataQuery[i][j] = "";
                              }
                          }
                          int i=0;
                          ResultSet rs;
                          try {
                              rs = conection.init("select * from SelectContracts (\'"+ 
                                  table1.getValueAt(selectedRow, 0).toString() + "\')");
                              while (rs.next()) {
                                  dataQuery[i][0] = rs.getString("Number");
                                  dataQuery[i][1] = rs.getString("Type");
                                  dataQuery[i][2] = rs.getString("Date");
                                  dataQuery[i][3] = rs.getString("Amount");
                                  i++;
                              }
                              rs.close();
                              makeReport(dataQuery,"Договора",table1.getValueAt(table1.getSelectedRow(), 0).toString());
                          } catch (ClassNotFoundException | SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                          }
                      }                                               
                    }                
                } else if(choise.equals("OrdersMaterials")) {
                    if(checkSelectedRow(choise)==0) {
                        JOptionPane.showMessageDialog(frame,"Вы не выбрали заказ, который необходимо закрыть!",
                                "Ошибка завершения", JOptionPane.YES_NO_OPTION);
                    } else {
                        if(table9.getValueAt(table9.getSelectedRow(), 5).toString().equals("Выполнен")) {
                            JOptionPane.showMessageDialog(frame,"Вы выбрали заказ, который уже выполнен!",
                                    "Ошибка завершения", JOptionPane.YES_NO_OPTION);
                        } else {
                            pool conection = new pool();
                            try {
                                conection.insertInto("update OrdersMaterials set State=1 where Id=\'"+getId(choise)+"\'");
                                update();
                            } catch (ClassNotFoundException e1) {                            
                                e1.printStackTrace();
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                } else if(choise.equals("EmployeeAccoutning")) {
                    dataQuery = CleanTheArray(dataQuery);         
                    textFieldColor(1);textFieldColor(2);
                    if ((textField_1.getText().length() == 0 || textField_2.getText().length() == 0)
                            || (textField_1.getText().length() != 4 || textField_2.getText().length() > 2)) {
                        JOptionPane.showMessageDialog(frame, "Не все обязательные поля заполнены или введеные некорректные данные.",
                                "Ошибка создания отчёта",JOptionPane.INFORMATION_MESSAGE);
                      } else {
                          pool conection = new pool();
                          int count = 0;
                          try {
                              ResultSet rs = conection.init("select * from EmployeeAccountingReportForAll("
                                      + textField_2.getText()+","+textField_1.getText()+") "
                                      + "order by EmployeeId,EmployeeFio,Date");
                              while (rs.next()) {
                                  count++;
                              }
                              rs.close();
                          } catch (ClassNotFoundException e) {
                              e.printStackTrace();
                          } catch (SQLException e) {
                              e.printStackTrace();
                          }
                          if(count == 0) {
                              JOptionPane.showMessageDialog(frame,"В данном месяце отсутствуют записи о работе сотрудников!",
                                      "Предупреждение", JOptionPane.YES_NO_OPTION);
                          } else {                          
                              dataQuery = new String[count][11];
                              for (int i = 0; i < count; i++) {
                                  for (int j = 0; j < 11; j++) {
                                      dataQuery[i][j] = "";
                                  }
                              }
                              int i=0;
                              ResultSet rs;
                              try {
                                  rs = conection.init("select * from EmployeeAccountingReportForAll("
                                          + textField_2.getText()+","+textField_1.getText()+") "
                                          + "order by EmployeeId,EmployeeFio,Date");
                                  while (rs.next()) {
                                      dataQuery[i][0] = rs.getString("EmployeeFIO");
                                      dataQuery[i][1] = rs.getString("Date");
                                      dataQuery[i][2] = rs.getString("Amount");
                                      dataQuery[i][3] = rs.getString("pos");
                                      dataQuery[i][4] = rs.getString("AmountOfDays");
                                      dataQuery[i][5] = rs.getString("DayNumber");
                                      dataQuery[i][6] = rs.getString("EmployeeId");
                                      i++;
                                  }
                                  rs.close();
                                  try {
                                    WorkWithExcel(dataQuery);
                                } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                              } catch (ClassNotFoundException | SQLException e) {
                                  // TODO Auto-generated catch block
                                  e.printStackTrace();
                              }
                          } 
                      }                                                   
                }
            }
        });
        requestButton1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        requestButton1.setBounds(1101, 44, 180, 23);
        frame.getContentPane().add(requestButton1);

        requestButton = new JButton("Акты");
        requestButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                if(choise.equals("Objects")) {
                    dataQuery = CleanTheArray(dataQuery);
                    selectedRow = table1.getSelectedRow();
                    if (selectedRow > -1) {                        
                      pool conection = new pool();
                      int count = 0;
                      try {
                          ResultSet rs = conection.init("select * from SelectActs (\'"+ 
                                  table1.getValueAt(selectedRow, 0).toString() + "\')");
                          while (rs.next()) {
                              count++;
                          }
                          rs.close();
                      } catch (ClassNotFoundException e) {
                          e.printStackTrace();
                      } catch (SQLException e) {
                          e.printStackTrace();
                      }
                      if(count == 0) {
                          JOptionPane.showMessageDialog(frame,"По данному объекту отсутствуют записи об актах!",
                                  "Предупреждение", JOptionPane.YES_NO_OPTION);
                      } else {
                          dataQuery = new String[count][11];
                          for (int i = 0; i < count; i++) {
                              for (int j = 0; j < 11; j++) {
                                  dataQuery[i][j] = "";
                              }
                          }
                          int i=0;
                          ResultSet rs;
                          try {
                              rs = conection.init("select * from SelectActs (\'"+ 
                                  table1.getValueAt(selectedRow, 0).toString() + "\')");
                              while (rs.next()) {
                                  dataQuery[i][0] = rs.getString("Number");
                                  dataQuery[i][1] = rs.getString("Date");
                                  dataQuery[i][2] = rs.getString("Amount");
                                  i++;
                              }
                              rs.close();
                              makeReport(dataQuery,"Акты",table1.getValueAt(table1.getSelectedRow(), 0).toString());
                          } catch (ClassNotFoundException | SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                          } 
                      }                                              
                    }                
                }
            }
        });
        requestButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        requestButton.setBounds(1101, 77, 180, 23);
        frame.getContentPane().add(requestButton);
        
        requestButton2 = new JButton("Сметы");
        requestButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                if(choise.equals("Objects")) {
                    dataQuery = CleanTheArray(dataQuery);
                    selectedRow = table1.getSelectedRow();
                    if (selectedRow > -1) {                        
                      pool conection = new pool();
                      int count = 0;
                      try {
                          ResultSet rs = conection.init("select * from SelectEstimates (\'"+ 
                                  table1.getValueAt(selectedRow, 0).toString() + "\')");
                          while (rs.next()) {
                              count++;
                          }
                          rs.close();
                      } catch (ClassNotFoundException e) {
                          e.printStackTrace();
                      } catch (SQLException e) {
                          e.printStackTrace();
                      }
                      if(count == 0) {
                          JOptionPane.showMessageDialog(frame,"По данному объекту отсутствуют записи о сметах!",
                                  "Предупреждение", JOptionPane.YES_NO_OPTION);
                      } else {
                          dataQuery = new String[count][11];
                          for (int i = 0; i < count; i++) {
                              for (int j = 0; j < 11; j++) {
                                  dataQuery[i][j] = "";
                              }
                          }
                          int i=0;
                          ResultSet rs;
                          try {
                              rs = conection.init("select * from SelectEstimates (\'"+ 
                                  table1.getValueAt(selectedRow, 0).toString() + "\')");
                              while (rs.next()) {
                                  dataQuery[i][0] = rs.getString("Number");
                                  dataQuery[i][1] = rs.getString("Date");
                                  dataQuery[i][2] = rs.getString("Amount");
                                  i++;
                              }
                              rs.close();
                              makeReport(dataQuery,"Сметы",table1.getValueAt(table1.getSelectedRow(), 0).toString());
                          } catch (ClassNotFoundException | SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                          } 
                      }                                              
                    }                
                }
            }
        });
        requestButton2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        requestButton2.setBounds(1101, 110, 180, 23);
        frame.getContentPane().add(requestButton2);
        
        requestButton3 = new JButton("Склад");
        requestButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                if(choise.equals("Objects")) {
                    dataQuery = CleanTheArray(dataQuery);
                    selectedRow = table1.getSelectedRow();
                    if (selectedRow > -1) {                        
                      pool conection = new pool();
                      int count = 0;
                      try {
                          ResultSet rs = conection.init("select * from SelectStore (\'"+ 
                                  table1.getValueAt(selectedRow, 0).toString() + "\')");
                          while (rs.next()) {
                              count++;
                          }
                          rs.close();
                      } catch (ClassNotFoundException e) {
                          e.printStackTrace();
                      } catch (SQLException e) {
                          e.printStackTrace();
                      }
                      if(count == 0) {
                          JOptionPane.showMessageDialog(frame,"Записей о складе данного объекта не существует!",
                                  "Предупреждение", JOptionPane.YES_NO_OPTION);
                      } else {
                          dataQuery = new String[count][11];
                          for (int i = 0; i < count; i++) {
                              for (int j = 0; j < 11; j++) {
                                  dataQuery[i][j] = "";
                              }
                          }
                          int i=0;
                          ResultSet rs;
                          try {
                              rs = conection.init("select * from SelectStore (\'"+ 
                                  table1.getValueAt(selectedRow, 0).toString() + "\')");
                              while (rs.next()) {
                                  dataQuery[i][0] = rs.getString("Material");
                                  dataQuery[i][1] = rs.getString("Amount");
                                  i++;
                              }
                              rs.close();
                              makeReport(dataQuery,"Склад",table1.getValueAt(table1.getSelectedRow(), 0).toString());
                          } catch (ClassNotFoundException | SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                          } 
                      }                                              
                    }                
                }
            }
        });
        requestButton3.setFont(new Font("Tahoma", Font.PLAIN, 10));
        requestButton3.setBounds(1101, 143, 180, 23);
        frame.getContentPane().add(requestButton3);
        
        JComboBox comboBox = new JComboBox(items);
        comboBox.setBounds(1101, 0, 182, 30);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String) comboBox.getSelectedItem()) {
                case "Объекты":
                    choise = "Objects";
                    update();
                    break;
                case "Сметы":
                    choise = "Estimates";
                    update();
                    break;
                case "Акты":
                    choise = "Acts";
                    update();
                    break;
                case "Договора":
                    choise = "Contracts";
                    update();
                    break;
                case "Материалы":
                    choise = "Materials";
                    update();
                    break;
                case "Сотрудники":
                    choise = "Employee";
                    update();
                    break;
                case "Учёт сотрудников":
                    choise = "EmployeeAccoutning";
                    update();
                    break;
                case "Контрагенты":
                    choise = "Counterparty";
                    update();
                    break;
                case "Заказы материалов":
                    choise = "OrdersMaterials";
                    update();
                    break;
                case "Техническая документация":
                    choise = "TechDocumentation";
                    update();
                    break;
               }
            }
        });
        frame.getContentPane().add(comboBox);

        frame.setBounds(0, 0, 1300, 700);

        menuBar = new JMenuBar();
        menuBar.setFont(new Font("Segoe Print", Font.PLAIN, 12));
        menuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        menuBar.setBackground(Color.WHITE);
        menuBar.setPreferredSize(new Dimension(80, 22));
        frame.setJMenuBar(menuBar);

        menuAdd = new JMenuItem("Добавить");
        menuAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
        menuAdd.setFont(new Font("Arial", Font.BOLD, 12));
        menuAdd.setBackground(Color.LIGHT_GRAY);
        menuAdd.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                addFrame frameAd = new addFrame();
                frameAd.createGUIAdd(choise,"add","nothing");
            }
        });
        menuBar.add(menuAdd);

        menuEdit = new JMenuItem("Редактировать");
        menuEdit.setFont(new Font("Arial", Font.BOLD, 12));
        menuEdit.setBorder(new LineBorder(new Color(0, 0, 0)));
        menuEdit.setBackground(Color.LIGHT_GRAY);
        menuEdit.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(checkSelectedRow(choise)==0) {
                    JOptionPane.showMessageDialog(frame,"Вы не выбрали запись, которую хотите отредактировать!",
                            "Ошибка редактирования", JOptionPane.YES_NO_OPTION);
                } else {
                    addFrame frameAd = new addFrame();
                    System.out.println(getId(choise));
                    frameAd.createGUIAdd(choise,"redact",getId(choise));                   
                }
            }
        });
        menuBar.add(menuEdit);
        
        menuRemove = new JMenuItem("Удалить");
        menuRemove.setFont(new Font("Arial", Font.BOLD, 12));
        menuRemove.setBorder(new LineBorder(new Color(0, 0, 0)));
        menuRemove.setBackground(Color.LIGHT_GRAY);
        menuRemove.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(checkSelectedRow(choise)==0) {
                    JOptionPane.showMessageDialog(frame,"Вы не выбрали запись, которую хотите удалить!",
                            "Ошибка удаления", JOptionPane.YES_NO_OPTION);
                } else {
                    if(JOptionPane.showConfirmDialog(frame,"Вы уверены что хотите удалить эту запись?",
                            "Подтверждение удаления",JOptionPane.YES_NO_OPTION)==1) {
                        System.out.println("Не удалили");
                    }
                    else {
                        pool conection = new pool();
                        try {
                            conection.insertInto("delete from TechDocumentation where Id=\'"+getId(choise)+"\'");
                            update();
                        } catch (ClassNotFoundException e1) {                            
                            e1.printStackTrace();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        menuBar.add(menuRemove);
        update();
        frame.setVisible(true);
    }

    private static String[][] fillData(String queryUs) {     
        pool conection = new pool();
        int count = 0;
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

        data = new String[count][11];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 11; j++) {
                data[i][j] = "";
            }
        }
        try {
            ResultSet rs = conection.init(queryUs);
            int i = 0;
            switch (queryUs) {
            case "select * from SelectFromObjects()":
                while (rs.next()) {
                    data[i][0] = rs.getString("Name");
                    data[i][1] = rs.getString("Customer");
                    data[i][2] = rs.getString("Amount");
                    data[i][3] = rs.getString("StartDate");
                    data[i][4] = rs.getString("EndDate");
                    i++;
                }
                rs.close();
                break;
            case "select Number,Date,Amount from Estimate":
                while (rs.next()) {
                    data[i][0] = rs.getString("Number");
                    data[i][1] = rs.getString("Date");
                    data[i][2] = rs.getString("Amount");
                    i++;
                }
                rs.close();
                break;
            case "select * from SelectFromActs()":
                while (rs.next()) {
                    data[i][0] = rs.getString("ObjectName");
                    data[i][1] = rs.getString("ActNumber");
                    data[i][2] = rs.getString("DateOfSinging");
                    data[i][3] = rs.getString("Amount");
                    i++;
                }
                rs.close();
                break;
            case "select Type,Number,Date,Amount from Contract":
                while (rs.next()) {
                    data[i][0] = rs.getString("Type");
                    data[i][1] = rs.getString("Number");
                    data[i][2] = rs.getString("Date");
                    data[i][3] = rs.getString("Amount");
                    i++;
                }
                rs.close();
                break;
            case "select Name,Unit,Cost from Material":
                while (rs.next()) {
                    data[i][0] = rs.getString("Name");
                    data[i][1] = rs.getString("Unit");
                    data[i][2] = rs.getString("Cost");
                    i++;
                }
                rs.close();
                break;
            case "select * from SelectFromEmployee()":
                while (rs.next()) {
                    data[i][0] = rs.getString("FullName");
                    data[i][1] = rs.getString("Position");
                    data[i][2] = rs.getString("PhoneNumber");
                    i++;
                }
                rs.close();
                break;
            case "select * from SelectFromEmployeeAccounting()":
                while (rs.next()) {
                    data[i][0] = rs.getString("ObjectName");
                    data[i][1] = rs.getString("FullName");
                    data[i][2] = rs.getString("Date");
                    data[i][3] = rs.getString("AmountOfHours");
                    i++;
                }
                rs.close();
                break;
            case "select Name, YNP from Counterparty":
                while (rs.next()) {
                    data[i][0] = rs.getString("Name");
                    data[i][1] = rs.getString("YNP");
                    i++;
                }
                rs.close();
                break;
            case "select * from SelectFromOrdersMaterials()":
                while (rs.next()) {
                    data[i][0] = rs.getString("ObjectName");
                    data[i][1] = rs.getString("Date");
                    data[i][2] = rs.getString("Material");
                    data[i][3] = rs.getString("Amount");
                    data[i][4] = rs.getString("Provider");
                    if(rs.getString("State").equals("0"))
                        data[i][5] = "Ожидание";
                    else
                        data[i][5] = "Выполнен";
                    i++;
                }
                rs.close();
                break;
            case "select * from [TechDocumentation]":
                while (rs.next()) {
                    data[i][0] = rs.getString("Cipher");
                    data[i][1] = rs.getString("Name");
                    data[i][2] = rs.getString("OrgDeveloper");
                    data[i][3] = rs.getString("PurchaseDate");
                    data[i][4] = rs.getString("ValidUntil");
                    data[i][5] = rs.getString("Comments");
                    if(rs.getString("State").equals("0"))
                        data[i][6] = "Выдано";
                    else
                        data[i][6] = "На складе";                    
                    i++;
                }
                rs.close();
                break;
            default:
                break;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    static void update() {
        scrollPane1.setVisible(false);scrollPane2.setVisible(false);scrollPane3.setVisible(false);
        scrollPane4.setVisible(false);scrollPane5.setVisible(false);scrollPane6.setVisible(false);
        scrollPane7.setVisible(false);scrollPane8.setVisible(false);scrollPane9.setVisible(false);
        scrollPane10.setVisible(false);menuRemove.setVisible(false);requestButton1.setVisible(false);
        requestButton.setVisible(false);menuEdit.setVisible(false);menuAdd.setVisible(false);
        requestButton2.setVisible(false);requestButton3.setVisible(false);textField_1.setVisible(false);
        textField_2.setVisible(false);label_1.setVisible(false);label_2.setVisible(false);
        requestButton1.setBounds(1101, 44, 180, 23);
        switch (choise) {
        case "Objects":
            menuEdit.setVisible(true);menuAdd.setVisible(true);requestButton1.setVisible(true);
            requestButton.setVisible(true);requestButton2.setVisible(true);requestButton3.setVisible(true);
            fillData("select * from SelectFromObjects()");
            DefaultTableModel dtm1 = (DefaultTableModel) table1.getModel();
            for (int i = 0; i < dtm1.getRowCount(); i++) {
                dtm1.removeRow(i);
            }
            dtm1.setRowCount(0);
            for (int i = 0; i < data.length; i++) {
                Vector<String> v = new Vector<String>();
                v.add(data[i][0]);
                v.add(data[i][1]);
                v.add(data[i][2]);
                v.add(data[i][3]);
                v.add(data[i][4]);
                dtm1.addRow(v);
            }
            scrollPane1.setVisible(true);
            break;
        case "Estimates":
            menuEdit.setVisible(true);menuAdd.setVisible(true);fillData("select Number,Date,Amount from Estimate");
            DefaultTableModel dtm2 = (DefaultTableModel) table2.getModel();
            for (int i = 0; i < dtm2.getRowCount(); i++) {
                dtm2.removeRow(i);
            }
            dtm2.setRowCount(0);
            for (int i = 0; i < data.length; i++) {
                Vector<String> v = new Vector<String>();
                v.add(data[i][0]);
                v.add(data[i][1]);
                v.add(data[i][2]);
                dtm2.addRow(v);
            }
            scrollPane2.setVisible(true);
            break;
        case "Acts":
            menuEdit.setVisible(true);menuAdd.setVisible(true);fillData("select * from SelectFromActs()");
            DefaultTableModel dtm3 = (DefaultTableModel) table3.getModel();
            for (int i = 0; i < dtm3.getRowCount(); i++) {
                dtm3.removeRow(i);
            }
            dtm3.setRowCount(0);
            for (int i = 0; i < data.length; i++) {
                Vector<String> v = new Vector<String>();
                v.add(data[i][0]);
                v.add(data[i][1]);
                v.add(data[i][2]);
                v.add(data[i][3]);
                dtm3.addRow(v);
            }
            scrollPane3.setVisible(true);
            break;
        case "Contracts":
            menuEdit.setVisible(true);menuAdd.setVisible(true);fillData("select Type,Number,Date,Amount from Contract");
            DefaultTableModel dtm4 = (DefaultTableModel) table4.getModel();
            for (int i = 0; i < dtm4.getRowCount(); i++) {
                dtm4.removeRow(i);
            }
            dtm4.setRowCount(0);
            for (int i = 0; i < data.length; i++) {
                Vector<String> v = new Vector<String>();
                v.add(data[i][0]);
                v.add(data[i][1]);
                v.add(data[i][2]);
                v.add(data[i][3]);
                dtm4.addRow(v);
            }
            scrollPane4.setVisible(true);
            break;
        case "Materials":
            menuEdit.setVisible(true);menuAdd.setVisible(true);fillData("select Name,Unit,Cost from Material");
            DefaultTableModel dtm5 = (DefaultTableModel) table5.getModel();
            for (int i = 0; i < dtm5.getRowCount(); i++) {
                dtm5.removeRow(i);
            }
            dtm5.setRowCount(0);
            for (int i = 0; i < data.length; i++) {
                Vector<String> v = new Vector<String>();
                v.add(data[i][0]);
                v.add(data[i][1]);
                v.add(data[i][2]);
                dtm5.addRow(v);
            }
            scrollPane5.setVisible(true);
            break;
        case "Employee":
            menuEdit.setVisible(true);menuAdd.setVisible(true);fillData("select * from SelectFromEmployee()");
            DefaultTableModel dtm6 = (DefaultTableModel) table6.getModel();
            for (int i = 0; i < dtm6.getRowCount(); i++) {
                dtm6.removeRow(i);
            }
            dtm6.setRowCount(0);
            for (int i = 0; i < data.length; i++) {
                Vector<String> v = new Vector<String>();
                v.add(data[i][0]);
                v.add(data[i][1]);
                v.add(data[i][2]);
                dtm6.addRow(v);
            }
            scrollPane6.setVisible(true);
            break;
        case "EmployeeAccoutning":
            requestButton1.setBounds(1101, 134, 180, 24);
            textField_1.setVisible(true);textField_2.setVisible(true);label_1.setVisible(true);
            label_2.setVisible(true);requestButton1.setVisible(true);requestButton1.setText("Отчёт за месяц(все)");
            menuEdit.setVisible(true);menuAdd.setVisible(true);fillData("select * from SelectFromEmployeeAccounting()");
            DefaultTableModel dtm7 = (DefaultTableModel) table7.getModel();
            for (int i = 0; i < dtm7.getRowCount(); i++) {
                dtm7.removeRow(i);
            }
            dtm7.setRowCount(0);
            for (int i = 0; i < data.length; i++) {
                Vector<String> v = new Vector<String>();
                v.add(data[i][0]);
                v.add(data[i][1]);
                v.add(data[i][2]);
                v.add(data[i][3]);
                dtm7.addRow(v);
            }
            scrollPane7.setVisible(true);
            break;
        case "Counterparty":
            menuEdit.setVisible(true);menuAdd.setVisible(true);fillData("select Name, YNP from Counterparty");
            DefaultTableModel dtm8 = (DefaultTableModel) table8.getModel();
            for (int i = 0; i < dtm8.getRowCount(); i++) {
                dtm8.removeRow(i);
            }
            dtm8.setRowCount(0);
            for (int i = 0; i < data.length; i++) {
                Vector<String> v = new Vector<String>();
                v.add(data[i][0]);
                v.add(data[i][1]);
                dtm8.addRow(v);
            }
            scrollPane8.setVisible(true);
            break;
        case "OrdersMaterials":
            menuEdit.setVisible(true);menuAdd.setVisible(true);requestButton1.setVisible(true);
            requestButton1.setText("Закрыть заказ");
            fillData("select * from SelectFromOrdersMaterials()");
            DefaultTableModel dtm9 = (DefaultTableModel) table9.getModel();
            for (int i = 0; i < dtm9.getRowCount(); i++) {
                dtm9.removeRow(i);
            }
            dtm9.setRowCount(0);
            for (int i = 0; i < data.length; i++) {
                Vector<String> v = new Vector<String>();
                v.add(data[i][0]);
                v.add(data[i][1]);
                v.add(data[i][2]);
                v.add(data[i][3]);
                v.add(data[i][4]);
                v.add(data[i][5]);
                dtm9.addRow(v);
            }
            scrollPane9.setVisible(true);
            break;
        case "TechDocumentation":
            menuEdit.setVisible(true);menuAdd.setVisible(true);menuRemove.setVisible(true);
            fillData("select * from [TechDocumentation]");
            DefaultTableModel dtm10 = (DefaultTableModel) table10.getModel();
            for (int i = 0; i < dtm10.getRowCount(); i++) {
                dtm10.removeRow(i);
            }
            dtm10.setRowCount(0);
            for (int i = 0; i < data.length; i++) {
                Vector<String> v = new Vector<String>();
                v.add(data[i][0]);
                v.add(data[i][1]);
                v.add(data[i][2]);
                v.add(data[i][3]);
                v.add(data[i][4]);
                v.add(data[i][5]);
                v.add(data[i][6]);
                dtm10.addRow(v);
            }
            scrollPane10.setVisible(true);
            break;  
        }
    }
    
    private static String[][] CleanTheArray(String [][]arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = "";
                }
            }
            return arr;
        } else {
            return arr;
        }
    }

    static private String getId(String Choise) {
        String resultId = "";
        String Argum = "";
        switch (Choise){
            case "Objects":
                resultId = getIdAdditional("select Id from Objects",table1.getValueAt(table1.getSelectedRow(), 0).toString());
            break;
            case "Estimates":
                resultId = getIdAdditional("select Id from Estimate",table2.getValueAt(table2.getSelectedRow(), 0).toString());
            break;
            case "Acts":
                Argum = table3.getValueAt(table3.getSelectedRow(), 0).toString() + "\n" +
                        table3.getValueAt(table3.getSelectedRow(), 1).toString() + "\n" +
                        table3.getValueAt(table3.getSelectedRow(), 2).toString() + "\n" +
                        table3.getValueAt(table3.getSelectedRow(), 3).toString();
                resultId = getIdAdditional("select Id from Act",Argum);
                break;
            case "Contracts":
                Argum = table4.getValueAt(table4.getSelectedRow(), 0).toString() + "\n" +
                        table4.getValueAt(table4.getSelectedRow(), 1).toString() + "\n" +
                        table4.getValueAt(table4.getSelectedRow(), 2).toString() + "\n" +
                        table4.getValueAt(table4.getSelectedRow(), 3).toString();
                resultId = getIdAdditional("select Id from Contract",Argum);
            break;
            case "Materials":
                Argum = table5.getValueAt(table5.getSelectedRow(), 0).toString() + "\n" +
                        table5.getValueAt(table5.getSelectedRow(), 1).toString() + "\n" +
                        table5.getValueAt(table5.getSelectedRow(), 2).toString();
                resultId = getIdAdditional("select Id from Material",Argum);
                break;
            case "Employee":
                resultId = getIdAdditional("select Id from Employee",table6.getValueAt(table6.getSelectedRow(), 2).toString());
            break;
            case "EmployeeAccoutning":
                Argum = table7.getValueAt(table7.getSelectedRow(), 0).toString() + "\n" +
                        table7.getValueAt(table7.getSelectedRow(), 1).toString() + "\n" +
                        table7.getValueAt(table7.getSelectedRow(), 2).toString() + "\n" +
                        table7.getValueAt(table7.getSelectedRow(), 3).toString(); 
                resultId = Argum;
            break;
            case "Counterparty":
                resultId = getIdAdditional("select Id from Counterparty",table8.getValueAt(table8.getSelectedRow(), 0).toString());
            break;
            case "OrdersMaterials":
                Argum = table9.getValueAt(table9.getSelectedRow(), 0).toString() + "\n" +
                        table9.getValueAt(table9.getSelectedRow(), 1).toString() + "\n" +
                        table9.getValueAt(table9.getSelectedRow(), 2).toString() + "\n" +
                        table9.getValueAt(table9.getSelectedRow(), 3).toString() + "\n" +
                        table9.getValueAt(table9.getSelectedRow(), 4).toString();
                resultId = getIdAdditional("select Id from OrdersMaterials",Argum);
            break;
            case "TechDocumentation":
                resultId = getIdAdditional("select Id from TechDocumentation",table10.getValueAt(table10.getSelectedRow(), 1).toString());                
            break;
        }
        return resultId;
    }
    
    private static String getIdAdditional(String queryUs, String argum) {  
        String Id="";
        String realQuery = "";
        System.out.println(argum);
        String []argumArr = argum.split("\n");
        switch (queryUs) {
        case "select Id from Objects":              
            realQuery = queryUs + " where Name=\'"+argum+"\'";
            break;
        case "select Id from Estimate":
            realQuery = queryUs + " where Number=\'"+argum+"\'";     
            break;
        case "select Id from Act":
            realQuery = "Select Id from Act where ObjectId=(select Id from Objects where Name=\'"+argumArr[0]+"\') and"
                + " Number=\'"+argumArr[1]+"\' and DateOfSinging=\'"+argumArr[2]+"\' and Amount=\'"+argumArr[3]+"\'";
            break;
        case "select Id from Contract":
            realQuery = "select Id from Contract where Number=\'"+argumArr[1]+"\' and Type=\'"+argumArr[0]+"\' and "
                    + "Date=\'"+argumArr[2]+"\' and Amount=\'"+argumArr[3]+"\'";
            break;
        case "select Id from Material":
            realQuery = "select Id from Material where Name=\'"+argumArr[0]+"\' and Unit=\'"+argumArr[1]+"\' and "
                    + "Cost="+argumArr[2];
            break;
        case "select Id from Employee":
            realQuery = queryUs + " where PhoneNumber=\'"+argum+"\'"; 
            break;
        case "select Id from Counterparty":
            realQuery = queryUs + " where Name=\'"+argum+"\'";
            break;
        case "select Id from OrdersMaterials":
            realQuery = "select dbo.SelectIdFromOrdersMaterials (\'"+argumArr[0]+"\',\'"+argumArr[1]+"\',\'"+argumArr[2] +
                "\',\'"+argumArr[3]+"\'" + ",\'"+argumArr[4]+"\') as Id";
            break;
        case "select Id from TechDocumentation":
            realQuery = queryUs + " where Name=\'"+argum+"\'"; 
            break;
        default:
            break;
        }
        pool conection = new pool();
        int count = 0;
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
        try {
            System.out.println(realQuery);
            ResultSet rs = conection.init(realQuery);
            switch (queryUs) {
            case "select Id from Objects":                
                rs.next();
                Id = rs.getString("Id");
                rs.close();    
                break;
            case "select Id from Estimate":
                rs.next();
                Id = rs.getString("Id");
                rs.close();                
                break;
            case "select Id from Act":
                rs.next();
                Id = rs.getString("Id");
                rs.close();
                break;
            case "select Id from Contract":
                rs.next();
                Id = rs.getString("Id");
                rs.close();       
                break;
            case "select Id from Material":
                rs.next();
                Id = rs.getString("Id");
                rs.close();       
                break;
            case "select Id from OrdersMaterials":
                rs.next();
                Id = rs.getString("Id");
                rs.close();       
                break;
            case "select Id from Employee":
                rs.next();
                Id = rs.getString("Id");
                rs.close();       
                break;
            case "select Id from Counterparty":
                rs.next();
                Id = rs.getString("Id");
                rs.close();   
                break;
            case "select Id from OrdersMaterials)":
                
                break;
            case "select Id from TechDocumentation":
                rs.next();
                Id = rs.getString("Id");
                rs.close();  
                break;
            default:
                break;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Id;
    }

    private static int checkSelectedRow(String choise) {  
        int resultValue = 0;
        switch(choise) {
        case "Objects":
            if(table1.getSelectedRow()!=-1)
                resultValue = 1;
            break;
        case "Estimates":
            if(table2.getSelectedRow()!=-1)
                resultValue = 1;
            break;
        case "Acts":
            if(table3.getSelectedRow()!=-1)
                resultValue = 1;
            break;
        case "Contracts":
            if(table4.getSelectedRow()!=-1)
                resultValue = 1;
            break;
        case "Materials":
            if(table5.getSelectedRow()!=-1)
                resultValue = 1;
            break;
        case "Employee":
            if(table6.getSelectedRow()!=-1)
                resultValue = 1;
            break;
        case "EmployeeAccoutning":
            if(table7.getSelectedRow()!=-1)
                resultValue = 1;
            break;
        case "Counterparty":
            if(table8.getSelectedRow()!=-1)
                resultValue = 1;
            break;
        case "OrdersMaterials":
            if(table9.getSelectedRow()!=-1)
                resultValue = 1;
            break;
        case "TechDocumentation":
            if(table10.getSelectedRow()!=-1)
                resultValue = 1;
            break;  
        }           
        return resultValue;
    }

    private static void makeReport(String[][] data,String Filename,String objName) {
      //Blank Document
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out;
        try {
            Date date = new Date();
            out = new FileOutputStream(new File(Filename+".docx"));//путь файла
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            if(!Filename.equals("Склад"))
                run.setText(Filename + " по объекту - \"" +objName+"\" от "+ date.toString());
            else 
                run.setText(Filename + " объекта - \"" +objName+"\" от "+ date.toString());
          //create table
            XWPFTable table = document.createTable();
          //create first row
            XWPFTableRow tableRowOne = table.getRow(0);
            switch(Filename) {
            case "Договора":
                tableRowOne.getCell(0).setText("Номер");
                tableRowOne.addNewTableCell().setText("Тип");
                tableRowOne.addNewTableCell().setText("От");
                tableRowOne.addNewTableCell().setText("Сумма");
                for(int i=0; i<data.length;i++) {
                //create second row
                    tableRowOne = table.createRow();
                    
                    tableRowOne.getCell(0).setText(data[i][0]);
                    tableRowOne.getCell(1).setText(data[i][1]);
                    tableRowOne.getCell(2).setText(data[i][2]);
                    tableRowOne.getCell(3).setText(data[i][3]);
                }
                break;
            case "Акты":
                tableRowOne.getCell(0).setText("Номер");
                tableRowOne.addNewTableCell().setText("Дата подписания");
                tableRowOne.addNewTableCell().setText("Сумма");
                for(int i=0; i<data.length;i++) {
                //create second row
                    tableRowOne = table.createRow();
                    
                    tableRowOne.getCell(0).setText(data[i][0]);
                    tableRowOne.getCell(1).setText(data[i][1]);
                    tableRowOne.getCell(2).setText(data[i][2]);
                }
                break;
            case "Сметы":
                tableRowOne.getCell(0).setText("Номер");
                tableRowOne.addNewTableCell().setText("Дата подписания");
                tableRowOne.addNewTableCell().setText("Сумма");
                for(int i=0; i<data.length;i++) {
                //create second row
                    tableRowOne = table.createRow();
                    
                    tableRowOne.getCell(0).setText(data[i][0]);
                    tableRowOne.getCell(1).setText(data[i][1]);
                    tableRowOne.getCell(2).setText(data[i][2]);
                }
                break;
            case "Склад":
                tableRowOne.getCell(0).setText("Материал(название)");
                tableRowOne.addNewTableCell().setText("Количество");
                for(int i=0; i<data.length;i++) {
                //create second row
                    tableRowOne = table.createRow();
                    
                    tableRowOne.getCell(0).setText(data[i][0]);
                    tableRowOne.getCell(1).setText(data[i][1]);
                }
                break;             
            }
            
            document.write(out);
            out.close();
            
            System.out.println("create_table.docx written successully");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    
    public static void WorkWithExcel(String[][] dataForExcel) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees sheet");
        
        int rownum = 0;
        Cell cell;
        Row row;
   
        HSSFCellStyle style = createStyleForTitle(workbook);
 
        row = sheet.createRow(rownum);        
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("ФИО");
        cell.setCellStyle(style);
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Должность");
        cell.setCellStyle(style);
        
        for(int i=0;i<Integer.parseInt(dataForExcel[0][4]);i++) {
            cell = row.createCell(i+2, CellType.STRING);
            cell.setCellValue(i+1);
            cell.setCellStyle(style);
        }
        
        tmpId = dataForExcel[0][6];
        int tmpCounter=1;
        row = sheet.createRow(1);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue(dataForExcel[0][0]);
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue(dataForExcel[0][3]);       
        for(int h=0;h<dataForExcel.length;h++) {
            if(dataForExcel[h][6].equals(tmpId)) {
                cell = row.createCell(Integer.parseInt(dataForExcel[h][5])+1, CellType.STRING);
                cell.setCellValue(dataForExcel[h][2]);
            } else {
                tmpCounter++;
                row = sheet.createRow(tmpCounter);
                tmpId = dataForExcel[h][6];
                row = sheet.createRow(tmpCounter);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(dataForExcel[h][0]);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(dataForExcel[h][3]);   
                cell = row.createCell(Integer.parseInt(dataForExcel[h][5])+1, CellType.STRING);
                cell.setCellValue(dataForExcel[h][2]);
            }               
        }
        
        File file = new File("D:/employee.xls");//путь файла
        file.getParentFile().mkdirs();        
        
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
        outFile.close();
    }

    static private void textFieldColor(int number) {
        switch(number) {
        case 1:
            if(textField_1.getText().length() == 0 || textField_1.getText().length() != 4)
                textField_1.setBackground(Color.RED);
            else
                textField_1.setBackground(Color.WHITE);
            break;
        case 2:
            if(textField_2.getText().length() == 0 || textField_2.getText().length() > 2)
                textField_2.setBackground(Color.RED);
            else
                textField_2.setBackground(Color.WHITE);
            break;
        }
    }
}