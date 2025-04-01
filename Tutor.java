 
/**
 * This is Tutor class which is created for storing details of Tutors.
 * author@ Rajendra Katuwal
 * London Met ID: 23049377
 * College ID: np05cp4a230255
 */
public class Tutor extends Teacher{
    private double salary;
    private String specialization;
    private String academicQualification;
    private int performanceIndex;
    private boolean isCertified;
    // Constructor for Tutor class that assigns value for its attributes.
    public Tutor(int teacherId,String teacherName, String address,String workingType, String employmentStatus,int workingHour,double salary,String specialization,String academicQualification,int performanceIndex){
        super(teacherId,teacherName,address,workingType,employmentStatus);
        super.setWorkingHour(workingHour);
        this.performanceIndex = performanceIndex;
        this.salary = salary;
        this.specialization = specialization;
        this.isCertified = false;
        this.academicQualification = academicQualification;
    }
    //Acessor methods to return values of all the attributes individually.
    public double getSalary()
    {
        return salary;
    }
    public String getSpecialization()
    {
        return specialization;
    }
    public String getAcademicQualification()
    {
        return academicQualification;
    }
    public int getPerformanceIndex()
    {
        return performanceIndex;
    }
    public boolean getIsCertified()
    {
        return isCertified;
    }
    //mutator method for updating salary based on performance.
    public void setSalary(double newSalary,int newPerformanceIndex)
    {
            if(newPerformanceIndex>=5 && getWorkingHour()>20)
            {
              double appraisalPercentage = 0;
              if(newPerformanceIndex>=5 && newPerformanceIndex<=7)
              {
                  appraisalPercentage = 5.0/100;
              }
              else if(newPerformanceIndex>=8 && newPerformanceIndex<=9)
              {
                  appraisalPercentage= 10.0/100;
              }
              else if(newPerformanceIndex==10)
              {
                  appraisalPercentage = 20.0/100;          
              }
              this.salary = (newSalary+(appraisalPercentage*newSalary));
              this.performanceIndex = newPerformanceIndex;
              this.isCertified=true;
              System.out.println("Approved teacher's salary sucessfully "+ salary);
            }
            else 
            {
                System.out.println("Salary cannot be approved.The tutor is not certified for appraisal.");
            }
    }
    //The method below is used for removing the tutor who is not certified.
    public void removeTutor()
    {
        if(!isCertified)    
        {
            salary=0;
            specialization="";
            academicQualification="";
            performanceIndex=0;
            isCertified=false;
            System.out.println("The tutor has been removed because s/he is not certified.");
        }
        else{
            System.out.println("The tutor cannot be removed because s/he is certified.");
        }
    }
    //This method display some or all attributes values based on Tutor certification.
    public void display ()
    {
        super.display();
        if(isCertified)
        {
            System.out.println("Salary:"+salary);  
            System.out.println("Specialization:"+specialization); 
            System.out.println("Academic qualification:"+academicQualification); 
            System.out.println("Performance Index:"+performanceIndex);
        }
    }
}

