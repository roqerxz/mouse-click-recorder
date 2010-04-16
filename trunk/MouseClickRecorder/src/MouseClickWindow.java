import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

//added packages TODO: reduce it
import javax.swing.JPanel;
import org.jdesktop.layout.GroupLayout;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;

//import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Hashtable;
//import java.util.ArrayList;





//VS4E -- DO NOT REMOVE THIS LINE!
public class MouseClickWindow extends JFrame {

	private static final long serialVersionUID = 1L;

    private static final double ProgramVerisonID = 1.1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private org.jdesktop.layout.GroupLayout jPanel1Layout;
    private javax.swing.JPanel jPanel3;
    private int selectMode = 0;
    private boolean newFile = true;
   // private ClickArray array = new ClickArray();
    private double imageHeight;
    private double imageWidth;
    private String imageSize;

   

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    
   

    private JMenuItem openMenuItem;
	private JMenuItem exitMenuItem;
	private JMenuItem undoMenuItem;
	private JMenu fileMenu0;
	private JMenu editMenu0;
	private JMenuBar jMenuBar0;
	private JTree directoryTree0;
	private JScrollPane jScrollPane0;
	private JScrollPane jScrollPane1;
	private JLabel imageLabel;
	private JSplitPane jSplitPane0;
	private JTextField commentField;
	private static File directory = null;	
	private String filename = null;
	private JFileChooser fc;
	private boolean commenting = false;
	private Point mouseCoords;
	private static final String COMMENT_PROMPT = "Enter a label or select another point";
    private static final String COMMENT_PROMPT2 = "Enter a label first and click on the associated points";
    private static final String COMMENT_PROMPT3 = "Enter a new label when done";
    private static final String COMMENT_PROMPT4 = "Select a point on the screen";
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public MouseClickWindow() {
		initComponents();
	}

	private void initComponents() {
		openFileDialog();
		setTitle("Mouse Click Recorder" + ProgramVerisonID);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setSize(890, 400);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setForeground(Color.black);
		add(getCommentField(), BorderLayout.NORTH);
        add(getCenterPanel(), BorderLayout.CENTER);
        add(getBottomPanel(), BorderLayout.SOUTH);
  		setJMenuBar(getJMenuBar0());
	}
    //============================================================
   
    //============================================================
    private JPanel getCenterPanel()
    {
        if(jPanel3 == null)
        {
            jPanel3 = new javax.swing.JPanel();
            jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        }
        //====

       // org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(getDetailPanel());
        //=====
       
        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                //optional gap maybe later
                //.addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            //TO DO: detail Panel , For now we comment it out
                .add(getDetailPanel(), org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(getJSplitPane0(), org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 850, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               
           )
            
        );


        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
               
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                   //optional gap and Detail are taken out TODO: complete the detail panel
                    .add(org.jdesktop.layout.GroupLayout.LEADING, getPanel2(), org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(getDetailPanel(), org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)

                   .add(getJSplitPane0p(), org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    )
                
                .addContainerGap()
                )
        );
  
