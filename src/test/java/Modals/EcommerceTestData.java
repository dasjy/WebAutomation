package Modals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties
@NoArgsConstructor
@AllArgsConstructor
public class EcommerceTestData {
    private String bannerMessage;
    private String infoMessage;
}
