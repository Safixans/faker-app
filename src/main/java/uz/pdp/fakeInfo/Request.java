package uz.pdp.fakeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;
@AllArgsConstructor
@Data
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