        //====
        
       
        return jPanel3;
    }
    //============================================================
    private JSplitPane getJSplitPane0p()
    {
        if( jSplitPane0 == null)
        {

        jSplitPane0 = new JSplitPane();
        }
        return jSplitPane0;
    }

    //============================================================
    private JPanel getPanel2()
    {
        if( jPanel2 == null)
        {

        jPanel2 = new javax.swing.JPanel();
        }
        return jPanel2;
    }
    //============================================================
    private JPanel getDetailPanel()
    {
        if(jPanel2 ==null)
        {
        jPanel2 = getPanel2();
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Image Details"));
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        

        jLabel1.setText("Height :");
        jLabel2.setText("Width  :");
        jLabel3.setText("Size :");
        jLabel4.setText("Name :");

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");

        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);

        //ToDO do it differently
        }
        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        //Dimension of the jpanel

        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)

            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
               // .addContainerGap(232, Short.MAX_VALUE)
                )
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(5, 5, 5)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
               // .addContainerGap(124, Short.MAX_VALUE)
                )
        );


        

        //pack();
        return jPanel2;

    }
    //============================================================================
    private JPanel getBottomPanel()
    {
        if (jPanel1 == null )
        {
            jPanel1 = new javax.swing.JPanel();
        }
        
        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton1);

        jRadioButton1.setText("Single");
        jRadioButton2.setText("Multiple");
        jCheckBox1.setText("Show Points");
        jCheckBox2.setText("Show Comments");
        jCheckBox3.setText("Show Image Details");
        jRadioButton1.setSelected(true);
        //TO DO : make the jRadioButton1 call its event by default//
       // jRadioButton1.setEnabled(true);
        jRadioButton1.doClick();
   
        jCheckBox3.setSelected(true);


        //TODO : finish up the tasks for this buttons
        //for now they are invisible
        jCheckBox1.setVisible(false);
        jCheckBox2.setVisible(false);
        

        //===========
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMode0(evt);
            }
        });
        //===========
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMode1(evt);
            }
        });
        //===========

        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailPanelVisible(evt);
            }
        });

        jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        //==============
        //Components on the bottom (Horizontal coordination)
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jCheckBox3)
                .addContainerGap(175, Short.MAX_VALUE)
                
                .add(jCheckBox1)
                .add(18, 18, 18)
                .add(jCheckBox2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 19, Short.MAX_VALUE)
                .add(jRadioButton1)
                .add(12, 12, 12)
                .add(jRadioButton2)
                .add(12, 12, 12))
        );
        //===========
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButton2)
                    .add(jRadioButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jCheckBox1)
                    .add(jCheckBox2)
                    .add(jCheckBox3))
                .addContainerGap())
        );
    
        return jPanel1;
    }
    //===========================================================================
	private JTextField getCommentField() {
		if (commentField == null) {
			commentField = new JTextField();
			commentField.setText("");
			InputMap im = commentField.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			ActionMap am = commentField.getActionMap();
			im.put(KeyStroke.getKeyStroke("ENTER"), "process-input");
			am.put("process-input", new AbstractAction(){
				private static final long serialVersionUID = 7152803600817907902L; // a technicality
				public void actionPerformed(final ActionEvent evt) {
					if( selectMode == 0)
                    {
                        if (!commentField.getText().isEmpty() && commenting) {

                            //add it to the array

                           // array.addMouseClick(directory, filename, mouseCoords.x, mouseCoords.y, commentField.getText());

                            saveAnnotation(directory, filename, mouseCoords.x, mouseCoords.y, commentField.getText());
                            commenting = false;
                            commentField.setText("");
                        }
                    }
                    else if ( selectMode == 1)
                    {
                        getCommentField().setSelectionStart(0);
                        getCommentField().setSelectionEnd(getCommentField().getText().length());
                        getCommentField().requestFocusInWindow();
                       
                    }
                  
				}
				
			});
		}
		return commentField;
	}
    //=====================================================
     private void DetailPanelVisible(java.awt.event.ActionEvent evt) {
       if (jCheckBox3.isSelected())
           jPanel2.setVisible(true);
       else
           jPanel2.setVisible(false);

    }
    //=====================================================
    private void selectMode0(java.awt.event.ActionEvent evt) {
       //single
        if (this.jRadioButton1.isSelected())
            this.selectMode = 0;
            getCommentField().setText("");
            getCommentField().setText(COMMENT_PROMPT4);


    }
    //=====================================================
    private void selectMode1(java.awt.event.ActionEvent evt) {
        //multiple 576
        if (this.jRadioButton2.isSelected())
            this.selectMode = 1;
            getCommentField().setText("");
            getCommentField().setText(COMMENT_PROMPT2);
            getCommentField().setSelectionStart(0);
            getCommentField().setSelectionEnd(COMMENT_PROMPT2.length());
            getCommentField().requestFocusInWindow();

    }
    //=====================================================

    //=====================================================
	private JSplitPane getJSplitPane0() {
       
		if (jSplitPane0 == null) {
			jSplitPane0 = new JSplitPane();
           }
        jSplitPane0.setDividerLocation(220);
        jSplitPane0.setLeftComponent(getJScrollPane0());
        jSplitPane0.setRightComponent(getJScrollPane1());
		return jSplitPane0;
        
	}

    //left component
	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
		}
        jScrollPane0.setViewportView(getJTree0());
		return jScrollPane0;
	}
    //right comonent
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
            jScrollPane1.setHorizontalScrollBarPolicy(30);
            jScrollPane1.setVerticalScrollBarPolicy(20);
		}
       
        jScrollPane1.setViewportView(getImageLabel());
       
       
        return jScrollPane1;
	}
	
	private JLabel getImageLabel() {
        
		if (imageLabel == null) {
			imageLabel = new JLabel();

		}
        imageLabel.setVerticalAlignment(SwingConstants.TOP);
		imageLabel.setAlignmentY(0.0f);
        
		imageLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent event)
            {
                imageLabelMouseMouseReleased(event);
                System.out.println("Amir");
            } 
		});
		return imageLabel;
	}	
	
	private JTree getJTree0() {
		if (directoryTree0 == null) {
			directoryTree0 = directory != null ? new JTree(directory.list(new FileDirectoryAndImageFilter())) : new JTree();
        }
			directoryTree0.addTreeSelectionListener(new TreeSelectionListener() {


				public void valueChanged(TreeSelectionEvent event) {
					directoryTree0TreeSelectionValueChanged(event);
				}
			});
		
		
		return directoryTree0;
	}

	private JMenuBar getJMenuBar0() {
		if (jMenuBar0 == null) {
			jMenuBar0 = new JMenuBar();
			jMenuBar0.add(getFileMenu());
			jMenuBar0.add(getEditMenu());
		}
		return jMenuBar0;
	}

	private JMenu getFileMenu() {
		if (fileMenu0 == null) {
			fileMenu0 = new JMenu();
			fileMenu0.setText("File");
			fileMenu0.setOpaque(false);
			fileMenu0.add(getOpenMenuItem());
			fileMenu0.add(getExitMenuItem());
		}
		return fileMenu0;
	}

	private JMenu getEditMenu() {
		if (editMenu0 == null) {
			editMenu0 = new JMenu();
			editMenu0.setText("Edit");
			editMenu0.setOpaque(false);
			editMenu0.add(getUndoMenuItem());
		}
		return editMenu0;
	}
	
	
	private JMenuItem getUndoMenuItem() {
		if (undoMenuItem == null) {
			undoMenuItem = new JMenuItem();
            //set it to be invisible for now TODO: 
            undoMenuItem.setVisible(false);
			undoMenuItem.setText("Undo");
			undoMenuItem.setOpaque(false);
			undoMenuItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) 
	            {
	                System.out.println("Undo was just pressed");
                    //TODO finish up undo
	            
	            
	            
	            
	            }
	        });
	
		}
		return undoMenuItem;
	}

	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.setOpaque(false);
