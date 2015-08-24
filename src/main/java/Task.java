import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Task{

  private String description;
  private int id;


  public Task(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }


  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object otherTask) {
    if(!(otherTask instanceof Task)) {
      return false;
    } else {
      Task newTask = (Task) otherTask;
      return this.getDescription().equals(newTask.getDescription());
    }
  }

  public static List<Task> all() {
    String sql = "SELECT id, description FROM tasks";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Task.class);
    }
  }

  // public static Task find(int id) {
  //   try {
  //     return instances.get(id-1);
  //   } catch (IndexOutOfBoundsException e) {
  //     return null;
  //   }
  // }
  
  // public void save() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "INSERT INTO Tasks (description) VALUES (:description)";
  //     con.createQuery(sql);
  //       addParameter("description", description);
  //       executeUpdate();
  //   }
  // }

  // public static void clear() {
  //   instances.clear();
  // }
}
