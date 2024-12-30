class Task(
    var description: String,
    var deadline: String,
    var priority: String,
    var name: String = "New Task",

) {
    var status: Boolean = false
    fun changeName(name: String){
        this.name = name
    }

    fun changeDescription(description: String){
        this.description = description
    }

    fun changeStatus(){
        status = !status
    }

    override fun toString(): String {
        return """
            $name
            Description: $description
            Deadline: $deadline
            Priority: $priority
            Status: $status
            
        """.trimIndent()
    }

}