// This exits the program
//			exitMenuItem.addActionListener(new ActionListener() {
//	            public void actionPerformed(ActionEvent e) {
//	            	 System.exit(0);
//	            }
//	        });				
		}
		return exitMenuItem;
	}	
	
	private JMenuItem getOpenMenuItem() {
		if (openMenuItem == null) {
			openMenuItem = new JMenuItem();
			openMenuItem.setText("Open...");
			openMenuItem.setOpaque(false);
            
			openMenuItem.addMouseListener(new MouseAdapter() {
               
				public void mouseReleased(MouseEvent event) {
					openMenuItemMouseMouseReleased(event);
				}
			});
// This worked for me, the above didnt
//			openMenuItem.addActionListener(new ActionListener() {
//	            public void actionPerformed(ActionEvent e) {
//	        		openFileDialog();
//	            }
//	        });			
		}
		return openMenuItem;
	}

	private JFileChooser getFc() {
		return fc;
	}
	
	private void openFileDialog(){
		if (fc == null) {
			fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
		}
		fc.showOpenDialog(this);
		directory = fc.getSelectedFile();
		directoryTree0 = null;
       
		getJScrollPane0();

	}
	//=====================================================
	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}
    
    private String getImageHeight()
    {
        NumberFormat nm = NumberFormat.getNumberInstance();
        nm.setMaximumFractionDigits(2);
        return nm.format(imageHeight)+ " Pixels";

    }
    private String getImageWidth()
    {
        NumberFormat nm = NumberFormat.getNumberInstance();
        nm.setMaximumFractionDigits(2);
        return nm.format(imageWidth)+ " Pixels";
    }
    private void setImageHeight(double height)
    {
        this.imageHeight = height;
    }
    private void setImageWidth(double width)
    {
        this.imageWidth = width ;
    }
    private String getImageSize(long length)
    {
        length /=1024.00; //in KBytes
        NumberFormat nm = NumberFormat.getNumberInstance();
        return imageSize = nm.format(length)+" Kbytes";
    }
    private String getImageSizeString()
    {
        return imageSize;
    }
    private void setNewFile(File file)
    {

        String temp = file.getPath().substring(0,file.getPath().length()-4) + ".txt";
        File tempFile = new File(temp);
        if(tempFile.exists()){

            this.newFile = false;
        }
        else{
            this.newFile = true;
        }
    }
    //======
    private boolean isNewFile()
    {
        if ( this.newFile == true)
            return true;
        else
            return false;
    }

	//===============================================================================

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
    //==========
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {			
				MouseClickWindow frame = new MouseClickWindow();
				frame.setDefaultCloseOperation(MouseClickWindow.EXIT_ON_CLOSE);
				frame.setTitle("Mouse Click Recorder v" +ProgramVerisonID);
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
	//=========================================================================
	private  boolean saveAnnotation(File directory, String fileName, int x, int y, String label){
        int extPos = fileName.lastIndexOf(".");
        String annotationFileName = fileName.substring(0,extPos+1) + "txt";
        File annotationsFile = new File(directory.getAbsolutePath()+System.getProperty("file.separator")+annotationFileName);
       
        try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(annotationsFile,true));
                if (isNewFile())
                {
                    bw.write("=========================================" +System.getProperty("line.separator"));
                    bw.write("'MouseClickRecorder' version: \t" +this.ProgramVerisonID +System.getProperty("line.separator"));
                    bw.write("Image_filename:"+fileName +System.getProperty("line.separator"));
                    bw.write("Image_height:" +getImageHeight()+System.getProperty("line.separator"));
                    bw.write("Image_width:"+getImageWidth()+System.getProperty("line.separator"));
                    bw.write("Image_file_size:" +getImageSizeString() +System.getProperty("line.separator"));
                    bw.write("=========================================" +System.getProperty("line.separator"));
                    bw.write("Row | Column\t" +"Comment" +System.getProperty("line.separator") );
                    this.newFile = false;
                }
                bw.write(x+" | "+y+" \t"+label+System.getProperty("line.separator"));
                bw.close();
                
        }  catch (IOException e) {
                return false;
        }

        return true;
    }
    //===
    //Undo
    //===
    private void unDo(File directory, String fileName){

    if(!this.isNewFile())
    {
        int extPos = fileName.lastIndexOf(".");
        String annotationFileName = fileName.substring(0,extPos+1) + "txt";
        File annotationsFile = new File(directory.getAbsolutePath()+System.getProperty("file.separator")+annotationFileName);

            try {
                BufferedReader in = new BufferedReader(new FileReader(annotationsFile));
                ArrayList list = new ArrayList();
                String line;
                while ((line = in.readLine()) != null) {
                list.add(line);
                }
                in.close();
                list.remove(list.size()-1);
                for(int i =0; i< list.size();i++)
                {
                System.out.println(list.get(i).toString());

                }
            }  catch (IOException e) {

            }
    }
}

   //==========================================================================
	private void openMenuItemMouseMouseReleased(MouseEvent event) {
		openFileDialog();
	}
	

	private void directoryTree0TreeSelectionValueChanged(TreeSelectionEvent event) {
		
        filename = event.getPath().getLastPathComponent().toString();
        
		if(filename != null) {
			try {

                File file = new File(directory.getAbsolutePath() + System.getProperty("file.separator")+filename);
                long length = file.length();
                
                
                setNewFile(file);
				System.out.println(directory.getAbsolutePath());
				System.out.println("hello");
                
				ImageIcon i = new ImageIcon(directory.getAbsolutePath() + System.getProperty("file.separator")+filename);
				
				//scaling (scales if image has height or width greater than 600
				double height = i.getImage().getHeight(null);
                double width = i.getImage().getWidth(null);
                setImageHeight(height);
                setImageWidth(width);

                         
				double ratio = height/width;
                if (height > 600 || width > 600 )
                {
                    i.setImage(i.getImage().getScaledInstance(600, (int)(600*ratio), Image.SCALE_FAST));
                }
				//end scaling
                
				this.imageLabel.setIcon(i);
				imageLabel.repaint();
				


                //add details to the details panel
                jTextField1.setText(filename);
                jTextField2.setText(getImageHeight());
                jTextField3.setText(getImageWidth());
                jTextField4.setText(getImageSize(length));

                getDetailPanel().repaint();

                repaint();
                

               // getCenterPanel().repaint();
               // getDetailPanel().repaint();
               // getJSplitPane0().repaint();
                


			}


            catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
		}
	}
	private void imageLabelMouseMouseReleased(MouseEvent event) {

        if( this.selectMode == 0)
        {
           
            mouseCoords = event.getPoint();
            commenting = true;
            getCommentField().setText(COMMENT_PROMPT);
            getCommentField().setSelectionStart(0);
            getCommentField().setSelectionEnd(COMMENT_PROMPT.length());
            getCommentField().requestFocusInWindow();
        }
        else if (this.selectMode == 1)
        {
            
            mouseCoords = event.getPoint();
            //array.addMouseClick(directory, filename, mouseCoords.x, mouseCoords.y, commentField.getText() );
            saveAnnotation(directory, filename, mouseCoords.x, mouseCoords.y, getCommentField().getText());
            
        }

    }

	
	private class FileDirectoryAndImageFilter implements FilenameFilter{
		private Hashtable filters;
		private String[] imageExtentions = {"jpg", "png", "gif"};
		FileDirectoryAndImageFilter(){
			super();
			filters = new Hashtable();
			for( String ext : imageExtentions )
				filters.put(ext, this);
		}
		 /**
	     * Return the extension portion of the file's name .
	     *
	     * @see #getExtension
	     * @see FileFilter#accept
	     */
	     public String getExtension(String filename) {
		if(filename != null) {
		    int i = filename.lastIndexOf('.');
		    if(i>0 && i<filename.length()-1) {
			return filename.substring(i+1).toLowerCase();
		    };
		}
		return null;
	    }
		@Override
		public boolean accept(File dir, String name) {
			String ext = getExtension(name);
			return (ext != null && filters.get(ext) != null ) ;
		}
	}
//========================================================================

     
//========================================================================

}

