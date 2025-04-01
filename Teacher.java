 


/**
 * This is Teacher class which is created for storing details of lecturers and tutor.
 * author@ Rajendra Katuwal
 * London Met ID: 23049377
 * College ID: np05cp4a230255
 */
public class Teacher{
    // Attributes declared following the encapsulation.
    private String teacherName;
    private int teacherId;
    private String workingType;
    private String employmentStatus;
    private String address;
    private int workingHour;
    
    /* Constructor that have five formal parameters which values 
    are assinged to their corresponding attributes above.*/
    
    public Teacher(int teacherId,String teacherName,String address,String workingType,String employmentStatus){
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.address = address;
        this.workingType = workingType;
        this.employmentStatus = employmentStatus;
    }
    
    // Getter methods that returns value individually for every attributes on this class.
    public String getTeacherName(){
        return teacherName;
    }
        public int getTeacherId(){
        return teacherId;
    }
        public String getWorkingType(){
        return workingType;
    }
        public String getEmploymentStatus(){
        return employmentStatus;
    }
        public String getAddress(){
        return address;
    }
        public int getWorkingHour(){
        return workingHour;
    }
    
    // Setter(Acessor) method to set the value of working hour.
    public void setWorkingHour(int workingHour){
        this.workingHour = workingHour;         // assinging the value to workingHour attribute
    }
    
    // Displays the values of all the attributes .
    public void display(){
        System.out.println("Teacher name    : "+this.teacherName);
        System.out.println("Teacher Id      : "+this.teacherId);
        System.out.println("Working Type    : "+this.workingType);
        System.out.println("Address         : " +this.address);
        System.out.println("Employment Status : "+this.employmentStatus);
        
        // Checking if the value for workingHour is set or not 
        if(this.getWorkingHour()!=0){
            System.out.println("Working Hour : "+workingHour);      //execute this if the value has been assinged for working hour.
        }
        else{
            System.out.println("Working Hour has not been set.");   //execute this if the value has not been assinged for working hour.
        }
    }
}
