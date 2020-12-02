package Objects;

public class Buyer {
  String buyer_id;
  String buyer_name;
  String buyer_addr;
  

  public void set_m_id(String buyer_id) {
    this.buyer_id = buyer_id;
  }

  public void set_m_name(String buyer_name) {
    this.buyer_name = buyer_name;
  }

  public void set_m_addr(String buyer_addr) {
    this.buyer_addr = buyer_addr;
  }
  
  public String get_buyer_id(){
    return buyer_id;
    }
  public String get_buyer_name(){
    return buyer_name;
    }
  public String get_buyer_addr(){
    return buyer_addr;
    }
  
}
