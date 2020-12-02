package Objects;

import java.sql.Date;

public class Staff {
  String staff_id;
  String staff_name;
  int salary;
  Date join_date;
  

  public void set_staff_id(String staff_id) {
    this.staff_id = staff_id;
  }

  public void set_staff_name(String staff_name) {
    this.staff_name = staff_name;
  }

  public void set_salary(int salary) {
    this.salary = salary;
  }

  public void set_join_date(Date join_date) {
    this.join_date = join_date;
  }
  
  public String get_staff_id(){
    return staff_id;
    }
  public String get_staff_name(){
    return staff_name;
    }
  public int get_salary(){
    return salary;
    }
  public Date get_join_date(){
    return join_date;
    }
  
}
