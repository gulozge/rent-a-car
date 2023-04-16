package kodlama.io.rentacar.adapters;

import kodlama.io.rentacar.business.abstracts.PosService;
import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class FakePosServiceAdapter implements PosService {
    @Override
    public void pay() {
        boolean isPaymentSuccesssful = new Random().nextBoolean();
        if (!isPaymentSuccesssful) throw new BusinessException(Messages.Payment.Failed);
    }
}
