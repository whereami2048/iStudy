package iStudy.managementservice.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class Calendar {

    private String title;
    private String startTime;
    private String endTime;

}
