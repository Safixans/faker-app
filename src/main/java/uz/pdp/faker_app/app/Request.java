package uz.pdp.faker_app.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor


public class Request {
   private String filename;
   private Integer count;
   private String type;
   private List<Pairs> pairs;

   public Request(String filename, Integer count, String type) {
      this.filename = filename;
      this.count = count;
      this.type = type;
   }
}
