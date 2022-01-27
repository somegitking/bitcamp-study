package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.io.FileWriter2;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;


@RestController
public class TodoController {

  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception{

    System.out.println("TodoController() 호출됨");
    com.eomcs.io.FileReader2 in = new com.eomcs.io.FileReader2("todos.csv");

    String line;
    while((line = in.readLine()).length() != 0) {
      todoList.add(Todo.valueOf(line));
    }

    in.close();
  }

  @RequestMapping("/todo/list")
  public Object list() {
    return todoList.toArray();
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    todoList.add(todo);

    return todoList.toArray();
  }

  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if(index < 0 || index >= todoList.size()) {
      return 0;
    }
    Todo old = (Todo) todoList.get(index);
    todo.setDone(old.isDone());

    return todoList.set(index, todo) == null ? 0:1;

  }


  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if(index < 0 || index >= todoList.size()) {
      return 0;
    }

    ((Todo) todoList.get(index)).setDone(done);
    return 1;
  }

  @RequestMapping("todo/delete")
  public Object delete(int index) {
    if(index < 0 || index >= todoList.size()) {
      return 0;
    }


    return 1;
  }

  @RequestMapping("/todo/save")
  public Object save() throws Exception{
    FileWriter2 out = new FileWriter2("todos.csv");

    Object[] arr = todoList.toArray();
    for(Object obj : arr) {
      Todo todo = (Todo) obj;
      out.println(todo.toCsvString());

    }



    out.close();
    return arr.length;

  }

}
