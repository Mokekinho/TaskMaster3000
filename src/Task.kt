class Task(
    var name: String = "New Task",
    var description: String,
    var deadline: String,
    var priority: String,
    var status: Boolean = false
) {

    fun changeName(name: String){
        this.name = name
    }

    fun changeDescription(description: String){
        this.description = description
    }

    fun changeStatus(){
        status = !status
    }

}