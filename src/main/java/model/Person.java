package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Evegeny on 21/03/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private String name;

}






