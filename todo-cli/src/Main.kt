import models.Task
fun main(){
    val taskList = mutableListOf<Task>()
    var taskId = 1

    while (true){
        println(
            """
            ========= Task Ninja =========
            1. Add Task
            2. Show Tasks
            3. Mark Task as Done
            4. Exit
            Choose an option:
            """.trimIndent()
        )

        when( readlnOrNull()?.trim()){
            "1" -> {
                println("Enter task title:")
                val title = readlnOrNull()?.trim().orEmpty()

                println("Enter task description:")
                val desc = readlnOrNull()?.trim().orEmpty()

                val task = Task(taskId++ , title,desc)
                taskList.add(task)
                println("✅ Task added!")
            }

            "2" -> {
                if (taskList.isEmpty()) {
                    println("⚠️ No tasks yet.")
                } else {
                    println("📋 Your Tasks:")
                    taskList.forEach { task ->
                        val status = if (task.isDone) "[✅]" else "[❌]"
                        println("$status ${task.id}: ${task.title} - ${task.desc}")
                    }
                }
            }

            "3" -> {
                println("Enter task ID to mark as done:")
                val id = readlnOrNull()?.toIntOrNull()
                val task = taskList.find { it.id == id }

                if (task != null) {
                    task.isDone = true
                    println("✔️ Marked as done: ${task.title}")
                } else {
                    println("❌ Task not found.")
                }
            }

            "4" -> {
                println("👋 Exiting... Stay sharp, Ninja.")
                break
            }

            else -> {
                println("🚫 Invalid option. Try again.")
            }
        }
    }
}