 

/**
 * This is Lecture class which is created for storing details of lecturers.
 * author@ Rajendra Katuwal
 * London Met ID: 23049377
 * College ID: np05cp4a230255
 */
public class Lecturer extends Teacher{
    //Declaring attributes for Lecturer class following the encapsulation.
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;
    
    // constructor that accepts eight parameter values.
    public Lecturer(int teacherId,String teacherName, String address,String workingType, String employmentStatus, 
    String department, int yearsOfExperience, int workingHour)
    {
        super(teacherId,teacherName,address,workingType,employmentStatus);
        super.setWorkingHour(workingHour);
        this.yearsOfExperience = yearsOfExperience;
        this.department = department;
        this.gradedScore = 0;
        this.hasGraded = false;
    } 
    // Getter methods that returns value individually of all the attributes .
    public String getDepartment(){
        return department;
    }
    public int getExperienceYears(){
        return yearsOfExperience;
    }
    public int getGradedScore(){
        return gradedScore;
    }
    public boolean getHasGraded(){
        return hasGraded;
    }    
    // Mutator(Setter) method for gradedScore that sets the value for gradedScore.
    public void setGradedScore(int gradedScore){
        this.gradedScore = gradedScore;
    }
    //This method is for grading assingment according to gradedScore only if the Tutor is eligible to grade the assingment.
    public void gradeAssignment(int gradedScore,String department,int yearsOfExperience){
        if(yearsOfExperience>=5 && department.equals(this.department)){
            if(gradedScore>=70 && gradedScore<=100){
                System.out.println("Grade A");
                this.gradedScore = gradedScore;
            }
            else if(gradedScore>=60){
                System.out.println("Grade B");
                this.gradedScore = gradedScore;
            }
            else if(gradedScore>=50){
                System.out.println("Grade C");
                this.gradedScore = gradedScore;
            }
            else if(gradedScore>=40){
                System.out.println("Grade D");
                this.gradedScore = gradedScore;
            }
            else if(gradedScore<40 && gradedScore>=0){
                System.out.println("Grade E");
                this.gradedScore = gradedScore;
            }
            hasGraded = true;
        }
        else{
            System.out.println("Lecturer not eligible to grade the assingment.");
        }
    }
    public void display(){
        super.display();
        System.out.println("The department is : " + department);
        System.out.println("The years of experience is : " + yearsOfExperience);
        if(!hasGraded)
        {
            System.out.println("The lecturer has not graded the Assingment yet!!");
        }
        else
        {
            System.out.println("The graded score is : " + gradedScore);
        }
        
    }
}





