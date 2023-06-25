import kotlin.math.max

//Class to store workshop details 
class WorkshopData {
    var workshopName: String
    var instructorName: String
    var location: String
    var date: String
    var time: String
    var capacity: Int
    
    constructor(workshopName: String, instructorName: String, location: String, date: String, time: String, capacity: Int) {
        this.workshopName = workshopName
        this.instructorName = instructorName
        this.location = location
        this.date = date
        this.time = time
        this.capacity = capacity
    }
    
    //Function to register a student to the workshop
    fun registerToWorkshop(studentName: String, studentEmail: String): Boolean {
        // check to see if capacity has been reached
        if (capacity < 1) {
            return false
        }
        //Output message
        println("Welcome to the Workshop! 
        \nStudent Name: $studentName 
        \nStudent Email: $studentEmail 
        \nWorkshop: $workshopName
        \nInstructor: $instructorName 
        \nLocation: $location 
        \nDate: $date 
        \nTime: $time
        \nYou are now registered!
        \nSee you soon!")
        capacity--
        return true
    }
    
    //Function to get the capacity of a workshop
    fun getCapacity(): Int {
        return capacity
    }
}

//Function to create workshop
fun createWorkshop(workshopName: String, instructorName: String, location: String, date: String, time: String, capacity: Int): WorkshopData {
    val workshop = WorkshopData(workshopName, instructorName, location, date, time, capacity)
    println("Workshop '$workshopName' created!")
    return workshop
}

//Function to create workshops from a list of details
fun createWorkshopsFromList(workshopList: MutableList<WorkshopData>) {
    for (workshop in workshopList) {
        println("Workshop '${workshop.workshopName}' created!")
    }
}

//Function to update a workshop capacity
fun updateWorkshopCapacity(workshop: WorkshopData, newCapacity: Int) {
    workshop.capacity = max(workshop.capacity, newCapacity)
    println("Workshop '${workshop.workshopName}' updated to capacity: ${workshop.capacity}!")
}

//Function to check if a user is registered to a workshop
fun checkIfRegistered(workshop: WorkshopData, studentName: String): Boolean {
    // check if student is registered
    if (workshop.capacity > 0) {
        return false
    }
    println("Student '$studentName' is registered for workshop '${workshop.workshopName}'")
    return true
}

//Function to list all workshops
fun listWorkshops(workshopList: MutableList<WorkshopData>) {
    for (workshop in workshopList) {
        println("Workshop: ${workshop.workshopName} 
        \nInstructor: ${workshop.instructorName} 
        \nLocation: ${workshop.location} 
        \nDate: ${workshop.date} 
        \nTime: ${workshop.time} 
        \nCapacity: ${workshop.capacity}")
    }
}

//Function to display workshop details
fun displayWorkshopDetails(workshop: WorkshopData) {
    println("Workshop: ${workshop.workshopName} 
    \nInstructor: ${workshop.instructorName} 
    \nLocation: ${workshop.location} 
    \nDate: ${workshop.date} 
    \nTime: ${workshop.time} 
    \nCapacity: ${workshop.capacity}")
}

//Function to cancel a workshop
fun cancelWorkshop(workshop: WorkshopData) {
    println("Workshop '${workshop.workshopName}' has been cancelled.")
    workshop.capacity = 0
    //Return all registered students their money
}

//Create a list to store workshop details
var workshopList: MutableList<WorkshopData> = mutableListOf()

//Create Workshops
val somaticTherapyWorkshop = createWorkshop("Somatic Therapy Workshop", "John Doe", "123 Main Street", "02/21/2021", "12:00pm", 10)
val movementWorkshop = createWorkshop("Movement Workshop", "Jane Doe", "456 Second Street", "03/15/2021", "10:00am", 15)

//Add workshops to list
workshopList.add(somaticTherapyWorkshop)
workshopList.add(movementWorkshop)

//Create workshops from list
createWorkshopsFromList(workshopList)

//Register students to workshops
val registered1 = somaticTherapyWorkshop.registerToWorkshop("Bob Smith", "bob@smith.com")
val registered2 = movementWorkshop.registerToWorkshop("Jill Jones", "jill@jones.com")

//Check if students have been registered
val student1Registered = checkIfRegistered(somaticTherapyWorkshop, "Bob Smith")
val student2Registered = checkIfRegistered(movementWorkshop, "Jill Jones")

//Update workshop capacity
updateWorkshopCapacity(somaticTherapyWorkshop, 12)
updateWorkshopCapacity(movementWorkshop, 20)

//List all workshops
listWorkshops(workshopList)

//Display details of a workshop
displayWorkshopDetails(somaticTherapyWorkshop)

//Cancel a workshop
cancelWorkshop(movementWorkshop)