package Objects;

public class Studio {
  String studio_id;
  String studio_name;
  String studio_addr;
  int hourly_cost;

  public void set_studio_id(String studio_id) {
    this.studio_id = studio_id;
  }

  public void set_studio_name(String studio_name) {
    this.studio_name = studio_name;
  }

  public void set_studio_addr(String studio_addr) {
    this.studio_addr = studio_addr;
  }

  public void set_hourly_cost(int hourly_cost) {
    this.hourly_cost = hourly_cost;
  }
  
  public String get_studio_id(){
    return studio_id;
    }
  public String get_studio_name(){
    return studio_name;
    }
  public String get_studio_addr(){
    return studio_addr;
    } 
  public int get_hourly_cost(){
    return hourly_cost;
    }
  
}
