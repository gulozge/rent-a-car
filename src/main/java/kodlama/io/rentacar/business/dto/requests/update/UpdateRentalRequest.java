package kodlama.io.rentacar.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRentalRequest {
    private int carId;
    private double dailyPrice;
    private int rentedForDays;
    private LocalDate startDate;
}
