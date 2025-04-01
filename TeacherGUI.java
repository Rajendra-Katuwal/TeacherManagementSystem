
/**
 * This class is created as to provide a graphical user interface for managing
 * our Teachers.
 * author@ Rajendra Katuwal
 * London Met ID: 23049377
 * College ID: np05cp4a230255
 */

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class TeacherGUI {

    // Declare and initialize fonts
    private Font h1Font = new Font("Sans", Font.BOLD, 23);
    private Font h2Font = new Font("Arial", Font.BOLD, 16);
    private Font lblFont = new Font("Sans", Font.PLAIN, 14);
    private Font btnFont = new Font("Arial", Font.BOLD, 14);

    // Declare and initialize colors
    private Color btnColor = new Color(118, 171, 174);
    private Color btnFontColor = new Color(238, 238, 238);
    private Color fontColor = new Color(45, 50, 65);

    private ArrayList<Teacher> teacherInfoData = new ArrayList<Teacher>();

    // Main menu components
    private JFrame mainFrame;
    private JPanel mainMenuPnl;
    private JLabel heading1;
    private JButton tutorGUIBtn, lecturerGUIBtn, displayGUIBtn;

    // Declaring components for lecturer section
    private JFrame lecturerFrame;
    private JPanel lecturerAppPanel, h1Panel, addLecturerPanel, h2addLecturerPanel, gradeAssingmentPanel,
            h2gradeAssingmentPanel;
    private JButton addNewLecturerBtn, gradeAssingmentBtn, clearBtnLecturer;
    private JTextField lecturerIdField1, lecturerIdField2, lecturerNameField,
            lecturerAddressField, lecturerWorkingTypeField, lecturerEmploymentStatusField, lecturerWorkingHoursField,
            lecturerYearOfExperField1, lecturerYearOfExperField2;
    private JLabel h2AddlecturerLbl,
            gradedScoreLbl, yearOfExperLbl, departmentLbl, h2gradeAssingmentLbl;

    // Declaring components for tutor section
    private JFrame tutorFrame;
    private JPanel tutorAppPanel, addTutorPanel, h2AddTutorPanel, setSalaryPanel, removeTutorPanel, h2setSalaryPanel,
            h2removeTutorPanel;
    private JButton addNewTutorBtn, setSalaryBtn, removeTutorBtn, clearBtnTutor;
    private JTextField tutorIdField1, tutorIdField2, tutorIdField3, tutorNameField, tutorAddressField,
            tutorWorkingTypeField, tutorEmploymentStatusField, tutorWorkingHoursField, salaryField1, salaryField2,
            specializationField, academicQlfytnField, performanceIndexField1, performanceIndexField2, gradedScoreField,
            departmentField1, departmentField2;
    private JLabel salaryLbl, specializationLbl, h2setSalaryLbl,
            academicQlfyctnLabel, performanceIndexLbl, h2AddTutorLbl, h2removeTutorLbl;

    // Declaring components for display info
    private JFrame displayFrame;
    private JPanel displayAppPanel;
    private JButton displayInfoBtn;
    private JTextField infoTeacherIdField;

    // Common component of JLabel for Lecturer section and tutor section
    private JLabel h1Lbl, teacherIdLbl, teacherNameLbl, addressLbl, workingTypeLbl, employmentStatusLbl, workingHourLbl;

    // Constructor for the TeacherGUI class creates main menu frame.
    public TeacherGUI() {

        // Main menu frame or start up frame for the teacher management system
        mainFrame = new JFrame("Teacher Management System");
        mainFrame.setLayout(null);
        mainFrame.setSize(400, 380);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // We will be adding all our components in this panel
        mainMenuPnl = new JPanel();
        mainMenuPnl.setBounds(28, 20, 330, 290);
        mainMenuPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2), "Main Menu"));
        mainMenuPnl.setLayout(null);
        mainFrame.add(mainMenuPnl);

        // Heading 1 for the main menu frame
        heading1 = new JLabel("Teacher Mangement");
        heading1.setForeground(fontColor);
        heading1.setFont(h1Font);
        heading1.setBounds(50, 25, 260, 40);
        mainMenuPnl.add(heading1);

        // Add lecturer button to get a frame where we can peform task related to
        // lecturer
        lecturerGUIBtn = new JButton("LECTURER SECTION");
        lecturerGUIBtn.setBackground(btnColor);
        lecturerGUIBtn.setFont(btnFont);
        lecturerGUIBtn.setForeground(btnFontColor);
        lecturerGUIBtn.setFocusable(false);
        lecturerGUIBtn.setBounds(70, 90, 190, 40);
        // Creates a new lecturer frame if its not present or if is not visible
        lecturerGUIBtn.addActionListener(
                e -> {
                    if (lecturerFrame == null || !lecturerFrame.isVisible()) {
                        createNewLecturerFrame();
                    } else {
                        lecturerFrame.toFront();
                    }
                });
        mainMenuPnl.add(lecturerGUIBtn);

        // Add tutor button to get a frame where we can peform task related to tutor
        tutorGUIBtn = new JButton("TUTOR SECTION");
        tutorGUIBtn.setBackground(btnColor);
        tutorGUIBtn.setFont(btnFont);
        tutorGUIBtn.setForeground(btnFontColor);
        tutorGUIBtn.setFocusable(false);
        tutorGUIBtn.setBounds(70, 150, 190, 40);
        // Creates a new tutor frame if its not present or if is not visible
        tutorGUIBtn.addActionListener(
                e -> {
                    if (tutorFrame == null || !tutorFrame.isVisible()) {
                        createNewTutorFrame();

                    } else {
                        tutorFrame.toFront();
                    }
                });
        mainMenuPnl.add(tutorGUIBtn);

        // Display button for displaying the info of a teacher
        displayGUIBtn = new JButton("DISPLAY INFO");
        displayGUIBtn.setBackground(btnColor);
        displayGUIBtn.setFont(btnFont);
        displayGUIBtn.setForeground(btnFontColor);
        displayGUIBtn.setFocusable(false);
        displayGUIBtn.setBounds(70, 210, 190, 40);
        // Creates a new display frame if its not present or if is not visible
        displayGUIBtn.addActionListener(
                e -> {
                    if (displayFrame == null || !displayFrame.isVisible()) {
                        createNewDisplayFrame();

                    } else {
                        displayFrame.toFront();
                    }
                });
        mainMenuPnl.add(displayGUIBtn);

        // Setting up Main Menu frame
        mainFrame.setVisible(true);

    }

    // Method that creates a new lecturer frame with all the required components
    private void createNewLecturerFrame() {

        // lecturer Section frame
        lecturerFrame = new JFrame("LECTURER SECTION");
        lecturerFrame.setLayout(null);
        lecturerFrame.setSize(760, 610);
        lecturerFrame.setLocationRelativeTo(null);
        lecturerFrame.setResizable(false);
        lecturerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // lecturer App Panel for adding all the components in it
        lecturerAppPanel = new JPanel();
        lecturerAppPanel.setSize(760, 590);
        lecturerAppPanel.setLayout(null);
        lecturerFrame.add(lecturerAppPanel);

        // h1 Panel for main heading of the frame
        h1Panel = new JPanel();
        h1Panel.setBounds(0, 0, 760, 45);
        h1Panel.setBackground(btnColor);
        lecturerAppPanel.add(h1Panel);

        // h1 label for heading one
        h1Lbl = new JLabel("LECTURER SECTION");
        h1Lbl.setFont(h1Font);
        h1Lbl.setForeground(Color.WHITE);
        h1Panel.add(h1Lbl);

        // Add lecturer Panel for adding new lecturer
        addLecturerPanel = new JPanel();
        addLecturerPanel.setBounds(30, 90, 400, 440);
        addLecturerPanel.setLayout(null);
        addLecturerPanel.setBorder(new LineBorder(Color.BLACK, 3));
        lecturerAppPanel.add(addLecturerPanel);

        // Heading 2 panel for add new lecturer panel
        h2addLecturerPanel = new JPanel();
        h2addLecturerPanel.setBounds(2, 2, 395, 35);
        h2addLecturerPanel.setBackground(btnColor);
        addLecturerPanel.add(h2addLecturerPanel);
        h2AddlecturerLbl = new JLabel("ADD A NEW LECTURER");
        h2AddlecturerLbl.setForeground(Color.WHITE);
        h2AddlecturerLbl.setFont(h2Font);
        h2addLecturerPanel.add(h2AddlecturerLbl);

        // Teacher ID label and textfield for add new lecturer
        teacherIdLbl = new JLabel("Teacher ID");
        teacherIdLbl.setFont(lblFont);
        teacherIdLbl.setBounds(20, 60, 160, 30);
        addLecturerPanel.add(teacherIdLbl);
        lecturerIdField1 = new JTextField();
        lecturerIdField1.setBorder(new LineBorder(Color.BLACK, 1));
        lecturerIdField1.setBounds(180, 60, 200, 30);
        addLecturerPanel.add(lecturerIdField1);

        // Teacher Name label and textfield for add new lecturer
        teacherNameLbl = new JLabel("Teacher Name");
        teacherNameLbl.setFont(lblFont);
        teacherNameLbl.setBounds(20, 100, 160, 30);
        addLecturerPanel.add(teacherNameLbl);
        lecturerNameField = new JTextField();
        lecturerNameField.setBorder(new LineBorder(Color.BLACK, 1));
        lecturerNameField.setBounds(180, 100, 200, 30);
        addLecturerPanel.add(lecturerNameField);

        // Address label and textfield for add new lecturer
        addressLbl = new JLabel("Address");
        addressLbl.setFont(lblFont);
        addressLbl.setBounds(20, 140, 160, 30);
        addLecturerPanel.add(addressLbl);
        lecturerAddressField = new JTextField();
        lecturerAddressField.setBorder(new LineBorder(Color.BLACK, 1));
        lecturerAddressField.setBounds(180, 140, 200, 30);
        addLecturerPanel.add(lecturerAddressField);

        // Working type label and field for add new lecturer
        workingTypeLbl = new JLabel("Working Type");
        workingTypeLbl.setFont(lblFont);
        workingTypeLbl.setBounds(20, 180, 200, 30);
        addLecturerPanel.add(workingTypeLbl);
        lecturerWorkingTypeField = new JTextField();
        lecturerWorkingTypeField.setBorder(new LineBorder(Color.BLACK, 1));
        lecturerWorkingTypeField.setBounds(180, 180, 200, 30);
        addLecturerPanel.add(lecturerWorkingTypeField);

        // Employment Status label and textfield for add new lecturer
        employmentStatusLbl = new JLabel("Employment Status");
        employmentStatusLbl.setFont(lblFont);
        employmentStatusLbl.setBounds(20, 220, 200, 30);
        addLecturerPanel.add(employmentStatusLbl);
        lecturerEmploymentStatusField = new JTextField();
        lecturerEmploymentStatusField.setBorder(new LineBorder(Color.BLACK, 1));
        lecturerEmploymentStatusField.setBounds(180, 220, 200, 30);
        addLecturerPanel.add(lecturerEmploymentStatusField);

        // Graded score label and textfield for add new lecturer
        departmentLbl = new JLabel("Department");
        departmentLbl.setFont(lblFont);
        departmentLbl.setBounds(20, 260, 200, 30);
        addLecturerPanel.add(departmentLbl);
        departmentField1 = new JTextField();
        departmentField1.setBorder(new LineBorder(Color.BLACK, 1));
        departmentField1.setBounds(180, 260, 200, 30);
        addLecturerPanel.add(departmentField1);

        // year of experience label and textfield for add new lecturer
        yearOfExperLbl = new JLabel("Year Of Experience");
        yearOfExperLbl.setFont(lblFont);
        yearOfExperLbl.setBounds(20, 300, 200, 30);
        addLecturerPanel.add(yearOfExperLbl);
        lecturerYearOfExperField1 = new JTextField();
        lecturerYearOfExperField1.setBorder(new LineBorder(Color.BLACK, 1));
        lecturerYearOfExperField1.setBounds(180, 300, 200, 30);
        addLecturerPanel.add(lecturerYearOfExperField1);

        // Working hour label and textfield for add new lecturer
        workingHourLbl = new JLabel("Working Hour");
        workingHourLbl.setFont(lblFont);
        workingHourLbl.setBounds(20, 340, 200, 30);
        addLecturerPanel.add(workingHourLbl);
        lecturerWorkingHoursField = new JTextField();
        lecturerWorkingHoursField.setBorder(new LineBorder(Color.BLACK, 1));
        lecturerWorkingHoursField.setBounds(180, 340, 200, 30);
        addLecturerPanel.add(lecturerWorkingHoursField);

        // Button for adding the new lecturer
        addNewLecturerBtn = new JButton("Add Lecturer");
        addNewLecturerBtn.setFont(lblFont);
        addNewLecturerBtn.setBackground(btnColor);
        addNewLecturerBtn.setFont(btnFont);
        addNewLecturerBtn.setForeground(btnFontColor);
        addNewLecturerBtn.setBounds(100, 390, 200, 35);
        addNewLecturerBtn.setFocusable(false);
        // adds the lecturer with valid details to arraylist
        addNewLecturerBtn.addActionListener(
                e -> addNewLecturer());
        addLecturerPanel.add(addNewLecturerBtn);

        // Grade assingment panel for the lecturer
        gradeAssingmentPanel = new JPanel();
        gradeAssingmentPanel.setBounds(445, 90, 270, 380);
        gradeAssingmentPanel.setBorder(new LineBorder(Color.BLACK, 3));
        gradeAssingmentPanel.setLayout(null);
        // gradeAssingmentPanel.setBackground(bgColor);
        lecturerAppPanel.add(gradeAssingmentPanel);

        // Heading 2 panel for grade assingment
        h2gradeAssingmentPanel = new JPanel();
        h2gradeAssingmentPanel.setBounds(2, 2, 265, 35);
        h2gradeAssingmentPanel.setBackground(btnColor);
        gradeAssingmentPanel.add(h2gradeAssingmentPanel);
        h2gradeAssingmentLbl = new JLabel("GRADE ASSINGMENT");
        h2gradeAssingmentLbl.setForeground(Color.WHITE);
        h2gradeAssingmentLbl.setFont(h2Font);
        h2gradeAssingmentPanel.add(h2gradeAssingmentLbl);

        // Teacher ID label and textfield for grade assingment
        teacherIdLbl = new JLabel("Teacher ID");
        teacherIdLbl.setFont(lblFont);
        teacherIdLbl.setBounds(20, 50, 160, 30);
        gradeAssingmentPanel.add(teacherIdLbl);
        lecturerIdField2 = new JTextField();
        lecturerIdField2.setBorder(new LineBorder(Color.BLACK, 1));
        lecturerIdField2.setBounds(20, 75, 230, 30);
        gradeAssingmentPanel.add(lecturerIdField2);

        // Grade score label and textfield for grade assingment
        gradedScoreLbl = new JLabel("Graded Score");
        gradedScoreLbl.setFont(lblFont);
        gradedScoreLbl.setBounds(20, 115, 160, 30);
        gradeAssingmentPanel.add(gradedScoreLbl);
        gradedScoreField = new JTextField();
        gradedScoreField.setBorder(new LineBorder(Color.BLACK, 1));
        gradedScoreField.setBounds(20, 140, 230, 30);
        gradeAssingmentPanel.add(gradedScoreField);

        // Performance Index label and textfield for grade assingment
        departmentLbl = new JLabel("Department");
        departmentLbl.setFont(lblFont);
        departmentLbl.setBounds(20, 180, 160, 30);
        gradeAssingmentPanel.add(departmentLbl);
        departmentField2 = new JTextField();
        departmentField2.setBorder(new LineBorder(Color.BLACK, 1));
        departmentField2.setBounds(20, 205, 230, 30);
        gradeAssingmentPanel.add(departmentField2);

        // year of experience label and textfield for grade assingment
        yearOfExperLbl = new JLabel("Year Of Experience");
        yearOfExperLbl.setFont(lblFont);
        yearOfExperLbl.setBounds(20, 245, 200, 30);
        gradeAssingmentPanel.add(yearOfExperLbl);
        lecturerYearOfExperField2 = new JTextField();
        lecturerYearOfExperField2.setBorder(new LineBorder(Color.BLACK, 1));
        lecturerYearOfExperField2.setBounds(20, 270, 230, 30);
        gradeAssingmentPanel.add(lecturerYearOfExperField2);

        // Button for grading the assingment
        gradeAssingmentBtn = new JButton("Grade Assingment");
        gradeAssingmentBtn.setFont(lblFont);
        gradeAssingmentBtn.setBackground(btnColor);
        gradeAssingmentBtn.setFont(btnFont);
        gradeAssingmentBtn.setForeground(btnFontColor);
        gradeAssingmentBtn.setFocusable(false);
        gradeAssingmentBtn.setBounds(45, 330, 180, 30);
        // Grades the assingment after the button is clicked
        gradeAssingmentBtn.addActionListener(
                e -> gradeAssingmentLecturer());
        gradeAssingmentPanel.add(gradeAssingmentBtn);

        // Button for clearing all the filled fields in the leturer section
        clearBtnLecturer = new JButton("CLEAR ALL FIELDS");
        clearBtnLecturer.setBounds(445, 490, 270, 40);
        clearBtnLecturer.setBorder(new LineBorder(Color.BLACK, 2));
        clearBtnLecturer.setBackground(Color.WHITE);
        clearBtnLecturer.setFont(btnFont);
        clearBtnLecturer.setForeground(Color.BLACK);
        clearBtnLecturer.setFocusable(false);
        clearBtnLecturer.addActionListener(
                e -> clearAllLecturerFields());
        lecturerAppPanel.add(clearBtnLecturer);

        // setting the lecturer section frame visible
        lecturerFrame.setVisible(true);
    }

    // Method for creating a new frame of Tutor Section
    private void createNewTutorFrame() {

        // Tutor Section frame
        tutorFrame = new JFrame("TUTOR SECTION");
        tutorFrame.setLayout(null);
        tutorFrame.setSize(730, 720);
        tutorFrame.setLocationRelativeTo(null);
        tutorFrame.setResizable(false);
        tutorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Tutor App Panel for adding all the components in it
        tutorAppPanel = new JPanel();
        tutorAppPanel.setSize(800, 680);
        tutorAppPanel.setLayout(null);
        tutorFrame.add(tutorAppPanel);

        // h1 Panel for tutor section main heading
        h1Panel = new JPanel();
        h1Panel.setBounds(0, 0, 720, 45);
        h1Panel.setBackground(btnColor);
        tutorAppPanel.add(h1Panel);

        // h1 label for heading one
        h1Lbl = new JLabel("TUTOR SECTION");
        h1Lbl.setFont(h1Font);
        h1Lbl.setForeground(Color.WHITE);
        h1Panel.add(h1Lbl);

        // Add Tutor Panel for adding new Tutor
        addTutorPanel = new JPanel();
        addTutorPanel.setBounds(15, 60, 400, 540);
        addTutorPanel.setLayout(null);
        addTutorPanel.setBorder(new LineBorder(Color.BLACK, 3));
        tutorAppPanel.add(addTutorPanel);

        // Heading 2 panel for add new tutor
        h2AddTutorPanel = new JPanel();
        h2AddTutorPanel.setBounds(2, 2, 395, 35);
        h2AddTutorPanel.setBackground(btnColor);
        addTutorPanel.add(h2AddTutorPanel);
        h2AddTutorLbl = new JLabel("ADD A NEW TUTOR");
        h2AddTutorLbl.setForeground(Color.WHITE);
        h2AddTutorLbl.setFont(h2Font);
        h2AddTutorPanel.add(h2AddTutorLbl);

        // Teacher ID label and textfield for add new tutor
        teacherIdLbl = new JLabel("Teacher ID");
        teacherIdLbl.setFont(lblFont);
        teacherIdLbl.setBounds(20, 60, 160, 30);
        addTutorPanel.add(teacherIdLbl);
        tutorIdField1 = new JTextField();
        tutorIdField1.setBorder(new LineBorder(Color.BLACK, 1));
        tutorIdField1.setBounds(180, 60, 200, 30);
        addTutorPanel.add(tutorIdField1);

        // Teacher Name label and textfield for add new tutor
        teacherNameLbl = new JLabel("Teacher Name");
        teacherNameLbl.setFont(lblFont);
        teacherNameLbl.setBounds(20, 100, 160, 30);
        addTutorPanel.add(teacherNameLbl);
        tutorNameField = new JTextField();
        tutorNameField.setBorder(new LineBorder(Color.BLACK, 1));
        tutorNameField.setBounds(180, 100, 200, 30);
        addTutorPanel.add(tutorNameField);

        // Address label and textfield for add new tutor
        addressLbl = new JLabel("Address");
        addressLbl.setFont(lblFont);
        addressLbl.setBounds(20, 140, 160, 30);
        addTutorPanel.add(addressLbl);
        tutorAddressField = new JTextField();
        tutorAddressField.setBorder(new LineBorder(Color.BLACK, 1));
        tutorAddressField.setBounds(180, 140, 200, 30);
        addTutorPanel.add(tutorAddressField);

        // Working type label and field for add new tutor
        workingTypeLbl = new JLabel("Working Type");
        workingTypeLbl.setFont(lblFont);
        workingTypeLbl.setBounds(20, 180, 200, 30);
        addTutorPanel.add(workingTypeLbl);
        tutorWorkingTypeField = new JTextField();
        tutorWorkingTypeField.setBorder(new LineBorder(Color.BLACK, 1));
        tutorWorkingTypeField.setBounds(180, 180, 200, 30);
        addTutorPanel.add(tutorWorkingTypeField);

        // Employment Status label and textfield for add new tutor
        employmentStatusLbl = new JLabel("Employment Status");
        employmentStatusLbl.setFont(lblFont);
        employmentStatusLbl.setBounds(20, 220, 200, 30);
        addTutorPanel.add(employmentStatusLbl);
        tutorEmploymentStatusField = new JTextField();
        tutorEmploymentStatusField.setBorder(new LineBorder(Color.BLACK, 1));
        tutorEmploymentStatusField.setBounds(180, 220, 200, 30);
        addTutorPanel.add(tutorEmploymentStatusField);

        // Working Hour label and textfield for add new tutor
        workingHourLbl = new JLabel("Working Hours");
        workingHourLbl.setFont(lblFont);
        workingHourLbl.setBounds(20, 260, 200, 30);
        addTutorPanel.add(workingHourLbl);
        tutorWorkingHoursField = new JTextField();
        tutorWorkingHoursField.setBorder(new LineBorder(Color.BLACK, 1));
        tutorWorkingHoursField.setBounds(180, 260, 200, 30);
        addTutorPanel.add(tutorWorkingHoursField);

        // Salary label and textfield for add new tutor
        salaryLbl = new JLabel("Salary");
        salaryLbl.setFont(lblFont);
        salaryLbl.setBounds(20, 300, 200, 30);
        addTutorPanel.add(salaryLbl);
        salaryField1 = new JTextField();
        salaryField1.setBorder(new LineBorder(Color.BLACK, 1));
        salaryField1.setBounds(180, 300, 200, 30);
        addTutorPanel.add(salaryField1);

        // Specialization label and textfield for add new tutor
        specializationLbl = new JLabel("Specialization");
        specializationLbl.setFont(lblFont);
        specializationLbl.setBounds(20, 340, 200, 30);
        addTutorPanel.add(specializationLbl);
        specializationField = new JTextField();
        specializationField.setBorder(new LineBorder(Color.BLACK, 1));
        specializationField.setBounds(180, 340, 200, 30);
        addTutorPanel.add(specializationField);

        // Academic Qualification label and textfield for add new tutor
        academicQlfyctnLabel = new JLabel("Academic Qualification");
        academicQlfyctnLabel.setFont(lblFont);
        academicQlfyctnLabel.setBounds(20, 380, 200, 30);
        addTutorPanel.add(academicQlfyctnLabel);
        academicQlfytnField = new JTextField();
        academicQlfytnField.setBorder(new LineBorder(Color.BLACK, 1));
        academicQlfytnField.setBounds(180, 380, 200, 30);
        addTutorPanel.add(academicQlfytnField);

        // Performance Index label and textfield for add new tutor
        performanceIndexLbl = new JLabel("Performance Index");
        performanceIndexLbl.setFont(lblFont);
        performanceIndexLbl.setBounds(20, 420, 200, 30);
        addTutorPanel.add(performanceIndexLbl);
        performanceIndexField1 = new JTextField();
        performanceIndexField1.setBorder(new LineBorder(Color.BLACK, 1));
        performanceIndexField1.setBounds(180, 420, 200, 30);
        addTutorPanel.add(performanceIndexField1);

        // Button for adding the new Tutor
        addNewTutorBtn = new JButton("Add Tutor");
        addNewTutorBtn.setFont(lblFont);
        addNewTutorBtn.setBackground(btnColor);
        addNewTutorBtn.setFont(btnFont);
        addNewTutorBtn.setForeground(btnFontColor);
        addNewTutorBtn.setFocusable(false);
        addNewTutorBtn.setBounds(100, 480, 200, 35);
        // Calls addNewTutor method for adding new tutor to arraylist
        addNewTutorBtn.addActionListener(
                e -> addNewTutor());
        addTutorPanel.add(addNewTutorBtn);

        // Set new salary panel for the tutor
        setSalaryPanel = new JPanel();
        setSalaryPanel.setBounds(430, 60, 270, 310);
        setSalaryPanel.setBorder(new LineBorder(Color.BLACK, 3));
        setSalaryPanel.setLayout(null);
        tutorAppPanel.add(setSalaryPanel);

        // Heading 2 panel for set salary
        h2setSalaryPanel = new JPanel();
        h2setSalaryPanel.setBounds(2, 2, 266, 35);
        h2setSalaryPanel.setBackground(btnColor);
        setSalaryPanel.add(h2setSalaryPanel);
        h2setSalaryLbl = new JLabel("SET NEW SALARY");
        h2setSalaryLbl.setForeground(Color.WHITE);
        h2setSalaryLbl.setFont(h2Font);
        h2setSalaryPanel.add(h2setSalaryLbl);

        // Teacher ID label and textfield for Salary setting
        teacherIdLbl = new JLabel("Teacher ID");
        teacherIdLbl.setFont(lblFont);
        teacherIdLbl.setBounds(20, 50, 160, 30);
        setSalaryPanel.add(teacherIdLbl);
        tutorIdField2 = new JTextField();
        tutorIdField2.setBorder(new LineBorder(Color.BLACK, 1));
        tutorIdField2.setBounds(20, 75, 230, 30);
        setSalaryPanel.add(tutorIdField2);

        // Salary label and textfield
        salaryLbl = new JLabel("New Salary");
        salaryLbl.setFont(lblFont);
        salaryLbl.setBounds(20, 115, 160, 30);
        setSalaryPanel.add(salaryLbl);
        salaryField2 = new JTextField();
        salaryField2.setBorder(new LineBorder(Color.BLACK, 1));
        salaryField2.setBounds(20, 140, 230, 30);
        setSalaryPanel.add(salaryField2);

        // Performance Index label and textfield
        performanceIndexLbl = new JLabel("New Performance Index");
        performanceIndexLbl.setFont(lblFont);
        performanceIndexLbl.setBounds(20, 180, 160, 30);
        setSalaryPanel.add(performanceIndexLbl);
        performanceIndexField2 = new JTextField();
        performanceIndexField2.setBorder(new LineBorder(Color.BLACK, 1));
        performanceIndexField2.setBounds(20, 205, 230, 30);
        setSalaryPanel.add(performanceIndexField2);

        // Button for setting salary of tutor
        setSalaryBtn = new JButton("Set Salary");
        setSalaryBtn.setFont(lblFont);
        setSalaryBtn.setBackground(btnColor);
        setSalaryBtn.setFont(btnFont);
        setSalaryBtn.setForeground(btnFontColor);
        setSalaryBtn.setFocusable(false);
        setSalaryBtn.setBounds(50, 260, 160, 30);
        // Calls setNewSalary method for setting salary for the tutor
        setSalaryBtn.addActionListener(
                e -> setNewSalary());
        setSalaryPanel.add(setSalaryBtn);

        // Remove tutor panel for the tutor
        removeTutorPanel = new JPanel();
        removeTutorPanel.setBounds(430, 385, 270, 215);
        removeTutorPanel.setLayout(null);
        removeTutorPanel.setBorder(new LineBorder(Color.BLACK, 3));
        tutorAppPanel.add(removeTutorPanel);

        // Heading 2 panel for remove tutor
        h2removeTutorPanel = new JPanel();
        h2removeTutorPanel.setBounds(2, 2, 266, 35);
        h2removeTutorPanel.setBackground(btnColor);
        removeTutorPanel.add(h2removeTutorPanel);
        h2removeTutorLbl = new JLabel("REMOVE TUTOR");
        h2removeTutorLbl.setForeground(Color.WHITE);
        h2removeTutorLbl.setFont(h2Font);
        h2removeTutorPanel.add(h2removeTutorLbl);

        // Teacher ID label and textfield for removing tutor
        teacherIdLbl = new JLabel("Teacher ID");
        teacherIdLbl.setFont(lblFont);
        teacherIdLbl.setBounds(20, 60, 160, 30);
        removeTutorPanel.add(teacherIdLbl);
        tutorIdField3 = new JTextField();
        tutorIdField3.setBorder(new LineBorder(Color.BLACK, 1));
        tutorIdField3.setBounds(20, 90, 230, 30);
        removeTutorPanel.add(tutorIdField3);

        // Button for removing tutor
        removeTutorBtn = new JButton("Remove Tutor");
        removeTutorBtn.setFont(lblFont);
        removeTutorBtn.setBackground(new Color(200, 60, 55));
        removeTutorBtn.setFont(btnFont);
        removeTutorBtn.setForeground(btnFontColor);
        removeTutorBtn.setFocusable(false);
        removeTutorBtn.setBounds(50, 145, 160, 35);
        // Calls the removeTutorAction method for removing the tutor
        removeTutorBtn.addActionListener(
                e -> removeTutorAction());
        removeTutorPanel.add(removeTutorBtn);

        // Button for clearing all the filled fields in tutor section
        clearBtnTutor = new JButton("CLEAR ALL FIELDS");
        clearBtnTutor.setBorder(new LineBorder(Color.BLACK, 2));
        clearBtnTutor.setBackground(Color.WHITE);
        clearBtnTutor.setFont(btnFont);
        clearBtnTutor.setForeground(Color.BLACK);
        clearBtnTutor.setFocusable(false);
        clearBtnTutor.setBounds(430, 625, 270, 40);
        // Calls clearAllTutorFields method to clear all the fields
        clearBtnTutor.addActionListener(
                e -> clearAllTutorFields());
        tutorAppPanel.add(clearBtnTutor);

        // Setting the tutor frame visible
        tutorFrame.setVisible(true);

    }

    // Method for creating a new display frame
    private void createNewDisplayFrame() {

        // Display frame for Display Info
        displayFrame = new JFrame();
        displayFrame.setSize(360, 355);
        displayFrame.setLayout(null);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setResizable(false);
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Display app panel for adding other components in it
        displayAppPanel = new JPanel();
        displayAppPanel.setSize(360, 320);
        displayAppPanel.setLayout(null);
        displayFrame.add(displayAppPanel);

        // h1 Panel for heading one
        h1Panel = new JPanel();
        h1Panel.setBounds(0, 0, 400, 45);
        h1Panel.setBackground(btnColor);
        displayAppPanel.add(h1Panel);

        // h1 label for heading one
        h1Lbl = new JLabel("Display Teacher Info");
        h1Lbl.setFont(h1Font);
        h1Lbl.setForeground(Color.WHITE);
        h1Panel.add(h1Lbl);

        // Teacher ID label and textfield for displaying the teacher info
        teacherIdLbl = new JLabel("Teacher ID");
        teacherIdLbl.setFont(lblFont);
        teacherIdLbl.setBounds(60, 100, 160, 30);
        displayAppPanel.add(teacherIdLbl);
        infoTeacherIdField = new JTextField();
        infoTeacherIdField.setBorder(new LineBorder(Color.BLACK, 1));
        infoTeacherIdField.setBounds(60, 130, 230, 40);
        displayAppPanel.add(infoTeacherIdField);

        // Button for displaying the teacher info
        displayInfoBtn = new JButton("Display Info");
        displayInfoBtn.setBackground(btnColor);
        displayInfoBtn.setFont(btnFont);
        displayInfoBtn.setForeground(btnFontColor);
        displayInfoBtn.setFocusable(false);
        displayInfoBtn.setBounds(90, 220, 160, 40);
        // Calls displayTeacherInfo method to display the teacher's info
        displayInfoBtn.addActionListener(
                e -> displayTeacherInfo());
        displayAppPanel.add(displayInfoBtn);

        // Setting the displayFrame visible
        displayFrame.setVisible(true);

    }

    // Method for displaying teacher info based on ID provided
    private void displayTeacherInfo() {
        try {
            String teacherIdText = getTextFromTFValidate(infoTeacherIdField);
            int teacehrId = convertToPositiveIntValue(teacherIdText);
            Teacher teacherobj = validateTeacherId(teacehrId);

            // Checking if teacher with such id is registered. If not
            if (teacherobj == null) {
                JOptionPane.showMessageDialog(displayFrame, "Teacher with provided Id is not registered.",
                        "Invalid teacher Id", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Displays information in a dialog box
            displayTeacherDetailsBox(teacherobj);
        }

        // Catching exception thrown when changing the data type
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(displayFrame, " Teacher ID must be a positive number", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
        // Catching exception thrown if any of the field is empty
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(displayFrame, "Fill the TeacherId Field.", "Empty Field",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    // Method that fetch data from the arraylist objects combine it and displays in
    // dialog box
    private void displayTeacherDetailsBox(Teacher teacherobj) {
        String teacherInfo = "";
        teacherInfo = "Teacher Id: " + teacherobj.getTeacherId() + "\n";
        teacherInfo += "Teacher Name: " + teacherobj.getTeacherName() + "\n";
        teacherInfo += "Address: " + teacherobj.getAddress() + "\n";
        teacherInfo += "Working Type: " + teacherobj.getWorkingType() + "\n";
        teacherInfo += "Employment Status: " + teacherobj.getEmploymentStatus() + "\n";
        if (teacherobj.getWorkingHour() >= 0) {
            teacherInfo += "Working Hours: " + teacherobj.getWorkingHour() + "\n";
        }

        // Checking if the object is instance of Lecturer
        if (teacherobj instanceof Lecturer) {
            Lecturer lecturerObj = (Lecturer) teacherobj; // Down casting to Lecturer
            teacherInfo += "Department: " + lecturerObj.getDepartment() + "\n";
            teacherInfo += "Year Of Experience: " + lecturerObj.getExperienceYears() + "\n";
            if (lecturerObj.getHasGraded()) {
                teacherInfo += "Graded Score: " + lecturerObj.getGradedScore() + "\n";
            } else {
                teacherInfo += "\nThe lecturer has not graded the assingment yet!";
            }

            // Calling Lecturer display method
            lecturerObj.display();
            JOptionPane.showMessageDialog(displayAppPanel, teacherInfo, "Lecturer Info",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // And if the object is instance of tutor
        Tutor tutorObj = (Tutor) teacherobj; // Down casting to Tutor

        if (tutorObj.getIsCertified()) {
            teacherInfo += "Salary: " + tutorObj.getSalary() + "\n";
            teacherInfo += "Specialization: " + tutorObj.getSpecialization() + "\n";
            teacherInfo += "Academic qualification: " + tutorObj.getAcademicQualification() + "\n";
            teacherInfo += "Performance Index: " + tutorObj.getPerformanceIndex() + "\n";
        }

        // Calling Tutor display method
        tutorObj.display();
        JOptionPane.showMessageDialog(displayAppPanel, teacherInfo, "Tutor Information ",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Method that add new lecturer to arraylist after all validations
    private void addNewLecturer() {

        try {
            // Fetching data from all the text fields of add Lecturer panel
            String teacherIdText = getTextFromTFValidate(lecturerIdField1);
            String teacherName = getTextFromTFValidate(lecturerNameField);
            String address = getTextFromTFValidate(lecturerAddressField);
            String workingType = getTextFromTFValidate(lecturerWorkingTypeField);
            String employmentStatus = getTextFromTFValidate(lecturerEmploymentStatusField);
            String department = getTextFromTFValidate(departmentField1);
            String yearOfExperienceText = getTextFromTFValidate(lecturerYearOfExperField1);
            String workingHourText = getTextFromTFValidate(lecturerWorkingHoursField);

            // Changing the data type as required for creating object
            int teacherId = convertToPositiveIntValue(teacherIdText);
            int workingHour = convertToPositiveIntValue(workingHourText);
            int yearOfExperience = convertToPositiveIntValue(yearOfExperienceText);

            // Checking if the provided id is zero.
            if (teacherId == 0) {
                JOptionPane.showMessageDialog(addLecturerPanel, "Teacher Id cannot be zero.", "Invalid input Id",
                        JOptionPane.ERROR_MESSAGE);
            }

            // Checking if the Teacher id is unique or teacher with that id exists
            if (!isTeacherIdUnique(teacherId)) {
                JOptionPane.showMessageDialog(addLecturerPanel, "Teacher with this Id already exists.",
                        "ID already exists", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String message = "Do you want to add the lecturer ? \n" + "Teacher ID : " + teacherIdText
                    + "\nTeacher Name : " + teacherName + "\nAddress : " + address + "\n Working Type : " + workingType
                    + "\nDepartment : " + department;
            int response = JOptionPane.showConfirmDialog(addLecturerPanel, message,
                    "Add Tutor", JOptionPane.OK_CANCEL_OPTION);

            if (response == JOptionPane.OK_OPTION) {

                // Creating lecturer object as teacher and adding in arraylist
                Teacher lecturerObj = new Lecturer(teacherId, teacherName, address, workingType, employmentStatus,
                        department,
                        yearOfExperience, workingHour);
                teacherInfoData.add(lecturerObj);
                JOptionPane.showMessageDialog(lecturerFrame, "Teacher registered successfully. ", "Successful",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

        }

        // Catching exception thrown when changing the data type
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(addLecturerPanel,
                    " Teacher ID, Working Hour,Year of Experience\n must be a positive number for registering lecturer.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
        // Catching exception thrown if any of the field is empty
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(addLecturerPanel, "Fill remaining empty fields \nin add lecturer panel.",
                    "Empty Field",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    // Method that grades the assingment of students after validating info
    private void gradeAssingmentLecturer() {
        try {
            String teacherIdText = getTextFromTFValidate(lecturerIdField2);
            String gradedScoreText = getTextFromTFValidate(gradedScoreField);
            String newDepartment = getTextFromTFValidate(departmentField2);
            String yearOfExperienceText = getTextFromTFValidate(lecturerYearOfExperField2);

            int teacherId = convertToPositiveIntValue(teacherIdText);
            int yearOfExperience = convertToPositiveIntValue(yearOfExperienceText);
            int gradedScore = convertToPositiveIntValue(gradedScoreText);
            if (gradedScore > 100) {
                JOptionPane.showMessageDialog(gradeAssingmentPanel, "Score should be between 0 and 100.",
                        "Grade score not valid", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Teacher teacherObj = validateTeacherId(teacherId);
            if (teacherObj == null) {
                JOptionPane.showMessageDialog(gradeAssingmentPanel, "Teacher with this ID is not registered.",
                        "ID not found", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (teacherObj instanceof Tutor) {
                JOptionPane.showMessageDialog(gradeAssingmentPanel,
                        "Provided id is of a Tutor.\nCannot perform grading by tutor.", "Invalid lecturer Id",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Lecturer lecturerObj = (Lecturer) teacherObj; // Down Casting to Lecturer

            // Validating if the lecturer is eligible to grade the assingment
            if (yearOfExperience >= 5 && newDepartment.equals(lecturerObj.getDepartment())) {
                String msg = "Do you want to grade the assingment ?\n" + "Teacher Id : " + teacherIdText
                        + "\nGrade Score : " + gradedScore + "\nDepartment : " + newDepartment
                        + "\nYear of experience : " + yearOfExperienceText;
                int result = JOptionPane.showConfirmDialog(gradeAssingmentPanel,
                        msg, "Are you sure", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.CANCEL_OPTION) {
                    return;
                }
                lecturerObj.gradeAssignment(gradedScore, newDepartment, yearOfExperience);
                JOptionPane.showMessageDialog(lecturerFrame, "Assingment Graded Sucessfully.",
                        "Sucessfully graded", JOptionPane.INFORMATION_MESSAGE);
                return;

            }
            JOptionPane.showMessageDialog(gradeAssingmentPanel, "Lecturer is not eligible to \ngrade the assingment. ",
                    "Not eligible!", JOptionPane.ERROR_MESSAGE);
        }

        // Catching exception thrown when changing the data type
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(gradeAssingmentPanel,
                    " Teacher ID, Graded,Year of Experience\n must be a positive number for grading.", "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
        // Catching exception thrown if any of the field is empty
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(gradeAssingmentPanel,
                    "Fill remaining empty fields\nin grade assingment panel.", "Empty Field",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to set all fields empty or say clear all the fields of lecturer frame
    private void clearAllLecturerFields() {
        int result = JOptionPane.showConfirmDialog(lecturerFrame, "Do you want to clear all the fields ?",
                "Clear fields", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            lecturerIdField1.setText("");
            lecturerNameField.setText("");
            lecturerAddressField.setText("");
            lecturerWorkingTypeField.setText("");
            lecturerEmploymentStatusField.setText("");
            departmentField1.setText("");
            lecturerYearOfExperField1.setText("");
            lecturerWorkingHoursField.setText("");
            lecturerIdField2.setText("");
            gradedScoreField.setText("");
            departmentField2.setText("");
            lecturerYearOfExperField2.setText("");

        }
    }

    // Method to validate the info filled and to add new tutor to the arraylist
    private void addNewTutor() {
        try {
            // Fetching data from all the text fields of add Tutor panel
            String teacherIdText = getTextFromTFValidate(tutorIdField1);
            String teacherName = getTextFromTFValidate(tutorNameField);
            String address = getTextFromTFValidate(tutorAddressField);
            String workingType = getTextFromTFValidate(tutorWorkingTypeField);
            String employmentStatus = getTextFromTFValidate(tutorEmploymentStatusField);
            String workingHourText = getTextFromTFValidate(tutorWorkingHoursField);
            String salaryText = getTextFromTFValidate(salaryField1);
            String specialization = getTextFromTFValidate(specializationField);
            String academicQlfytn = getTextFromTFValidate(academicQlfytnField);
            String performanceIndexText = getTextFromTFValidate(performanceIndexField1);

            // Changing the data type of teacherId workingHour and yearOfExperience as
            // required for creating new object of lecturer
            int teacherId = convertToPositiveIntValue(teacherIdText);
            int workingHour = convertToPositiveIntValue(workingHourText);
            int performanceIndex = convertToPositiveIntValue(performanceIndexText);
            double salary = convertToPositiveIntValue(salaryText);
            if (performanceIndex > 10) {
                JOptionPane.showMessageDialog(addTutorPanel, "Performance index should be between (0-10).",
                        "Invalid Performance index", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Checking if the provided id is zero.
            if (teacherId == 0) {
                JOptionPane.showMessageDialog(addTutorPanel, "Teacher Id cannot zero.", "Invalid input Id",
                        JOptionPane.ERROR_MESSAGE);
            }

            // Checking if the Teacher id is unique or already exists
            if (!isTeacherIdUnique(teacherId)) {
                JOptionPane.showMessageDialog(addTutorPanel, "Teacher with similar Id already exists.",
                        "ID already exists", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int response = JOptionPane.showConfirmDialog(addTutorPanel, "Do you want to add the tutor ?", "Add Tutor",
                    JOptionPane.OK_CANCEL_OPTION);
            if (response == JOptionPane.OK_OPTION) {
                // If the teacehr id is unique then creating it object and adding it to
                // arraylist
                Teacher tutorObj = new Tutor(teacherId, teacherName, address, workingType, employmentStatus,
                        workingHour, salary, specialization, academicQlfytn, performanceIndex);
                teacherInfoData.add(tutorObj);
                JOptionPane.showMessageDialog(tutorFrame, "Teacher Sucessfully added", "Sucessful",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

        }

        // Catching exception thrown when changing the data type
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(tutorFrame,
                    " Teacher ID,\n Working Hour, Salary\n and Performance Index\n must be a positive number",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Catching exception thrown if any of the field is empty
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(addTutorPanel, "Fill all the empty Fields\n in add Tutor Panel.",
                    "Empty Field",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method that handles setting salary if the tutor is eligible for it
    private void setNewSalary() {
        try {
            String teacherIdText = getTextFromTFValidate(tutorIdField2);
            String newSalaryText = getTextFromTFValidate(salaryField2);
            String newPerformanceIndexText = getTextFromTFValidate(performanceIndexField2);

            int teacherId = convertToPositiveIntValue(teacherIdText);
            double newSalary = convertToPositiveDoubleValue(newSalaryText);
            int newPerformanceIndex = convertToPositiveIntValue(newPerformanceIndexText);
            if (newPerformanceIndex > 10) {
                JOptionPane.showMessageDialog(setSalaryPanel, "Performance index value between 0 and 10.",
                        "Invalid Performance index", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Teacher teacherObj = validateTeacherId(teacherId);
            if (teacherObj == null) {
                JOptionPane.showMessageDialog(setSalaryPanel, "Teacher with this id is not registered.", "Id not found",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (teacherObj instanceof Lecturer) {
                JOptionPane.showMessageDialog(setSalaryPanel,
                        "Provided id is a Lecturer.\nCannot set new salary for lecturer.",
                        "Invalid ID for tutor.", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Tutor tutorObj = (Tutor) teacherObj; // Down Casting to Tutor

            // Validating conditions for setting new salary.
            if (newPerformanceIndex >= 5 && tutorObj.getWorkingHour() > 20) {
                int result = JOptionPane.showConfirmDialog(setSalaryPanel, "Do you want to set salary ?",
                        "Are you sure ", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.CANCEL_OPTION) {
                    return;
                }

                tutorObj.setSalary(newSalary, newPerformanceIndex);
                JOptionPane.showMessageDialog(setSalaryPanel,
                        "Approved teacher's salary successfully \n" + "New Salary: " + tutorObj.getSalary(),
                        "Successfull", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(setSalaryPanel,
                    "Salary cannot be approved.\nThe tutor is not certified for appraisal.", "Not certified",
                    JOptionPane.ERROR_MESSAGE);

        }
        // Catching exception thrown when changing the data type
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(setSalaryPanel,
                    " Teacher ID, Salary, Performance Index must be \na positive number for setting new salary.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Catching exception thrown if any of the field is empty
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(setSalaryPanel, "Fill remaining empty fields.", "Empty Field set salary",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to remove the tutors that are not certified
    private void removeTutorAction() {
        try {
            String teacherIdText = getTextFromTFValidate(tutorIdField3);
            int teacherId = convertToPositiveIntValue(teacherIdText);
            Teacher teacherObj = validateTeacherId(teacherId);
            if (teacherObj == null) {
                JOptionPane.showMessageDialog(tutorFrame, "Teacher with this id is not registered.",
                        "Id not found", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (teacherObj instanceof Lecturer) {
                JOptionPane.showMessageDialog(tutorFrame, "Provided id is a Lecturer.\nCannot remove.",
                        "Not a Tutor", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Tutor tutorObj = (Tutor) teacherObj; // Down Casting to Tutor

            // Checking if the tutor is not certified
            if (!tutorObj.getIsCertified()) {
                String msg = "Do you want to remove this tutor ?\n Tutor Id : " + teacherId + "\n" + "Teacher Name : "
                        + tutorObj.getTeacherName();
                int result = JOptionPane.showConfirmDialog(tutorFrame, msg,
                        "Remove Tutor", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    tutorObj.removeTutor();
                    JOptionPane.showMessageDialog(tutorFrame, "Tutor sucessfully removed.", "Sucessfully Removed",
                    JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(tutorFrame, "Tutor is Certified.\nCannot be Removed.",
                    "Cannot Remove", JOptionPane.ERROR_MESSAGE);

        }

        // Catching exception thrown when changing the data type
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(tutorFrame,
                    " Teacher ID must be a positive number",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Catching exception thrown if any of the field is empty
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(tutorFrame, "Fill all the empty Fields\n in remove Tutor Panel.",
                    "Empty Field",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    // Method to set all fields empty or say clear all the fields of tutor frame
    private void clearAllTutorFields() {
        int result = JOptionPane.showConfirmDialog(tutorFrame, "Do you want to clear all the fields ?", "Clear all",
                JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            tutorIdField1.setText("");
            tutorNameField.setText("");
            tutorAddressField.setText("");
            tutorWorkingTypeField.setText("");
            tutorEmploymentStatusField.setText("");
            tutorWorkingHoursField.setText("");
            salaryField1.setText("");
            specializationField.setText("");
            academicQlfytnField.setText("");
            performanceIndexField1.setText("");
            tutorIdField2.setText("");
            salaryField2.setText("");
            performanceIndexField2.setText("");
            tutorIdField3.setText("");
        }

    }

    // This method takes a text field as argument and validate wether or not it's
    // blank if not return field text
    private String getTextFromTFValidate(JTextField tf) {
        String content = tf.getText().trim();
        if (content.isBlank()) {
            throw new IllegalArgumentException();
        }
        return content;
    }

    // Method to validate wether or not a Teacher with provided ID already exists in
    // arraylist
    private boolean isTeacherIdUnique(int teacherId) {
        for (Teacher teacher : teacherInfoData) {

            if (teacherId == teacher.getTeacherId()) {
                return false;
            }
        }
        return true;
    }

    // Method that validates wether or not the teacher with this id is registered.
    // If it's in arraylist then it returns that particular object of teacher
    private Teacher validateTeacherId(int teacherId) {
        for (Teacher teacher : teacherInfoData) {
            if (teacher.getTeacherId() == teacherId) {
                return teacher;
            }
        }
        return null;
    }

    // This method converts and checks wether it is positive integer or not.
    // If yes returns the converted value else throws exception.
    private int convertToPositiveIntValue(String str) {
        int value = Integer.parseInt(str);
        if (value < 0) {
            throw new NumberFormatException();
        }
        return value;
    }

    // This method converts and checks wether it is positive double value or not.
    // If yes returns the converted value else throws exception.
    private double convertToPositiveDoubleValue(String str) {
        double value = Double.parseDouble(str);
        if (value < 0) {
            throw new NumberFormatException();
        }
        return value;
    }

    // Creating an instance of this class
    public static void main(String[] args) {
        new TeacherGUI();
    }
}
