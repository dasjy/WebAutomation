package UIAutomation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties
public class TableModals {
    private String Year;
    private String Principal;
    private String Interest;
    private String totalPayment;
    private String Balance;
    private String loanToPaidDate;

}
