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

    fun findTask(name: String): Task?{
        for(task in tasks){
            if(name == task.name){
                return task
            }
        }
        return null
    }

    override fun toString(): String {
        var str = "$name\n\n"

        for(task in tasks){
            str += task.toString()
        }

        return str
    }

}