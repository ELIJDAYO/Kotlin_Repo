import java.util.Date
import javax.swing.plaf.nimbus.State

enum class Statuses{
    FOR_INTERVIEW,
    FOR_JOB_OFFER,
    WILL_TAKE_THE_JOB,
    WILL_NOT_TAKE_THE_JOB,
    FOR_CONTRACT_SIGNING,
    CONTRACT_SIGNING,
    ACCEPTED_POSITION
}

class Department(){
    var DepartmentName=""
    var DepartmentLocation=""
    var Employees:ArrayList<Teacher>? = null
    var ApplicationForm:ArrayList<ApplicationForm>?=null
}
class Teacher(){
    var DateAdded:Date? =null
    var Teacher:Person?=null
}
class ApplicationForm(){
    var Applicant:Person?=null
    var JobOffered:String=""
    var State: Statuses=Statuses.FOR_INTERVIEW
}
class SchoolAttended() {
    var HighSchoolName: String = ""
    var YearGraduated: Int = 0
    var HightSchoolAddress: String = ""
    var CollegeAttended: ArrayList<CollegeAttended>? = null
}
class CollegeAttended(){
    var NameSchool:String=""
    var AddressSchool:String=""
    var SYAYAttended:String =""
    var Term:Int=0
}
class Contacts(
    var EmailAddress:String="",
    var TelephoneNumber:String=""
){}
open class Person(
    var LastName:String="",
    var FirstName:String=""
){
    var MiddleName:String=""
    var NickName:String=""
    var Age:Int=0
        get() = field
        set(value) {
            field  = value
        }
    var Gender:String=""
    var Religion:String=""
    var Contact: Contacts?=Contacts()
        set(value) {
            field = value
        }
    var schoolAttended: SchoolAttended?=SchoolAttended()
        set(value) {
            field = value
        }
    var PlaceofBirth:String=""
    var CivilStatus:String=""
    var Citizenship:String=""
    var DateofBirth:Date?=null
    var NameofSpouseifMarried:String=""
    constructor():this(
        "",
        "",
    )

}


fun main(){
    //Fill application form
    var p1 = Person("Dayon", "Elijah")
        p1.Age=24
        p1.CivilStatus="Single"
        p1.Gender="Male"

        p1.DateofBirth = Date(2000,7,4)
    var contact_p1 = Contacts()
        contact_p1.EmailAddress = "____@gmail.com"
        contact_p1.TelephoneNumber = "09-____-_____"
    p1.Contact = contact_p1
    var college_list = ArrayList<CollegeAttended>()
        college_list.add(CollegeAttended())
    var class_taken = college_list[college_list.size-1]
        class_taken.NameSchool = "DLSU"
        class_taken.SYAYAttended="2023-2024"
        class_taken.Term=1
    var school_hist_p1 = SchoolAttended()
        school_hist_p1.HighSchoolName="UST-SHS"
        school_hist_p1.YearGraduated=2017
        school_hist_p1.CollegeAttended=college_list

    //Create Department  where applicant is applying
    var ccs = Department()
        ccs.DepartmentLocation = "GK"
        ccs.DepartmentName = "CCS"

    //Submit application form to Department for review
    var application_p1=ApplicationForm()
        application_p1.Applicant=p1

    ccs.ApplicationForm = ArrayList<ApplicationForm>()
    ccs.ApplicationForm!!.add(application_p1)
    var size: Int? = ccs.ApplicationForm?.size
    var underReview = ccs.ApplicationForm?.get(size!!-1)
    println("The state of ${underReview?.Applicant?.FirstName} is ${underReview?.State}")
    underReview?.JobOffered="DATA100 Part-time"
    println("${underReview?.Applicant?.FirstName} is offered ${underReview?.JobOffered}")
    underReview?.State = Statuses.WILL_TAKE_THE_JOB
    println("${underReview?.Applicant?.FirstName} ${underReview?.State} ${underReview?.JobOffered}")
    underReview?.State = Statuses.ACCEPTED_POSITION
    println("${ccs.DepartmentName} ${underReview?.State} of ${underReview?.Applicant?.FirstName} ")

    //Add applicant to teacher record
    var ccsTeacher = Teacher()
        ccsTeacher.Teacher=p1
        ccsTeacher.DateAdded = Date(2022, 10, 17)
    ccs.Employees = ArrayList<Teacher>()
    ccs.Employees?.add(ccsTeacher)
    size = ccs.Employees?.size
    if (size != null) {
        ccsTeacher = ccs.Employees?.get(size-1)!!
    }
    println("${ccsTeacher.Teacher!!.FirstName} is a teacher since ${ccsTeacher.DateAdded}")

}