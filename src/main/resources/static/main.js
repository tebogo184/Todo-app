const taskForm = document.getElementById("taskForm");
const todoList = document.getElementById("toDo-list");
const taskContainer = document.getElementById("taskContainer");
const submitButton = document.querySelector("#submit");

//Add task function
taskForm.addEventListener("submit", e => {
    e.preventDefault();
    const payload = new FormData(taskForm);

    //Post the recent added task from the html to springboot
    fetch("http://localhost:8080/saveTask", {
        method: "POST",
        body: payload,
    }).then(res => {
        if (!res.ok) {
            throw new Error("Unable to save the task");
        }
        return res.json;
    })
        .then(() => {
            displayTasks();//display all tasks including the recent task added
        })
        .catch(error => {
            console.log(error);
        })

});


displayTasks();//display all the tasks

//display task function
function displayTasks() {
    fetch("http://localhost:8080/AllTasks")//fetch all the tasks
        .then(response => {
            if (!response.ok) {
                throw new Error("Something went wrong with the request");
            }
            return response.json(); //convert the data into json
        })
        .then(data => {
            /*check if there are any tasks created or not
            if there are not any task created, create a header tag that will instruct the user to create a task.
            */
            todoList.innerHTML = " ";//clear the todo list first
            if (data.length == 0 || data == null) {

                const noTask = document.createElement("h3");
                noTask.innerHTML = "Add Task"
                todoList.append(noTask);
            } else {

                //create elements that will be used to display every tasks added
                data.forEach(task => {
                    const todoItem = document.createElement("div");
                    todoItem.classList.add("todo-item");

                    const content = document.createElement("div");

                    content.classList.add("todo-content");
                    content.innerHTML = `<input type="text" class="text" value="${task.taskName}" readonly>
                            <div class="class-delete">
                            <button class="delete">delete</button>
                            </div>`;


                    todoItem.appendChild(content);
                    todoList.appendChild(todoItem);


                });
            }
        })
        .catch(error => {
            console.error(error);
        });

}