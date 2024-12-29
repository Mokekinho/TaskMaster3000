class Category(
    var name: String = "New Category"
) {
    val tasks : MutableList<Task> = mutableListOf()

    fun changename(name : String){
        this.name = name
    }

    fun addTask(task: Task){
        tasks.add(task)
    }

    fun removeTask(taskName: String) : Boolean{
        for(task in tasks){
            if(taskName == task.name){
                tasks.remove(task)
                return true
            }
        }
        return false
    }

}