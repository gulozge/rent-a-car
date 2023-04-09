package kodlama.io.rentacar.business.dto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    @NotBlank(message = "KART NUMARASI BOŞ BIRAKILAMAZ")
    @Length(min = 16,max = 16,message = "kart numarası 16 haneli olmalı")
    private String cardNumber;

    @NotBlank
    @Length(min = 5)
    private String cardHolder;

    @NotNull
    @Min(value = 2023)
    private int cardExpirationYear;

    @NotNull
    @Max(value = 12)
    @Min(1)
    private int cardExpirationMonth;

    @NotBlank
    @Length(min = 3,max = 3)
    private String cardCvv;
}
