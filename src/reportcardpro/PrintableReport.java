package reportcardpro;

import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class PrintableReport extends javax.swing.JFrame
{
    private final Student toCopy;
    public DecimalFormat df = new DecimalFormat("#.##");
    
    public PrintableReport(Student s)
    {
        this.toCopy = s;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentInfo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMarkTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1100, 850));

        tblStudentInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tblStudentInfo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tblStudentInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Student", "Age", "Gender", "Mean Average", "Median Average"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudentInfo.setRowHeight (50);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblStudentInfo.setDefaultRenderer(String.class, centerRenderer);
        tblStudentInfo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblStudentInfo);
        if (tblStudentInfo.getColumnModel().getColumnCount() > 0) {
            tblStudentInfo.getColumnModel().getColumn(0).setResizable(false);
            tblStudentInfo.getColumnModel().getColumn(0).setHeaderValue("Student");
            tblStudentInfo.getColumnModel().getColumn(1).setResizable(false);
            tblStudentInfo.getColumnModel().getColumn(1).setHeaderValue("Age");
            tblStudentInfo.getColumnModel().getColumn(2).setHeaderValue("Gender");
            tblStudentInfo.getColumnModel().getColumn(3).setHeaderValue("Mean Average");
            tblStudentInfo.getColumnModel().getColumn(4).setHeaderValue("Median Average");
        }
        tblStudentInfo.setValueAt (toCopy.name, 0, 0);
        tblStudentInfo.setValueAt (Integer.toString(toCopy.getAge()), 0, 1);
        tblStudentInfo.setValueAt (toCopy.gender, 0, 2);
        tblStudentInfo.setValueAt (df.format(toCopy.getOverallMeanAverage()), 0, 3);
        tblStudentInfo.setValueAt (df.format(toCopy.getOverallMedianAverage()), 0, 4);

        String[] subStrings = new String[toCopy.subjects.size()];
        String[][] markStrings = new String[toCopy.subjects.size()][10];

        int n = 0;

        //System.out.println("Sub Size: " + toCopy.subjects.size());

        for (Subject sub: toCopy.subjects)
        {
            //System.out.println("n: " + n + " (" + sub.subjectName + ")");
            subStrings[n] = sub.subjectName;

            //System.out.println("Mar Siz: " + toCopy.subjects.get(0).marks.size());

            if (n != (toCopy.subjects.size() - 1))
            {
                n++;
            }
            else if(n == (toCopy.subjects.size() - 1) || n == 9)
            {
                break;
            }

            int m = 0;
            for (Mark mar: sub.marks)
            {
                //System.out.println("m: " + m + " (" + mar.markDescription + ")");
                markStrings[n][m] = df.format(mar.mark);
                if (m != (sub.marks.size() - 1))
                {
                    m++;
                }
                else if (m == (sub.marks.size() - 1) || m == 9)
                {
                    break;
                }
            }
        }
        tblMarkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            subStrings
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblMarkTable);
        System.out.println("Sub Size: " + subStrings.length);

        for (int x = 0; x < subStrings.length; x++)
        {
            //System.out.println("MarSize: " + markStrings.length);
            for (int y = 0; y < 10; y++)
            {
                tblMarkTable.setValueAt(markStrings[y], x, y);
            }
        } //MAKE THE MAX THE SIZE OF EACH MARK ARRAY

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(396, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMarkTable;
    private javax.swing.JTable tblStudentInfo;
    // End of variables declaration//GEN-END:variables
}
