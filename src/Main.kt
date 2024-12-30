fun main() {
    val all = Category(name = "All tasks")
    val categories : MutableList<Category> = mutableListOf()

    do{
        println(menu())
        var  x = readLine()?.toIntOrNull() ?: 0

        when(x){
            0 -> println("Exiting...")

            1 -> {
                println("Type the title")
                val name = readLine() ?: ""

                println("Type the description")
                val description = readLine() ?: ""

                println("Type the deadline")
                val deadline = readLine() ?: ""

                println("Type the priority")
                val priority = readLine() ?: ""

                val task : Task
                if(name == "") task = Task(description, deadline, priority)
                else task = Task(description, deadline, priority, name)

                all.addTask(task)
            }

            2 -> println(all)

            3 -> {
                println("Type the task Name")
                val name = readLine() ?: ""

                val taskTemp = all.findTask(name)
                val task : Task
                if(taskTemp != null){
                    task = taskTemp
                    task.changeStatus()
                }
                else println("Wrong name or this task does not exist")


            }

            4 -> {
                do{
                    println(menuCategories())
                    var y =  readLine()?.toIntOrNull() ?: 0

                    when(y){
                        0 -> println("Going to menu...")

                        1 -> {
                            val category : Category
                            println("Type the category name")
                            val name = readLine() ?: ""

                            if(name == "") category = Category()
                            else category = Category(name)

                            categories.add(category)
                        }

                        2 -> {
                            println("Type task name")
                            val taskName = readLine() ?:""
                            val taskTemp = all.findTask(taskName)
                            val task : Task
                            if(taskTemp == null) {
                                println("Task nor found")
                                continue
                            }
                            else{
                                task = taskTemp
                                println("Type the category name")
                                val categoryName = readLine() ?: ""
                                for(category in categories){
                                    if(category.name == categoryName){
                                        category.addTask(task)
                                        break
                                    }
                                }
                            }
                        }

                        3 -> for(category in categories){
                            println(category)
                        }

                    }

                }while (y!= 0)

            }



        }


    }while (x != 0)

}

fun menu(): String{
    return "\u001B[34mTaskMaster 3000\n" +"\u001B[0m" +"""
        
        0. Exit
        1. Add a Task  
        2. View Tasks  
        3. Mark Task as Completed  
        4. Manage Categories  
        5. View Statistics  
    """.trimIndent()
}

fun menuCategories(): String{

    return """
        Categories menu
        
        0. Exit
        1. Add a category
        2. Add a task on a category
        3. Show all categories
    """.trimIndent()
}