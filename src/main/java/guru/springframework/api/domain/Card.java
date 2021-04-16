package guru.springframework.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card  implements Serializable {
    private String type;
    private String number;
    private ExpirationDate expirationDate;
    private String iban;
    private String swift;
}
